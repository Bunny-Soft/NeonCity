package com.luis.neoncity.Scenes;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.InputProcessor;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.freetype.FreeTypeFontGenerator;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.ui.ButtonGroup;
import com.badlogic.gdx.scenes.scene2d.ui.Cell;
import com.badlogic.gdx.scenes.scene2d.ui.CheckBox;
import com.badlogic.gdx.scenes.scene2d.ui.Image;
import com.badlogic.gdx.scenes.scene2d.ui.ImageButton;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import com.badlogic.gdx.scenes.scene2d.utils.Drawable;
import com.badlogic.gdx.scenes.scene2d.utils.TextureRegionDrawable;
import com.badlogic.gdx.utils.viewport.FitViewport;
import com.badlogic.gdx.utils.viewport.Viewport;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.luis.neoncity.Input.TiledMapStage;
import com.luis.neoncity.NeonCity;
import com.luis.neoncity.Screens.PlayScreen;
import com.luis.neoncity.Tools.City;

import java.util.ArrayList;
//import com.sun.xml.internal.ws.policy.privateutil.PolicyUtils;

/**
 * Created by Luis and Jacob on 5/9/2017.
 */

public class Hud implements InputProcessor{
    public enum State {
        BULLDOZER,  ROAD,
        RAIL,       POWER,
        PARK,       RESIDENTIAL,
        COMMERCIAL, INDUSTRIAL,
        FIRE,       POLICE,
        STADIUM,    SEAPORT,
        COAL,       NUCLEAR,
        AIRPORT,    DRAG};
    public State currentState;

    private Viewport viewport;
    public Stage stage;
    public Skin skin;

    City city;

    private Label fundsLabel;
    private Label popLabel;
    private Label nameLabel;

    private Image cursor;


    private ClickListener listener = new ClickListener();
    public Hud(SpriteBatch sb, City city) {
        this.city = city;
        viewport = new FitViewport(NeonCity.V_WIDTH, NeonCity.V_HEIGHT, new OrthographicCamera());
        stage = new Stage(viewport, sb);
        try {
            skin = new Skin(Gdx.files.internal("uiskin.json"));
        }
        catch (Exception e){
            skin = new Skin();
        }
        cursor = new Image(new Texture("cursor.png"));

        currentState = State.DRAG;

        sideButtons();

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

    public void sideButtons(){

        ButtonGroup<CheckBox> group = new ButtonGroup<CheckBox>();
        group.setMaxCheckCount(1);

        int count = 0;
        for(int r = 1; r <= 8; r++) {
            for(int c = 1; c <= 2; c++)
            {
                count++;
                TextButton button = new TextButton(""+count,skin,"default");
                button.setSize(50,50);
                button.setColor(Color.DARK_GRAY);
                stage.addActor(button);
                button.setPosition(c*50,r*50+150);

                if(count==1)
                    button.addListener(new ClickListener(){
                     @Override public void clicked(InputEvent event, float x, float y) {
                       currentState = State.BULLDOZER;}
                    });

                if(count==2)
                    button.addListener(new ClickListener(){
                        @Override public void clicked(InputEvent event, float x, float y) {
                            currentState = State.ROAD;}});

                if(count==3)
                    button.addListener(new ClickListener(){
                        @Override public void clicked(InputEvent event, float x, float y) {
                            currentState = State.RAIL;}
                    });
                if(count==4)
                    button.addListener(new ClickListener(){
                        @Override public void clicked(InputEvent event, float x, float y) {
                            currentState = State.POWER;}});

                if(count==5)
                    button.addListener(new ClickListener(){
                        @Override public void clicked(InputEvent event, float x, float y) {
                            currentState = State.PARK;}});

                if(count==6)
                    button.addListener(new ClickListener(){
                        @Override public void clicked(InputEvent event, float x, float y) {
                            currentState = State.RESIDENTIAL;}});

                if(count==7)
                    button.addListener(new ClickListener(){
                        @Override public void clicked(InputEvent event, float x, float y) {
                            currentState = State.COMMERCIAL;
                        }
                    });

                if(count==8) {
                    button.addListener(new ClickListener(){
                        @Override public void clicked(InputEvent event, float x, float y) {
                            currentState = State.INDUSTRIAL;
                        }
                    });
                }
                if(count==9) {
                    button.addListener(new ClickListener(){
                        @Override public void clicked(InputEvent event, float x, float y) {
                            currentState = State.FIRE;
                        }
                    });
                }
                if(count==10) {
                    button.addListener(new ClickListener(){
                        @Override public void clicked(InputEvent event, float x, float y) {
                            currentState = State.POLICE;
                        }
                    });
                }
                if(count==11) {
                    button.addListener(new ClickListener(){
                        @Override public void clicked(InputEvent event, float x, float y) {
                            currentState = State.STADIUM;
                        }
                    });
                }
                if(count==12) {
                    button.addListener(new ClickListener(){
                        @Override public void clicked(InputEvent event, float x, float y) {
                            currentState = State.SEAPORT;
                        }
                    });
                }
                if(count==13)
                    button.addListener(new ClickListener(){
                        @Override public void clicked(InputEvent event, float x, float y) {
                            currentState = State.COAL;}
                    });

                if(count==14) {
                    button.addListener(new ClickListener(){
                        @Override public void clicked(InputEvent event, float x, float y) {
                            currentState = State.NUCLEAR;
                        }
                    });
                }
                if(count==15) {
                    button.addListener(new ClickListener(){
                        @Override public void clicked(InputEvent event, float x, float y) {
                            currentState = State.AIRPORT;
                        }
                    });
                }
                if(count==16) {
                    button.addListener(new ClickListener(){
                        @Override public void clicked(InputEvent event, float x, float y) {
                            currentState = State.DRAG;
                        }
                    });
                }

                // The currentState variable will be checked in TiledMapStage and will
                // affect the type of building placed
            }
        }
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
        System.out.println(currentState.toString());
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
        //cursor.setPosition((screenX/16) * 16, ((Gdx.graphics.getHeight() - screenY)/16)*16);

        return false;
    }

    @Override
    public boolean scrolled(int amount) {
        return false;
    }
}
