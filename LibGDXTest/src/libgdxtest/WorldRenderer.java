
package libgdxtest;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.GL10;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer.ShapeType;
import com.badlogic.gdx.math.Rectangle;
import java.util.Iterator;

public class WorldRenderer {
    
    private World world;
    private OrthographicCamera cam;
    
    private static final float CAMERA_HEIGHT = 7f;
    private static final float CAMERA_WIDTH = 10f;
    
    ShapeRenderer debugRenderer = new ShapeRenderer();
    
    private Texture playerTexture;
    private Texture blockTexture;
    
    private SpriteBatch spriteBatch;
    private boolean debug = false;
    private int width;
    private int height;
    private float ppuX;
    private float ppuY;
    
    public void setSize(int w, int h) {
        this.width = w;
        this.height = h;
        ppuX = (float) width / CAMERA_WIDTH;
        ppuY = (float) height / CAMERA_HEIGHT;
        
    }
    
    public WorldRenderer(World world, boolean debug) {
        this.world = world;
        this.cam = new OrthographicCamera(CAMERA_WIDTH, CAMERA_HEIGHT);
        this.cam.position.set(CAMERA_WIDTH / 2f, CAMERA_HEIGHT / 2f,0);
        this.cam.update();
        this.debug = debug;
        spriteBatch = new SpriteBatch();
        loadTextures();
    }
    
    private void loadTextures() {
        playerTexture = new Texture(Gdx.files.internal("assets/images/bob_01.png"));
        blockTexture = new Texture(Gdx.files.internal("assets/images/block.png"));
    }   
    
    public void render() {
        
        spriteBatch.begin();
        drawBlocks();
        drawPlayer();
        spriteBatch.end();
        
        if(debug)
            drawDebug();

    }
    
    public void drawBlocks() {
        for (Iterator it = world.getBlocks().iterator(); it.hasNext();) {
            Block block = (Block) it.next();
            spriteBatch.draw(blockTexture, block.getPosition().x * ppuX, block.getPosition().y * ppuY, Block.SIZE * ppuX, Block.SIZE * ppuY);
        }
    }
    
    public void drawPlayer() {
        Player player1 = world.getPlayer1();
        spriteBatch.draw(playerTexture, player1.getPosition().x * ppuX, player1.getPosition().y * ppuY, Player.SIZE * ppuX, Player.SIZE * ppuY);
    }
    
    public void drawDebug() {
        debugRenderer.setProjectionMatrix(cam.combined);
        debugRenderer.begin(ShapeType.Line);
        
        for (Iterator it = world.getBlocks().iterator(); it.hasNext();) {
            Block block1 = (Block) it.next();
            Rectangle rect = block1.getBounds();
            float x1 = block1.getPosition().x + rect.x;
            float y1 = block1.getPosition().y + rect.y;
            debugRenderer.setColor(new Color(1, 0, 0, 1));
            debugRenderer.rect(x1, y1, rect.width, rect.height);
        }
        
        Player player1 = world.getPlayer1();    
        Rectangle rect = player1.getBounds();
        float x1 = player1.getPosition().x + rect.x;
        float y1 = player1.getPosition().y + rect.y;
        debugRenderer.setColor(new Color(0, 1, 0, 1));
        debugRenderer.rect(x1, y1, rect.width, rect.height);
        debugRenderer.end();
        
        debugRenderer.end();
    }
            
}
