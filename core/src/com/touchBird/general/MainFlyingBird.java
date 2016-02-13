package com.touchBird.general;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.g2d.ParticleEffect;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.touchBird.UpDate.GameOverUpDate;
import com.touchBird.UpDate.MenuUpDate;
import com.touchBird.UpDate.PauseUpDate;
import com.touchBird.UpDate.PreGameOverUpDate;
import com.touchBird.UpDate.RunningUpDate;
import com.touchBird.draw.GameOverDraw;
import com.touchBird.draw.MenuDraw;
import com.touchBird.draw.PauseDraw;
import com.touchBird.draw.PreGameOverDraw;
import com.touchBird.draw.RunningDraw;
import com.touchBird.draw.SplashDraw;
import com.touchBird.storage.GameOverStorage;
import com.touchBird.storage.GeneralStorage;
import com.touchBird.storage.MenuStorage;
import com.touchBird.storage.PauseStorage;
import com.touchBird.storage.RunningStorage;
import com.touchBird.storage.SplashStorage;


public class MainFlyingBird extends ApplicationAdapter{
	public static Sprite spHelp = null;
	public static Color colorFondo;
	public static int timer,counter, randomNumber = 0;
	public static ParticleEffect particle1, particleLeft, particleRight = null;
    public static ActionResolver action;
    public MainFlyingBird(){
        action = action;
    }

	@Override
	public void create () {

		GeneralStorage.load();
		MenuStorage.load();
		SplashStorage.load();
		MenuStorage.load();
		PauseStorage.load();
		RunningStorage.load();
		GameOverStorage.load();

		GeneralStorage.estado = GeneralStorage.state.splash;
		MenuStorage.HelpTouched = false;
		//Init the particle effect
		particle1 = new ParticleEffect();
		particleLeft = new ParticleEffect();
		particleRight = new ParticleEffect();
		//load the particle, first parameter is path and name file when is the particle,
		//second one the fold when is the particle image.
		particle1.load(Gdx.files.internal("efectos/vuelo2"), Gdx.files.internal("efectos"));
		particleLeft.load(Gdx.files.internal("efectos/efLateral3"), Gdx.files.internal("efectos"));
		particleRight.load(Gdx.files.internal("efectos/efLateral3"), Gdx.files.internal("efectos"));
		//Sprites of button of the menu screen to music, sound and button help

		spHelp = new Sprite(GeneralStorage.imgBTHelp);
		spHelp.setSize(GeneralStorage.w / 10, GeneralStorage.w / 10);
		spHelp.setPosition(GeneralStorage.w - GeneralStorage.w / 4 - spHelp.getWidth() / 2, GeneralStorage.h / 4);

		//storage the background color
		colorFondo = MenuStorage.spBackGroundGame.getColor();
		//Time to splash screen.
		timer = 100;

	}
	//method of the random numbers
	public static int random_numbers(int min, int max){
		randomNumber = (int)(Math.random()*(max-min)+min);
		return randomNumber;
	}
	//this method put all counters at 0.
	public static void setGame(){
		for(int i=0; i < 18; i++){
			RunningStorage.side_left[i].setState(0);
			RunningStorage.side_right[i].setState(1);
			RunningStorage.side_left[i].setPosition(-RunningStorage.side_left[i].spSpike.getWidth(), (float) (GeneralStorage.h - GeneralStorage.h*0.1 - GeneralStorage.h*0.05*i));
			RunningStorage.side_right[i].setPosition(GeneralStorage.w,GeneralStorage.h - GeneralStorage.h*0.1f - GeneralStorage.h*0.05f*i);//
		}
		counter = 0;
		RunningStorage.changeState = false;
		MenuStorage.spBackGroundGame.setTexture(GeneralStorage.imgBackGround);
		MenuStorage.spBackGroundGame.setColor(colorFondo);
		RunningStorage.pointer = 0;
		RunningStorage.last_touched = 0;
		RunningStorage.array_aleatorios.clear();
		GeneralStorage.bird.spBird.setRotation(RunningStorage.posicion);
		GeneralStorage.bird.setVelocityY((float) (GeneralStorage.h * 0.10));
		GeneralStorage.bird.setDirection_x(1);
		GeneralStorage.bird.spBird.setTexture(GeneralStorage.bird.imgBirdDC);
		GeneralStorage.bird.setPosition(GeneralStorage.w / 2 - GeneralStorage.bird.getWidth() / 2, GeneralStorage.h / 2 - GeneralStorage.bird.getHeight() / 2); // position on the middle screen
		GeneralStorage.bird.spBird.setColor(GeneralStorage.color);
		MenuStorage.HelpTouched = false;
		// here reset the particles to restart the game.
		particle1.reset();
		RunningUpDate.touchLeft = false;
		RunningUpDate.touchRight = false;

		if(GameOverUpDate.isReview)
			GeneralStorage.estado = GeneralStorage.state.menu;
		else
			GeneralStorage.estado = GeneralStorage.state.running;
		GameOverUpDate.isReview = false;
	}
	@Override
	public void render () {
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT|GL20.GL_DEPTH_BUFFER_BIT|GL20.GL_STENCIL_BUFFER_BIT);

		GeneralStorage.batch.begin();

		switch(GeneralStorage.estado){
			case splash :

				SplashDraw.Draw();

				break;
			case menu :

				MenuUpDate.upDate();
				MenuDraw.draw();

				break;
			case running :

				RunningUpDate.update();
				RunningDraw.draw();

				break;
			case pause:

				PauseUpDate.upDate();
				PauseDraw.draw();

				break;
			case preGameOver :

				PreGameOverUpDate.upDate();
				PreGameOverDraw.draw();

				break;
			case gameOver :

				GameOverUpDate.upDate();
				GameOverDraw.draw();

				break;
		}

		GeneralStorage.batch.end();

	}
}
