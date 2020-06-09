/*
   File: Artifact.java
   Description: 
   
   
   User: Navroze
   Date: 04/06/2020
   Changes Made:  Created constructors, accessors and mutators
   
   Date: 05/06/2020
   Changes Made: Made the following methods:
                                             
                                             addVisitor(Visitor)
                                             removeVisitor(Visitor)
                                             equals()
                                             all toString methods
                                             all compare methods
                                             all exceeds/inRange methods
   Date: 08/06/2020
   Changes Made: Created clearVisitors()
      
                  
*/
import java.util.*;

public class Artifact
{
   private String name;
   private int id;
   private String description;
   private double value;
   private int numCurrentVisitors;
   private double floorSpace;
   private boolean onDisplay;
   
   private Date dateMade;
   private Date datePurchased;
   private Exhibit exhibitLocation;
   private ArrayList<Visitor> currentVisitors;
   
   public Artifact(String artifactName, int idNum, String descr, double val, double reqFloorSpace, Date dateMade, Date dateBought, Exhibit location, boolean displayed)
   {
      name = artifactName;
      
      if (idNum > 9999 && ((idNum+"").length() == 5))
         id= idNum;
      else
         throw new InputMismatchException();
         
      description = descr;
      value = val;
      floorSpace = reqFloorSpace;
      this.dateMade = dateMade;
      datePurchased = dateBought;
      exhibitLocation = location;
      onDisplay = displayed;
      numCurrentVisitors = 0;
      currentVisitors = new ArrayList<Visitor>();
   }
   
   public Artifact (String artifactName, int idNum, String descr, double val, double reqFloorSpace, Date dateMade, Date dateBought, Exhibit location, boolean displayed, ArrayList<Visitor> visitors)
   {
      name = artifactName;
      
      if (idNum > 9999 && ((idNum+"").length() == 5))
         id= idNum;
      else
         throw new InputMismatchException();
         
      description = descr;
      value = val;
      floorSpace = reqFloorSpace;
      this.dateMade = dateMade;
      datePurchased = dateBought;
      exhibitLocation = location;
      onDisplay = displayed;
      currentVisitors = visitors;
      numCurrentVisitors = 0;
   }
   
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
   
   public double getValue()
   {
      return value;
   }
   
   public int getNumCurrentVisitors()
   {
      return numCurrentVisitors;
   }
   
   public double getFloorSpace()
   {
      return floorSpace;
   }
   
   public boolean getOnDisplay()
   {
      return onDisplay;
   }
   
   public Date getDateMade()
   {
      return dateMade;
   }
   
   public Date getDatePurchased()
   {
      return datePurchased;
   }
   
   public Exhibit getExhibitLocation()
   {
      return exhibitLocation;
   }
   
   public ArrayList getCurrentVisitors ()
   {
      return currentVisitors;
   }
   
   public void setName(String name)
   {
      this.name = name;
   }
   
   public void setId(int id)
   { 
   
      if (id > 9999 && ((id+"").length() == 5))
         this.id= id;
      else
         throw new InputMismatchException();
         
   }
   
   public void setDescription(String description)
   {
      this.description = description;
   }
   
   public void setValue(double value)
   {
      this.value = value;
   }
   
   public void setNumCurrentVisitors(int numVisitors)
   {
      numCurrentVisitors = numVisitors;
   }
   
   public void setFloorSpace(double reqFloorSpace)
   {
      floorSpace = reqFloorSpace;
   }
   
   public void setOnDisplay(boolean displayed)
   {
      onDisplay = displayed;
   }
   
   public void setDateMade(Date dateMade)
   {
      this.dateMade = dateMade;
   }
   
   public void setDatePurchased(Date dateBought)
   {
      datePurchased = dateBought;
   }
   
   public void setExhibitLocation(Exhibit location)
   {
      exhibitLocation = location;
   }
   
   public void setCurrentVisitors(ArrayList<Visitor> visitors)
   {
      currentVisitors = visitors;
   }
   
   private void updateNumCurrentVisitors()
   {
      currentVisitors.trimToSize();
      numCurrentVisitors = currentVisitors.size();
   }
   
