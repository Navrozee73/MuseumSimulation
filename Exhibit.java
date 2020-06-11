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
      
      if (idNum > 999 && ((idNum+"").length() == 4))
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
      
      if (idNum > 999 && ((idNum+"").length() == 4))
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
   
   public void setId(int idNum)
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
   
   private void updateNumArtifacts()
   {
      artifactList.trimToSize();
      numArtifacts = artifactList.size();
   }
   
   private void updateNumCurrentVisitors()
   {
      currentVisitors.trimToSize();
      numCurrentVisitors = currentVisitors.size();
   }
   
   private void updateValue()
   {
      double temp=0;
      for (int i=0;i<numArtifacts;i++)
         temp += artifactList.get(i).getValue();
      value = temp;
   }
   
   private void updateFloorSpace()
   {
      double temp=0;
      for (int i=0;i<numArtifacts;i++)
         temp += artifactList.get(i).getFloorSpace();
      floorSpace = temp;
   }
   
   private void updateOnDisplay()
   {
      boolean temp = false;
      for (int i=0; i<numArtifacts;i++)
         if (artifactList.get(i).getOnDisplay())
            temp = true;
      onDisplay = temp;
   }
   
   public String toString()
   {
      String info = "";
      info = "EXHIBIT: " + name + "\nID: " + id + "\nDescription: " + description + "\nTotal Exhibit Value: $" + value + "\nTotal Floor Space Required: " + floorSpace + " sq. ft." + "\nTotal Number of Current Visitors: " + numCurrentVisitors + "\nTotal Number of Current Artifacts: " + numArtifacts + "\n\nList of Artifacts within Museum: ";
      for (int i=0; i< numArtifacts; i++)
      {
         info+= ("\n" + artifactList.get(i));
      } 
      return info;
   }
   
   public String identifierToString()
   {
      return ("Name: " + name + " ID: " + id);
   }
   
   public String[] artifactsToString()
   {
      String [] artifactsInfo = new String [numArtifacts];
      for (int i=0; i< numArtifacts; i++)
      {
         artifactsInfo[i] = (artifactList.get(i).toString());
      }  
      return artifactsInfo;
   }
   
   public String[] currentVisitorsToString()
   {
      String [] visitorsInfo = new String [numCurrentVisitors];
      
      for (int i=0; i< numCurrentVisitors; i++)
      {
         visitorsInfo[i] = (currentVisitors.get(i).toString());
      } 
      return visitorsInfo;
   }
   
   public String [] artifactIdentifiersToString() 
   {
      String [] identifiers = new String [numArtifacts];
      
      for (int i=0;i<numArtifacts;i++)
      {
         identifiers[i] = artifactList.get(i).identifierToString();
      }
      return identifiers;
   }
   
   public String[] currentVisitorIdentifiersToString()
   {
      String [] identifiers = new String [numCurrentVisitors];
      
      for (int i=0;i<numCurrentVisitors;i++)
      {
         identifiers[i] = currentVisitors.get(i).identifierToString();
      }
      return identifiers;
   }
   
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
   
   public boolean removeArtifact (Artifact targetArtifact)
   {
      boolean found = false;
      for (int i = 0;i<numArtifacts && !found;i++)
      {
         if (artifactList.get(i).equals(targetArtifact))
         {
            artifactList.remove(i);
            updateNumArtifacts();
            found = true;
         }
      }
      return found;
   }
   
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
   
   public boolean valueExceeds(double min)
   {
      return (value > min);
   }
   
   public boolean valueInRange (double min, double max)
   {
      return (value >= min && value <= max);
   }
   
   public boolean currentNumVisitorsExceeds(int min)
   {
      return (numCurrentVisitors > min);
   }
   
   public boolean currentNumVisitorsInRange (int min, int max)
   {
      return (numCurrentVisitors>= min && numCurrentVisitors <= max);
   }
   
   public boolean floorSpaceUnder(double max)
   {
      return (floorSpace < max);
   }
   
   public boolean floorSpaceInRange(double min, double max)
   {  
      return (floorSpace >= min && floorSpace <= max);
   }
   
   public double compareValue (Exhibit other)
   {
      return (value - other.value);
   }
   
   public int compareNumCurrentVisitors(Exhibit other)
   {
      return (numCurrentVisitors - other.numCurrentVisitors);
   }
   
   public int compareNumArtifacts(Exhibit other)
   {
      return (numArtifacts - other.numArtifacts);
   }
   
   public double compareFloorSpace(Exhibit other)
   {
      return (floorSpace - other.floorSpace);
   }
   
   public int compareName(Exhibit other)
   {
      return (name.compareTo(other.name));
   }
   
   public void clearVisitors()
   {
      for (int i=0; i<numArtifacts;i++)
      {
         artifactList.get(i).clearVisitors();
      }
      updateNumCurrentVisitors();
   }
}
