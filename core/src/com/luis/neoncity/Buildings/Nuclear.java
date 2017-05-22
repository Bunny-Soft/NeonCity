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

public class Nuclear extends Building {

    public Nuclear(Vector3 loc, City contains, Boolean inUse){
        super(loc, contains, inUse, 4, 5000);

        sprite = new Image(new Texture("nuclear.png"));
        sprite.setPosition(loc.x, loc.y);

        Skin skin;
        try {
            skin = new Skin(Gdx.files.internal("uiskin.json"));
        }
        catch (Exception e){
            skin = new Skin();
        }

        populationNeeded = (int)(Math.random()*15+30); //random requirement of residents
        pollutionCreated = 15; //specific pollution to building type
        int powerAdded = populationNeeded*5;

        if(city.getPopulation() >  populationNeeded)
        {
            city.setPopulation(city.getPopulation()-populationNeeded);
            city.setPower(city.getPower()+powerAdded);
            pop = new Label(""+powerAdded, skin);
            pop.setPosition(loc.x+1, loc.y+1);
            pop.setColor(Color.BLACK);
        }
    }
}
