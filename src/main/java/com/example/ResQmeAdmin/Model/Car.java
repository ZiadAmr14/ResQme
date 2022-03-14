package com.example.ResQmeAdmin.Model;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Car {
    @JsonProperty
    private String carDriverLicence;
    private String carID;
    private String carLicence;
    private String carMaintenance;
    private String carModel;
    private String carStatus;
    private String carTransmission;
    private String carType;
    private String userID;

    public String getCarDriverLicence() {
        return carDriverLicence;
    }

    public void setCarDriverLicence(String carDriverLicence) {
        this.carDriverLicence = carDriverLicence;
    }

    public String getUserID() {
        return userID;
    }

    public void setUserID(String userID) {
        this.userID = userID;
    }

    public String getCarID() {
        return carID;
    }

    public void setCarID(String carID) {
        this.carID = carID;
    }

    public String getCarLicence() {
        return carLicence;
    }

    public void setCarLicence(String carLicence) {
        this.carLicence = carLicence;
    }

    public String getCarMaintenance() {
        return carMaintenance;
    }

    public void setCarMaintenance(String carMaintenance) {
        this.carMaintenance = carMaintenance;
    }

    public String getCarModel() {
        return carModel;
    }

    public void setCarModel(String carModel) {
        this.carModel = carModel;
    }

    public String getCarStatus() {
        return carStatus;
    }

    public void setCarStatus(String carStatus) {
        this.carStatus = carStatus;
    }

    public String getCarTransmission() {
        return carTransmission;
    }

    public void setCarTransmission(String carTransmission) {
        this.carTransmission = carTransmission;
    }

    public String getCarType() {
        return carType;
    }

    public void setCarType(String carType) {
        this.carType = carType;
    }


}
