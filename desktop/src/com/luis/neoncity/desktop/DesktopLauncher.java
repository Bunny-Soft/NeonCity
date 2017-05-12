package com.luis.neoncity.desktop;

import com.badlogic.gdx.backends.lwjgl.LwjglApplication;
import com.badlogic.gdx.backends.lwjgl.LwjglApplicationConfiguration;
import com.luis.neoncity.NeonCity;

public class DesktopLauncher {
	public static void main (String[] arg) {
		LwjglApplicationConfiguration config = new LwjglApplicationConfiguration();
		config.title = "NeonCity";
		config.width = 1366;
		config.height = 768;
		new LwjglApplication(new NeonCity(), config);
	}
}
