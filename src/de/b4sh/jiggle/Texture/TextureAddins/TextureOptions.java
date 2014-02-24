package de.b4sh.jiggle.Texture.TextureAddins;

public class TextureOptions {

    private TextureWrap wrapMode = TextureWrap.REPEAT;
    private boolean mipMap = true;
    private boolean filter = true;

    public TextureOptions() {    }

    public TextureWrap getWrapMode() {
        return wrapMode;
    }

    public void setWrapMode(TextureWrap wrapMode) {
        this.wrapMode = wrapMode;
    }

    public boolean isMipMap() {
        return mipMap;
    }

    public void setMipMap(boolean mipMap) {
        this.mipMap = mipMap;
    }

    public boolean isFilter() {
        return filter;
    }

    public void setFilter(boolean filter) {
        this.filter = filter;
    }
}
