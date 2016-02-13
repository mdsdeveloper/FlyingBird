package com.touchBird.UpDate;


import com.badlogic.gdx.Gdx;
import com.touchBird.general.MainFlyingBird;
import com.touchBird.storage.GeneralStorage;
import com.touchBird.storage.MenuStorage;
import com.touchBird.storage.RunningStorage;

public class RunningUpDate {


	public static boolean touchRight, touchLeft = false;

	public static void update(){
		while(Gdx.input.isTouched(RunningStorage.pointer)){
			RunningStorage.pointer++;
		}
		RunningStorage.currently_touch = RunningStorage.pointer;

		//Here change the screen color.
		if(MainFlyingBird.counter > 5 )
			MenuStorage.spBackGroundGame.setColor(228/255f, 241/255f, 254/255f, 1);
		if(MainFlyingBird.counter > 10)
			MenuStorage.spBackGroundGame.setColor(197/255f, 239/255f, 247/255f, 1);
		if(MainFlyingBird.counter > 15)
			MenuStorage.spBackGroundGame.setColor(82/255f, 179/255f, 217/255f, 1);
		if(MainFlyingBird.counter > 20)
			MenuStorage.spBackGroundGame.setColor(34/255f, 167/255f, 240/255f, 1);
		if(MainFlyingBird.counter > 30)
			MenuStorage.spBackGroundGame.setColor(58/255f, 83/255f, 155/255f, 1);
		if(MainFlyingBird.counter > 50)
			MenuStorage.spBackGroundGame.setColor(52/255f, 33/255f, 94/255f, 1);
		if(MainFlyingBird.counter > 70)
			MenuStorage.spBackGroundGame.setColor(103/255f, 128/255f, 159/255f, 1);
		if(MainFlyingBird.counter > 85)
			GeneralStorage.bird.spBird.setColor(107 / 255f, 185 / 255f, 240 / 255f, 1);


		//if last touch is other than new touch, reload your velocity (velocity is the bird move on Y direction).
		if(Gdx.input.isTouched() && RunningStorage.last_touched != RunningStorage.currently_touch){
			if ((Gdx.input.getX() >= RunningStorage.xMinPause) && (Gdx.input.getX() <= RunningStorage.xMaxPause) && ((GeneralStorage.h - Gdx.input.getY()) >= RunningStorage.yMinPause) && ((GeneralStorage.h - Gdx.input.getY()) <= RunningStorage.yMaxPause)) {
				GeneralStorage.estado = GeneralStorage.state.pause;
			}
			if(!GeneralStorage.isTouch)
				GeneralStorage.soundTouch.play();
			//Here change the texture to peak open right.
			if(GeneralStorage.bird.getDirection_x() > 0)
				GeneralStorage.bird.spBird.setTexture(GeneralStorage.imgBirdDA);
				//Here change the texture to peak open left.
			else
				GeneralStorage.bird.spBird.setTexture(GeneralStorage.imgBirdIA);
			MainFlyingBird.particle1.start();
			GeneralStorage.bird.setVelocityY((float) (GeneralStorage.h * 0.10));
		}
		//if bird go to right and your velocity arrive to <= count time_open then change the bird texture to close peak.
		if(GeneralStorage.bird.getVelocidadY() <= RunningStorage.time_open && GeneralStorage.bird.getDirection_x() > 0){
			GeneralStorage.bird.spBird.setTexture(GeneralStorage.bird.imgBirdDC);
		}
		//if bird go to left and your velocity arrive to <= count time_open then change the bird texture to close peak.
		if(GeneralStorage.bird.getDirection_x() <= 0 && GeneralStorage.bird.getVelocidadY() <= RunningStorage.time_open){
			GeneralStorage.bird.spBird.setTexture(GeneralStorage.imgBirdIC);
		}
		//Here i reduce speed of bird.
		GeneralStorage.bird.setVelocityY((float) (GeneralStorage.bird.getVelocidadY() - GeneralStorage.h * 0.005));

		//Here when arrive to right side.
		if(GeneralStorage.bird.getX() + GeneralStorage.bird.getWidth() >= GeneralStorage.w && GeneralStorage.bird.getDirection_x() > 0){
			MainFlyingBird.particleRight.setPosition(GeneralStorage.bird.getX() + GeneralStorage.bird.getWidth(), GeneralStorage.bird.getY() + GeneralStorage.bird.getHeight() / 2);
			MainFlyingBird.particleRight.start();
			touchRight = true;
			touchLeft = false;
			if(!GeneralStorage.isTouch)
				GeneralStorage.soundLateral.play(0.2f); //start the lateral sonud
			GeneralStorage.bird.setDirection_x(GeneralStorage.bird.getDirection_x() * -1); //change direction
			GeneralStorage.bird.spBird.setTexture(GeneralStorage.imgBirdIC); //change bird texture to close left.
			MainFlyingBird.counter ++; //increase the count.
			for(int i=0; i < 18; i++){
				RunningStorage.side_right[i].setState(1);
			}
			RunningStorage.array_aleatorios.clear();
			RunningStorage.posicion_pinchos = 0;

			for(int i=0; i < RunningStorage.pinchos_movidos; i++){
				RunningStorage.posicion_pinchos = MainFlyingBird.random_numbers(2, 15);
				if(RunningStorage.array_aleatorios.size() == 0)  // aqui si es el primer pincho lo meto sin comprobar su posicion
					RunningStorage.array_aleatorios.add(RunningStorage.posicion_pinchos);

				else{	//if isn't first spike, i do a while loop to verify if array list not contain the position, otherwise i generate other ramdon number.
					while(RunningStorage.array_aleatorios.contains(RunningStorage.posicion_pinchos)){
						RunningStorage.posicion_pinchos = MainFlyingBird.random_numbers(2, 15);
					}
					RunningStorage.array_aleatorios.add(RunningStorage.posicion_pinchos);
				}
			}
			for(int i=0; i < RunningStorage.array_aleatorios.size(); i++){
				RunningStorage.side_left[RunningStorage.array_aleatorios.get(i)].setState(1);
			}
		}

		//Here when arrive to left side.
		if(GeneralStorage.bird.getX() <= 0 && GeneralStorage.bird.getDirection_x() < 0){
			MainFlyingBird.particleLeft.setPosition(GeneralStorage.bird.getX(), GeneralStorage.bird.getY() + GeneralStorage.bird.getHeight() / 2);
			MainFlyingBird.particleLeft.start();
			touchLeft = true;
			touchRight = false;
			if(!GeneralStorage.isTouch)
				GeneralStorage.soundLateral.play(0.2f);//start the lateral sonud
			GeneralStorage.bird.setDirection_x(GeneralStorage.bird.getDirection_x()*-1);
			GeneralStorage.bird.spBird.setTexture(GeneralStorage.bird.imgBirdDC); //change bird texture to close right.
			MainFlyingBird.counter ++;
			for(int i=0; i < 18; i++){
				RunningStorage.side_left[i].setState(0);
			}
			RunningStorage.array_aleatorios.clear();
			RunningStorage.posicion_pinchos = 0;
			for(int i=0; i < RunningStorage.pinchos_movidos; i++){
				RunningStorage.posicion_pinchos = MainFlyingBird.random_numbers(2, 15);
				if(RunningStorage.array_aleatorios.size() == 0)  //here if is the first spike, add to array list without verify the position.
					RunningStorage.array_aleatorios.add(RunningStorage.posicion_pinchos);
				else{	//if isn't first spike, i do a while loop to verify if array list not contain the position, otherwise i generate other ramdon number.
					while(RunningStorage.array_aleatorios.contains(RunningStorage.posicion_pinchos)){
						RunningStorage.posicion_pinchos = MainFlyingBird.random_numbers(2, 15);
					}
					RunningStorage.array_aleatorios.add(RunningStorage.posicion_pinchos);
				}
			}

			for(int i=0; i < RunningStorage.array_aleatorios.size(); i++){
				RunningStorage.side_right[RunningStorage.array_aleatorios.get(i)].setState(0);
			}
		}


		GeneralStorage.bird.move();
		//if bird go to right i introduce the particle.
		if(GeneralStorage.bird.getDirection_x() > 0) {
			MainFlyingBird.particle1.setPosition(GeneralStorage.bird.getX(), GeneralStorage.bird.getY()+ GeneralStorage.bird.getHeight()/2 );
		}
		else{//if bird go to left i introduce the particle.
			MainFlyingBird.particle1.setPosition(GeneralStorage.bird.getX() + GeneralStorage.bird.getWidth(), GeneralStorage.bird.getY() + GeneralStorage.bird.getHeight() / 2);
		}
		//here move the spikes.
		for(int i=0; i < 18 ; i++){
			RunningStorage.side_left[i].move();
			RunningStorage.side_right[i].move();
		}
		//here increase dificult.
		if(MainFlyingBird.counter >= 0 && MainFlyingBird.counter <= 3) {
			RunningStorage.pinchos_movidos = 2;
		}
		if(MainFlyingBird.counter >= 4 && MainFlyingBird.counter <= 7){
			RunningStorage.pinchos_movidos = 3;
		}
		if(MainFlyingBird.counter >= 8 && MainFlyingBird.counter <= 10){
			RunningStorage.pinchos_movidos = 4;
		}
		if(MainFlyingBird.counter >= 10 && MainFlyingBird.counter <= 14){
			RunningStorage.pinchos_movidos = 5;
		}
		if(MainFlyingBird.counter >= 14 && MainFlyingBird.counter <= 19){
			RunningStorage.pinchos_movidos = 6;
		}

		//here if bird touch the down or up screen change the screen game to game over.
		if((GeneralStorage.bird.getY() + GeneralStorage.bird.getHeight()) >= (GeneralStorage.h - GeneralStorage.h/10) && RunningStorage.last_touched == 0){
			RunningStorage.changeState = true;
		}
		if(GeneralStorage.bird.getY() <= (GeneralStorage.h/10) && RunningStorage.last_touched == 0){
			RunningStorage.changeState = true;
		}
		//here verify if bird touch same spike.
		if(GeneralStorage.bird.getDirection_x() < 0){  //if bird is going to left.
			for(int i=0; i < RunningStorage.array_aleatorios.size(); i++){ //this for loop runs array with outside spikes.
				// this if verify the bird position if is equals to spike position.
				if((GeneralStorage.bird.getX() < RunningStorage.side_left[RunningStorage.array_aleatorios.get(i)].getX() + RunningStorage.side_left[RunningStorage.array_aleatorios.get(i)].getWidth()/3)
						&& (GeneralStorage.bird.getY() + GeneralStorage.bird.getHeight() > RunningStorage.side_left[RunningStorage.array_aleatorios.get(i)].getY()+15)
						&& (GeneralStorage.bird.getY() < RunningStorage.side_left[RunningStorage.array_aleatorios.get(i)].getY() + RunningStorage.side_left[RunningStorage.array_aleatorios.get(i)].getHeight()- RunningStorage.side_left[RunningStorage.array_aleatorios.get(i)].getHeight()/3 )){
					RunningStorage.changeState = true;
				}
			}
		}
		else{
			for(int i=0; i < RunningStorage.array_aleatorios.size(); i++){
				if((GeneralStorage.bird.getX() + GeneralStorage.bird.getWidth() > RunningStorage.side_right[RunningStorage.array_aleatorios.get(i)].getX() + (RunningStorage.side_right[RunningStorage.array_aleatorios.get(i)].getWidth())*3/4)
						&& (GeneralStorage.bird.getY() + GeneralStorage.bird.getHeight() > RunningStorage.side_right[RunningStorage.array_aleatorios.get(i)].getY() + 15)
						&& (GeneralStorage.bird.getY() < RunningStorage.side_right[RunningStorage.array_aleatorios.get(i)].getY() + RunningStorage.side_right[RunningStorage.array_aleatorios.get(i)].getHeight() - RunningStorage.side_right[RunningStorage.array_aleatorios.get(i)].getHeight()/3)){
					RunningStorage.changeState = true;
				}
			}
		}

		if(MainFlyingBird.counter >= GeneralStorage.prefs.getInteger("best", 0)){
			GeneralStorage.prefs.putInteger("best", MainFlyingBird.counter);
			GeneralStorage.prefs.flush();
		}
		RunningStorage.best = GeneralStorage.prefs.getInteger("best",0);
		RunningStorage.pointer = 0;
		RunningStorage.last_touched = RunningStorage.currently_touch;
		RunningStorage.currently_touch = 0;
		if(RunningStorage.changeState){
			if(!GeneralStorage.isTouch) {
				GeneralStorage.soundFinal.play();
				GeneralStorage.soundFinal1.play();
			}
			RunningStorage.array_aleatorios.clear();
			MainFlyingBird.timer = 100;
			RunningStorage.posicion = GeneralStorage.bird.spBird.getRotation(); //here i save the last rotation bird.
			MainFlyingBird.action.submitScore(MainFlyingBird.counter);
			GeneralStorage.estado = GeneralStorage.state.preGameOver;
		}

	}

}
