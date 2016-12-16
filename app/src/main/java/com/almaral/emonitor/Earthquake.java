package com.almaral.emonitor;

public class Earthquake {
    private String magnitude;
    private String place;

    public Earthquake(String magnitude, String place) {
        this.magnitude = magnitude;
        this.place = place;
    }

    public String getMagnitude() {
        return magnitude;
    }

    public String getPlace() {
        return place;
    }
}
