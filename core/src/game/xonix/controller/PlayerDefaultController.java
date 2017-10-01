package game.xonix.controller;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

import game.xonix.Xonix;
import game.xonix.model.PlayerSingleton;

/**
 * Created by Sonad on 27.09.17.
 */

public class PlayerDefaultController {

    private PlayerSingleton player = PlayerSingleton.getInstance();
    private int currentPositionY;
    private float currentPositionX;


    public void runRight() {
        player.getPosition().x += player.getMovement() * Gdx.graphics.getDeltaTime();

    }

    public void runLeft() {
        player.getPosition().x -= player.getMovement() * Gdx.graphics.getDeltaTime();

    }

    public void runUp() {
        player.getPosition().y += player.getMovement() * Gdx.graphics.getDeltaTime();

    }

    public void runDown() {
        player.getPosition().y -= player.getMovement() * Gdx.graphics.getDeltaTime();

    }

    public void correctXPosition() {
        currentPositionX = (player.getPosition().x % 24)-12;
        if (currentPositionX != 0) {
            player.getPosition().x = (player.getPosition().x - currentPositionX);
        }
    }

    public void correctYPosition() {
        currentPositionY = (int)(player.getPosition().y % 24);
        if (currentPositionY != 0) {
            if (currentPositionY >= 12)
                player.getPosition().y = (int)player.getPosition().y + 24 - currentPositionY;
            else
                player.getPosition().y = (int)player.getPosition().y - currentPositionY;
        }
    }

    public void stay() {
        correctXPosition();
        correctYPosition();
    }

    public void update(float dt) {
        player.getPlayerAnimation().update(dt);
        if (player.getPosition().x < 12) player.getPosition().x = 12;
        if (player.getPosition().y < 0) player.getPosition().y = 0;
        if (player.getPosition().x > Xonix.WIDTH-51-11) player.getPosition().x = Xonix.WIDTH-51-11;
        if (player.getPosition().y > Xonix.HEIGHT-24) player.getPosition().y = Xonix.HEIGHT-24;
        player.getPlayerGround().setPosition(player.getPosition().x+24, player.getPosition().y+12);

    }

    public void draw(SpriteBatch sb) {
        sb.draw(player.getPlayer(), player.getPosition().x, player.getPosition().y);
    }

    public PlayerSingleton getPlayer() {
        return player;
    }
}