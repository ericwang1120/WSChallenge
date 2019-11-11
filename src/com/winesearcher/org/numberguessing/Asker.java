package com.winesearcher.org.numberguessing;

public class Asker {
	private int answer;

	public Asker(int answer) {
		this.answer = answer;
		System.out.println("The puzzle is " + answer + ". Start guessing...");
	}

	/**
	 * @param guessNum
	 * @return correct count of the guess
	 */
	public int checkGuess(int guessNum) {
		String guessString = String.valueOf(guessNum);
		if (guessNum == answer) {
			return guessString.length();
		} else {
			String answerString = String.valueOf(answer);
			int length = Math.min(answerString.length(), guessString.length());
			int result = 0;
			for (int i = 0; i < length; i++) {
				char answerChar = answerString.charAt(answerString.length() - i - 1);
				char guessChar = guessString.charAt(guessString.length() - i - 1);
				if (answerChar == guessChar) {
					result++;
				}
			}
			System.out.println("Guessed " + guessNum + ", got " + result + " digits corrected");
			return result;
		}
	}
}
