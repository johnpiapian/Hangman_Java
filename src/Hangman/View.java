package Hangman;

import java.util.ArrayList;
import java.util.Scanner;

public class View {
    
    private Scanner input = new Scanner(System.in);
    
    public String getString(){
        return input.nextLine();
    }
    
    public void intro(){
        System.out.println("This game is like a Hangman game where you guess the missing letters of a word which are represented by underscores(_).\n"
                        + "You will be given 7 times to guess all the missing letters correctly, failing to do so wihtin the given\n"
                        + "amount of guesses will result in a game over. To prevent repeated incorrect guesses, your incorrect guesses\n"
                        + "will be shown to you through out the game. Upon guessing a correct letter you will be notified and the missing letter will be filled.\n");
    }
    
    public void outro(){
        System.out.println("\nThank you for playing the game. Goodbye!");
    }
    
    //print censor chars
    public void printChars(char[] chars, String seperator){
        for(int i=0; i < chars.length; i++){
            System.out.print(chars[i] + seperator);
        }
        System.out.println("");
    }
   
    public int startGame(){
        System.out.print("Enter 1 to start a new game, or 0 to quit: ");
        return Integer.parseInt(input.nextLine());
    }
    
    public void startMatch(){
        System.out.println("Start guessing, or enter 0 to quit!");
    }
    
    public void remainingAttempts(int currentAttempts, int totalAttempts){
        System.out.println("No of remaining attempts: "+(totalAttempts - currentAttempts));
    }
    
    public void wrongGuesses(String str){
        System.out.println("Wrong guesses: "+ str);
    }
    
    public void guessLimitError(){
        System.out.println("You lost! Guess limit has been reached!");
    }
    
    public void gameWon(String word, int attempts){
        System.out.println("The word is "+ word);
        System.out.println("Congratulations! You guessed the entire word correctly! Attempts taken("+attempts+")");
    }
    
}
