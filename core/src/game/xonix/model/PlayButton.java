package game.xonix.model;

import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.ui.ImageButton;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;

import game.xonix.Xonix;

/**
 * Created by Sonad on 26.09.17.
 */

public class PlayButton {

    private ImageButton playButton;
    TextureAtlas atlasButton = new TextureAtlas("button/buttons.atlas");
    Skin buttonsSkin = new Skin(atlasButton);

    public PlayButton() {
        ImageButton.ImageButtonStyle connectToHost = new ImageButton.ImageButtonStyle();
        connectToHost.up = buttonsSkin.getDrawable("btn1t");//кнопка не нажата
        connectToHost.over = buttonsSkin.getDrawable("btn2t");
        connectToHost.down = buttonsSkin.getDrawable("btn3t"); // кнопка нажата
        playButton = new ImageButton(connectToHost);
        playButton.setSize(250, 100);// размер кнопки
        playButton.setPosition((Xonix.WIDTH/2)-(playButton.getWidth()/2), Xonix.HEIGHT/2); // позиция кнопки(с нижнего левого угла координаты считаются)
    }

    public ImageButton getPlayButton() {
        return playButton;
    }

    public void dispose() {
        atlasButton.dispose();
        buttonsSkin.dispose();
    }

    public void setPosition(int x, int y) {
        playButton.setPosition(x-(playButton.getWidth()/2), y);
    }


}
