/*
     Class Name:    Museum
     Author:        Jerry & William
     Creation Date: 2020-6-5
     Course:        ICS4U1-01
     Purpose:       This class represents a museum and manages all its operations.
*/

public class Museum
{
     private static final int VISITOR_BASE_ID = 100000;
     private static final int ARTIFACT_BASE_ID = 10000;
     private static final int EXHIBIT_BASE_ID = 1000;
     
     private Date openingDate;
     private Date currentDate;
     private double maxDisplaySpace;
     private double maxStorageSpace;
     private int numCurrentVisitors;
     private int daysOpenCount;
     private ArrayList allExhibits = new ArrayList();
     private ArrayList allArtifacts = new ArrayList();
     private ArrayList allVisitors = new ArrayList();
     private Bank bank;
     private static int numVisitorsAdded = 0;
     private static int numExhibitsAdded = 0;
     private static int numArtifactsAdded = 0;
     
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
     
     public Museum(String date1, String date2, double maxDisplaySpace, double maxStorageSpace)
     {
          Date openingDate = new Date(date1);
          Date currentDate = new Date(openingDate.identifierToString());
          this.openingDate = openingDate;
          this.currentDate = currentDate;
          this.maxDisplaySpace = maxDisplaySpace;
          this.maxStorageSpace = maxStorageSpace;
     }
     
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
     
     public ArrayList getAllExhibits() {
          return allExhibits;
     }
    
     public ArrayList getAllArtifacts() {
          return allArtifacts;
     }
     
     public ArrayList getAllVisitors() {
          return allVisitors;
     }
          
     public Bank getBank() {
          return bank;
     }
          
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
     
    public void setBank(double lifeTimeRevenue, double[] dailyRevenue) {
          Bank newBank = new Bank (lifeTimeRevenue, dailyRevenue);
          bank = newBank;
     }
        
     public void addVisitor(String firstName, String lastName, int age)
     {
          try
          {
               Visitor newVisitor = new Visitor(firstName, lastName, VISITOR_BASE_ID + numVisitorsAdded, age);
               numVisitorsAdded++;
               numCurrentVisitors++;
               allVisitors.add(newVisitor);
          }
          catch(Exception e)
          {
               System.out.println("Error adding visitor");
          }
     }
     
     public void removeVisitor(int givenId)
     {
          int foundIndex = findVisitorIndexById(givenId);
          
          if (foundIndex == -1)
               System.out.println("Visitor with ID " + visitorId + " cannot be found");
          else
          {
               allVisitors.remove(foundIndex);    
               numCurrentVisitors--; 
          }
     }
     
     public void removeVisitor(String givenName)
     {
          int foundIndex = findVisitorIndexByName(givenName);
          
          if (foundIndex == -1)
               System.out.println("Visitor with name " + visitorName + " cannot be found");
          else
          {
               allVisitors.remove(foundIndex);    
               numCurrentVisitors--; 
          }   
     }
     
     public void addExhibit(String name, int id, String description)
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
          
