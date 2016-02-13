package com.touchBird.draw;

import com.touchBird.general.MainFlyingBird;
import com.touchBird.storage.GameOverStorage;
import com.touchBird.storage.GeneralStorage;
import com.touchBird.storage.MenuStorage;


public class GameOverDraw {

	public static void draw(){
		GameOverStorage.spBackGround.draw(GeneralStorage.batch);
		GeneralStorage.btfTittle.draw(GeneralStorage.batch, "GAME OVER", (GeneralStorage.w-GeneralStorage.btfTittle.getBounds("GAME OVER").width)/2, GeneralStorage.h/2 + GeneralStorage.h/4);

		MenuStorage.fontPlay.draw(GeneralStorage.batch, "SCORE", (GeneralStorage.w / 2 - GeneralStorage.w/4 - MenuStorage.fontPlay.getBounds("SCORE").width/2), GeneralStorage.h / 6);
		MenuStorage.fontPlay.draw(GeneralStorage.batch, "BEST", (GeneralStorage.w - GeneralStorage.w/4 - MenuStorage.fontPlay.getBounds("BEST").width/2), GeneralStorage.h / 6 );


		MenuStorage.fontPlay.draw(GeneralStorage.batch, Integer.toString(MainFlyingBird.counter), (GeneralStorage.w / 2 - GeneralStorage.w/4 - MenuStorage.fontPlay.getBounds(Integer.toString(MainFlyingBird.counter)).width/2), (GeneralStorage.h / 6 - MenuStorage.fontPlay.getBounds("0").height - 10));
		MenuStorage.fontPlay.draw(GeneralStorage.batch, Integer.toString(GeneralStorage.prefs.getInteger("best",0)), (GeneralStorage.w - GeneralStorage.w/4 - MenuStorage.fontPlay.getBounds(Integer.toString(GeneralStorage.prefs.getInteger("best",0))).width/2), (GeneralStorage.h/6 - MenuStorage.fontPlay.getBounds("0").height - 10));

		GameOverStorage.spCirculo.draw(GeneralStorage.batch);
		if(GeneralStorage.estado == GeneralStorage.state.gameOver) {
			MenuStorage.spMusic.setTexture(GeneralStorage.imgBackMenu);
		}
		MenuStorage.spMusic.draw(GeneralStorage.batch);
		GameOverStorage.spShare.draw(GeneralStorage.batch);
		GameOverStorage.spLoaderBoard.setPosition(GeneralStorage.w - GeneralStorage.w / 4 - GameOverStorage.spLoaderBoard.getWidth() / 2, GeneralStorage.h / 4);
		GameOverStorage.spLoaderBoard.draw(GeneralStorage.batch);

	}
}
