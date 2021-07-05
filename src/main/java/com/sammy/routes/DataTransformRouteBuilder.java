package com.sammy.routes;

import com.sammy.processor.OrderToCsvProcessor;
import org.apache.camel.builder.RouteBuilder;

/**
 * Created by samif on 24/07/2016.
 */
public class DataTransformRouteBuilder extends RouteBuilder {

    @Override
    public void configure() throws Exception {
        from("quartz://report?cron=0+0+6+*+*+?")
                .to("http://riders.com/orders/cmd=received&date=yesterday")
                .process(new OrderToCsvProcessor())
                .to("file://riders/orders?fileName=report-${header.Date}.csv");
    }
}