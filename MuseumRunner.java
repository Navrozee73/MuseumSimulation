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

				} else if (input == 4) {

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
					System.out.println("Total display space(m�) - " + museum.getMaxDisplaySpace());
				} else if (input == 2) {
					System.out.println("Total storage space(m�) - " + museum.getMaxStorageSpace());
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

				} else if (input != 4) {

				}

			} catch (Exception e) {
				System.out.println("Error reading input. Try again.");
				input = -1;
			}
		} while (input != 4);
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

				if (input == 1) {

					museum.printAllExhibits();

				} else if (input == 2) {

					int input1 = -1;

					do {
                  input1= -1;
					   System.out.println("Options");
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
                  input1=-1;
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
                  input1=-1;
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

			///////////////UNCOMMENT LATER//////museum.printAllArtifacts();//////////////////////////////////////////////////////

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
									///////////UNCOMMENT LATER/////	museum.printSpecificArtifact(id);
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

		} while (input != 5);

	}

	private static void sortArtifacts(Scanner sc, Museum museum) {
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

	private static void compareArtifacts(Scanner sc, Museum museum) {
		int input = -1;

		do {
         input = -1;
		   System.out.println("\nCompare Artifacts");
		   System.out.println("1) Compare values between artifacts");
		   System.out.println("2) Compare number of visitors between artifacts");
		   System.out.println("3) Compare required floor space between artifacts");
		   System.out.println("4) Compare number of artifacts between artifacts");
		   System.out.println("5) Back to Artifact Analytics");
			try {
				input = sc.nextInt();

				if (input == 1) {

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

	// Prints Museum Simulation Menu, takes input, and directs user accordingly
	private static void museumSimulationMenu(Scanner sc, Museum museum)
    {
         int input = -1;
         
         // repeat this menu until proper input is received
         do
         {
            input = -1;
            System.out.println ("\nMuseum Simulation");
            System.out.println ("0) Return to Main Menu");
            System.out.println ("1) Edit Museum Simulation");
            System.out.println("2) Daily Operations");
            System.out.print ("Enter your choice: ");
            
            try
            {
               input = sc.nextInt();
               System.out.println();
               if (input == 1)
               {
                  editMuseumInformationMenu(sc, museum);
               }
               else if (input == 2)
               {
                  dailyOperationsMenu(sc, museum);
               }
               else if (input != 0)
               {
                  System.out.println("Invalid Input. Try Again.");
               }
            }
            catch (Exception e)
            {
               System.out.println ("Error reading input. Please try again.");
               input = -1;
            }
            
         } while(input != 0);    
    }

   private static void editMuseumInformationMenu(Scanner sc, Museum museum)
   {
      int input = -1;
      
      do 
      {
            input = -1;
            System.out.println ("\nEdit Museum Information");
            System.out.println("0) Return to Museum Simulation Menu");
            System.out.println("1) Edit the amount of available display space within the museum");
            System.out.println("2) Edit the amount of available storage space within the museum");
            System.out.println("3) Add/Remove Facilities (Exhibits/Artifacts)");
            System.out.print("Enter your choice: ");
            
            try
            {
               input = sc.nextInt();
               System.out.println();
               if (input == 1)
               {
                  double displaySpace;
                  System.out.println("Enter the new amount of display space: ");
                  try
                  {
                     displaySpace = sc.nextDouble();
                     museum.setMaxDisplaySpace(displaySpace);
                  }
                  catch (Exception e)
                  {
                     System.out.println("Invalid input. Now returning to Edit menu");
                  } 
               }
               else if (input == 2)
               {
                  double storageSpace;
                  System.out.println("Enter the new amount of storage space: ");
                  try
                  {
                     storageSpace = sc.nextDouble();
                     museum.setMaxStorageSpace(storageSpace);
                  }
                  catch (Exception e)
                  {
                     System.out.println("Invalid input. Now returning to Edit menu");
                  } 
               }
               else if (input == 3)
               {
                  facilityModificationMenu(sc, museum);
               }
               else if (input != 0)
               {
                  System.out.println ("Invalid input. Please try again.");
               }
            }
            catch (Exception e)
            {
               System.out.println ("Error reading input. Please try again.");
               input = -1;
            }
      } while (input != 0);
   }
   
   private static void facilityModificationMenu (Scanner sc, Museum museum)
   {
      int input = -1;
      do
      {
         input = -1;
         System.out.println("\nAdd/Remove Facilities");
         System.out.println("0) Go back to Edit Museum Information Menu");
         System.out.println("1) Add exhibit");
         System.out.println("2) Remove exhibit");
         System.out.println("3) Add artifact *NOTE: EXHIBIT MUST FIRST BE CREATED TO HOUSE ARTIFACT");
         System.out.println ("4) Remove artifact");
         System.out.print("Enter your choice: ");
         try
         {
            input = sc.nextInt();
            System.out.println();
            if (input == 1)   //Add exhibit
            {
            }
            else if (input == 2) //Remove exhibit
            {
            }
            else if (input == 3) // Add artifact
            {
            }
            else if (input == 4) // Remove artifact
            {
            }
            else if (input != 0)
            {
            }
         }
         catch (Exception e)
         {
            System.out.println("Error reading input. Please try again.");
            input = -1;
         }
      } while (input != 0);
   }   
   private static void dailyOperationsMenu (Scanner sc, Museum museum)
   {
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

	private static Museum loadNewMuseum() 
   {
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
			out.write(""+museum.getDaysOpenCount());
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
			out.write(""+exhibits.size());
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
			out.write(""+artifacts.size());
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
			out.write(""+visitors.size());
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
			}  //visitor loop
         
         out.close();
		} catch (IOException iox) {
			System.out.println("Error writing to file! Returning to start menu.");
		}
	}


	private static Exhibit findExhibit(ArrayList<Exhibit> exhibitList, int exhId) {
		exhibitList.trimToSize();
		for (int i = 0; i < exhibitList.size(); i++) {
			if (exhId == exhibitList.get(i).getId())
				return exhibitList.get(i);
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