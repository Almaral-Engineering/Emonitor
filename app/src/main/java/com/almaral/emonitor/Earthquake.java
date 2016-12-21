package com.almaral.emonitor;

public class Earthquake {
    private Double magnitude;
    private String place;

    public Earthquake(Double magnitude, String place) {
        this.magnitude = magnitude;
        this.place = place;
    }

    public Double getMagnitude() {
        return magnitude;
    }

    public String getPlace() {
        return place;
    }
}
