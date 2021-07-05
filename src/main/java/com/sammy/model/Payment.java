package com.sammy.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

/**
 * NAME
 *
 * @author Luke Harwood
 * 23 June 2016
 */
@Data
public class Payment {
	@JsonProperty(value = "name", required = true)
	protected String name;
}