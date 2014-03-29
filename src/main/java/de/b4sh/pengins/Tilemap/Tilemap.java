package de.b4sh.pengins.Tilemap;

import de.b4sh.pengins.System.Renderable;
import de.b4sh.pengins.Texture.TStorage;

public class Tilemap implements Renderable {

    private TStorage textureStorage;
    private Tile[][] tileMap;
    private int tilemapHeight,tilemapWidth;

    public Tilemap() {
        this.tileMap = new Tile[tilemapWidth][tilemapHeight];
    }


    @Override
    public void render() {

    }
}
