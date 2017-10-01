package game.xonix.controller.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

import game.xonix.controller.Controller;
import game.xonix.controller.Direction;
import game.xonix.controller.GameControllerManager;
import game.xonix.controller.PlayerController;
import game.xonix.controller.player.*;
import game.xonix.model.Enemy;
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
    private Enemy enemy;

    public PlayController(GameControllerManager gsm) {
        super(gsm);
        enemy = new Enemy(700, 500);
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
        enemy.update(dt);
        player.update(dt);
        if(collisionController.isFieldCollision()) {
            if (!wasCollision)
                player = new PlayerCollisionController(lastKeyPressed);
            wasCollision = true;
        }
        else
            if(wasCollision) {
                player = new PlayerDefaultController();
                wasCollision = false;
            }


    }

    @Override
    public void render(SpriteBatch sb) {
        sb.begin();
        if(!backgroundDrawed) background.render(sb);
        drawWall.render(sb);
        player.draw(sb);
        enemy.draw(sb);
        sb.end();
    }

    @Override
    public void dispose() {
    }

}
