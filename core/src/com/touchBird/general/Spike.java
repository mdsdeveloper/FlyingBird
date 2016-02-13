package com.touchBird.general;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.touchBird.storage.GeneralStorage;

public class Spike {

	public Sprite spSpike;
	private float height, width=0;
	private int state, side = 0; // state 0 = left and state 1 = right. Side 1 = spike right and side 0 = spike left
	private float time =(float) 0.5; // time to go out the spike

	public Spike(float w, float h, int orientation){
		side = orientation;
		if(orientation == 0){
			spSpike = new Sprite(GeneralStorage.imgTriangleI);
		}
		else
			spSpike = new Sprite(GeneralStorage.imgTriangleD);

		height = h;
		width = w;
		spSpike.setSize(h*0.05f, h*0.05f);

	}
	public void draw(SpriteBatch batch){
		spSpike.draw(batch);
	}
	public float getX(){
		return spSpike.getX();
	}
	public float getY(){
		return spSpike.getY();
	}
	public float getHeight(){
		return spSpike.getHeight();
	}
	public float getWidth(){
		return spSpike.getWidth();
	}
	public void setPosition(float x, float y){
		spSpike.setPosition(x, y);
	}
	public void move(){
		if(side == 0){
			if(getState() == 0){
				if(getX() - (getWidth()/ time)*Gdx.graphics.getDeltaTime() <= - getWidth()){
					setPosition(- getWidth(),getY());
				}
				else{
					setPosition(getX() - (getWidth()/time)*Gdx.graphics.getDeltaTime(),getY());
				}
			}
			if(getState() == 1){
				if(getX() + (getWidth()/ time)*Gdx.graphics.getDeltaTime() >= 0){
					setPosition(0, getY());
				}
				else{
					setPosition(getX() + (getWidth()/ time)*Gdx.graphics.getDeltaTime(), getY());
				}
			}
		}
		else{
			if(getState() == 0){
				if(getX() - (getWidth()/ time)*Gdx.graphics.getDeltaTime() <= GeneralStorage.w - getWidth()){
					setPosition(GeneralStorage.w - getWidth(),getY());
				}
				else{
					setPosition(getX() - (getWidth()/time)*Gdx.graphics.getDeltaTime(),getY());
				}
			}
			if(getState() == 1){
				if(getX() + (getWidth()/ time)*Gdx.graphics.getDeltaTime() >= GeneralStorage.w){
					setPosition(GeneralStorage.w, getY());
				}
				else{
					setPosition(getX() + (getWidth()/ time)*Gdx.graphics.getDeltaTime(), getY());
				}
			}
		}
	}
	public int getState() {
		return state;
	}
	public void setState(int estado) {
		this.state = estado;
	}

}
