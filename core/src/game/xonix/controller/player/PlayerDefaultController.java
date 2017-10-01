package game.xonix.controller.player;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

import game.xonix.controller.PlayerController;
import game.xonix.model.PlayerSingleton;
import game.xonix.view.PlayerView;

/**
 * Created by Sonad on 27.09.17.
 */

public class PlayerDefaultController implements PlayerController {

    private PlayerSingleton player = PlayerSingleton.getInstance();
    private PlayerView playerView;
    private CorrectPosition correctPosition;

    public PlayerDefaultController() {
        playerView = new PlayerView();
        correctPosition = new CorrectPosition();
    }

    public void runRight() {
        correctPosition.correctYPosition();
        player.getPosition().x += player.getMovement() * Gdx.graphics.getDeltaTime();

    }

    public void runLeft() {
        correctPosition.correctYPosition();
        player.getPosition().x -= player.getMovement() * Gdx.graphics.getDeltaTime();

    }

    public void runUp() {
        correctPosition.correctXPosition();
        player.getPosition().y += player.getMovement() * Gdx.graphics.getDeltaTime();
    }

    public void runDown() {
        correctPosition.correctXPosition();
        player.getPosition().y -= player.getMovement() * Gdx.graphics.getDeltaTime();
    }



    @Override
    public void keyIsNotPressed() {
        correctPosition.correctXPosition();
        correctPosition.correctYPosition();
    }

    @Override
    public void update(float dt) {
        playerView.view(dt);
    }

    @Override
    public void draw(SpriteBatch sb) {
        sb.draw(player.getPlayer(), player.getPosition().x, player.getPosition().y);
    }

    @Override
    public PlayerSingleton getPlayer() {
        return player;
    }

}