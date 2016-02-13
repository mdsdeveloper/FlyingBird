package com.touchBird.draw;

import com.touchBird.general.MainFlyingBird;
import com.touchBird.storage.GeneralStorage;
import com.touchBird.storage.MenuStorage;
import com.touchBird.storage.SplashStorage;

public class SplashDraw {

	public static void Draw(){
		//here with each render delta time rest one time and during this time draw the splash sceen
		if(MainFlyingBird.timer > 0 && GeneralStorage.estado == GeneralStorage.state.splash){
			MainFlyingBird.timer --;
			if(MainFlyingBird.timer == 0){
				GeneralStorage.estado = GeneralStorage.state.menu;
			}
		}
		SplashStorage.spBackGroundSplash.draw(GeneralStorage.batch);
		GeneralStorage.btfTittle.draw(GeneralStorage.batch, "MAGUI STUDIO", (GeneralStorage.w - GeneralStorage.btfTittle.getBounds("MAGUI STUDIO").width) / 2, GeneralStorage.h - GeneralStorage.h/3);
		MenuStorage.fontHelp.setScale(GeneralStorage.ratio);
		GeneralStorage.fontPresent.draw(GeneralStorage.batch, "Presents", (GeneralStorage.w - SplashStorage.btfSplash.getBounds("Presents").width) / 2, GeneralStorage.h/2 + 70);// - SplashStorage.btfSplash.getBounds("presents").height * 2);

	}
}
