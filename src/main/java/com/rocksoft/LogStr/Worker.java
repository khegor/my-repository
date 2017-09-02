package com.rocksoft.LogStr;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonRootName;
import org.apache.log4j.Logger;
import org.codehaus.jackson.annotate.JsonSetter;

import javax.xml.bind.annotation.*;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by Esenin on 26.08.2017.
 */
@XmlRootElement(name = "worker")
@JsonIgnoreProperties(ignoreUnknown = true)
public class Worker {

    @JsonProperty
    private String name;
    @JsonProperty
    private String surname;
    @JsonProperty
    private String establishedPost;
    @JsonProperty
    private Address address;

    private static final Logger LOGGER = Logger.getLogger(Worker.class);
    @XmlElement(type=Date.class)
    private Date dateOfBirth;

    public String getName() {
        return name;
    }
    @XmlElement (name = "name")
    @JsonSetter(value = "name")
    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }
    @XmlElement (name = "surname")
    @JsonSetter(value = "surname")
    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getEstablishedPost() {
        return establishedPost;
    }
    @XmlElement (name = "establishedPost")
    @JsonSetter (value = "establishedPost")
    public void setEstablishedPost(String establishedPost) {
        this.establishedPost = establishedPost;
    }

    public Address getAddress() {
        return address;
    }
    @XmlElement (name = "address")
    @JsonSetter(value = "address")
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
            LOGGER.info(e);
        }
    }
}
