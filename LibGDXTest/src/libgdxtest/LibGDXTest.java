/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package libgdxtest;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL10;

/**
 *
 * @author Maaster
 */
public class LibGDXTest extends Game {

    private World world;
    private WorldRenderer renderer;

    @Override
    public void create() {
        setScreen(new GameScreen());
        world = new World();
        renderer = new WorldRenderer(world, false);
    }

    @Override
    public void resize(int width, int height) {
        renderer.setSize(width, height);
    }

    @Override
    public void render() {
        Gdx.gl.glClearColor(0.1f, 0.1f, 0.1f, 1);
        Gdx.gl.glClear(GL10.GL_COLOR_BUFFER_BIT);
        renderer.render();
    }

    @Override
    public void pause() {
        //throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public void resume() {
        //throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public void dispose() {
        //throw new UnsupportedOperationException("Not supported yet.");
    }
}
