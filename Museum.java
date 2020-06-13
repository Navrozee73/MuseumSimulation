/*
   Class Name:       Museum.java
   Authors:          Jerry & William
   Creation Date:    2020-6-5
   Course:           ICS4U1-02
   Purpose:          This class represents a museum and manages all its operations.
*/

import java.util.ArrayList;
import java.util.*;

public class Museum
{
   private static final int VISITOR_BASE_ID = 100000;       // ID of the first visitor added
   private static final int ARTIFACT_BASE_ID = 10000;       // ID of the first artifact added
   private static final int EXHIBIT_BASE_ID = 1000;         // ID of the museum lobby (first exhibit added)
   
   private Date openingDate;                                // opening date of the museum
   private Date currentDate;                                // current date in museum simulation
   private double maxDisplaySpace;                          // total amount of display space available
   private double maxStorageSpace;                          // total amount of storage space available
   private int numCurrentVisitors;                          // current number of visitors inside museum
   private int daysOpenCount;                               // number of days the museum has been open
   private ArrayList <Exhibit> allExhibits;                 // all exhibits in museum
   private ArrayList <Artifact> allArtifacts;               // all artifacts in museum
   private ArrayList <Visitor> allVisitors;                 // all visitors currently in museum
   private Bank bank;                                       // manages the financial aspects of the museum
   private int numVisitorsAdded;                            // total number of visitors added
   private int numExhibitsAdded;                            // total number of exhibits added
   private int numArtifactsAdded;                           // total number of artifacts added
   
   // Constructors
   
   // default constructor if no parameters are entered
   public Museum()
   {
      openingDate = null;
      currentDate = null;
      maxDisplaySpace = 0;
      maxStorageSpace = 0;
      numCurrentVisitors = 0;
      daysOpenCount = 0;
      allExhibits = null;
      allArtifacts = null;
      allVisitors = null;
      bank = null;
      numVisitorsAdded = 0;
      numExhibitsAdded = 0;
      numArtifactsAdded = 0;
   }
   
   // constructor for creating a pre-existing museum, given all fields
   public Museum(Date date1, Date date2, double maxDisplaySpace, double maxStorageSpace, int numCurrentVisitors, int daysOpenCount, ArrayList allExhibits, ArrayList allArtifacts, ArrayList allVisitors, Bank bank)
   {
      Date openingDate = date1;
      Date currentDate = date2;
      this.openingDate = openingDate;
      this.currentDate = currentDate;
      this.maxDisplaySpace = maxDisplaySpace;
      this.maxStorageSpace = maxStorageSpace;
      this.numCurrentVisitors = numCurrentVisitors;
      this.daysOpenCount = daysOpenCount;
      this.allExhibits = allExhibits;
      this.allArtifacts = allArtifacts;
      this.allVisitors = allVisitors;
      this.bank = bank;
      numVisitorsAdded = allVisitors.size();
      numExhibitsAdded = allExhibits.size();
      numArtifactsAdded = allArtifacts.size();
   }
   
   // constructor for creating a brand new museum, only given opening date, max display space, and max storage space
   public Museum(String date, double maxDisplaySpace, double maxStorageSpace)
   {
      Date openingDate = new Date(date);
      this.openingDate = openingDate;
      this.currentDate = openingDate;
      numCurrentVisitors = 0;
      daysOpenCount = 0;
      this.maxDisplaySpace = maxDisplaySpace;
      this.maxStorageSpace = maxStorageSpace;
      allExhibits = new ArrayList();
      allArtifacts = new ArrayList();
      allVisitors = new ArrayList();
      
      ArrayList <Double> dailyRevenue = new ArrayList<Double>();
      ArrayList <Date> dates = new ArrayList<Date>();
      dailyRevenue.trimToSize();
      dates.trimToSize();
      dailyRevenue.add(0.0);
      dates.add(openingDate);
      bank = new Bank(0,dailyRevenue, dates, currentDate);
      
      numVisitorsAdded = 0;
      numExhibitsAdded = 0;
      numArtifactsAdded = 0;
      this.addExhibit("Lobby", "Area to store all new visitors, or visitors not currently at an existing artifact.");
   }
   
   // Accessors
   
   public Date getOpeningDate() {
      return openingDate;
   }
   
   public Date getCurrentDate() {
      return currentDate;
   }
   
   public double getMaxDisplaySpace() {
      return maxDisplaySpace;
   }
   
   public double getMaxStorageSpace() {
      return maxStorageSpace;
   }
        
   public int getNumCurrentVisitors() {
      return numCurrentVisitors;
   }
   
   public int getDaysOpenCount() {
      return daysOpenCount;
   }
   
   public ArrayList <Exhibit> getAllExhibits() {
      return allExhibits;
   }
  
   public ArrayList <Artifact> getAllArtifacts() {
      return allArtifacts;
   }
   
   public ArrayList <Visitor> getAllVisitors() {
      return allVisitors;
   }
        
   public Bank getBank() {
      return bank;
   }
     
   // Mutators
      
   public void setOpeningDate(String date) {
      Date setDate = new Date(date);
      openingDate = setDate;
   }
   
   public void setCurrentDate(String date) {
      Date setDate = new Date(date);
      currentDate = setDate;
   }
     
   public void setMaxDisplaySpace(double space) {
      maxDisplaySpace = space;
   }
   
   public void setMaxStorageSpace(double space) {
      maxStorageSpace = space;
   }
   
   public void setNumCurrentVisitors(int num) {
      numCurrentVisitors = num;
   }
   
   public void setDaysOpenCount(int num) {
      daysOpenCount = num;
   }
   
   public void setAllExhibits(ArrayList allExhibits) {
      this.allExhibits = allExhibits;
   }
   
   public void setAllArtifacts(ArrayList allArtifacts) {
      this.allArtifacts = allArtifacts;
   }
   
   public void setAllVisitors(ArrayList allVisitors) {
      this.allVisitors = allVisitors;
   }
   
   public void setBank(double lifeTimeRevenue, ArrayList <Double> dailyRevenue, ArrayList <Date> dailyRevenueDates, Date currentDate) {
      Bank newBank = new Bank (lifeTimeRevenue, dailyRevenue, dailyRevenueDates, currentDate);
      bank = newBank;
   }
   
   public void setBank(Bank bank) {
      this.bank = bank;
   } 
   
   // Instance Methods
   
   /* Adds a pre-existing visitor to the museum
   *  String firstName - first name of visitor being added
   *  String lastName - last name of visitor being added
   *  Exhibit currentExhibit - the exhibit the visitor is currently in
   *  Artifact currentArtifact - the artifact the visitor is currently in
   */
   
