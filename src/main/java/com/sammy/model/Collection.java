package com.sammy.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import lombok.Data;

import java.io.Serializable;

/**
 * NAME
 *
 * @author Luke Harwood
 * 23 June 2016
 */

//@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
	"Person",
	"Payment",
	"CustInfo",
	"HouseInfo"
})
@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class Collection implements Serializable {

	@JsonProperty(value = "person", required = true)
	protected Person person;

	@JsonProperty(value = "payment", required = true)
	protected Payment payment;

	@JsonProperty("CustInfo")
	private CustInfo custInfo;

	@JsonProperty("HouseInfo")
	private HouseInfo houseInfo;
}