package de.b4sh.jiggle.Texture;

import de.b4sh.jiggle.System.Renderable;
import de.b4sh.jiggle.Texture.Image.Image;
import de.b4sh.jiggle.Texture.TextureAddins.TextureTarget;

import static org.lwjgl.opengl.GL11.*;
import static org.lwjgl.opengl.GL12.GL_TEXTURE_WRAP_R;
import static org.lwjgl.opengl.GL12.glTexImage3D;
import static org.lwjgl.opengl.GL13.GL_TEXTURE0;
import static org.lwjgl.opengl.GL13.glActiveTexture;
import static org.lwjgl.opengl.GL14.GL_GENERATE_MIPMAP;

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
            glBindTexture(GL_TEXTURE_2D,this.handle);
            glPixelStorei(GL_UNPACK_ALIGNMENT, 1);
            glTexParameteri(GL_TEXTURE_2D, GL_TEXTURE_MIN_FILTER, GL_NEAREST);
            glTexImage2D(GL_TEXTURE_2D,0,image.getFormat(),image.getWidth(), image.getHeight(),0,image.getFormat(),image.getType(),image.getImageData());

            glBindTexture(target, 0); // unbind texture
        }

    }

    public void bind(int unit)
    {
        glActiveTexture(GL_TEXTURE0+unit);
        glBindTexture(GL_TEXTURE_2D, handle);
    }

    public String getFileName() {
        return fileName;
    }
}
