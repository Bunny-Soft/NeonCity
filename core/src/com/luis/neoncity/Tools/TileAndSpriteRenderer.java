package com.luis.neoncity.Tools;

import com.badlogic.gdx.maps.tiled.TiledMap;
import com.badlogic.gdx.maps.tiled.renderers.OrthogonalTiledMapRenderer;
import com.luis.neoncity.Buildings.ResidentialBuilding;

/**
 * Created by nl383118 on 5/17/2017.
 */

public class TileAndSpriteRenderer extends OrthogonalTiledMapRenderer {
    City city;
    public TileAndSpriteRenderer(TiledMap map, City city) {
        super(map);
        this.city = city;
    }

    @Override
    public void render() {
        super.render();

        this.getBatch().begin();
        for(ResidentialBuilding b : city.getBuildings())
            b.sprite.draw(this.getBatch(), 1f);

        this.getBatch().end();
    }
}