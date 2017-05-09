package com.luis.neoncity;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class NeonCity extends ApplicationAdapter {
	SpriteBatch batch;
	Texture img, menu;

	@Override
	public void create () {
		batch = new SpriteBatch();
		img = new Texture("8bitCity.png");
		menu = new Texture("menu.png");
	}

	@Override
	public void render () {
		//Gdx.gl.glClearColor(1, 0, 0, 1);
		//Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

		batch.begin();
		batch.draw(img, 0, 0, 1440, 900);
		batch.draw(menu, 50, 600);
		batch.end();
	}

	@Override
	public void dispose () {
		batch.dispose();
	}
}