   public String toString() 
   {
      String info = "";
      info += ("ARTIFACT: " + name + "\nID: " + id + "\nDescription: " + description);
      info += ("\nValue: $" + value + "\nDate Made: " + dateMade.identifierToString() + "\nDate Purchased: " + datePurchased.identifierToString());
      info += ("\nFloor Space Required: " + floorSpace + " sq. ft.\nExhibit Location: " + exhibitLocation.identifierToString() + "\nNumber of Current Visitors: " + numCurrentVisitors + "\nVisitors:");
      for (int i=0; i< numCurrentVisitors; i++)
      {
         info+= ("\n" + currentVisitors.get(i).toString());
      }
      
      return info;
   }
   
   public String identifierToString() 
   {
      return("Name: " + name + " ID: " + id);
   }
   
   public String [] currentVisitorsToString() 
   {
      String [] visitors = new String [numCurrentVisitors];
      for (int i=0;i<numCurrentVisitors;i++)
      {
         visitors[i] = currentVisitors.get(i).toString();
      }
      return visitors;
   }
   
   public String[] currentVisitorsIdentifierToString()
   {
      String [] visitors = new String [numCurrentVisitors];
      for (int i=0;i<numCurrentVisitors;i++)
      {
         visitors[i] =currentVisitors.get(i).identifierToString();
      }
      return visitors;
   }
   
   public boolean addVisitor (Visitor newVisitor)
   {  
      try 
      {  
        currentVisitors.add(newVisitor);
        updateNumCurrentVisitors();
        return true;
      }
      catch (Exception e)
      {
         return false;
      }
   }
   
   public boolean removeVisitor (Visitor targetVisitor)
   {  
      boolean found = false;
      for (int i = 0;i<numCurrentVisitors && !found;i++)
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
   
   public boolean valueExceeds (double min)
   {
      return (value > min);
   }
   
   public boolean valueInRange(double min, double max)
   {
      return (value >= min && value <= max);
   }
   
   public boolean numCurrentVisitorsExceeds(int min)
   {
      return (numCurrentVisitors > min);
   }
   
   public boolean numCurrentVisitorsInRange(int min, int max)
   {
      return (numCurrentVisitors >= min && numCurrentVisitors <= max);
   }
   
   public boolean floorSpaceUnder(double max)
   {
      return (floorSpace < max);
   }
   
   public boolean floorSpaceInRange(double min, double max)
   {
      return (floorSpace >= min && floorSpace <= max);
   }
   
   public boolean madeBefore(Date date)
   {
      return (dateMade.compareTo(date) > 0);
   }
   
   public boolean madeWithin (Date date1, Date date2)
   {
      return (dateMade.compareTo(date1) <=0 && dateMade.compareTo(date2) >= 0);
   }
   
   public boolean purchasedBefore(Date date)
   {
      return (datePurchased.compareTo(date) > 0);
   }
   
   public boolean purchasedWithin (Date date1, Date date2)
   {
      return (datePurchased.compareTo(date1) <= 0 && datePurchased.compareTo(date2) >= 0);
   }
   
   public double compareValue (Artifact other)
   {
      return (value - other.value);
   }
   
   public int compareName(Artifact other)
   {
      return (name.compareTo(other.name));
   }
   
   public int compareNumCurrentVisitors(Artifact other)
   {
      return (numCurrentVisitors - other.numCurrentVisitors);
   }
   
   public int compareDateMade(Artifact other)
   {
      return (dateMade.compareTo(other.dateMade));
   }
   
   public int compareDatePurchased(Artifact other)
   {
      return (datePurchased.compareTo(other.datePurchased));
   }
   
   public boolean equals(Artifact other)
   {
      boolean equals = (other != null && name.equals(other.name) && id == other.id && description.equals(other.description) 
                        && value == other.value && floorSpace == other.floorSpace && onDisplay == onDisplay
                        && dateMade.equals(other.dateMade) && datePurchased.equals(other.datePurchased) 
                        && exhibitLocation.getName().equals(other.exhibitLocation.getName()) && exhibitLocation.getId() == other.exhibitLocation.getId()
                        && exhibitLocation.getDescription().equals(other.exhibitLocation.getDescription()));
      if (numCurrentVisitors == other.numCurrentVisitors)
      {
         for (int i=0;i<numCurrentVisitors;i++)
         {
            if (!((currentVisitors.get(i)).equals(other.currentVisitors.get(i))))
               equals = false;
         }
      }
      else
      {
         equals = false;
      }
      
      return equals;
   }
   
   public void clearVisitors()
   {
      currentVisitors.clear();
      updateNumCurrentVisitors();
   }
}