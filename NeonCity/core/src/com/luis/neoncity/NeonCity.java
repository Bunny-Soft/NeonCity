/*
@author Luis Najera
5/9/17
 */
package com.luis.neoncity;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.luis.neoncity.Screens.PlayScreen;

public class NeonCity extends Game {
	public static final int V_WIDTH = 800;
	public static final int V_HEIGHT = 480;
	public SpriteBatch batch;

	@Override
	public void create () {
		batch = new SpriteBatch();
		setScreen(new PlayScreen(this));
	}

	@Override
	public void render () {
		super.render();
	}
}