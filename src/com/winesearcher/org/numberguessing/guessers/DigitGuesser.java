package com.winesearcher.org.numberguessing.guessers;

public class DigitGuesser implements Guesser {
	private int[] nextGuess;
	private int currentPosition = 3;
	private int digitOnCurrentPosition = 0;
	private int previousCorrectDigit = 0;

	public DigitGuesser() {
		nextGuess = new int[] { 0, 0, 0, 0 };
	}

	@Override
	public int guessFromClues(int correctDigit) {
		if (correctDigit == -1) {
			return 0;
		} else if (previousCorrectDigit > correctDigit) {
			nextGuess[currentPosition] = digitOnCurrentPosition - 1;
			currentPosition = currentPosition - 1;
			digitOnCurrentPosition = 1;
			nextGuess[currentPosition] = digitOnCurrentPosition;
		} else if (previousCorrectDigit < correctDigit) {
			nextGuess[currentPosition] = digitOnCurrentPosition;
			currentPosition = currentPosition - 1;
			digitOnCurrentPosition = 1;
			nextGuess[currentPosition] = digitOnCurrentPosition;
		} else {
			digitOnCurrentPosition = digitOnCurrentPosition + 1;
			nextGuess[currentPosition] = digitOnCurrentPosition;
		}
		previousCorrectDigit = correctDigit;
		int result = getIntFromDigitArray(nextGuess);
		System.out.println("Guesser guessed " + result);
		return result;
	}

	public int getIntFromDigitArray(int[] intArray) {
		int result = 0;
		for (int i = 0; i < intArray.length; i++) {
			result += Math.pow(10, (intArray.length - i - 1)) * intArray[i];
		}
		return result;
	}
}