   public void addVisitor(String firstName, String lastName, int age, Exhibit currentExhibit, Artifact currentArtifact)
   {
      try
      {               
         if (age >= Child.MIN_AGE)
         {
            Visitor newVisitor;
                    
            if (age >= Child.MIN_AGE && age <= Child.MAX_AGE)
            {
               newVisitor = new Child (VISITOR_BASE_ID + numVisitorsAdded, firstName, lastName, age, currentExhibit, currentArtifact);
               bank.addRevenue(Child.ENTRANCE_FEE);
            }
            else if (age >= Adult.MIN_AGE && age <= Adult.MAX_AGE)
            {
               newVisitor = new Adult (VISITOR_BASE_ID + numVisitorsAdded, firstName, lastName, age, currentExhibit, currentArtifact);
               bank.addRevenue(Adult.ENTRANCE_FEE);
            }
            else
            {
               newVisitor = new Senior (VISITOR_BASE_ID + numVisitorsAdded, firstName, lastName, age, currentExhibit, currentArtifact);
               bank.addRevenue(Senior.ENTRANCE_FEE);
            }
                         
            numVisitorsAdded++;
            numCurrentVisitors++;
            allVisitors.add(newVisitor);
            currentExhibit.addVisitor(newVisitor);
            currentArtifact.addVisitor(newVisitor);
         }
         else
            System.out.println("Age is not valid");
      }
      catch(Exception e)
      {
         System.out.println("Error adding visitor");
      }
   }

   /* Adds a brand new visitor to the museum, placed in lobby
   *  String firstName - first name of visitor being added
   *  String lastName - last name of visitor being added
   *  Exhibit currentExhibit - the exhibit the visitor is currently in
   *  Artifact currentArtifact - the artifact the visitor is currently in
   */
   public void addVisitor(String firstName, String lastName, int age)
   {
      try
      {               
         if (age >= Child.MIN_AGE)
         {
            Visitor newVisitor;
            Exhibit lobby = allExhibits.get(findExhibitIndexByName("Lobby"));
                    
            if (age >= Child.MIN_AGE && age <= Child.MAX_AGE)
            {
               newVisitor = new Child (VISITOR_BASE_ID + numVisitorsAdded, firstName, lastName, age, lobby, null);
               bank.addRevenue(Child.ENTRANCE_FEE);
            }
            else if (age >= Adult.MIN_AGE && age <= Adult.MAX_AGE)
            {
               newVisitor = new Adult (VISITOR_BASE_ID + numVisitorsAdded, firstName, lastName, age, lobby, null);
               bank.addRevenue(Adult.ENTRANCE_FEE);
            }
            else
            {
               newVisitor = new Senior (VISITOR_BASE_ID + numVisitorsAdded, firstName, lastName, age, lobby, null);
               bank.addRevenue(Senior.ENTRANCE_FEE);
            }
                         
            numVisitorsAdded++;
            numCurrentVisitors++;
            allVisitors.add(newVisitor);
            lobby.addVisitor(newVisitor);
         }
         else
            System.out.println("Age is not valid");
      }
      catch(Exception e)
      {
         System.out.println("Error adding visitor");
      }
   }   
   
   public void removeVisitor(int givenId)
   {
      int foundIndex = findVisitorIndexById(givenId);
      Visitor foundVisitor = allVisitors.get(foundIndex);
      
      if (foundIndex == -1)
         System.out.println("Visitor with ID " + givenId + " cannot be found");
      else
      {
         allVisitors.remove(foundIndex);    
         (foundVisitor.getCurrentArtifact()).removeVisitor(foundVisitor);
         (foundVisitor.getCurrentExhibit()).removeVisitor(foundVisitor);
         numCurrentVisitors--; 
      }
   }
   
   public void removeVisitor(String givenName)
   {
      int foundIndex = findVisitorIndexByName(givenName);
      Visitor foundVisitor = allVisitors.get(foundIndex);
      
      if (foundIndex == -1)
         System.out.println("Visitor with name " + givenName + " cannot be found");
      else
      {
         allVisitors.remove(foundIndex);
         (foundVisitor.getCurrentArtifact()).removeVisitor(foundVisitor);
         (foundVisitor.getCurrentExhibit()).removeVisitor(foundVisitor);    
         numCurrentVisitors--; 
      }   
   }
   
   public void addExhibit(String name, String description)
   {
      try
      {
         Exhibit newExhibit = new Exhibit(name, EXHIBIT_BASE_ID + numExhibitsAdded, description);
         numExhibitsAdded ++;
         allExhibits.add(newExhibit);
      }
      catch(Exception e)
      {
         System.out.println("Error adding exhibit");
      }
   }
   
   public void removeExhibit(int exhibitId)
   {
      int foundIndex = findExhibitIndexById(exhibitId);
      Exhibit foundExhibit = allExhibits.get(foundIndex);
      
      if (foundIndex == -1)
         System.out.println("Exhibit with ID " + exhibitId + " cannot be found");
      else
      {  
         // remove all artifacts from Exhibit (thus movig visitors to lobby)
         ArrayList <Artifact> displacedArtifacts = foundExhibit.getArtifactList();
         displacedArtifacts.trimToSize();
         for (int i=0;i < displacedArtifacts.size(); i++)
         {
            this.removeArtifact(displacedArtifacts.get(i).getId());
         }
         allExhibits.remove(foundIndex);     
      }
   }
   
   public void removeExhibit(String exhibitName)
   {
      int foundIndex = findExhibitIndexByName(exhibitName);
      
      if (foundIndex == -1)
         System.out.println("Exhibit called " + exhibitName + " cannot be found");
      else
         allExhibits.remove(foundIndex);     
   }
   
   public void addArtifact(String name, String description, double value, double floorSpace, String dateMadeString, String datePurchasedString, int exhibitId, boolean onDisplay)
   {
      try
      {
         Date dateMade = new Date(dateMadeString);
         Date datePurchased = new Date(datePurchasedString);
         int foundIndex = findExhibitIndexById(exhibitId);
         
         if (foundIndex != -1)
         {
            Artifact newArtifact = new Artifact(name, ARTIFACT_BASE_ID + numArtifactsAdded, description, value, floorSpace, dateMade, datePurchased, allExhibits.get(foundIndex), onDisplay);
            allArtifacts.add(newArtifact);
            (allExhibits.get(foundIndex)).addArtifact(newArtifact);
            numArtifactsAdded++;
         }
         else
            System.out.println("Exhibit with ID " + exhibitId + " cannot be found");
      }
      catch(Exception e)
      {
         System.out.println("Error adding artifact");
      }
   }
   
   public void removeArtifact(int artifactId)
   {
      int foundIndex = findArtifactIndexById(artifactId);
      Artifact foundArtifact = allArtifacts.get(foundIndex);
      
      if (foundIndex == -1)
         System.out.println("Artifact with ID " + artifactId + " cannot be found");
      else
      {
         // move all visitors at artifact to lobby        
         ArrayList<Visitor> displacedVisitors = foundArtifact.getCurrentVisitors();
         displacedVisitors.trimToSize();
         for (int i=0; i < displacedVisitors.size();i++)
         {
            this.moveToLobby(displacedVisitors.get(i));  //moves visitor to lobby
         }
         
         // remove artifact from arraylist
         allArtifacts.remove(foundIndex);
         
         // remove artifact from exhibit
         foundArtifact.getExhibitLocation().removeArtifact(foundArtifact);
      }
   }
   
