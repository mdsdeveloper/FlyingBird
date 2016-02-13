package com.touchBird.UpDate;

import com.badlogic.gdx.Gdx;
import com.touchBird.storage.GeneralStorage;
import com.touchBird.storage.MenuStorage;
import com.touchBird.storage.PauseStorage;
import com.touchBird.storage.RunningStorage;


public class PauseUpDate {
    private static float xMinBack,xMaxBack,yMinBack, yMaxBack, xMinPlay, xMaxPlay, yMinPlay, yMaxPlay;

    public static void upDate(){
        while (Gdx.input.isTouched(RunningStorage.pointer)) {
            RunningStorage.pointer++;
        }
        RunningStorage.currently_touch = RunningStorage.pointer;
        xMinBack = PauseStorage.spBack.getX();
        xMaxBack = PauseStorage.spBack.getX() + PauseStorage.spBack.getWidth();
        yMinBack = PauseStorage.spBack.getY();
        yMaxBack = PauseStorage.spBack.getY() + PauseStorage.spBack.getHeight();
        xMinPlay = PauseStorage.spPlay.getX();
        xMaxPlay = PauseStorage.spPlay.getX() + PauseStorage.spPlay.getWidth();
        yMinPlay = PauseStorage.spPlay.getY();
        yMaxPlay = PauseStorage.spPlay.getY() + PauseStorage.spPlay.getHeight();

        if(Gdx.input.isTouched() && RunningStorage.last_touched != RunningStorage.currently_touch) {
            if ((Gdx.input.getX() >= xMinBack) && (Gdx.input.getX() <= xMaxBack) && ((GeneralStorage.h - Gdx.input.getY()) >= yMinBack) && ((GeneralStorage.h - Gdx.input.getY()) <= yMaxBack)) {
                GeneralStorage.estado = GeneralStorage.state.running;

            } else if ((Gdx.input.getX() >= xMinPlay) && (Gdx.input.getX() <= xMaxPlay) && ((GeneralStorage.h - Gdx.input.getY()) >= yMinPlay) && ((GeneralStorage.h - Gdx.input.getY()) <= yMaxPlay)) {
                GeneralStorage.bird.setDirection_x(1);
                GeneralStorage.bird.spBird.setTexture(GeneralStorage.bird.imgBirdDC);
                GeneralStorage.bird.setPosition(GeneralStorage.w / 2 - GeneralStorage.bird.getWidth() / 2, GeneralStorage.h / 2 - GeneralStorage.bird.getHeight() / 2); // position on the middle screen
                if (GeneralStorage.music.isPlaying())
                    MenuStorage.spMusic.setTexture(GeneralStorage.imgMusic);
                else
                    MenuStorage.spMusic.setTexture(MenuStorage.imgMusic_off);
                GeneralStorage.estado = GeneralStorage.state.menu;
            }
        }
        RunningStorage.pointer = 0;
        RunningStorage.last_touched = RunningStorage.currently_touch;
    }

}
