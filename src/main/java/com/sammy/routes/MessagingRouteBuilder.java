package com.sammy.routes;

import com.sammy.processor.MessageProcessor;
import org.apache.camel.builder.RouteBuilder;

/**
 * Created by samif on 10/07/2016.
 */
public class MessagingRouteBuilder extends RouteBuilder {

    @Override
    public void configure() throws Exception {
        from("file:data/inbox?noop=true").process(new MessageProcessor())
                .to("jms:allOrders");

        from("jms:allOrders")
                .choice()
                .when(header("CamelFileName")
                    .endsWith(".xml"))
                .to("jms:xmlOrders")

                .when(header("CamelFileName")
                        .endsWith(".json"))
                .to("jms:jsonOrders")

                .otherwise()
                    .to("jms:badOrders").stop()
                .end()
                .to("jms:continuedProcessing");

        from("jms:badOrders").process(exchange ->  {
            System.out.println("Has some bad orders: " + exchange.getIn().getHeader("CamelFileName"));
        });

        from("jms:xmlOrders").process(exchange -> {
            System.out.println("Received XML orders: " + exchange.getIn().getHeader("CamelFileName"));
        });
    }
}