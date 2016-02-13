package com.touchBird.UpDate;

import com.badlogic.gdx.Gdx;
import com.touchBird.general.MainFlyingBird;
import com.touchBird.storage.GameOverStorage;
import com.touchBird.storage.GeneralStorage;
import com.touchBird.storage.MenuStorage;
import com.touchBird.storage.RunningStorage;


public class GameOverUpDate {

	public static float w,h, xMinLDBoard, xMaxLDBoard, yMinLDBoard, yMaxLDBoard, xMinShare, xMaxShare, yMinShare, yMaxShare;
	public static boolean isReview = false;

	public static void upDate() {

		while(Gdx.input.isTouched(RunningStorage.pointer)){
			RunningStorage.pointer ++;
		}
		RunningStorage.currently_touch = RunningStorage.pointer;
		xMinShare = GameOverStorage.spShare.getX();
		xMaxShare = GameOverStorage.spShare.getX() + GameOverStorage.spShare.getWidth();
		yMinShare = GameOverStorage.spShare.getY();
		yMaxShare = GameOverStorage.spShare.getY() + GameOverStorage.spShare.getHeight();
		xMinLDBoard = MenuUpDate.xMinBTHelp;
		xMaxLDBoard = MenuUpDate.xMaxBTHelp;
		yMinLDBoard = MenuUpDate.yMinBTHelp;
		yMaxLDBoard = MenuUpDate.yMaxBTHelp;

		MenuStorage.fontPlay.setScale((float) (GeneralStorage.ratio*0.5));

		MenuUpDate.yMax = GameOverStorage.spCirculo.getY() + GameOverStorage.spCirculo.getHeight();
		MenuUpDate.yMin = GameOverStorage.spCirculo.getY();
		MenuUpDate.xMax = GameOverStorage.spCirculo.getX() + GameOverStorage.spCirculo.getWidth();
		MenuUpDate.xMin = GameOverStorage.spCirculo.getX();
		//here return to play the game
		if(Gdx.input.isTouched() && RunningStorage.last_touched != RunningStorage.currently_touch){
			if((Gdx.input.getX() >= MenuUpDate.xMin) && (Gdx.input.getX() <= MenuUpDate.xMax) && (((GeneralStorage.h - Gdx.input.getY()) <= MenuUpDate.yMax) && ((GeneralStorage.h - Gdx.input.getY()) >= MenuUpDate.yMin))){
				MainFlyingBird.particleRight.reset();
				MainFlyingBird.particleLeft.reset();
				MainFlyingBird.setGame();
			}
			else if ((Gdx.input.getX() >= MenuUpDate.xMinBTMusic) && (Gdx.input.getX() <= MenuUpDate.xMaxBTMusic) && (((GeneralStorage.h - Gdx.input.getY()) >= MenuUpDate.yMinBTMusic) && ((GeneralStorage.h - Gdx.input.getY()) <= MenuUpDate.yMaxBTMusic))) {
				if (GeneralStorage.music.isPlaying())
					MenuStorage.spMusic.setTexture(GeneralStorage.imgMusic);
				else
					MenuStorage.spMusic.setTexture(MenuStorage.imgMusic_off);
				isReview = true;
				MainFlyingBird.setGame();
			}
			else if ((Gdx.input.getX() >= xMinLDBoard) && (Gdx.input.getX() <= xMaxLDBoard) && (((GeneralStorage.h - Gdx.input.getY()) >= yMinLDBoard) && ((GeneralStorage.h - Gdx.input.getY()) <= yMaxLDBoard))) {

				MainFlyingBird.action.showScores();

			}
			else if ((Gdx.input.getX() >= xMinShare) && (Gdx.input.getX() <= xMaxShare) && (((GeneralStorage.h - Gdx.input.getY()) >= yMinShare) && ((GeneralStorage.h - Gdx.input.getY()) <= yMaxShare))) {
				MainFlyingBird.action.share(MainFlyingBird.counter);
			}
		}

		RunningStorage.pointer = 0;
		RunningStorage.last_touched = RunningStorage.currently_touch;
	}


}
