package com.touchBird.general;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;


public class Button {
	private float x1, x2, y1, y2, newRatio;
	private Texture texture, imgButton = null;
	private String text = "";
	private BitmapFont fontPlay = null;
	private Sprite sp = null;

	public Button(Sprite sp1, String texto, BitmapFont fontPlay, float ratio) {
		text = texto;
		this.fontPlay = fontPlay;
		this.fontPlay.setScale(2 * ratio);
		x1 = sp1.getX();
		x2 = sp1.getX() + sp1.getWidth();
		y1 = sp1.getY();
		y2 = sp1.getY() + sp1.getHeight();
		sp = sp1;
		newRatio = ratio;
		imgButton = new Texture("buttonPlay.png"); // image of the boton play
		imgButton.setFilter(Texture.TextureFilter.Linear, Texture.TextureFilter.Linear);
	}

	public void draw(SpriteBatch batch) {
		sp.draw(batch);
		fontPlay.draw(batch, text, sp.getX() + (sp.getWidth() - fontPlay.getBounds(text).width) / 2, sp.getY() + (sp.getHeight() / 2) + (fontPlay.getBounds(text).height / 2));
	}



}
