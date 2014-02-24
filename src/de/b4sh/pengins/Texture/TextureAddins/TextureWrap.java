package de.b4sh.pengins.Texture.TextureAddins;

import static org.lwjgl.opengl.GL11.GL_REPEAT;
import static org.lwjgl.opengl.GL11.GL_CLAMP;


public enum TextureWrap {

    REPEAT(GL_REPEAT),
    CLAMP(GL_CLAMP);

    //ENUM
    private int glConstant;
    private TextureWrap(int glConstant){this.glConstant = glConstant;}
    public int getGlConstant(){return glConstant;}
}
