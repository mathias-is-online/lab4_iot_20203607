package com.example.lab4_20203607.entity;

import java.io.Serializable;
import java.util.Map;

public class Clima implements Serializable {


    private String name;
    private Map<String, String> localNames;
    private double lat;
    private double lon;
    private String country;
    private String state;


    public Clima(String name, Map<String, String> localNames, double lat, double lon, String country, String state) {
        this.name = name;
        this.localNames = localNames;
        this.lat = lat;
        this.lon = lon;
        this.country = country;
        this.state = state;
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Map<String, String> getLocalNames() {
        return localNames;
    }

    public void setLocalNames(Map<String, String> localNames) {
        this.localNames = localNames;
    }

    public double getLat() {
        return lat;
    }

    public void setLat(double lat) {
        this.lat = lat;
    }

    public double getLon() {
        return lon;
    }

    public void setLon(double lon) {
        this.lon = lon;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }
}
