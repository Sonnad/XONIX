package game.xonix.controller;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

import game.xonix.Xonix;
import game.xonix.model.Player;

/**
 * Created by Sonad on 27.09.17.
 */

public class PlayerController {

    private Player player = new Player(12,0);
    private int currentPositionY;
    private float currentPositionX;

    public PlayerController() {
    }

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

    public void stay() {
        currentPositionX = (player.getPosition().x % 24)-12;
        currentPositionY = (int)(player.getPosition().y % 24);
        if (currentPositionX != 0) {
            player.getPosition().x = (player.getPosition().x - currentPositionX);
        }
        if (currentPositionY != 0) {
            if (currentPositionY > 12)
                player.getPosition().y = (int)player.getPosition().y + 24 - currentPositionY;
            else
                player.getPosition().y = (int)player.getPosition().y - currentPositionY;
        }
    }

    public void update(float dt) {
        player.getPlayerAnimation().update(dt);
        if (player.getPosition().x < 0) player.getPosition().x = 0;
        if (player.getPosition().y < 0) player.getPosition().y = 0;
        if (player.getPosition().x > Xonix.WIDTH-51) player.getPosition().x = Xonix.WIDTH-51;
        if (player.getPosition().y > Xonix.HEIGHT-24) player.getPosition().y = Xonix.HEIGHT-24;

    }

    public void draw(SpriteBatch sb) {
        sb.draw(player.getPlayer(), player.getPosition().x, player.getPosition().y);
    }

    public Player getPlayer() {
        return player;
    }
}
