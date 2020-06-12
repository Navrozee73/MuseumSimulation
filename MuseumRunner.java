import java.util.*;
import java.io.*;

/*
BASED ON PROTOTYPE
User: Navroze
Date: 10/06/2020
Changes Made:
               - Made start menu
               
               
*/
import java.util.*;

public class MuseumRunner {
    public static void main (String [] args) {
        int input;
        Museum museum = new Museum();
        boolean museumMade = false;
        Scanner sc = new Scanner(System.in);
        System.out.println("WELCOME TO THE MUSEUM SIMULATOR");
        do {
            input = -1;
            System.out.println();
            printStartMenu();
            try {
                System.out.print ("Choose an option: ");
                input = sc.nextInt();
                System.out.println();
                if (input == 1) {
                    museum = makeNewMuseum(sc);
                    if (museum != null)
                      museumMade = true;
                } else if (input == 2) {
                    museum = loadNewMuseum();
                    if (museum != null)
                        museumMade = true;
                } else if (input == 3) {
                    saveMuseum(museum);
                } else if (input == 4) {
                    if (museumMade) {
                        mainMenu(sc, museum);
                    } else {
                        System.out.println("You need to make or load a museum before you can begin the simulation!");
                    }
                }

            } catch (Exception e) {

                System.out.println("Error with input. Try again");
                input = -1;

            }
        } while (input != 0);
    }

    //Prints start menu options
    private static void printStartMenu() {
        System.out.println ("Choose from the below options, or hit 0 to return");
        System.out.println ("1) Make New Museum (WARNING: THIS WILL OVERRIDE ANY PREVIOUSLY SAVED FILES)");
        System.out.println ("2) Load previously stored museum information");
        System.out.println ("3) Save current museum information");
        System.out.println ("4) Begin Simulation");
    }

    //Prints main menu options, takes input, and directs user accordingly
    private static void mainMenu (Scanner sc, Museum museum) {
        int input;

        System.out.println("Main Menu");
        System.out.println("1) Museum Affairs and Analytics");
        System.out.println("2) Update Museum Simulation");
        System.out.println("3) Back to Start Menu");
        //Repeat until proper input is received
        do {
            input = -1;
            try {
                //Get input
                input = sc.nextInt();
                //Direct user according to input
                if (input == 1){
                    museumAnalyticsMenu(sc, museum);
                } else if (input == 2){
                    museumSimulationMenu(sc,museum);
                } else if (input != 3){
                    System.out.println("Invalid Input. Try again.");
                }
            } catch (Exception e) {
                System.out.println("Error reading input. Please try again.");
                input = -1;
            }
        } while (input != 3);
    }

    //Prints Museum Analytics Menu, takes input, and directs user accordingly
    private static void museumAnalyticsMenu (Scanner sc, Museum museum){
        int input = -1;

        System.out.println("Museum Affairs and Analytics");
        System.out.println("1) Museum Information and Statistics");
        System.out.println("2) Museum Facility Analytics");
        System.out.println("3) Museum Finances");
        System.out.println("4) Museum Optimization");
        System.out.println("5) Back to Main Menu");
        //Repeat until proper input is received
        do {
            input = -1;
            try {
                //Get input
                input = sc.nextInt();
                //Direct user accordingly
                if (input == 1) {
                    museumStatsAndInfo(sc, museum);
                } else if (input == 2){
                    museumFacilityAnalytics(sc, museum);
                } else if (input == 3){

                } else if (input == 4){

                } else if (input != 5){
                    System.out.println("Invalid Input. Try again.");
                }

            } catch (Exception e){
                System.out.println("Error reading input. Please try again.");
                input = -1;
            }
        } while (input != 5);
    }

