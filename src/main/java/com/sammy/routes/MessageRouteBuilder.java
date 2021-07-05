package com.sammy.routes;

import com.sammy.model.RecipientListBean;
import com.sammy.processor.MessageProcessor;
import org.apache.camel.builder.RouteBuilder;

/**
 * Created by samif on 10/07/2016.
 */
public class MessageRouteBuilder extends RouteBuilder {

    @Override
    public void configure() throws Exception {
        from("jms:jsonOrders")
                .choice()
                    .when()
                        .jsonpath("$..CustInfo[?(@.infotype == 'LoanCustomer')]")
                        .process(new MessageProcessor())
                    .to("jms:queue:incomingApplication", "jms:queue:customerDetails")

                    .when()
                        .jsonpath("$..HouseInfo[?(@.infotype == 'LoanHouse')]")
                        .process(new MessageProcessor())
                    .to("jms:housing")
                .end();

        from("jms:jsonOrders").bean(RecipientListBean.class);
    }
}