   public void removeArtifact(String artifactName)
   {
      int foundIndex = findArtifactIndexByName(artifactName);
      Artifact foundArtifact = allArtifacts.get(foundIndex);
      
      if (foundIndex == -1)
         System.out.println("Artifact called " + artifactName + " cannot be found");
      else
      {
         // move all visitors at artifact to lobby         
         ArrayList<Visitor> displacedVisitors = foundArtifact.getCurrentVisitors();
         displacedVisitors.trimToSize();
         for (int i=0; i < displacedVisitors.size();i++)
         {
            this.moveToLobby(displacedVisitors.get(i));  //moves visitor to lobby
         }
         
         // remove artifact from arraylist
         allArtifacts.remove(foundIndex);
         
         // remove artifact from exhibit
         foundArtifact.getExhibitLocation().removeArtifact(foundArtifact);
      }
   }
   
   public boolean moveVisitor(int visitorId, int toArtifactId)
   {
      try
      {
         // locate visitor and artifact ID
         int visitorFoundIndex = findVisitorIndexById(visitorId);
         int artifactFoundIndex = findArtifactIndexById(toArtifactId);
         
         // boolean indicates if the visitor is successfully moved (different artifact is given)
         boolean moveSuccessful = false;
         
         // variables to store objects
         Visitor movingVisitor;
         Artifact toArtifact;
         Exhibit toExhibit;
         Exhibit originalExhibit = allVisitors.get(visitorFoundIndex).getCurrentExhibit();
         
         // check if IDs given are valid
         
         if (visitorFoundIndex != -1 && artifactFoundIndex != -1)
         {
            movingVisitor = allVisitors.get(visitorFoundIndex);
            toArtifact = allArtifacts.get(artifactFoundIndex);
            
            // move visitor to another object (updates visitor info)
            moveSuccessful = movingVisitor.moveVisitor(toArtifact);
            
            // if visitor is successfully moved
            if (moveSuccessful)
            {
               // remove visitor from their initial artifact
               // add visitor to their new artifact
               
               (movingVisitor.getCurrentArtifact()).removeVisitor(movingVisitor);
               toArtifact.addVisitor(movingVisitor);
                
               // if artifact is located in another exhibit
               if (toArtifact.getExhibitLocation().equals(originalExhibit) == false)
               {
                  toExhibit = toArtifact.getExhibitLocation();
                  
                  // remove visitor from their initial exhibit
                  // add visitor to their new exhibit
                  
                  (movingVisitor.getCurrentExhibit()).removeVisitor(movingVisitor);
                  toExhibit.addVisitor(movingVisitor);
               }
            }
           
            return true;
         }
         else
            return false;
      }
      catch(Exception e)
      { 
         return false;
      }
   }
   
   public boolean moveVisitor(String visitorName, String toArtifactName)
   {
      try
      {
         // locate visitor and artifact ID
         int visitorFoundIndex = findVisitorIndexByName(visitorName);
         int artifactFoundIndex = findArtifactIndexByName(toArtifactName);
         
         // boolean indicates if the visitor is successfully moved (different artifact is given)
         boolean moveSuccessful = false;
         
         // variables to store objects
         Visitor movingVisitor;
         Artifact toArtifact;
         Exhibit toExhibit;
         Exhibit originalExhibit = allVisitors.get(visitorFoundIndex).getCurrentExhibit();
         
         // check if IDs given are valid
         
         if (visitorFoundIndex != -1 && artifactFoundIndex != -1)
         {
            movingVisitor = allVisitors.get(visitorFoundIndex);
            toArtifact = allArtifacts.get(artifactFoundIndex);
            
            // move visitor to another object (updates visitor info)
            moveSuccessful = movingVisitor.moveVisitor(toArtifact);
            
            // if visitor is successfully moved
            if (moveSuccessful)
            {
               // remove visitor from their initial artifact
               // add visitor to their new artifact
               
               (movingVisitor.getCurrentArtifact()).removeVisitor(movingVisitor);
               toArtifact.addVisitor(movingVisitor);
                  
               // if artifact is located in another exhibit
               if (toArtifact.getExhibitLocation().equals(originalExhibit) == false)
               {
                  toExhibit = toArtifact.getExhibitLocation();
                  
                  // remove visitor from their initial exhibit
                  // add visitor to their new exhibit
                  
                  (movingVisitor.getCurrentExhibit()).removeVisitor(movingVisitor);
                  toExhibit.addVisitor(movingVisitor);
               }
               
               return true;
            }
            
            return false;
         }
         else
            return false;
      }
      catch(Exception e)
      { 
         return false;
      }
   }
   
   public boolean moveToLobby(Visitor visitor)
   {
      return (visitor.moveToLobby(allExhibits.get(findExhibitIndexByName("Lobby"))));
   }
   
   public void closeForTheDay()
   {
          // add the current date to Bank's date array
      (bank.getDailyRevenueDates()).add(currentDate);
          
          // update days open and current date for Museum
          // set tomorrow's initial daily revenue as $0 for Bank
      daysOpenCount++;
      currentDate.progressDate();
      (bank.getDailyRevenue()).add(0.0);
          
          // clear visitor array in Museum
      allVisitors.clear();
          
          // clear currentVisitors in all Artifacts and Exhibits
      for (int i = 0; i < allExhibits.size(); i ++)
      {
         (allExhibits.get(i)).clearVisitors();
      }
          
      for (int i = 0; i < allArtifacts.size(); i ++)
      {
         (allArtifacts.get(i)).clearVisitors();
      }
          
   }
   
   public int numTotalExhibits()
   {
      allExhibits.trimToSize();
      return allExhibits.size();
   }
   
   public int numTotalArtifacts()
   {
      allArtifacts.trimToSize();
      return allArtifacts.size();
   }
   
   public int numTotalVisitors()
   {
      allVisitors.trimToSize();
      return allVisitors.size();
   }
   
   public void printAllVisitors()
   {
      allVisitors.trimToSize();
      for(int i = 0; i < allVisitors.size(); i ++)
      {
         System.out.println((allVisitors.get(i)).identifierToString());
      }
   }
   
   public void printSpecificVisitor(int givenId)
   {
      int foundIndex = findVisitorIndexById(givenId);
      
      if (foundIndex == -1)
         System.out.println("Visitor with ID " + givenId + " cannot be found.");
      else
         System.out.println((allVisitors.get(foundIndex)).identifierToString());
   }
   
   public void printSpecificVisitor(String givenName)
   {
      int foundIndex = findVisitorIndexByName(givenName);
      
      if (foundIndex == -1)
         System.out.println("Visitor with ID " + givenName + " cannot be found");
      else
         System.out.println((allVisitors.get(foundIndex)).identifierToString());
   }
   
   public void printVisitedArtifacts(int givenId)
   {
      int foundIndex = findVisitorIndexById(givenId);
      Visitor foundVisitor;
      ArrayList <Artifact> artifactsVisited;
      
      if (foundIndex == -1)
         System.out.println("Visitor with ID " + givenId + " cannot be found");
      else
      {
         foundVisitor = allVisitors.get(foundIndex);
         artifactsVisited = foundVisitor.getVisitedArtifacts();
         
         for (int i = 0; i < artifactsVisited.size(); i ++)
         {
            System.out.print((artifactsVisited.get(i)).identifierToString());
         }
      }
   }
   
