package com.sammy.processor;

import com.sammy.model.Collection;
import org.apache.camel.Exchange;
import org.apache.camel.Processor;

public class FirstProcessor implements Processor {

    public void process(Exchange exchange) throws Exception {
        Collection collection = (Collection) exchange.getIn().getBody();

        if (collection.getCustInfo().getFirstName() != null){
            System.out.println(collection.getCustInfo());
            exchange.getIn().setBody(collection.getCustInfo());
        }
    }
}