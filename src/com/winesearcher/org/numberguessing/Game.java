package com.winesearcher.org.numberguessing;

import java.util.Random;

import com.winesearcher.org.numberguessing.guessers.DigitGuesser;
import com.winesearcher.org.numberguessing.guessers.Guesser;

public class Game {
	public static void main(String[] args) throws Exception {
		int answer = new Random().nextInt(9999);
		Asker asker = new Asker(answer);
		Guesser guesser = new DigitGuesser();

		int nextGuess = guesser.guessFromClues(-1);
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
