package game.xonix.controller.player;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

import game.xonix.controller.Direction;
import game.xonix.controller.PlayerController;
import game.xonix.model.PlayerSingleton;
import game.xonix.view.PlayerView;

/**
 * Created by Sonad on 01.10.17.
 */

public class PlayerCollisionController implements PlayerController {

    private PlayerSingleton player = PlayerSingleton.getInstance();
    private PlayerView playerView;
    private Direction lastKeyPressed;
    private CorrectPosition correctPosition;

    public PlayerCollisionController(Direction lastKeyPressed) {
        this.lastKeyPressed = lastKeyPressed;
        playerView = new PlayerView();
        correctPosition = new CorrectPosition();
    }

    public void move() {
        switch (lastKeyPressed) {
            case UP: {
                correctPosition.correctXPosition();
                player.getPosition().y += player.getMovement() * Gdx.graphics.getDeltaTime();
                break;
            }
            case DOWN: {
                correctPosition.correctXPosition();
                player.getPosition().y -= player.getMovement() * Gdx.graphics.getDeltaTime();
                break;
            }
            case LEFT: {
                correctPosition.correctYPosition();
                player.getPosition().x -= player.getMovement() * Gdx.graphics.getDeltaTime();
                break;
            }
            case RIGHT: {
                correctPosition.correctYPosition();
                player.getPosition().x += player.getMovement() * Gdx.graphics.getDeltaTime();
                break;
            }
        }
    }

    @Override
    public void runUp() {

    }

    @Override
    public void runDown() {

    }

    @Override
    public void runLeft() {

    }

    @Override
    public void runRight() {

    }


    @Override
    public void update(float dt) {
        move();
        playerView.view(dt);

    }

    @Override
    public PlayerSingleton getPlayer() {
        return player;
    }

    @Override
    public void draw(SpriteBatch sb) {
        sb.draw(player.getPlayer(), player.getPosition().x, player.getPosition().y);
    }

    @Override
    public void keyIsNotPressed() {

    }
}
