package com.sammy.model;

import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import lombok.Data;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "-infotype",
    "nationalID",
    "address",
    "bedroom",
    "bathroom",
    "landSize",
    "appraisedValue"
})
@Data
public class HouseInfo implements Serializable {

    @JsonProperty("-infotype")
    protected String infotype;

    @JsonProperty(value = "nationalID", required = true)
    protected String nationalID;

    @JsonProperty(value = "address", required = true)
    protected String address;

    @JsonProperty("bedroom")
    public int bedroom;

    @JsonProperty("bathroom")
    public int bathroom;

    @JsonProperty("landSize")
    public int landSize;

    @JsonProperty("appraisedValue")
    public int appraisedValue;

    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<>();

    @JsonAnyGetter
    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    @JsonAnySetter
    public void setAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
    }
}

