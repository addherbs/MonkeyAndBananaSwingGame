
package com.adipandey.monkeybanana.states;

import com.adipandey.monkeybanana.MonkeyStatePattern;
import com.adipandey.monkeybanana.Constants;
import com.adipandey.monkeybanana.Monkey;

public class RestStatePattern extends MonkeyStatePattern {

	public MonkeyStatePattern keyUp(Monkey monkey) {
		monkey.setY(monkey.getY() - Constants.BOX);
		monkey.setMonkeyStatePattern(new MoveStatePattern());
		return new MoveStatePattern();
	}

	public MonkeyStatePattern keyRight(Monkey monkey) {
		monkey.setX(monkey.getX() + Constants.BOX);
		monkey.setMonkeyStatePattern(new MoveStatePattern());
		return new MoveStatePattern();
	}

	public MonkeyStatePattern keyDown(Monkey monkey) {
		monkey.setY(monkey.getY() + Constants.BOX);
		monkey.setMonkeyStatePattern(new MoveStatePattern());
		return new MoveStatePattern();
	}

	public MonkeyStatePattern keyLeft(Monkey monkey) {
		monkey.setX(monkey.getX() - Constants.BOX);
		monkey.setMonkeyStatePattern(new MoveStatePattern());
		return new MoveStatePattern();
	}

}
