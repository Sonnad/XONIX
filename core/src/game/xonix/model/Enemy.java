package game.xonix.model;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector3;
import com.badlogic.gdx.utils.Array;

import java.util.Random;

import game.xonix.Xonix;
import game.xonix.view.Animation;

/**
 * Created by Sonad on 01.10.17.
 */

public class Enemy {

    private Vector3 position;
    private Rectangle boundsEnemy;
    private final int MOVEMENT = 150;
    private Animation playerAnimation;
    Random random;
    private int dx;
    private int dy;

    public Enemy(int x, int y) {
        random = new Random();
        position = new Vector3(x, y, 0);
        boundsEnemy = new Rectangle(x, y, 24 , 25);
        dy = random.nextBoolean()? MOVEMENT : -MOVEMENT;
        dx = random.nextBoolean()? MOVEMENT : -MOVEMENT;
        Array<TextureRegion> frames = new Array<TextureRegion>();
        frames.add(new TextureRegion(new Texture("enemy_1.png")));
        frames.add(new TextureRegion(new Texture("enemy_2.png")));
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


    public void move() {
        position.y += dy * Gdx.graphics.getDeltaTime();
        position.x += dx * Gdx.graphics.getDeltaTime();
    }


    public void update(float dt) {
        move();
        boundsEnemy.setPosition(position.x, position.y);
        playerAnimation.update(dt);
    }

    public int getDx() {
        return dx;
    }

    public int getDy() {
        return dy;
    }

    public void setDx(int dx) {
        this.dx = dx;
    }

    public void setDy(int dy) {
        this.dy = dy;
    }


}
