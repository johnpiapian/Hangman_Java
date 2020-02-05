package Hangman;

public class Model {
    
    //Contruct words
    private final String[] wordList = {"aspect", "depart", "cold", "folk", "horn", "bench", "organ", "chorus", "coffin", "exceed", "eat"};
    
    //Variables
    private int attempts;
    private String wrongGuesses = "";
    private String wordToGuess = getRandomWord();
    private char[] wordToGuessChars = wordToGuess.toCharArray();
    private char[] wordToGuessCensor = wordToGuess.toCharArray();
    //private char[] wrongGuesses = new char[7];
    
    //Reset & Regenerate all variables
    public void init(){
        attempts = 0;
        wordToGuess = "";
        wrongGuesses = "";
        wordToGuess = getRandomWord();
        wordToGuessChars = wordToGuess.toCharArray();
        wordToGuessCensor = wordToGuess.toCharArray();
        for (int index = 0; index < wordToGuess.length(); index++) {
            wordToGuessCensor[index] = '_';
        }
    }
    
    //This will be used to select a random word from wordList array
    private int generateRandomNo(int min, int max){
        return (int)(Math.random() * (max + 1 - min)) + min;
    }
    
    //get a random word
    private String getRandomWord(){
        return wordList[generateRandomNo(0, wordList.length - 1)];
    }
    
    //***Setters & Getters

    public int getAttempts() {
        return attempts;
    }

    public void setAttempts(int attempts) {
        this.attempts = attempts;
    }

    public String getWordToGuess() {
        return wordToGuess;
    }

    public void setWordToGuess(String wordToGuess) {
        this.wordToGuess = wordToGuess;
    }

    public char[] getWordToGuessChars() {
        return wordToGuessChars;
    }

    public void setWordToGuessChars(char[] wordToGuessChars) {
        this.wordToGuessChars = wordToGuessChars;
    }

    public char[] getWordToGuessCensor() {
        return wordToGuessCensor;
    }

    public void setWordToGuessCensor(char[] wordToGuessCensor) {
        this.wordToGuessCensor = wordToGuessCensor;
    }
    
    public void setWordToGuessCensorIndex(int index, char value){
        this.wordToGuessCensor[index] = value;
    }

    public String getWrongGuesses() {
        return wrongGuesses;
    }

    public void setWrongGuesses(String wrongGuesses) {
        this.wrongGuesses = wrongGuesses;
    }
    
}
