package com.example.hotelapp.model;

import java.io.Serializable;
import java.util.UUID;

public class Hotel implements Serializable {

    private String id;
    private String name;
    private String desc;
    private double[] coords;
    private String imgSrc;

    private int costPerPerson;

    private String place;
    private String phoneNumber;

    private int minimalCostPerPerson;
    

    public Hotel(String name, String desc, double[] coords, String imgSrc) {
        this.id = UUID.randomUUID().toString();
        this.name = name;
        this.desc = desc;
        this.coords = coords;
        this.imgSrc = imgSrc;
    }

    public Hotel(String name, String desc, double[] coords, String imgSrc, int costPerPerson) {
        this.id = id;
        this.name = name;
        this.desc = desc;
        this.coords = coords;
        this.imgSrc = imgSrc;
        this.costPerPerson = costPerPerson;
    }

    public Hotel(String name, String desc, double[] coords, String imgSrc, int costPerPerson, String place) {
        this.name = name;
        this.desc = desc;
        this.coords = coords;
        this.imgSrc = imgSrc;
        this.costPerPerson = costPerPerson;
        this.place = place;
    }

    public Hotel(String name, String desc, double[] coords, String imgSrc, int costPerPerson, String place, String phoneNumber) {
        this.name = name;
        this.desc = desc;
        this.coords = coords;
        this.imgSrc = imgSrc;
        this.costPerPerson = costPerPerson;
        this.place = place;
        this.phoneNumber = phoneNumber;
    }

    public String getName() {
        return name;
    }

    public String getDesc() {
        return desc;
    }

    public double[] getCoords() {
        return coords;
    }

    public String getId() {
        return id;
    }

    public String getImgSrc() {
        return imgSrc;
    }

    public int getCostPerPerson() {
        return costPerPerson;
    }

    public String getPlace() {
        return place;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public int getMinimalCostPerPerson() {
        return minimalCostPerPerson;
    }
}
