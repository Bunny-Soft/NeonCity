package com.luis.neoncity.Scenes;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.InputProcessor;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.Sprite;
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
import com.badlogic.gdx.scenes.scene2d.utils.SpriteDrawable;
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

    private SpriteDrawable icon;
    private Sprite sprite;

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
                ImageButton button = new ImageButton(new SpriteDrawable(new Sprite(new Texture("ui.png"))));


                if(count==1) {
                    sprite = new Sprite(new Texture("bulldozer.png"));
                    sprite.setSize(48,48);
                    icon = new SpriteDrawable(sprite);
                    button = new ImageButton(icon);
                    button.addListener(new ClickListener() {
                        @Override
                        public void clicked(InputEvent event, float x, float y) {
                            currentState = State.BULLDOZER;
                            cursor = new Image(sprite.getTexture());

                        }
                    });

                }
                if(count==2) {
                    sprite = new Sprite(new Texture("road.png"));
                    sprite.setSize(48,48);
                    icon = new SpriteDrawable(sprite);
                    button = new ImageButton(icon);
                    button.addListener(new ClickListener() {
                        @Override
                        public void clicked(InputEvent event, float x, float y) {
                            currentState = State.ROAD;
                            cursor = new Image(sprite.getTexture());
                        }
                    });

                }

                if(count==3) {
                    sprite = new Sprite(new Texture("road.png"));
                    sprite.setSize(48,48);
                    icon = new SpriteDrawable(sprite);
                    button = new ImageButton(icon);
                    button.addListener(new ClickListener() {
                        @Override
                        public void clicked(InputEvent event, float x, float y) {
                            currentState = State.RAIL;
                            cursor = new Image(sprite.getTexture());
                        }
                    });

                }

                if(count==4) {
                    sprite = new Sprite(new Texture("road.png"));
                    sprite.setSize(48,48);
                    icon = new SpriteDrawable(sprite);
                    button = new ImageButton(icon);
                    button.addListener(new ClickListener() {
                        @Override
                        public void clicked(InputEvent event, float x, float y) {
                            currentState = State.POWER;
                            cursor = new Image(sprite.getTexture());
                        }
                    });

                }

                if(count==5) {
                    sprite = new Sprite(new Texture("park.png"));
                    sprite.setSize(48,48);
                    icon = new SpriteDrawable(sprite);
                    button = new ImageButton(icon);
                    button.addListener(new ClickListener() {
                        @Override
                        public void clicked(InputEvent event, float x, float y) {
                            currentState = State.PARK;
                            cursor = new Image(sprite.getTexture());
                        }
                    });

                }

                if(count==6) {
                    sprite = new Sprite(new Texture("res.png"));
                    icon = new SpriteDrawable(sprite);
                    button = new ImageButton(icon);
                    button.addListener(new ClickListener() {
                        @Override
                        public void clicked(InputEvent event, float x, float y) {
                            currentState = State.RESIDENTIAL;
                            cursor = new Image(sprite.getTexture());
                        }
                    });

                }

                if(count==7) {
                    sprite = new Sprite(new Texture("com.png"));
                    icon = new SpriteDrawable(sprite);
                    button = new ImageButton(icon);
                    button.addListener(new ClickListener() {
                        @Override
                        public void clicked(InputEvent event, float x, float y) {
                            currentState = State.COMMERCIAL;
                            cursor = new Image(sprite.getTexture());
                        }
                    });

                }

                if(count==8) {
                    sprite = new Sprite(new Texture("ind.png"));
                    icon = new SpriteDrawable(sprite);
                    button = new ImageButton(icon);
                    button.addListener(new ClickListener(){
                        @Override public void clicked(InputEvent event, float x, float y) {
                            currentState = State.INDUSTRIAL;
                            cursor = new Image(sprite.getTexture());
                        }
                    });

                }
                if(count==9) {
                    sprite = new Sprite(new Texture("fire.png"));
                    icon = new SpriteDrawable(sprite);
                    button = new ImageButton(icon);
                    button.addListener(new ClickListener(){
                        @Override public void clicked(InputEvent event, float x, float y) {
                            currentState = State.FIRE;
                            cursor = new Image(sprite.getTexture());
                        }
                    });

                }
                if(count==10) {
                    sprite = new Sprite(new Texture("police.png"));
                    icon = new SpriteDrawable(sprite);
                    button = new ImageButton(icon);
                    button.addListener(new ClickListener(){
                        @Override public void clicked(InputEvent event, float x, float y) {
                            currentState = State.POLICE;
                            cursor = new Image(sprite.getTexture());
                        }
                    });

                }
                if(count==11) {
                    sprite = new Sprite(new Texture("stadium.png"));
                    icon = new SpriteDrawable(sprite);
                    button = new ImageButton(icon);
                    button.addListener(new ClickListener(){
                        @Override public void clicked(InputEvent event, float x, float y) {
                            currentState = State.STADIUM;
                            cursor = new Image(sprite.getTexture());
                        }
                    });

                }
                if(count==12) {
                    sprite = new Sprite(new Texture("seaport.png"));
                    icon = new SpriteDrawable(sprite);
                    button = new ImageButton(icon);
                    button.addListener(new ClickListener(){
                        @Override public void clicked(InputEvent event, float x, float y) {
                            currentState = State.SEAPORT;
                            cursor = new Image(sprite.getTexture());
                        }
                    });

                }
                if(count==13) {
                    sprite = new Sprite(new Texture("coal.png"));
                    icon = new SpriteDrawable(sprite);
                    button = new ImageButton(icon);
                    button.addListener(new ClickListener() {
                        @Override
                        public void clicked(InputEvent event, float x, float y) {
                            currentState = State.COAL;
                            cursor = new Image(sprite.getTexture());
                        }
                    });

                }

                if(count==14) {
                    sprite = new Sprite(new Texture("nuclear.png"));
                    icon = new SpriteDrawable(sprite);
                    button = new ImageButton(icon);
                    button.addListener(new ClickListener(){
                        @Override public void clicked(InputEvent event, float x, float y) {
                            currentState = State.NUCLEAR;
                            cursor = new Image(sprite.getTexture());
                        }
                    });

                }
                if(count==15) {
                    sprite = new Sprite(new Texture("airport.png"));
                    icon = new SpriteDrawable(sprite);
                    button = new ImageButton(icon);
                    button.addListener(new ClickListener(){
                        @Override public void clicked(InputEvent event, float x, float y) {
                            currentState = State.AIRPORT;
                            cursor = new Image(sprite.getTexture());
                        }
                    });

                }
                if(count==16) {
                    sprite = new Sprite(new Texture("Cursor.png"));
                    icon = new SpriteDrawable(sprite);
                    button = new ImageButton(icon);
                    button.addListener(new ClickListener(){
                        @Override public void clicked(InputEvent event, float x, float y) {
                            currentState = State.DRAG;
                            cursor = new Image(sprite.getTexture());
                        }
                    });

                }
                button.setSize(50,50);
                button.setColor(Color.DARK_GRAY);
                stage.addActor(button);
                button.setPosition(c*50,r*50+150);
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
