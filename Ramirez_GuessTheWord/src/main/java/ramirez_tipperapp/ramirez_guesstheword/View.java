/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ramirez_tipperapp.ramirez_guesstheword;
import java.util.Scanner;
import java.util.ArrayList;

/**
 *
 * @author angelramirez-rivera
 */
public class View {
    
    private Scanner scanner = new Scanner(System.in);

    public void displayword(String wordDisplay) {
        System.out.println("Guess the word: " + wordDisplay);
    }

    public void displayGuessedWords(ArrayList<String> guessedWords) {
        System.out.println("Guessed words: " + guessedWords);
    }

    public String getGuess() {
        System.out.print("Guess a word (or enter 'quit' to exit): ");
        String guess = scanner.nextLine();
        return guess;
    }

    public void displayWin(String word) {
        System.out.println("Congratulations! You guessed the word: " + word);
    }

    public void displayLose(String word) {
        System.out.println("Sorry, you ran out of guesses. The word was: " + word);
    }

    public void displayPreviousIncorrectGuesses(ArrayList<String> incorrectGuesses) {
        System.out.println("Previous incorrect guesses: " + incorrectGuesses);
    }

    public void displayPlayAgainPrompt() {
        System.out.print("Would you like to play again? (yes or no): ");
    }

    public void displayExitMessage() {
        System.out.println("Thanks for playing!");
    }
}