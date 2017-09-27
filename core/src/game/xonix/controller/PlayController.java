package game.xonix.controller;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

import game.xonix.view.Background;
import game.xonix.view.DrawWall;

/**
 * Created by Sonad on 26.09.17.
 */

public class PlayController extends Controller {
    private Background background;
    private DrawWall drawWall;
    private PlayerController player;
    private FieldCollisionController collisionController;
    private boolean backgroundDrawed = false;

    public PlayController(GameControllerManager gsm) {
        super(gsm);
        drawWall = new DrawWall();
        background = new Background();
        player = new PlayerController();
        collisionController = new FieldCollisionController(drawWall.getWalls(), background.getBackground());
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
        collisionController.update();
    }

    @Override
    public void render(SpriteBatch sb) {
        sb.begin();
        if(!backgroundDrawed) background.render(sb);
        drawWall.render(sb);
        player.draw(sb);
        sb.end();
    }

    @Override
    public void dispose() {
    }

}
