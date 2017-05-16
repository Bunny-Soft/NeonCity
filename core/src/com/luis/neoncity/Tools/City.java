package com.luis.neoncity.Tools;

import com.luis.neoncity.Buildings.Building;

import java.util.ArrayList;

/**
 * Created by Luis on 5/16/2017.
 */

public class City {
    private String cityName;
    private Integer funds;
    private Integer population;


    ArrayList<Building> buildings;

    public City(String cityName){
        this.cityName = cityName;
        this.funds = 200000;
        this.population = 0;
        buildings = new ArrayList<Building>();
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

    public ArrayList<Building> getBuildings() {
        return buildings;
    }

    public void setBuildings(ArrayList<Building> buildings) {
        this.buildings = buildings;
    }
}
