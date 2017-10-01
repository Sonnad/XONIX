package game.xonix.controller.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.audio.Music;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import com.badlogic.gdx.utils.viewport.FitViewport;
import com.badlogic.gdx.utils.viewport.Viewport;

import game.xonix.Xonix;
import game.xonix.controller.Controller;
import game.xonix.controller.GameControllerManager;
import game.xonix.model.PlayButton;

/**
 * Created by Sonad on 18.09.17.
 */

public class MenuController extends Controller {

    private Texture background;
    private PlayButton playButton;
    protected Stage stage;
    boolean rendered = false;
    private Viewport viewport;
    Music music;

    public MenuController(final GameControllerManager gsm) {
        super(gsm);
        Gdx.input.setInputProcessor(stage);
        viewport = new FitViewport(Xonix.WIDTH, Xonix.HEIGHT, camera);
        viewport.apply();
        background = new Texture("bg.jpg");
        playButton = new PlayButton();
        playButton.getPlayButton().addListener(new ClickListener() {
            @Override
            public void clicked(InputEvent event, float x, float y) {
                stage.dispose();
                gsm.set(new PlayController(gsm));
            }
        });

    }

    @Override
    protected void handleInput() {

    }

    @Override
    public void update(float dt) {
        handleInput();
    }

    @Override
    public void render(SpriteBatch sb) {
        if (!rendered) {
            stage = new Stage(viewport, sb);
            Gdx.input.setInputProcessor(stage);
            stage.addActor(playButton.getPlayButton());
            rendered = true;
        }

        sb.begin();
        sb.draw(background, 0, 0, Xonix.WIDTH, Xonix.HEIGHT);
        sb.end();
        stage.act();
        stage.draw();
    }

    @Override
    public void dispose() {
        background.dispose();
    }

}
