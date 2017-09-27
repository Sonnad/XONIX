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

    public Ground(int x, int y) {
        position = new Vector3(x, y, 0);
        ground = new Texture("ground_2.png");
        boundsGround = new Rectangle(position.x, position.y, ground.getWidth(), ground.getHeight());
    }

    public Vector3 getPosition() {
        return position;
    }

    public Texture getGround() {
        return ground;
    }

}
