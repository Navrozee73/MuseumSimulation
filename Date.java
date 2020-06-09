/*
   File: Date.java
   Description: 
   
   
   User: Navroze
   Date: 08/06/2020
   Changes Made:
      
                  
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
            
         if (date.substring(11).equals("C.E.") || date.substring(11).equals("C.E"))
            ce = true;
         else if (date.substring(11).equals("B.C.E.") || date.substring(11).equals("B.C.E") || date.substring(11).equals("B.C.") || date.substring(11).equals("B.C"))
            ce = false;
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
   
   public int compareTo (Date other)
   {
      return 1;
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
}
