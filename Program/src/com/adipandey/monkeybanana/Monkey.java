package com.adipandey.monkeybanana;

import java.awt.image.BufferedImage;
import java.io.IOException;
import java.net.URL;
import java.util.Random;

import javax.imageio.ImageIO;

import com.adipandey.monkeybanana.states.RestStatePattern;

public class Monkey {

	private int x;
	private int y;
	private BufferedImage monkeyImage;
	private MonkeyStatePattern monkeyStatePattern;

	public Monkey() {
		monkeyStatePattern = new RestStatePattern();
        randomNumberGeneratorMonkey();
    }

	public void setMonkeyStatePattern(MonkeyStatePattern newMonkeyStatePattern) {
		monkeyStatePattern = newMonkeyStatePattern;
	}

	public BufferedImage getMonkeyImage() {
		URL monkeyResource = getClass().getResource("/media/monkey.png");
		try {
			monkeyImage = ImageIO.read(monkeyResource);
		} catch (IOException e) {
			e.printStackTrace();
		}
		return monkeyImage;
	}

	public Monkey randomNumberGeneratorMonkey() {
		Random random = new Random();
		x = random.nextInt(19) * Constants.BOX;
		y = random.nextInt(19) * Constants.BOX;
		if (x >= Constants.WIDTH || y >= Constants.HEIGHT)
			randomNumberGeneratorMonkey();
        if (x <0 || y< 0){
            randomNumberGeneratorMonkey();
        }

		return this;
	}

	public MonkeyStatePattern keyUp(Monkey monkey) {
		return monkeyStatePattern.keyUp(this);
	}

	public MonkeyStatePattern keyDown(Monkey monkey) {
		return monkeyStatePattern.keyDown(this);
	}

	public MonkeyStatePattern keyLeft(Monkey monkey) {
		return monkeyStatePattern.keyLeft(this);
	}

	public MonkeyStatePattern keyRight(Monkey monkey) {
		return monkeyStatePattern.keyRight(this);
	}

	public MonkeyStatePattern keyReleased(Monkey monkey) {
		return monkeyStatePattern.keyReleased(this);
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
