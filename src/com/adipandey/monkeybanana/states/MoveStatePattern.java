package com.adipandey.monkeybanana.states;

import com.adipandey.monkeybanana.MonkeyStatePattern;
import com.adipandey.monkeybanana.Constants;
import com.adipandey.monkeybanana.Monkey;

public class MoveStatePattern extends MonkeyStatePattern {

	public MonkeyStatePattern keyUp(Monkey monkey) {
		monkey.setY(monkey.getY() - Constants.BOX);
		monkey.setMonkeyStatePattern(this);
		return this;
	}

	public MonkeyStatePattern keyDown(Monkey monkey) {
		monkey.setY(monkey.getY() + Constants.BOX);
		monkey.setMonkeyStatePattern(this);
		return this;
	}

	public MonkeyStatePattern keyLeft(Monkey monkey) {
		monkey.setX(monkey.getX() - Constants.BOX);
		monkey.setMonkeyStatePattern(this);
		return this;
	}

	public MonkeyStatePattern keyRight(Monkey monkey) {
		monkey.setX(monkey.getX() + Constants.BOX);
		monkey.setMonkeyStatePattern(this);
		return this;
	}

	public MonkeyStatePattern keyReleased(Monkey monkey) {
		monkey.setMonkeyStatePattern(new RestStatePattern());
		return new RestStatePattern();
	}
}
