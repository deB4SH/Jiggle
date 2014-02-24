package de.b4sh.pengins.System.OpenGLBasic;

import static org.lwjgl.opengl.GL11.*;

public class KoordinateSystem{

    public KoordinateSystem()
    {    }

    public void draw()
    {
        glBegin(GL_LINES);

        //x
        glColor4f(0.5f,0f,0f,0.5f); //red
        glVertex3f(-300,0,0);
        glVertex3f(300,0,0);

        //y
        glColor4f(0,0.5f,0f,0.5f); //green
        glVertex3f(0,-300,0);
        glVertex3f(0,300,0);

        //z
        glColor4f(0f,0f,0.5f,0.5f); //blue
        glVertex3f(0,0,300);
        glVertex3f(0,0,-300);

        glEnd();
    }

}
