package com.touchBird.storage;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;

public class PauseStorage {
    public static Sprite spPlay,spBack, spPause;
    public static Texture imgPause;

    public static void load(){
        spPlay = new Sprite(GeneralStorage.imgBackMenu);
        spPlay.setSize(GeneralStorage.w / 7, GeneralStorage.w / 7);
        spPlay.setPosition(GeneralStorage.w / 2 - 40 - spPlay.getWidth(), GeneralStorage.h / 2);
        imgPause = new Texture("fondo4.png");
        imgPause.setFilter(Texture.TextureFilter.Linear, Texture.TextureFilter.Linear);
        spPause = new Sprite(imgPause);
        spBack = new Sprite(GeneralStorage.imgPlay);
        spBack.setSize(GeneralStorage.w / 7, GeneralStorage.w / 7);
        spBack.setPosition(GeneralStorage.w / 2 + 40, GeneralStorage.h / 2);
    }
}
