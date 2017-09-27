package game.xonix.model;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector3;

import game.xonix.Xonix;
import game.xonix.view.Animation;

/**
 * Created by Sonad on 21.09.17.
 */

public class Player {

    private Vector3 position;
    private Rectangle playerGround;
    public final int MOVEMENT = 250;
    private Animation playerAnimation;

    public Player(int x, int y) {
        position = new Vector3(x, y, 0);
//        playerGround = new Rectangle(position.x, position.y, player.getWidth(), player.getHeight());
        playerAnimation = new Animation(0.45f);
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

}
