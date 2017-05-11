package com.luis.neoncity.Input;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.InputProcessor;
import com.badlogic.gdx.math.Vector3;
import com.badlogic.gdx.scenes.scene2d.Stage;

/**
 * Created by Luis on 5/10/2017.
 */

public class MapInputProcessor implements InputProcessor{
    Vector3 last_touch_down = new Vector3();
    Stage stage;

    public  MapInputProcessor(Stage s) {
        stage = s;
    }

    private void moveCamera( int touch_x, int touch_y ) {
        Vector3 newPosition = getNewCameraPosition(touch_x, touch_y);
        if(Math.abs(newPosition.x) < 50)
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
    public boolean keyDown(int keycode) {
        return false;
    }

    @Override
    public boolean keyUp(int keycode) {
        return false;
    }

    @Override
    public boolean keyTyped(char character) {
        return false;
    }

    @Override
    public boolean touchDown(int screenX, int screenY, int pointer, int button) {
        //last_touch_down.set(0, 0, 0);
        return false;
    }

    @Override
    public boolean touchUp(int screenX, int screenY, int pointer, int button) {
        return false;
    }

    @Override
    public boolean touchDragged(int screenX, int screenY, int pointer) {
        moveCamera(screenX, screenY);
        return false;
    }

    @Override
    public boolean mouseMoved(int screenX, int screenY) {
        return false;
    }

    @Override
    public boolean scrolled(int amount) {
        return false;
    }
}
