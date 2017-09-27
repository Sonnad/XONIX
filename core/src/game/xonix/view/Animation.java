package game.xonix.view;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.utils.Array;

/**
 * Created by Sonad on 21.09.17.
 */

public class Animation {
    private Array<TextureRegion> frames;
    private float maxFrameTime;
    private float currentFrameTime;
    private int frameCount = 4;
    private int frame;

    public Animation(float cycleTime){
        frames = new Array<TextureRegion>();
        frames.add(new TextureRegion(new Texture("anim2.png")));
        frames.add(new TextureRegion(new Texture("anim3.png")));
        frames.add(new TextureRegion(new Texture("anim4.png")));
        frames.add(new TextureRegion(new Texture("anim3.png")));
        maxFrameTime = cycleTime/frameCount;
        frame = 0;
    }
    public void update(float dt){
        currentFrameTime += dt;
        if (currentFrameTime > maxFrameTime){
            frame++;
            currentFrameTime = 0;
        }
        if (frame >= frameCount)
            frame = 0;
    }
    public  TextureRegion getFrame(){
        return frames.get(frame);
    }
}
