package game.xonix.model;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector3;

/**
 * Created by Sonad on 19.09.17.
 */

public class Ground {
    Texture ground;
    private Vector3 position;
    private Rectangle boundsGround;

    public Ground(int x, int y, boolean isGameField) {
        position = new Vector3(x, y, 0);
        ground = new Texture("ground_2.png");
        if(isGameField) boundsGround = new Rectangle(position.x, position.y, ground.getWidth(), ground.getHeight());
    }

    public Vector3 getPosition() {
        return position;
    }

    public Texture getGround() {
        return ground;
    }

    public Rectangle getBoundsGround() {
        return boundsGround;
    }

    public void deleteBoundsGround() {
        boundsGround = null;
    }

    public void restoreBounds(int x, int y) {
        boundsGround = new Rectangle(x, y, ground.getWidth(), ground.getHeight());
    }

    public void dispose() {
        ground.dispose();
    }

}
