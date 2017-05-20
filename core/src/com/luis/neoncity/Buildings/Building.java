package com.luis.neoncity.Buildings;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.math.Vector3;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.ui.Image;
import com.luis.neoncity.Input.TiledMapStage;
import com.luis.neoncity.Tools.City;
/**
 * Created by Luis on 5/15/2017 and Changed by Zach on 5/16/17.
 */

public class Building extends Actor {

    protected Vector3 location;
    City city;
    Boolean inUse;
    int populationNeeded, pollutionCreated;

    public Image sprite;
    public int size;
    public int cost;

    public Building()
    {
    }

    public Building(Vector3 loc, City city, boolean inUse, int size, int cost)
    {
        location = loc;
        this.city = city;
        this.inUse = inUse;
        this.size = size;
        this.cost = cost;
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

    public void addPollution()
    {
            if(inUse)
            city.setPollution(city.getPollution() + pollutionCreated);
    }
}
