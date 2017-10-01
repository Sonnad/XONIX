package game.xonix.model;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector3;
import com.badlogic.gdx.utils.Array;

import game.xonix.view.Animation;

/**
 * Created by Sonad on 01.10.17.
 */

public class Enemy {

    private Vector3 position;
    private Rectangle boundsEnemy;
    private final int MOVEMENT = 250;
    private Animation playerAnimation;

    public Enemy(int x, int y) {
        position = new Vector3(x, y, 0);
        boundsEnemy = new Rectangle(700, 500, 1 , 1);
        Array<TextureRegion> frames = new Array<TextureRegion>();
        frames.add(new TextureRegion(new Texture("enemy_1.png")));
        frames.add(new TextureRegion(new Texture("enemy_2.png")));;
        playerAnimation = new Animation(0.4f, frames, 2);
    }

    public Vector3 getPosition() {
        return position;
    }

    public TextureRegion getEnemy() {

        return playerAnimation.getFrame();
    }

    public int getMovement() {
        return MOVEMENT;
    }

    public Animation getPlayerAnimation() {
        return playerAnimation;
    }

    public Rectangle getBoundsEnemy() {
        return boundsEnemy;
    }

    public void draw(SpriteBatch sb) {
        sb.draw(getEnemy(), getPosition().x, getPosition().y);
    }

    public void update(float dt) {
        playerAnimation.update(dt);
    }

}
