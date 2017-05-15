package com.luis.neoncity.Screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.InputListener;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.ui.Image;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import com.badlogic.gdx.utils.viewport.ScreenViewport;

/**
 * Created by jz367071 on 5/12/2017.
 */

public class MainMenu implements Screen {
    Label outputLabel;
    Stage stage;
    Image sprite;
    Image title;
    SpriteBatch sb;
    public MainMenu(SpriteBatch sb) {
        this.sb = sb;
        sb.begin();
        //removed create(); and inserted its code where it was called
        stage = new Stage(new ScreenViewport());
        Gdx.input.setInputProcessor(stage);
        Skin skin = new Skin(Gdx.files.internal("uiskin.json"));
        TextButton start = new TextButton("Start", skin, "default");
        start.setSize(400, 200);
        //sprite is the background image for the title
        sprite = new Image(new Texture("8bitCity.png"));
        title = new Image(new Texture("title.jpg"));
        title.setSize(400,400);
        title.setPosition(30, 500);

        //adding image and button to display in order
        stage.addActor(sprite);
        stage.addActor(title);
        stage.addActor(start);


    }

    @Override
    public void show() {

    }

    @Override
    public void render(float delta) {

        stage.act();
        stage.draw();
    }

    @Override
    public void resize(int width, int height) {

    }

    @Override
    public void pause() {

    }

    @Override
    public void resume() {

    }

    @Override
    public void hide() {

    }

    @Override
    public void dispose() {

    }
}