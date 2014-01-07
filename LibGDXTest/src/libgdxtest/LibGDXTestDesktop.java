/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package libgdxtest;

import com.badlogic.gdx.backends.lwjgl.LwjglApplication;

/**
 *
 * @author Maaster
 */
public class LibGDXTestDesktop {
    public static void main(String[] args) {
        new LwjglApplication(new LibGDXTest(), "Test", 800, 600, true);
    }
}
