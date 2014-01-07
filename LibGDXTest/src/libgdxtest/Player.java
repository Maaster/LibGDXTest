/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package libgdxtest;

import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector2;

/**
 *
 * @author Maaster
 */
public class Player {

    /**
     * @return the bounds
     */
    public Rectangle getBounds() {
        return bounds;
    }

    /**
     * @return the position
     */
    public Vector2 getPosition() {
        return position;
    }
    
    public enum State {
        IDLE, WALKING, JUMPING, DYING
    }
    
    static final float SPEED = 2f;
    static final float JUMP_VELOCITY = 1f;
    static final float SIZE = 0.5f;
    
    private Vector2 position = new Vector2();
    Vector2 acceleration = new Vector2();
    Vector2 velocity = new Vector2();
    private Rectangle bounds = new Rectangle();
    State state = State.IDLE;
    boolean facingLeft = true;
    
    public Player(Vector2 position) {
        this.position = position;
        this.bounds.height = SIZE;
        this.bounds.width = SIZE;
    }
}
