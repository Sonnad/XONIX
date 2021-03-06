package game.xonix.view;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.utils.Array;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.ListIterator;

import game.xonix.Xonix;
import game.xonix.model.Ground;
import game.xonix.model.Wall;
/**
 * Created by Sonad on 19.09.17.
 */

public class DrawWall {
    private LinkedList<Wall> walls;

    public DrawWall() {
        walls = new LinkedList<Wall>();
        for (int i = 0; i < Xonix.WIDTH; i+=Xonix.SPRITESIZE) {
            for (int j = 0; j < Xonix.HEIGHT-48; j+=Xonix.SPRITESIZE) {
                //Рисуем границы игрового поля. Границы - 2 блока в высоту снизу/cверху  и 3 блока в ширину слева/справа
                //Проверяем, если координаты соответствуют описанному выше условию - рисуем стену
                if (i < Xonix.SPRITESIZE*3) {
                    walls.add(new Wall(i, j));
                    continue;
                }
                if (j < Xonix.SPRITESIZE*2) {
                    walls.add(new Wall(i, j));
                    continue;
                }

                if (i >= Xonix.WIDTH-Xonix.SPRITESIZE*3)
                {
                    walls.add(new Wall(i, j));
                    continue;
                }

                if (j >= Xonix.HEIGHT-Xonix.SPRITESIZE*4) {
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

    public void deleteDuplicate() {
        Iterator<Wall> firstIter = walls.iterator();
        while (firstIter.hasNext()) {
            Wall duplicateWall = firstIter.next();
            Iterator<Wall> secondIter = walls.iterator();
            secondIter.next();
            while (secondIter.hasNext()) {
                Wall wall = secondIter.next();
                if (duplicateWall == wall) continue;
                if (wall.equals(duplicateWall)) {
                    firstIter.remove();
                    break;
                }
            }
        }
    }

    public LinkedList<Wall> getWalls() {
        return walls;
    }

    public void dispose() {
        for (Wall wall : walls) {
            wall.dispose();
        }
    }

}
