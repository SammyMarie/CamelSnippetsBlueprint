package com.sammy.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.xml.bind.annotation.XmlRegistry;
import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "CustInfo"
})
@Data
@XmlRegistry
@NoArgsConstructor
public class ObjectFactory implements Serializable {

    @JsonProperty("CustInfo")
    public CustInfo custInfo;

    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<>();

    public HouseInfoXml createHouseInfo() {
        return new HouseInfoXml();
    }

    public CustInfoXml createCustInfo() {
        return new CustInfoXml();
    }
}