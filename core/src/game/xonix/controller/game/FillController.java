package game.xonix.controller.game;


import java.util.ArrayList;
import java.util.LinkedList;

import game.xonix.Xonix;
import game.xonix.model.Enemy;
import game.xonix.model.Ground;
import game.xonix.model.Wall;
import game.xonix.view.Background;

/**
 * Created by Sonad on 15.10.17.
 */

public class FillController {

    private LinkedList<Wall> walls;
    private LinkedList<Ground> temporaryGround;
    private Background ground;
    private ArrayList<Enemy> enemyList;

    public FillController(LinkedList<Wall> walls, Background ground, ArrayList<Enemy> enemyList) {
        this.temporaryGround = new LinkedList<Ground>();
        this.walls = walls;
        this.enemyList = enemyList;
        this.ground = ground;
    }

    private void fillTemporary(int x, int y) {
        if (x < 72 || x > 1104) return;
        if (y < 48 || y > 816) return;
        Ground temporaryGround = ground.getBackground().get((x / Xonix.SPRITESIZE) * 36 + (y / Xonix.SPRITESIZE));
        if (temporaryGround.getBoundsGround() == null) return;
        this.temporaryGround.add(temporaryGround);
        temporaryGround.deleteBoundsGround();
        for (int dx = -24; dx < 48; dx += 24)
            for (int dy = -24; dy < 48; dy += 24) fillTemporary(x + dx, y + dy);
    }

    void tryToFill() {
        long timer = -System.currentTimeMillis();
        for (Enemy enemy : enemyList) {
            fillTemporary(correctXPosition(enemy), correctYPosition(enemy));
        }
        timer += System.currentTimeMillis();
        System.out.println("C.m(Рекурсия) " + timer);
        for (Ground groundElement: ground.getBackground()) {
            if (groundElement.getBoundsGround() == null) continue;
                groundElement.deleteBoundsGround();
                walls.add(new Wall(groundElement.getPosition().x, groundElement.getPosition().y));
        }

        for (Ground groundElement : temporaryGround) {
            groundElement.restoreBounds();
        }

        temporaryGround = new LinkedList<Ground>();

    }


    private int correctXPosition(Enemy enemy) {
        int currentPositionX = (int) (enemy.getPosition().x % 24);
        if (currentPositionX != 0) {
            return (int)(enemy.getPosition().x - currentPositionX);
        }
        return (int) enemy.getPosition().x;
    }

    private int correctYPosition(Enemy enemy) {
        int currentPositionY = (int)(enemy.getPosition().y % 24);
        if (currentPositionY != 0) {
                return (int)(enemy.getPosition().y - currentPositionY);
        }
        return (int) enemy.getPosition().y;
    }
}
