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
 * Created by Luis on 5/15/2017 and Changed by Zach on 5/16/17.
 */


public class ResidentialBuilding extends Building { //implements Building{
    protected int populationAdded;

    public ResidentialBuilding(Vector3 loc, City city, Boolean inUse){
        super(loc, city, inUse, 3, 100);

        sprite = new Image(new Texture("res.png"));
        sprite.setPosition(loc.x, loc.y);


        Skin skin;
        try {
            skin = new Skin(Gdx.files.internal("uiskin.json"));
        }
        catch (Exception e){
            skin = new Skin();
        }



        populationNeeded = (int)(Math.random()*10+30); //random requirement of residents
        pollutionCreated = 1; //specific pollution to building type
        powerNeeded = 20;

        populationAdded = (int) Math.ceil(populationNeeded * (city.getHappiness()+.5)); //The amount of people born or moving in is affected by city happiness
        if(city.getPopulation() >  populationNeeded && city.getPower() > powerNeeded)
        {
            city.setPopulation(city.getPopulation()-populationNeeded);
            city.setPower(city.getPower()-powerNeeded);
            inUse = true;
            addPopulation();
            pop = new Label(""+populationAdded, skin);
            pop.setPosition(loc.x+1, loc.y+1);
            pop.setColor(Color.BLACK);
        }
    }

    //adds population to the city that city the building
    //     because the city city the population variable
    public void addPopulation()
    {
        if(inUse)
            city.setPopulation(city.getPopulation() + populationAdded);
    }
}
