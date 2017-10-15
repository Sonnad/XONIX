package game.xonix.model;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector3;

/**
 * Created by Sonad on 16.10.17.
 */

public class UI {
    Texture texture;
    private Vector3 position;

    public UI(int x, int y, Texture texture) {
        position = new Vector3(x, y, 0);
        this.texture = texture;
    }

    public Vector3 getPosition() {
        return position;
    }

    public Texture getTexture() {
        return texture;
    }

    public void dispose() {
        texture.dispose();
    }
}
