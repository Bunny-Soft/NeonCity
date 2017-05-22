package com.luis.neoncity.Buildings;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.math.Vector3;
import com.badlogic.gdx.scenes.scene2d.ui.Image;
import com.luis.neoncity.Tools.City;

/**
 * Created by Luis on 5/18/17.
 */

public class Road extends Building { //implements Building{
    protected int fundsAdded;

    public Road(Vector3 loc, City city, Boolean inUse){
        super(loc, city, inUse, 1, 10);

        sprite = new Image(new Texture("road.bmp"));
        sprite.setPosition(loc.x, loc.y);

        populationNeeded = (int)(Math.random()*4+3); //random requirement of workers
        pollutionCreated = 2; //specific pollution to building type
        fundsAdded = (int) Math.ceil(populationNeeded * (city.getHappiness()*10)); //The amount of money made is affected by city happiness and people working
    }

    //adds funds to the city that city the building
    //     because the city city the population variable
    public void addFunds()
    {
        if(inUse)
            city.setFunds(city.getFunds() + fundsAdded);
    }
}
