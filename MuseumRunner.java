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
              	System.out.println ("Error loading museum. Check file format is correct.");
               input = 0;
          	}	
        } 
        else if (input == 3)
        {
          try
          {
            	saveMuseum(museum);		//I'm working on it on my computer rn
          }
          catch (Exception e)
          {
            	System.out.println("Error saving museum");
          }
        }
       else if (input == 4)
       {
         try
         {
            int input;
           	
         }
         catch(Exception e)
         {
            input = 0;	//Set to 0 so if theres any bad issue it'll just go to start menue
          							// still need try/catches inside the try above
         }
       }
       else    
       {
         input = 0;
       }
  		} while (input == 0);
   }
   
   private static void printStartMenu()
   {
      System.out.println ("Choose from the below options, or hit 0 to return");
      System.out.println ("1) Make New Museum (WARNING: THIS WILL OVERRIDE ANY PREVIOUSLY SAVED FILES)");
      System.out.println ("2) Load previously stored museum information");
      System.out.println ("3) Save current museum information");
      System.out.println ("4) Begin Simulation");
   }
  
  private static int printMainMenu ()
  {
   
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
      return (new Museum (stringDate, maxDisplay, maxStorage)); 	
     																																				   
   }
  
  private static Museum loadNewMuseum()	//I'm doing this on my computer rn
  {
      double maxStorage, maxDisplay;
      int numDaysOpen, numExhibits, numArtifacts, numVisitors;
      
      ArrayList <Date> dates = new ArrayList<Date>();
      ArrayList <Double> dailyRev = new ArrayList<Double>();
      dates.trimToSize();
      dailyRev.trimToSize();
      double lifetimeRev = 0;
      Bank bank;
      
      ArrayList <Artifact> artifacts = new ArrayList<Artifact>();
      ArrayList <Exhibit> exhibits = new ArrayList<Exhibit>();
      ArrayList <Visitor> visitors = new ArrayList<Visitor>();
      artifacts.trimToSize();
      exhibits.trimToSize();
      visitors.trimToSize();
      
    	BufferedReader in = new BufferedReader (new FileReader ("museumSave.txt"));
      Date openDate = new Date (in.readLine());
      Date currDate = new Date(in.readLine());
      maxDisplay = Double.parseDouble(in.readLine());
      maxStorage = Double.parseDouble(in.readLine());
      numDaysOpen = Integer.parseInt(in.readLine());

      
      for (int i = 0; i< numDaysOpen;i++)
      {
         Date temp = new Date (in.readLine());
         dates.add(temp);
      }
      
      // making bank
      for (int i=0; i < numDaysOpen;i++)
      {
         dailyRev.add(Double.parseDouble(in.readLine()));
         lifetimeRev += dailyRev.get(i);
      }
      bank = new Bank (lifetimeRev, dailyRev, dates, currDate);
      
      // making exhibit
      numExhibits = Integer.parseInt(in.readLine());
      Exhibit lobby = new Exhibit("Lobby", 1000, "Starting area for visitors");
      exhibits.add(lobby);
      for (int i= 0; i < numExhibits;i++)
      {
         Exhibit temp = new Exhibit (in.readLine(), Integer.parseInt(in.readLine()), in.readLine());
         exhibits.add(temp);
      }
      
      // making artifacts and adding to exhibit
      numArtifacts = Integer.parseInt(in.readLine());
      for (int i=0;i<numArtifacts;i++)
      {
         Artifact temp = new Artifact(in.readLine(), Integer.parseInt(in.readLine()), in.readLine(), Double.parseDouble(in.readLine()), 
                                       Double.parseDouble(in.readLine()),new Date(in.readLine()), new Date(in.readLine()),(Exhibit tempExh = findExhibit(exhibits, Integer.parseInt(in.readLine()))) ,Boolean.parseBoolean(in.readLine()));
         artifacts.add(temp);
         tempExh.addArtifact(temp);
      }
      
      // Making visitors
      numVisitors = Integer.parseInt(in.readLine());
      for (int i=0; i<numVisitors;i++)
      {
         ArrayList <Exhibit>prevVisitedExh = new ArrayList<Exhibit>();
         ArrayList <Artifact>prevVisitedArt = new ArrayList<Artifact>();
         prevVisitedExh.trimToSize();
         prevVisitedArt.trimToSize();
         int visId = Integer.parseInt(in.readLine());
         String visFName = in.readLine();
         String visLName = in.readLine();
         int visAge = Integer.parseInt(in.readLine());
         Artifact currArt = findArtifact(Integer.parseInt(in.readLine())); //currArt
         Exhibit currExh = currArt.getExhibitLocation(); //use currArt to find currExh
         
         // making prev visited exhibits
         for (int i=0;i<Integer.parseInt(in.readLine()),i++)
         {
            Exhibit temp = findExhibit (exhibits,Integer.parseInt(in.readLine()));
            prevVisitedExh.add(temp);
         }
         
         // making prev visited artifacts
         for (int i=0;i<Integer.parseInt(in.readLine()), i++)
         {
            Artifact temp = findArtifact(artifacts, Integer.parseInt(in.readLine()));
            prevVisitedArt.add(temp);
         }
         
         Visitor tempVisitor = new Visitor(visId, visFName, visLName, visAge, currExh, currArt, prevVisitedExh, prevVisitedArt);
         visitors.add(tempVisitor);
      }
      
      return (new Museum(openDate, currDate,maxDisplay, maxStorage, numVisitors, numDaysOpen, exhibits, artifacts, visitors, bank));
  }
  
  private Exhibit findExhibit(ArrayList<Exhibit> exhibitList, int exhId)
  {
   exhibitList.trimToSize();
   for (int i=0;i<exhibitList.size();i++)
   {
      if (exhId == exhibitList.get(i).getId())
         return exhibitList.get(i);
   }
   return null;
  }
  
  private Artifact findArtifact(int artId)
  {
   artifactList.trimToSize();
   for (int i=0;i<artifactList.size();i++)
   {
      if (artId == artifactList.get(i).getId())
         return artifactList.get(i);
   }
   return null;
  }
}