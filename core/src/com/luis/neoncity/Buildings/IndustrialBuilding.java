package com.luis.neoncity.Buildings;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.ui.Image;
import com.luis.neoncity.Tools.City;

/**
 * Created by Zach on 5/16/17.
 */

public class IndustrialBuilding extends Building { //implements Building{
    protected int fundsAdded;
    protected Image sprite;
    Batch batch;

    public IndustrialBuilding(Vector2 loc, City contains, Boolean inUse){
        super.location = loc;
        super.contains = contains;
        super.inUse = inUse;
        //TODO :: get image for industrial building
        sprite = new Image();
        sprite.setPosition(loc.x, loc.y);
        populationNeeded = (int)(Math.random()*4+3); //random requirement of workers
        pollutionCreated = 2; //specific pollution to building type
        fundsAdded = (int) Math.ceil(populationNeeded * (contains.getHappiness()*10)); //The amount of money made is affected by city happiness and people working
    }

    //adds funds to the city that contains the building
    //     because the city contains the population variable
    public void addFunds()
    {
        if(inUse)
            contains.setFunds(contains.getFunds() + fundsAdded);
    }

    public void draw(Batch batch){
        super.draw(batch);
    }
}
