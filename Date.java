/*
   File: Date.java
   Description: A date consists of a day, month, year, and the 
                information of whether or not it is before common era or after 
   
   User: Navroze
   Date: 08/08/2020
   Changes Made:
                  Created constructor, accessors and mutators
                  
   Date: 08/09/2020
   Changes Made:
                  Created toString methods
                  daysBetween(Date)
                  withinDates(Date1, Date2)
                  equals(Date)
                  compareTo(Date)
                  isOlder(Date)
                  progressDate(int)
                  
*/
import java.util.*;
public class Date
{
   // FIELDS
   private int day;
   private int month;
   private int year;
   private boolean ce;
   
   // Array of days in each month
   private static final int [] DAYS_IN_MONTH = {31,28,31,30,31,30,31,31,30,31,30,31};
   
   // CONSTRUCTORS
   
   // Constructor for given all field values
   public Date(int day, int month, int year, boolean ce)
   {
      this.day = day;
      this.month = month;
      this.year = year;
      this.ce = ce;
   }
   
   // Constructor for when given a String that correlates to a date
   public Date (String date)
   {
         int temp;
         
         year = Integer.parseInt(date.substring(6,10));   // reads year
           
         temp = Integer.parseInt(date.substring(3,5));   //reads the month
         
         if (temp >= 1 && temp <= 12)                 // checks if month is valid, if not, throws exception
            month = temp;
         else
            throw new InputMismatchException();  
         
         temp = Integer.parseInt(date.substring(0,2));   // reads the date
         if (temp <= DAYS_IN_MONTH[month-1])             // checks if valid for the month, if not, throws exception
            day = temp;
         else
            throw new InputMismatchException();
            
         // Reads if common era or before common era. If incorrect format found, throws exception
         if (date.substring(11).equals("C.E.") || date.substring(11).equals("C.E")|| date.substring(11).equals("c.e")|| date.substring(11).equals("c.e.")|| date.substring(11).equals("ce")) 
            ce = true;
         else if (date.substring(11).equals("B.C.E.") || date.substring(11).equals("B.C.E") || date.substring(11).equals("B.C.") || date.substring(11).equals("B.C")|| date.substring(11).equals("b.c.e") 
                     || date.substring(11).equals("b.c.e.") || date.substring(11).equals("b.c")|| date.substring(11).equals("b.c.") || date.substring(11).equals("bc"))
            ce = false;
         else
            throw new InputMismatchException();
   }
   
   // Returns all field properties of the Date
   public String toString() 
   {
      String dayString, monString, yearString = "";
      String output;
      
      if (day < 10)  // fixes format of day to include leading zeroes
         dayString = "0" + day;
      else
         dayString = "" + day;
         
      if (month < 10)   // fixes format of month to include leading zeroes
         monString = "0" + month;
      else
         monString = "" + month;
            
      if (year < 10)    // fixes format of year to include leading zeroes
         yearString += "0";
      if (year < 100)
         yearString += "0";
      if (year < 1000)
         yearString += "0";
      yearString += ""+year;
      
      output= "Day: " + dayString + "\nMonth: " + monString + "\nYear: " + yearString; 
      
      if (ce)
         output += "C.E.";
      else 
         output += "B.C.E.";
      return output;      
   }
   
   public String identifierToString()  // returns Date identifier in String format that can be read and interpreted by Date constructor
   {
      String dayString, monString, yearString = "";
      String output;
      
      // adds leading zeroes to date
      if (day < 10)
         dayString = "0" + day;
      else
         dayString = "" + day;
         
       // adds leading zeroes to month
      if (month < 10)
         monString = "0" + month;
      else
         monString = "" + month;
         
       // adds leading zeroes to year  
      if (year < 10)
         yearString += "0";
      if (year < 100)
         yearString += "0";
      if (year < 1000)
         yearString += "0";
      yearString += ""+year;
      
      output = dayString + "/" + monString + "/" + yearString + " ";
      
      if (ce)
         output += "C.E.";
      else 
         output += "B.C.E.";
      return output;
   }
   
