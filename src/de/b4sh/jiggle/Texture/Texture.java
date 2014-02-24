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
            glBindTexture(this.target,this.handle);

            switch(target) {
                case 3:
                    glTexImage3D(target,0,image.getFormat(),image.getWidth(), image.getHeight(), image.getDepth(),0,image.getFormat(),image.getType(),image.getImageData());
                    break;

                case 2:
                    glTexImage2D(target,0,image.getFormat(),image.getWidth(), image.getHeight(),0,image.getFormat(),image.getType(),image.getImageData());
                    break;

                case 1:
                    glTexImage1D(target,0,image.getFormat(),image.getWidth(),0,image.getFormat(),image.getType(),image.getImageData());
                    break;
            }

            glBindTexture(target, 0); // unbind texture
        }

    }

    public void bind(int unit)
    {
        glActiveTexture(GL_TEXTURE0+unit);
        glBindTexture(this.target, handle);
    }

    public String getFileName() {
        return fileName;
    }
}
