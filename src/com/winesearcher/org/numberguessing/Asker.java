package com.winesearcher.org.numberguessing;

public class Asker {
	private int answer;

	public Asker(int answer) {
		this.answer = answer;
	}

	/**
	 * @param guessNum
	 * @return correct count of the guess
	 */
	public int checkGuess(int guessNum) {
		if (guessNum == answer) {
			return String.valueOf(guessNum).length();
		}
		return 0;
	}
}
