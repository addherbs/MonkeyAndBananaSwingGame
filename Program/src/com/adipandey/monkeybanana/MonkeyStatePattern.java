package com.adipandey.monkeybanana;

public abstract class MonkeyStatePattern {

	public MonkeyStatePattern keyUp(Monkey monkey) {
		return this.keyUp(monkey);
	}

	public MonkeyStatePattern keyRight(Monkey monkey) {
		return this.keyRight(monkey);
	}

	public MonkeyStatePattern keyDown(Monkey monkey) {
		return this.keyDown(monkey);
	}

	public MonkeyStatePattern keyLeft(Monkey monkey) {
		return this.keyLeft(monkey);
	}

	public MonkeyStatePattern keyReleased(Monkey monkey) {
		return this.keyReleased(monkey);
	}
}
