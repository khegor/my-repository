package com.rocksoft.LogStr;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonRootName;
import com.fasterxml.jackson.annotation.JsonSetter;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * Created by Esenin on 26.08.2017.
 */
@XmlRootElement (name = "address")
@JsonRootName(value = "address")
public class Address {

    @JsonProperty
    private String country;
    @JsonProperty
    private String city;
    @JsonProperty
    private String street;
    @JsonProperty
    private String homeNumber;

    public String getCountry() {
        return country;
    }
@XmlElement(name = "country")
@JsonSetter (value = "country")
    public void setCountry(String country) {
        this.country = country;
    }

    public String getCity() {
        return city;
    }
@XmlElement (name = "city")
@JsonSetter (value = "city")
    public void setCity(String city) {
        this.city = city;
    }

    public String getStreet() {
        return street;
    }
@XmlElement (name = "street")
@JsonSetter (value = "street")
    public void setStreet(String street) {
        this.street = street;
    }

    public String getHomeNumber() {
        return homeNumber;
    }
@XmlElement (name = "homeNumber")
@JsonSetter (value = "homeNumber")
    public void setHomeNumber(String homeNumber) {
        this.homeNumber = homeNumber;
    }
    @Override
    public String toString(){
        return this.country + " " + this.city + " " + this.street + " " + this.homeNumber;
    }
}
