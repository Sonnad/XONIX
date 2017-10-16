package game.xonix.controller;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;

import java.util.Stack;

/**
 * Created by Sonad on 18.09.17.
 */

public class GameControllerManager {
    private Stack<Controller> states;

    public GameControllerManager() {
        this.states = new Stack<Controller>();
    }

    public void push(Controller state) {
        this.states.push(state);
    }

    public void pop() {
        this.states.pop().dispose();
    }

    public void set(Controller state) {
        pop();
        this.states.push(state);
    }

    public void update(float dt) {
        states.peek().update(dt);
    }

    public void render(SpriteBatch sb) {
        states.peek().render(sb);
    }
}
