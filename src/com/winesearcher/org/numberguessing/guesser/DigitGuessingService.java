package com.winesearcher.org.numberguessing.guesser;

/**
 * DigitGuessingService is an implementation that takes and increments each
 * digit of the number.
 * <p>
 * Each increment triggers a calculation, calculating the digits to an integer.
 * see the {@link #getIntFromDigitArray()} method, then sent to the asker for
 * checking. @see#Asker.
 * 
 * @author eric.wang
 */
public class DigitGuessingService implements GuessingService {
	private int[] nextGuess;
	private int currentIndex = 3;
	private int digitOfCurrentIndex = 0;
	private int previousNumberOfCorrectDigits = 0;

	/**
	 * Initialize the digit array, the value of index 0 infers the thousands.
	 */
	public DigitGuessingService() {
		nextGuess = new int[] { 0, 0, 0, 0 };
	}

	/**
	 * This method mutates the current state of the digit array, snapshot the
	 * previous number of correct digits.
	 * <p>
	 * When the number of correct digits increases, jump to lower index. Otherwise
	 * increment the digit of the current index.
	 * 
	 * @param numberOfCorrectDigits this is from
	 *                              {@link com.winesearcher.org.numberguessing.Asker#checkGuess()}}
	 * @return guessedAnswer calculated from the digits array. @see
	 *         {@link #getIntFromDigitArray()}
	 */
	@Override
	public int guessFromClues(int numberOfCorrectDigits) {
		int guessedAnswer;
		if (numberOfCorrectDigits == GuessingService.START_POINT) {
			guessedAnswer = 0;
			System.out.println("Guesser guessed " + guessedAnswer);
			return guessedAnswer;
		}

		if (numberOfCorrectDigits > previousNumberOfCorrectDigits) {
			nextGuess[currentIndex] = digitOfCurrentIndex;
			currentIndex = currentIndex - 1;
			digitOfCurrentIndex = 1;
			nextGuess[currentIndex] = digitOfCurrentIndex;
		} else {
			digitOfCurrentIndex = digitOfCurrentIndex + 1;
			nextGuess[currentIndex] = digitOfCurrentIndex;
		}
		previousNumberOfCorrectDigits = numberOfCorrectDigits;
		guessedAnswer = getIntFromDigitArray(nextGuess);
		System.out.println("Guesser guessed " + guessedAnswer);
		return guessedAnswer;
	}

	/**
	 * @param digitsArray
	 * @return
	 */
	private int getIntFromDigitArray(int[] digitsArray) {
		int result = 0;
		for (int i = 0; i < digitsArray.length; i++) {
			result += Math.pow(10, (digitsArray.length - i - 1)) * digitsArray[i];
		}
		return result;
	}
}
