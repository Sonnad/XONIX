package game.xonix.controller.enemy;

import com.badlogic.gdx.math.Rectangle;

import java.util.ArrayList;
import java.util.LinkedList;

import game.xonix.Xonix;
import game.xonix.model.Enemy;
import game.xonix.model.Wall;


/**
 * Created by Sonad on 01.10.17.
 */

public class EnemyController {
    private ArrayList<Enemy> enemyList;
    private LinkedList<Wall> walls;

    public EnemyController(LinkedList<Wall> walls, int enemyCount) {
        enemyList = new ArrayList<Enemy>();
        this.walls = walls;
        for (int i = 0; i < enemyCount; i++) {
            createEnemy();
        }

    }

    public void createEnemy() {
//        Рандом по заданному диапазону
//         =  Min + (int)(Math.random() * ((Max - Min) + 1))
        int x  = (int) (Math.random() * ((Xonix.WIDTH - Xonix.SPRITESIZE * 5) - (Xonix.SPRITESIZE * 5)) + 1) + Xonix.SPRITESIZE * 5;
        int y  = (int) (Math.random() * ((Xonix.HEIGHT- Xonix.SPRITESIZE * 4) - (Xonix.SPRITESIZE * 4)) + 1) + Xonix.SPRITESIZE * 4;
        enemyList.add(new Enemy(x, y));
    }

    public ArrayList<Enemy> getEnemyList() {
        return enemyList;
    }

    public void update(float dt) {
        for (Enemy enemy : enemyList) {
            for (Wall wall : walls) {
                changeDirection(enemy, wall, dt);
            }
            enemy.update(dt);
        }


    }

    private void changeDirection(Enemy enemy, Wall wall, float dt) {
        if (new Rectangle(enemy.getPosition().x+(enemy.getDx() * dt), enemy.getPosition().y, 24, 25).overlaps(wall.getBoundsWall())) {
            enemy.setDx(-enemy.getDx());
        }
        if (new Rectangle(enemy.getPosition().x, enemy.getPosition().y+(enemy.getDy() * dt), 24, 25).overlaps(wall.getBoundsWall())) {
            enemy.setDy(-enemy.getDy());
        }
    }

}