   public void printVisitedArtifacts(String givenName)
   {
      int foundIndex = findVisitorIndexByName(givenName);
      Visitor foundVisitor;
      ArrayList <Artifact> artifactsVisited;
      
      if (foundIndex == -1)
         System.out.println("Visitor with name " + givenName + " cannot be found");
      else
      {
         foundVisitor = allVisitors.get(foundIndex);
         artifactsVisited = foundVisitor.getVisitedArtifacts();
         
         for (int i = 0; i < artifactsVisited.size(); i ++)
         {
            System.out.print((artifactsVisited.get(i)).identifierToString());
         }
      }   
   }
   
   public int numAdults()
   {
      int adultCount = 0;
      
      allVisitors.trimToSize();
      for (int i = 0; i < allVisitors.size(); i ++)
      {
         if (allVisitors.get(i) instanceof Adult)
            adultCount++;
      }
      
      return adultCount;
   }
   
   public int numChildren()
   {
      int childCount = 0;
      
      allVisitors.trimToSize();
      for (int i = 0; i < allVisitors.size(); i ++)
      {
         if (allVisitors.get(i) instanceof Child)
            childCount++;
      }
      
      return childCount;
   }
   
   public int numSeniors()
   {
      int seniorCount = 0;
      
      allVisitors.trimToSize();
      for (int i = 0; i < allVisitors.size(); i ++)
      {
         if (allVisitors.get(i) instanceof Senior)
            seniorCount++;
      }
      
      return seniorCount;
   }
   
   public double averageAge()
   {
      int ageSum = 0;
      int visitorCount = 0;
      double average;
      
      allVisitors.trimToSize();
      for (int i = 0; i < allVisitors.size(); i ++)
      {
         ageSum += (allVisitors.get(i)).getAge();
         visitorCount++;
      }
      
      average = (double) ageSum / visitorCount;
      return average;
   }
   
   public void printAllAdults()
   {
      allVisitors.trimToSize();
      for (int i = 0; i < allVisitors.size(); i ++)
      {
         if (allVisitors.get(i) instanceof Adult)
            System.out.println((allVisitors.get(i)).identifierToString());
      }
   }
   
   public void printAllChildren()
   {
      allVisitors.trimToSize();
      for (int i = 0; i < allVisitors.size(); i ++)
      {
         if (allVisitors.get(i) instanceof Child)
            System.out.println((allVisitors.get(i)).identifierToString());
      }
   }
   
   public void printAllSeniors()
   {
      allVisitors.trimToSize();
      for (int i = 0; i < allVisitors.size(); i ++)
      {
         if (allVisitors.get(i) instanceof Senior)
            System.out.println((allVisitors.get(i)).identifierToString());
      }
   }
   
   public void printVisitorsAscendingAge()
   {
      int min;
      int minIndex;
   
      allVisitors.trimToSize();
      for (int i = 0; i < allVisitors.size(); i ++)
      {
         min = (allVisitors.get(i)).getAge(); 
         minIndex = i;
       
         for (int j = i + 1; j < allVisitors.size(); j ++)
         {
            if ((allVisitors.get(j)).getAge() < min)
            {
               min = (allVisitors.get(j)).getAge();
               minIndex = j;
            }
         }
       
         Collections.swap(allVisitors,i,minIndex);
         System.out.println((allVisitors.get(i)).identifierToString());
      }
   }
   
   public void printVisitorsDescendingAge()
   {
      int max;
      int maxIndex;
   
      allVisitors.trimToSize();
      for (int i = 0; i < allVisitors.size(); i ++)
      {
         max = (allVisitors.get(i)).getAge(); 
         maxIndex = i;
       
         for (int j = i + 1; j < allVisitors.size(); j ++)
         {
            if ((allVisitors.get(j)).getAge() > max)
            {
               max = (allVisitors.get(j)).getAge();
               maxIndex = j;
            }
         }
       
         Collections.swap(allVisitors,i,maxIndex);
         System.out.println((allVisitors.get(i)).identifierToString());
      }
   }
   
   public void printVisitorsAtExhibit(int exhibitId)
   {
      int foundIndex = findExhibitIndexById(exhibitId);
      Exhibit foundExhibit;
      ArrayList <Visitor> currentVisitors;
      
      allVisitors.trimToSize();
      if (foundIndex == -1)
         System.out.println("The exhibit with ID " + exhibitId + " cannot be found");
      else
      {
         foundExhibit = allExhibits.get(foundIndex);
         currentVisitors = foundExhibit.getCurrentVisitors();
         
         for (int i = 0; i < currentVisitors.size(); i ++)
         {
            System.out.println((currentVisitors.get(i)).identifierToString());
         }
      }
   }
   
   public void printVisitorsAtExhibit(String exhibitName)
   {
      int foundIndex = findExhibitIndexByName(exhibitName);
      Exhibit foundExhibit;
      ArrayList <Visitor> currentVisitors;
      
      if (foundIndex == -1)
         System.out.println("The exhibit called " + exhibitName + " cannot be found");
      else
      {
         foundExhibit = allExhibits.get(foundIndex);
         currentVisitors = foundExhibit.getCurrentVisitors();
         
         for (int i = 0; i < currentVisitors.size(); i ++)
         {
            System.out.println((currentVisitors.get(i)).identifierToString());
         }
      }
   }
   
   public void printVisitorsAtArtifact(int artifactId)
   {
      int foundIndex = findArtifactIndexById(artifactId);
      Artifact foundArtifact;
      ArrayList <Visitor> currentVisitors;
      
      if (foundIndex == -1)
         System.out.println("The artifact with ID " + artifactId + " cannot be found");
      else
      {
         foundArtifact = allArtifacts.get(foundIndex);
         currentVisitors = foundArtifact.getCurrentVisitors();
         
         for (int i = 0; i < currentVisitors.size(); i ++)
         {
            System.out.println((currentVisitors.get(i)).identifierToString());
         }
      }
   }
   
   public void printVisitorsAtArtifact(String artifactName)
   {
      int foundIndex = findArtifactIndexByName(artifactName);
      Artifact foundArtifact;
      ArrayList <Visitor> currentVisitors;
      
      if (foundIndex == -1)
         System.out.println("The artifact called " + artifactName + " cannot be found");
      else
      {
         foundArtifact = allArtifacts.get(foundIndex);
         currentVisitors = foundArtifact.getCurrentVisitors();
         
         for (int i = 0; i < currentVisitors.size(); i ++)
         {
            System.out.println((currentVisitors.get(i)).identifierToString());
         }
      }
   }
   
   public Visitor searchVisitorById(int visitorId)
   {
      int foundIndex = findVisitorIndexById(visitorId);
      
      if (foundIndex == -1)
      {
         System.out.println("Visitor with ID " + visitorId + " cannot be found");
         return null;
      }
      else
      {
         return allVisitors.get(foundIndex);
      }
   }
   
   public Visitor searchVisitorByName(String visitorName)
   {
      int foundIndex = findVisitorIndexByName(visitorName);
      
      if (foundIndex == -1)
      {
         System.out.println("Visitor with name " + visitorName + " cannot be found");
         return null;
      }
      else
      {
         return allVisitors.get(foundIndex);
      }
   }
   
