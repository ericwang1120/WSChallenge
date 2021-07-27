package com.winesearcher.org.numberguessing;

import java.util.stream.IntStream;

/**
 * This class stores the answer and checks how many digits a guess has got
 * right.
 * 
 * @author eric.wang
 */
public class Asker {
	private int answer;

	public Asker(int answer) {
		this.answer = answer;
		System.out.println("The correct answer is " + answer + ". Start guessing...");
	}

	/**
	 * @param guessNum
	 * @return how many digits the guess has got right
	 */
	public int checkGuess(int guessNum) {
		if (guessNum == answer) {
			return String.valueOf(answer).length();
		}

		String guessString = new StringBuilder(String.valueOf(guessNum)).reverse().toString();
		String answerString = new StringBuilder(String.valueOf(answer)).reverse().toString();

		int numberOfCorrectDigits = (int) IntStream.range(0, guessString.length())
				.filter(i -> answerString.charAt(i) == guessString.charAt(i)).count();

		String gameInfo = String.format("The answer %s got %s digits corrected", guessNum, numberOfCorrectDigits);
		System.out.println(gameInfo);
		return numberOfCorrectDigits;
	}
}
