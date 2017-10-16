package game.xonix.controller.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.freetype.FreeTypeFontGenerator;

import java.util.LinkedList;

import game.xonix.Xonix;
import game.xonix.controller.Controller;
import game.xonix.controller.GameControllerManager;
import game.xonix.controller.enemy.EnemyController;
import game.xonix.model.Enemy;
import game.xonix.model.PlayerSingleton;
import game.xonix.model.Wall;
import game.xonix.view.Background;
import game.xonix.view.DrawUI;
import game.xonix.view.DrawWall;

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
    public static BitmapFont font;
    FreeTypeFontGenerator generator;
    FreeTypeFontGenerator.FreeTypeFontParameter parameter;

    public GameOverController(GameControllerManager grm, Background background, DrawWall drawWall, EnemyController enemyController, DrawUI ui,LinkedList<Wall> playerWal ) {
        super(grm);
        this.background = background;
        this.drawWall = drawWall;
        this.enemyController = enemyController;
        this.ui = ui;
        this.playerWall = playerWal;
        backgroundTexture = new Texture("GameOver.png");
        generateFont();
    }

    private  void generateFont() {
        generator = new FreeTypeFontGenerator(Gdx.files.internal("fonts/kenpixel_blocks.ttf"));
        parameter = new FreeTypeFontGenerator.FreeTypeFontParameter();
        parameter.size = 100;
        parameter.color = Color.BLACK;
        font = generator.generateFont(parameter);
    }

    @Override
    protected void handleInput() {

    }

    @Override
    public void update(float dt) {

    }

    @Override
    public void render(SpriteBatch sb) {
        sb.begin();
        background.render(sb);
        drawWall.render(sb);
        ui.render(sb);
        for (Enemy enemy : enemyController.getEnemyList()) {
            enemy.draw(sb);
        }
        for (Wall wall : playerWall) {
            sb.draw(wall.getWall(), wall.getPosition().x, wall.getPosition().y);
        }
        sb.draw(player.getPlayer(), player.getPosition().x, player.getPosition().y);
        sb.draw(backgroundTexture, 0, 0, Xonix.WIDTH, Xonix.HEIGHT);
        font.draw(sb, "GAME OVER", Xonix.WIDTH/2-300, Xonix.HEIGHT/2+50);
        sb.end();
    }

    @Override
    public void dispose() {
        background.dispose();
        drawWall.dispose();
        ui.dispose();
    }
}
