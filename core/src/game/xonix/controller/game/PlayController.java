package game.xonix.controller.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

import game.xonix.controller.Controller;
import game.xonix.controller.Direction;
import game.xonix.controller.GameControllerManager;
import game.xonix.controller.PlayerController;
import game.xonix.controller.enemy.EnemyController;
import game.xonix.controller.player.*;
import game.xonix.model.Enemy;
import game.xonix.model.PlayerSingleton;
import game.xonix.view.Background;
import game.xonix.view.DrawUI;
import game.xonix.view.DrawWall;

/**
 * Created by Sonad on 26.09.17.
 */

public class PlayController extends Controller {
    private Background background;
    private DrawWall drawWall;
    private PlayerController player;
    private FieldCollisionController collisionController;
    private Direction lastKeyPressed;
    private boolean wasCollision = false;
    private EnemyController enemyController;
    private FillController fillController;
    private DrawUI ui;
    GameControllerManager gsm;

    public PlayController(GameControllerManager gsm) {
        super(gsm);
        this.gsm = gsm;
        drawWall = new DrawWall();
        background = new Background();
        enemyController = new EnemyController(background.getBackground() , drawWall.getWalls(), 10);
        player = new PlayerDefaultController();
        collisionController = new FieldCollisionController(drawWall.getWalls(), background.getBackground());
        fillController = new FillController(drawWall.getWalls(), background, enemyController.getEnemyList());
        ui = new DrawUI();
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
        enemyController.update(dt, collisionController.getNewWall());
        if (PlayerSingleton.getInstance().isDead()) {
            gsm.set(new GameOverController(gsm, background, drawWall, enemyController, ui, collisionController.getNewWall()));
        }
        if(collisionController.isFieldCollision()) {
            if (!wasCollision)
                player = new PlayerCollisionController(lastKeyPressed);
            wasCollision = true;
        }
        else
            if(wasCollision) {
                if (!enemyController.isPlayerCollision()) {
                    collisionController.clearGround();
                    long timer = -System.currentTimeMillis();
                    fillController.tryToFill();
                    timer += System.currentTimeMillis();
                    System.out.println("C.m(fillController.tryToFill()) " + timer);
                }
                enemyController.setPlayerCollision(false);
                player = new PlayerDefaultController();
                collisionController.clear();
                wasCollision = false;
            }
    }

    @Override
    public void render(SpriteBatch sb) {
        sb.begin();
        background.render(sb);
        drawWall.render(sb);
        player.draw(sb);
        ui.render(sb);
        for (Enemy enemy : enemyController.getEnemyList()) {
            enemy.draw(sb);
        }
        sb.end();
    }

    @Override
    public void dispose() {
        if (!PlayerSingleton.getInstance().isDead()) {
            background.dispose();
            drawWall.dispose();
            ui.dispose();
        }
    }

}
