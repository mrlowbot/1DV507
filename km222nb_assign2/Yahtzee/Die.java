package km222nb_assign2.Yahtzee;

import java.util.Random;

/**
 * Anyways cannot be 100% sure about this game because i have never played it
 * before nor do i know what the point is so there might be some errors. At
 * least i hope there won't be any. Just tired to play Yahtzee online... but i
 * still don't get the game... i am trying to figure it out! let's go!
 * 
 * @author Karwan
 *
 */

public class Die {
	static final int DieSides = 6;
	private int side;
	private int value;

	public Die() {
		Random random = new Random();
		side = DieSides; // Standard die
		value = random.nextInt(side) + 1; 
	}

	public Die(int startValue) {
		side = DieSides;
		value = startValue;

	}

	public Die(int startValue, int maxSides) {
		side = maxSides; //
		value = startValue;
	}

	public void roll() {
		Random random = new Random();
		value = random.nextInt(side) + 1;
	}

	public int getValue() {
		return value;
	}

	public int getSides() {
		return side;
	}
}
