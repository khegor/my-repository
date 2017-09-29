package com.rocksoft.LogStr.db.models;

/**
 * Created by Esenin on 26.09.2017.
 */
public class Orders extends AbstractEntity{


    private String ownerOrganisationName;
    private String ownershipType;
    private String operationType;

    public String getOwnerOrganisationName() {
        return ownerOrganisationName;
    }

    public void setOwnerOrganisationName(String ownerOrganisationName) {
        this.ownerOrganisationName = ownerOrganisationName;
    }

    public String getOwnershipType(){
        return ownershipType;
    }

    public void setOwnerShipType(String ownershipType){
        this.ownershipType = ownershipType;
    }

    public String getOperationType(){
        return operationType;
    }

    public void setOperationType(String operationType){
        this.operationType = operationType;
    }
}
