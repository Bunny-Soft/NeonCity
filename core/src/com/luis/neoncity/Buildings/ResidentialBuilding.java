package com.luis.neoncity.Buildings;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.math.Vector3;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.ui.Image;

/**
 * Created by Luis on 5/15/2017.
 */

public class ResidentialBuilding extends Actor { //implements Building{
    protected Vector3 location;
    protected Image sprite;

    public ResidentialBuilding(Vector3 loc){
        location = loc;
        sprite = new Image(new Texture("res.png"));
        sprite.setPosition(loc.x, loc.y);
    }

    public void draw(Batch batch){
        batch.begin();
        sprite.draw(batch, 1f);
        batch.end();
        super.draw(batch, 1.0f);
    }
}
