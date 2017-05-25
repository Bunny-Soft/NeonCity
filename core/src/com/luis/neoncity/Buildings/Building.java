package com.luis.neoncity.Buildings;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.math.Vector3;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.ui.Image;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.luis.neoncity.Tools.City;

/**
 * Created by Luis on 5/15/2017 and Changed by Zach on 5/23/17.
 */

/**
 * super class of all other buildings that is a subclass of Actor so it can be added to a stage
 */
public class Building extends Actor { //super class of all other buildings that is a subclass of Actor so it can be added to a stage

    protected Vector3 location; //position on map
    protected City city;
    protected int populationNeeded, pollutionCreated, powerNeeded; //every building has these

    public Boolean inUse; //if its working
    public Label pop; //text on the building
    public Image sprite; //image of the building
    public int size; //tiles taken up by the building
    public int cost; //funds cost to build

    public Building() //base constructor
    {
    }

    public Building(Vector3 loc, City city, boolean inUse, int size, int cost)
    {

        Skin skin;
        try {
            skin = new Skin(Gdx.files.internal("uiskin.json"));
        }
        catch (Exception e){
            skin = new Skin();
        }

        pop = new Label("", skin);

        location = loc;
        this.city = city;
        this.inUse = inUse;
        this.size = size;
        this.cost = cost;
    }

    public void setTilesUnusable(){ //if tiles are unusable then buildings cant be built on them
        for(int x = (int)location.x/16; x < (int)location.x/16 + size; x++){
            for(int y = (int)location.y/16; y < (int)location.y/16 + size; y++){
                city.tiles[x][y].setUsable(false);
            }
        }
    }
    public Vector3 getLocation()
    {
        return location;
    }

    public int getPopulationNeeded()
    {
        return populationNeeded;
    }

    public int getPollutionCreated()
    {
        return pollutionCreated;
    }

    public int getPowerNeeded() {
        return powerNeeded;
    }

    public void addPollution()
    {
            if(inUse)
            city.setPollution(city.getPollution() + pollutionCreated);
    }

    public void addFunction() //if building is built, cost, population, power come out and the buildings benefit goes back in
    {

    }
}
