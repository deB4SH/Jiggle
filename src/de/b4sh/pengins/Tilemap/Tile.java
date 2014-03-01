package de.b4sh.pengins.Tilemap;

import de.b4sh.pengins.System.Renderable;
import de.b4sh.pengins.System.Updateable;
import de.b4sh.pengins.Texture.Texture;
import de.b4sh.pengins.Texture.TextureEvents;
import org.lwjgl.Sys;

import static org.lwjgl.opengl.GL11.*;
import static org.lwjgl.opengl.GL11.glPopMatrix;

public class Tile implements Renderable, Updateable{

    public int width,height;
    public int tileID;


    @Override
    public void render() {

        glPushMatrix();

            //bind texture
            //System.out.println(TextureEvents.getInstance().getTextureHandle(0));
            TextureEvents.getInstance().bind(0);


            glBegin(GL_QUADS);
            {
                glVertex2f(50,0);
                glTexCoord2f(1,0);

                glVertex2f(50,50);
                glTexCoord2d(1,1);

                glVertex2f(0,50);
                glTexCoord2d(0,1);

                glVertex2f(0,0);
                glTexCoord2d(0,0);

            }
            glEnd();

        glPopMatrix();

    }

    @Override
    public void update() {

    }
}
