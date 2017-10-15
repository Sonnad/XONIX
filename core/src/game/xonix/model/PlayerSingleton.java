package game.xonix.model;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.audio.Sound;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector3;
import com.badlogic.gdx.utils.Array;

import game.xonix.view.Animation;

/**
 * Created by Sonad on 21.09.17.
 */

public class PlayerSingleton {

    private Vector3 position;
    private Rectangle playerGround;
    private final int MOVEMENT = 250;
    private Animation playerAnimation;
    private Sound deathSound;

    private PlayerSingleton(int x, int y) {
        position = new Vector3(x, y, 0);
        playerGround = new Rectangle(36, 12, 1 , 1);
        Array<TextureRegion> frames = new Array<TextureRegion>();
        frames.add(new TextureRegion(new Texture("anim2.png")));
        frames.add(new TextureRegion(new Texture("anim3.png")));
        frames.add(new TextureRegion(new Texture("anim4.png")));
        frames.add(new TextureRegion(new Texture("anim3.png")));
        playerAnimation = new Animation(0.45f, frames, 4);
        deathSound = Gdx.audio.newSound(Gdx.files.internal("deathSound.mp3"));

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

    public void kill() {
        position.x = 12;
        position.y = 0;
        deathSound.play();
        playerGround.setPosition(position.x, position.y);

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
