/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package libgdxtest;

import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.utils.Array;

/**
 *
 * @author Maaster
 */
public class World {
    
    private Array blocks = new Array();
    private Player player1;

    /**
     * @return the blocks
     */
    public Array getBlocks() {
        return blocks;
    }

    /**
     * @return the player1
     */
    public Player getPlayer1() {
        return player1;
    }
    
    
    public World() 
    {
        createDemoWorld();
    }
    
    public void createDemoWorld() 
    {
        player1 = new Player(new Vector2(7,2));
        
        for (int i = 0; i < 10; i++)
        { 			 			
            getBlocks().add(new Block(new Vector2(i, 0))); 			 			
            getBlocks().add(new Block(new Vector2(i, 6))); 			 			
            if (i > 2)
                getBlocks().add(new Block(new Vector2(i, 1)));
        }
        
        getBlocks().add(new Block(new Vector2(9, 2)));
        getBlocks().add(new Block(new Vector2(9, 3)));
        getBlocks().add(new Block(new Vector2(9, 4)));
        getBlocks().add(new Block(new Vector2(9, 5)));

        getBlocks().add(new Block(new Vector2(6, 3)));
        getBlocks().add(new Block(new Vector2(6, 4)));
        getBlocks().add(new Block(new Vector2(6, 5)));
        
        
    }

    /**
     * @param blocks the blocks to set
     */
    public void setBlocks(Array blocks) {
        this.blocks = blocks;
    }
    
}
