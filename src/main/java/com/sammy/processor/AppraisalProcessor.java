package com.sammy.processor;

import com.sammy.model.HouseInfo;

/**
 * Created by samif on 21/06/2016.
 */
public class AppraisalProcessor {

    public HouseInfo quote(HouseInfo houseInfo){

        int appraisedValue = 0;

        appraisedValue += houseInfo.getLandSize() * 1000;
        appraisedValue += houseInfo.getBathroom() * 2800;
        appraisedValue += houseInfo.getBedroom() * 2500;

        houseInfo.setAppraisedValue(appraisedValue);
        return houseInfo;
    }
}