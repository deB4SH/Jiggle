package de.b4sh.jiggle.Tilemap;

import de.b4sh.jiggle.System.Renderable;
import de.b4sh.jiggle.System.Updateable;
import de.b4sh.jiggle.Texture.TStorage;

import static org.lwjgl.opengl.GL11.*;
import static org.lwjgl.opengl.GL11.glPopMatrix;

public class Tile implements Renderable, Updateable{

    public int width,height;
    public int tileID;


    @Override
    public void render() {

        glPushMatrix();

        //bind texture
        TStorage.bindTexture(0);

        glBegin(GL_QUADS);
        {
            glTexCoord2f(0,0);
            glVertex2f(0,0);

            glTexCoord2d(0,50);
            glVertex2f(0,50);

            glTexCoord2d(50,50);
            glVertex2f(50,50);

            glTexCoord2d(50,0);
            glVertex2f(50,0);

        }
        glEnd();

        glPopMatrix();

    }

    @Override
    public void update() {

    }
}
