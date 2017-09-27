package game.xonix.controller;


import java.util.Iterator;
import java.util.LinkedList;

import game.xonix.model.Ground;
import game.xonix.model.PlayerSingleton;
import game.xonix.model.Wall;

/**
 * Created by Sonad on 28.09.17.
 */

public class FieldCollisionController {

    private PlayerSingleton player = PlayerSingleton.getInstance();
    private LinkedList<Wall> walls;
    private LinkedList<Ground> ground;

    public FieldCollisionController(LinkedList<Wall> walls, LinkedList<Ground> ground) {
        this.walls = walls;
        this.ground = ground;
    }

    public void update() {
        Iterator<Ground> iter = ground.iterator();
        while (iter.hasNext()) {
            Ground ground = iter.next();
            if(ground.getBoundsGround().overlaps(player.getPlayerGround())) {
                walls.add(new Wall(ground.getPosition().x, ground.getPosition().y));
            }
        }
    }

}
