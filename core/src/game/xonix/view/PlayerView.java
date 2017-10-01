package game.xonix.view;

import game.xonix.Xonix;
import game.xonix.model.PlayerSingleton;

/**
 * Created by Sonad on 01.10.17.
 */

public class PlayerView {
    private PlayerSingleton player = PlayerSingleton.getInstance();

    public void view(float dt) {
        player.getPlayerAnimation().update(dt); //Переключаем кадр анимации
        if (player.getPosition().x < 12) player.getPosition().x = 12; //Игрок не может выйти за левую границу поля
        if (player.getPosition().y < 0) player.getPosition().y = 0; //Игрок не может выйти за верхнюю границу поля
        if (player.getPosition().x > Xonix.WIDTH-51-11) player.getPosition().x = Xonix.WIDTH-51-11; //Игрок не может выйти за правую границу поля
        if (player.getPosition().y > Xonix.HEIGHT-24) player.getPosition().y = Xonix.HEIGHT-24; //Игрок не может выйти за нижнюю границу поля
        player.getPlayerGround().setPosition(player.getPosition().x+24, player.getPosition().y+12); //Двигаем прямоугольник столкновения с землей за игроком
    }

}
