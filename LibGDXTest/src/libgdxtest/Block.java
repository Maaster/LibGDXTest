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
public class Block {
    
    public static final float SIZE = 1f;

    
    private Vector2 position = new Vector2();
    private Rectangle bounds = new Rectangle();
    
    public Block(Vector2 pos) 
    {
        this.position = pos;
        this.bounds.width = SIZE;
        this.bounds.height = SIZE;
    }

    /**
     * @return the position
     */
    public Vector2 getPosition() {
        return position;
    }

    /**
     * @return the bounds
     */
    public Rectangle getBounds() {
        return bounds;
    }
}
