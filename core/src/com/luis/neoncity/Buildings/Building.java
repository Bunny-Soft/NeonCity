package com.luis.neoncity.Buildings;

import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.ui.Image;
import com.luis.neoncity.Tools.City;

/**
 * Created by Luis on 5/15/2017 and Changed by Zach on 5/16/17.
 */

public class Building extends Actor{

    protected Vector2 location;
    Batch batch;
    City contains;
    Boolean inUse;
    int populationNeeded, pollutionCreated;

    public Building()
    {

    }

    public Building(Vector2 loc, City contains, boolean inUse)
    {
        location = loc;
        this.contains = contains;
        this.inUse = inUse;
    }

    public Vector2 getLocation()
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
            contains.setPollution(contains.getPollution() + pollutionCreated);
    }

    public void draw(Batch batch)
    {
        super.draw(batch, 1.0f);
    }


}
