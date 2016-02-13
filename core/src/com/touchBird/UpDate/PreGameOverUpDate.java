package com.touchBird.UpDate;

import com.badlogic.gdx.math.MathUtils;
import com.touchBird.C.C;
import com.touchBird.general.MainFlyingBird;
import com.touchBird.storage.GeneralStorage;

public class PreGameOverUpDate {

	public static void upDate(){

		if(GeneralStorage.bird.getY() <= (GeneralStorage.h/10))
			GeneralStorage.bird.setVelocityY((float) (GeneralStorage.h * 0.10));
		//Here is the time to splash screen.
		if(MainFlyingBird.timer > 0  && GeneralStorage.estado == GeneralStorage.state.preGameOver){
			MainFlyingBird.timer --;
			if(MainFlyingBird.timer == 0){
				if(MathUtils.random(0,100) < C.Percent) // here is de percentage of times that show admob intertitial
					MainFlyingBird.action.showOrLoadInterstital();

				GeneralStorage.estado = GeneralStorage.state.gameOver;
			}
		}
		//Here when the bird arrive right side change direction.
		if(GeneralStorage.bird.getX() + GeneralStorage.bird.getWidth() >= GeneralStorage.w)
			GeneralStorage.bird.setDirection_x(GeneralStorage.bird.getDirection_x() * -1);
		//Here when the bird arrive left side change direction.
		if(GeneralStorage.bird.getX() <= 0)
			GeneralStorage.bird.setDirection_x(GeneralStorage.bird.getDirection_x()*-1);

		//Here i reduce speed of bird.
		GeneralStorage.bird.setVelocityY((float) (GeneralStorage.bird.getVelocidadY() - GeneralStorage.h * 0.01));
		GeneralStorage.bird.move();
		GeneralStorage.bird.spBird.setOrigin(GeneralStorage.bird.getWidth() / 2, GeneralStorage.bird.getHeight() / 2); // center
		GeneralStorage.bird.spBird.setRotation(GeneralStorage.bird.spBird.getRotation() + 30);

	}

}
