package com.winesearcher.org.numberguessing.guessers;

public class DigitGuesser implements Guesser {
	private int[] nextGuess;
	private int[][] matrix;
	private int xPointer = 3;
	private int yPointer = 0;
	private int currentRightDigitCount = 0;

	public DigitGuesser() {
		initMatrix();
		nextGuess = new int[] { 0, 0, 0, 0 };
	}

	@Override
	public int guessFromClues(int rightDigitCount) {
		if (rightDigitCount == -1) {
			return 0;
		} else if (currentRightDigitCount > rightDigitCount) {
			nextGuess[xPointer] = yPointer - 1;
			xPointer = xPointer - 1;
			yPointer = 1;
			nextGuess[xPointer] = yPointer;
		} else if (currentRightDigitCount < rightDigitCount) {
			nextGuess[xPointer] = yPointer;
			xPointer = xPointer - 1;
			yPointer = 1;
			nextGuess[xPointer] = yPointer;
		} else {
			yPointer = yPointer + 1;
			nextGuess[xPointer] = yPointer;
		}
		currentRightDigitCount = rightDigitCount;
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

	private void initMatrix() {
		matrix = new int[4][10];
		for (int i = 0; i < 4; i++) {
			for (int j = 0; j < 10; j++) {
				matrix[i][j] = j;
			}
		}
	}
}
