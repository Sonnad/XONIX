package game.xonix.view;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.utils.Array;

import game.xonix.Xonix;
import game.xonix.model.Ground;
import game.xonix.model.Wall;

/**
 * Created by Sonad on 19.09.17.
 */

public class Background {
    private Array<Ground> background;

    public Background() {
        background = new Array<Ground>();
        for (int i = 0; i < Xonix.WIDTH; i+=Xonix.SPRITESIZE) {
            for (int j = 0; j < Xonix.HEIGHT; j+=Xonix.SPRITESIZE) {
                background.add(new Ground(i, j));
            }
        }
    }

    public void render(SpriteBatch sb) {
        for (Ground ground : background) {
            sb.draw(ground.getGround(), ground.getPosition().x, ground.getPosition().y);
        }
    }

}
