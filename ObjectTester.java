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