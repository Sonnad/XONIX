package game.xonix.desktop;

import com.badlogic.gdx.backends.lwjgl.LwjglApplication;
import com.badlogic.gdx.backends.lwjgl.LwjglApplicationConfiguration;
import game.xonix.Xonix;

public class DesktopLauncher {
	public static void main (String[] arg) {
		LwjglApplicationConfiguration config = new LwjglApplicationConfiguration();
		new LwjglApplication(new Xonix(), config);
		config.height = Xonix.HEIGHT;
		config.width = Xonix.WIDTH;
		config.title = Xonix.TITLE;
		config.resizable = false;
	}
}
