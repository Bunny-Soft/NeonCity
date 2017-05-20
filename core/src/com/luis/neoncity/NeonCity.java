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

public class NeonCity extends Game {
	public static final int V_WIDTH = 1280;
	public static final int V_HEIGHT = 720;
	public SpriteBatch batch;

	@Override
	public void create () {
		Music music = Gdx.audio.newMusic(Gdx.files.internal("song.mp3"));
		music.play();
		music.setLooping(true);

		batch = new SpriteBatch();
		setScreen(new MainMenu(this, batch));
	}

	@Override
	public void render () {
		super.render();
	}
}