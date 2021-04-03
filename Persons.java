package com.company;

public class Persons {
    private String cityName;
    private float mass, height;

    public Persons(String cityName, float mass, float height) {
        this.cityName = cityName;
        this.mass = mass;
        this.height = height;
    }

    public float bimCalc(){
        return(mass / (height*2));
    }
}
