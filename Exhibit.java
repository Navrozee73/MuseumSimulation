/*
   File: Exhibit.java
   Description: 
   
   
   User: Navroze
   Date: 06/06/2020
   Changes Made:  Created constructors, accessors and mutators
                  Created the following methods:
                                             all toString methods
                                             addArtifact(Artifact)
                                             removeArtifact(Artifact)
                                       
   
   Date: 08/06/2020
   Changes Made: Made the following methods:
                                             
                                             addVisitor(Visitor)
                                             removeVisitor(Visitor)
                                             equals()
                                             all compare methods
                                             all exceeds/inRange methods
                                             clearVisitors()
      
                  
*/
import java.util.*;

public class Exhibit
{
   // FIELDS
   private String name;
   private int id;
   private String description;
   private boolean onDisplay;
   private int numCurrentVisitors;
   private int numArtifacts;
   private double value;
   private double floorSpace;
   
   private ArrayList<Artifact> artifactList;
   private ArrayList<Visitor> currentVisitors;
   
   //CONSTRUCTORS
   
   // Constructor for creating brand new exhibit
   public Exhibit(String exhName, int idNum, String desc)
   {
      name = exhName;
      
      if (idNum > 999 && ((idNum+"").length() == 4))  //valid Exhibit IDs must be 1000-9999  
         id= idNum;
      else
         throw new InputMismatchException();
         
      description = desc;
      onDisplay = false;
      numCurrentVisitors = 0;
      numArtifacts = 0;
      value = 0;
      floorSpace = 0;
      artifactList = new ArrayList<Artifact>();
      currentVisitors = new ArrayList<Visitor>();
   }
   
   // Constructor for creating exhibit from file, given all fields
   public Exhibit(String exhName, int idNum, String desc, boolean displayed, int visitorCount, int artifactCount, double price, double reqSpace, ArrayList<Artifact> artifacts, ArrayList<Visitor> visitors)
   {
      name = exhName;
      
      if (idNum > 999 && ((idNum+"").length() == 4))
         id= idNum;
      else
         throw new InputMismatchException();
         
      description = desc;
      onDisplay = displayed;
      numCurrentVisitors = visitorCount;
      numArtifacts = artifactCount;
      value = price;
      floorSpace = reqSpace;
      
      artifacts.trimToSize();
      visitors.trimToSize();
      artifactList = artifacts;
      currentVisitors = visitors;
   }
   
   // Constructor for creating exhibit from file, given all fields but array sizes undetermined
   public Exhibit(String exhName, int idNum, String desc, boolean displayed, double price, double reqSpace, ArrayList<Artifact> artifacts, ArrayList<Visitor> visitors)
   {
      name = exhName;
      
      if (idNum > 999 && ((idNum+"").length() == 4))  //valid Exhibit IDs must be 1000-9999
         id= idNum;
      else
         throw new InputMismatchException();
         
      description = desc;
      onDisplay = displayed;
      value = price;
      floorSpace = reqSpace;
      
      artifacts.trimToSize();
      visitors.trimToSize();
      artifactList = artifacts;
      numArtifacts = artifactList.size();
      currentVisitors = visitors;
      numCurrentVisitors = currentVisitors.size();
   }
   
   // ACCESSORS & MUTATORS
   public String getName()
   {
      return name;
   }
   
   public int getId()
   {
      return id;
   }
   
   public String getDescription()
   {
      return description;
   }
   
   public boolean getOnDisplay()
   {
      return onDisplay;
   }
   
   public int getNumCurrentVisitors()
   {
      return numCurrentVisitors;
   }
   
   public int getNumArtifacts()
   {
      return numArtifacts;
   }
   
   public double getValue()
   {
      return value;
   }
   
   public double getFloorSpace()
   {
      return floorSpace;
   }
   
   public ArrayList<Artifact> getArtifactList()
   {
      return artifactList;
   }
   
   public ArrayList<Visitor> getCurrentVisitors()
   {
      return currentVisitors;
   }
   
   public void setName(String exhName)
   {
      name = exhName;
   }
   
   public void setId(int idNum)     // Id number is only valid if 1000-9999
   {
      if (idNum > 999 && ((idNum+"").length() == 4))
         id = idNum;
      else
         throw new InputMismatchException();
   }
   
   public void setDescription(String desc)
   {
      description = desc;
   }
   
   public void setOnDisplay(boolean displayed)
   {
      onDisplay = displayed;
   }
   
   public void setNumCurrentVisitors(int numVisitors)
   {
      numCurrentVisitors = numVisitors;
   }
   