   public Visitor greaterAgeBetweenVisitors(int visitorId1, int visitorId2)
   {
      int index1 = findVisitorIndexById(visitorId1);
      int index2 = findVisitorIndexById(visitorId2);
      Visitor visitor1;
      Visitor visitor2;
      
      if (index1 != -1 && index2 != -1)
      {
         visitor1 = allVisitors.get(index1);
         visitor2 = allVisitors.get(index2);
         
         if (visitor1.compareAge(visitor2) > 0)
            return visitor1;
         else if (visitor1.compareAge(visitor2) < 0)
            return visitor2;
         else
         {
            System.out.println("Both visitors have the same age.");
            return null;
         }
      }
      else
      {
         System.out.println("Visitor ID(s) entered are not valid");
         return null;
      }
   }

   public Visitor greaterAgeBetweenVisitors(String visitorName1, String visitorName2)
   {
      int index1 = findVisitorIndexByName(visitorName1);
      int index2 = findVisitorIndexByName(visitorName2);
      Visitor visitor1;
      Visitor visitor2;
      
      if (index1 != -1 && index2 != -1)
      {
         visitor1 = allVisitors.get(index1);
         visitor2 = allVisitors.get(index2);
         
         if (visitor1.compareAge(visitor2) > 0)
            return visitor1;
         else if (visitor1.compareAge(visitor2) < 0)
            return visitor2;
         else
         {
            System.out.println("Both visitors have the same age.");
            return null;
         }
      }
      else
      {
         System.out.println("Visitor name(s) entered are not valid");
         return null;
      }
   }
   
   public Visitor greaterNumOfExhibitsVisited(int visitorId1, int visitorId2)
   {
      int index1 = findVisitorIndexById(visitorId1);
      int index2 = findVisitorIndexById(visitorId2);
      Visitor visitor1;
      Visitor visitor2;
      
      if (index1 != -1 && index2 != -1)
      {
         visitor1 = allVisitors.get(index1);
         visitor2 = allVisitors.get(index2);
         
         if (visitor1.compareExhibitVisits(visitor2) > 0)
            return visitor1;
         else if (visitor1.compareExhibitVisits(visitor2) < 0)
            return visitor2;
         else
         {
            System.out.println("Both visitors have the same number of exhibits visited.");
            return null;
         }
      }
      else
      {
         System.out.println("Visitor ID(s) entered are not valid");
         return null;
      }
   }
   
   public Visitor greaterNumOfExhibitsVisited(String visitorName1, String visitorName2)
   {
      int index1 = findVisitorIndexByName(visitorName1);
      int index2 = findVisitorIndexByName(visitorName2);
      Visitor visitor1;
      Visitor visitor2;
      
      if (index1 != -1 && index2 != -1)
      {
         visitor1 = allVisitors.get(index1);
         visitor2 = allVisitors.get(index2);
         
         if (visitor1.compareExhibitVisits(visitor2) > 0)
            return visitor1;
         else if (visitor1.compareExhibitVisits(visitor2) < 0)
            return visitor2;
         else
         {
            System.out.println("Both visitors have the same number of exhibits visited.");
            return null;
         }
      }
      else
      {
         System.out.println("Visitor name(s) entered are not valid");
         return null;
      }
   }
   
   public Visitor greaterNumOfArtifactsVisited(int visitorId1, int visitorId2)
   {
      int index1 = findVisitorIndexById(visitorId1);
      int index2 = findVisitorIndexById(visitorId2);
      Visitor visitor1;
      Visitor visitor2;
      
      if (index1 != -1 && index2 != -1)
      {
         visitor1 = allVisitors.get(index1);
         visitor2 = allVisitors.get(index2);
         
         if (visitor1.compareArtifactVisits(visitor2) > 0)
            return visitor1;
         else if (visitor1.compareArtifactVisits(visitor2) < 0)
            return visitor2;
         else
         {
            System.out.println("Both visitors have the same number of artifact visits");
            return null;
         }
      }
      else
      {
         System.out.println("Visitor ID(s) entered are not valid");
         return null;
      }
   }
   
   public Visitor greaterNumOfArtifactsVisited(String visitorName1, String visitorName2)
   {
      int index1 = findVisitorIndexByName(visitorName1);
      int index2 = findVisitorIndexByName(visitorName2);
      Visitor visitor1;
      Visitor visitor2;
      
      if (index1 != -1 && index2 != -1)
      {
         visitor1 = allVisitors.get(index1);
         visitor2 = allVisitors.get(index2);
         
         if (visitor1.compareArtifactVisits(visitor2) > 0)
            return visitor1;
         else if (visitor1.compareArtifactVisits(visitor2) < 0)
            return visitor2;
         else
         {
            System.out.println("Both visitors have the same number of artifact visits");
            return null;
         }
      }
      else
      {
         System.out.println("Visitor ID(s) entered are not valid");
         return null;
      }
   }
   
   public void printAllExhibits()
   {
      allExhibits.trimToSize();
      for (int i = 0; i < allExhibits.size(); i ++)
      {
         System.out.println((allExhibits.get(i)).identifierToString());
      }
   }
   
   public void printAllArtifactsInExhibit(int exhibitId)
   {
      int foundIndex = findExhibitIndexById(exhibitId);
      Exhibit foundExhibit;
      ArrayList <Artifact> artifactsInExhibit;
      
      if (foundIndex == -1)
         System.out.println("Exhibit with ID " + exhibitId + " cannot be found");
      else
      {
         foundExhibit = allExhibits.get(foundIndex);
         artifactsInExhibit = foundExhibit.getArtifactList();
         
         for (int i = 0; i < artifactsInExhibit.size(); i ++)
         {
            System.out.println((artifactsInExhibit.get(i)).identifierToString());
         }
      }
   }

   public void printAllArtifactsInExhibit(String exhibitName)
   {
      int foundIndex = findExhibitIndexByName(exhibitName);
      Exhibit foundExhibit;
      ArrayList <Artifact> artifactsInExhibit;
      
      if (foundIndex == -1)
         System.out.println("Exhibit called " + exhibitName + " cannot be found");
      else
      {
         foundExhibit = allExhibits.get(foundIndex);
         artifactsInExhibit = foundExhibit.getArtifactList();
         
         for (int i = 0; i < artifactsInExhibit.size(); i ++)
         {
            System.out.println((artifactsInExhibit.get(i)).identifierToString());
         }
      }
   }
   
   public void printSpecificExhibit(int exhibitId)
   {
      int foundIndex = findExhibitIndexById(exhibitId);
      
      if (foundIndex == -1)
         System.out.println("Exhibit with ID " + exhibitId + " cannot be found");
      else
         System.out.println((allExhibits.get(foundIndex)).identifierToString());
   }
   
   public void printSpecificExhibit(String exhibitName)
   {
      int foundIndex = findExhibitIndexByName(exhibitName);
      
      if (foundIndex == -1)
         System.out.println("Exhibit called " + exhibitName + " cannot be found");
      else
         System.out.println((allExhibits.get(foundIndex)).identifierToString());
   }
   
