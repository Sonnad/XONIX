package game.xonix.view;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.freetype.FreeTypeFontGenerator;
import com.badlogic.gdx.graphics.g2d.freetype.FreeTypeFontGenerator.FreeTypeFontParameter;

import java.util.LinkedList;
import java.util.Locale;

import game.xonix.Xonix;
import game.xonix.model.PlayerSingleton;
import game.xonix.model.UI;
import game.xonix.view.Fonts.*;

/**
 * Created by Sonad on 16.10.17.
 */

public class DrawUI {

    private LinkedList<UI> ui;
    private double percent;
    private long second;
    private long minute;
    private int hearthCount;
    private long score;

    public DrawUI() {
        ui = new LinkedList<UI>();
        addUIElements();
        hearthCount = PlayerSingleton.getInstance().getLifes();
    }

    private void addUIElements() {
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
        ui.add(new UI(Xonix.WIDTH - 460, Xonix.HEIGHT-37, new Texture("clock.png")));
        for (int i = 0, j = 20; i <= PlayerSingleton.getInstance().getLifes(); i++, j+=30) {
            ui.add(new UI(j, Xonix.HEIGHT-44, new Texture("hearth.png")));
        }
    }

    public void update(double percent, long time, long score) {
        this.percent = percent;
        if (hearthCount!=PlayerSingleton.getInstance().getLifes()) {
            hearthCount--;
            ui.removeLast();
        }
        second = (time / 1000) % 60;
        minute = (time / (1000 * 60)) % 60;
        this.score = score;
    }

    public void render(SpriteBatch sb) {
        for (UI uiElement : ui) {
            sb.draw(uiElement.getTexture(), uiElement.getPosition().x, uiElement.getPosition().y);
            GameUIFont.font.draw(sb, "Progress: " + (int)percent + "/80%", Xonix.WIDTH - 305, Xonix.HEIGHT - 14);
        }
        GameUIFont.font.draw(sb, String.format("%02d:%02d",minute, second), Xonix.WIDTH - 425, Xonix.HEIGHT - 14);
        GameUIFont.font.draw(sb, "Score: " + score, Xonix.WIDTH - 720, Xonix.HEIGHT - 14);

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
