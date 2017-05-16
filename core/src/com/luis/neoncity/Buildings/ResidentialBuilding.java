package com.luis.neoncity.Buildings;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.math.Vector3;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.ui.Image;
import com.luis.neoncity.Tools.City;
/**
 * Created by Luis on 5/15/2017 and Changed by Zach on 5/16/17.
 */


public class ResidentialBuilding extends Building { //implements Building{
    protected int populationAdded;
    protected Image sprite;

    public ResidentialBuilding(Vector2 loc, City contains, Boolean inUse){
        super.location = loc;
        super.contains = contains;
        super.inUse = inUse;
        sprite = new Image(new Texture("res.png"));
        sprite.setPosition(loc.x, loc.y);
        populationNeeded = (int)(Math.random()*3+1); //random requirement of residents
        pollutionCreated = 1; //specific pollution to building type
        populationAdded = (int) Math.ceil(populationNeeded * contains.getHappiness()); //The amount of people born or moving in is affected by city happiness
    }

    //adds population to the city that contains the building
    //     because the city contains the population variable
    public void addPopulation()
    {
        if(inUse)
            contains.setPopulation(contains.getPopulation() + populationAdded);
    }

    public void draw(Batch batch){

        super.draw(batch);
    }
}
