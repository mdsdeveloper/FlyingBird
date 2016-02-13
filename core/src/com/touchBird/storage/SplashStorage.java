package com.touchBird.storage;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.Sprite;

public class SplashStorage {
	public static Sprite spBackGroundSplash = null;
	private static Texture imgBackGroundSplash = null;
	public static BitmapFont btfSplash = null;

	public static void load(){

		imgBackGroundSplash = new Texture("backGroundSplash.png");
		imgBackGroundSplash.setFilter(Texture.TextureFilter.Linear, Texture.TextureFilter.Linear);
		spBackGroundSplash = new Sprite(imgBackGroundSplash);
		spBackGroundSplash.setSize(GeneralStorage.w, GeneralStorage.h);
		spBackGroundSplash.setTexture(imgBackGroundSplash);
		btfSplash = new BitmapFont(Gdx.files.internal("Fonts/font.fnt"));
		btfSplash.setScale((float) GeneralStorage.ratio);

	}

}

