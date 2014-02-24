package de.b4sh.jiggle.Tilemap;

import de.b4sh.jiggle.System.Renderable;
import de.b4sh.jiggle.Texture.TStorage;

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
