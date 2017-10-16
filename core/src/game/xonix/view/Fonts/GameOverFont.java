package game.xonix.view.Fonts;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.freetype.FreeTypeFontGenerator;

/**
 * Created by Sonad on 16.10.17.
 */

public class GameOverFont {

    public static BitmapFont font;
    private FreeTypeFontGenerator generator;
    private FreeTypeFontGenerator.FreeTypeFontParameter parameter;

    public GameOverFont() {
        generator = new FreeTypeFontGenerator(Gdx.files.internal("fonts/kenpixel_blocks.ttf"));
        parameter = new FreeTypeFontGenerator.FreeTypeFontParameter();
        parameter.size = 100;
        parameter.color = Color.BLACK;
        font = generator.generateFont(parameter);
    }
}
