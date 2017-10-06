package com.rocksoft.LogStr.db.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.apache.log4j.Logger;
import org.codehaus.jackson.annotate.JsonSetter;

import javax.xml.bind.annotation.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

/**
 * Created by Esenin on 26.08.2017.
 */
@XmlRootElement(name = "worker")
@JsonIgnoreProperties(ignoreUnknown = true)
public abstract class Worker extends AbstractEntity {

    @JsonProperty
    private String name;
    @JsonProperty
    private String surname;
    @JsonProperty
    private String establishedPost;
    @JsonProperty
    private Address address;
    private List<Car> cars;
    private List<Orders> orders;


    private static final Logger LOGGER = Logger.getLogger(Worker.class);
    @XmlElement(type = Date.class)
    private Date dateOfBirth;

    public String getName() {
        return name;
    }

    @XmlElement(name = "name")
    @JsonSetter(value = "name")
    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    @XmlElement(name = "surname")
    @JsonSetter(value = "surname")
    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getEstablishedPost() {
        return establishedPost;
    }

    @XmlElement(name = "establishedPost")
    @JsonSetter(value = "establishedPost")
    public void setEstablishedPost(String establishedPost) {
        this.establishedPost = establishedPost;
    }

    public Address getAddress() {
        return address;
    }

    @XmlElement(name = "address")
    @JsonSetter(value = "address")
    public void setAddress(Address address) {
        this.address = address;
    }

    public List<Car> getCars() {

        return cars;
    }

    public void setCars(List<Car> cars) {
        this.cars = cars;
    }

    public void setOrders(List<Orders> orders) {
        this.orders = orders;
    }

    public void setDateOfBirth(Date dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    @Override
    public String toString() {
        String s = "";
        for (Car c : cars) {
            s = s + " " + getName() + " " + getSurname() + " " +
                    getEstablishedPost() + " " + getAddress() + " " +
                    dateOfBirth.toString() + " " + c.getCarModel() + " " + c.getNumber() + "\n";
        }
        return  s;
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
