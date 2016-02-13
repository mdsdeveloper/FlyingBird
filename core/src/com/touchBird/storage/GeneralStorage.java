package com.touchBird.storage;

import com.badlogic.gdx.Files;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Preferences;
import com.badlogic.gdx.audio.Music;
import com.badlogic.gdx.audio.Sound;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.touchBird.general.Bird;

public class GeneralStorage {
	public static SpriteBatch batch = null;
	public static BitmapFont btfTittle, font_a, fontPresent= null;
	public static int w,h = 0;
	public static float ratio;
	public static Texture imgBirdDA, imgBirdIC, imgBirdIA, imgCounter, imgBackMenu, imgBTHelp,imgMusic,imgSound, imgBackGround, imgTriangleD, imgTriangleI, imgPlay, imgTriangleUP, imgTriangleDown = null;
	public static Preferences prefs = null;
	public static Bird bird = null;
	public static Music music;
	public static Sound soundTouch,soundLateral, soundFinal, soundFinal1;
	public static boolean isTouch, isActive = false;
	public static CharSequence[] str_a = new CharSequence[7];
	public static Color color;

	public enum state{
		splash,
		menu,
		running,
		pause,
		preGameOver,
		gameOver;
	};
	public static state estado; // variable of the menu

	public static void load(){
		//Screen Sizes. DON'T CHANGE THEM!
		w = Gdx.graphics.getWidth();
		h = Gdx.graphics.getHeight();

		//Ratio is used for text size
		float ratio1 = (float) (w / 720.0);
		float ratio2 = (float) (h / 1280.0);

		//The ratio is used for text size
		if (ratio1 > ratio2)
			ratio = ratio2;
		else
			ratio = ratio1;
		/////////////END SIZE VARIABLES DECLARATION////////////////////////
		batch = new SpriteBatch(); // size of the screen
		//********************************Font***********************************
		btfTittle = new BitmapFont(Gdx.files.internal("Fonts/fontPlay.fnt"));
		btfTittle.setScale(ratio);
		fontPresent = new BitmapFont(Gdx.files.internal("Fonts/fontPresents.fnt"));
		fontPresent.setScale(ratio);
		font_a = new BitmapFont(Gdx.files.internal("Fonts/fontName.fnt"));
		str_a[0] = "HELP";
		str_a[1] = "tap the screen to keep";
		str_a[2] = "bird flying, without";
		str_a[3] = "touching the spikes";
		str_a[4] = "of the walls.";
		str_a[5] = "Never leave of flying,";
		str_a[6] = "because you will fall.";
		//********************************Texture***********************************
		imgBackGround = new Texture("backGroundGame.png");
		imgBackGround.setFilter(Texture.TextureFilter.Linear, Texture.TextureFilter.Linear);
		imgBirdDA = new Texture("bird3.png");
		imgBirdDA.setFilter(Texture.TextureFilter.Linear, Texture.TextureFilter.Linear);
		imgBirdIC = new Texture("bird2.png");
		imgBirdIC.setFilter(Texture.TextureFilter.Linear, Texture.TextureFilter.Linear);
		imgBirdIA = new Texture("bird4.png");
		imgBirdIA.setFilter(Texture.TextureFilter.Linear, Texture.TextureFilter.Linear);
		imgCounter = new Texture("circlePointer.png"); // Circulo contador
		imgCounter.setFilter(Texture.TextureFilter.Linear, Texture.TextureFilter.Linear);
		imgBackMenu = new Texture("home.png");
		imgBackMenu.setFilter(Texture.TextureFilter.Linear, Texture.TextureFilter.Linear);
		imgBTHelp = new Texture("BTHelp.png");
		imgBTHelp.setFilter(Texture.TextureFilter.Linear, Texture.TextureFilter.Linear);
		imgMusic = new Texture("music_on.png");
		imgMusic.setFilter(Texture.TextureFilter.Linear, Texture.TextureFilter.Linear);
		imgSound = new Texture("sound_on.png");
		imgSound.setFilter(Texture.TextureFilter.Linear, Texture.TextureFilter.Linear);
		imgTriangleD = new Texture("triangleD.png");
		imgTriangleD.setFilter(Texture.TextureFilter.Linear, Texture.TextureFilter.Linear);
		imgTriangleI = new Texture("triangleI.png");
		imgTriangleI.setFilter(Texture.TextureFilter.Linear, Texture.TextureFilter.Linear);
		imgTriangleUP = new Texture("triangles.png");
		imgTriangleUP.setFilter(Texture.TextureFilter.Linear, Texture.TextureFilter.Linear);
		imgTriangleDown = new Texture("triangles.png");
		imgTriangleDown.setFilter(Texture.TextureFilter.Linear, Texture.TextureFilter.Linear);
		imgPlay = new Texture("BTPlay.png");
		imgPlay.setFilter(Texture.TextureFilter.Linear, Texture.TextureFilter.Linear);
		//********************************Preferences***********************************
		prefs = Gdx.app.getPreferences("pref");
		//********************************Music and sounds declarations***********************************
		music = Gdx.audio.newMusic(Gdx.files.getFileHandle("sound/Tango.mp3", Files.FileType.Internal));
		soundTouch = Gdx.audio.newSound(Gdx.files.getFileHandle("sound/7410.mp3", Files.FileType.Internal));
		soundLateral = Gdx.audio.newSound(Gdx.files.getFileHandle("sound/beep1.mp3", Files.FileType.Internal));
		soundFinal = Gdx.audio.newSound(Gdx.files.getFileHandle("sound/328.mp3", Files.FileType.Internal));
		soundFinal1 = Gdx.audio.newSound(Gdx.files.getFileHandle("sound/1386.mp3", Files.FileType.Internal));
		//********************************Bird creation and position on menu sreen***********************************
		bird = new Bird(GeneralStorage.w,GeneralStorage.h);
		bird.setPosition(GeneralStorage.w/2 - bird.getWidth()/2, GeneralStorage.h/2 - bird.getHeight()/2); // position on the middle screen
		color = GeneralStorage.bird.spBird.getColor();
	}

}
