package game.xonix.model;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector3;

/**
 * Created by Sonad on 19.09.17.
 */

public class Wall {
    Texture wall;
    private Vector3 position;
    private Rectangle boundsWall;

    public Wall(float x, float y) {
        position = new Vector3(x, y, 0);
        wall = new Texture("crate_2.png");
        boundsWall = new Rectangle(position.x, position.y, wall.getWidth(), wall.getHeight());
    }

    public Vector3 getPosition() {
        return position;
    }

    public Texture getWall() {
        return wall;
    }

    public Rectangle getBoundsWall() {
        return boundsWall;
    }

    public void dispose() {
        wall.dispose();
    }

}