    private static void museumStatsAndInfo (Scanner sc, Museum museum){
        int input = -1;

        System.out.println("Museum Information and Statistics");
        System.out.println("1) Print total display space in museum");
        System.out.println("2) Print total storage space in museum");
        System.out.println("3) Print total number of exhibits in museum");
        System.out.println("4) Print total number of artifacts in museum");
        System.out.println("5) Print current number of visitors in museum");
        System.out.println("6) Print current date");
        System.out.println("7) Print opening date");
        System.out.println("8) Print total days museum has been open");
        System.out.println("9) Back to Museum Affairs");

        do {
            input = -1;
            try {
                input = sc.nextInt();

                if (input == 1){
                    System.out.println("Total display space(m²) - " + museum.getMaxDisplaySpace());
                } else if (input == 2){
                    System.out.println("Total storage space(m²) - " + museum.getMaxStorageSpace());
                } else if (input == 3){
                    System.out.println("Total number of exhibits - " + museum.numTotalExhibits());
                } else if (input == 4){
                    System.out.println("Total number of artifacts - " + museum.numTotalArtifacts());
                } else if (input == 5){
                    System.out.println("Current number of visitors - " + museum.numTotalVisitors());
                } else if (input == 6){
                    System.out.println("Current date - " + (museum.getCurrentDate()).toString());
                } else if (input == 7){
                    System.out.println("Opening date - " + (museum.getOpeningDate()).toString());
                } else if (input == 8){
                    System.out.println("Total days open - " + museum.getDaysOpenCount());
                } else if (input != 9){
                    System.out.println("Invalid Input. Try again.");
                    input = -1;
                }

            } catch (Exception e){
                System.out.println("Error reading input. Try again.");
                input = -1;
            }
        } while (input != 9);
    }

    public static void museumFacilityAnalytics (Scanner sc, Museum museum){
        int input = -1;

        System.out.println("Museum Facility Analytics Menu");
        System.out.println("1) Exhibits");
        System.out.println("2) Artifacts");
        System.out.println("3) Visitors");
        System.out.println("4) Back to Museum Affairs");

        do {
            try{
                input = sc.nextInt();

                if (input == 1){
                    exhibitAnalytics(sc, museum);
                } else if (input == 2){

                } else if (input == 3){

                } else if (input != 4){

                }

            } catch (Exception e){
                System.out.println("Error reading input. Try again.");
                input = -1;
            }
        } while (input != 4);
    }

    private static void exhibitAnalytics (Scanner sc, Museum museum){
        int input = -1;

        System.out.println("Exhibit Analytics");
        System.out.println("1) Print information about exhibits");
        System.out.println("2) Sort exhibits by criteria");
        System.out.println("3) Search exhibits by criteria");
        System.out.println("4) Compare exhibits");
        System.out.println("5) Back to Facility Analytics");

        do {
            try {
                input = sc.nextInt();

                if (input == 1){
                    printExhibitInfo(sc, museum);
                } else if (input == 2){

                } else if (input == 3){

                } else if (input == 4){

                } else if (input != 5){
                    System.out.println("Invalid Input. Try Again.");
                    input = -1;
                }
            } catch (Exception e){
                System.out.println("Error reading input. Try again.");
            }
        } while (input != 5);
    }

