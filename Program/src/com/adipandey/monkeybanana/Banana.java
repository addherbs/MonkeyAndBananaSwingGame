package com.adipandey.monkeybanana;

import java.awt.image.BufferedImage;
import java.io.IOException;
import java.net.URL;
import java.util.Random;

import javax.imageio.ImageIO;

public class Banana {

	private int x;
	private int y;
	private BufferedImage bananaImage;

	public BufferedImage getBananaImage() {
		URL bananaResource = getClass().getResource("/media/banana.png");
		try {
			bananaImage = ImageIO.read(bananaResource);
		} catch (IOException e) {
			e.printStackTrace();
		}
		return bananaImage;
	}

	public Banana randomNumberGenerator() {
		Random random = new Random();
		x = random.nextInt(20) * Constants.BOX;
		y = random.nextInt(20) * Constants.BOX;
		if (x >= Constants.WIDTH || y >= Constants.HEIGHT)
			randomNumberGenerator();

		if (x <0 || y< 0){
			randomNumberGenerator();
		}
		return this;
	}

	public int getX() {
		return x;
	}

	public int getY() {
		return y;
	}

	public void setX(int x) {
		this.x = x;
	}

	public void setY(int y) {
		this.y = y;
	}
}
