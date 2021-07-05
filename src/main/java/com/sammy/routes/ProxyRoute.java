package com.sammy.routes;

import com.sammy.model.Collection;
import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.component.jackson.JacksonDataFormat;
import org.apache.camel.model.dataformat.JsonLibrary;

/**
 * Created by samif on 17/11/2016.
 */
public class ProxyRoute extends RouteBuilder {

    private JacksonDataFormat json = new JacksonDataFormat(Collection.class);

    public void configure() throws Exception {
        from("file:src/data?noop=true&include=.*.json")
            .choice()
                .when()
                .jsonpath("$..CustInfo[?(@.firstName == 'Sammy')]").unmarshal(json)
                .log("Got customer data for ${body.custInfo.firstName}")
                .marshal().json(JsonLibrary.Jackson)
                .to("activemq:queue:incomingApplication", "activemq:queue:customerDetails");

        from("activemq:queue:incomingApplication")
                .to("activemq:queue:output");
    }
}