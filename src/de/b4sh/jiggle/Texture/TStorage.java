package de.b4sh.jiggle.Texture;

import java.util.ArrayList;

public class TStorage {

    private static ArrayList<Texture> textureList;

    public TStorage() {
        textureList = new ArrayList<Texture>();
    }

    public void loadTexture(String filename)
    {
        textureList.add(new Texture(filename));

        int a = 0;
    }

    public void unloadTexutre(String filename)
    {
        Texture tmp = new Texture("");
        for(Texture e: textureList)
        {
            if(e.getFileName() == filename)
            {
                tmp = e;
            }
        }
        textureList.remove(tmp);
        tmp = null;
    }

    public static void bindTexture(int id)
    {
        if(textureList.get(id) != null)
        {
            System.out.println("Binding Texture: " + id);
            textureList.get(id).bind(0);
        }
        else
            System.out.println("Cannot bind Texture: " +id);
    }


}
