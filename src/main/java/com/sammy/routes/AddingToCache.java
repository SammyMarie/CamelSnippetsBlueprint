package com.sammy.routes;

import com.sammy.model.Collection;
import com.sammy.processor.FirstProcessor;
import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.component.infinispan.InfinispanConstants;
import org.apache.camel.component.infinispan.InfinispanOperation;
import org.apache.camel.component.jackson.JacksonDataFormat;
import org.apache.camel.model.dataformat.JsonLibrary;
import org.apache.camel.spi.DataFormat;

public class AddingToCache extends RouteBuilder {

    private DataFormat json = new JacksonDataFormat(Collection.class);

   public void configure() {
       from("file:src/data?noop=true&include=.*.json")
            .log("START")
               .unmarshal(json)
            .setHeader(InfinispanConstants.OPERATION, constant(InfinispanOperation.PUTIFABSENT))
            .setHeader(InfinispanConstants.KEY, simple("${body.custInfo.firstName}"))
               .log("Got customer data for ${body.custInfo.firstName}")
            .process(new FirstProcessor())
               .marshal().json(JsonLibrary.Jackson)
            .log("ending ..." )
            .to("infinispan://localhost")
            .to("activemq:output");
   }
}