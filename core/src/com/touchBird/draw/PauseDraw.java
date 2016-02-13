package com.touchBird.draw;

import com.touchBird.storage.GeneralStorage;
import com.touchBird.storage.PauseStorage;

public class PauseDraw {

    public static void draw(){
        RunningDraw.draw();
        PauseStorage.spPause.draw(GeneralStorage.batch);
        GeneralStorage.btfTittle.draw(GeneralStorage.batch, "PAUSE", (GeneralStorage.w- GeneralStorage.btfTittle.getBounds("PAUSE").width)/2, GeneralStorage.h/2 + GeneralStorage.h/4);

        PauseStorage.spPlay.draw(GeneralStorage.batch);
        PauseStorage.spBack.draw(GeneralStorage.batch);
    }
}
