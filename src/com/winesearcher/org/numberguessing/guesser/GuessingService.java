package com.winesearcher.org.numberguessing.guesser;

/**
 * @author eric.wang
 */
public interface GuessingService {
	public static final int START_POINT = -1;

	/**
	 * @param numberOfCorrectDigits how many digits the guess has got right
	 * @return a new guessed answer
	 */
	int guessFromClues(int numberOfCorrectDigits);
}
