package com.luis.neoncity.desktop;

import com.badlogic.gdx.Files;
import com.badlogic.gdx.backends.lwjgl.LwjglApplication;
import com.badlogic.gdx.backends.lwjgl.LwjglApplicationConfiguration;
import com.luis.neoncity.NeonCity;

/**
 * Handles launching on desktop
 */
public class DesktopLauncher {
	public static void main (String[] arg) {
		//creates the window configuration
		LwjglApplicationConfiguration config = new LwjglApplicationConfiguration();

		//adds a e s t h e t i c icons to the game
		config.addIcon("icon256.jpg", Files.FileType.Internal);
		config.addIcon("icon64.jpg", Files.FileType.Internal);
		config.addIcon("icon32.jpg", Files.FileType.Internal);

		//Sets the window title
		config.title = "N e o n C i t y";

		//makes the window un-resizeable
		config.resizable = false;

		//sets the windows width and height
		config.width = 1366;
		config.height = 768;

		//Creates the window with our configuration, loads our game onto the window
		new LwjglApplication(new NeonCity(), config);
	}
}
