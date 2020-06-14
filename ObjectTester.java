package museumproject2;
import java.util.*;
public class ObjectTester
{
   public static void main (String [] args)
   {
      try
      {
         Date dateM1 = new Date ("03/06/2020 C.E");
         Date dateP1 = new Date ("02/12/2021 C.E.");
         Date dateM2 = new Date ("03/06/2020 B.C.E.");
         Date dateP2 = new Date ("02/12/2021 C.E.");
         Exhibit e1 = new Exhibit ("E1", 1000, "First EXHIBIT");
         Artifact a1 = new Artifact ("A1", 10000, "First ARTIFACT", 20, 20 ,dateM1, dateP1, e1, false);
         Artifact a2 = new Artifact ("A2", 10001, "Second ARTIFACT", 30, 30, dateM2, dateP2, e1, true);
         e1.addArtifact(a1);
         e1.addArtifact (a2);
         System.out.println(e1.toString());
         Date d1 = new Date ("01/01/2020 C.E");
         Date d2 = new Date ("01/01/2019 C.E");
         System.out.println (d2.daysBetween(d1));
         System.out.println (d2.compareTo(d1));
         System.out.println (d1.compareTo(d2));
         Exhibit e = new Exhibit ("ETEST", 1001, "Test for constructor");
         System.out.println(a1.equals(a2));
         Date dm1 = new Date ("03/06/2020 C.E");

         Artifact a = new Artifact ("A1", 10000, "First ARTIFACT", 20, 20, dm1, dateP1, e1, false);
              System.out.println (a1.equals(a));
         System.out.print(dm1.identifierToString());
      }
      catch (InputMismatchException imx)
      {
         System.out.println ("Error with date formatting!");
      }
      catch (IndexOutOfBoundsException ioobx)
      {
         System.out.println ("Error with formatting date");
      }
   }
}