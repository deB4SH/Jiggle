package de.b4sh.pengins.Texture.Image;

import java.nio.ByteBuffer;

public interface ImageData {

    public int getWidth();
    public int getHeight();
    public int getDepth();

    public ByteBuffer getImageData();
    public int getType();
    public int getFormat();
}
