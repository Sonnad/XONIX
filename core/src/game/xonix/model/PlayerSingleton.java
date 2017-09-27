package game.xonix.model;

import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector3;

import game.xonix.view.Animation;

/**
 * Created by Sonad on 21.09.17.
 */

public class PlayerSingleton {

    private Vector3 position;
    private Rectangle playerGround;
    private final int MOVEMENT = 250;
    private Animation playerAnimation;

    private PlayerSingleton(int x, int y) {
        position = new Vector3(x, y, 0);
        playerGround = new Rectangle(36, 12, 1 , 1);
        playerAnimation = new Animation(0.45f);
    }

    private static PlayerSingleton instance;

    public static synchronized PlayerSingleton getInstance() {
        if (instance == null) {
            instance = new PlayerSingleton(12,0);
        }
        return instance;
    }

    public Vector3 getPosition() {
        return position;
    }

    public TextureRegion getPlayer() {

        return playerAnimation.getFrame();
    }

    public int getMovement() {
        return MOVEMENT;
    }

    public Animation getPlayerAnimation() {
        return playerAnimation;
    }

    public Rectangle getPlayerGround() {
        return playerGround;
    }
}
