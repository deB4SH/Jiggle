package de.b4sh.jiggle.Texture.TextureAddins;

import static org.lwjgl.opengl.GL11.GL_TEXTURE_1D;
import static org.lwjgl.opengl.GL11.GL_TEXTURE_2D;
import static org.lwjgl.opengl.GL12.GL_TEXTURE_3D;

public enum TextureTarget {
    TEXTURE1D(GL_TEXTURE_1D,1),
    TEXTURE2D(GL_TEXTURE_2D,2),
    TEXTURE3D(GL_TEXTURE_3D,3);

    //ENUM
    private int constant;
    private int dimension;
    private TextureTarget(int constant,int dimension)
    {
        this.constant = constant;
        this.dimension = dimension;
    }

    public int getConstant() {
        return constant;
    }

    public int getDimension() {
        return dimension;
    }
}
