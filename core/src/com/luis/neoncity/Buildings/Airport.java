package com.luis.neoncity.Buildings;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.math.Vector3;
import com.badlogic.gdx.scenes.scene2d.ui.Image;
import com.luis.neoncity.Tools.City;

/**
 * Created by Luis on 5/18/17.
 */

public class Airport extends Building {

    public Airport(Vector3 loc, City contains, Boolean inUse){
        super(loc, contains, inUse, 6, 10000);

        sprite = new Image(new Texture("airport.png"));
        sprite.setPosition(loc.x, loc.y);
    }
}
