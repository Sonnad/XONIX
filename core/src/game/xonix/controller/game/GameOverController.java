package game.xonix.controller.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.audio.Sound;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import com.badlogic.gdx.utils.viewport.FitViewport;
import com.badlogic.gdx.utils.viewport.Viewport;

import java.util.LinkedList;

import game.xonix.Xonix;
import game.xonix.controller.Controller;
import game.xonix.controller.GameControllerManager;
import game.xonix.controller.enemy.EnemyController;
import game.xonix.model.Enemy;
import game.xonix.model.PlayButton;
import game.xonix.model.PlayerSingleton;
import game.xonix.model.Wall;
import game.xonix.view.Background;
import game.xonix.view.DrawUI;
import game.xonix.view.DrawWall;
import game.xonix.view.Fonts.GameOverFont;

/**
 * Created by Sonad on 16.10.17.
 */

public class GameOverController extends Controller {

    private Background background;
    private DrawWall drawWall;
    PlayerSingleton player = PlayerSingleton.getInstance();
    private EnemyController enemyController;
    private DrawUI ui;
    private LinkedList<Wall> playerWall;
    private Texture backgroundTexture;
    protected Stage stage;
    private Viewport viewport;
    private PlayButton playButton;
    boolean rendered = false;

    public GameOverController(final GameControllerManager grm, Background background, DrawWall drawWall, EnemyController enemyController, DrawUI ui,LinkedList<Wall> playerWal ) {
        super(grm);
        Gdx.audio.newSound(Gdx.files.internal("trombon.mp3")).play();
        this.background = background;
        this.drawWall = drawWall;
        this.enemyController = enemyController;
        this.ui = ui;
        this.playerWall = playerWal;
        backgroundTexture = new Texture("GameOver.png");
        Gdx.input.setInputProcessor(stage);
        viewport = new FitViewport(Xonix.WIDTH, Xonix.HEIGHT, camera);
        viewport.apply();
        playButton = new PlayButton();
        playButton.setPosition((Xonix.WIDTH/2), Xonix.HEIGHT/2-300);
        playButton.getPlayButton().addListener(new ClickListener() {
            @Override
            public void clicked(InputEvent event, float x, float y) {
                stage.dispose();
                grm.set(new MenuController(grm));
            }
        });
    }


    @Override
    protected void handleInput() {

    }

    @Override
    public void update(float dt) {

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
        background.render(sb);
        drawWall.render(sb);
        ui.render(sb);
        for (Wall wall : playerWall) {
            sb.draw(wall.getWall(), wall.getPosition().x, wall.getPosition().y);
        }
        for (Enemy enemy : enemyController.getEnemyList()) {
            enemy.draw(sb);
        }
        sb.draw(player.getPlayer(), player.getPosition().x, player.getPosition().y);
        sb.draw(backgroundTexture, 0, 0, Xonix.WIDTH, Xonix.HEIGHT);
        GameOverFont.font.draw(sb, "GAME OVER", Xonix.WIDTH/2-310, Xonix.HEIGHT/2+75);
        sb.end();
        stage.act();
        stage.draw();
    }

    @Override
    public void dispose() {
//        background.dispose();
//        drawWall.dispose();
        ui.dispose();
    }
}
