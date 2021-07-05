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
     "address",
     "bedroom",
     "bathroom",
     "landSize",
     "appraisedValue"
})
@XmlRootElement(name = "HouseInfo")
public class HouseInfoXml {
    @XmlElement(required = true)
    protected String nationalID;

    @XmlElement(required = true)
    protected String address;

    protected int bedroom;
    protected int bathroom;
    protected int landSize;
    protected int appraisedValue;

    @XmlAttribute(name = "infotype")
    protected String infotype;
}
