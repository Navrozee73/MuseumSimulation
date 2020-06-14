/*
   File: Date.java
   Description: 
   
   
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
   private int day;
   private int month;
   private int year;
   private boolean ce;
   private static final int [] DAYS_IN_MONTH = {31,28,31,30,31,30,31,31,30,31,30,31};
   
   public Date(int day, int month, int year, boolean ce)
   {
      this.day = day;
      this.month = month;
      this.year = year;
      this.ce = ce;
   }
   
   public Date (String date)
   {
//       try
//       {
         int temp;
         
            year = Integer.parseInt(date.substring(6,10));   
           
         temp = Integer.parseInt(date.substring(3,5));   //month
         if (temp >= 1 && temp <= 12)
            month = temp;
         else
            throw new InputMismatchException();  
         
         temp = Integer.parseInt(date.substring(0,2));
         if (temp <= DAYS_IN_MONTH[month-1])
            day = temp;
         else
            throw new InputMismatchException();
            
         if (date.contains("B.C.E.") || date.contains("B.C.E") || date.contains("BCE") ||date.contains("B.C.") || date.contains("B.C") || date.contains("BC"))
            ce = false;
         else if (date.contains("C.E.") || date.contains("C.E") || date.contains("CE"))
            ce = true;
         else
            throw new InputMismatchException();
//       }
//       catch (InputMismatchException imx)
//       {
//          System.out.println ("Error with formatting of date. Please use format: dd/mm/yyyy C.E. or dd/mm/yyyy B.C.E.");
//       }
//       catch (Exception e)
//       {
//          System.out.println ("Error creating date.");
//       }
   }
   
   public String toString() 
   {
      String dayString, monString, yearString = "";
      String output;
      if (day < 10)
         dayString = "0" + day;
      else
         dayString = "" + day;
      if (month < 10)
         monString = "0" + month;
      else
         monString = "" + month;
      if (year < 10)
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
   
   public String identifierToString()
   {
      String dayString, monString, yearString = "";
      String output;
      if (day < 10)
         dayString = "0" + day;
      else
         dayString = "" + day;
      if (month < 10)
         monString = "0" + month;
      else
         monString = "" + month;
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
   
   public int daysBetween(Date other)
   { 
      Date higherDate, lowerDate;
      int daysNum = 0;
      
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
       
      if (this.equals(other))
         return 0;
      else
      {
         if (ce && other.ce) //both ce
         {
            daysNum += Date.DAYS_IN_MONTH[lowerDate.month-1]-lowerDate.day;   //makes lowerDate basicaly to upper month
            
            // add days to basically round to upper year
            for (int i = lowerDate.month+1; i<= 12; i++) //starts 1 up cuz rounded there
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
            for (int i = lowerDate.month+1; i<= 12; i++) //starts 1 up cuz rounded there
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
   
   private boolean isOlder(Date other)
   {
      if (ce && !other.ce)
         return false;
      else if  (!ce && other.ce)
         return true;
      else        //both ce or both bce
      {
         if (ce)     //older has lower year, lower month, lower days
         {
            if (year - other.year > 0)
               return false;
            else if (year-other.year < 0)
               return true;
            else     // same year
            {
               if (month - other.month > 0)
                  return false;
               else if (month - other.month < 0)
                  return true;
               else  // same month
               {
                  if (day - other.day >= 0)   //same date or is younger 
                     return false;
                  else if (day - other.day < 0)
                     return true;  
               }
            }
         }
            
         else if (!ce)        //older Date has higher year, lower month, lower day
         {
            if (year - other.year > 0)
               return true;
            else if (year - other.year < 0)
               return false;
            else
            {
              if (month - other.month > 0)
                  return false;
               else if (month - other.month < 0)
                  return true;
               else  // same month
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
   
   public int compareTo (Date other)
   {
      if (this.isOlder(other))
         return (-1* this.daysBetween(other));
      else
         return (this.daysBetween(other));  
   }
   
   public boolean withinDates (Date min, Date max)
   {
      return (this.compareTo (min) > 0 && this.compareTo(max)< 0);
   }

   public boolean equals (Date other)
   {
      return (day == other.day && month == other.month && year == other.year && ce == other.ce);
   }
   
   public void progressDate (int numDaysForward)
   {
      for (int i=0; i< numDaysForward;i++)
         this.progressDate();
   }
   
   public void progressDate ()
   {
         day++;
         if (day > Date.DAYS_IN_MONTH[month-1]) //day flows over
         {
            month++;
            day = 1;
         }
         
         if (month > 12)
         {
            month = 1;
            if (ce)  //ce
            {
               year ++;
            }
            else  //bce
            {
               year--;
               if (year == 0)
               {
                  ce = true;
               }
            }
         }
      
   }
}

