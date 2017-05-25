package com.luis.neoncity.Buildings;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.math.Vector3;
import com.badlogic.gdx.scenes.scene2d.ui.Image;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.luis.neoncity.Tools.City;

/**
 * Created by Luis on 5/18/17.
 */
/**
 * A park is a building
 * sets the position, cost, and sprite for a new park
 * parks add happiness
 */
public class Park extends Building {
    protected int happyAdded; //global building purpose
    protected Vector3 loc; // global location
    protected Skin skin; //global skin

    public Park(Vector3 local, City city, Boolean inUse){
        super(local, city, inUse, 1, 1000); //making the super constructor

        loc = local;

        sprite = new Image(new Texture("park.png"));//image of building
        sprite.setPosition(loc.x, loc.y); //position on map of building

        try {
            skin = new Skin(Gdx.files.internal("uiskin.json")); //skin for labels
        }
        catch (Exception e){ //if skin causes an error, default to a basic skin
            skin = new Skin();
        }

        populationNeeded = (int)(Math.random()*4+3); //random requirement of workers
        pollutionCreated = 2; //specific pollution to building type
        happyAdded = 10; //The amount of happiness made is flat or it will increase far too fast
    }

    //adds funds to the city that city the building
    //     because the city city the population variable
    public void addFunction() //vague method for all buildings to describe their benefits
    {
        if(city.getPopulation() >  populationNeeded && city.getPower() > powerNeeded) // if reqs to build are met, build building and perform its function
        {
            city.setPollution(city.getPollution() + pollutionCreated); //building things causes pollution no use currently
            city.setPopulation(city.getPopulation()-populationNeeded); //people used to maintain the building are not part of the unused population
            city.setPower(city.getPower()-powerNeeded); //taking free power away as building needs it
        }
        city.setHappiness(city.getHappiness() + happyAdded); //Building was built, so people have a natural space causing happiness to increase
    }
}
