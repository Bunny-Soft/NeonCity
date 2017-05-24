package com.luis.neoncity.Tools;

import com.badlogic.gdx.maps.tiled.TiledMap;
import com.badlogic.gdx.maps.tiled.renderers.OrthogonalTiledMapRenderer;
import com.luis.neoncity.Buildings.Building;

/**
 * Created by Jacob on 5/17/2017.
 */

/**
 * Renders the map, then the buildings, then the labels on top of the buildings
 */
public class TileAndSpriteRenderer extends OrthogonalTiledMapRenderer {
    City city;

    /**
     * initializes the super class with the map to render
     * and takes in the city containing an array list witb buildings to render
     * @param map
     * map to be rendered
     * @param city
     * city to be rendered
     */
    public TileAndSpriteRenderer(TiledMap map, City city) {
        super(map); //Map renderer super class created
        this.city = city;
    }

    @Override
    public void render() {

        //renders the map first
        super.render();

        this.getBatch().begin();
        for(Building b : city.getBuildings()) {
            //renders the building sprite
            b.sprite.draw(this.getBatch(), 1f);
            //then the label on top of it
            b.pop.draw(this.getBatch(), 1f);

        }
        this.getBatch().end(); //closing resource leak
    }
}
