package game.xonix.controller;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.audio.Music;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

import game.xonix.model.Player;
import game.xonix.view.Background;
import game.xonix.view.DrawWall;

/**
 * Created by Sonad on 26.09.17.
 */

public class PlayController extends Controller {
    private Background background;
    private DrawWall drawWall;
    private PlayerController player;
    private boolean leftIsPressed = false;
    private boolean rightIsPressed = false;

    public PlayController(GameControllerManager gsm) {
        super(gsm);
        drawWall = new DrawWall();
        background = new Background();
        player = new PlayerController();
    }

    @Override
    protected void handleInput() {
        if(Gdx.input.isKeyPressed(Input.Keys.UP)) {
            player.runUp();
            player.correctXPosition();
            return;
        }
        if(Gdx.input.isKeyPressed(Input.Keys.DOWN)) {
            player.runDown();
            player.correctXPosition();
            return;
        }
        if(Gdx.input.isKeyPressed(Input.Keys.LEFT)) {
            player.runLeft();
            player.correctYPosition();
            return;
        }
        if(Gdx.input.isKeyPressed(Input.Keys.RIGHT)) {
            player.runRight();
            player.correctYPosition();
            return;
        }
        player.stay();
    }


        @Override
    public void update(float dt) {
        handleInput();
        player.update(dt);
    }

    @Override
    public void render(SpriteBatch sb) {
        sb.begin();
        background.render(sb);
        drawWall.render(sb);
        player.draw(sb);
        sb.end();
    }

    @Override
    public void dispose() {
    }

}
