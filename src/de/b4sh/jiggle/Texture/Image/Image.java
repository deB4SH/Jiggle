package de.b4sh.jiggle.Texture.Image;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.color.ColorSpace;
import java.awt.image.*;
import java.io.File;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.util.Hashtable;

import static org.lwjgl.opengl.GL11.GL_RGBA;
import static org.lwjgl.opengl.GL11.GL_UNSIGNED_BYTE;


/*
 * Credit to Henry4k for understanding a good Texture-Management
 * https://github.com/henry4k
 *
 * Loads an Image from res/filename
 * Holds data as ByteBuffer and as BufferedImage
 */


public class Image implements ImageData {


    private ByteBuffer imageData;
    private BufferedImage image;
    private ComponentColorModel glAlphaColorModel;
    private ComponentColorModel glColorModel;

    public Image(String filename)
    {
        this.glAlphaColorModel = new ComponentColorModel((ColorSpace.getInstance(ColorSpace.CS_sRGB)),new int[]{8,8,8,8},true,false,ComponentColorModel.TRANSLUCENT, DataBuffer.TYPE_BYTE);
        this.glColorModel = new ComponentColorModel((ColorSpace.getInstance(ColorSpace.CS_sRGB)),new int[]{8,8,8,0},false,false,ComponentColorModel.OPAQUE,DataBuffer.TYPE_BYTE);

        try {
            loadImage(filename);
        } catch (IOException ioe) {
            ioe.printStackTrace();
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
    }

    private void loadImage(String filename) throws IOException
    {
        this.image = ImageIO.read(new File("res/" + filename));

        //create raster
        final WritableRaster raster = Raster.createInterleavedRaster(DataBuffer.TYPE_BYTE, image.getWidth(), image.getHeight(), image.getColorModel().getNumColorComponents(), null);

        final BufferedImage bufferedImage;

        //check if graphic got an alpha level
        if(this.image.getColorModel().hasAlpha())
        {
            bufferedImage = new BufferedImage(glAlphaColorModel,raster,false, new Hashtable());
        }
        else
        {
            bufferedImage = new BufferedImage(glColorModel,raster,false,new Hashtable());
        }

        final Graphics graphics = bufferedImage.getGraphics();
        graphics.setColor(new Color(1,0,0,0));
        graphics.fillRect(0,0,image.getWidth(),image.getHeight());
        graphics.drawImage(image,0,0,null);

        byte[] rawData = ((DataBufferByte)bufferedImage.getRaster().getDataBuffer()).getData();
        this.imageData = ByteBuffer.allocateDirect(rawData.length);
        this.imageData.order(ByteOrder.nativeOrder());
        this.imageData.put(rawData,0,rawData.length);
        this.imageData.flip();
    }

    public void dispose()
    {
        this.image = null;
        this.imageData = null;
    }

    @Override
    public int getWidth() {
        return this.image.getWidth();
    }

    @Override
    public int getHeight() {
        return this.image.getHeight();
    }

    @Override
    public int getDepth() {
        return 1;
    }

    @Override
    public ByteBuffer getImageData() {
        return this.imageData;
    }

    @Override
    public int getType() {
        return GL_RGBA;
    }

    @Override
    public int getFormat() {
        return GL_UNSIGNED_BYTE;
    }
}
