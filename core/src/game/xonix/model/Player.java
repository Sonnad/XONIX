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
    public static final int MOVEMENT = 250;
    private Animation playerAnimation;
    private int currentPositionY;
    private float currentPositionX;

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

    public void runRight() {
            position.x += MOVEMENT * Gdx.graphics.getDeltaTime();

    }

    public void runLeft() {
            position.x -= MOVEMENT * Gdx.graphics.getDeltaTime();

    }

    public void runUp() {
        position.y += MOVEMENT * Gdx.graphics.getDeltaTime();

    }

    public void runDown() {
        position.y -= MOVEMENT * Gdx.graphics.getDeltaTime();

    }

    public void stay() {
        currentPositionX = (position.x % 24)-12;
        currentPositionY = (int)(position.y % 24);
        if (currentPositionX != 0) {
            position.x = (position.x - currentPositionX);
        }
        if (currentPositionY != 0) {
            if (currentPositionY > 12)
                position.y = (int)position.y + 24 - currentPositionY;
             else
                 position.y = (int)position.y - currentPositionY;
        }
    }

    public void update(float dt) {
        playerAnimation.update(dt);
        if (position.x < 0) position.x = 0;
        if (position.y < 0) position.y = 0;
        if (position.x > Xonix.WIDTH-51) position.x = Xonix.WIDTH-51;
        if (position.y > Xonix.HEIGHT-24) position.y = Xonix.HEIGHT-24;

    }


}
