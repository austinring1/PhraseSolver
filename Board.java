/*
 * Activity 2.5.2
 *
 * A Board class the PhraseSolverGame
 */
import java.util.Scanner;
import java.io.File;

public class  Board
{
  private String phrase = "";
  private String solvedPhrase = "";
  private int currentLetterValue; 

  /* your code here - constructor(s) */ 

  public Board(){
    setLetterValue();
    phrase = loadPhrase();
    loadPhrase();
  }
  
  /* your code here - accessor(s) */
  
  public String getPhrase(){
    return phrase;
  }

  public String getSolvedPhrase() {
    return solvedPhrase;
  }


  public int getLetterValue(){
    return currentLetterValue;
  }
  /* your code here - mutator(s)  */


  /* ---------- provided code, do not modify ---------- */
  public void setLetterValue()
  {
    int randomInt = (int) ((Math.random() * 10) + 1) * 100;    
    currentLetterValue = randomInt;
  }

  public boolean isSolved(String guess)
  {
    if (phrase.equals(guess))
    {
      return true;
    }
    return false;
  }

  private String loadPhrase()
  {
    String tempPhrase = "";
    
    int numOfLines = 0;
    try 
    {
      Scanner sc = new Scanner(new File("phrases.txt"));
      while (sc.hasNextLine())
      {
        tempPhrase = sc.nextLine().trim();
        numOfLines++;
      }
    } catch(Exception e) { System.out.println("Error reading or parsing phrases.txt"); }
    
		int randomInt = (int) ((Math.random() * numOfLines) + 1);
    
    try 
    {
      int count = 0;
      Scanner sc = new Scanner(new File("phrases.txt"));
      while (sc.hasNextLine())
      {
        count++;
        String temp = sc.nextLine().trim();
        if (count == randomInt)
        {
          tempPhrase = temp;
        }
      }
    } catch (Exception e) { System.out.println("Error reading or parsing phrases.txt"); }
    
    for (int i = 0; i < tempPhrase.length(); i++)
    {
      if (tempPhrase.substring(i, i + 1).equals(" "))
      {
        solvedPhrase += "  ";
      }  
      else
      {
        solvedPhrase += "_ ";
      }
    }  
    
    return tempPhrase;
  }  

  public boolean guessLetter(String guess)
  
  /* Compares the guessed letter to the phrase, and returns true or false depending on the outcome.
   *
   *  Precondition:
   *        "phrase" is properly loaded.
   * 
   *  Postcondition:
   *        The for loop must terminate properly, and the if statement must work for all values of guess.
   */  
  {
    boolean foundLetter = false;
    //sets the boolean checking whether or not the player has found the letter to false.

    String newSolvedPhrase = "";
    //a placeholder String that will be filled with text later.

    
    for (int i = 0; i < phrase.length(); i++)
    {
      if (phrase.substring(i, i + 1).equals(guess))
      {
        //for loop and if statement which checks for each letter of the guess if it equals the corresponding letter of the phrase. 
        
        newSolvedPhrase += guess + " ";
        foundLetter = true;
        //if the letters are the same, foundLetter is set to true because it was found.
      }
      else
      {
        newSolvedPhrase += solvedPhrase.substring(i * 2, i * 2 + 1) + " ";  
        //if the letters aren't the same, this line makes the if statement check after the last try.
      }
    }
    solvedPhrase = newSolvedPhrase;
    return foundLetter;
    //returns the value of foundLetter.
  } 
} 