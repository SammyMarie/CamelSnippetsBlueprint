package com.sammy.processor;

import org.apache.camel.Exchange;
import org.apache.camel.Processor;

/**
 * Created by samif on 24/07/2016.
 */
public class OrderToCsvProcessor implements Processor {

    @Override
    public void process(Exchange exchange) throws Exception {
        String customFormat = exchange.getIn().getBody(String.class);

        String Id = customFormat.substring(0, 9);
        String customerId = customFormat.substring(10, 19);
        String date = customFormat.substring(20, 29);
        String items = customFormat.substring(30);
        String [] itemIds = items.split("@");

        StringBuilder csv = new StringBuilder();
        csv.append(Id.trim());
        csv.append(",").append(date.trim());
        csv.append(",").append(customerId.trim());

        for (String item : itemIds){
            csv.append(",").append(item.trim());
        }
        exchange.getIn().setBody(csv.toString());
    }
}