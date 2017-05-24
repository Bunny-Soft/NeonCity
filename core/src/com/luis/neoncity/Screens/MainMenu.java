package com.luis.neoncity.Screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.ui.Image;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;
import com.badlogic.gdx.scenes.scene2d.utils.ChangeListener;
import com.badlogic.gdx.utils.viewport.ScreenViewport;
import com.luis.neoncity.NeonCity;
import com.luis.neoncity.Tools.TextInput;

/**
 * Created by Zach on 5/12/2017.
 */

/**
 * Creates the main menu for the game
 * has a background image, buttons, and tittle
 */
public class MainMenu implements Screen { //it is a subclass of screen so layering doesn't occur
    private Stage stage;//similar to a content pane
    protected Image sprite; //background
    private Image title; //title image
    private SpriteBatch sb; //colors
    private NeonCity game; //game class
    protected Skin skin; //skin

    public MainMenu(NeonCity g, SpriteBatch s) {
        this.game = g; //pulls game state
        this.sb = s; //sprite batch is transferred
        sb.begin();

        //removed create(); and inserted its code where it was called
        stage = new Stage(new ScreenViewport()); //The windows content pane
        Gdx.input.setInputProcessor(stage); //screen uses the stage created

        try {
            skin = new Skin(Gdx.files.internal("uiskin.json")); //creating skin from file to use for a font
        }
        catch(Exception e){
            skin = new Skin();
        }

        TextButton start = new TextButton("New Game", skin, "default"); //button has a listener to dispose of @MainMenu screen and create a @CityCreator screen
        start.setSize(400, 100);
        start.setPosition(850, 550);
        start.addListener(new ChangeListener() {
            @Override
            public void changed (ChangeEvent event, Actor actor) {
                sb.end();
                dispose();
                game.setScreen(new CityCreator(game, sb)); //switches screen to cityCreator
            }
        });


        TextButton load = new TextButton("Credits", skin, "default");// pulls a credits screen with the option to recreate the mainmenu to continue to the game.
        load.setSize(400, 100);
        load.setPosition(850, 440);
        load.addListener(new ChangeListener() {
            @Override
            public void changed (ChangeEvent event, Actor actor) {
                sb.end();
                dispose();
                game.setScreen(new Credits(sb, game));
            }
        });


        TextButton options = new TextButton("Throw an Error", skin, "default"); //The ultimate bait button creates an array with 10 slots and calls the 12th
        options.setSize(400, 100);
        options.setPosition(850, 330);
        options.addListener(new ChangeListener() {
            @Override
            public void changed (ChangeEvent event, Actor actor) {
                sb.end();
                dispose();
                int[] com = new int[10];
                com[11] = 0;
            }
        });

        //sprite is the background image for the title
        sprite = new Image(new Texture("8bitCity.png"));
        sprite.setSize(1366, 768);

        title = new Image(new Texture("menu.png")); // title image
        title.setPosition(30, 550);

        Image japanese = new Image(new Texture("doNotStepOnSnekInJapanese.png"));
        japanese.setPosition(300, 500);
        japanese.setScale(.5f);

        //adding image and button to display in order
        stage.addActor(sprite);
        stage.addActor(title);
        stage.addActor(japanese);
        stage.addActor(start);
        stage.addActor(load);
        stage.addActor(options);
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
    } //when screen is closed, memory leak is closed
}