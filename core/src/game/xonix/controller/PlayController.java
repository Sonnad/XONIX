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
    private Player player;

    public PlayController(GameControllerManager gsm) {
        super(gsm);
        drawWall = new DrawWall();
        background = new Background();
        player = new Player(12,0);
    }

    @Override
    protected void handleInput() {
        if(Gdx.input.isKeyPressed(Input.Keys.UP)) {
            player.runUp();
            return;
        }
        if(Gdx.input.isKeyPressed(Input.Keys.DOWN)) {
            player.runDown();
            return;
        }
        if(Gdx.input.isKeyPressed(Input.Keys.LEFT)) {
            player.runLeft();
            return;
        }
        if(Gdx.input.isKeyPressed(Input.Keys.RIGHT)) {
            player.runRight();
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
        sb.draw(player.getPlayer(), player.getPosition().x, player.getPosition().y);
        sb.end();
    }

    @Override
    public void dispose() {
    }

}
