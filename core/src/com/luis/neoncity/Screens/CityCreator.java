package com.luis.neoncity.Screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.ui.Image;
import com.badlogic.gdx.scenes.scene2d.ui.ImageButton;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.scenes.scene2d.ui.SelectBox;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;
import com.badlogic.gdx.scenes.scene2d.utils.ChangeListener;
import com.badlogic.gdx.scenes.scene2d.utils.SpriteDrawable;
import com.badlogic.gdx.utils.viewport.ScreenViewport;
import com.luis.neoncity.NeonCity;
import com.luis.neoncity.Tools.City;
import com.luis.neoncity.Tools.TextInput;

/**
 * Created by Zach on 5/18/2017.
 */

public class CityCreator implements Screen { //it is a subclass of screen so layering doesn't occur
    private Stage stage; //similar to a content pane
    protected SpriteBatch sb; //pulls colors
    private Image back; //background image
    private Image options; //options sign image
    protected NeonCity game; //game created once options are selected
    protected Skin skin; //skin for labels and buttons
    private TextInput cityName; //input box class created to take in text for a name selector
    private SelectBox cityDifficulty; //comboBox menu that allows for difficulty to be selected, starting funds are scaled with difficulty
    private Integer cityFunds;
    private String mapName; //mapName is what decide which map is instantiated
    public CityCreator(NeonCity g, SpriteBatch s) {
        this.game = g;
        this.sb = s;
        sb.begin();

        //removed create(); and inserted its code where it was called
        stage = new Stage(new ScreenViewport()); //new 'content pane'
        Gdx.input.setInputProcessor(stage); //game views the stage that is setup

        try {
            skin = new Skin(Gdx.files.internal("uiskin.json")); //create skin from file
        }
        catch(Exception e){
            skin = new Skin();
        }

       // TextButton start = new TextButton("Difficulty", skin, "default");
       // start.setSize(300, 100);
       // start.setPosition(120, 550);
       // start.addListener(new ChangeListener() {
        //    @Override
       //     public void changed (ChangeEvent event, Actor actor) {
                cityDifficulty = new SelectBox(skin); //creates comboBox
                cityDifficulty.setName("Difficulty"); //name of the box
                cityDifficulty.setSize(300, 100); //size
                cityDifficulty.setPosition(120, 550); //location from bottom right
                String[] items = new String[3]; //array to put into the box
                items[0] = "Easy";
                items[1] = "Medium";
                items[2] = "Hard";
                cityDifficulty.setItems(items);//setting the options in the box

         //   }
       // });


        TextButton load = new TextButton("Create City Name", skin, "default"); // button to pull up a textInput box
        load.setSize(400, 100); //size
        load.setPosition(120, 440); //location from bottom right
        load.addListener(new ChangeListener() {
            @Override
            public void changed(ChangeEvent event, Actor actor) {
                cityName = new TextInput();
                Gdx.input.getTextInput(cityName, "", "Dallas", ""); //new popup that is the Name creator
            }
        });

        Sprite map1 = new Sprite(new Texture("seaport.png")); //image of the map1
        map1.setSize(400,200); //image size
        ImageButton mapButton1 = new ImageButton(new SpriteDrawable(map1)); //button
        mapButton1.setSize(400,200);
        mapButton1.setPosition(680, 450);
        mapButton1.addListener(new ChangeListener() {
            @Override
            public void changed(ChangeEvent event, Actor actor) {
                mapName = "islandTest";
            }
        });

        Sprite map2 = new Sprite(new Texture("stadium.png")); //map2
        map2.setSize(400,200);
        ImageButton mapButton2 = new ImageButton(new SpriteDrawable(map2));
        mapButton2.setSize(400,200);
        mapButton2.setPosition(680, 240);
        mapButton2.addListener(new ChangeListener() {
            @Override
            public void changed(ChangeEvent event, Actor actor) {
                mapName = "TestMap";
            }
        });

        Sprite map3 = new Sprite(new Texture("nuclear.png")); //map3
        map3.setSize(400,200);
        ImageButton mapButton3 = new ImageButton(new SpriteDrawable(map3));
        mapButton3.setSize(400,200);
        mapButton3.setPosition(680, 30);
        mapButton3.addListener(new ChangeListener() {
            @Override
            public void changed(ChangeEvent event, Actor actor) {
                mapName = "SimpleTest";
            }
        });

        TextButton exit = new TextButton("Continue", skin, "default"); //continue button
        exit.setSize(400, 100);
        exit.setPosition(120, 330);
        exit.addListener(new ChangeListener() {
            @Override
            public void changed(ChangeEvent event, Actor actor) {
                sb.end();

                try {// gets starting funds based on selected difficulty

                if(cityDifficulty.getSelected().equals("Easy"))
                    cityFunds = 10000;
                else if(cityDifficulty.getSelected().equals("Medium"))
                    cityFunds = 50000;
                else if(cityDifficulty.getSelected().equals("Hard"))
                    cityFunds = 3000;
                else
                    cityFunds = 0;
                }

                catch(Exception e) //if a difficulty/name/map isnt selected an error is thrown
                {
                    Label error = new Label("", skin);
                    error.setText("Set a City Name AND Difficulty AND a Map before starting the game.");
                    error.setPosition(60, 30);
                    stage.addActor(error);
                    sb.begin();
                }

                if(cityName.getInput().equals("WannaCry")){ //easter egg
                    Image i = new Image(new Texture("cry.jpg"));
                    i.setSize(1366, 768);
                    stage.addActor(i);
                }
                else{
                    try {
                        game.setScreen(new PlayScreen(game, sb, new City(cityName.getInput(),cityFunds), mapName));
                    }
                    catch(Exception e)
                    {
                        Label error = new Label("", skin); //catching null errors from players not selecting maps or names
                        error.setText("Set a City Name AND Difficulty AND a Map before starting the game.");
                        System.out.print(e.toString());
                        error.setPosition(60, 30);
                        stage.addActor(error);
                        sb.begin();
                    }
                }
            }
        });

        back = new Image(new Texture("black.png")); //background
        back.setSize(1366, 768);
        options = new Image(new Texture("GameOptions.png"));
        options.setPosition(80, 660);
        //stages are the canvas of the screen
        //actors are objects that can be projected onto that canvas
        //actors must be added to stages or they will not be rendered
        stage.addActor(back);
        stage.addActor(options);
        stage.addActor(cityDifficulty);
        stage.addActor(mapButton1);
        stage.addActor(mapButton2);
        stage.addActor(mapButton3);
        //stage.addActor(start);
        stage.addActor(load);
        stage.addActor(exit);
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