   public void printAllVisitorsInExhibit(int exhibitId)
   {
      int foundIndex = findExhibitIndexById(exhibitId);
      Exhibit foundExhibit;
      ArrayList <Visitor> visitorsInExhibit;
      
      if (foundIndex == -1)
         System.out.println("Exhibit with ID " + exhibitId + " cannot be found");
      else
      {
         foundExhibit = allExhibits.get(foundIndex);
         visitorsInExhibit = foundExhibit.getCurrentVisitors();
         
         for (int i = 0; i < visitorsInExhibit.size(); i ++)
         {
            System.out.println((visitorsInExhibit.get(i)).identifierToString());
         }
      }
   }
   
   public void printAllVisitorsInExhibit(String exhibitName)
   {
      int foundIndex = findExhibitIndexByName(exhibitName);
      Exhibit foundExhibit;
      ArrayList <Visitor> visitorsInExhibit;
      
      if (foundIndex == -1)
         System.out.println("Exhibit called " + exhibitName + " cannot be found");
      else
      {
         foundExhibit = allExhibits.get(foundIndex);
         visitorsInExhibit = foundExhibit.getCurrentVisitors();
         
         for (int i = 0; i < visitorsInExhibit.size(); i ++)
         {
            System.out.println((visitorsInExhibit.get(i)).identifierToString());
         }
      }
   }
   
   public int numArtifactsInExhibit(int exhibitId)
   {
      int foundIndex = findExhibitIndexById(exhibitId);
      
      if (foundIndex == -1)
      {
         System.out.println("Exhibit with ID " + exhibitId + " cannot be found");
         return -1;
      }
      else
         return (allExhibits.get(foundIndex)).getNumArtifacts();
   }
   
   public int numArtifactsInExhibit(String exhibitName)
   {
      int foundIndex = findExhibitIndexByName(exhibitName);
      
      if (foundIndex == -1)
      {
         System.out.println("Exhibit called " + exhibitName + " cannot be found");
         return -1;
      }
      else
         return (allExhibits.get(foundIndex)).getNumArtifacts();
   }
   
   public int numVisitorsInExhibit(int exhibitId)
   {
      int foundIndex = findExhibitIndexById(exhibitId);
      
      if (foundIndex == -1)
      {
         System.out.println("Exhibit with ID " + exhibitId + " cannot be found");
         return -1;
      }
      else
         return (allExhibits.get(foundIndex)).getNumCurrentVisitors();
   }
   
   public int numVisitorsInExhibit(String exhibitName)
   {
      int foundIndex = findExhibitIndexByName(exhibitName);
      
      if (foundIndex == -1)
      {
         System.out.println("Exhibit called " + exhibitName + " cannot be found");
         return -1;
      }
      else
         return (allExhibits.get(foundIndex)).getNumCurrentVisitors();
   }
   
   public void printExhibitsCurrentlyOnFloor()
   {  
      allExhibits.trimToSize();
      for (int i = 0; i < allExhibits.size(); i ++)
      {
         if ((allExhibits.get(i)).getOnDisplay())
            System.out.println((allExhibits.get(i)).identifierToString());
      }
   }
   
   public void printExhibitsInStorage()
   {
      allExhibits.trimToSize();
      for (int i = 0; i < allExhibits.size(); i ++)
      {
         if ((allExhibits.get(i)).getOnDisplay() == false)
            System.out.println((allExhibits.get(i)).identifierToString());
      }
   }

   public void printExhibitsAscendingValue()
   {
      double min;
      int minIndex;
      
      allExhibits.trimToSize();
      for (int i = 0; i < allExhibits.size(); i ++)
      {
         min = (allExhibits.get(i)).getValue(); 
         minIndex = i;
       
         for (int j = i + 1; j < allExhibits.size(); j ++)
         {
            if ((allExhibits.get(j)).getValue() < min)
            {
               min = (allExhibits.get(j)).getValue();
               minIndex = j;
            }
         }
       
         Collections.swap(allExhibits,i,minIndex);
         System.out.println((allExhibits.get(i)).identifierToString());
      }
   }
   
   public void printExhibitsDescendingValue()
   {
      double max;
      int maxIndex;
   
      allExhibits.trimToSize();
      for (int i = 0; i < allExhibits.size(); i ++)
      {
         max = (allExhibits.get(i)).getValue(); 
         maxIndex = i;
       
         for (int j = i + 1; j < allExhibits.size(); j ++)
         {
            if ((allExhibits.get(j)).getValue() > max)
            {
               max = (allExhibits.get(j)).getValue();
               maxIndex = j;
            }
         }
       
         Collections.swap(allExhibits,i,maxIndex);
         System.out.println((allExhibits.get(i)).identifierToString());
      }
   }
   
   public void printExhibitsAscendingFloorSpace()
   {
      double min;
      int minIndex;
   
      allExhibits.trimToSize();
      for (int i = 0; i < allExhibits.size(); i ++)
      {
         min = (allExhibits.get(i)).getFloorSpace(); 
         minIndex = i;
       
         for (int j = i + 1; j < allExhibits.size(); j ++)
         {
            if ((allExhibits.get(j)).getFloorSpace() < min)
            {
               min = (allExhibits.get(j)).getFloorSpace();
               minIndex = j;
            }
         }
       
         Collections.swap(allExhibits,i,minIndex);
         System.out.println((allExhibits.get(i)).identifierToString());
      }
   }
   
   public void printExhibitsDescendingFloorSpace()
   {
      double max;
      int maxIndex;
   
      allExhibits.trimToSize();
      for (int i = 0; i < allExhibits.size(); i ++)
      {
         max = (allExhibits.get(i)).getFloorSpace(); 
         maxIndex = i;
       
         for (int j = i + 1; j < allExhibits.size(); j ++)
         {
            if ((allExhibits.get(j)).getFloorSpace() > max)
            {
               max = (allExhibits.get(j)).getFloorSpace();
               maxIndex = j;
            }
         }
       
         Collections.swap(allExhibits,i,maxIndex);
         System.out.println((allExhibits.get(i)).identifierToString());
      }
   }
   
   public void printExhibitsAscendingNumVisitors()
   {
      int min;
      int minIndex;
   
      allExhibits.trimToSize();
      for (int i = 0; i < allExhibits.size(); i ++)
      {
         min = (allExhibits.get(i)).getNumCurrentVisitors(); 
         minIndex = i;
       
         for (int j = i + 1; j < allExhibits.size(); j ++)
         {
            if ((allExhibits.get(j)).getNumCurrentVisitors() < min)
            {
               min = (allExhibits.get(j)).getNumCurrentVisitors();
               minIndex = j;
            }
         }
       
         Collections.swap(allExhibits,i,minIndex);
         System.out.println((allExhibits.get(i)).identifierToString());
      }
   }
   
   public void printExhibitsDescendingNumVisitors()
   {
      int max;
      int maxIndex;
   
      allExhibits.trimToSize();
      
      for (int i = 0; i < allExhibits.size(); i ++)
      {
         max = (allExhibits.get(i)).getNumCurrentVisitors();          // casting
         maxIndex = i;
       
         for (int j = i + 1; j < allExhibits.size(); j ++)
         {
            if ((allExhibits.get(j)).getNumCurrentVisitors() > max)
            {
               max = (allExhibits.get(j)).getNumCurrentVisitors();
               maxIndex = j;
            }
         }
       
         Collections.swap(allExhibits,i,maxIndex);
         System.out.println((allExhibits.get(i)).identifierToString());
      }
   }
   
