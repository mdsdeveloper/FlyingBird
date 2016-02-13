package com.touchBird.general;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;


public class Bird {
	public Sprite spBird = null;
	public Texture imgBirdDC = null;
	private float width,height, velocityY =0;
	private int direction_x = 1;  // 1 if bird go to right and -1 if bird go to left.
	private float time_x = 2;

	public Bird(float w, float h){
		imgBirdDC = new Texture("bird1.png");
		imgBirdDC.setFilter(Texture.TextureFilter.Linear, Texture.TextureFilter.Linear);
		spBird = new Sprite(imgBirdDC);
		spBird.setSize(h/20, h/20);
		width = w;
		height = h;
	}

	public float getWidth(){
		return spBird.getWidth();
	}
	public float getHeight(){
		return spBird.getHeight();
	}
	public void setPosition(float x, float y){
		spBird.setPosition(x, y);
	}
	public float getX(){
		return spBird.getX();
	}
	public float getY(){
		return spBird.getY();
	}
	public void draw(SpriteBatch batch){
		spBird.draw(batch);
	}
	public void rotation(){
		spBird.setRotation(90);
	}
	public float getVelocidadY(){
		return velocityY;
	}
	public int getDirection_x(){
		return direction_x;
	}
	public void move(){
		setPosition(getX() + (width/getTime_x())*Gdx.graphics.getDeltaTime()* getDirection_x(), getY() + (getVelocidadY())*Gdx.graphics.getDeltaTime()*4);
	}

	public float getTime_x() {
		return time_x;
	}

	public void setTime_x(float time_x) {
		this.time_x = time_x;
	}

	public void setDirection_x(int direction_x) {
		this.direction_x = direction_x;
	}

	public void setVelocityY(float velocidadY) {
		this.velocityY = velocidadY;
	}
	public void setTexture(Texture tex){
		spBird.setTexture(tex);
	}

}
