package com.luis.neoncity.Input;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.InputProcessor;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.maps.MapLayer;
import com.badlogic.gdx.maps.tiled.TiledMap;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.math.Vector3;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Image;
import com.badlogic.gdx.utils.viewport.Viewport;
import com.luis.neoncity.Buildings.ResidentialBuilding;
import com.luis.neoncity.Tools.City;

/**
 * Created by Luis on 5/11/2017.
 */

public class TiledMapStage extends Stage implements InputProcessor{
    private TiledMap tiledMap;
    private Vector3 lastTouch;
    private Stage stage;
    City city;

    public TiledMapStage(Viewport viewport, TiledMap tiledMap, City city) {
        super(viewport);
        this.tiledMap = tiledMap;
        this.city = city;

        lastTouch = new Vector3();
        stage = this;

        for (MapLayer layer : tiledMap.getLayers()) {
            //TODO assign each tile an object stored in a 2d array with information on its content(buildings and such)
        }
    }

    private void moveCamera( int screenX, int screenY ) {
        Vector3 newPosition = getNewCameraPosition(screenX, screenY);
        stage.getCamera().translate(newPosition);
        lastTouch.set(screenX, screenY, 0);
    }

    private Vector3 getNewCameraPosition(int x, int y) {
        Vector3 newPosition = lastTouch;
        newPosition.sub(x, y, 0);
        newPosition.y = -newPosition.y;
        return newPosition;
    }

    @Override
    public boolean touchDown(int screenX, int screenY, int pointer, int button) {
        lastTouch.set(screenX, screenY, 0);
        Vector3 test = stage.getCamera().unproject(new Vector3(screenX, screenY, 0));
        System.out.println((int)(test.x / 16) +  ", " + (int)(test.y /16));

        ResidentialBuilding res = new ResidentialBuilding(test, city, true);
        city.buildings.add(res);

        return super.touchDown(screenX, screenY, pointer, button);
    }

    @Override
    public boolean touchDragged(int screenX, int screenY, int pointer) {
        moveCamera(screenX, screenY);
        return false;
    }
}