   public void printExhibitsReverseAlpha()
   {
      String max;
      int maxIndex;
      
      allExhibits.trimToSize();
      for (int i = 0; i < allExhibits.size(); i ++)
      {
         max = (allExhibits.get(i)).getName(); 
         maxIndex = i;
       
         for (int j = i + 1; j < allExhibits.size(); j ++)
         {
            if (((allExhibits.get(j)).getName()).compareToIgnoreCase(max) > 0)
            {
               max = (allExhibits.get(j)).getName();
               maxIndex = j;
            }
         }
       
         Collections.swap(allExhibits,i,maxIndex);
         System.out.println((allExhibits.get(i)).identifierToString());
      }
   }
   
   public void printExhibitAlpha()
   {
      String min;
      int minIndex;
      
      allExhibits.trimToSize();
      for (int i = 0; i < allExhibits.size(); i ++)
      {
         min = (allExhibits.get(i)).getName(); 
         minIndex = i;
       
         for (int j = i + 1; j < allExhibits.size(); j ++)
         {
            if (((allExhibits.get(j)).getName()).compareToIgnoreCase(min) < 0)
            {
               min = (allExhibits.get(j)).getName();
               minIndex = j;
            }
         }
       
         Collections.swap(allExhibits,i,minIndex);
         System.out.println((allExhibits.get(i)).identifierToString());
      }
   }
   
   public Exhibit searchExhibitById(int exhibitId)
   {
      int foundIndex = findExhibitIndexById(exhibitId);
      
      if (foundIndex == -1)
      {
         System.out.println("Exhibit with ID " + exhibitId + " cannot be found");
         return null;
      }
      else
         return allExhibits.get(foundIndex);
   }
   
   public Exhibit searchExhibitByName(String exhibitName)
   {
      int foundIndex = findExhibitIndexByName(exhibitName);
      
      if (foundIndex == -1)
      {
         System.out.println("Exhibit called " + exhibitName + " cannot be found");
         return null;
      }
      else
         return allExhibits.get(foundIndex);
   }
   
   public void printExhibitsExceedingValue(double givenValue)
   {
      allExhibits.trimToSize();
      for (int i = 0; i < allExhibits.size(); i ++)
      {
         //if ((allExhibits.get(i)).getValue() > givenValue)
         if ((allExhibits.get(i)).valueExceeds(givenValue))
            System.out.println((allExhibits.get(i)).identifierToString());
      }
   }
   
   public void printExhibitsWithinValue(double lowerbound, double upperbound)
   {
      allExhibits.trimToSize();
      for (int i = 0; i < allExhibits.size(); i ++)
      {
         //if ((allExhibits.get(i)).getValue() > lowerbound && allExhibits.get(i)).getValue() < upperbound)
         if ((allExhibits.get(i)).valueInRange(lowerbound, upperbound))
            System.out.println((allExhibits.get(i)).identifierToString());
      }
   }
   
   public void printExhibitsExceedingNumVisitors(int givenNum)
   {
      allExhibits.trimToSize();
      for (int i = 0; i < allExhibits.size(); i ++)
      {
         //if ((allExhibits.get(i)).getNumCurrentVisitors() > givenNum)
         if ((allExhibits.get(i)).currentNumVisitorsExceeds(givenNum))
            System.out.println((allExhibits.get(i)).identifierToString());
      }
   }
   
   public void printExhibitsWithinNumVisitors(int lowerbound, int upperbound)
   {
      allExhibits.trimToSize();
      for (int i = 0; i < allExhibits.size(); i ++)
      {
         //if ((allExhibits.get(i)).getNumCurrentVisitors() > lowerbound && (allExhibits.get(i)).getNumCurrentVisitors() < upperbound)
         if ((allExhibits.get(i)).currentNumVisitorsInRange(lowerbound, upperbound))
            System.out.println((allExhibits.get(i)).identifierToString());
      }
   }
   
   public void printExhibitsLessThanFloorSpace(double givenFloorSpace)
   {
      allExhibits.trimToSize();
      for (int i = 0; i < allExhibits.size(); i ++)
      {
         //if ((allExhibits.get(i)).getFloorSpace() < givenFloorSpace)
         if ((allExhibits.get(i)).floorSpaceUnder(givenFloorSpace))
            System.out.println((allExhibits.get(i)).identifierToString());
      }
   }
   
   public void printExhibitsWithinFloorSpace(double lowerbound, double upperbound)
   {
      allExhibits.trimToSize();
      for (int i = 0; i < allExhibits.size(); i ++)
      {
         //if ((allExhibits.get(i)).getFloorSpace() > lowerbound && (allExhibits.get(i)).getFloorSpace() < upperbound)
         if ((allExhibits.get(i)).floorSpaceInRange(lowerbound, upperbound))
            System.out.println((allExhibits.get(i)).identifierToString());
      }
   }
   
   public Exhibit greaterValueBetweenExhibits(int exhibitId1, int exhibitId2)
   {
      int index1 = findExhibitIndexById(exhibitId1);
      int index2 = findExhibitIndexById(exhibitId2);
      Exhibit exhibit1;
      Exhibit exhibit2;
      
      if (index1 != -1 && index2 != -1)
      {
         exhibit1 = allExhibits.get(index1);
         exhibit2 = allExhibits.get(index2);
         
         if (exhibit1.compareValue(exhibit2) > 0)
            return exhibit1;
         else if (exhibit1.compareValue(exhibit2) < 0)
            return exhibit2;
         else
         {
            System.out.println("Both exhibits have the same value");
            return null;
         }
      }
      else
      {
         System.out.println("Exhibit ID(s) are not valid");
         return null;
      }
   }
   
   public Exhibit greaterValueBetweenExhibits(String exhibitName1, String exhibitName2)
   {
      int index1 = findExhibitIndexByName(exhibitName1);
      int index2 = findExhibitIndexByName(exhibitName2);
      Exhibit exhibit1;
      Exhibit exhibit2;
      
      if (index1 != -1 && index2 != -1)
      {
         exhibit1 = allExhibits.get(index1);
         exhibit2 = allExhibits.get(index2);
         
         if (exhibit1.compareValue(exhibit2) > 0)
            return exhibit1;
         else if (exhibit1.compareValue(exhibit2) < 0)
            return exhibit2;
         else
         {
            System.out.println("Both exhibits have the same value");
            return null;
         }
      }
      else
      {
         System.out.println("Exhibit ID(s) are not valid");
         return null;
      }
   }
   
   public Exhibit greaterNumVisitorsBetweenExhibits(int exhibitId1, int exhibitId2)
   {
      int index1 = findExhibitIndexById(exhibitId1);
      int index2 = findExhibitIndexById(exhibitId2);
      Exhibit exhibit1;
      Exhibit exhibit2;
      
      if (index1 != -1 && index2 != -1)
      {
         exhibit1 = allExhibits.get(index1);
         exhibit2 = allExhibits.get(index2);
         
         if (exhibit1.compareNumCurrentVisitors(exhibit2) > 0)
            return exhibit1;
         else if (exhibit1.compareNumCurrentVisitors(exhibit2) < 0)
            return exhibit2;
         else
         {
            System.out.println("Both exhibits have the same number of current visitors");
            return null;
         }
      }
      else
      {
         System.out.println("Exhibit ID(s) are not valid");
         return null;
      }
   }
   
