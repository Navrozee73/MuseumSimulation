import java.util.*;
/*
BASED ON PROTOTYPE
User: Navroze
Date: 10/06/2020
Changes Made:
               - Made start menu
               
               
*/
import java.util.*;

public class MuseumRunner
{
   public static void main (String [] args)
   {
      int input;
      Museum museum;
      boolean museumMade = false;
      Scanner sc = new Scanner(System.in);
      do
      { 	
         printStartMenu();
         input = sc.nextInt();
         if (input == 1)
         {
            try
            {
               museum = makeNewMuseum(sc);
               museumMade = true;
            } 
            catch (Exception e)
            {
               System.out.println ("Error creating museum. Check values and formatting are correct.");
               input = 0;	//resets to 0 so loops again 
            }
        } 
        else if (input == 2) 
        {
         		try
            {
              	museum = loadNewMuseum();
              	museumMade = true;
            }
          	catch (FileNotFoundException ef)
            {
              	System.out.println ("Error finding file.");
              	input = 0;
            }
          	catch (Exception e)
          	{
              	System.out.println ("Error loading museum. Check file format is correct.")
                input = 0;
          	}	
        } 
        else if (input == 3)
        {
          try
          {
            	saveMuseum(museum);
          }
          catch (Exception e)
          {
            	System.out.println("Error saving museum")
          }
        }
  		} while (input != 0 );
   }
   
   private static void printStartMenu()
   {
      System.out.println ("Choose from the below options, or hit 0 to return");
      System.out.println ("1) Make New Museum (WARNING: THIS WILL OVERRIDE ANY PREVIOUSLY SAVED FILES)");
      System.out.println ("2) Load previously stored museum information");
      System.out.println ("3) Save current museum information");
      System.out.println ("4) Begin Simulation");
   }
   
   private static Museum makeNewMuseum(Scanner sc)
   {
      String stringDate;
      int makeDisplay, maxStorage;
      System.out.print ("Enter opening date (dd/mm/yyyy C.E/B.C.E)  : ");
      stringDate = sc.nextLine();
      System.out.print ("Enter Max Display Space: $");
      maxDisplay = sc.nextDouble();
      System.out.print ("Enter Max Storage Space: $");
      maxStorage = sc.nextDouble();
      return (new Museum (stringDate, maxDisplay, maxStorage)); //Isn't this a void method? Why is it returning? 	
     																																				   
   }
  
  private static Museum loadNewMuseum()
  {
    	BufferedReader in = new BufferedReader (new File ("museumSave.txt"));
  }
}