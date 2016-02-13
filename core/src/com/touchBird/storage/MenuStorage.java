package com.touchBird.storage;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.touchBird.general.Button;

public class MenuStorage {
	public static Texture imgButton, imgButtonBack, imgSound_off, imgMusic_off, imgFavorite = null;
	public static BitmapFont fontPlay, fontHelp = null;
	public static Sprite spButton, spBackGroundGame, spBirdD, spBirdI, spFavorite, spMusic, spSound = null;
	public static Button button_play = null;
	public static boolean HelpTouched = false;

	public static void load(){
		imgButtonBack = new Texture("BTBack.png");
		imgButtonBack.setFilter(Texture.TextureFilter.Linear, Texture.TextureFilter.Linear);
		imgButton = new Texture("buttonPlay.png");
		imgButton.setFilter(Texture.TextureFilter.Linear, Texture.TextureFilter.Linear);


		spMusic = new Sprite(GeneralStorage.imgMusic);
		spMusic.setSize(GeneralStorage.w / 10, GeneralStorage.w / 10);
		spMusic.setPosition(GeneralStorage.w - GeneralStorage.w / 2 - GeneralStorage.w / 4 - spMusic.getWidth() / 2, GeneralStorage.h / 4);

		spSound = new Sprite(GeneralStorage.imgSound);
		spSound.setSize(GeneralStorage.w / 10, GeneralStorage.w / 10);
		spSound.setPosition(GeneralStorage.w / 2 - spSound.getWidth() / 2, GeneralStorage.h / 4);

		imgSound_off = new Texture("sound_off.png");
		imgSound_off.setFilter(Texture.TextureFilter.Linear, Texture.TextureFilter.Linear);
		imgMusic_off = new Texture("music_off.png");
		imgMusic_off.setFilter(Texture.TextureFilter.Linear, Texture.TextureFilter.Linear);

		imgFavorite = new Texture("favorites.png");
		imgFavorite.setFilter(Texture.TextureFilter.Linear, Texture.TextureFilter.Linear);
		spFavorite = new Sprite(imgFavorite);
		spFavorite.setSize(GeneralStorage.w / 10, GeneralStorage.w / 10);

		fontPlay = new BitmapFont(Gdx.files.internal("Fonts/fontPlay.fnt"));
		fontHelp = new BitmapFont(Gdx.files.internal("Fonts/WhiteFont.fnt"));
		spBackGroundGame = new Sprite(GeneralStorage.imgBackGround);
		spBackGroundGame.setSize(GeneralStorage.w, GeneralStorage.h);
		//Sprite y Textures to help screen
		spBirdD = new Sprite(GeneralStorage.bird.imgBirdDC);
		spBirdD.setSize(GeneralStorage.h / 20, GeneralStorage.h / 20);
		spBirdI = new Sprite(GeneralStorage.imgBirdIC);
		spBirdI.setSize(GeneralStorage.h / 20, GeneralStorage.h / 20);

		spButton = new Sprite(imgButton);
		spButton.setSize(GeneralStorage.h / 5, GeneralStorage.h / 5);
		spButton.setPosition(GeneralStorage.w / 2 - spButton.getWidth() / 2, GeneralStorage.h / 2 - spButton.getHeight() / 2);

		button_play = new Button(spButton, "Play", fontPlay, (float) (.5* GeneralStorage.ratio));

	}
}

