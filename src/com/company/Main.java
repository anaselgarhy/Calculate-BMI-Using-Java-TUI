package com.company;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        Category category[] = new Category[4];
        category[0] = new Category("Underweight");
        category[1] = new Category("Normal");
        category[2] = new Category("Overweight");
        category[3] = new Category("Obese");

        String tempNameCity;
        int tempNumOfPersons=0,totalNumOfPersons=0, numOfCities=0, p;
        int underweightPersons=0, normalPersons=0, overweightPersons=0, obesePersons=0;
        float tempHeight=0.0f, tempMass=0.0f;
        int tempNum;
        int numOfBestCitiesInArray=0, numOfBadCitiesInArray=0, numOfLowCitiesInArray=0;

        // Welcome
        System.out.print("\t _____________\n");
        System.out.print("\t|Calculate BMI|\n");
        System.out.print("\t -------------\n");


        while(numOfCities <6){
            System.out.print("Please enter number of cities(minimum 6 cities): ");
            numOfCities = input.nextInt();
        }

        Cities cities[] = new Cities[numOfCities];

        //Input name of city
        for(int i=0; i<numOfCities; i++){
            System.out.printf("City [%d]:\n", i+1);
            System.out.printf("\t Name of city: ");
            tempNameCity = input.next();
            while(tempNumOfPersons < 10){
                System.out.printf("\t Number of persons (minimum 10 persons):");
                tempNumOfPersons = input.nextInt();
            }
            cities[i] = new Cities(tempNameCity, tempNumOfPersons);
            totalNumOfPersons += tempNumOfPersons;
            tempNumOfPersons=0;
        }

        //
        Persons persons[] = new Persons[totalNumOfPersons];
        p=0;

        //read persons
        for(int i=0;i<numOfCities; i++){
            System.out.println(cities[i].getName() + ":");
            for(int j=0; j< cities[i].getNumberOfPersons(); j++){
                System.out.printf("\tPerson [%d]:\n", j+1);
                while(tempMass <= 0){
                    System.out.print("\t\tMass: ");
                    tempMass = input.nextFloat();
                }
                while(tempHeight <= 0){
                    System.out.print("\t\tHeight: ");
                    tempHeight = input.nextFloat();
                }

                persons[p++] = new Persons(cities[i].getName(), tempMass, tempHeight);
                tempMass = tempHeight = 0.0f;
            }
        }

        //
        for(int i=0; i<numOfCities; i++)
            for (int j=0; j<cities[i].getNumberOfPersons(); j++){
                float bim =  persons[j].bimCalc();
                if(bim < 18.5){
                    cities[i].setUnderweightPersons(++underweightPersons);
                    category[0].setNumOfPersons(underweightPersons);
                }
                else if(bim > 18.5 && bim < 25.0){
                    cities[i].setNormalPersons(++normalPersons);
                    category[1].setNumOfPersons(normalPersons);
                }
                else if(bim == 25.0 && bim < 30){
                    cities[i].setOverweightPersons(++overweightPersons);
                    category[2].setNumOfPersons(overweightPersons);
                }
                else{
                    cities[i].setObesePersons(++obesePersons);
                    category[3].setNumOfPersons(obesePersons);
                }

            }
        //
        tempNum=0;
        for(int i = 0; i<numOfCities; i++)
            if(cities[i].getUnderweightPersons() > tempNum){
                numOfLowCitiesInArray = i;
                category[0].setBestCityInCategory(cities[i].getName());
            }
        tempNum=0;
        for(int i = 0; i<numOfCities; i++)
            if(cities[i].getNormalPersons() > tempNum){
                numOfBestCitiesInArray = i;
                category[1].setBestCityInCategory(cities[i].getName());
            }
        tempNum=0;
        for(int i = 0; i<numOfCities; i++)
            if(cities[i].getOverweightPersons() > tempNum){
                numOfBadCitiesInArray = i;
                category[2].setBestCityInCategory(cities[i].getName());
            }
        tempNum=0;
        for(int i = 0; i<numOfCities; i++)
            if(cities[i].getObesePersons() > tempNum){
                numOfBadCitiesInArray = i;
                category[3].setBestCityInCategory(cities[i].getName());
            }






        //  summary report
        System.out.println("\nSummary Report:");
        System.out.printf(" Number of cities: \t%5d\n", numOfCities);
        System.out.printf(" Total number of persons: \t%5d\n", totalNumOfPersons);
        System.out.println("----------------------------------------------");
        System.out.printf(" name of the best city which has the maximum percent of persons in normal weight: %s\n", category[1].getBestCityInCategory());
        System.out.printf(" BMI category \'Normal\' these people’s percent ratio %5d%%\n", (cities[numOfBestCitiesInArray].getNormalPersons()/totalNumOfPersons)*100);
        System.out.printf(" the worst city which has the maximum percent of persons in obese BMI: %s\n", category[3].getBestCityInCategory());
        System.out.printf(" category \'Obese\' and these people’s percent ratio: %5d%%\n", (cities[numOfBadCitiesInArray].getObesePersons()/totalNumOfPersons)*100);
        System.out.printf(" city which has the minimum percent of persons in underweight BMI: %s\n", category[0].getBestCityInCategory());
        System.out.printf(" category \'Underweight\' and these people’s percent ratio: %5d%%\n", (cities[numOfLowCitiesInArray].getUnderweightPersons()/totalNumOfPersons)*100);
        System.out.println("----------------------------------------------\n");

        System.out.println("Category BIM\t\tNumber of persons\t\tRatio");
        System.out.println("----------------------------------------------------------------");
        for(int i=0; i<4; i++)
            System.out.printf("%-10s\t\t\t\t%5d\t\t\t%5d\n", category[i].getName(),category[i].getNumOfPersons(),category[i].calcRatio(totalNumOfPersons));
    }
}