    private static void printExhibitInfo (Scanner sc, Museum museum){
        int input = -1;

        System.out.println("Exhibit Information");
        System.out.println("1) Print information on all exhibits");
        System.out.println("2) Print all artifacts within specific exhibit");
        System.out.println("3) Print specific exhibit information");
        System.out.println("4) Print all visitors inside specific exhibit");
        System.out.println("5) Print number of artifacts within specific exhibit");
        System.out.println("6) Print number of visitors currently at specific exhibit");
        System.out.println("7) Back to Exhibit Analysis");

        do {
            try {
                input = sc.nextInt();

                if (input == 1){

                    museum.printAllExhibits();

                } else if (input == 2){

                    int input1 = -1;

                    System.out.println("Options");
                    System.out.println("1) Search by ID");
                    System.out.println("2) Search by name");

                    do {
                        try {
                            input1 = sc.nextInt();
                            if (input1 == 1){
                                boolean properInput = true;
                                System.out.print("ID - ");
                                do {
                                    try {
                                        int id = sc.nextInt();
                                        museum.printAllArtifactsInExhibit(id);
                                    } catch (Exception e) {
                                        System.out.println("Improper Input. Try again.");
                                        properInput = false;
                                    }
                                } while (!properInput);
                            } else if (input1 == 2) {
                                boolean properInput = true;
                                do {
                                    try {
                                        System.out.print("Name - ");
                                        String name = sc.nextLine();
                                        museum.printAllArtifactsInExhibit(name);
                                    } catch (Exception e){
                                        System.out.println("Improper Input. Try again.");
                                        properInput = false;
                                    }
                                } while (!properInput);
                            }
                        } catch (Exception e) {
                            System.out.println("Improper input. Try again.");
                        }
                    } while (input1 != 1 && input1 != 2);

                } else if (input == 3){

                    int input1 = -1;

                    System.out.println("Options");
                    System.out.println("1) Search by ID");
                    System.out.println("2) Search by name");

                    do {
                        try {
                            input1 = sc.nextInt();
                            if (input1 == 1){
                                boolean properInput = true;
                                System.out.print("ID - ");
                                do {
                                    try {
                                        int id = sc.nextInt();
                                        museum.printSpecificExhibit(id);
                                    } catch (Exception e) {
                                        System.out.println("Improper Input. Try again.");
                                        properInput = false;
                                    }
                                } while (!properInput);
                            } else if (input1 == 2) {
                                boolean properInput = true;
                                do {
                                    try {
                                        System.out.print("Name - ");
                                        String name = sc.nextLine();
                                        museum.printSpecificExhibit(name);
                                    } catch (Exception e){
                                        System.out.println("Improper Input. Try again.");
                                        properInput = false;
                                    }
                                } while (!properInput);
                            }
                        } catch (Exception e) {
                            System.out.println("Improper input. Try again.");
                        }
                    } while (input1 != 1 && input1 != 2);

                } else if (input == 4){



                } else if (input == 5){

                } else if (input == 6){

                } else if (input != 7){
                    System.out.println("Invalid Input. Try Again.");
                    input = -1;
                }
            } catch (Exception e){
                System.out.println("Error reading input. Try again.");
            }
        } while (input != 7);

    }

    private static void museumSimulationMenu (Scanner sc, Museum museum){

    }

    private static Museum makeNewMuseum(Scanner sc){
        String stringDate;
        double maxDisplay, maxStorage;
        System.out.print ("Enter opening date (dd/mm/yyyy C.E/B.C.E)  : ");
        sc.nextLine();  // flush
        stringDate = sc.nextLine();
        System.out.print ("Enter Max Display Space: $");
        maxDisplay = sc.nextDouble();
        System.out.print ("Enter Max Storage Space: $");
        maxStorage = sc.nextDouble();
        return (new Museum (stringDate, maxDisplay, maxStorage));
    }

