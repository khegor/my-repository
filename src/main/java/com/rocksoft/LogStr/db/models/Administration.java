package com.rocksoft.LogStr.db.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonSetter;
import com.rocksoft.LogStr.db.main.all.Main;
import org.apache.log4j.Logger;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by Esenin on 26.08.2017.
 */

@XmlRootElement(name = "admin")
@JsonIgnoreProperties(ignoreUnknown = true)

public abstract class Administration extends AbstractEntity{

    private static final Logger LOGGER = Logger.getLogger(Main.class);
    @JsonProperty
    private String name;
    @JsonProperty
    private String surname;
    @JsonProperty
    private String establishedPost;
    @JsonProperty
    private Address address;

    @XmlElement(type=Date.class)
    private Date dateOfBirth;

    public String getName() {
        return name;
    }
    @XmlElement(name = "name")
    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }
    @XmlElement(name = "surname")
    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getEstablishedPost() {
        return establishedPost;
    }
    @XmlElement(name = "establishedPost")
    public void setEstablishedPost(String establishedPost) {
        this.establishedPost = establishedPost;
    }

    public Address getAddress() {
        return address;
    }
    @XmlElement(name = "address")
    public void setAddress(Address address) {
        this.address = address;
    }
    @Override
    public String toString(){
        return getName() + " " + getSurname() + " " + getEstablishedPost() + " " + getAddress() + " " + dateOfBirth.toString();
    }

    public Date getDateOfBirth() {
        return dateOfBirth;
    }

    @JsonSetter(value = "dateOfBirth")
    @XmlElement(name = "dateOfBirth")
    public void setDateOfBirth(String dateOfBirth) {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
        try {
            this.dateOfBirth = simpleDateFormat.parse(dateOfBirth);
        } catch (ParseException e) {
            LOGGER.error(e);
        }
    }
}
