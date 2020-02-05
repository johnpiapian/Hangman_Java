package Hangman;

public class Controller {
    private final Model model;
    private final View view;
    
    Controller(){
        this.model = new Model();
        this.view = new View();
    }
    
    public void Start(){
        view.intro();
        // Don't exit the game until the user decides to
        while(view.startGame() == 1){
            Game();
        }
        view.outro();
    }
    
    public void Game(){
        
        model.init();
        view.startMatch();
        boolean quit = false;
        
        do{
            //Check if the user has successfully guesseed all chars
            if(!String.valueOf(model.getWordToGuessCensor()).equals(model.getWordToGuess())){
                view.remainingAttempts(model.getAttempts()+1, 8);
                view.wrongGuesses(model.getWrongGuesses());
                view.printChars(model.getWordToGuessCensor(), " ");
                
                String currentGuess = view.getString().toLowerCase();

                if(currentGuess.toLowerCase().equals("0")){//check quit
                    quit = true;
                }else{
                    char currentChar = currentGuess.charAt(0);
                    boolean isCorrect = false;
                    
                    for(int i = 0; i < model.getWordToGuessChars().length; i++){
                        if(model.getWordToGuessChars()[i] ==  currentChar){//if guessed corretly
                           isCorrect = true;
                           model.setWordToGuessCensorIndex(i, currentChar);
                        }
                    }
                    
                    if(!isCorrect){
                        model.setWrongGuesses(model.getWrongGuesses() + currentChar +", ");
                    }
                    
                    model.setAttempts(model.getAttempts() + 1);  
                }
                //Check if guess limit is reached
                if(model.getAttempts() >= 7 && !String.valueOf(model.getWordToGuessCensor()).equals(model.getWordToGuess())){
                    view.guessLimitError();
                    quit = true;
                    break;
                }               
            }else{
                view.gameWon(model.getWordToGuess(), model.getAttempts());
                quit = true;
            }
        }while(!quit);
    }
}
