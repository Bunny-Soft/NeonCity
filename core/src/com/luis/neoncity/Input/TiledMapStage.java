package com.luis.neoncity.Input;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.InputProcessor;
import com.badlogic.gdx.maps.MapLayer;
import com.badlogic.gdx.maps.tiled.TiledMap;
import com.badlogic.gdx.maps.tiled.TiledMapTileLayer;
import com.badlogic.gdx.math.Vector3;
import com.badlogic.gdx.scenes.scene2d.EventListener;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.utils.viewport.Viewport;

/**
 * Created by Luis on 5/11/2017.
 */

public class TiledMapStage extends Stage implements InputProcessor{
    private TiledMap tiledMap;
    Vector3 last_touch_down;
    Stage stage;

    public TiledMapStage(Viewport viewport, TiledMap tiledMap) {
        super(viewport);
        this.tiledMap = tiledMap;
        last_touch_down = new Vector3();
        stage = this;

        for (MapLayer layer : tiledMap.getLayers()) {
            //TODO assign each tile an object stored in a 2d array with information on its content(buildings and such)
        }
    }

    private void moveCamera( int touch_x, int touch_y ) {
        Vector3 newPosition = getNewCameraPosition(touch_x, touch_y);
        stage.getCamera().translate(newPosition);
        last_touch_down.set(touch_x, touch_y, 0);
    }

    private Vector3 getNewCameraPosition(int x, int y) {
        Vector3 newPosition = last_touch_down;
        newPosition.sub(x, y, 0);
        newPosition.y = -newPosition.y;
        return newPosition;
    }

    @Override
    public boolean touchDown(int screenX, int screenY, int pointer, int button) {
        last_touch_down.set(screenX, screenY, 0);
        Vector3 test = stage.getCamera().unproject(new Vector3(screenX, screenY, 0));
        System.out.println((int)(test.x / 16) +  ", " + (int)(test.y /16));
        return super.touchDown(screenX, screenY, pointer, button);
    }

    @Override
    public boolean touchDragged(int screenX, int screenY, int pointer) {
        Gdx.app.log("Touch at", screenX + ", " + screenY);
        moveCamera(screenX, screenY);
        return false;
    }
}
