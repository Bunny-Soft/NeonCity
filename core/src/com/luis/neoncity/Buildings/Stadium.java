package com.luis.neoncity.Buildings;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.math.Vector3;
import com.badlogic.gdx.scenes.scene2d.ui.Image;
import com.luis.neoncity.Tools.City;

/**
 * Created by Luis on 5/18/17.
 */

/**
 * A stadium is a building
 * sets the position, cost, and sprite for a stadium
 */
public class Stadium extends Building {

    public Stadium(Vector3 loc, City contains, Boolean inUse){
        super(loc, contains, inUse, 4, 3000);

        sprite = new Image(new Texture("stadium.png"));
        sprite.setPosition(loc.x, loc.y);
    }
}