    private static Museum loadNewMuseum () {
        double maxStorage, maxDisplay;
        int numDaysOpen, numExhibits, numArtifacts, numVisitors;

        ArrayList <Date> dates = new ArrayList<Date>();
        ArrayList <Double> dailyRev = new ArrayList<Double>();
        dates.trimToSize();
        dailyRev.trimToSize();
        double lifetimeRev = 0;
        Bank bank;

        ArrayList <Artifact> artifacts = new ArrayList<Artifact>();
        ArrayList <Exhibit> exhibits = new ArrayList<Exhibit>();
        ArrayList <Visitor> visitors = new ArrayList<Visitor>();
        artifacts.trimToSize();
        exhibits.trimToSize();
        visitors.trimToSize();
        
        try
        {
            BufferedReader in = new BufferedReader (new FileReader ("museumSave.txt"));
            Date openDate = new Date (in.readLine());
            Date currDate = new Date(in.readLine());
            maxDisplay = Double.parseDouble(in.readLine());
            maxStorage = Double.parseDouble(in.readLine());
            numDaysOpen = Integer.parseInt(in.readLine());
      
            for (int i = 0; i< numDaysOpen;i++) {
                Date temp = new Date (in.readLine());
                dates.add(temp);
            }
      
            // making bank
            for (int i=0; i < numDaysOpen;i++) {
                dailyRev.add(Double.parseDouble(in.readLine()));
                lifetimeRev += dailyRev.get(i);
            }
      
            bank = new Bank (lifetimeRev, dailyRev, dates, currDate);
      
            // making exhibit
            numExhibits = Integer.parseInt(in.readLine());
            Exhibit lobby = new Exhibit("Lobby", 1000, "Starting area for visitors");
            exhibits.add(lobby);
            for (int i= 0; i < numExhibits;i++) {
                Exhibit temp = new Exhibit (in.readLine(), Integer.parseInt(in.readLine()), in.readLine());
                exhibits.add(temp);
            }
      
            // making artifacts and adding to exhibit
            numArtifacts = Integer.parseInt(in.readLine());
            for (int i=0;i<numArtifacts;i++) {
                Artifact temp = new Artifact(in.readLine(), Integer.parseInt(in.readLine()), in.readLine(), Double.parseDouble(in.readLine()),
                Double.parseDouble(in.readLine()),new Date(in.readLine()), new Date(in.readLine()),findExhibit(exhibits, Integer.parseInt(in.readLine())), Boolean.parseBoolean(in.readLine()));
                artifacts.add(temp);
                temp.getExhibitLocation().addArtifact(temp);
            }
      
            // Making visitors
            numVisitors = Integer.parseInt(in.readLine());
            for (int i=0; i<numVisitors;i++) {
                Visitor tempVisitor;
                ArrayList <Exhibit>prevVisitedExh = new ArrayList<Exhibit>();
                ArrayList <Artifact>prevVisitedArt = new ArrayList<Artifact>();
                prevVisitedExh.trimToSize();
                prevVisitedArt.trimToSize();
                int visId = Integer.parseInt(in.readLine());
                String visFName = in.readLine();
                String visLName = in.readLine();
                int visAge = Integer.parseInt(in.readLine());
                Artifact currArt = findArtifact(artifacts,Integer.parseInt(in.readLine())); //currArt
                Exhibit currExh = currArt.getExhibitLocation(); //use currArt to find currExh
      
                // making prev visited exhibits
                int maxNumExhibits = Integer.parseInt(in.readLine());
                for (int j=0;j<maxNumExhibits;j++){
                    Exhibit temp = findExhibit (exhibits,Integer.parseInt(in.readLine()));
                    prevVisitedExh.add(temp);
                }
      
                // making prev visited artifacts
                int maxNumArtifacts = Integer.parseInt(in.readLine());
                for (int j=0;j<maxNumArtifacts; j++){
                    Artifact temp = findArtifact(artifacts, Integer.parseInt(in.readLine()));
                    prevVisitedArt.add(temp);
                }
                
                if (visAge >= Child.MIN_AGE && visAge <= Child.MAX_AGE)
                {
                   tempVisitor = new Child(visId, visFName, visLName, visAge, currExh, currArt, prevVisitedExh, prevVisitedArt);
                   visitors.add(tempVisitor);
                }
                else if (visAge <= Adult.MAX_AGE)
                {
                   tempVisitor = new Adult(visId, visFName, visLName, visAge, currExh, currArt, prevVisitedExh, prevVisitedArt);
                   visitors.add(tempVisitor);
                }
                else if (visAge >= Senior.MIN_AGE)
                { 
                   tempVisitor = new Senior(visId, visFName, visLName, visAge, currExh, currArt, prevVisitedExh, prevVisitedArt);
                   visitors.add(tempVisitor);
                }   
            }

            return (new Museum(openDate, currDate,maxDisplay, maxStorage, numVisitors, numDaysOpen, exhibits, artifacts, visitors, bank));
        }
        catch (IOException iox)
        {
            System.out.println("Error reading from file. Check if file exists!");
            System.out.println();
            return null;
        }
    }

