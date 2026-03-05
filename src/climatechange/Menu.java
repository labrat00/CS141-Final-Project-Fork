package climatechange;
import java.util.Scanner;
public class Menu {
	// Input scanner
	private static Scanner scnr = new Scanner(System.in);
	
	// Support method for wrapText()
	// Allows handling of texts longer than 75 characters
	private static void wrapTextBody(String justify, String t) {
		String leftSpaces;
		String rightSpaces;
		
		int textFill = 78 - t.length();
		switch (justify) {
		case "center":
			leftSpaces = String.valueOf(" ").repeat(textFill / 2);
			
			if (textFill % 2 == 0) {
				rightSpaces = String.valueOf(" ").repeat((textFill / 2) - 1);
			} else {
				rightSpaces = leftSpaces;
			}
			
			System.out.println("*" + leftSpaces + t + rightSpaces + "*");
			break;
		case "left":
			leftSpaces = " ";
			rightSpaces = String.valueOf(" ").repeat(textFill - 2);
			System.out.println("*" + leftSpaces + t + rightSpaces + "*");
			break;
		}
	}
		
	// Wraps text in * chars and centers or left justifies
	public static void wrapText(String justify, String... text) {
		String topBottomWrap = String.valueOf("* ").repeat(39) + "*";
		System.out.println(topBottomWrap);
		for (String t: text) {
			if (t.length() > 75) {
				wrapTextBody(justify, t.substring(0, 75));
				wrapTextBody(justify, t.substring(75));
				continue;
			}
			
			wrapTextBody(justify, t);
		}
		
		System.out.println(topBottomWrap + '\n');
	}
	
	// Main menu
	public static void printOptions() {
		wrapText(
			"left",
			"Available options",
			"  (i) impact        - Answer some questions to calculate your carbon",
			"                      footprint",
			"  (p) project       - get a projection of various climate related events",
			"  (e) equity        - learn about how inequitable climate change is",
			"  (j) join          - get a list of local groups for couseling, action or",
			"                      information",
			"  (f) environmental - learn about climate change and how it affected",
			"      effects         some environments",
			"  (h) help          - view options menu",
			"  (x) exit          - exit the app"
		);
	}
	
	// TODO
	public static void personalImpact() {
		System.out.println("TO DO: add code to ask for user info and calculate impact, tell them how many trees or plankton");
		System.out.println("are required to offest");
	}
	
	// TODO
	public static void project() {
		System.out.println("TO DO: add projections for various environmental things such as sea level, ocean temp etc.");
	}
	
	// TODO
	public static void equity() {
		System.out.println("TO DO: highlight things like redlining, inequal burdens, responsible parties not paying the price.");
		System.out.println("Maybe as a quiz or something interactive?");
	}
	
	// TODO Join
	public static void join() {
		System.out.println("TO DO: prompt user for the kind of group they want to join and then give a few local or online options");
		int input;
		String[] groups = {
			"1. Snohomish Conservation District",
			"2. Adopt a Stream Foundation",
			"3. Earth Watch",
			"4. exit"
		};
		String[] descriptions = {
			"""
			Snohomish Conservation District’s mission is to work cooperatively with others
			to promote and encourage conservation and responsible use of natural resources.""",
			"""
			The Adopt A Stream Foundation (AASF) a 501(c)3 non-profit organization was established
			to ensure that Pacific Northwest streams continue to provide healthy spawning and rearing
			habitat for salmon, trout, steelhead, and other wildlife. While serving our growing
			population by providing clean drinking water, and beautiful places for rest and relaxation.
			""",
			"""
			Earthwatch connects people with scientists to conserve our planet. 
			Our expeditions put you at the center of research and conservation worldwide. 
			Are you ready to experience nature as you help protect it?
			"""
		};
		String[] links = {
			"https://snohomishcd.org/",
			"https://www.streamkeeper.org/",
			"https://earthwatch.org/"
		};
		
		wrapText(
			"center",
			"Here are some local and online groups you can join to help",
			"type the number and hit enter to learn more or"
		);
		wrapText("left", groups);
		
		// Join loop
		while (true) {
			
			input = scnr.nextInt();
			switch (input) {
				case 1:
					System.out.println(descriptions[0] + "\n\n" + links[0]);
					break;
				case 2:
					System.out.println(descriptions[1] + "\n\n" + links[1]);
					break;
				case 3:
					System.out.println(descriptions[2] + "\n\n" + links[2]);
					break;
				case 4:
					printOptions();
					scnr.nextLine(); //clears buffer
					return;
			}
			
		}
	}
	
	// TODO effects of climate change of trees, animals, choose from menu options to get more information.
	public static void environmentalEffects() {
		//Scanner input = new Scanner(System.in);
        // Array of ecosystem types
	    String[] ecosystems = {
	        "Forest",
	        "Ocean",
	        "Desert",
	        "Grassland",
	        "Tundra",
	        "Wetlands"
	    };
	    // Array of what is affected in each Ecosystem. 
    	String[] affectedComponents = {
	        "Tree die-off, increased wildfires, habitat loss for animals",
	        "Coral bleaching, rising sea levels, marine species migration",
	        "Water scarcity, species extinction, extreme heat impact",
	        "Loss of grazing species, drought damage, soil degradation",
	        "Melting permafrost, declining polar wildlife populations",
	        "Flooding, loss of bird habitats, water contamination"
        };
	    int choice = 0;
	    while (choice != (ecosystems.length + 1)) {
	    	System.out.println("\n=== You are in Environmental Effects ===");
	    	System.out.println("Select an ecosystem to learn more:");
	    	for (int i = 0; i < ecosystems.length; i++) {
	    		System.out.println((i + 1) + "." + ecosystems[i]);
	    	}
	    	System.out.println((ecosystems.length + 1) + ". Exit");
	    	System.out.print("Enter your choice: ");
	    	choice = scnr.nextInt();

	    	if ((choice >= 1) && (choice <= ecosystems.length)) {
	    		System.out.println("\nEffects on " + ecosystems[choice - 1] + ":");
	    		System.out.println(affectedComponents[choice - 1]);
	    	}
	    	else if (choice == (ecosystems.length + 1)) {
	    		System.out.println("Exiting Environmental Effects...");
	    		printOptions();
	    		scnr.nextLine(); // clears buffer
	    		break;
           	}
	    	else {
	    		System.out.println("Invalid choice. Please try again.");
           }
	    }
    }
	
	public static void main(String[] args) {
		String input;
		
		wrapText(
			"center",
			"Welcome to the climate change information tool",
			"Type 'help' for menu options or 'exit' to quit"
		);
		printOptions();
		
		// Main menu loop
		while (true) {
			System.out.print("\n>");
			input = scnr.nextLine().trim().toLowerCase();
			switch (input) {
				case "impact":
				case "i":
					personalImpact();
					break;
				case "project":
				case "p":
					project();
					break;
				case "equity":
				case "e":
					equity();
					break;
				case "join":
				case "j":
					join();
					break;
				case "effects":
				case "f":
					environmentalEffects();
					break;
				case "help":
				case "h":
					printOptions();
					break;
				case "exit":
				case "x":
					System.out.println("Thanks for using the app, Goodbye!");
					return;
				default:
					System.out.println("Invalid choice. Please try again.");
			}
		}
	}		
}
