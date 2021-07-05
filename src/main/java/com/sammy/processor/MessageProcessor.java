package com.sammy.processor;

import org.apache.camel.Exchange;
import org.apache.camel.Processor;

/**
 * Created by samif on 10/07/2016.
 */
public class MessageProcessor implements Processor {

    @Override
    public void process(Exchange exchange) throws Exception {
        System.out.println("We got to download: " + exchange.getIn().getHeader("CamelFileName"));
    }
}