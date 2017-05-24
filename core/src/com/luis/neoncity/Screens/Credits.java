package com.luis.neoncity.Screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Image;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;
import com.badlogic.gdx.scenes.scene2d.utils.ChangeListener;
import com.badlogic.gdx.utils.viewport.ScreenViewport;
import com.luis.neoncity.NeonCity;

/**
 * Created by Zach on 5/24/2017.
 */

/**
 * Displays credits for the game
 */
public class Credits implements Screen{
    private Stage stage;//similar to a content pane
    protected Image sprite; //background
    private Image cat;
    private SpriteBatch sb; //colors
    private NeonCity game; //is the runner
    protected Skin skin; //skin
    public Credits(SpriteBatch s, NeonCity g)
    {
        this.game = g;
        this.sb = s;
        sb.begin();

        stage = new Stage(new ScreenViewport());
        Gdx.input.setInputProcessor(stage);

        try {
            skin = new Skin(Gdx.files.internal("uiskin.json"));
        }
        catch(Exception e){
            skin = new Skin();
        }

        sprite = new Image(new Texture("black.png"));
        sprite.setSize(1366, 768);

        Label credit = new Label("Game created by Luis, Jacob, and Zach\n    ©2017 Stites Co.",skin);
        credit.setPosition(300, 500);


        Image cat = new Image(new Texture("cat.jpg"));
        cat.setPosition(700,150);
        cat.setSize(400,400);



        TextButton start = new TextButton("Return", skin, "default");
        start.setSize(300, 100);
        start.setPosition(30, 50);
        start.addListener(new ChangeListener() {
            @Override
            public void changed (ChangeEvent event, Actor actor) {
                sb.end();
                dispose();
                game.setScreen(new MainMenu(game, sb));
            }
        });

        stage.addActor(sprite);
        stage.addActor(credit);
        stage.addActor(cat);
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
        stage.dispose();
    }
}