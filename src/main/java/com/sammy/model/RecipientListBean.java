package com.sammy.model;

import org.apache.camel.RecipientList;
import org.apache.camel.jsonpath.JsonPath;

/**
 * Created by samif on 11/07/2016.
 */
public class RecipientListBean {

    @RecipientList
    public String[] route(@JsonPath("$..CustInfo[?(@.firstName)]") String customer){
        if(isGoldCustomer(customer)){
            return new String[]{"jms:accounting", "jms:fastTrack"};
        }else {
            return new String[]{"jms:accounting"};
        }
    }

    private boolean isGoldCustomer(String customer){
        return customer.equals("Sammy");
    }
}