          if (foundIndex == -1)
               System.out.println("Exhibit with ID " + exhibitId + " cannot be found");
          else
               allExhibits.remove(foundIndex);     
     }
     
     public void removeExhibit(String exhibitName)
     {
          int foundIndex = findExhibitIndexByName(exhibitName);
          
          if (foundIndex == -1)
               System.out.println("Exhibit called " + exhibitName + " cannot be found");
          else
               allExhibits.remove(foundIndex);     
     }
     
     public void addArtifact(String name, int id, String description, double value, double floorSpace, String dateMadeString, String datePurchasedString, int exhibitId, boolean onDisplay)
     {
          try
          {
               Date dateMade = new Date(dateMadeString);
               Date datePurchased = new Date(datePurchasedString);
               Artifact newArtifact = new Artifact(name, id, description, value, floorSpace, dateMade, datePurchased, exhibitId, onDisplay);
               allArtifacts.add(newArtifact);
          }
          catch(Exception e)
          {
               System.out.println("Error adding artifact");
          }
     }
     
     public void removeArtifact(int artifactId)
     {
          int foundIndex = findArtifactIndexById(artifactId);
          
          if (foundIndex == -1)
               System.out.println("Artifact with ID " + artifactId + " cannot be found");
          else
               allArtifacts.remove(foundIndex);
     }
     
     public void removeArtifact(String artifactName)
     {
          int foundIndex = findArtifactIndexByName(artifactName);
          
          if (foundIndex == -1)
               System.out.println("Artifact called " + artifactName + " cannot be found");
          else
               allArtifacts.remove(foundIndex);
     }
     
     public boolean moveVisitor(int visitorId, int toArtifactId)
     {
          try
          {
               int visitorFoundIndex = findVisitorIndexById(visitorId);
               int artifactFoundIndex = findArtifactIndexById(toArtifactId);
               Visitor movingVisitor;
               Artifact toArtifact;
               
               if (visitorFoundIndex != -1 && artifactFoundIndex != -1)
               {
                    movingVisitor = allVisitors.get(visitorFoundIndex);
                    toArtifact = allArtifacts.get(toArtifact);
                    movingVisitor.moveVisitor(toArtifact);
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
               int visitorFoundIndex = findVisitorIndexByName(visitorName);
               int artifactFoundIndex = findArtifactIndexByname(toArtifactName);
               Visitor movingVisitor;
               Artifact toArtifact;
               
               if (visitorFoundIndex != -1 && artifactFoundIndex != -1)
               {
                    movingVisitor = allVisitors.get(visitorFoundIndex);
                    toArtifact = allArtifacts.get(toArtifact);
                    movingVisitor.moveVisitor(toArtifact);
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
     
     public double closeForTheDay()
     {
          ArrayList dailyRevenue = bank.getDailyRevenue();
          dailyRevenue.trimToSize();
          double todayRevenue = (double) dailyRevenue.get(dailyRevenue.size() - 1);
          daysOpenCount++;
          
          // clear visitor array in museum
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
          
          return todayRevenue;
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
          ArrayList artifactsVisited;
          
          if (foundIndex == -1)
               System.out.println("Visitor with ID " + givenId + " cannot be found");
          else
          {
               foundVisitor = allVisitors.get(foundIndex);
               artifactsVisited = foundVisitor.getVisitedExhibits();
               
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
          ArrayList artifactsVisited;
          
          if (foundIndex = -1)
               System.out.println("Visitor with name " + givenName + " cannot be found");
          else
          {
               foundVisitor = allVisitors.get(foundIndex);
               artifactsVisited = foundVisitor.getVisitedExhibits();
               
               for (int i = 0; i < artifactsVisited.size(); i ++)
               {
                    System.out.print((artifactsVisited.get(i)).identifierToString());
               }
          }   
     }
     
     public int numAdults()
     {
          int adultCount = 0;
          
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
          
          for (int i = 0; i < allVisitors.size(); i ++)
          {
               if (allVisitors.get(i) instanceof Child)
                    childCount++;
          }
          
          return childCount;
     }
     
     public int numSenior()
     {
          int seniorCount = 0;
          
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
          for (int i = 0; i < allVisitors.size(); i ++)
          {
               if (allVisitors.get(i) instanceof Adult)
                    System.out.println((allVisitors.get(i)).identifierToString());
          }
     }
     
     public void printAllChildren()
     {
          for (int i = 0; i < allVisitors.size(); i ++)
          {
               if (allVisitors.get(i) instanceof Child)
                    System.out.println((allVisitors.get(i)).identifierToString());
          }
     }
     
     public void printAllSeniors()
     {
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
          ArrayList currentVisitors;
          
          if (foundIndex == -1)
               System.out.println("The exhibit with ID " + exhibitId + " cannot be found");
          else
          {
               foundExhibit = allExhibits.get(foundIndex);
               currentVisitors = foundExhibit.getCurrentVisitors();
               
               for (int i = 0; i < currentVisitors.size(); i ++)
               {
                    System.out.println((currentVisitor.get(i)).identifierToString());
               }
          }
     }
     
     public void printVisitorsAtExhibit(String exhibitName)
     {
          int foundIndex = findExhibitIndexByName(exhibitName);
          Exhibit foundExhibit;
          ArrayList currentVisitors;
          
          if (foundIndex == -1)
               System.out.println("The exhibit called " + exhibitName + " cannot be found");
          else
          {
               foundExhibit = allExhibits.get(foundIndex);
               currentVisitors = foundExhibit.getCurrentVisitors();
               
               for (int i = 0; i < currentVisitors.size(); i ++)
               {
                    System.out.println((currentVisitor.get(i)).identifierToString());
               }
          }
     }
     
     public void printVisitorsAtArtifact(int artifactId)
     {
          int foundIndex = findArtifactIndexById(artifactId);
          Artifact foundArtifact;
          ArrayList currentVisitors;
          
          if (foundIndex == -1)
               System.out.println("The artifact with ID " + artifactId + " cannot be found");
          else
          {
               foundArtifact = allArtifacts.get(foundIndex);
               currentVisitors = foundArtifact.getCurrentVisitors();
               
               for (int i = 0; i < currentVisitors.size(); i ++)
               {
                    System.out.println((currentVisitor.get(i)).identifierToString());
               }
          }
     }
     
     public void printVisitorsAtArtifact(String artifactName)
     {
          int foundIndex = findArtifactIndexByName(artifactName);
          Artifact foundArtifact;
          ArrayList currentVisitors;
          
          if (foundIndex == -1)
               System.out.println("The artifact called " + artifactName + " cannot be found");
          else
          {
               foundArtifact = allArtifacts.get(foundIndex);
               currentVisitors = foundArtifact.getCurrentVisitors();
               
               for (int i = 0; i < currentVisitors.size(); i ++)
               {
                    System.out.println((currentVisitor.get(i)).identifierToString());
               }
          }
     }
     
     public void printAllExhibits()
     {
          
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
               
               if (visitor1.compareVisitorAge(visitor2) > 0)
                    return visitor1;
               else if (visitor1.compareVisitorAge(visitor2) < 0)
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
               
               if (visitor1.compareVisitorAge(visitor2) > 0)
                    return visitor1;
               else if (visitor1.compareVisitorAge(visitor2) < 0)
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
               
               if (visitor1.comapareExhibitVisits(visitor2) > 0)
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
               
               if (visitor1.comapareExhibitVisits(visitor2) > 0)
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
               
               if (visitor1.comapareArtifactVisits(visitor2) > 0)
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
               
               if (visitor1.comapareArtifactVisits(visitor2) > 0)
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
          for (int i = 0; i < allExhibits.size(); i ++)
          {
               System.out.println((allExhibits.get(i)).identifierToString());
          }
     }
     
     public void printAllArtifactsInExhibit(int exhibitId)
     {
          int foundIndex = findExhibitIndexById(exhibitId);
          Exhibit foundExhibit;
          ArrayList artifactsInExhibit;
          
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
          ArrayList artifactsInExhibit;
          
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
               System.out.println("Exhibit with ID " + exhibitName + " cannot be found");
          else
               System.out.println((allExhibits.get(foundIndex)).identifierToString());
     }
     
     public void printAllVisitorsInExhibit(int exhibitId)
     {
          int foundIndex = findExhibitIndexById(exhibitId);
          Exhibit foundExhibit;
          ArrayList visitorsInExhibit;
          
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
          ArrayList visitorsInExhibit;
          
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
               System.out.println("Exhibit with ID " + exhibitId + " cannot be found");
          else
               return (allExhibits.get(foundIndex)).getNumArtifacts();
     }
     
     public int numArtifactsInExhibit(String exhibitName)
     {
          int foundIndex = findExhibitIndexByName(exhibitName);
          
          if (foundIndex == -1)
               System.out.println("Exhibit called " + exhibitName + " cannot be found");
          else
               return (allExhibits.get(foundIndex)).getNumArtifacts();
     }
     
     public int numVisitorsInExhibit(int exhibitId)
     {
          int foundIndex = findExhibitIndexById(exhibitId);
          
          if (foundIndex == -1)
               System.out.println("Exhibit with ID " + exhibitId + " cannot be found");
          else
               return (allExhibits.get(foundIndex)).getNumVisitors();
     }
     
     public int numVisitorsInExhibit(String exhibitName)
     {
          int foundIndex = findExhibitIndexByName(exhibitName);
          
          if (foundIndex == -1)
               System.out.println("Exhibit called " + exhibitName + " cannot be found");
          else
               return (allExhibits.get(foundIndex)).getNumVisitors();
     }
     
     public void printExhibitsCurrentlyOnFloor()
     {  
          for (int i = 0; i < allExhibits.size(); i ++)
          {
               if ((allExhibits.get(i)).getOnDisplay())
                    System.out.println((allExhibits.get(i)).identifierToString());
          }
     }
     
     public void printExhibitsInStorage()
     {
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
          double max;
          int maxIndex;
      
          for (int i = 0; i < allExhibits.size(); i ++)
          {
             max = (allExhibits.get(i)).getNumCurrentVisitors(); 
             maxIndex = i;
             
             for (int j = i + 1; j < allExhibits.size(); j ++)
             {
                if (((allExhibits.get(j)).getNumCurrentVisitors) > max)
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
          
          for (int i = 0; i < allExhibits.size(); i ++)
          {
             max = (String)allExhibits.get(i); 
             maxIndex = i;
             
             for (int j = i + 1; j < allExhibits.size(); j ++)
             {
                if (((String) allExhibits.get(j)).compareToIgnoreCase(max) > 0)
                {
                   max = (String) allExhibits.get(j);
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
          
          for (int i = 0; i < allExhibits.size(); i ++)
          {
             min = (String)allExhibits.get(i); 
             minIndex = i;
             
             for (int j = i + 1; j < allExhibits.size(); j ++)
             {
                if (((String) allExhibits.get(j)).compareToIgnoreCase(min) < 0)
                {
                   min = (String) allExhibits.get(j);
                   minIndex = j;
                }
             }
             
             Collections.swap(allExhibits,i,minIndex);
             System.out.println((allExhibits.get(i)).identifierToString());
          }
     }
     
     public Exhibit searchExhibitById(int exhibitId)
     {
          int foundIndex = findExhibitIndexById(exhibitId)
          
          if (foundIndex == -1)
               System.out.println("Exhibit with ID " + exhibitId + " cannot be found");
               return null;
          else
               return allExhibits.get(foundIndex);
     }
     
     public Exhibit searchExhibitByName(String exhibitName)
     {
          int foundIndex = findExhibitIndexByName(exhibitName)
          
          if (foundIndex == -1)
               System.out.println("Exhibit called " + exhibitName + " cannot be found");
               return null;
          else
               return allExhibits.get(foundIndex);
     }
     
     public void printExhibitsExceedingValue(double givenValue)
     {
          for (int i = 0; i < allExhibits.size(); i ++)
          {
               //if ((allExhibits.get(i)).getValue() > givenValue)
               if ((allExhibits.get(i)).valueExceeds(givenValue))
                    System.out.println((allExhibits.get(i)).identifierToString());
          }
     }
     
     public void printExhibitsWithinValue(double lowerbound, double upperbound)
     {
          for (int i = 0; i < allExhibits.size(); i ++)
          {
               //if ((allExhibits.get(i)).getValue() > lowerbound && allExhibits.get(i)).getValue() < upperbound)
               if ((allExhibits.get(i)).valueInRange(lowerbound, upperbound))
                    System.out.println((allExhibits.get(i)).identifierToString());
          }
     }
     
     public void printExhibitsExceedingNumVisitors(int givenNum)
     {
          for (int i = 0; i < allExhibits.size(); i ++)
          {
               //if ((allExhibits.get(i)).getNumCurrentVisitors() > givenNum)
               if ((allExhibits.get(i)).numCurrentVisitorsExceeds(givenNum))
                    System.out.println((allExhibits.get(i)).identifierToString());
          }
     }
     
     public void printExhibitsWithinNumVisitors(int lowerbound, int upperbound)
     {
          for (int i = 0; i < allExhibits.size(); i ++)
          {
               //if ((allExhibits.get(i)).getNumCurrentVisitors() > lowerbound && (allExhibits.get(i)).getNumCurrentVisitors() < upperbound)
               if ((allExhibits.get(i)).numCurrentVisitorsInRange(lowerbound, upperbound))
                    System.out.println((allExhibits.get(i)).identifierToString());
          }
     }
     
     public void printExhibitsLessThanFloorSpace(double givenFloorSpace)
     {
          for (int i = 0; i < allExhibits.size(); i ++)
          {
               //if ((allExhibits.get(i)).getFloorSpace() < givenFloorSpace)
               if ((allExhibits.get(i)).floorSpaceUnder(givenFloorSpace))
                    System.out.println((allExhibits.get(i)).identifierToString());
          }
     }
     
     public void printExhibitsWithinFloorSpace(double lowerbound, double upperbound)
     {
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
               
               if (exhibit1.compareNumVisitors(exhibit2) > 0)
                    return exhibit1;
               else if (exhibit1.compareNumVisitors(exhibit2) < 0)
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
               
               if (exhibit1.compareNumVisitors(exhibit2) > 0)
                    return exhibit1;
               else if (exhibit1.compareNumVisitors(exhibit2) < 0)
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
          int index1 = findExhibitIndexById(exhibitName1);
          int index2 = findExhibitIndexById(exhibitName2);
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
     
     private static int findVisitorIndexById(int givenId)
     {
          int visitorIndex = -1;
          int currentId;
          
          for(int i = 0; i < allVisitors.size() && visitorIndex == -1; i ++)
          {
               currentId = (allVisitors.get(i)).getId();
               
               if (currentId == givenId)
                    visitorIndex = i;
          }
          
          return visitorIndex;
     }
     
     private static int findVisitorIndexByName(String givenName)
     {
          int visitorIndex = -1;
          String currentFistName;
          String currentLastName;
          
          String[] name;
          name = givenName.split(" ");
          
          for (int i = 0; i < allVisitors.size() && visitorIndex == -1; i ++)
          {
               currentFirstName = (allVisitors.get(i)).getFirstName();
               currentLastName = (allVisitors.get(i)).getLastName();
               
               if (currentFistName.equals(name[0]) && currentLastName.equals(name[1]))
                    visitorIndex = i;
          }
          
          return visitorIndex;
     }
     
     private static int findExhibitIndexById(int givenId)
     {
          int exhibitIndex = -1;
          int currentId;
          
          for (int i = 0; i < allExhibits.size() && exhibitIndex == -1; i ++)
          {
               currentId = (allExhibits.get(i)).getId();
               
               if (currentId == givenId)
                    exhibitIndex = i;
          }
          
          return exhibitIndex;
     }
     
     private static int findExhibitIndexByName(String givenName)
     {
          int exhibitIndex = -1;
          String currentName;
          
          for (int i = 0; i < allExhibits.size() && exhibitIndex == -1; i ++)
          {
               currentName = (allExhibits.get(i)).getName();
               
               if (currentName.equals(givenName))
                    exhibitIndex = i
          }
          
          return exhibitIndex;
     }
     
     private static int findArtifactIndexById(int givenId)
     {
          int artifactIndex = -1;
          int currentId;
          
          for (int i = 0; i < allArtifacts.size() && artifactIndex == -1; i ++)
          {
               currentId = (allArtifacts.get(i)).getId();
               
               if (currentId == givenId)
                    artifactIndex = i;
          }
          
          return artifactIndex;
     }
     
     private static int findArtifactIndexByName(String givenName)
     {
          int artifactIndex = -1;
          String currentName;
          
          for (int i = 0; i < allArtifacts.size() && artifactIndex == -1; i ++)
          {
               currentName = (allArtifacts.get(i)).getName();
               
               if (currentName.equals(givenName))
                    artifactIndex = i;
          }
          
          return artifactIndex;
     }
     
     private static void sortIntegersAscending(ArrayList list)
     {
          int min;
          int minIndex;
      
          for (int i = 0; i < list.size() - 1; i ++)
          {
             min = (int) list.get(i); 
             minIndex = i;
             
             for (int j = i + 1; j < list.size(); j ++)
             {
                if ((int) list.get(j) < min)
                {
                   min = (int) list.get(j);
                   minIndex = j;
                }
             }
             
             Collections.swap(list,i,minIndex);
          }
     }
     
     private static void sortIntegersDescending(ArrayList list)
     {
          int max;
          int maxIndex;
      
          for (int i = 0; i < list.size() - 1; i ++)
          {
             max = (int) list.get(i); 
             maxIndex = i;
             
             for (int j = i + 1; j < list.size(); j ++)
             {
                if ((int) list.get(j) > max)
                {
                   max = (int) list.get(j);
                   maxIndex = j;
                }
             }
             
             Collections.swap(list,i,maxIndex);
          }
     }
     
     private static void sortDoublesAscending(ArrayList list)
     {
          double min;
          int minIndex;
      
          for (int i = 0; i < list.size() - 1; i ++)
          {
             min = (double) list.get(i); 
             minIndex = i;
             
             for (int j = i + 1; j < list.size(); j ++)
             {
                if ((double) list.get(j) < min)
                {
                   min = (double) list.get(j);
                   minIndex = j;
                }
             }
             
             Collections.swap(list,i,minIndex);
          }
     }
     
     private static void sortDoublesDescending(ArrayList list)
     {
          double max;
          int maxIndex;
      
          for (int i = 0; i < list.size() - 1; i ++)
          {
             max = (double) list.get(i); 
             maxIndex = i;
             
             for (int j = i + 1; j < list.size(); j ++)
             {
                if ((double) list.get(j) > max)
                {
                   max = (double) list.get(j);
                   maxIndex = j;
                }
             }
             
             Collections.swap(list,i,maxIndex);
          }
     }

    public void printAllArtifacts(){
        for(Artifact a: getAllArtifacts()){
            System.out.println(a);
        }
    }
    
    public void printSpecificArtifact(String name){
        System.out.println(searchArtifactByName(name));
    }
    
    public void printSpecificArtifact(int id){
        System.out.println(searchArtifactByID(id));
    }
    
    public void printAllVisitorsAtArtifact(String name){
        for(Visitor v: searchArtifactByName(name).getCurrentVisitors()){
            System.out.println(v);
        }
    }
    
    public void printAllVisitorsAtArtifact(int id){
        for(Visitor v: searchArtifactByID(id).getCurrentVisitors()){
            System.out.println(v);
        }
    }
     
    public int numVisitorsAtArtifact(String name){
        try{
            return searchArtifactByName(name).getCurrentVisitors().length;
        }catch(Exception e){
            System.out.println("Artifact \"" + name + "\" doesn't exist.");
            return 0;
        }
    }
    
    public int numVisitorsAtArtifact(int id){
        try{
            return searchArtifactByID(id).getCurrentVisitors().length;
        }catch(Exception e){
            System.out.println("Artifact \"" + name + "\" doesn't exist.");
            return 0;
        }
    }
    
    public void printArtifactsCurrentlyOnFloor(){
        for(Artifact a: getAllArtifacts()){
            if(a.isOnDisplay()){
                System.out.println(a);
            }
        }
    }
    
    public void printArtifactsInStorage(){
        for(Artifact a: getAllArtifacts()){
            if(!a.isOnDisplay()){
                System.out.println(a);
            }
        }
    }
     
    public void  printArtifactsAscendingValue(){
        Artifact[] sortedList = getAllArtifacts().clone();
        Artifact temp;
        
        for(int i = 0; i < sortedList.length-1; i++){
            if(sortedList[i].getValue() > sortedList[i+1].getValue()){
                temp = sortedList[i+1];
                for(int j = i; j >= 0; j--){
                    if(sortedList[j].getValue() < temp.getValue()){
                        sortedList[j+1]=temp;
                    }else{
                        sortedList[j+1]=sortedList[j];
                        sortedList[j] = temp;
                    }
                }
            }
        }
        
        for(Artifact a: sortedList){
            System.out.println(a);
        }
    }
    
    public void  printArtifactsDescendingValue(){
        Artifact[] sortedList = getAllArtifacts().clone();
        Artifact temp;
        
        for(int i = 0; i < sortedList.length-1; i++){
            if(sortedList[i].getValue() < sortedList[i+1].getValue()){
                temp = sortedList[i+1];
                for(int j = i; j >= 0; j--){
                    if(sortedList[j].getValue() > temp.getValue()){
                        sortedList[j+1]=temp;
                    }else{
                        sortedList[j+1]=sortedList[j];
                        sortedList[j] = temp;
                    }
                }
            }
        }
        
        for(Artifact a: sortedList){
            System.out.println(a);
        }
    }
    
    public void  printArtifactsAscendingFloorSpace(){
        Artifact[] sortedList = getAllArtifacts().clone();
        Artifact temp;
        
        for(int i = 0; i < sortedList.length-1; i++){
            if(sortedList[i].getFloorSpace() > sortedList[i+1].getFloorSpace()){
                temp = sortedList[i+1];
                for(int j = i; j >= 0; j--){
                    if(sortedList[j].getFloorSpace() < temp.getFloorSpace()){
                        sortedList[j+1]=temp;
                    }else{
                        sortedList[j+1]=sortedList[j];
                        sortedList[j] = temp;
                    }
                }
            }
        }
        
        for(Artifact a: sortedList){
            System.out.println(a);
        }
    }
    
    public void  printArtifactsDescendingFloorSpace(){
        Artifact[] sortedList = getAllArtifacts().clone();
        Artifact temp;
        
        for(int i = 0; i < sortedList.length-1; i++){
            if(sortedList[i].getFloorSpace() < sortedList[i+1].getFloorSpace()){
                temp = sortedList[i+1];
                for(int j = i; j >= 0; j--){
                    if(sortedList[j].getFloorSpace() > temp.getFloorSpace()){
                        sortedList[j+1]=temp;
                    }else{
                        sortedList[j+1]=sortedList[j];
                        sortedList[j] = temp;
                    }
                }
            }
        }
        
        for(Artifact a: sortedList){
            System.out.println(a);
        }
    }
    
    public void  printArtifactsOldToRecent(){
        Artifact[] sortedList = getAllArtifacts().clone();
        Artifact temp;
        
        for(int i = 0; i < sortedList.length-1; i++){
            if(sortedList[i+1].madeAfter(sortedList[i].getDateMade())){
                temp = sortedList[i+1];
                for(int j = i; j >= 0; j--){
                    if(sortedList[j].madeAfter(temp.getDateMade())){
                        sortedList[j+1]=temp;
                    }else{
                        sortedList[j+1]=sortedList[j];
                        sortedList[j] = temp;
                    }
                }
            }
        }
        
        for(Artifact a: sortedList){
            System.out.println(a);
        }
    }
    
    public void  printArtifactsRecentToOld(){
        Artifact[] sortedList = getAllArtifacts().clone();
        Artifact temp;
        
        for(int i = 0; i < sortedList.length-1; i++){
            if(sortedList[i+1].madeBefore(sortedList[i].getDateMade())){
                temp = sortedList[i+1];
                for(int j = i; j >= 0; j--){
                    if(sortedList[j].madeAfter(temp.getDateMade())){
                        sortedList[j+1]=temp;
                    }else{
                        sortedList[j+1]=sortedList[j];
                        sortedList[j] = temp;
                    }
                }
            }
        }
        
        for(Artifact a: sortedList){
            System.out.println(a);
        }
    }
    
    public void  printArtifactsAscendingVisitors(){
        Artifact[] sortedList = getAllArtifacts().clone();
        Artifact temp;
        
        for(int i = 0; i < sortedList.length-1; i++){
            if(sortedList[i].getNumVisitors() > sortedList[i+1].getNumVisitors()){
                temp = sortedList[i+1];
                for(int j = i; j >= 0; j--){
                    if(sortedList[j].getNumVisitors() < temp.getNumVisitors()){
                        sortedList[j+1]=temp;
                    }else{
                        sortedList[j+1]=sortedList[j];
                        sortedList[j] = temp;
                    }
                }
            }
        }
        
        for(Artifact a: sortedList){
            System.out.println(a);
        }
    }
    
    public void  printArtifactsDescendingVisitors(){
        Artifact[] sortedList = getAllArtifacts().clone();
        Artifact temp;
        
        for(int i = 0; i < sortedList.length-1; i++){
            if(sortedList[i].getNumVisitors() < sortedList[i+1].getNumVisitors()){
                temp = sortedList[i+1];
                for(int j = i; j >= 0; j--){
                    if(sortedList[j].getNumVisitors() > temp.getNumVisitors()){
                        sortedList[j+1]=temp;
                    }else{
                        sortedList[j+1]=sortedList[j];
                        sortedList[j] = temp;
                    }
                }
            }
        }
        
        for(Artifact a: sortedList){
            System.out.println(a);
        }
    }
    
    
    
//printArtifactsAlpha()
//printArtifactsReverseAlpha()
    
    
    
    public Artifact searchArtifactByName(String name){
        for(Artifact a: getAllArtifacts()){
            if(a.getName().equals(name){
                return a;
            }
        }
        return null;
    }
    
    
    public Artifact searchArtifactByID(int id){
        for(Artifact a: getAllArtifacts()){
            if(a.getID() == id){
                return a;
            }
        }
        return null;
    }
    
    public void printArtifactsOfType(String type){
        for(Artifact a: getAllArtifacts()){
            if(a.getType().equals(type)){
                System.out.println(a);
            }
        }
    }
    
    public void printArtifactsExceedingValue(double min){
        for(Artifact a: getAllArtifacts()){
            if(a.getValue() > min){
                System.out.println(a);
            }
        }
    }
    
    public void printArtifactsWithinValue(double min, double max){
        for(Artifact a: getAllArtifacts()){
            if(a.getValue() >= min && a.getValue() <= max){
                System.out.println(a);
            }
        }
    }
    
    public void printArtifactsExceedingNumVisitors(int min){
        for(Artifact a: getAllArtifacts()){
            if(a.getNumVisitors() > min){
                System.out.println(a);
            }
        }
    }
    
    public void printArtifactsWithinNumVisitors(int min, int max){
        for(Artifact a: getAllArtifacts()){
            if(a.getNumVisitors() >= min && a.getNumVisitors() <= max){
                System.out.println(a);
            }
        }
    }
    
    public void printArtifactsLessThanFloorSpace(double max){
        for(Artifact a: getAllArtifacts()){
            if(a.getFloorSpace() < max){
                System.out.println(a);
            }
        }
    }
    
    public void printArtifactsMadeBefore(String date){
        for(Artifact a: getAllArtifacts()){
            if(a.madeBefore(new Date(date)){
                System.out.println(a);
            }
        }
    }
    
    public void printArtifactsMadeWithin(String date1, String date2){
        for(Artifact a: getAllArtifacts()){
            if(a.madeWithin(new Date(date1), new Date(date@))){
                System.out.println(a);
            }
        }
    }
    
    public void printArtifactsPurchasedBefore(String date){
        for(Artifact a: getAllArtifacts()){
            if(a.purchasedBefore(new Date(date)){
                System.out.println(a);
            }
        }
    }
    
    public void printArtifactsPurchasedWithin(String date1, String date2){
        for(Artifact a: getAllArtifacts()){
            if(a.purchasedWithin(new Date(date1), new Date(date@))){
                System.out.println(a);
            }
        }
    }
    
    public Artifact greaterValueBetweenArtifacts(int id1, int id2){
        Artifact a = searchArtifactByID(id1);
        Artifact b = searchArtifactByID(id2);
        
        if(a.getValue() < b.getValue()){
            return b;
        }
        return a;
    }
    
    public Artifact greaterValueBetweenArtifacts(String name1, String name2){
        Artifact a = searchArtifactByName(name1);
        Artifact b = searchArtifactByName(name2);
        
        if(a.getValue() < b.getValue()){
            return b;
        }
        return a;
    }
    
    public Artifact olderMadeBetweenArtifacts(int id1, int id2){
        Artifact a = searchArtifactByID(id1);
        Artifact b = searchArtifactByID(id2);
        
        if(a.madeBefore(b)){
            return a;
        }
        return b;
    }
    
    public Artifact olderMadeBetweenArtifacts(String name1, String name2){
        Artifact a = searchArtifactByName(name1);
        Artifact b = searchArtifactByName(name2);
        
        if(a.madeBefore(b)){
            return a;
        }
        return b;
    }
    
    public Artifact olderPurchasedBetweenArtifacts(int id1, int id2){
        Artifact a = searchArtifactByID(id1);
        Artifact b = searchArtifactByID(id2);
        
        if(a.purchasedBefore(b)){
            return a;
        }
        return b;
    }
    
    public Artifact olderPurchasedBetweenArtifacts(String name1, String name2){
        Artifact a = searchArtifactByName(name1);
        Artifact b = searchArtifactByName(name2);
        
        if(a.purchasedBefore(b)){
            return a;
        }
        return b;
    }
    
    public Artifact greaterNumVisitorsBetweenArtifacts(int id1, int id2){
        Artifact a = searchArtifactByID(id1);
        Artifact b = searchArtifactByID(id2);
        
        if(a.getNumVisitors() > b.getNumVisitors())){
            return a;
        }
        return b;
    }
    
    public Artifact greaterNumVisitorsBetweenArtifacts(String name1, String name2){
        Artifact a = searchArtifactByName(name1);
        Artifact b = searchArtifactByName(name2);
        
        if(a.getNumVisitors() > b.getNumVisitors())){
            return a;
        }
        return b;
    }
    
    public Artifact greaterFloorSpaceBetweenArtifacts(int id1, int id2){
        Artifact a = searchArtifactByID(id1);
        Artifact b = searchArtifactByID(id2);
        
        if(a.getFloorSpace() > b.getFloorSpace())){
            return a;
        }
        return b;
    }
    
    public Artifact greaterFloorSpaceBetweenArtifacts(String name1, String name2){
        Artifact a = searchArtifactByName(name1);
        Artifact b = searchArtifactByName(name2);
        
        if(a.getFloorSpace() > b.getFloorSpace())){
            return a;
        }
        return b;
    }
    
    public String toString(){
        String s = this.getDescription();
        
        for(Artifact a: getAllArtifacts()){
            s = s + a;
        }
        
        for(Exhibit e: allExhibits){
            s = s + e;
        }
        
        for(Visitor v: allVisitors){
            s = s + v;
        }
        
        return s;
    }
    
    public boolean equals(Museum museum2){
        if(museum2 != null){
            if( this.getOpeningDate() == museum2.getOpeningDate() &&
                this.getCurrentDate() == museum2.getCurrentDate() &&
                this.getMaxDisplaySpace() == museum2.getMaxDisplaySpace() &&
                this.getMaxStorageSpace() == museum2.getMaxStorageSpace() &&
                this.getNumCurrentVisitors() == museum2.getNumCurrentVisitors() &&
                this.getDaysOpenCount() == museum2.getDaysOpenCount()   
            ){
                return true;
            }
        }
        
        return false;
    }
    
}
