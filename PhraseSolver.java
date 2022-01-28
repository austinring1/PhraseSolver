/*
 * Activity 2.5.2
 *
 *  The PhraseSolver class the PhraseSolverGame
 */
import java.util.Scanner;
  
public class PhraseSolver
{
  /* your code here - attributes */

  private Player player1;

  private Player player2;

  private Board game;

  private boolean solved;

  /* your code here - constructor(s) */ 

  public PhraseSolver(){
    player1 = new Player();
    player2 = new Player();
    game = new Board();
    solved = false;
  }

  /* your code here - accessor(s) */
  
  /* your code here - mutator(s)  */

  public void play()
  {
    boolean solved = false;
    int currentPlayer = 1;
    int winningPlayer = 0;

    Scanner input = new Scanner(System.in);
    
    boolean correct = true;
    while (!solved) 
    {
      System.out.println(game.getSolvedPhrase());
      game.setLetterValue();
      System.out.println("The current letter value is: " + game.getLetterValue() + ".");
       


      if (currentPlayer == 1){
        System.out.print(player1.getName() + ", please enter a guess: ");
      }else{
        System.out.print(player2.getName() + ", please enter a guess: ");
      }

      String guess = input.nextLine();

     if(guess.length() == 1){ 

      if(game.guessLetter(guess) == true){
        if (currentPlayer == 1){
          player1.addToPoints(game.getLetterValue());
        }else{
          player2.addToPoints(game.getLetterValue());
        }
      }
      }else{

      if(game.isSolved(guess) == true){
        if (currentPlayer == 1){
          player1.addToPoints(game.getLetterValue());
          solved = true;
        }else{
          player2.addToPoints(game.getLetterValue());
          solved = true;
        }
      }
    }
    if(currentPlayer == 1){
      currentPlayer = 2;
    }else{
      currentPlayer = 1;
    }
    
    
    
 } 
 if(player1.getPoints() > player2.getPoints()){
  winningPlayer = 1;
}else if(player2.getPoints() > player1.getPoints()){
  winningPlayer = 2;
} 


 if(winningPlayer == 1){
  System.out.println("Congratulations, " + player1.getName() + ", you win!");
 }else if(winningPlayer == 2){
  System.out.println("Congratulations, " + player2.getName() + ", you win!");
 }else{
  System.out.println("It was a draw!");
 }
System.out.println(player1.getName() + " had " + player1.getPoints() + " points, and " + player2.getName() + " had " + player2.getPoints() + " points.");
}
  }

 