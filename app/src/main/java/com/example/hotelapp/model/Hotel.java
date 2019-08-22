package com.example.hotelapp.model;

public class Hotel {

    private String name;
    private String desc;
    private double[] coords;

    public Hotel(String name, String desc, double[] coords) {
        this.name = name;
        this.desc = desc;
        this.coords = coords;
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
}
