package de.b4sh.pengins.Texture;

import de.b4sh.pengins.Texture.Image.Image;
import de.b4sh.pengins.Texture.TextureAddins.TextureTarget;
import org.lwjgl.BufferUtils;

import java.nio.IntBuffer;

import static org.lwjgl.opengl.GL11.*;
import static org.lwjgl.opengl.GL12.*;
import static org.lwjgl.opengl.GL14.*;

public class Texture {

    //general
    public int handle;
    public String fileName;
    public int target = TextureTarget.TEXTURE2D.getConstant();

    //image related
    private Image image;
    private int imageWidth,imageHeight,imageDepth;
    private boolean hasAlpha;

    public Texture(String fileName) {
        this.fileName = fileName;

        this.image = new Image(fileName); //load the image

        if(this.image != null)
        {
            //get imagedata
            this.imageHeight    = this.image.getHeight();
            this.imageWidth     = this.image.getWidth();
            this.imageDepth     = this.image.getDepth();

            this.handle = glGenTextures();

            System.out.println(handle);

            glBindTexture(GL_TEXTURE_2D,this.handle);

            glPixelStorei(GL_UNPACK_ALIGNMENT, 1);

            glTexParameteri(GL_TEXTURE_2D, GL_TEXTURE_WRAP_S, GL_REPEAT);
            glTexParameteri(GL_TEXTURE_2D, GL_TEXTURE_WRAP_T, GL_REPEAT);
            glTexParameteri(GL_TEXTURE_2D, GL_TEXTURE_MIN_FILTER, GL_NEAREST);
            glTexParameteri(GL_TEXTURE_2D, GL_TEXTURE_MAG_FILTER, GL_NEAREST);
            glTexParameteri(GL_TEXTURE_2D, GL_GENERATE_MIPMAP, GL_TRUE);

            glTexImage2D(GL_TEXTURE_2D, 0, image.getFormat(), image.getWidth(), image.getHeight(), 0, image.getFormat(), image.getType(), image.getImageData());

            glBindTexture(target, 0); // unbind texture
        }

    }

    public void bind()
    {
        glBindTexture(target,handle);
    }

    public String getFileName() {
        return fileName;
    }
}
