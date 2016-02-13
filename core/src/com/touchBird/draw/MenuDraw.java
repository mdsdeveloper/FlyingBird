package com.touchBird.draw;

import com.touchBird.general.MainFlyingBird;
import com.touchBird.storage.GameOverStorage;
import com.touchBird.storage.GeneralStorage;
import com.touchBird.storage.MenuStorage;
import com.touchBird.storage.SplashStorage;

public class MenuDraw {

	/**
	 * This class draw the menu screen
	 * and help screen.
	 */
	public static void draw(){
		MenuStorage.spBackGroundGame.draw(GeneralStorage.batch);
		MenuStorage.button_play.draw(GeneralStorage.batch);

		GeneralStorage.bird.draw(GeneralStorage.batch);
		MenuStorage.fontPlay.setScale(GeneralStorage.ratio);
		MenuStorage.fontPlay.draw(GeneralStorage.batch, "FLYING BIRD", (GeneralStorage.w - MenuStorage.fontPlay.getBounds("FLYING BIRD").width) / 2, GeneralStorage.h / 2 + GeneralStorage.h / 4);
		//here change the texture music when touch the button
		if (GeneralStorage.music.isPlaying())
			MenuStorage.spMusic.setTexture(GeneralStorage.imgMusic);
		else
			MenuStorage.spMusic.setTexture(MenuStorage.imgMusic_off);
		MenuStorage.spMusic.draw(GeneralStorage.batch);
		// here change the texture sound when touch the button
		if (GeneralStorage.isTouch)
			MenuStorage.spSound.setTexture(MenuStorage.imgSound_off);
		else
			MenuStorage.spSound.setTexture(GeneralStorage.imgSound);
		MenuStorage.spSound.draw(GeneralStorage.batch);
		MainFlyingBird.spHelp.draw(GeneralStorage.batch);
		GameOverStorage.spLoaderBoard.draw(GeneralStorage.batch);
		MenuStorage.spFavorite.setPosition(GeneralStorage.w - GeneralStorage.w / 4 - GeneralStorage.w / 8 - MenuStorage.spFavorite.getWidth() / 2, GeneralStorage.h / 6);
		MenuStorage.spFavorite.draw(GeneralStorage.batch);
		// if is touch change the screen
		if(MenuStorage.HelpTouched){
			SplashStorage.spBackGroundSplash.draw(GeneralStorage.batch);
			MenuStorage.fontHelp.setScale((float) (GeneralStorage.ratio));
			MenuStorage.fontHelp.draw(GeneralStorage.batch, GeneralStorage.str_a[0], (GeneralStorage.w - GeneralStorage.w / 2 - MenuStorage.fontHelp.getBounds(GeneralStorage.str_a[0]).width / 2), GeneralStorage.h - 40);
			MenuStorage.fontHelp.draw(GeneralStorage.batch, GeneralStorage.str_a[1], (GeneralStorage.w - GeneralStorage.w) + 20, GeneralStorage.h - 150);
			MenuStorage.fontHelp.draw(GeneralStorage.batch, GeneralStorage.str_a[2], (GeneralStorage.w - GeneralStorage.w) + 20, GeneralStorage.h - 230);
			MenuStorage.fontHelp.draw(GeneralStorage.batch, GeneralStorage.str_a[3], (GeneralStorage.w - GeneralStorage.w) + 20, GeneralStorage.h - 310);
			MenuStorage.fontHelp.draw(GeneralStorage.batch, GeneralStorage.str_a[4], (GeneralStorage.w - GeneralStorage.w) + 20, GeneralStorage.h - 390);
			MenuStorage.fontHelp.draw(GeneralStorage.batch, GeneralStorage.str_a[5], (GeneralStorage.w - GeneralStorage.w) + 20, GeneralStorage.h - 470);
			MenuStorage.fontHelp.draw(GeneralStorage.batch, GeneralStorage.str_a[6], (GeneralStorage.w - GeneralStorage.w) + 20, GeneralStorage.h - 550);
			// here put bird on help screen
			MenuStorage.spBirdD.setPosition((GeneralStorage.w - GeneralStorage.w / 2 - MenuStorage.fontHelp.getBounds(GeneralStorage.str_a[0]).width - GeneralStorage.bird.getWidth()), GeneralStorage.h - 90);
			MenuStorage.spBirdD.draw(GeneralStorage.batch);
			MenuStorage.spBirdI.setPosition((GeneralStorage.w - GeneralStorage.w / 2 + MenuStorage.fontHelp.getBounds(GeneralStorage.str_a[0]).width), GeneralStorage.h - 90);
			MenuStorage.spBirdI.draw(GeneralStorage.batch);
			MainFlyingBird.spHelp.draw(GeneralStorage.batch);
		}


	}
}
