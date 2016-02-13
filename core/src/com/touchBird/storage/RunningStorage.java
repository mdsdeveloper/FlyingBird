package com.touchBird.storage;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.touchBird.general.Spike;
import java.util.ArrayList;



public class RunningStorage {

	public static Sprite spCounter, spPause, spTriangleUP, spTriangleDown =  null;
	public static int pointer,currently_touch,last_touched,pinchos_movidos,posicion_pinchos,best = 0;
	public static float time_open, posicion, xMinPause, xMaxPause, yMinPause, yMaxPause=0;  // This is the time of the peak bird open
	public static ArrayList<Integer> array_aleatorios = null;
	public static Spike[] side_right = new Spike[18];	// spikes right
	public static Spike[] side_left = new Spike[18];	// spike left
	public static boolean changeState = false;
	public static Texture imgPause = null;

	public static void load(){
		spCounter = new Sprite(GeneralStorage.imgCounter);
		spCounter.setSize(GeneralStorage.h / 5, GeneralStorage.h / 5);
		spCounter.setPosition(GeneralStorage.w / 2 - spCounter.getWidth() / 2, GeneralStorage.h / 2 - spCounter.getHeight() / 2);
		time_open =(float) (GeneralStorage.h*0.08);
		array_aleatorios = new ArrayList<Integer>();
		array_aleatorios.clear();
		imgPause = new Texture("pause.png");
		imgPause.setFilter(Texture.TextureFilter.Linear, Texture.TextureFilter.Linear);
		spPause = new Sprite(imgPause);
		spPause.setSize(GeneralStorage.w / 7, GeneralStorage.w / 7);
		spPause.setPosition(GeneralStorage.w - GeneralStorage.w / 2 - spPause.getWidth() / 2, GeneralStorage.h - 140);
		spTriangleDown = new Sprite(GeneralStorage.imgTriangleDown);
		spTriangleDown.setSize(GeneralStorage.w, GeneralStorage.h / 9);
		spTriangleDown.setPosition(0, 0);
		spTriangleUP = new Sprite(GeneralStorage.imgTriangleUP);
		spTriangleUP.setSize(GeneralStorage.w, GeneralStorage.h / 10);
		spTriangleUP.setOrigin(spTriangleUP.getWidth() / 2, spTriangleUP.getHeight() / 2);
		spTriangleUP.rotate(180);
		spTriangleUP.setPosition(0, GeneralStorage.h - spTriangleUP.getHeight());
		xMinPause = spPause.getX();
		xMaxPause = spPause.getX() + spPause.getWidth();
		yMinPause = spPause.getY();
		yMaxPause = spPause.getY() + spPause.getHeight();

		for(int i=0; i < 18; i++){
			side_right[i] = new Spike(GeneralStorage.w, GeneralStorage.h,1); // 1 if it is side right.
			side_right[i].setPosition(GeneralStorage.w, GeneralStorage.h - GeneralStorage.h*0.1f - GeneralStorage.h*0.05f*i);//
			side_right[i].setState(1);
			side_left[i] = new Spike(GeneralStorage.w, GeneralStorage.h,0); // 0 if it is side left.
			side_left[i].setPosition(-side_left[i].spSpike.getWidth(), (float) (GeneralStorage.h - GeneralStorage.h*0.1 - GeneralStorage.h*0.05*i));
			side_left[i].setState(0);
		}

	}

}