   public int daysBetween(Date other)  // finds the absolute number of days between two dates
   { 
      Date higherDate, lowerDate;
      int daysNum = 0;
      
      // determines whether implicit or explicit is older
      if (this.isOlder(other))
      {
         higherDate = this;
         lowerDate = other;
      }
      else
      {
         higherDate = other;
         lowerDate = this;
      }
       
      if (this.equals(other)) // if same date, returns 0
         return 0;
      else
      {
         if (ce && other.ce) //both ce
         {
            daysNum += Date.DAYS_IN_MONTH[lowerDate.month-1]-lowerDate.day;   //makes lowerDate basically round to upper month
            
            // add days to basically round to upper year
            for (int i = lowerDate.month+1; i<= 12; i++) //starts 1 up since rounded there
            {
               daysNum += Date.DAYS_IN_MONTH[i-1];  
            }
            
            daysNum += (higherDate.year - (lowerDate.year+1)) * 365;
            
            for (int i=1;i<higherDate.month;i++)
            {
               daysNum += Date.DAYS_IN_MONTH[i-1];
            }
            daysNum += higherDate.day;
         }
         else if (!ce && !other.ce) //both bce
         {
            daysNum += Date.DAYS_IN_MONTH[lowerDate.month-1]-lowerDate.day;   //rounds to upper month
            
            // adds days in months
            for (int i = lowerDate.month+1; i<= 12; i++) //starts 1 up since rounded there
            {
               daysNum += Date.DAYS_IN_MONTH[lowerDate.month+1-1];  
            }
            
            daysNum += (((lowerDate.year-1) - higherDate.year) * 365);
            
            for (int i=1;i<higherDate.month;i++)
            {
               daysNum += Date.DAYS_IN_MONTH[i-1];
            }
            daysNum += higherDate.day;            
         }
         else  // lowerDate is bce, higherDate is ce
         {
            daysNum += Date.DAYS_IN_MONTH[lowerDate.month-1]-lowerDate.day;   //rounds to upper month
            
            // adds days in months
            for (int i = lowerDate.month+1; i<= 12; i++) //starts 1 up cuz rounded there
            {
               daysNum += Date.DAYS_IN_MONTH[lowerDate.month+1-1];  
            }
            
            daysNum += (lowerDate.year-1)*365;
            daysNum += higherDate.year*365;        
         
            for (int i=1;i<higherDate.month;i++)
            {
               daysNum += Date.DAYS_IN_MONTH[i-1];
            }
            daysNum += higherDate.day;      
         }
         return Math.abs(daysNum);
      }  
   }
   
   // Determines whether the implicit is an older date than the explicit
   private boolean isOlder(Date other) 
   {
      if (ce && !other.ce) // if the implicit is CE and explicit is BCE then explicit is older
         return false;
      else if  (!ce && other.ce) // if the explicit is CE and implicit is BCE then implicit is older
         return true;
         
      else        //both ce or both bce
      {
         if (ce)     //if both are CE, older one must have lower year, lower month, lower days
         {
            if (year - other.year > 0)
               return false;
            else if (year-other.year < 0)
               return true;
            else     // if same year
            {
               if (month - other.month > 0)
                  return false;
               else if (month - other.month < 0)
                  return true;
               else  // if same month
               {
                  if (day - other.day >= 0)   //if same day or is younger 
                     return false;
                  else if (day - other.day < 0)
                     return true;  
               }
            }
         }
            
         else if (!ce)        //if both are BCE, older Date must have the higher year, lower month, lower day
         {
            if (year - other.year > 0) // if this year value is larger than explicit, it is older
               return true;
            else if (year - other.year < 0)// if this year value is larger than explicit, it is not older
               return false;
            else
            {
              if (month - other.month > 0)   // if same year
                  return false;
               else if (month - other.month < 0)
                  return true;
               else  // if also same month
               {
                  if (day - other.day >= 0)   //same date or is younger 
                     return false;
                  else if (day - other.day < 0)
                     return true;   
               }
            }
         }
      }
      
      return false; //needed to compile
   }
   
   // Uses the daysBetween method to compare two dates. 
   // If implicit is older, a negative value will be returned, if not a positive value will be returned 
   public int compareTo (Date other)
   {
      if (this.isOlder(other))
         return (-1* this.daysBetween(other));
      else
         return (this.daysBetween(other));  
   }
   
   // returns whether this Date falls between two other Dates
   public boolean withinDates (Date min, Date max)
   {
      return (this.compareTo (min) > 0 && this.compareTo(max)< 0);
   }

   // returns whether this Date is the same as another Date
   public boolean equals (Date other)
   {
      return (day == other.day && month == other.month && year == other.year && ce == other.ce);
   }
   
   // Moves the date forward a number of days
   public void progressDate (int numDaysForward)
   {
      for (int i=0; i< numDaysForward;i++)
         this.progressDate();
   }
   
   // Moves the date forward by one day, progressing month and year, and CE status if necessary
   public void progressDate ()
   {
         day++;   //increment day
         if (day > Date.DAYS_IN_MONTH[month-1]) //if day flows over
         {
            month++; // increment month
            day = 1; // reset day to start of new month
         }
         
         if (month > 12)   // if day flow-over causes month flow-over
         {
            month = 1;  // reset month to start of new year
            if (ce)  //if C.E, increment year
            {
               year ++;
            }
            else  //if B.C.E, decrement year value
            {
               year--;
               if (year == 0) // if year flowover causes it to be at the crossing point between B.C.E & C.E, set to C.E
               {
                  ce = true;
               }
            }
         }
      
   }
}

