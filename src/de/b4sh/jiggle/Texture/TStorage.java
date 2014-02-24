package de.b4sh.jiggle.Texture;

import java.util.ArrayList;

public class TStorage {

    private ArrayList<Texture> textureList;

    public TStorage() {
        this.textureList = new ArrayList<Texture>();
        TextureEvents.getInstance().setTextureStorage(this);
    }

    public void loadTexture(String filename)
    {
        this.textureList.add(new Texture(filename));

        int a = 0;
    }

    public void unloadTexutre(String filename)
    {
        Texture tmp = new Texture("");
        for(Texture e: this.textureList)
        {
            if(e.getFileName() == filename)
            {
                tmp = e;
            }
        }
        this.textureList.remove(tmp);
        tmp = null;
    }

    public void bindTexture(int id)
    {
        if(this.textureList.get(id) != null)
        {
            System.out.println("Binding Texture: " + id);
            this.textureList.get(id).bind();
        }
        else
            System.out.println("Cannot bind Texture: " +id);
    }


}
