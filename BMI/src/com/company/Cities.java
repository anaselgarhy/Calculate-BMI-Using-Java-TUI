package com.company;

public class Cities {
    private String name;
    private int numberOfPersons,underweightPersons, normalPersons, overweightPersons,obesePersons ;

    public Cities(String name, int numberOfPersons) {
        this.name = name;
        this.numberOfPersons = numberOfPersons;
    }

    public String getName() {
        return name;
    }

    public int getNumberOfPersons() {
        return numberOfPersons;
    }

    public int getUnderweightPersons() {
        return underweightPersons;
    }

    public void setUnderweightPersons(int underweightPersons) {
        this.underweightPersons = underweightPersons;
    }

    public int getNormalPersons() {
        return normalPersons;
    }

    public void setNormalPersons(int normalPersons) {
        this.normalPersons = normalPersons;
    }

    public int getOverweightPersons() {
        return overweightPersons;
    }

    public void setOverweightPersons(int overweightPersons) {
        this.overweightPersons = overweightPersons;
    }

    public int getObesePersons() {
        return obesePersons;
    }

    public void setObesePersons(int obesePersons) {
        this.obesePersons = obesePersons;
    }

}
