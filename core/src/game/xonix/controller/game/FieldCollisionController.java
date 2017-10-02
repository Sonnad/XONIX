package game.xonix.controller.game;


import java.util.Iterator;
import java.util.LinkedList;

import game.xonix.model.Ground;
import game.xonix.model.PlayerSingleton;
import game.xonix.model.Wall;

/**
 * Created by Sonad on 28.09.17.
 */

public class FieldCollisionController {

    PlayerSingleton player = PlayerSingleton.getInstance();
    private LinkedList<Wall> walls;
    private LinkedList<Ground> ground;
    private LinkedList<Wall> newWall;
    private LinkedList<Ground> deleteGround;

    public FieldCollisionController(LinkedList<Wall> walls, LinkedList<Ground> ground) {
        this.walls = walls;
        this.ground = ground;
        deleteGround = new LinkedList<Ground>();
        newWall = new LinkedList<Wall>();
    }

    public boolean isFieldCollision() {
        Iterator<Ground> iter = ground.iterator();
        while (iter.hasNext()) {
            Ground ground = iter.next();

            if(ground.getBoundsGround() == null) continue;

            if(ground.getBoundsGround().overlaps(player.getPlayerGround())) {
                newWall.add(new Wall(ground.getPosition().x, ground.getPosition().y));
                walls.add(new Wall(ground.getPosition().x, ground.getPosition().y));
                deleteGround.add(ground);
                return true;
            }
        }

        return false;
    }

    public void clear() {
        newWall.clear();
        deleteGround.clear();
    }

    public void clearGround() {
        for (Ground delete : deleteGround) {
            delete.deleteBoundsGround();
        }
    }

    public LinkedList<Wall> getNewWall() {
        return newWall;
    }
}
