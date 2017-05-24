package com.luis.neoncity.Buildings;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.math.Vector3;
import com.badlogic.gdx.scenes.scene2d.ui.Image;
import com.luis.neoncity.Tools.City;

/**
 * Created by Luis on 5/18/17.
 */

/**
 * A Road is a building
 * sets the position, cost, and sprite for a road
 */
public class Road extends Building { //implements Building{
    public Road(Vector3 loc, City city, Boolean inUse){
        super(loc, city, inUse, 1, 10);

        sprite = new Image(new Texture("road.bmp"));
        sprite.setPosition(loc.x, loc.y);
 }
}
