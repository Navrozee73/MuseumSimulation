
import java.sql.SQLOutput;
import java.sql.SQLOutput;
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

    public static void main(String[] args) {
        int input;
        Museum museum = new Museum();
        boolean museumMade = false;
        Scanner sc = new Scanner(System.in);

        do {
            input = -1;
            System.out.println("\nStart Menu");
            System.out.println("Choose from the below options, or hit 0 to return");
            System.out.println("1) Make New Museum (WARNING: THIS WILL OVERRIDE ANY PREVIOUSLY SAVED FILES)");
            System.out.println("2) Load previously stored museum information");
            System.out.println("3) Save current museum information");
            System.out.println("4) Begin Simulation");
            try {
                input = sc.nextInt();
                System.out.println();
                if (input == 1) {
                    museum = makeNewMuseum(sc);
                    museumMade = true;
                    System.out.println("Museum has been created!");
                } else if (input == 2) {
                    museum = loadNewMuseum();
                    museumMade = true;
                    System.out.println("Museum loaded successfully!");
                } else if (input == 3) {
                    saveMuseum(museum);
                    System.out.println("Museum saved successfully!");
                } else if (input == 4) {
                    if (museumMade) {
                        mainMenu(sc, museum);
                    } else {
                        System.out.println("Make a museum first!");
                    }
                }

            } catch (Exception e) {

                System.out.println("Error with input. Try again");
                input = -1;

            }
        } while (input != 0);
    }

    // Prints main menu options, takes input, and directs user accordingly
    private static void mainMenu(Scanner sc, Museum museum) {
        int input;

        // Repeat until proper input is received
        do {
            System.out.println("\nMain Menu");
            System.out.println("1) Museum Affairs and Analytics");
            System.out.println("2) Update Museum Simulation");
            System.out.println("3) Back to Start Menu");
            input = -1;
            try {
                // Get input
                input = sc.nextInt();
                // Direct user according to input
                if (input == 1) {
                    museumAnalyticsMenu(sc, museum);
                } else if (input == 2) {
                    museumSimulationMenu(sc, museum);
                } else if (input != 3) {
                    System.out.println("Invalid Input. Try again.");
                }
            } catch (Exception e) {
                System.out.println("Error reading input. Please try again.");
                input = -1;
            }
        } while (input != 3);
    }

    // Prints Museum Analytics Menu, takes input, and directs user accordingly
    private static void museumAnalyticsMenu(Scanner sc, Museum museum) {
        int input = -1;

        // Repeat until proper input is received
        do {
            System.out.println("\nMuseum Affairs and Analytics");
            System.out.println("1) Museum Information and Statistics");
            System.out.println("2) Museum Facility Analytics");
            System.out.println("3) Museum Finances");
            System.out.println("4) Museum Optimization");
            System.out.println("5) Back to Main Menu");
            input = -1;
            try {
                // Get input
                input = sc.nextInt();
                // Direct user accordingly
                if (input == 1) {
                    museumStatsAndInfo(sc, museum);
                } else if (input == 2) {
                    museumFacilityAnalytics(sc, museum);
                } else if (input == 3) {
                    museumFinances(sc, museum);
                } else if (input == 4) {
                    museumOptimization(sc, museum);
                } else if (input != 5) {
                    System.out.println("Invalid Input. Try again.");
                }

            } catch (Exception e) {
                System.out.println("Error reading input. Please try again.");
                input = -1;
            }
        } while (input != 5);
    }

    private static void museumStatsAndInfo(Scanner sc, Museum museum) {
        int input = -1;

        do {
            input = -1;
            System.out.println("\nMuseum Information and Statistics");
            System.out.println("1) Print total display space in museum");
            System.out.println("2) Print total storage space in museum");
            System.out.println("3) Print total number of exhibits in museum");
            System.out.println("4) Print total number of artifacts in museum");
            System.out.println("5) Print current number of visitors in museum");
            System.out.println("6) Print current date");
            System.out.println("7) Print opening date");
            System.out.println("8) Print total days museum has been open");
            System.out.println("9) Back to Museum Affairs");
            try {
                input = sc.nextInt();

                if (input == 1) {
                    System.out.println("Total display space(m²) - " + museum.getMaxDisplaySpace());
                } else if (input == 2) {
                    System.out.println("Total storage space(m²) - " + museum.getMaxStorageSpace());
                } else if (input == 3) {
                    System.out.println("Total number of exhibits - " + museum.numTotalExhibits());
                } else if (input == 4) {
                    System.out.println("Total number of artifacts - " + museum.numTotalArtifacts());
                } else if (input == 5) {
                    System.out.println("Current number of visitors - " + museum.numTotalVisitors());
                } else if (input == 6) {
                    System.out.println("Current date - " + (museum.getCurrentDate()).toString());
                } else if (input == 7) {
                    System.out.println("Opening date - " + (museum.getOpeningDate()).toString());
                } else if (input == 8) {
                    System.out.println("Total days open - " + museum.getDaysOpenCount());
                } else if (input != 9) {
                    System.out.println("Invalid Input. Try again.");
                    input = -1;
                }

            } catch (Exception e) {
                System.out.println("Error reading input. Try again.");
                input = -1;
            }
        } while (input != 9);
    }

    public static void museumFacilityAnalytics(Scanner sc, Museum museum) {
        int input = -1;
        do {
            input = -1;
            System.out.println("\nMuseum Facility Analytics Menu");
            System.out.println("1) Exhibits");
            System.out.println("2) Artifacts");
            System.out.println("3) Visitors");
            System.out.println("4) Back to Museum Affairs");
            try {
                input = sc.nextInt();

                if (input == 1) {
                    exhibitAnalytics(sc, museum);
                } else if (input == 2) {
                    artifactAnalytics(sc, museum);
                } else if (input == 3) {
                    printVisitorInfo(sc, museum);
                } else if (input != 4) {

                }

            } catch (Exception e) {
                System.out.println("Error reading input. Try again.");
                input = -1;
            }
        } while (input != 4);
    }

    private static void museumFinances(Scanner sc, Museum museum) {
        int input = -1;
        do {
            input = -1;
            System.out.println("\nMuseum Finances Menu");
            System.out.println("1) Display total lifetime revenue");
            System.out.println("2) Display daily revenue for a specific date");
            System.out.println("3) Display daily revenue for a range of dates");
            System.out.println("4) Display the average revenue made per day");
            System.out.println("5) Back to Museum Affairs");
            try {
                input = sc.nextInt();
                if (input == 1) {
                    System.out.println("The museum's lifetime revenue is: $" + museum.getBank().getLifetimeRevenue());
                } else if (input == 2) {
                    boolean properInput;
                    do {
                        try {
                            String dateString;
                            Date date;
                            properInput = true;

                            sc.nextLine();
                            System.out.print("Enter a date (dd/mm/yyyy C.E/B.C.E): ");
                            dateString = sc.nextLine();
                            date = new Date(dateString);
                            museum.getBank().printRevenue(date);
                        } catch (Exception e) {
                            System.out.println("Improper input. Please try again.");
                            properInput = false;
                        }
                    } while (!properInput);
                } else if (input == 3) {
                    boolean properInput;
                    do {
                        try {
                            String dateString1, dateString2;
                            Date date1, date2;
                            properInput = true;

                            sc.nextLine();
                            System.out.print("Enter the starting date (dd/mm/yyyy C.E/B.C.E): ");
                            dateString1 = sc.nextLine();
                            System.out.print("Enter the ending date (dd/mm/yyyy C.E/B.C.E): ");
                            dateString2 = sc.nextLine();
                            date1 = new Date(dateString1);
                            date2 = new Date(dateString2);
                            museum.getBank().printRangeRevenue(date1, date2);
                        } catch (Exception e) {
                            System.out.println("Improper input. Please try again.");
                            properInput = false;
                        }
                    } while (!properInput);
                } else if (input == 4) {
                    double averageRevenue = museum.getBank().getLifetimeRevenue() / (double) museum.getDaysOpenCount();
                    System.out.println("The average revenue made per day is: $" + averageRevenue);
                } else if (input != 5) {
                    System.out.println("Invalid input. Please try again.");
                }
            } catch (Exception e) {
                sc.nextLine();
                System.out.println("Improper input. Please try again.");
            }
        } while (input != 5);
    }

    private static void museumOptimization(Scanner sc, Museum museum) {
        int input = -1;
        do {
            input = -1;
            System.out.println("\nMuseum Optimization Menu");
            System.out.println("1) Produce list of exhibits that should be displayed to maximize on-display space");
            System.out.println("2) Produce list of exhibits that should be stored to maximize storage space");
            System.out.println("3) Back to Museum Affairs");
            try {
                input = sc.nextInt();
                if (input == 1) {
                    for(Exhibit e: museum.findOptimalExhibitArrangement(museum.getMaxDisplaySpace())){  //Maximizes the amount of display space used
                        System.out.println(e);
                    }
                } else if (input == 2) {
                    for(Exhibit e: museum.findOptimalExhibitArrangement(museum.getMaxStorageSpace())){  //Maximizes the amount of storage space used
                        System.out.println(e);
                    }
                } else if (input != 3) {
                    System.out.println("Invalid input. Please try again.");
                }
            } catch (Exception e) {
                System.out.println("Improper input. Please try again.");
            }
        } while (input != 3);
    }

    private static void exhibitAnalytics(Scanner sc, Museum museum) {
        int input = -1;
        do {
            input = -1;
            System.out.println("\nExhibit Analytics");
            System.out.println("1) Print information about exhibits");
            System.out.println("2) Sort exhibits by criteria");
            System.out.println("3) Search exhibits by criteria");
            System.out.println("4) Compare exhibits");
            System.out.println("5) Back to Facility Analytics");
            try {
                input = sc.nextInt();
                sc.nextLine();

                if (input == 1) {
                    printExhibitInfo(sc, museum);
                } else if (input == 2) {
                    sortExhibits(sc, museum);
                } else if (input == 3) {
                    searchExhibits(sc, museum);
                } else if (input == 4) {
                    compareExhibits(sc, museum);
                } else if (input != 5) {
                    System.out.println("Invalid Input. Try Again.");
                    input = -1;
                }
            } catch (Exception e) {
                System.out.println("Error reading input. Try again.");
            }
        } while (input != 5);
    }

    private static void printExhibitInfo(Scanner sc, Museum museum) {
        int input = -1;

        do {
            input = -1;
            System.out.println("\nExhibit Information");
            System.out.println("1) Print information on all exhibits");
            System.out.println("2) Print all artifacts within specific exhibit");
            System.out.println("3) Print specific exhibit information");
            System.out.println("4) Print all visitors inside specific exhibit");
            System.out.println("5) Print number of artifacts within specific exhibit");
            System.out.println("6) Print number of visitors currently at specific exhibit");
            System.out.println("7) Back to Exhibit Analysis");
            try {
                input = sc.nextInt();
                sc.nextLine();

                if (input == 1) {

                    museum.printAllExhibits();

                } else if (input == 2) {

                    int input1 = -1;

                    do {
                        input1 = -1;
                        System.out.println("\nOptions");
                        System.out.println("1) Search by ID");
                        System.out.println("2) Search by name");
                        try {
                            input1 = sc.nextInt();
                            sc.nextLine();
                            if (input1 == 1) {
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
                                    } catch (Exception e) {
                                        System.out.println("Improper Input. Try again.");
                                        properInput = false;
                                    }
                                } while (!properInput);
                            }
                        } catch (Exception e) {
                            System.out.println("Improper input. Try again.");
                        }
                    } while (input1 != 1 && input1 != 2);

                } else if (input == 3) {

                    int input1 = -1;
                    do {
                        input1 = -1;
                        System.out.println("\nOptions");
                        System.out.println("1) Search by ID");
                        System.out.println("2) Search by name");
                        try {
                            input1 = sc.nextInt();
                            if (input1 == 1) {
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
                                    } catch (Exception e) {
                                        System.out.println("Improper Input. Try again.");
                                        properInput = false;
                                    }
                                } while (!properInput);
                            }
                        } catch (Exception e) {
                            System.out.println("Improper input. Try again.");
                        }
                    } while (input1 != 1 && input1 != 2);

                } else if (input == 4) {

                    int input1 = -1;

                    do {
                        input1 = -1;
                        System.out.println("\nOptions");
                        System.out.println("1) Search by ID");
                        System.out.println("2) Search by name");
                        try {
                            input1 = sc.nextInt();

                            if (input1 == 1) {
                                boolean properInput = true;
                                System.out.print("ID - ");
                                do {
                                    try {
                                        int id = sc.nextInt();
                                        museum.printAllVisitorsInExhibit(id);
                                    } catch (Exception e) {
                                        System.out.println("Improper Input. Try again.");
                                        properInput = false;
                                    }
                                } while (!properInput);
                            } else if (input1 == 2) {
                                boolean properInput = true;
                                System.out.print("Name - ");
                                do {
                                    try {
                                        String name = sc.nextLine();
                                        museum.printAllVisitorsInExhibit(name);
                                    } catch (Exception e) {
                                        System.out.println("Improper Input. Try again.");
                                        properInput = false;
                                    }
                                } while (!properInput);
                            }
                        } catch (Exception e) {
                            System.out.println("Error reading input. Try again.");
                        }
                    } while (input1 != 1 && input1 != 2);

                } else if (input == 5) {

                    int input1 = -1;

                    do {
                        input1 = -1;
                        System.out.println("\nOptions");
                        System.out.println("1) Search by ID");
                        System.out.println("2) Search by name");
                        try {
                            input1 = sc.nextInt();

                            if (input1 == 1) {
                                boolean properInput = true;
                                System.out.print("ID - ");
                                do {
                                    try {
                                        int id = sc.nextInt();
                                        int numArtifacts = museum.numArtifactsInExhibit(id);
                                        System.out.println("Number of artifacts - " + numArtifacts);
                                    } catch (Exception e) {
                                        System.out.println("Improper Input. Try again.");
                                        properInput = false;
                                    }
                                } while (!properInput);
                            } else if (input1 == 2) {
                                boolean properInput = true;
                                System.out.print("Name - ");
                                do {
                                    try {
                                        String name = sc.nextLine();
                                        int numArtifacts = museum.numArtifactsInExhibit(name);
                                        System.out.println("Number of artifacts - " + numArtifacts);
                                    } catch (Exception e) {
                                        System.out.println("Improper Input. Try again.");
                                        properInput = false;
                                    }
                                } while (!properInput);
                            }
                        } catch (Exception e) {
                            System.out.println("Error reading input. Try again.");
                        }
                    } while (input1 != 1 && input1 != 2);

                } else if (input == 6) {

                    int input1 = -1;

                    do {
                        input1 = -1;
                        System.out.println("\nOptions");
                        System.out.println("1) Search by ID");
                        System.out.println("2) Search by name");
                        try {
                            input1 = sc.nextInt();

                            if (input1 == 1) {
                                boolean properInput = true;
                                System.out.print("ID - ");
                                do {
                                    try {
                                        int id = sc.nextInt();
                                        int numVisitors = museum.numVisitorsInExhibit(id);
                                        System.out.println("Number of artifacts - " + numVisitors);
                                    } catch (Exception e) {
                                        System.out.println("Improper Input. Try again.");
                                        properInput = false;
                                    }
                                } while (!properInput);
                            } else if (input1 == 2) {
                                boolean properInput = true;
                                System.out.print("Name - ");
                                do {
                                    try {
                                        String name = sc.nextLine();
                                        int numVisitors = museum.numVisitorsInExhibit(name);
                                        System.out.println("Number of artifacts - " + numVisitors);
                                    } catch (Exception e) {
                                        System.out.println("Improper Input. Try again.");
                                        properInput = false;
                                    }
                                } while (!properInput);
                            }
                        } catch (Exception e) {
                            System.out.println("Error reading input. Try again.");
                        }
                    } while (input1 != 1 && input1 != 2);

                } else if (input != 7) {
                    System.out.println("Invalid Input. Try Again.");
                    input = -1;
                }

            } catch (Exception e) {
                System.out.println("Error reading input. Try again.");
            }

        } while (input != 7);
    }

    private static void sortExhibits(Scanner sc, Museum museum) {
        int input = -1;

        do {
            input = -1;
            System.out.println("\nSort Exhibits");
            System.out.println("1) Display all exhibits currently on floor");
            System.out.println("2) Display all exhibits currently in storage");
            System.out.println("3) Display all exhibits, sorted by ascending value");
            System.out.println("4) Display all exhibits, sorted by descending value");
            System.out.println("5) Display all exhibits sorted by ascending required floor space");
            System.out.println("6) Display all exhibits sorted by descending required floor space");
            System.out.println("7) Display all exhibits, sorted by ascending number of current visitors");
            System.out.println("8) Display all exhibits, sorted by descending number of current visitors");
            System.out.println("9) Display all exhibits in alphabetical order");
            System.out.println("10) Display all exhibits in reverse alphabetical order");
            System.out.println("11) Back to Exhibit Analytics");
            try {
                input = sc.nextInt();

                if (input == 1) {
                    museum.printExhibitsCurrentlyOnFloor();
                } else if (input == 2) {
                    museum.printExhibitsInStorage();
                } else if (input == 3) {
                    museum.printExhibitsAscendingValue();
                } else if (input == 4) {
                    museum.printExhibitsDescendingValue();
                } else if (input == 5) {
                    museum.printExhibitsAscendingFloorSpace();
                } else if (input == 6) {
                    museum.printExhibitsDescendingFloorSpace();
                } else if (input == 7) {
                    museum.printExhibitsAscendingNumVisitors();
                } else if (input == 8) {
                    museum.printExhibitsDescendingNumVisitors();
                } else if (input == 9) {
                    museum.printExhibitAlpha();
                } else if (input == 10) {
                    museum.printExhibitsReverseAlpha();
                } else if (input != 11) {
                    System.out.println("Invalid Input. Try Again.");
                    input = -1;
                }
            } catch (Exception e) {
                System.out.println("Error reading input. Try again.");
            }
        } while (input != 11);
    }

    private static void searchExhibits(Scanner sc, Museum museum) {
        int input = -1;

        do {
            input = -1;
            System.out.println("\nSearch Exhibits");
            System.out.println("1) Search by ID");
            System.out.println("2) Search by name");
            System.out.println("3) Print exhibits exceeding certain value");
            System.out.println("4) Print exhibits within range of values");
            System.out.println("5) Print exhibits exceeding certain number of visitors");
            System.out.println("6) Print exhibits within a range of current visitors");
            System.out.println("7) Print exhibits that fit within a specified floor space");
            System.out.println("8) Print exhibits that fit within a range of floor space");
            System.out.println("9) Back to Exhibit Analytics");
            try {
                input = sc.nextInt();

                if (input == 1) {
                    int id;
                    boolean properInput = true;

                    System.out.print("ID - ");

                    do {
                        try {
                            id = sc.nextInt();
                            System.out.println((museum.searchExhibitById(id)).identifierToString());
                        } catch (Exception e) {
                            System.out.println("Error reading input. Try again.");
                            properInput = false;
                        }
                    } while (!properInput);

                } else if (input == 2) {
                    String name;
                    boolean properInput = true;

                    System.out.print("Name - ");

                    do {
                        try {
                            name = sc.nextLine();
                            System.out.println((museum.searchExhibitByName(name)).identifierToString());
                        } catch (Exception e) {
                            System.out.println("Error reading input. Try again.");
                            properInput = false;
                        }
                    } while (!properInput);

                } else if (input == 3) {
                    int value;
                    boolean properInput = true;

                    System.out.print("Value - ");

                    do {
                        try {
                            value = sc.nextInt();
                            museum.printExhibitsExceedingValue(value);
                        } catch (Exception e) {
                            System.out.println("Error reading input. Try again.");
                            properInput = false;
                        }
                    } while (!properInput);

                } else if (input == 4) {
                    int value1;
                    int value2;
                    boolean properInput = true;

                    System.out.println("Lower Value - ");

                    do {
                        try {
                            value1 = sc.nextInt();
                            System.out.println("Higher Value - ");
                            value2 = sc.nextInt();
                            museum.printExhibitsWithinValue(value1, value2);
                        } catch (Exception e) {
                            System.out.println("Error reading input. Try again.");
                            properInput = false;
                        }
                    } while (!properInput);

                } else if (input == 5) {
                    int numVisitors;
                    boolean properInput = true;

                    System.out.println("Num of visitors - ");

                    do {
                        try {
                            numVisitors = sc.nextInt();
                            museum.printExhibitsExceedingNumVisitors(numVisitors);
                        } catch (Exception e) {
                            System.out.println("Error reading input. Try again.");
                            properInput = false;
                        }
                    } while (!properInput);

                } else if (input == 6) {
                    int numVisitors1;
                    int numVisitors2;
                    boolean properInput = true;

                    System.out.println("Lower visitor limit - ");

                    do {
                        try {
                            numVisitors1 = sc.nextInt();
                            System.out.println("Higher visitor limit - ");
                            numVisitors2 = sc.nextInt();
                            museum.printExhibitsWithinNumVisitors(numVisitors1, numVisitors2);
                        } catch (Exception e) {
                            System.out.println("Error reading input. Try again.");
                            properInput = false;
                        }
                    } while (!properInput);

                } else if (input == 7) {
                    int maxFloorSpace;
                    boolean properInput = true;

                    System.out.println("Max Floor Space - ");

                    do {
                        try {
                            maxFloorSpace = sc.nextInt();
                            museum.printExhibitsLessThanFloorSpace(maxFloorSpace);
                        } catch (Exception e) {
                            System.out.println("Error reading input. Try again.");
                            properInput = false;
                        }
                    } while (!properInput);

                } else if (input == 8) {
                    int minFloorSpace;
                    int maxFloorSpace;
                    boolean properInput = true;

                    System.out.println("Max Floor Space - ");

                    do {
                        try {
                            maxFloorSpace = sc.nextInt();
                            System.out.println("Minimum Floor Space - ");
                            minFloorSpace = sc.nextInt();
                            museum.printExhibitsWithinFloorSpace(minFloorSpace, maxFloorSpace);
                        } catch (Exception e) {
                            System.out.println("Error reading input. Try again.");
                            properInput = false;
                        }
                    } while (!properInput);

                } else if (input != 9) {
                    System.out.println("Invalid input. Try again.");
                    input = -1;
                }
            } catch (Exception e) {
                System.out.println("Error reading input. Please try again.");
            }
        } while (input != 9);
    }

    private static void compareExhibits(Scanner sc, Museum museum) {
        int input = -1;

        do {
            input = -1;
            System.out.println("\nCompare Exhibits");
            System.out.println("1) Compare values between exhibits");
            System.out.println("2) Compare number of visitors between exhibits");
            System.out.println("3) Compare required floor space between exhibits");
            System.out.println("4) Compare number of artifacts between exhibits");
            System.out.println("5) Back to Exhibit Analytics");
            try {
                input = sc.nextInt();

                if (input == 1) {

                    int input1 = -1;

                    System.out.println("\nOptions");
                    System.out.println("1) Search by ID");
                    System.out.println("2) Search by name");

                    do {
                        try {
                            input1 = sc.nextInt();
                            if (input1 == 1) {
                                boolean properInput = true;
                                System.out.print("ID #1 - ");
                                do {
                                    try {
                                        int id1 = sc.nextInt();
                                        System.out.println("ID #2 - ");
                                        int id2 = sc.nextInt();
                                        System.out.println(
                                                (museum.greaterValueBetweenExhibits(id1, id2)).identifierToString());
                                    } catch (Exception e) {
                                        System.out.println("Improper Input. Try again.");
                                        properInput = false;
                                    }
                                } while (!properInput);
                            } else if (input1 == 2) {
                                boolean properInput = true;
                                do {
                                    try {
                                        System.out.print("Name #1 - ");
                                        String name1 = sc.nextLine();
                                        System.out.println("Name #2 - ");
                                        String name2 = sc.nextLine();
                                        System.out.println((museum.greaterValueBetweenExhibits(name1, name2))
                                                .identifierToString());
                                    } catch (Exception e) {
                                        System.out.println("Improper Input. Try again.");
                                        properInput = false;
                                    }
                                } while (!properInput);
                            }
                        } catch (Exception e) {
                            System.out.println("Improper input. Try again.");
                        }
                    } while (input1 != 1 && input1 != 2);

                } else if (input == 2) {

                    int input1 = -1;

                    do {
                        input1 = -1;
                        System.out.println("\nOptions");
                        System.out.println("1) Search by ID");
                        System.out.println("2) Search by name");
                        try {
                            input1 = sc.nextInt();
                            if (input1 == 1) {
                                boolean properInput = true;
                                System.out.print("ID #1 - ");
                                do {
                                    try {
                                        int id1 = sc.nextInt();
                                        System.out.println("ID #2 - ");
                                        int id2 = sc.nextInt();
                                        System.out.println((museum.greaterNumVisitorsBetweenExhibits(id1, id2))
                                                .identifierToString());
                                    } catch (Exception e) {
                                        System.out.println("Improper Input. Try again.");
                                        properInput = false;
                                    }
                                } while (!properInput);
                            } else if (input1 == 2) {
                                boolean properInput = true;
                                do {
                                    try {
                                        System.out.print("Name #1 - ");
                                        String name1 = sc.nextLine();
                                        System.out.println("Name #2 - ");
                                        String name2 = sc.nextLine();
                                        System.out.println((museum.greaterNumVisitorsBetweenExhibits(name1, name2))
                                                .identifierToString());
                                    } catch (Exception e) {
                                        System.out.println("Improper Input. Try again.");
                                        properInput = false;
                                    }
                                } while (!properInput);
                            }
                        } catch (Exception e) {
                            System.out.println("Improper input. Try again.");
                        }
                    } while (input1 != 1 && input1 != 2);

                } else if (input == 3) {

                    int input1 = -1;

                    do {
                        input1 = -1;
                        System.out.println("\nOptions");
                        System.out.println("1) Search by ID");
                        System.out.println("2) Search by name");
                        try {
                            input1 = sc.nextInt();
                            if (input1 == 1) {
                                boolean properInput = true;
                                System.out.print("ID #1 - ");
                                do {
                                    try {
                                        int id1 = sc.nextInt();
                                        System.out.println("ID #2 - ");
                                        int id2 = sc.nextInt();
                                        System.out.println((museum.greaterFloorSpaceBetweenExhibits(id1, id2))
                                                .identifierToString());
                                    } catch (Exception e) {
                                        System.out.println("Improper Input. Try again.");
                                        properInput = false;
                                    }
                                } while (!properInput);
                            } else if (input1 == 2) {
                                boolean properInput = true;
                                do {
                                    try {
                                        System.out.print("Name #1 - ");
                                        String name1 = sc.nextLine();
                                        System.out.println("Name #2 - ");
                                        String name2 = sc.nextLine();
                                        System.out.println((museum.greaterFloorSpaceBetweenExhibits(name1, name2))
                                                .identifierToString());
                                    } catch (Exception e) {
                                        System.out.println("Improper Input. Try again.");
                                        properInput = false;
                                    }
                                } while (!properInput);
                            }
                        } catch (Exception e) {
                            System.out.println("Improper input. Try again.");
                        }
                    } while (input1 != 1 && input1 != 2);

                } else if (input == 4) {

                    int input1 = -1;

                    do {
                        input1 = -1;
                        System.out.println("\nOptions");
                        System.out.println("1) Search by ID");
                        System.out.println("2) Search by name");
                        try {
                            input1 = sc.nextInt();
                            if (input1 == 1) {
                                boolean properInput = true;
                                System.out.print("ID #1 - ");
                                do {
                                    try {
                                        int id1 = sc.nextInt();
                                        System.out.println("ID #2 - ");
                                        int id2 = sc.nextInt();
                                        System.out.println((museum.greaterNumArtifactsBetweenExhibits(id1, id2))
                                                .identifierToString());
                                    } catch (Exception e) {
                                        System.out.println("Improper Input. Try again.");
                                        properInput = false;
                                    }
                                } while (!properInput);
                            } else if (input1 == 2) {
                                boolean properInput = true;
                                do {
                                    try {
                                        System.out.print("Name #1 - ");
                                        String name1 = sc.nextLine();
                                        System.out.println("Name #2 - ");
                                        String name2 = sc.nextLine();
                                        System.out.println((museum.greaterNumArtifactsBetweenExhibits(name1, name2))
                                                .identifierToString());
                                    } catch (Exception e) {
                                        System.out.println("Improper Input. Try again.");
                                        properInput = false;
                                    }
                                } while (!properInput);
                            }
                        } catch (Exception e) {
                            System.out.println("Improper input. Try again.");
                        }
                    } while (input1 != 1 && input1 != 2);

                } else if (input != 5) {
                    System.out.println("Invalid input. Try again.");
                }
            } catch (Exception e) {
                System.out.println("Error reading input. Try again.");
                input = -1;
            }
        } while (input != 5);

    }

    private static void artifactAnalytics(Scanner sc, Museum museum) {
        int input = -1;

        do {
            input = -1;
            System.out.println("\nArtifact Analytics");
            System.out.println("1) Print information about artifacts");
            System.out.println("2) Sort artifacts by criteria");
            System.out.println("3) Search artifacts by criteria");
            System.out.println("4) Compare artifacts");
            System.out.println("5) Back to Facility Analytics");
            try {
                input = sc.nextInt();

                if (input == 1) {
                    printArtifactInfo(sc, museum);
                } else if (input == 2) {
                    sortArtifacts(sc, museum);
                } else if (input == 3) {
                    searchArtifacts(sc, museum);
                } else if (input == 4) {
                    compareArtifacts(sc, museum);
                } else if (input != 5) {
                    System.out.println("Invalid Input. Try Again.");
                    input = -1;
                }
            } catch (Exception e) {
                System.out.println("Error reading input. Try again.");
            }
        } while (input != 5);
    }

    private static void printArtifactInfo(Scanner sc, Museum museum) {
        int input = -1;

        do {
            input = -1;
            System.out.println("\nArtifact Information");
            System.out.println("1) Print information on all artifacts");
            System.out.println("2) Print specific artifact information");
            System.out.println("3) Print all visitors at specific artifact");
            System.out.println("4) Print number of visitors currently at specific artifact");
            System.out.println("5) Back to Exhibit Analysis");
            try {
                input = sc.nextInt();

                if (input == 1) {

                    museum.printAllArtifacts();
                    //"2) Print specific artifact information"
                } else if (input == 2) {

                    int input1 = -1;

                    do {
                        input1 = -1;
                        System.out.println("\nOptions");
                        System.out.println("1) Search by ID");
                        System.out.println("2) Search by name");
                        try {
                            input1 = sc.nextInt();
                            if (input1 == 1) {
                                boolean properInput = true;
                                System.out.print("ID - ");
                                do {
                                    try {
                                        int id = sc.nextInt();
                                        museum.printSpecificArtifact(id);
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
                                    } catch (Exception e) {
                                        System.out.println("Improper Input. Try again.");
                                        properInput = false;
                                    }
                                } while (!properInput);
                            }
                        } catch (Exception e) {
                            System.out.println("Improper input. Try again.");
                        }
                    } while (input1 != 1 && input1 != 2);
                    //"3) Print all visitors at specific artifact"
                } else if (input == 3) {

                    int input1 = -1;

                    do {
                        input1 = -1;
                        System.out.println("\nOptions");
                        System.out.println("1) Search by ID");
                        System.out.println("2) Search by name");
                        try {
                            input1 = sc.nextInt();

                            if (input1 == 1) {
                                boolean properInput = true;
                                System.out.print("ID - ");
                                do {
                                    try {
                                        int id = sc.nextInt();
                                        museum.printAllVisitorsAtArtifact(id);
                                    } catch (Exception e) {
                                        System.out.println("Improper Input. Try again.");
                                        properInput = false;
                                    }
                                } while (!properInput);
                            } else if (input1 == 2) {
                                boolean properInput = true;
                                System.out.print("Name - ");
                                do {
                                    try {
                                        String name = sc.nextLine();
                                        museum.printAllVisitorsAtArtifact(name);
                                    } catch (Exception e) {
                                        System.out.println("Improper Input. Try again.");
                                        properInput = false;
                                    }
                                } while (!properInput);
                            }
                        } catch (Exception e) {
                            System.out.println("Error reading input. Try again.");
                        }
                    } while (input1 != 1 && input1 != 2);
                    //"4) Print number of visitors currently at specific artifact"
                } else if (input == 4) {

                    int input1 = -1;

                    do {
                        input1 = -1;
                        System.out.println("\nOptions");
                        System.out.println("1) Search by ID");
                        System.out.println("2) Search by name");
                        try {
                            input1 = sc.nextInt();

                            if (input1 == 1) {
                                boolean properInput = true;
                                System.out.print("ID - ");
                                do {
                                    try {
                                        int id = sc.nextInt();
                                        int numArtifacts = museum.numVisitorsAtArtifact(id);
                                        System.out.println("Number of artifacts - " + numArtifacts);
                                    } catch (Exception e) {
                                        System.out.println("Improper Input. Try again.");
                                        properInput = false;
                                    }
                                } while (!properInput);
                            } else if (input1 == 2) {
                                boolean properInput = true;
                                System.out.print("Name - ");
                                do {
                                    try {
                                        String name = sc.nextLine();
                                        int numArtifacts = museum.numVisitorsAtArtifact(name);
                                        System.out.println("Number of artifacts - " + numArtifacts);
                                    } catch (Exception e) {
                                        System.out.println("Improper Input. Try again.");
                                        properInput = false;
                                    }
                                } while (!properInput);
                            }
                        } catch (Exception e) {
                            System.out.println("Error reading input. Try again.");
                        }
                    } while (input1 != 1 && input1 != 2);

                } else if (input != 5) {
                    System.out.println("Invalid Input. Try Again.");
                    input = -1;
                }

            } catch (Exception e) {
                System.out.println("Error reading input. Try again.");
            }

        } while (input != 5);

    }

    private static void sortArtifacts(Scanner sc, Museum museum) {
        int input = -1;

        do {
            input = -1;
            System.out.println("\nSort Artifacts");
            System.out.println("1) Display all artifacts currently on floor");
            System.out.println("2) Display all artifacts currently in storage");
            System.out.println("3) Display all artifacts, sorted by ascending value");
            System.out.println("4) Display all artifacts, sorted by descending value");
            System.out.println("5) Display all artifacts sorted by ascending required floor space");
            System.out.println("6) Display all artifacts sorted by descending required floor space");
            System.out.println("7) Display all artifacts, sorted by ascending number of current visitors");
            System.out.println("8) Display all artifacts, sorted by descending number of current visitors");
            System.out.println("9) Display all artifacts in alphabetical order");
            System.out.println("10) Display all artifacts in reverse alphabetical order");
            System.out.println("11) Back to Artifact Analytics");
            try {
                input = sc.nextInt();

                if (input == 1) {
                    museum.printArtifactsCurrentlyOnFloor();
                } else if (input == 2) {
                    museum.printArtifactsInStorage();
                } else if (input == 3) {
                    museum.printArtifactsAscendingValue();
                } else if (input == 4) {
                    museum.printArtifactsDescendingValue();
                } else if (input == 5) {
                    museum.printArtifactsAscendingFloorSpace();
                } else if (input == 6) {
                    museum.printArtifactsDescendingFloorSpace();
                } else if (input == 7) {
                    museum.printArtifactsAscendingVisitors();
                } else if (input == 8) {
                    museum.printArtifactsDescendingVisitors();
                } else if (input == 9) {
                    museum.printArtifactsAlpha();
                } else if (input == 10) {
                    museum.printArtifactsReverseAlpha();
                } else if (input != 11) {
                    System.out.println("Invalid Input. Try Again.");
                    input = -1;
                }
            } catch (Exception e) {
                System.out.println("Error reading input. Try again.");
            }
        } while (input != 11);
    }

    private static void searchArtifacts(Scanner sc, Museum museum) {
        int input = -1;
        do {
            input = -1;
            System.out.println("\nSearch Artifacts");
            System.out.println("1) Search by ID");
            System.out.println("2) Search by name");
            System.out.println("3) Print artifacts exceeding certain value");
            System.out.println("4) Print artifacts within range of values");
            System.out.println("5) Print artifacts exceeding certain number of visitors");
            System.out.println("6) Print artifacts within a range of current visitors");
            System.out.println("7) Print artifacts that fit within a specified floor space");
            System.out.println("8) Print artifacts that fit within a range of floor space");
            System.out.println("9) Back to Artifact Analytics");

            try {
                input = sc.nextInt();

                if (input == 1) {
                    int id;
                    boolean properInput = true;

                    System.out.print("ID - ");

                    do {
                        try {
                            id = sc.nextInt();
                            System.out.println((museum.searchArtifactByID(id)).identifierToString());
                        } catch (Exception e) {
                            System.out.println("Error reading input. Try again.");
                            properInput = false;
                        }
                    } while (!properInput);

                } else if (input == 2) {
                    String name;
                    boolean properInput = true;

                    System.out.print("Name - ");

                    do {
                        try {
                            name = sc.nextLine();
                            System.out.println((museum.searchArtifactByName(name)).identifierToString());
                        } catch (Exception e) {
                            System.out.println("Error reading input. Try again.");
                            properInput = false;
                        }
                    } while (!properInput);

                } else if (input == 3) {
                    int value;
                    boolean properInput = true;

                    System.out.print("Value - ");

                    do {
                        try {
                            value = sc.nextInt();
                            museum.printArtifactsExceedingValue(value);
                        } catch (Exception e) {
                            System.out.println("Error reading input. Try again.");
                            properInput = false;
                        }
                    } while (!properInput);

                } else if (input == 4) {
                    int value1;
                    int value2;
                    boolean properInput = true;

                    System.out.println("Lower Value - ");

                    do {
                        try {
                            value1 = sc.nextInt();
                            System.out.println("Higher Value - ");
                            value2 = sc.nextInt();
                            museum.printArtifactsWithinValue(value1, value2);
                        } catch (Exception e) {
                            System.out.println("Error reading input. Try again.");
                            properInput = false;
                        }
                    } while (!properInput);

                } else if (input == 5) {
                    int numVisitors;
                    boolean properInput = true;

                    System.out.println("Num of visitors - ");

                    do {
                        try {
                            numVisitors = sc.nextInt();
                            museum.printArtifactsExceedingNumVisitors(numVisitors);
                        } catch (Exception e) {
                            System.out.println("Error reading input. Try again.");
                            properInput = false;
                        }
                    } while (!properInput);

                } else if (input == 6) {
                    int numVisitors1;
                    int numVisitors2;
                    boolean properInput = true;

                    System.out.println("Lower visitor limit - ");

                    do {
                        try {
                            numVisitors1 = sc.nextInt();
                            System.out.println("Higher visitor limit - ");
                            numVisitors2 = sc.nextInt();
                            museum.printArtifactsWithinNumVisitors(numVisitors1, numVisitors2);
                        } catch (Exception e) {
                            System.out.println("Error reading input. Try again.");
                            properInput = false;
                        }
                    } while (!properInput);

                } else if (input == 7) {
                    int maxFloorSpace;
                    boolean properInput = true;

                    System.out.println("Max Floor Space - ");

                    do {
                        try {
                            maxFloorSpace = sc.nextInt();
                            museum.printArtifactsLessThanFloorSpace(maxFloorSpace);
                        } catch (Exception e) {
                            System.out.println("Error reading input. Try again.");
                            properInput = false;
                        }
                    } while (!properInput);

                } else if (input == 8) {
                    int minFloorSpace;
                    int maxFloorSpace;
                    boolean properInput = true;

                    System.out.println("Max Floor Space - ");

                    do {
                        try {
                            maxFloorSpace = sc.nextInt();
                            System.out.println("Minimum Floor Space - ");
                            minFloorSpace = sc.nextInt();
                            museum.printExhibitsWithinFloorSpace(minFloorSpace, maxFloorSpace);
                        } catch (Exception e) {
                            System.out.println("Error reading input. Try again.");
                            properInput = false;
                        }
                    } while (!properInput);

                } else if (input != 9) {
                    System.out.println("Invalid input. Try again.");
                    input = -1;
                }
            } catch (Exception e) {
                System.out.println("Error reading input. Please try again.");
            }
        } while (input != 9);
    }
    
    private static void compareArtifacts(Scanner sc, Museum museum) {
        int input = -1;

        do {
            input = -1;
            System.out.println("\nCompare Artifacts");
            System.out.println("1) Compare values between artifacts");
            System.out.println("2) Compare number of visitors between artifacts");
            System.out.println("3) Compare required floor space between artifacts");
            System.out.println("4) Back to Artifact Analytics");
            try {
                input = sc.nextInt();

                if (input == 1) { // Compare values between artifacts

                    int input1 = -1;

                    do {
                        input1 = -1;
                        System.out.println("\nOptions");
                        System.out.println("1) Search by ID");
                        System.out.println("2) Search by name");
                        try {
                            input1 = sc.nextInt();
                            if (input1 == 1) {  
                                boolean properInput = true;
                                System.out.print("ID #1 - ");
                                do {
                                    try {
                                        int id1 = sc.nextInt();
                                        System.out.println("ID #2 - ");
                                        int id2 = sc.nextInt();
                                        System.out.println(
                                                (museum.greaterValueBetweenArtifacts(id1, id2)).identifierToString());
                                    } catch (Exception e) {
                                        System.out.println("Improper Input. Try again.");
                                        properInput = false;
                                    }
                                } while (!properInput);
                            } else if (input1 == 2) {   
                                boolean properInput = true;
                                do {
                                    try {
                                        System.out.print("Name #1 - ");
                                        String name1 = sc.nextLine();
                                        System.out.println("Name #2 - ");
                                        String name2 = sc.nextLine();
                                        System.out.println((museum.greaterValueBetweenArtifacts(name1, name2))
                                                .identifierToString());
                                    } catch (Exception e) {
                                        System.out.println("Improper Input. Try again.");
                                        properInput = false;
                                    }
                                } while (!properInput);
                            }
                        } catch (Exception e) {
                            System.out.println("Improper input. Try again.");
                        }
                    } while (input1 != 1 && input1 != 2);

                } else if (input == 2) {    //Compare number of visitors between artifacts

                    int input1 = -1;

                    do {
                        input1 = -1;
                        System.out.println("\nOptions");
                        System.out.println("1) Search by ID");
                        System.out.println("2) Search by name");
                        try {
                            input1 = sc.nextInt();
                            if (input1 == 1) {
                                boolean properInput = true;
                                System.out.print("ID #1 - ");
                                do {
                                    try {
                                        int id1 = sc.nextInt();
                                        System.out.println("ID #2 - ");
                                        int id2 = sc.nextInt();
                                        System.out.println((museum.greaterNumVisitorsBetweenArtifacts(id1, id2))
                                                .identifierToString());
                                    } catch (Exception e) {
                                        System.out.println("Improper Input. Try again.");
                                        properInput = false;
                                    }
                                } while (!properInput);
                            } else if (input1 == 2) {
                                boolean properInput = true;
                                do {
                                    try {
                                        System.out.print("Name #1 - ");
                                        String name1 = sc.nextLine();
                                        System.out.println("Name #2 - ");
                                        String name2 = sc.nextLine();
                                        System.out.println((museum.greaterNumVisitorsBetweenArtifacts(name1, name2))
                                                .identifierToString());
                                    } catch (Exception e) {
                                        System.out.println("Improper Input. Try again.");
                                        properInput = false;
                                    }
                                } while (!properInput);
                            }
                        } catch (Exception e) {
                            System.out.println("Improper input. Try again.");
                        }
                    } while (input1 != 1 && input1 != 2);

                } else if (input == 3) { //Compare required floor space between artifacts

                    int input1 = -1;

                    do {
                        input1 = -1;
                        System.out.println("\nOptions");
                        System.out.println("1) Search by ID");
                        System.out.println("2) Search by name");
                        try {
                            input1 = sc.nextInt();
                            if (input1 == 1) {
                                boolean properInput = true;
                                System.out.print("ID #1 - ");
                                do {
                                    try {
                                        int id1 = sc.nextInt();
                                        System.out.println("ID #2 - ");
                                        int id2 = sc.nextInt();
                                        System.out.println((museum.greaterFloorSpaceBetweenArtifacts(id1, id2))
                                                .identifierToString());
                                    } catch (Exception e) {
                                        System.out.println("Improper Input. Try again.");
                                        properInput = false;
                                    }
                                } while (!properInput);
                            } else if (input1 == 2) {
                                boolean properInput = true;
                                do {
                                    try {
                                        System.out.print("Name #1 - ");
                                        String name1 = sc.nextLine();
                                        System.out.println("Name #2 - ");
                                        String name2 = sc.nextLine();
                                        System.out.println((museum.greaterFloorSpaceBetweenArtifacts(name1, name2))
                                                .identifierToString());
                                    } catch (Exception e) {
                                        System.out.println("Improper Input. Try again.");
                                        properInput = false;
                                    }
                                } while (!properInput);
                            }
                        } catch (Exception e) {
                            System.out.println("Improper input. Try again.");
                        }
                    } while (input1 != 1 && input1 != 2);

                } else if (input != 4) {
                    System.out.println("Invalid input. Try again.");
                }
            } catch (Exception e) {
                System.out.println("Error reading input. Try again.");
                input = -1;
            }
        } while (input != 4);

    }
    
    public static void printVisitorInfo(Scanner sc, Museum museum) {
        int input = -1;

        do {
            input = -1;
            System.out.println("0) Back to Facility Analytics Menu");
            System.out.println("1) Print Information on current visitors");
            System.out.println("2) Sort visitors by criteria");
            System.out.println("3) Search visitors by criteria");
            System.out.println("4) Compare visitor information");

            try {
                input = sc.nextInt();
                System.out.println();

                if (input == 1) {
                    printVisitorInfoMenu(sc, museum);
                } else if (input == 2) {
                    sortVisitorMenu(sc, museum);
                } else if (input == 3) {
                    searchVisitorMenu(sc, museum);
                } else if (input == 4) {
                    compareVisitorsMenu(sc, museum);
                } else if (input != 0) {
                    System.out.println("Please enter an input from 1-4");
                }
            } catch (Exception e) {
                System.out.println("Error reading input. Please try again");
                input = -1;
            }
        } while (input != 0);
    }

    public static void printVisitorInfoMenu(Scanner sc, Museum museum) {
        int input = -1;
        do {
            input = -1;
            System.out.println("\nPrint Visitor Information");
            System.out.println("0) Back to Visitor Analytics Menu");
            System.out.println("1) Print Information on all Visitors");
            System.out.println("2) Print a specified visitor's name, age and current location (specified by ID or name)");
            System.out.println("3) Print all artifacts a specified visitor has been to");
            System.out.println("4) Print the current number of total visitors in the museum");
            System.out.println("5) Print the current number of child visitors in the museum");
            System.out.println("6) Print the current number of adult visitors in the museum");
            System.out.println("7) Print the current number of senior visitors in the museum");
            System.out.println("8) Print the average age of the current visitors");
            System.out.print("Enter desired option: ");

            try {
                input = sc.nextInt();
                System.out.println();

                if (input == 1) // print all visitors
                {
                    System.out.println("List of all visitors: ");
                    museum.printAllVisitors();
                    System.out.println();
                } else if (input == 2) // print on specific visitor
                {
                    int input1 = -1;

                    do {
                        input1 = -1;
                        System.out.println("\nOptions");
                        System.out.println("1) Search by ID");
                        System.out.println("2) Search by name");
                        System.out.println("Enter desired choice: ");
                        input1 = sc.nextInt();
                        System.out.println();
                        try {
                            if (input1 == 1) // print from 6 digit ID {
                            {
                                int id;
                                System.out.print("Enter the visitor's 6 digit ID number: ");
                                id = sc.nextInt();
                                museum.printSpecificVisitor(id);
                                System.out.println();
                            } else if (input1 == 2) // print from given full name, case-sensitive, sep. by a space
                            {
                                String fullName;
                                sc.nextLine(); // flush
                                System.out.println(
                                        "Enter case-sensitive full name, separating the first and last name by a space: ");
                                fullName = sc.nextLine();
                                System.out.println();
                                museum.printSpecificVisitor(fullName);
                            } else if (!(input1 == 1 || input1 == 2)) // invalid option
                            {
                                System.out.println("Please enter 1 or 2");
                                System.out.println();
                                input1 = -1;
                            }
                        } catch (Exception e) {
                            System.out.println("Invalid input.");
                            System.out.println();
                            input1 = -1;
                        }
                    } while (!(input1 == 1 || input1 == 2));
                } else if (input == 3) // print all places a visitor has visited
                {

                    String fullName;
                    sc.nextLine(); // flush
                    System.out
                            .println("Enter the full name of a visitor(separate the first and last name by a space): ");
                    fullName = sc.nextLine();
                    System.out.println();
                    // museum.printVisitedArtifacts();
                    System.out.println();
                } else if (input == 4) // print current num total visitors
                {
                    int numTotal = museum.numAdults() + museum.numChildren() + museum.numSeniors();
                    System.out.println("There are a total of " + numTotal + " current visitors at the museum");
                    System.out.println();
                } else if (input == 5) // print current num child visitors
                {
                    System.out.println(
                            "There are a total of " + museum.numChildren() + " current visitors at the museum");
                    System.out.println();
                } else if (input == 6) // print current num adult visitors
                {
                    System.out
                            .println("There are a total of " + museum.numAdults() + " current visitors at the museum");
                    System.out.println();
                } else if (input == 7) // print current num senior visitors
                {
                    System.out
                            .println("There are a total of " + museum.numSeniors() + " current visitors at the museum");
                    System.out.println();
                } else if (input == 8) // print avg age of all visitors
                {
                    System.out.println(museum.averageAge() + " is the average age of all the visitors");
                } else if (input != 0) {
                    System.out.println("Please enter a valid digit from 0-9");
                    System.out.println();
                    input = -1;
                }
            } catch (Exception e) {
                System.out.println("Error reading input. Try again.");
                System.out.println();
                input = -1;
            }
        } while (input != 0);
    }

    public static void sortVisitorMenu(Scanner sc, Museum museum) {
        int input = -1;

        do {
            input = -1;
            System.out.println("\nSort Visitors");
            System.out.println("0) Back to Visitor Analytics Menu");
            System.out.println("1) Print a list of all current child visitors");
            System.out.println("2) Print a list of all current adult visitors");
            System.out.println("3) Print a list of all current senior visitors");
            System.out.println("4) Print all visitors, sorted by ascending age");
            System.out.println("5) Print all visitors, sorted by descending age");
            System.out.print("Enter your desired choice: ");
            try {
                input = sc.nextInt();
                System.out.println();
                if (input == 1) {
                    museum.printAllChildren();
                    System.out.println();
                } else if (input == 2) {
                    museum.printAllAdults();
                    System.out.println();
                } else if (input == 3) {
                    museum.printAllSeniors();
                    System.out.println();
                } else if (input == 4) {
                    museum.printVisitorsAscendingAge();
                    System.out.println();
                } else if (input == 5) {
                    museum.printVisitorsDescendingAge();
                    System.out.println();
                } else if (input != 0) {
                    System.out.println("Please enter an integer between 0-5");
                    System.out.println();
                }
            } catch (Exception e) {
                System.out.println("Error reading input. Please try again.");
                System.out.println();
                input = -1;
            }
        } while (input != 0);
    }

    public static void searchVisitorMenu(Scanner sc, Museum museum) {
        int input = -1;

        do {
            input = -1;
            System.out.println("\nSearch Visitors");
            System.out.println("0) Return to Visitor Analytics Menu");
            System.out.println("1) Search for a visitor by ID");
            System.out.println("2) Search for a visitor by name");
            System.out.println("3) Print all visitors currently at a specific exhibit");
            System.out.println("4) Print all visitors currently at a specific artifact");
            System.out.println("Enter your desired choice: ");

            try {
                input = sc.nextInt();
                System.out.println();

                if (input == 1) {
                    int id;
                    System.out.print("Enter desired visitor's 6 digit ID: ");
                    id = sc.nextInt();
                    museum.printSpecificVisitor(id);
                    System.out.println();
                } else if (input == 2) {
                    sc.nextLine(); // flush
                    String name;
                    System.out.println(
                            "Enter case-sensitive full name of desired visitor, separate the first and last name by space: ");
                    name = sc.nextLine();
                    museum.printSpecificVisitor(name);
                    System.out.println();
                } else if (input == 3) {
                    int input1 = -1;
                    do {
                        input1 = -1;
                        System.out.println("\nOptions");
                        System.out.println("1) Choose exhibit by 4 digit ID");
                        System.out.println("2) Choose exhibit by full name");
                        System.out.print("Enter desired choice: ");
                        try {
                            input1 = sc.nextInt();
                            if (input1 == 1) // Search by exhibit 4 digit ID
                            {
                                int id;
                                System.out.print("Enter exhibit's 4 digit ID: ");
                                try {
                                    id = sc.nextInt();
                                    museum.printVisitorsAtExhibit(id);
                                    System.out.println();
                                } catch (InputMismatchException imx) {
                                    System.out.println("ID not entered correctly");
                                    System.out.println();
                                }

                            } else if (input1 == 2) // search by exhibit full name
                            {
                                sc.nextLine(); // flush
                                String name;
                                System.out.print("Enter case-sensitive exhibit name: ");
                                name = sc.nextLine();
                                museum.printVisitorsAtExhibit(name);
                                System.out.println();
                            } else if (input1 != 1 && input1 != 2) // if input thats integer non-option is entered
                            {
                                System.out.println("Enter either 1 or 2");
                                System.out.println();
                                input1 = -1;
                            }
                        } catch (Exception e) {
                            System.out.println("Enter either 1 or 2");
                            System.out.println();
                        }
                    } while (input1 != 1 && input1 != 2);
                } else if (input == 4) {
                    int input1 = -1;
                    do {
                        input1 = -1;
                        System.out.println("\nOptions");
                        System.out.println("1) Choose artifact by 5 digit ID");
                        System.out.println("2) Choose artifact by full name");
                        System.out.print("Enter desired choice: ");
                        try {
                            input1 = sc.nextInt();
                            if (input1 == 1) // Search by artifact 5 digit ID
                            {
                                int id;
                                System.out.print("Enter artifact's 5 digit ID: ");
                                try {
                                    id = sc.nextInt();
                                    museum.printVisitorsAtArtifact(id);
                                    System.out.println();
                                } catch (InputMismatchException imx) {
                                    System.out.println("ID not entered correctly");
                                    System.out.println();
                                }

                            } else if (input1 == 2) // search by artifact full name
                            {
                                sc.nextLine(); // flush
                                String name;
                                System.out.print("Enter case-sensitive artifact name: ");
                                name = sc.nextLine();
                                museum.printVisitorsAtArtifact(name);
                                System.out.println();
                            } else if (input1 != 1 && input1 != 2) // if input thats integer non-option is entered
                            {
                                System.out.println("Enter either 1 or 2");
                                System.out.println();
                            }
                        } catch (Exception e) {
                            System.out.println("Enter either 1 or 2");
                            System.out.println();
                        }
                    } while (input1 != 1 && input1 != 2);
                } else if (input != 0) {
                    System.out.println("Enter an integer option between 0-4");
                    System.out.println();
                }
            } catch (Exception e) {
                System.out.println("Please enter a valid info");
                System.out.println();
            }
        } while (input != 0);
    }

    public static void compareVisitorsMenu(Scanner sc, Museum museum) {
        int input = -1;
        do {
            input = -1;
            System.out.println("\nCompare Visitors");
            System.out.println("0) Return to Visitor Analytics Menu");
            System.out.println("1) Compare the age between two visitors");
            System.out.println("2) Compare the number of unique exhibits two visitors have visited");
            System.out.println("3) Compare the number of unique artifacts two visitors have visited");
            System.out.print("Enter desired option: ");

            try {
                input = sc.nextInt();
                System.out.println();
                if (input == 1) // compare ages
                {
                    int input1 = -1;
                    do {
                        input1 = -1;
                        System.out.println("\nOptions");
                        System.out.println("1) Compare two visitors with ID");
                        System.out.println("2) Compare two visitors with full names");
                        System.out.print("Enter desired option: ");

                        try {
                            input1 = sc.nextInt();
                            System.out.println();
                            if (input1 == 1) //use IDs
                            {
                                int id1, id2;
                                try {
                                    System.out.print("Enter 6 digit ID of first visitor: ");
                                    id1 = sc.nextInt();
                                    System.out.print("Enter 6 digit ID of second visitor: ");
                                    id2 = sc.nextInt();
                                    System.out.println("The following visitor has the greater age: ");
                                    System.out.println(museum.greaterAgeBetweenVisitors(id1, id2).identifierToString());
                                } catch (InputMismatchException imx) {
                                    System.out.println("An ID must be entered.");
                                }
                            } else if (input1 == 2) //use full names
                            {
                                sc.nextLine(); // flush
                                String name1, name2;
                                System.out.println("Enter case-sensitive full name of 1st visitor, separating the first and last name by a space: ");
                                name1 = sc.nextLine();
                                System.out.println("Enter case-sensitive full name of 2nd visitor, separating the first and last name by a space: ");
                                name2 = sc.nextLine();
                                System.out.println("The following visitor has the greater age: ");
                                System.out.println(museum.greaterAgeBetweenVisitors(name1, name2).identifierToString());
                            } else if (input1 != 1 && input1 != 2) //invalid integer entered
                            {
                                System.out.println("Enter either 1 or 2");
                                System.out.println();
                                input1 = -1;
                            }
                        } catch (InputMismatchException imx) {
                            System.out.println("Invalid Input. Enter either 1 or 2");
                            System.out.println();
                            input1 = -1;
                        }
                    } while (input1 != 1 && input1 != 2);
                } else if (input == 2) //compare numExhibits
                {
                    int input1 = -1;
                    do {
                        input1 = -1;
                        System.out.println("\nOptions");
                        System.out.println("1) Compare two visitors with ID");
                        System.out.println("2) Compare two visitors with full names");
                        System.out.print("Enter desired option: ");

                        try {
                            input1 = sc.nextInt();
                            System.out.println();
                            if (input1 == 1) //use IDs
                            {
                                int id1, id2;
                                try {
                                    System.out.print("Enter 6 digit ID of first visitor: ");
                                    id1 = sc.nextInt();
                                    System.out.print("Enter 6 digit ID of second visitor: ");
                                    id2 = sc.nextInt();
                                    System.out.println("The following visitor has visited more exhibits: ");
                                    System.out.println(museum.greaterNumOfExhibitsVisited(id1, id2).identifierToString());
                                } catch (InputMismatchException imx) {
                                    System.out.println("An ID number must be entered.");
                                }
                            } else if (input1 == 2) //use full names
                            {
                                sc.nextLine(); // flush
                                String name1, name2;
                                System.out.println("Enter case-sensitive full name of 1st visitor, separating the first and last name by a space: ");
                                name1 = sc.nextLine();
                                System.out.println("Enter case-sensitive full name of 2nd visitor, separating the first and last name by a space: ");
                                name2 = sc.nextLine();
                                System.out.println("The following visitor has visited more exhibits: ");
                                System.out.println(museum.greaterNumOfExhibitsVisited(name1, name2).identifierToString());

                            } else if (input1 != 1 && input1 != 2) //invalid integer entered
                            {
                                System.out.println("Enter either 1 or 2");
                                System.out.println();
                                input1 = -1;
                            }
                        } catch (InputMismatchException imx) {
                            System.out.println("Invalid Input. Enter either 1 or 2");
                            System.out.println();
                            input1 = -1;
                        }
                    } while (input1 != 1 && input1 != 2);
                } else if (input == 3) //comppare numArtifacts
                {
                    int input1 = -1;
                    do {
                        input1 = -1;
                        System.out.println("\nOptions");
                        System.out.println("1) Compare two visitors with ID");
                        System.out.println("2) Compare two visitors with full names");
                        System.out.print("Enter desired option: ");

                        try {
                            input1 = sc.nextInt();
                            System.out.println();
                            if (input1 == 1) //use IDs
                            {
                                int id1, id2;
                                try {
                                    System.out.print("Enter 6 digit ID of first visitor: ");
                                    id1 = sc.nextInt();
                                    System.out.print("Enter 6 digit ID of second visitor: ");
                                    id2 = sc.nextInt();
                                    System.out.println("The following visitor has visited more artifacts: ");
                                    System.out.println(museum.greaterNumOfArtifactsVisited(id1, id2).identifierToString());
                                } catch (InputMismatchException imx) {
                                    System.out.println("An ID must be entered.");
                                }
                            } else if (input1 == 2) //use full names
                            {
                                sc.nextLine(); // flush
                                String name1, name2;
                                System.out.println("Enter case-sensitive full name of 1st visitor, separating the first and last name by a space: ");
                                name1 = sc.nextLine();
                                System.out.println("Enter case-sensitive full name of 2nd visitor, separating the first and last name by a space: ");
                                name2 = sc.nextLine();
                                System.out.println("The following visitor has visited more artifacts: ");
                                System.out.println(museum.greaterNumOfArtifactsVisited(name1, name2).identifierToString());
                            } else if (input1 != 1 && input1 != 2) //invalid integer entered
                            {
                                System.out.println("Enter either 1 or 2");
                                System.out.println();
                                input1 = -1;
                            }
                        } catch (InputMismatchException imx) {
                            System.out.println("Invalid Input. Enter either 1 or 2");
                            System.out.println();
                            input1 = -1;
                        }
                    } while (input1 != 1 && input1 != 2);
                } else if (input != 0) {
                    System.out.println("Please enter an option from 0-3");
                    System.out.println();
                }
            } catch (Exception e) {
                System.out.println("Invalid input. Please try again.");
                System.out.println();
                input = -1;
            }
        } while (input != 0);
    }

    // Prints Museum Simulation Menu, takes input, and directs user accordingly
    private static void museumSimulationMenu(Scanner sc, Museum museum) {
        int input = -1;

        // repeat this menu until proper input is received
        do {
            input = -1;
            System.out.println("\nMuseum Simulation");
            System.out.println("0) Return to Main Menu");
            System.out.println("1) Edit Museum Simulation");
            System.out.println("2) Daily Operations");
            System.out.print("Enter your choice: ");

            try {
                input = sc.nextInt();
                System.out.println();
                if (input == 1) {
                    editMuseumInformationMenu(sc, museum);
                } else if (input == 2) {
                    dailyOperationsMenu(sc, museum);
                } else if (input != 0) {
                    System.out.println("Invalid Input. Try Again.");
                }
            } catch (Exception e) {
                System.out.println("Error reading input. Please try again.");
                input = -1;
            }

        } while (input != 0);
    }

    private static void editMuseumInformationMenu(Scanner sc, Museum museum) {
        int input = -1;

        do {
            input = -1;
            System.out.println("\nEdit Museum Information");
            System.out.println("0) Return to Museum Simulation Menu");
            System.out.println("1) Edit the amount of available display space within the museum");
            System.out.println("2) Edit the amount of available storage space within the museum");
            System.out.println("3) Add/Remove Facilities (Exhibits/Artifacts)");
            System.out.print("Enter your choice: ");

            try {
                input = sc.nextInt();
                System.out.println();
                if (input == 1) {
                    double displaySpace;
                    System.out.println("Enter the new amount of display space: ");
                    try {
                        displaySpace = sc.nextDouble();
                        museum.setMaxDisplaySpace(displaySpace);
                    } catch (Exception e) {
                        System.out.println("Invalid input. Now returning to Edit menu");
                    }
                } else if (input == 2) {
                    double storageSpace;
                    System.out.println("Enter the new amount of storage space: ");
                    try {
                        storageSpace = sc.nextDouble();
                        museum.setMaxStorageSpace(storageSpace);
                    } catch (Exception e) {
                        System.out.println("Invalid input. Now returning to Edit menu");
                    }
                } else if (input == 3) {
                    facilityModificationMenu(sc, museum);
                } else if (input != 0) {
                    System.out.println("Invalid input. Please try again.");
                }
            } catch (Exception e) {
                System.out.println("Error reading input. Please try again.");
                input = -1;
            }
        } while (input != 0);
    }

    private static void facilityModificationMenu(Scanner sc, Museum museum) {
        int input = -1;
        do {
            input = -1;
            System.out.println("\nAdd/Remove Facilities");
            System.out.println("0) Go back to Edit Museum Information Menu");
            System.out.println("1) Add exhibit");
            System.out.println("2) Remove exhibit");
            System.out.println("3) Add artifact *NOTE: EXHIBIT MUST FIRST BE CREATED TO HOUSE ARTIFACT");
            System.out.println("4) Remove artifact");
            System.out.print("Enter your choice: ");
            try {
                input = sc.nextInt();
                System.out.println();
                if (input == 1) // Add exhibit
                {
                    sc.nextLine(); // flush
                    String name, desc;
                    boolean validInput = false;
                    System.out.print("Enter the case sensitive name for the exhibit: ");
                    name = sc.nextLine();
                    System.out.print("Enter a description for the exhibit: ");
                    desc = sc.nextLine();
                    museum.addExhibit(name, desc); // museum will return an error if unsuccessful
                    System.out.println("New exhibit successfully added: ");
                    System.out.println(museum.searchExhibitByName(name).identifierToString());
                } else if (input == 2) // Remove exhibit
                {
                    int input1 = -1;
                    do {
                        input1 = -1;
                        System.out.println("Options: ");
                        System.out.println("1) Search exhibit by ID");
                        System.out.println("2) Search exhibit by name");
                        System.out.print("Enter choice: ");
                        try {
                            input1 = sc.nextInt();
                            System.out.println();
                            if (input1 == 1) // remove exhibit given id
                            {
                                int id;
                                System.out.println("Enter id of exhibit you want to remove: ");
                                id = sc.nextInt(); // if not number entered, will kick back to options catch
                                museum.removeExhibit(id); // museum will give error msg if id doesnt exist
                            } else if (input1 == 2) // remove exhibit given name
                            {
                                sc.nextLine(); // flush
                                String name;
                                System.out.println("Enter case-sensitive name of exhibit you want to remove: ");
                                name = sc.nextLine();
                                museum.removeExhibit(name); // museum will give error msg if name doesnt exist

                            } else if (!(input1 == 1 || input1 == 2)) // invalid option number
                            {
                                System.out.println("Enter either 1 or 2");
                                input1 = -1;
                            }
                        } catch (Exception e) {
                            System.out.println("Invalid input. Try again.");
                            input1 = -1;
                        }
                    } while (!(input1 == 1 || input1 == 2));
                } else if (input == 3) // Add artifact
                {
                    sc.nextLine(); // flush
                    String name, desc, dateMade, datePurchased;
                    double value, floorSpace;
                    int exhId;
                    char onDisplayChar;
                    boolean onDisplay = false;
                    try {
                        System.out.print("Enter artifact name: ");
                        name = sc.nextLine();
                        System.out.print("Enter artifact description: ");
                        desc = sc.nextLine();
                        System.out.print("Enter value of artifact: $");
                        value = sc.nextDouble();
                        System.out.print("Enter floor space required to house artifact (sq. ft.): ");
                        floorSpace = sc.nextDouble();
                        sc.nextLine(); // flush
                        System.out.print("Enter the artifact's date of origin (dd/mm/yyyy C.E/B.C.E): ");
                        dateMade = sc.nextLine();
                        System.out.print("Enter the artifact's date of purchase (dd/mm/yyyy C.E/B.C.E): ");
                        datePurchased = sc.nextLine();
                        System.out.print("Enter the exhibit ID of where the artifact should be located: ");
                        exhId = sc.nextInt();
                        sc.nextLine(); // flush
                        System.out.print("Is the artifact on display right now? (Y/N): ");
                        onDisplayChar = sc.nextLine().charAt(0);
                        if (onDisplayChar == 'Y' || onDisplayChar == 'y') {
                            onDisplay = true;
                        } else if (onDisplayChar == 'N' || onDisplayChar == 'n') {
                            onDisplay = false;
                        }
                        museum.addArtifact(name, desc, value, floorSpace, dateMade, datePurchased, exhId, onDisplay);
                        System.out.println("Artifact succesfully made: ");
                        //// System.out.println(museum.findArtifactIndexByName(name).identifierToString());
                        //// print ARTIFACT IDENTIFIER
                    } catch (InputMismatchException imx) {
                        System.out.println("Invalid input. Returning to Facility Modification Menu");
                    }
                } else if (input == 4) // Remove artifact
                {
                    int input1 = -1;
                    do {
                        input1 = -1;
                        System.out.println("\nOptions: ");
                        System.out.println("1) Search artifact by ID");
                        System.out.println("2) Search artifact by name");
                        System.out.print("Enter choice: ");
                        try {
                            input1 = sc.nextInt();
                            System.out.println();
                            if (input1 == 1) // remove artifact given id
                            {
                                int id;
                                System.out.println("Enter id of artifact you want to remove: ");
                                id = sc.nextInt(); // if not number entered, will kick back to options catch
                                museum.removeArtifact(id); // museum will give error msg if id doesnt exist
                            } else if (input1 == 2) // remove artifact given name
                            {
                                sc.nextLine(); // flush
                                String name;
                                System.out.println("Enter case-sensitive name of artifact you want to remove: ");
                                name = sc.nextLine();
                                museum.removeExhibit(name); // museum will give error msg if name doesnt exist

                            } else if (!(input1 == 1 || input1 == 2)) // invalid option number
                            {
                                System.out.println("Enter either 1 or 2");
                                input1 = -1;
                            }
                        } catch (Exception e) {
                            System.out.println("Invalid input. Try again.");
                            input1 = -1;
                        }
                    } while (!(input1 == 1 || input1 == 2));
                } else if (input != 0) {
                    System.out.println("Please enter an option from 0-4");
                }
            } catch (Exception e) {
                System.out.println("Error reading input. Please try again.");
                input = -1;
            }
        } while (input != 0);
    }

    private static void dailyOperationsMenu(Scanner sc, Museum museum) {
        int input = -1;
        do {
            input = -1;
            System.out.println("\nDaily Operations");
            System.out.println("0) Return to Museum Simulation Menu");
            System.out.println("1) Add Visitor");
            System.out.println("2) Move Visitor");
            System.out.println("3) Remove Visitor");
            System.out.println("4) Close for the day");
            System.out.print("Enter your choice: ");

            try {
                input = sc.nextInt();
                System.out.println();
                if (input == 1) {
                    boolean properInput;
                    do {
                        try {
                            String firstName, lastName;
                            int age;
                            properInput = true;
                            sc.nextLine();
                            System.out.print("First Name: ");
                            firstName = sc.nextLine();
                            System.out.print("Last Name: ");
                            lastName = sc.nextLine();
                            System.out.print("Age: ");
                            age = sc.nextInt();
                            museum.addVisitor(firstName, lastName, age);
                        } catch (Exception e) {
                            System.out.println("Improper input. Please try again.");
                            properInput = false;
                        }
                    } while (!properInput);
                } else if (input == 2) {
                    int input1 = -1;
                    do {
                        input1 = -1;
                        System.out.println("\nOptions:");
                        System.out.println("1) Move visitor by visitor and artifact ID");
                        System.out.println("2) Move visitor by visitor and artifact name");
                        try {
                            input1 = sc.nextInt();
                            if (input1 == 1) {
                                boolean properInput;
                                do {
                                    try {
                                        properInput = true;
                                        System.out.print("Visitor ID: ");
                                        int visitorId = sc.nextInt();
                                        System.out.print("Artifact ID: ");
                                        int artifactId = sc.nextInt();
                                        museum.moveVisitor(visitorId, artifactId);
                                    } catch (Exception e) {
                                        System.out.println("Improper input. Please try again.");
                                        properInput = false;
                                    }
                                } while (!properInput);
                            } else if (input1 == 2) {
                                boolean properInput;
                                do {
                                    try {
                                        properInput = true;
                                        sc.nextLine();
                                        System.out.print("Visitor full name: ");
                                        String visitorName = sc.nextLine();
                                        System.out.print("Artifact name: ");
                                        String artifactName = sc.nextLine();
                                        museum.moveVisitor(visitorName, artifactName);
                                    } catch (Exception e) {
                                        System.out.println("Improper input. Please try again.");
                                        properInput = false;
                                    }
                                } while (!properInput);
                            }
                        } catch (Exception e) {
                            System.out.println("Improper input. Please try again.");
                        }
                    } while (input1 != 1 && input1 != 2);
                } else if (input == 3) {
                    int input1 = -1;
                    do {
                        input1 = -1;
                        System.out.println("\nOptions: ");
                        System.out.println("1) Remove visitor by ID");
                        System.out.println("2) Remove visitor by name");
                        try {
                            input1 = sc.nextInt();
                            if (input1 == 1) {
                                boolean properInput;
                                do {
                                    properInput = true;
                                    try {
                                        System.out.print("Enter visitor ID: ");
                                        int id = sc.nextInt();
                                        museum.removeVisitor(id);
                                    } catch (Exception e) {
                                        System.out.println("Improper input. Please try again.");
                                        properInput = false;
                                    }
                                } while (!properInput);
                            } else if (input1 == 2) {
                                boolean properInput;
                                do {
                                    properInput = true;
                                    try {
                                        sc.nextLine();
                                        System.out.print("Enter visitor's full name: ");
                                        String name = sc.nextLine();
                                        museum.removeVisitor(name);
                                    } catch (Exception e) {
                                        System.out.println("Improper input. Please try again.");
                                        properInput = false;
                                    }
                                } while (!properInput);
                            }
                        } catch (Exception e) {
                            System.out.println("Improper input. Please try again.");
                        }
                    } while (input1 != 1 && input1 != 2);
                } else if (input == 4) {
                    museum.closeForTheDay();
                    System.out.println("The museum has been closed for the day");
                } else if (input != 0) {
                    System.out.println("Invalid input. Please try again.");
                }
            } catch (Exception e) {
                sc.nextLine();
                System.out.println("Improper input. Please try again.");
            }
        } while (input != 0);
    }

    private static Museum makeNewMuseum(Scanner sc) {
        String stringDate;
        double maxDisplay, maxStorage;
        System.out.print("Enter opening date (dd/mm/yyyy C.E/B.C.E)  : ");
        sc.nextLine(); // flush
        stringDate = sc.nextLine();
        System.out.print("Enter Max Display Space: (sq. ft.)");
        maxDisplay = sc.nextDouble();
        System.out.print("Enter Max Storage Space: (sq. ft.)");
        maxStorage = sc.nextDouble();
        return (new Museum(stringDate, maxDisplay, maxStorage));
    }

    private static Museum loadNewMuseum() {
        double maxStorage, maxDisplay;
        int numDaysOpen, numExhibits, numArtifacts, numVisitors;

        ArrayList<Date> dates = new ArrayList<Date>();
        ArrayList<Double> dailyRev = new ArrayList<Double>();
        dates.trimToSize();
        dailyRev.trimToSize();
        double lifetimeRev = 0;
        Bank bank;

        ArrayList<Artifact> artifacts = new ArrayList<Artifact>();
        ArrayList<Exhibit> exhibits = new ArrayList<Exhibit>();
        ArrayList<Visitor> visitors = new ArrayList<Visitor>();
        artifacts.trimToSize();
        exhibits.trimToSize();
        visitors.trimToSize();

        try {
            BufferedReader in = new BufferedReader(new FileReader("museumSave.txt"));
            Date openDate = new Date(in.readLine());
            Date currDate = new Date(in.readLine());
            maxDisplay = Double.parseDouble(in.readLine());
            maxStorage = Double.parseDouble(in.readLine());
            numDaysOpen = Integer.parseInt(in.readLine());

            for (int i = 0; i < numDaysOpen; i++) {
                Date temp = new Date(in.readLine());
                dates.add(temp);
            }

            // making bank
            for (int i = 0; i < numDaysOpen; i++) {
                dailyRev.add(Double.parseDouble(in.readLine()));
                lifetimeRev += dailyRev.get(i);
            }

            bank = new Bank(lifetimeRev, dailyRev, dates, currDate);

            // making exhibit
            numExhibits = Integer.parseInt(in.readLine());
            for (int i = 0; i < numExhibits; i++) {
                Exhibit temp = new Exhibit(in.readLine(), Integer.parseInt(in.readLine()), in.readLine());
                exhibits.add(temp);
            }

            // making artifacts and adding to exhibit
            numArtifacts = Integer.parseInt(in.readLine());
            for (int i = 0; i < numArtifacts; i++) {
                Artifact temp = new Artifact(in.readLine(), Integer.parseInt(in.readLine()), in.readLine(),
                        Double.parseDouble(in.readLine()), Double.parseDouble(in.readLine()), new Date(in.readLine()),
                        new Date(in.readLine()), findExhibit(exhibits, Integer.parseInt(in.readLine())),
                        Boolean.parseBoolean(in.readLine()));
                artifacts.add(temp);
                temp.getExhibitLocation().addArtifact(temp);
            }

            // Making visitors
            numVisitors = Integer.parseInt(in.readLine());
            for (int i = 0; i < numVisitors; i++) {
                Visitor tempVisitor;
                ArrayList<Exhibit> prevVisitedExh = new ArrayList<Exhibit>();
                ArrayList<Artifact> prevVisitedArt = new ArrayList<Artifact>();
                prevVisitedExh.trimToSize();
                prevVisitedArt.trimToSize();
                int visId = Integer.parseInt(in.readLine());
                String visFName = in.readLine();
                String visLName = in.readLine();
                int visAge = Integer.parseInt(in.readLine());
                Artifact currArt = findArtifact(artifacts, Integer.parseInt(in.readLine())); // currArt
                Exhibit currExh = currArt.getExhibitLocation(); // use currArt to find currExh

                // making prev visited exhibits
                int maxNumExhibits = Integer.parseInt(in.readLine());
                for (int j = 0; j < maxNumExhibits; j++) {
                    Exhibit temp = findExhibit(exhibits, Integer.parseInt(in.readLine()));
                    prevVisitedExh.add(temp);

                }

                // making prev visited artifacts
                int maxNumArtifacts = Integer.parseInt(in.readLine());
                for (int j = 0; j < maxNumArtifacts; j++) {
                    Artifact temp = findArtifact(artifacts, Integer.parseInt(in.readLine()));
                    prevVisitedArt.add(temp);
                }

                if (visAge >= Child.MIN_AGE && visAge <= Child.MAX_AGE) {
                    tempVisitor = new Child(visId, visFName, visLName, visAge, currExh, currArt, prevVisitedExh,
                            prevVisitedArt);
                    visitors.add(tempVisitor);
                    currArt.addVisitor(tempVisitor);
                    currExh.addVisitor(tempVisitor);
                } else if (visAge <= Adult.MAX_AGE) {
                    tempVisitor = new Adult(visId, visFName, visLName, visAge, currExh, currArt, prevVisitedExh,
                            prevVisitedArt);
                    visitors.add(tempVisitor);
                    currArt.addVisitor(tempVisitor);
                    currExh.addVisitor(tempVisitor);
                } else if (visAge >= Senior.MIN_AGE) {
                    tempVisitor = new Senior(visId, visFName, visLName, visAge, currExh, currArt, prevVisitedExh,
                            prevVisitedArt);
                    visitors.add(tempVisitor);
                    currArt.addVisitor(tempVisitor);
                    currExh.addVisitor(tempVisitor);
                }
            }
            in.close();
            return (new Museum(openDate, currDate, maxDisplay, maxStorage, numVisitors, numDaysOpen, exhibits,
                    artifacts, visitors, bank));
        } catch (IOException iox) {
            System.out.println("Error reading from file. Check if file exists!");
            return null;
        }
    }

    public static void saveMuseum(Museum museum) {
        try {
            BufferedWriter out = new BufferedWriter(new FileWriter("museumSave.txt"));
            // Print
            out.write(museum.getOpeningDate().identifierToString());
            out.newLine();
            out.write(museum.getCurrentDate().identifierToString());
            out.newLine();
            out.write("" + museum.getMaxDisplaySpace());
            out.newLine();
            out.write("" + museum.getMaxStorageSpace());
            out.newLine();
            out.write("" + museum.getDaysOpenCount());
            out.newLine();

            // Write all Dates open (for bank)
            ArrayList<Date> datesOpen = museum.getBank().getDailyRevenueDates();
            datesOpen.trimToSize();
            for (int i = 0; i < museum.getDaysOpenCount(); i++) {
                out.write(datesOpen.get(i).identifierToString());
                out.newLine();
            }

            // Write all Daily Revenues (for bank)
            ArrayList<Double> revenues = museum.getBank().getDailyRevenue();
            revenues.trimToSize();
            for (int i = 0; i < museum.getDaysOpenCount(); i++) {
                out.write("" + revenues.get(i));
                out.newLine();
            }

            // Write Exhibits Info
            ArrayList<Exhibit> exhibits = museum.getAllExhibits();
            exhibits.trimToSize();
            out.write("" + exhibits.size());
            out.newLine();
            for (int i = 0; i < exhibits.size(); i++) {
                out.write(exhibits.get(i).getName());
                out.newLine();
                out.write("" + exhibits.get(i).getId());
                out.newLine();
                out.write(exhibits.get(i).getDescription());
                out.newLine();
            }

            // Write Artifacts Info
            ArrayList<Artifact> artifacts = museum.getAllArtifacts();
            artifacts.trimToSize();
            out.write("" + artifacts.size());
            out.newLine();
            for (int i = 0; i < artifacts.size(); i++) {
                out.write(artifacts.get(i).getName());
                out.newLine();
                out.write("" + artifacts.get(i).getId());
                out.newLine();
                out.write(artifacts.get(i).getDescription());
                out.newLine();
                out.write(artifacts.get(i).getValue() + "");
                out.newLine();
                out.write(artifacts.get(i).getFloorSpace() + "");
                out.newLine();
                out.write(artifacts.get(i).getDateMade().identifierToString());
                out.newLine();
                out.write(artifacts.get(i).getDatePurchased().identifierToString());
                out.newLine();
                out.write("" + artifacts.get(i).getExhibitLocation().getId());
                out.newLine();
                out.write("" + artifacts.get(i).getOnDisplay());
                out.newLine();
            }

            // Write Visitors Info
            ArrayList<Visitor> visitors = museum.getAllVisitors();
            visitors.trimToSize();
            out.write("" + visitors.size());
            out.newLine();
            for (int i = 0; i < visitors.size(); i++) {
                ArrayList<Exhibit> visitedExh = visitors.get(i).getVisitedExhibits();
                ArrayList<Artifact> visitedArt = visitors.get(i).getVisitedArtifacts();
                out.write("" + visitors.get(i).getId());
                out.newLine();
                out.write(visitors.get(i).getFirstName());
                out.newLine();
                out.write(visitors.get(i).getLastName());
                out.newLine();
                out.write("" + visitors.get(i).getAge());
                out.newLine();
                out.write("" + visitors.get(i).getCurrentArtifact().getId());
                out.newLine();
                // previously visited artifacts/exhibits
                out.write("" + visitedExh.size());
                out.newLine();
                for (int j = 0; j < visitedExh.size(); j++) {
                    out.write("" + visitedExh.get(j).getId());
                    out.newLine();
                }

                out.write("" + visitedArt.size());
                out.newLine();
                for (int j = 0; j < visitedArt.size(); j++) {
                    out.write("" + visitedArt.get(j).getId());
                    out.newLine();
                }
            } // visitor loop

            out.close();
        } catch (IOException iox) {
            System.out.println("Error writing to file! Returning to start menu.");
        }
    }

    private static Exhibit findExhibit(ArrayList<Exhibit> exhibitList, int exhId) {
        exhibitList.trimToSize();
        for (int i = 0; i < exhibitList.size(); i++) {
            if (exhId == exhibitList.get(i).getId()) {
                return exhibitList.get(i);
            }
        }
        return null;
    }

    private static Artifact findArtifact(ArrayList<Artifact> artifactList, int artId) {
        artifactList.trimToSize();
        for (int i = 0; i < artifactList.size(); i++) {
            if (artId == artifactList.get(i).getId()) {
                return artifactList.get(i);
            }
        }
        return null;
    }
}
