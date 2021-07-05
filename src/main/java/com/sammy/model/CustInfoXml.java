package com.sammy.model;

import lombok.Data;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

@Data
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
    "nationalID",
    "firstName",
    "lastName",
    "age",
    "occupation"
})
@XmlRootElement(name = "CustInfo")
public class CustInfoXml {
    @XmlElement(required = true)
    protected String nationalID;

    @XmlElement(required = true)
    protected String firstName;

    @XmlElement(required = true)
    protected String lastName;

    protected int age;
    @XmlElement(required = true)
    protected String occupation;

    @XmlAttribute(name = "infotype")
    protected String infotype;
}
