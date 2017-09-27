package game.xonix.controller;

import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector3;

/**
 * Created by Sonad on 18.09.17.
 */

public abstract class Controller {
    protected OrthographicCamera camera;
    protected Vector3 mouse;
    protected GameControllerManager grm;

    public Controller(GameControllerManager grm) {
        this.grm = grm;
        camera = new OrthographicCamera();
        mouse = new Vector3();
    }

    protected abstract void handleInput();
    public abstract void update(float dt);
    public abstract void render(SpriteBatch sb);
    public abstract void dispose();

}
