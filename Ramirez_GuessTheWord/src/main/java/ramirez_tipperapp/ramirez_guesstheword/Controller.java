/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ramirez_tipperapp.ramirez_guesstheword;
import java.util.ArrayList;
/**
 *
 * @author angelramirez-rivera
 */


public class Controller {
    private Model model = new Model();
    private View view = new View();

    public void playGame() {
        model.chooseWord();
        view.displayword(model.wordDisplay());

        while (!model.isGameOver()) {
            String guess = view.getGuess();
            if (guess.equalsIgnoreCase("quit")) {
                view.displayExitMessage();
                return;
            }

            boolean correct = model.checkGuess(guess);
            if (correct) {
                view.displayWin(model.getChosenWord());
                break;
            } else {
                view.displayword(model.wordDisplay());
                view.displayPreviousIncorrectGuesses(model.getIncorrectGuesses());
            }
        }

        if (model.isGameOver()) {
            view.displayLose(model.getChosenWord());
        }

        ArrayList<String> guessedWords = new ArrayList<>();
        guessedWords.add(model.getChosenWord());
        guessedWords.addAll(model.getIncorrectGuesses());
        view.displayGuessedWords(guessedWords);

        view.displayPlayAgainPrompt();
        String playAgain = view.getGuess();
        if (playAgain.equalsIgnoreCase("yes")) {
            playGame();
        } else {
            view.displayExitMessage();
        }
    }
}