   public Exhibit greaterNumVisitorsBetweenExhibits(String exhibitName1, String exhibitName2)
   {
      int index1 = findExhibitIndexByName(exhibitName1);
      int index2 = findExhibitIndexByName(exhibitName2);
      Exhibit exhibit1;
      Exhibit exhibit2;
      
      if (index1 != -1 && index2 != -1)
      {
         exhibit1 = allExhibits.get(index1);
         exhibit2 = allExhibits.get(index2);
         
         if (exhibit1.compareNumCurrentVisitors(exhibit2) > 0)
            return exhibit1;
         else if (exhibit1.compareNumCurrentVisitors(exhibit2) < 0)
            return exhibit2;
         else
         {
            System.out.println("Both exhibits have the same number of current visitors");
            return null;
         }
      }
      else
      {
         System.out.println("Exhibit ID(s) are not valid");
         return null;
      }
   }
   
   public Exhibit greaterFloorSpaceBetweenExhibits(int exhibitId1, int exhibitId2)
   {
      int index1 = findExhibitIndexById(exhibitId1);
      int index2 = findExhibitIndexById(exhibitId2);
      Exhibit exhibit1;
      Exhibit exhibit2;
      
      if (index1 != -1 && index2 != -1)
      {
         exhibit1 = allExhibits.get(index1);
         exhibit2 = allExhibits.get(index2);
         
         if (exhibit1.compareFloorSpace(exhibit2) > 0)
            return exhibit1;
         else if (exhibit1.compareFloorSpace(exhibit2) < 0)
            return exhibit2;
         else
         {
            System.out.println("Both exhibits have the same required floor space");
            return null;
         }
      }
      else
      {
         System.out.println("Exhibit ID(s) are not valid");
         return null;
      }
   }
   
   public Exhibit greaterFloorSpaceBetweenExhibits(String exhibitName1, String exhibitName2)
   {
      int index1 = findExhibitIndexByName(exhibitName1);
      int index2 = findExhibitIndexByName(exhibitName2);
      Exhibit exhibit1;
      Exhibit exhibit2;
      
      if (index1 != -1 && index2 != -1)
      {
         exhibit1 = allExhibits.get(index1);
         exhibit2 = allExhibits.get(index2);
         
         if (exhibit1.compareFloorSpace(exhibit2) > 0)
            return exhibit1;
         else if (exhibit1.compareFloorSpace(exhibit2) < 0)
            return exhibit2;
         else
         {
            System.out.println("Both exhibits have the same required floor space");
            return null;
         }
      }
      else
      {
         System.out.println("Exhibit ID(s) are not valid");
         return null;
      }
   }
   
   public Exhibit greaterNumArtifactsBetweenExhibits(int exhibitId1, int exhibitId2)
   {
      int index1 = findExhibitIndexById(exhibitId1);
      int index2 = findExhibitIndexById(exhibitId2);
      Exhibit exhibit1;
      Exhibit exhibit2;
      
      if (index1 != -1 && index2 != -1)
      {
         exhibit1 = allExhibits.get(index1);
         exhibit2 = allExhibits.get(index2);
         
         if (exhibit1.compareNumArtifacts(exhibit2) > 0)
            return exhibit1;
         else if (exhibit1.compareNumArtifacts(exhibit2) < 0)
            return exhibit2;
         else
         {
            System.out.println("Both exhibits have the same number of artifacts");
            return null;
         }
      }
      else
      {
         System.out.println("Exhibit ID(s) are not valid");
         return null;
      }
   }
   
   public Exhibit greaterNumArtifactsBetweenExhibits(String exhibitName1, String exhibitName2)
   {
      int index1 = findExhibitIndexByName(exhibitName1);
      int index2 = findExhibitIndexByName(exhibitName2);
      Exhibit exhibit1;
      Exhibit exhibit2;
      
      if (index1 != -1 && index2 != -1)
      {
         exhibit1 = allExhibits.get(index1);
         exhibit2 = allExhibits.get(index2);
         
         if (exhibit1.compareNumArtifacts(exhibit2) > 0)
            return exhibit1;
         else if (exhibit1.compareNumArtifacts(exhibit2) < 0)
            return exhibit2;
         else
         {
            System.out.println("Both exhibits have the same number of artifacts");
            return null;
         }
      }
      else
      {
         System.out.println("Exhibit ID(s) are not valid");
         return null;
      }
   }
   
   private int findVisitorIndexById(int givenId)
   {
      int visitorIndex = -1;
      int currentId;
      
      allExhibits.trimToSize();
      
      for(int i = 0; i < allVisitors.size() && visitorIndex == -1; i ++)
      {
         currentId = (allVisitors.get(i)).getId();
         
         if (currentId == givenId)
            visitorIndex = i;
      }
      
      return visitorIndex;
   }
   
   private int findVisitorIndexByName(String givenName)
   {
      int visitorIndex = -1;
      String currentFirstName;
      String currentLastName;
      
      String[] name;
      name = givenName.split(" ");
      allExhibits.trimToSize();
      
      for (int i = 0; i < allVisitors.size() && visitorIndex == -1; i ++)
      {
         currentFirstName = (allVisitors.get(i)).getFirstName();
         currentLastName = (allVisitors.get(i)).getLastName();
         
         if (currentFirstName.equals(name[0]) && currentLastName.equals(name[1]))
            visitorIndex = i;
      }
      
      return visitorIndex;
   }
   
   private int findExhibitIndexById(int givenId)
   {
      int exhibitIndex = -1;
      int currentId;
      allExhibits.trimToSize();
      
      for (int i = 0; i < allExhibits.size() && exhibitIndex == -1; i ++)
      {
         currentId = (allExhibits.get(i)).getId();
         
         if (currentId == givenId)
            exhibitIndex = i;
      }
      
      return exhibitIndex;
   }
   
   private int findExhibitIndexByName(String givenName)
   {
      int exhibitIndex = -1;
      String currentName;
      allExhibits.trimToSize();
      
      for (int i = 0; i < allExhibits.size() && exhibitIndex == -1; i ++)
      {
         currentName = (allExhibits.get(i)).getName();
         
         if (currentName.equals(givenName))
            exhibitIndex = i;
      }
      
      return exhibitIndex;
   }
   
   private int findArtifactIndexById(int givenId)
   {
      int artifactIndex = -1;
      int currentId;
      allExhibits.trimToSize();
      
      for (int i = 0; i < allArtifacts.size() && artifactIndex == -1; i ++)
      {
         currentId = (allArtifacts.get(i)).getId();
         
         if (currentId == givenId)
            artifactIndex = i;
      }
      
      return artifactIndex;
   }
   
   private int findArtifactIndexByName(String givenName)
   {
      int artifactIndex = -1;
      String currentName;
      allExhibits.trimToSize();
      
      for (int i = 0; i < allArtifacts.size() && artifactIndex == -1; i ++)
      {
         currentName = (allArtifacts.get(i)).getName();
         
         if (currentName.equals(givenName))
            artifactIndex = i;
      }
      
      return artifactIndex;
   }
}
