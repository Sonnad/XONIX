package game.xonix.controller.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

import game.xonix.controller.Controller;
import game.xonix.controller.Direction;
import game.xonix.controller.GameControllerManager;
import game.xonix.controller.PlayerController;
import game.xonix.controller.player.*;
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
    private Direction lastKeyPressed;
    private boolean wasCollision = false;

    public PlayController(GameControllerManager gsm) {
        super(gsm);
        drawWall = new DrawWall();
        background = new Background();
        player = new PlayerDefaultController();
        collisionController = new FieldCollisionController(drawWall.getWalls(), background.getBackground());
    }

    @Override
    protected void handleInput() {
        if(Gdx.input.isKeyPressed(Input.Keys.UP)) {
            player.runUp();
            lastKeyPressed = Direction.UP;
            return;
        }
        if(Gdx.input.isKeyPressed(Input.Keys.DOWN)) {
            player.runDown();
            lastKeyPressed = Direction.DOWN;
            return;
        }
        if(Gdx.input.isKeyPressed(Input.Keys.LEFT)) {
            player.runLeft();
            lastKeyPressed = Direction.LEFT;
            return;
        }
        if(Gdx.input.isKeyPressed(Input.Keys.RIGHT)) {
            player.runRight();
            lastKeyPressed = Direction.RIGHT;
            return;
        }
        player.keyIsNotPressed();
    }


    @Override
    public void update(float dt) {
        handleInput();
        player.update(dt);
        if(collisionController.isFieldCollision()) {
            player = new PlayerCollisionController(lastKeyPressed);
            wasCollision = true;
        }
        else
            if(wasCollision) player = new PlayerDefaultController();


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
