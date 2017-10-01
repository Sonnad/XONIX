package game.xonix.controller;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;

import game.xonix.model.PlayerSingleton;

/**
 * Created by Sonad on 01.10.17.
 */

public class PlayerCollisionController implements PlayerController {
    private PlayerSingleton player = PlayerSingleton.getInstance();

    @Override
    public void update(float dt) {

    }

    @Override
    public PlayerSingleton getPlayer() {
        return player;
    }

    @Override
    public void draw(SpriteBatch sb) {

    }
}
