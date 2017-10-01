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
    private int frameCount;
    private int frame;

    public Animation(float cycleTime, Array<TextureRegion> frames, int frameCount){
        this.frames = frames;
        this.frameCount = frameCount;
        maxFrameTime = cycleTime/frameCount; //Время показа 1 кадра анимации = время на весь круг анимации/ кол-во кадров
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
