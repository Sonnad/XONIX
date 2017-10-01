package game.xonix;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

import game.xonix.controller.GameControllerManager;
import game.xonix.controller.game.MenuController;

public class Xonix extends ApplicationAdapter {
	public static final int WIDTH = 1200;
	public static final int HEIGHT = 912;
	public static final String TITLE = "XONIX";
	public static final int SPRITESIZE = 24;

	private GameControllerManager grm;
	private SpriteBatch batch;


	@Override
	public void create () {
		batch = new SpriteBatch();
		grm = new GameControllerManager();
		Gdx.gl.glClearColor(1, 0, 0, 1);
		grm.push(new MenuController(grm));
	}

	@Override
	public void render () {
		Gdx.gl.glClearColor(1, 0, 0, 1);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
		grm.update(Gdx.graphics.getDeltaTime());
		grm.render(batch);
	}

	@Override
	public void dispose () {
		batch.dispose();
	}

}
