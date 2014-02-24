package de.b4sh.pengins.Texture;

public class TextureEvents {
    private static TextureEvents ourInstance = new TextureEvents();

    public static TextureEvents getInstance() {
        return ourInstance;
    }

    private TextureEvents() {
    }

    private TStorage textureStorage;

    public void bind(int textureID)
    {
        textureStorage.bindTexture(textureID);
    }

    public void setTextureStorage(TStorage textureStorage) {
        this.textureStorage = textureStorage;
    }
}
