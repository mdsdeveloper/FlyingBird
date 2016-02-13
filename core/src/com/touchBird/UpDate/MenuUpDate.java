package com.touchBird.UpDate;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.scenes.scene2d.ui.TextField;
import com.touchBird.general.MainFlyingBird;
import com.touchBird.storage.GameOverStorage;
import com.touchBird.storage.GeneralStorage;
import com.touchBird.storage.MenuStorage;
import com.touchBird.storage.RunningStorage;

public class MenuUpDate {
    private static boolean touch_up;
    public static float xMin, xMax, yMax, yMin, xMinLDBoard, xMaxLDBoard, yMinLDBoard, yMaxLDBoard, xMinFavorite, xMaxFavorite, yMinFavorite, yMaxFavorite;
    public static float xMinBTMusic, xMaxBTMusic, yMinBTMusic, yMaxBTMusic, xMinBTSound, xMaxBTSound, yMinBTSound, yMaxBTSound, xMinBTHelp, xMaxBTHelp, yMinBTHelp, yMaxBTHelp;
    TextField.TextFieldClickListener click;

    public static void upDate() {

        while (Gdx.input.isTouched(RunningStorage.pointer)) {
            RunningStorage.pointer++;
        }
        RunningStorage.currently_touch = RunningStorage.pointer;
        GameOverStorage.spLoaderBoard.setPosition(GeneralStorage.w - GeneralStorage.w / 2 - GeneralStorage.w / 8 - GameOverStorage.spLoaderBoard.getWidth() / 2, GeneralStorage.h / 6);


        xMinBTMusic = MenuStorage.spMusic.getX();
        xMaxBTMusic = MenuStorage.spMusic.getX() + MenuStorage.spMusic.getWidth();
        yMinBTMusic = MenuStorage.spMusic.getY();
        yMaxBTMusic = MenuStorage.spMusic.getY() + MenuStorage.spMusic.getHeight();
        xMinBTSound = MenuStorage.spSound.getX();
        xMaxBTSound = MenuStorage.spSound.getX() + MenuStorage.spSound.getWidth();
        yMinBTSound = MenuStorage.spSound.getY();
        yMaxBTSound = MenuStorage.spSound.getY() + MenuStorage.spSound.getHeight();
        xMinBTHelp = MainFlyingBird.spHelp.getX();
        xMaxBTHelp = MainFlyingBird.spHelp.getX() + MainFlyingBird.spHelp.getWidth();
        yMinBTHelp = MainFlyingBird.spHelp.getY();
        yMaxBTHelp = MainFlyingBird.spHelp.getY() + MainFlyingBird.spHelp.getHeight();
        xMinLDBoard = GameOverStorage.spLoaderBoard.getX();
        xMaxLDBoard = GameOverStorage.spLoaderBoard.getX() + GameOverStorage.spLoaderBoard.getWidth();
        yMinLDBoard = GameOverStorage.spLoaderBoard.getY();
        yMaxLDBoard = GameOverStorage.spLoaderBoard.getY() + GameOverStorage.spLoaderBoard.getHeight();
        xMinFavorite = MenuStorage.spFavorite.getX();
        xMaxFavorite = MenuStorage.spFavorite.getX() + MenuStorage.spFavorite.getWidth();
        yMinFavorite = MenuStorage.spFavorite.getY();
        yMaxFavorite = MenuStorage.spFavorite.getY() + MenuStorage.spFavorite.getHeight();

        //if bird arrive to down or up limit, change the variable touch_up to true or false.
        if (GeneralStorage.bird.getY() + GeneralStorage.bird.getHeight() >= MenuStorage.spButton.getY() + (MenuStorage.spButton.getHeight() - MenuStorage.spButton.getHeight() / 9))
            touch_up = false;
        if (GeneralStorage.bird.getY() <= (MenuStorage.spButton.getY() + MenuStorage.spButton.getHeight() / 9))
            touch_up = true;

        yMax = MenuStorage.spButton.getY() + MenuStorage.spButton.getHeight();
        yMin = MenuStorage.spButton.getY();
        xMax = MenuStorage.spButton.getX() + MenuStorage.spButton.getWidth();
        xMin = MenuStorage.spButton.getX();

        //Here the bird move down or up on button play for 2 pixels.
        if (touch_up == true) {
            GeneralStorage.bird.setPosition(GeneralStorage.bird.getX(), GeneralStorage.bird.getY() + 2);
        }
        if (touch_up == false) {
            GeneralStorage.bird.setPosition(GeneralStorage.bird.getX(), GeneralStorage.bird.getY() - 2);
        }
        //Here change screen to running screen.
        if (Gdx.input.isTouched() && RunningStorage.last_touched != RunningStorage.currently_touch) {
            if ((Gdx.input.getX() >= xMin) && (Gdx.input.getX() <= xMax) && (((GeneralStorage.h - Gdx.input.getY()) <= yMax) && ((GeneralStorage.h - Gdx.input.getY()) >= yMin)) && !MenuStorage.HelpTouched) {
                MainFlyingBird.setGame();
                GeneralStorage.music.setVolume(.3f);
            } else if ((Gdx.input.getX() >= xMinBTMusic) && (Gdx.input.getX() <= xMaxBTMusic) && (((GeneralStorage.h - Gdx.input.getY()) >= yMinBTMusic) && ((GeneralStorage.h - Gdx.input.getY()) <= yMaxBTMusic)) && !MenuStorage.HelpTouched) {
                if (GeneralStorage.music.isPlaying()) {
                    GeneralStorage.music.pause();
                    GeneralStorage.isActive = true;
                    MenuStorage.spMusic.setTexture(MenuStorage.imgMusic_off);
                } else {
                    GeneralStorage.music.play();
                    GeneralStorage.isActive = false;
                    MenuStorage.spMusic.setTexture(GeneralStorage.imgMusic);
                }
            } else if ((Gdx.input.getX() >= xMinBTSound) && (Gdx.input.getX() <= xMaxBTSound) && (((GeneralStorage.h - Gdx.input.getY()) >= yMinBTSound) && ((GeneralStorage.h - Gdx.input.getY()) <= yMaxBTSound)) && !MenuStorage.HelpTouched) {
                if (!GeneralStorage.isTouch) {
                    GeneralStorage.soundTouch.stop();
                    GeneralStorage.soundLateral.stop();
                    GeneralStorage.soundFinal.stop();
                    GeneralStorage.soundFinal1.stop();
                    GeneralStorage.isTouch = true;
                    MenuStorage.spSound.setTexture(MenuStorage.imgSound_off);
                } else if (GeneralStorage.isTouch) {
                    GeneralStorage.isTouch = false;
                    MenuStorage.spSound.setTexture(GeneralStorage.imgSound);
                }
            } else if ((Gdx.input.getX() >= xMinBTHelp) && (Gdx.input.getX() <= xMaxBTHelp) && (((GeneralStorage.h - Gdx.input.getY()) >= yMinBTHelp) && ((GeneralStorage.h - Gdx.input.getY()) <= yMaxBTHelp)) && !MenuStorage.HelpTouched) {
                MainFlyingBird.spHelp.setTexture(MenuStorage.imgButtonBack);
                MainFlyingBird.spHelp.setPosition(GeneralStorage.w / 2 - MainFlyingBird.spHelp.getWidth() / 2, GeneralStorage.h / 10);
                MenuStorage.HelpTouched = true;
            } else if ((Gdx.input.getX() >= xMinBTHelp) && (Gdx.input.getX() <= xMaxBTHelp) && (((GeneralStorage.h - Gdx.input.getY()) >= yMinBTHelp) && ((GeneralStorage.h - Gdx.input.getY()) <= yMaxBTHelp)) && MenuStorage.HelpTouched) {
                MenuStorage.HelpTouched = false;
                MainFlyingBird.spHelp.setTexture(GeneralStorage.imgBTHelp);
                MainFlyingBird.spHelp.setPosition(GeneralStorage.w - GeneralStorage.w / 4 - MainFlyingBird.spHelp.getWidth() / 2, GeneralStorage.h / 4);

            } else if ((Gdx.input.getX() >= xMinLDBoard) && (Gdx.input.getX() <= xMaxLDBoard) && (((GeneralStorage.h - Gdx.input.getY()) >= yMinLDBoard) && ((GeneralStorage.h - Gdx.input.getY()) <= yMaxLDBoard))) {

                MainFlyingBird.action.showScores();

            } else if ((Gdx.input.getX() >= xMinFavorite) && (Gdx.input.getX() <= xMaxFavorite) && (((GeneralStorage.h - Gdx.input.getY()) >= yMinFavorite) && ((GeneralStorage.h - Gdx.input.getY()) <= yMaxFavorite))) {

                MainFlyingBird.action.rate();

            }
        }
        GeneralStorage.music.setLooping(true);
        if (!GeneralStorage.isActive) {
            GeneralStorage.music.play();
        }

        RunningStorage.pointer = 0;
        RunningStorage.last_touched = RunningStorage.currently_touch;

    }
}

