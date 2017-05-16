package com.luis.neoncity.Scenes;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.InputProcessor;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.freetype.FreeTypeFontGenerator;
import com.badlogic.gdx.scenes.scene2d.ui.Image;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;
import com.badlogic.gdx.utils.viewport.FitViewport;
import com.badlogic.gdx.utils.viewport.Viewport;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.luis.neoncity.NeonCity;
import com.luis.neoncity.Screens.PlayScreen;
import com.luis.neoncity.Tools.City;

/**
 * Created by Luis and Jacob on 5/9/2017.
 */

public class Hud implements InputProcessor{
    private Viewport viewport;
    public Stage stage;
    public Skin skin;

    City city;

    private Label fundsLabel;
    private Label popLabel;
    private Label nameLabel;

    private Image cursor;
    public Hud(SpriteBatch sb, City city) {
        this.city = city;

        viewport = new FitViewport(NeonCity.V_WIDTH, NeonCity.V_HEIGHT, new OrthographicCamera());
        stage = new Stage(viewport, sb);
        skin = new Skin(Gdx.files.internal("uiskin.json"));

        cursor = new Image(new Texture("cursor.png"));

        for(int r = 1; r <= 8; r++)
        {
            for(int c = 1; c <= 2; c++)
            {
                TextButton button = new TextButton(""+c*r,skin,"default");
                button.setSize(50,50);
                stage.addActor(button);
                button.setPosition(c*50,r*50+150);

            }
        }

        Table table = new Table();
        table.top();
        table.setFillParent(true);
        FreeTypeFontGenerator generator = new FreeTypeFontGenerator(Gdx.files.internal("pixel.ttf"));
        FreeTypeFontGenerator.FreeTypeFontParameter parameter = new FreeTypeFontGenerator.FreeTypeFontParameter();
        parameter.size = 32;
        BitmapFont font = generator.generateFont(parameter); // font size 12 pixels
        generator.dispose();

        Label.LabelStyle style = new Label.LabelStyle(font, com.badlogic.gdx.graphics.Color.WHITE);

        fundsLabel = new Label("$" + String.format("%07d", city.getFunds()), style);
        popLabel = new Label(String.format("%08d", city.getPopulation()), style);
        nameLabel = new Label(city.getCityName(), style);

        table.add(nameLabel).expandX().padTop(10);
        table.add(fundsLabel).expandX().padTop(10);
        table.add(popLabel).expandX().padTop(10);

        stage.addActor(table);
        stage.addActor(cursor);
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
        Image res = new Image(new Texture("res.png"));
        res.setPosition(screenX, Gdx.graphics.getHeight() - screenY);
        stage.addActor(res);
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
        cursor.setPosition(screenX, ((Gdx.graphics.getHeight() - screenY)));
        stage.act();
        return false;
    }

    @Override
    public boolean scrolled(int amount) {
        return false;
    }
}
