package com.example.ResQmeAdmin.Model;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Car {
    @JsonProperty
    private String carDrivingLicence;
    private String carID;
    private String carLicence;
    private String carMaintenance;
    private String carModel;
    private String carStatus;
    private String carTransmission;
    private String carType;
    private String userId;

    public String getCarDrivingLicence() {
        return carDrivingLicence;
    }

    public void setCarDrivingLicence(String carDrivingLicence) {
        this.carDrivingLicence = carDrivingLicence;
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

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }
}
