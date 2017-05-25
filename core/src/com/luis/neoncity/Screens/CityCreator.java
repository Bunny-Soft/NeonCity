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

/**
 * Display for creating a new city
 * allows you to set difficulty, city name, and map
 */
public class CityCreator implements Screen {
	private Stage stage;
	protected SpriteBatch sb;
	private Image back;
	private Image options;
	protected NeonCity game;
	protected Skin skin;
	private TextInput cityName;
	private SelectBox cityDifficulty;
	private Integer cityFunds;
	private String mapName;

	public CityCreator(NeonCity g, SpriteBatch s) {
		this.game = g;
		this.sb = s;
		sb.begin();

		//removed create(); and inserted its code where it was called
		stage = new Stage(new ScreenViewport());
		Gdx.input.setInputProcessor(stage);

		//sometimes this causes problems, now it doesnt
		try {
			skin = new Skin(Gdx.files.internal("uiskin.json"));
		}
		catch(Exception e){
			skin = new Skin();
		}

		//creates difficulty selector
		cityDifficulty = new SelectBox(skin);
		cityDifficulty.setName("Difficulty");
		cityDifficulty.setSize(300, 100);
		cityDifficulty.setPosition(120, 550);
		String[] items = new String[3];
		items[0] = "Easy";
		items[1] = "Medium";
		items[2] = "Hard";
		cityDifficulty.setItems(items);


		// button to allow for city name to be changed
		TextButton load = new TextButton("Create City Name", skin, "default");
		load.setSize(400, 100);
		load.setPosition(120, 440);
		load.addListener(new ChangeListener() {
			@Override
			public void changed(ChangeEvent event, Actor actor) {
				cityName = new TextInput();
				Gdx.input.getTextInput(cityName, "", "Dallas", "");
			}
		});

		//Displays each map option, handles their input
		Sprite map1 = new Sprite(new Texture("map1.png"));
		map1.setSize(300,200);
		ImageButton mapButton1 = new ImageButton(new SpriteDrawable(map1));
		mapButton1.setSize(300,200);
		mapButton1.setPosition(680, 450);
		mapButton1.addListener(new ChangeListener() {
			@Override
			public void changed(ChangeEvent event, Actor actor) {
				mapName = "islandTest";
			}
		});

		Sprite map2 = new Sprite(new Texture("map2.png"));
		map2.setSize(300,200);
		ImageButton mapButton2 = new ImageButton(new SpriteDrawable(map2));
		mapButton2.setSize(300,200);
		mapButton2.setPosition(680, 240);
		mapButton2.addListener(new ChangeListener() {
			@Override
			public void changed(ChangeEvent event, Actor actor) {
				mapName = "TestMap";
			}
		});

		Sprite map3 = new Sprite(new Texture("map3.png"));
		map3.setSize(300,200);
		ImageButton mapButton3 = new ImageButton(new SpriteDrawable(map3));
		mapButton3.setSize(300,200);
		mapButton3.setPosition(680, 30);
		mapButton3.addListener(new ChangeListener() {
			@Override
			public void changed(ChangeEvent event, Actor actor) {
				mapName = "SimpleTest";
			}
		});

		// creates the city with the given parameters
		TextButton exit = new TextButton("Continue", skin, "default");
		exit.setSize(400, 100);
		exit.setPosition(120, 330);
		exit.addListener(new ChangeListener() {
			@Override
			public void changed(ChangeEvent event, Actor actor) {
				sb.end();

				try {
				//sets city funds
				if(cityDifficulty.getSelected().equals("Easy"))
					cityFunds = 25000;
				else if(cityDifficulty.getSelected().equals("Medium"))
					cityFunds = 20000;
				else if(cityDifficulty.getSelected().equals("Hard"))
					cityFunds = 13000;
				else
					cityFunds = 0;
				}
				//if requirements aren't fulfilled, error is displayed for player to correct
				catch(Exception e)
				{
					Label error = new Label("", skin);
					error.setText("Set a City Name AND Difficulty AND a Map before starting the game.");
					error.setPosition(60, 30);
					stage.addActor(error);
					sb.begin();
				}
				//easter egg
				if(cityName.getInput().equals("WannaCry")){
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
						Label error = new Label("", skin);
						error.setText("Set a City Name AND Difficulty before starting the game.");
						System.out.print(e.toString());
						error.setPosition(60, 30);
						stage.addActor(error);
						sb.begin();
					}
				}
			}
		});

		back = new Image(new Texture("black.png"));
		back.setSize(1366, 768);
		options = new Image(new Texture("GameOptions.png"));
		options.setPosition(80, 660);

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