   public void setNumArtifacts(int numArts)
   {
      numArtifacts = numArts;
   }
   
   public void setValue(double price)
   {
      value = price;
   }
   
   public void setFloorSpace(double reqSpace)
   {
      floorSpace = reqSpace;
   }
   
   public void setArtifactList(ArrayList<Artifact> list)
   {
      artifactList = list;
   }
   
   public void setCurrentVisitors(ArrayList<Visitor> list)
   {
      currentVisitors = list;
   }
   
   //UPDATE METHODS
   //Updates the number of Artifacts within the exhibit to be the size of the ArrayList of artifacts
   private void updateNumArtifacts()
   {
      artifactList.trimToSize();
      numArtifacts = artifactList.size();
   }
   
   //Updates the number of visitors in the Exhibit to be the size of the ArrayList of current visitors
   private void updateNumCurrentVisitors()
   {
      currentVisitors.trimToSize();
      numCurrentVisitors = currentVisitors.size();
   }
   
   // Updates the total value of the artifacts within the exhibit to be the sum of all current artifacts
   private void updateValue()
   {
      double temp=0;
      for (int i=0;i<numArtifacts;i++)
         temp += artifactList.get(i).getValue();
      value = temp;
   }

   // Updates the total floor space of the artifacts within the exhibit to be the sum of all current artifacts
   private void updateFloorSpace()
   {
      double temp=0;
      for (int i=0;i<numArtifacts;i++)
         temp += artifactList.get(i).getFloorSpace();
      floorSpace = temp;
   }

   // Updates whether or not any parts of the exhibit are on display 
   private void updateOnDisplay()
   {
      boolean temp = false;
      for (int i=0; i<numArtifacts;i++)
         if (artifactList.get(i).getOnDisplay())
            temp = true;
      onDisplay = temp;
   }
 
   // Print all properties of the exhibit including name, id, description
   // total value, total floor space, number of current artifacts and visitors, and the information on all the artifacts  
   public String toString()
   {
      String info = "";
      info = "EXHIBIT: " + name + "\nID: " + id + "\nDescription: " + description + "\nTotal Exhibit Value: $" + value + "\nTotal Floor Space Required: " + floorSpace + " sq. ft." + "\nTotal Number of Current Visitors: " + numCurrentVisitors + "\nTotal Number of Current Artifacts: " + numArtifacts + "\n\nList of Artifacts within Exhibit: ";
      for (int i=0; i< numArtifacts; i++)
      {
         info+= ("\n" + artifactList.get(i));
      } 
      if (numArtifacts == 0)
         info+= ("\nN/A");
      return info;
   }
   
   // Return just Exhibit Name + id
   public String identifierToString()
   {
      return (id + " " + name);
   }
   
   // Return all current artifacts' properties
   public String[] artifactsToString()
   {
      String [] artifactsInfo = new String [numArtifacts];
      for (int i=0; i< numArtifacts; i++)
      {
         artifactsInfo[i] = (artifactList.get(i).toString());
      }  
      return artifactsInfo;
   }
   
   // Return all current visitors' properties
   public String[] currentVisitorsToString()
   {
      String [] visitorsInfo = new String [numCurrentVisitors];
      
      for (int i=0; i< numCurrentVisitors; i++)
      {
         visitorsInfo[i] = (currentVisitors.get(i).toString());
      } 
      return visitorsInfo;
   }
   
   // Return all current artifacts' identifiers
   public String [] artifactIdentifiersToString() 
   {
      String [] identifiers = new String [numArtifacts];
      
      for (int i=0;i<numArtifacts;i++)
      {
         identifiers[i] = artifactList.get(i).identifierToString();
      }
      return identifiers;
   }
   
   // Return all current visitors' identifiers
   public String[] currentVisitorIdentifiersToString()
   {
      String [] identifiers = new String [numCurrentVisitors];
      
      for (int i=0;i<numCurrentVisitors;i++)
      {
         identifiers[i] = currentVisitors.get(i).identifierToString();
      }
      return identifiers;
   }
   
   // Adds an artifact to the exhibit, updates value, floorSpace, onDisplay and numArtifacts of exhibit to reflect the new addition
   public boolean addArtifact (Artifact newArtifact)
   {
      try 
      {  
        artifactList.add(newArtifact);
        updateNumArtifacts();
        updateValue();
        updateFloorSpace();
        updateOnDisplay();
        return true;
      }
      catch (Exception e)
      {
         return false;
      }
   }
   
