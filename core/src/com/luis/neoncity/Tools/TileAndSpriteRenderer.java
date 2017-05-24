package com.luis.neoncity.Tools;

import com.badlogic.gdx.maps.tiled.TiledMap;
import com.badlogic.gdx.maps.tiled.renderers.OrthogonalTiledMapRenderer;
import com.luis.neoncity.Buildings.Building;

/**
 * Created by Jacob on 5/17/2017.
 */

public class TileAndSpriteRenderer extends OrthogonalTiledMapRenderer {
    City city;
    public TileAndSpriteRenderer(TiledMap map, City city) {
        super(map); //Map renderer super class created
        this.city = city;
    }

    @Override
    public void render() {
        super.render(); //paints a map

        this.getBatch().begin();
        for(Building b : city.getBuildings()) { //array of buildings to render
            b.sprite.draw(this.getBatch(), 1f); //draws building sprites
            b.pop.draw(this.getBatch(), 1f); //draws building labels
        }
        this.getBatch().end(); //closing resource leak
    }
}
