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
    "firstName",
    "lastName",
    "age",
    "occupation"
})
@Data
public class CustInfo implements Serializable {

    @JsonProperty("-infotype")
    public String infotype;

    @JsonProperty(value = "nationalID", required = true)
    public String nationalID;

    @JsonProperty(value = "firstName", required = true)
    public String firstName;

    @JsonProperty(value = "lastName", required = true)
    public String lastName;

    @JsonProperty("age")
    public String age;

    @JsonProperty(value = "occupation", required = true)
    public String occupation;

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