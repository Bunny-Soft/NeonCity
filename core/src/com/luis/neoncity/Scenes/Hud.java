package com.luis.neoncity.Scenes;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.InputProcessor;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.ui.Dialog;
import com.badlogic.gdx.scenes.scene2d.ui.ImageButton;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import com.badlogic.gdx.utils.Timer;
import com.badlogic.gdx.utils.viewport.FitViewport;
import com.badlogic.gdx.utils.viewport.Viewport;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.luis.neoncity.NeonCity;

/**
 * Created by Luis and Jacob on 5/9/2017.
 */

public class Hud implements InputProcessor{
    private Viewport viewport;
    public Stage stage;
    public Skin skin;

    //TODO: Create a GameManger class for global variables such as these
    private Integer funds;
    private Integer population;
    private String cityName;

    private Label fundsLabel;
    private Label popLabel;
    private Label nameLabel;

    public Hud(SpriteBatch sb) {
        //TODO: replace with global variables, loaded from files
        funds = 20000;
        population = 1000000;
        cityName = "Dallas";

        viewport = new FitViewport(NeonCity.V_WIDTH, NeonCity.V_HEIGHT, new OrthographicCamera());
        stage = new Stage(viewport, sb);
        skin = new Skin(Gdx.files.internal("uiskin.json"));

        for(int r = 1; r <= 8; r++)
        {
            for(int c = 1; c <= 2; c++)
            {
                TextButton button = new TextButton("",skin,"default");
                button.setSize(50,50);
                stage.addActor(button);
                button.setPosition(c*50,r*50+150);

            }
        }

        Gdx.input.setInputProcessor(stage);

        Table table = new Table();
        table.top();
        table.setFillParent(true);

        BitmapFont font = new BitmapFont();
        //font.getData().setScale(3f);
        Label.LabelStyle style = new Label.LabelStyle(font, com.badlogic.gdx.graphics.Color.WHITE);

        fundsLabel = new Label("$" + String.format("%07d", funds), style);
        popLabel = new Label(String.format("%08d", population), style);
        nameLabel = new Label(cityName, style);

        table.add(nameLabel).expandX().padTop(10);
        table.add(fundsLabel).expandX().padTop(10);
        table.add(popLabel).expandX().padTop(10);

        stage.addActor(table);
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
        return false;
    }

    @Override
    public boolean touchUp(int screenX, int screenY, int pointer, int button) {
        return false;
    }

    @Override
    public boolean touchDragged(int screenX, int screenY, int pointer) {
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
