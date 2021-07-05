package com.sammy.routes;

import com.sammy.model.Collection;
import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.component.infinispan.InfinispanConstants;
import org.apache.camel.component.infinispan.InfinispanOperation;
import org.apache.camel.component.jackson.JacksonDataFormat;
import org.apache.camel.model.dataformat.JsonLibrary;

public class InfinispanRoute extends RouteBuilder {

    private JacksonDataFormat json = new JacksonDataFormat(Collection.class);

    @Override
    public void configure() throws Exception {
        from("file:src/data?noop=true&include=.*.json")
                .choice()
                .when()
                .jsonpath("$..CustInfo[?(@.firstName == 'Sammy')]").unmarshal(json)
                .log("Got customer data for ${body.custInfo.firstName}")
                .setHeader(InfinispanConstants.OPERATION, constant(InfinispanOperation.PUTIFABSENT))
                .setHeader(InfinispanConstants.KEY, simple("${body.custInfo.firstName}"))
                .marshal().json(JsonLibrary.Jackson)
                .to("infinispan://localhost")
                .to("activemq:queue:incomingApplication", "activemq:queue:customerDetails");

        from("direct:start")
                .setHeader(InfinispanConstants.OPERATION, constant(InfinispanOperation.GET))
                .setHeader(InfinispanConstants.OPERATION, constant("${body.custInfo.firstName}"))
                .to("infinispan://localhost?command=SIZE")
                //.setBody(simple("${header.CamelInfinispanOperationResult}"))
                .to("activemq:queue:output");
    }
}