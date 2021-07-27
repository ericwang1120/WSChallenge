package com.winesearcher.org.numberguessing;

import java.util.Random;

import com.winesearcher.org.numberguessing.guesser.DigitGuessingService;
import com.winesearcher.org.numberguessing.guesser.GuessingService;

/**
 * Start the auto guessing game application. The answer is a random positive
 * integer less than 10000. The guesser bot will provide a new guess every one
 * second until getting the answer correctly.
 * 
 * @author eric.wang
 */
public class GameApplication {
	public static void main(String[] args) throws Exception {
		int answer = new Random().nextInt(9999);
		Asker asker = new Asker(answer);
		GuessingService guesser = new DigitGuessingService();

		int nextGuess = guesser.guessFromClues(GuessingService.START_POINT);
		while (true) {
			if (nextGuess != answer) {
				Thread.sleep(1000);
				nextGuess = guesser.guessFromClues(asker.checkGuess(nextGuess));
			} else {
				System.out.println("got it!");
				break;
			}
		}
	}
}
