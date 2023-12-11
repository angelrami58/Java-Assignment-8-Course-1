/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ramirez_tipperapp.ramirez_guesstheword;


import java.util.Random;
import java.util.ArrayList;
/**
 *
 * @author angelramirez-rivera
 */
public class Model {

    private static final String[] words= {"tupac", "biggy", "lilwayne", "drake", "jcole","dreamville","kendrick","popsmoke","rap","music"};
    private Random rand = new Random();
    private String chosenWord;
    private int maxGuesses = 10;
    private int numGuesses = 0;
    private ArrayList<String> incorrectGuesses = new ArrayList<String>();

    public void chooseWord() {
        int index = rand.nextInt(words.length);
        chosenWord = words[index];
    }

    public boolean checkGuess(String guess) {
        boolean correct = false;
        if (guess.equalsIgnoreCase(chosenWord)) {
            correct = true;
        } else {
            numGuesses++;
            if (!incorrectGuesses.contains(guess)) {
                incorrectGuesses.add(guess);
            }
        }
        return correct;
    }

    public String getChosenWord() {
        return chosenWord;
    }

    public int getMaxGuesses() {
        return maxGuesses;
    }

    public int getNumGuesses() {
        return numGuesses;
    }

    public ArrayList<String> getIncorrectGuesses() {
        return incorrectGuesses;
    }

    public boolean isGameOver() {
        if (numGuesses >= maxGuesses || !wordDisplay().contains("-")) {
            return true;
        } else {
            return false;
        }
    }

    public String wordDisplay() {
        StringBuilder wordDisplay = new StringBuilder();
        for (int i = 0; i < chosenWord.length(); i++) {
            char c = chosenWord.charAt(i);
            if (incorrectGuesses.contains(Character.toString(c))) {
                wordDisplay.append(c);
            } else {
                wordDisplay.append("-");
            }
        }
        return wordDisplay.toString();
    }
}