package com.winesearcher.org.numberguessing.guessers;

/**
 * @author eric.wang
 *
 */
public interface Guesser {
	/**
	 * @param correctNum
	 *            Correct count of the previous guess.
	 * @return new guess
	 */
	int guessFromClues(int correctCount);
}
