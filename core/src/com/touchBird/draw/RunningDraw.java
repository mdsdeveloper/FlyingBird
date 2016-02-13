package com.touchBird.draw;

import com.badlogic.gdx.Gdx;
import com.touchBird.UpDate.RunningUpDate;
import com.touchBird.general.MainFlyingBird;
import com.touchBird.storage.GeneralStorage;
import com.touchBird.storage.MenuStorage;
import com.touchBird.storage.RunningStorage;

public class RunningDraw {

    public static void draw() {
        //here draw the background screen
        MenuStorage.spBackGroundGame.draw(GeneralStorage.batch);
        RunningStorage.spTriangleDown.draw(GeneralStorage.batch);
        RunningStorage.spTriangleUP.draw(GeneralStorage.batch);
        //here draw the circle count of the center screen
        RunningStorage.spCounter.draw(GeneralStorage.batch);
        //here draw the pause sprite
        RunningStorage.spPause.draw(GeneralStorage.batch);
        //here draw the number of count if is < that 10 adding zero
        if(MainFlyingBird.counter < 10)
            GeneralStorage.btfTittle.draw(GeneralStorage.batch, String.valueOf("0" + MainFlyingBird.counter), (GeneralStorage.w - GeneralStorage.btfTittle.getBounds(String.valueOf("0" + MainFlyingBird.counter)).width) / 2, GeneralStorage.h / 2 + GeneralStorage.h / 30);
        //here draw the number of count if is >= 10
        if(MainFlyingBird.counter >= 10)
            GeneralStorage.btfTittle.draw(GeneralStorage.batch, String.valueOf(MainFlyingBird.counter), (GeneralStorage.w - GeneralStorage.btfTittle.getBounds(String.valueOf(MainFlyingBird.counter)).width) / 2, GeneralStorage.h / 2 + GeneralStorage.h / 30);
        //here draw the bird
        GeneralStorage.bird.draw(GeneralStorage.batch);
        //here draw the spikes
        for (int i = 0; i < 18; i++) {
            RunningStorage.side_left[i].draw(GeneralStorage.batch);
            RunningStorage.side_right[i].draw(GeneralStorage.batch);
        }
        //Draw the bird particles.
        MainFlyingBird.particle1.draw(GeneralStorage.batch, Gdx.graphics.getDeltaTime());
        //here draw sides particles
        if (RunningUpDate.touchRight){
            MainFlyingBird.particleRight.draw(GeneralStorage.batch, Gdx.graphics.getDeltaTime());
        }
        if(RunningUpDate.touchLeft) {
            MainFlyingBird.particleLeft.draw(GeneralStorage.batch, Gdx.graphics.getDeltaTime());
        }
    }

}
