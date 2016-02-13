package com.touchBird.storage;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;

public class GameOverStorage {

	public static Sprite spCirculo, spShare, spLoaderBoard, spBackGround = null;
	public static Texture imgCircleReplay, imgShare, imgLDBoard, imgBackGround = null;

	public static void load(){

		imgCircleReplay = new Texture("circuloRetro.png");
		imgCircleReplay.setFilter(Texture.TextureFilter.Linear, Texture.TextureFilter.Linear);
		spCirculo = new Sprite(imgCircleReplay);
		spCirculo.setSize(GeneralStorage.w / 6, GeneralStorage.w / 6);
		spCirculo.setPosition(GeneralStorage.w / 2 - spCirculo.getWidth() / 2, GeneralStorage.h / 2 - spCirculo.getHeight() / 2);

		imgShare = new Texture("Share.png");
		imgShare.setFilter(Texture.TextureFilter.Linear, Texture.TextureFilter.Linear);
		spShare = new Sprite(imgShare);
		spShare.setSize(GeneralStorage.w / 10, GeneralStorage.w / 10);;
		spShare.setPosition(GeneralStorage.w / 2 - spShare.getWidth() / 2, GeneralStorage.h / 4);

		imgBackGround = new Texture("backGroundGame.png");
		imgBackGround.setFilter(Texture.TextureFilter.Linear, Texture.TextureFilter.Linear);
		spBackGround = new Sprite(imgBackGround);
		spBackGround.setSize(GeneralStorage.w, GeneralStorage.h);
		spBackGround.setColor(37/255f,116/255f,169/255f,1);

		imgLDBoard = new Texture("loaderBoard.png");
		imgLDBoard.setFilter(Texture.TextureFilter.Linear, Texture.TextureFilter.Linear);
		spLoaderBoard = new Sprite(imgLDBoard);
		spLoaderBoard.setSize(GeneralStorage.w / 10, GeneralStorage.w / 10);
		spLoaderBoard.setPosition(GeneralStorage.w - GeneralStorage.w / 2 - GeneralStorage.w / 8 - spLoaderBoard.getWidth() / 2, GeneralStorage.h / 6);


	}
}

