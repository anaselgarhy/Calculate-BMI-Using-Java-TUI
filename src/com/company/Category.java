package com.company;

public class Category {
    String name;
    int numOfPersons;
    String bestCityInCategory;

    public Category(String name) {
        this.name = name;
    }

    public int getNumOfPersons() {
        return numOfPersons;
    }

    public void setNumOfPersons(int numOfPersons) {
        this.numOfPersons = numOfPersons;
    }

    public String getName() {
        return name;
    }

    public String getBestCityInCategory() {
        return bestCityInCategory;
    }

    public void setBestCityInCategory(String bestCityInCategory) {
        this.bestCityInCategory = bestCityInCategory;
    }

    public int calcRatio(int totalNumberOfPersons){
        return (numOfPersons/totalNumberOfPersons)*100;
    }
}
