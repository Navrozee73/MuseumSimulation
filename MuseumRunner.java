import java.util.*;

public class MuseumRunner
{
   public static void main (String [] args)
   {
      int input;
      Museum museum;
      Scanner sc = new Scanner(System.in);
      while (input != 0)
      {
         printStartMenu();
         input = sc.nextInt();
         if (input == 1)
         {
            boolean museumMade = false;
            try
            {
               museum = makeNewMuseum();
            } 
            catch (Exception e)
            {
               System.out.println ("Error creating museum. Check values and formatting are correct.");
            }
         }
      }
   }
   
   private static void printStartMenu()
   {
      System.out.println ("Choose from the below options, or hit 0 to return");
      System.out.println ("1) Make New Museum (WARNING: THIS WILL OVERRIDE ANY PREVIOUSLY SAVED FILES)");
      System.out.println ("2) Load previously stored museum information");
      System.out.println ("3) Save current museum information");
      System.out.println ("4) Begin Simulation");
   }
   
   private static void makeNewMuseum()
   {
      String stringDate;
      int makeDisplay, maxStorage;
      System.out.print ("Enter opening date (dd/mm/yyyy C.E/B.C.E)  : ");
      stringDate = sc.nextLine();
      System.out.print ("Enter Max Display Space: $");
      maxDisplay = sc.nextDouble();
      System.out.print ("Enter Max Storage Space: $");
      maxStorage = sc.nextDouble();
      return (new Museum (stringDate, maxDisplay, maxStorage));
      
   }
}