   // Remove an artifact from the exhibit, updates value, floorSpace, onDisplay and numArtifacts of exhibit to reflect the new addition
   public boolean removeArtifact (Artifact targetArtifact)
   {
      boolean found = false;
      for (int i = 0;i<numArtifacts && !found;i++)
      {
         if (artifactList.get(i).equals(targetArtifact))
         {
            artifactList.remove(i);
            updateNumArtifacts();
            updateValue();
            updateFloorSpace();
            updateOnDisplay();
            return true;
         }
      }
      return found;
   }
   
   // Add a visitor to the exhibit, updates the number of current visitors to reflect the change
   public boolean addVisitor(Visitor targetVisitor)
   {
      try 
      {  
        currentVisitors.add(targetVisitor);
        updateNumCurrentVisitors();
        return true;
      }
      catch (Exception e)
      {
         return false;
      }  
   }
   
   // Remove a visitor from the currentVisitors list. Does not remove from the artifact they're within.
   public boolean removeVisitor(Visitor targetVisitor)
   {
      boolean found = false;
      for (int i=0; i<numCurrentVisitors && !found; i++)
      {
         if (currentVisitors.get(i).equals(targetVisitor))
         {
            currentVisitors.remove(i);
            updateNumCurrentVisitors();
            found = true;
         }
      }
      return found;
   }
   
   // Returns whether the exhibit is the same as another Exhibit
   public boolean equals (Exhibit other)
   {
      boolean equals = (other != null && name.equals(other.name) && id == other.id && 
                        description.equals(other.description) && numCurrentVisitors == other.numCurrentVisitors && numArtifacts == other.numArtifacts);
      if (equals)
      {
         for (int i=0; i<numCurrentVisitors;i++)
         {
            if (!(currentVisitors.get(i).equals(other.currentVisitors.get(i))))
               equals = false;
         }
         for (int i=0; i < numArtifacts;i++)
         {
            if (!(artifactList.get(i).equals(other.artifactList.get(i))))
               equals = false;
         }
      }
      return equals;
   }
   
   // returns whether the exhibit's total value exceeds an amount
   public boolean valueExceeds(double min)
   {
      return (value > min);
   }

   // returns whether the exhibit's total value is within a range 
   public boolean valueInRange (double min, double max)
   {
      return (value >= min && value <= max);
   }

   // returns whether the exhibit's total number of visitors exceeds an amount   
   public boolean currentNumVisitorsExceeds(int min)
   {
      return (numCurrentVisitors > min);
   }
   
   // returns whether the exhibit's total number of visitors is within a range    
   public boolean currentNumVisitorsInRange (int min, int max)
   {
      return (numCurrentVisitors>= min && numCurrentVisitors <= max);
   }
   
   // returns whether the exhibit's total value is below an amount   
   public boolean floorSpaceUnder(double max)
   {
      return (floorSpace < max);
   }
   
   // returns whether the exhibit's total floor space is within a range    
   public boolean floorSpaceInRange(double min, double max)
   {  
      return (floorSpace >= min && floorSpace <= max);
   }

   // Compare exhibit values by subtracting the explicit Exhibit's value from the implicit's
   // Returns positive value if implicit > explicit, 0 if implicit= explicit, negative value if implicit < explicit 
   public double compareValue (Exhibit other)
   {
      return (value - other.value);
   }
   
   // Compare exhibit number of visitors by subtracting the explicit Exhibit's number of current visitors from the implicit's
   // Returns positive value if implicit > explicit, 0 if implicit= explicit, negative value if implicit < explicit 
   public int compareNumCurrentVisitors(Exhibit other)
   {
      return (numCurrentVisitors - other.numCurrentVisitors);
   }
   
   // Compare exhibit number of artifacts by subtracting the explicit Exhibit's number of current artifacts from the implicit's
   // Returns positive value if implicit > explicit, 0 if implicit= explicit, negative value if implicit < explicit 
   public int compareNumArtifacts(Exhibit other)
   {
      return (numArtifacts - other.numArtifacts);
   }
   
   // Compare exhibit floor space by subtracting the explicit Exhibit's floor space from the implicit's
   // Returns positive value if implicit > explicit, 0 if implicit= explicit, negative value if implicit < explicit 
   public double compareFloorSpace(Exhibit other)
   {
      return (floorSpace - other.floorSpace);
   }
   
   // compares exhibit names using String .compareTo
   public int compareName(Exhibit other)
   {
      return (name.compareTo(other.name));
   }
   
   // empties all visitors from the exhibit. Does not clear visitors from inner artifacts.
   public void clearVisitors()
   {
      for (int i=0; i<numArtifacts;i++)
      {
         artifactList.get(i).clearVisitors();
      }
      updateNumCurrentVisitors();
   }
}
