package com.example.hotelapp.model;

import java.io.Serializable;
import java.util.UUID;

public class Hotel implements Serializable {

    private String id;
    private String name;
    private String desc;
    private double[] coords;
    //todo city/country
    private String imgSrc;

    private int costPerPerson;
    //todo + address

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
}
