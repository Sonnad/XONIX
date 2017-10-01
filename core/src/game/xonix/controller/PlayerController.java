package game.xonix.controller;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;

import game.xonix.model.PlayerSingleton;

/**
 * Created by Sonad on 01.10.17.
 */

public interface PlayerController {

    public void update(float dt);

    public PlayerSingleton getPlayer();

    public void draw(SpriteBatch sb);

}
