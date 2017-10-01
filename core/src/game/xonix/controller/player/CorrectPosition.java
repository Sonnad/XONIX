package game.xonix.controller.player;

import game.xonix.model.PlayerSingleton;
import game.xonix.view.PlayerView;

/**
 * Created by Sonad on 01.10.17.
 */

public class CorrectPosition {

    private PlayerSingleton player = PlayerSingleton.getInstance();
    private int currentPositionY;
    private float currentPositionX;

    public void correctXPosition() {
        currentPositionX = (player.getPosition().x % 24)-12;
        if (currentPositionX != 0) {
            player.getPosition().x = (player.getPosition().x - currentPositionX);
        }
    }

    public void correctYPosition() {
        currentPositionY = (int)(player.getPosition().y % 24);
        if (currentPositionY != 0) {
            if (currentPositionY >= 12)
                player.getPosition().y = (int)player.getPosition().y + 24 - currentPositionY;
            else
                player.getPosition().y = (int)player.getPosition().y - currentPositionY;
        }
    }
}
