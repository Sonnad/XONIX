package game.xonix.view;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

import java.util.LinkedList;

import game.xonix.Xonix;
import game.xonix.model.Ground;
import game.xonix.model.UI;
import game.xonix.model.Wall;

/**
 * Created by Sonad on 16.10.17.
 */

public class DrawUI {
    private LinkedList<UI> ui;

    public DrawUI() {
        ui = new LinkedList<UI>();
        ui.add(new UI(0, Xonix.HEIGHT-24, new Texture("tile_4.png")));
        ui.add(new UI(0, Xonix.HEIGHT - 48, new Texture("tile_3.png")));
        ui.add(new UI(Xonix.WIDTH-24, Xonix.HEIGHT-24, new Texture("tile_1.png")));
        ui.add(new UI(Xonix.WIDTH-24, Xonix.HEIGHT-48, new Texture("tile_2.png")));
        for (int i = 24; i <= Xonix.WIDTH-48; i+=Xonix.SPRITESIZE) {
            for (int j = Xonix.HEIGHT; j >= Xonix.HEIGHT - 48; j-=Xonix.SPRITESIZE) {
                 if (j == Xonix.HEIGHT-24) ui.add(new UI(i,j, new Texture("tile_5.png")));
                else ui.add(new UI(i,j, new Texture("tile_6.png")));
            }
        }
    }

    public void render(SpriteBatch sb) {
        for (UI uiElement : ui) {
            sb.draw(uiElement.getTexture(), uiElement.getPosition().x, uiElement.getPosition().y);
        }

    }

    public LinkedList<UI> getUIs() {
        return ui;
    }

    public void dispose() {
        for (UI uiElement : ui) {
            uiElement.dispose();
        }
    }


}
