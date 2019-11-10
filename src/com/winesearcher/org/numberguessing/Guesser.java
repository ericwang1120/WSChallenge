package com.winesearcher.org.numberguessing;

import java.util.Map;

public class Guesser {
	private final int lengthOfPuzzle;
	private int noMatchNum = -1;
	private int nextGuess = 0;
	private Map<Integer, Integer> numberCountMap;
	private int remainingCount;

	public Guesser(int lengthOfPuzzle) {
		if (lengthOfPuzzle > 8) {
			throw new UnsupportedOperationException();
		}
		this.lengthOfPuzzle = lengthOfPuzzle;
		this.remainingCount = lengthOfPuzzle;
	}

	public void recordGuess(int guessNum, int correctCount) {
		if (correctCount == 0) {
			if (noMatchNum == -1) {
				noMatchNum = guessNum;
			}
		}
		numberCountMap.put(guessNum, correctCount);
		remainingCount = remainingCount - correctCount;
	}

	public int nextGuess() {
		return nextGuess;
	}
}
