package game.xonix.view;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.utils.Array;

import game.xonix.Xonix;
import game.xonix.model.Ground;
import game.xonix.model.Wall;
/**
 * Created by Sonad on 19.09.17.
 */

public class DrawWall {
    private Array<Wall> walls;

    public DrawWall() {
        walls = new Array<Wall>();
        for (int i = 0; i < Xonix.WIDTH; i+=Xonix.SPRITESIZE) {
            for (int j = 0; j < Xonix.HEIGHT; j+=Xonix.SPRITESIZE) {
                if (i < Xonix.SPRITESIZE*3) {
                    walls.add(new Wall(i, j));
                    continue;
                }
                if (j < Xonix.SPRITESIZE*3) {
                    walls.add(new Wall(i, j));
                    continue;
                }

                if (i >= Xonix.WIDTH-Xonix.SPRITESIZE*3)
                {
                    walls.add(new Wall(i, j));
                    continue;
                }

                if (j >= Xonix.HEIGHT-Xonix.SPRITESIZE*3) {
                    walls.add(new Wall(i, j));
                    continue;
                }



            }
        }
    }



    public void render(SpriteBatch sb) {
        for (Wall wall : walls) {
            sb.draw(wall.getWall(), wall.getPosition().x, wall.getPosition().y);
        }

    }
}
