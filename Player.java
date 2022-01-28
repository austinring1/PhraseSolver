/*
 * Activity 2.5.2
 * 
 * A Player class the PhraseSolverGame
 */
import java.util.Scanner;

public class Player
{
  /* your code here - attributes */

  private String name;

  private int points;

  /* your code here - constructor(s) */ 

  Scanner scanner = new Scanner(System.in);
  
  public Player(){
    System.out.print("Enter player name: ");
    name = scanner.nextLine();
    System.out.println("Welcome, " + name);
    points = 0;
  }

  public Player(String inputName){
    name = inputName;
    System.out.println("Welcome, " + name);
    points = 0;
  }


  /* your code here - accessor(s) */ 

  public String getName(){
    return name;
  }

  public int getPoints(){
    return points;
  }


  /* your code here - mutator(s) */ 

  public void setName(String inputName){
    name = inputName;
  }

  public void addToPoints(int value){
    points =+ value;
  }
}