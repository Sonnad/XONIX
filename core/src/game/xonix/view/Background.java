package game.xonix.view;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.utils.Array;

import java.util.LinkedList;

import game.xonix.Xonix;
import game.xonix.model.Ground;
import game.xonix.model.Wall;

/**
 * Created by Sonad on 19.09.17.
 */

public class Background {
    private LinkedList<Ground> background;

    public Background() {
        background = new LinkedList<Ground>();
        for (int i = 0; i < Xonix.WIDTH; i+=Xonix.SPRITESIZE) {
            for (int j = 0; j < Xonix.HEIGHT-48; j+=Xonix.SPRITESIZE) {
                background.add(new Ground(i, j, isGameField(i, j)));
            }
        }
    }

    private boolean isGameField(int i, int j) {

        //При отрисовки игрового поля блоки, находящиеся под стартовыми стенами не должны иметь прямоугольника для коллизии
        if (i < Xonix.SPRITESIZE*3) {
            return false;
        }
        if (j < Xonix.SPRITESIZE*2) {
            return false;
        }

        if (i >= Xonix.WIDTH-Xonix.SPRITESIZE*3)
        {
            return false;
        }

        if (j >= Xonix.HEIGHT-Xonix.SPRITESIZE*4) {
            return false;
        }

        return true;
    }

    public void render(SpriteBatch sb) {
        for (Ground ground : background) {
            sb.draw(ground.getGround(), ground.getPosition().x, ground.getPosition().y);
        }
    }

    public LinkedList<Ground> getBackground() {
        return background;
    }

    public void dispose() {
        for (Ground ground : background) {
            ground.dispose();
        }
    }

}
