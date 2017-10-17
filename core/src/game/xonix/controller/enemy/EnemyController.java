package game.xonix.controller.enemy;

import com.badlogic.gdx.math.Rectangle;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;

import game.xonix.Xonix;
import game.xonix.model.Enemy;
import game.xonix.model.Ground;
import game.xonix.model.PlayerSingleton;
import game.xonix.model.Wall;


/**
 * Created by Sonad on 01.10.17.
 */

public class EnemyController {
    private ArrayList<Enemy> enemyList;
    private LinkedList<Wall> walls;
    private LinkedList<Ground> groundList;
    private PlayerSingleton player = PlayerSingleton.getInstance();
    private boolean playerCollision = false;

    public EnemyController(LinkedList<Ground> groundList, LinkedList<Wall> walls, int enemyCount) {
        enemyList = new ArrayList<Enemy>();
        this.walls = walls;
        this.groundList = groundList;
        for (int i = 0; i < enemyCount; i++) {
            createEnemy();
        }

    }

    public void createEnemy() {
//        Рандом по заданному диапазону
//         =  Min + (int)(Math.random() * ((Max - Min) + 1))
        int x  = (int) (Math.random() * ((Xonix.WIDTH - Xonix.SPRITESIZE * 5) - (Xonix.SPRITESIZE * 5)) + 1) + Xonix.SPRITESIZE * 5;
        int y  = (int) (Math.random() * ((Xonix.HEIGHT- Xonix.SPRITESIZE * 6) - (Xonix.SPRITESIZE * 4)) + 1) + Xonix.SPRITESIZE * 4;
        enemyList.add(new Enemy(x, y));
    }

    public ArrayList<Enemy> getEnemyList() {
        return enemyList;
    }

    public boolean isPlayerCollision() {
        return playerCollision;
    }

    public void setPlayerCollision(boolean playerCollision) {
        this.playerCollision = playerCollision;
    }

    public void update(float dt, LinkedList<Wall> newWall) {
        for (Enemy enemy : enemyList) {
            for (Wall wall : walls) {
                if (changeDirection(enemy, wall, dt)) {
                    if (contains(newWall, wall)) {
                        playerCollision = true;
                        collisionWithPlayerWall(newWall);
                        break;
                    }
                }
            }
            enemy.update(dt);
        }


    }

    private boolean changeDirection(Enemy enemy, Wall wall, float dt) {
        boolean collision = false;
        if (new Rectangle(enemy.getPosition().x+(enemy.getDx() * dt), enemy.getPosition().y, 24, 25).overlaps(wall.getBoundsWall())) {
            enemy.setDx(-enemy.getDx());
            collision = true;
        }
        if (new Rectangle(enemy.getPosition().x, enemy.getPosition().y+(enemy.getDy() * dt), 24, 25).overlaps(wall.getBoundsWall())) {
            enemy.setDy(-enemy.getDy());
            collision = true;
        }
        return collision;
    }

    private void collisionWithPlayerWall(LinkedList<Wall> newWall) {
        Iterator<Wall> newWallIter = newWall.iterator();
        while (newWallIter.hasNext()) {
            Wall playerWall = newWallIter.next();
            Iterator<Wall> iter = walls.iterator();
            while (iter.hasNext()) {
                Wall wall = iter.next();
                if (wall.equals(playerWall)) {
                    iter.remove();
                }
            }
        }
        player.kill();
        if (!player.isDead()) newWall.clear();
    }

    private boolean contains(LinkedList<Wall> wallList, Wall wall) {
        for (Wall element : wallList) {
            if (element.equals(wall)) return true;
        }
        return false;
    }



}