    public static void saveMuseum (Museum museum)
    {
      try
      {
        BufferedWriter out = new BufferedWriter(new FileWriter("museumSave.txt"));
        // Print
        out.write(museum.getOpeningDate().identifierToString());
        out.newLine();
        out.write(museum.getCurrentDate().identifierToString());
        out.newLine();
        out.write(""+museum.getMaxDisplaySpace());
        out.newLine();
        out.write(""+museum.getMaxStorageSpace());
        out.newLine();
        out.write(museum.getDaysOpenCount());
        out.newLine();

        // Write all Dates open (for bank)
        ArrayList <Date> datesOpen = museum.getBank().getDailyRevenueDates();
        datesOpen.trimToSize();
        for (int i=0;i<museum.getDaysOpenCount();i++)
        {
            out.write(datesOpen.get(i).identifierToString());
            out.newLine();
        }

        //Write all Daily Revenues (for bank)
        ArrayList<Double> revenues = museum.getBank().getDailyRevenue();
        revenues.trimToSize();
        for (int i=0; i < museum.getDaysOpenCount();i++)
        {
            out.write(""+revenues.get(i));
            out.newLine();
        }

        // Write Exhibits Info
        ArrayList <Exhibit> exhibits = museum.getAllExhibits();
        exhibits.trimToSize();
        out.write(exhibits.size());
        out.newLine();
        for (int i=0;i<exhibits.size();i++)
        {
            out.write(exhibits.get(i).getName());
            out.newLine();
            out.write(""+exhibits.get(i).getId());
            out.newLine();
            out.write(exhibits.get(i).getDescription());
            out.newLine();
        }

        //Write Artifacts Info
        ArrayList <Artifact> artifacts = museum.getAllArtifacts();
        artifacts.trimToSize();
        out.write(artifacts.size());
        out.newLine();
        for (int i=0;i<artifacts.size();i++)
        {
            out.write(artifacts.get(i).getName());
            out.newLine();
            out.write(""+artifacts.get(i).getId());
            out.newLine();
            out.write(artifacts.get(i).getDescription());
            out.newLine();
            out.write(artifacts.get(i).getValue()+"");
            out.newLine();
            out.write(artifacts.get(i).getFloorSpace()+"");
            out.newLine();
            out.write(artifacts.get(i).getDateMade().identifierToString());
            out.newLine();
            out.write(artifacts.get(i).getDatePurchased().identifierToString());
            out.newLine();
            out.write(""+artifacts.get(i).getExhibitLocation().getId());
            out.newLine();
            out.write(""+artifacts.get(i).getOnDisplay());
            out.newLine();
        }

        //Write Visitors Info
        ArrayList <Visitor> visitors = museum.getAllVisitors();
        visitors.trimToSize();
        out.write(visitors.size());
        out.newLine();
        for (int i=0;i<visitors.size();i++) {
            ArrayList <Exhibit> visitedExh = visitors.get(i).getVisitedExhibits();
            ArrayList <Artifact> visitedArt = visitors.get(i).getVisitedArtifacts();
            out.write(""+visitors.get(i).getId());
            out.newLine();
            out.write(visitors.get(i).getFirstName());
            out.newLine();
            out.write(visitors.get(i).getLastName());
            out.newLine();
            out.write(""+visitors.get(i).getAge());
            out.newLine();
            out.write(""+visitors.get(i).getCurrentExhibit().getId());
            out.newLine();
            // previously visited artifacts/exhibits
            out.write(""+visitedExh.size());
            out.newLine();
            for (int j=0;i<visitedExh.size();j++) {
                out.write(""+visitedExh.get(j).getId());
                out.newLine();
            }

            out.write(""+visitedArt.size());
            out.newLine();
            for (int j=0;i<visitedArt.size();j++) {
                out.write(""+visitedArt.get(j).getId());
                out.newLine();
            }
        }
      }
      catch (IOException iox)
      {
         System.out.println ("Error reading from file! Returning to start menu.");
      }
    }

    private static Exhibit findExhibit(ArrayList<Exhibit> exhibitList, int exhId){
        exhibitList.trimToSize();
        for (int i=0;i<exhibitList.size();i++) {
            if (exhId == exhibitList.get(i).getId())
                return exhibitList.get(i);
            }
        return null;
    }

    private static Artifact findArtifact(ArrayList<Artifact> artifactList,int artId){
        artifactList.trimToSize();
        for (int i=0;i<artifactList.size();i++) {
            if (artId == artifactList.get(i).getId())
                    return artifactList.get(i);
        }
        return null;
   }
}