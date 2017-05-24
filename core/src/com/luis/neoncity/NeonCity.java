/*
@author Luis Najera
5/9/17
 */
package com.luis.neoncity;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.audio.Music;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.luis.neoncity.Screens.MainMenu;

/**
 * Created by the Desktop & Android launcher
 * Initializes the game
 */
public class NeonCity extends Game {
	//Width and Height all gameCameras
	public static final int V_WIDTH = 1280;
	public static final int V_HEIGHT = 720;
	//batch to be rendered
	public SpriteBatch batch;

	@Override
	public void create () {
		//Starts some a e s t h e t i c   m u s i c
		Music music = Gdx.audio.newMusic(Gdx.files.internal("song.mp3"));
		//begins playing the song
		music.play();
		//l o o p
		music.setLooping(true);

		//initializes the sprite batch
		batch = new SpriteBatch();

		//creates the main menu and sets it as the current state
		setScreen(new MainMenu(this, batch));
	}

	@Override
	public void render () {
		super.render();
	}
}