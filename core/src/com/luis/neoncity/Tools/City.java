package com.luis.neoncity.Tools;

import com.luis.neoncity.Buildings.ResidentialBuilding;

import java.util.ArrayList;

/**
 * Created by Luis on 5/16/2017  and Changed by Zach on 5/16/17.
 */

public class City {
    private String cityName;
    private Integer funds;
    private Integer population;
    private Integer pollution;
    private Double happiness;

    public ArrayList<ResidentialBuilding> buildings;

    public City(String cityName){
        this.cityName = cityName;

        this.funds = 2000000;
        this.population = 5;
        pollution = 0;
        happiness = 100.00;
        buildings = new ArrayList<ResidentialBuilding>();
    }
    public String getCityName() {
        return cityName;
    }

    public void setCityName(String cityName) {
        this.cityName = cityName;
    }

    public Integer getFunds() {
        return funds;
    }

    public void setFunds(Integer funds) {
        this.funds = funds;
    }

    public Integer getPopulation() {
        return population;
    }

    public void setPopulation(Integer population) {
        this.population = population;
    }

    public Integer getPollution()
    {
        return pollution;
    }

    public void setPollution(Integer pollution)
    {
        this.pollution = pollution;
    }

    public Double getHappiness()
    {
        return happiness/100;
    }

    public void setHappiness(Double happiness)
    {
        this.happiness = happiness;
    }

    public ArrayList<ResidentialBuilding> getBuildings() {
        return buildings;
    }

    public void setBuildings(ArrayList<ResidentialBuilding> buildings) {
        this.buildings = buildings;
    }
    //buildings are initialized with Building(Vector2 location, this, Boolean IfBuildingIsInUse);
    //buildings are the superclass to all other non-road structures.
}
