package com.rocksoft.LogStr.db.models;

/**
 * Created by Esenin on 26.09.2017.
 */
public class Car extends AbstractEntity {


    private String carModel;
    private String number;

    public String getCarModel() {
        return carModel;
    }

    public void setCarModel(String carModel) {
        this.carModel = carModel;
    }

    public String getNumber(){
        return number;
    }

    public void setNumber(String number){
        this.number = number;
    }

}
