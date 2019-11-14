/**
 * 
 */
package wordGame;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;
import java.util.regex.Pattern;

/**
 * A simple text-based user interface for the word game application.
 * 
 * @author Sylvia Wong
 * @version 31/10/2019
 */
public class TUI {

	private Controller controller;  
	
	private Scanner stdIn;
	
	public TUI(Controller controller) {
		
		this.controller = controller;
		
		// Creates a Scanner object for obtaining user input
		stdIn = new Scanner(System.in);
		
		while (true) {
			displayMenu();
			getAndProcessUserOption();
		}
	}

	/**
	 * Displays the header of this application and a summary of menu options.
	 */
	private void displayMenu() {
		display(header());
		display(menu());
	}
	
	/**
	 * Obtains an user option and processes it.
	 */
	private void getAndProcessUserOption() {
		Play play;
		String command = stdIn.nextLine().trim();
		switch (command) {
		case "1" : // Refill tile rack
			display(controller.refillRack());
			break;
		case "2" : // Display board and tile rack contents
			display(controller.gameState());
			break;
		case "3" : // Place tiles on game board...
			display("Place tiles on game board...");
			play = getPlay();
			if (play != null) {
				display(controller.play(play));
			}
			break;
		case "4" : // Calculate score for an planned play
			display("Calculate score for a play...");
			play = getPlay();
			if (play != null) {
				display(controller.calculateScore(play));
			}
			break;
		case "5" : // Valid a move
			display("Check validity...");
			play = getPlay();
			if (play != null) {
				display(controller.checkValidity(play));
			}
			break;
		case "6" : // Exits the application
			display("Goodbye!");
			System.exit(0);
			break;
		default : // Not a known command option
			display(unrecogniseCommandErrorMsg(command));
		}
	}

	/**
	 * Obtain a move from the user and returns the information as a Play object.
	 */
	private Play getPlay() {
		display("Enter your move in the format STARTING_CELL; DIRECTION; LETTER_POSITIONS_IN_RACK, e.g. B3, DOWN, 513");
		String play = stdIn.nextLine().trim();
		String[] moveDetails = play.split(",");
		try { // Check the format of the input data...
			if (moveDetails.length == 3) { // Does the input contains three attributes?
				// Is the tile position sequence acceptable?
				String tilePositions = moveDetails[2].trim();
				Pattern p = Pattern.compile("[1-5]{1,5}");
				// Does it contain the acceptable number and range of tile positions?
				if (p.matcher(tilePositions).matches()) {  
					// Is there any duplicated tile position?
					Set<Character> positionSet = new HashSet<>();
					for (int index = 0; index < tilePositions.length(); index++) {
						if (!positionSet.add(tilePositions.charAt(index))) {
							display("Unacceptable tile sequence.");
							return null;
						}
					}
					// Is the given cell ID valid?
					String cellID = moveDetails[0].trim();
					p = Pattern.compile("[A-J][1-9][0]?");
					if (!p.matcher(cellID).matches()) { // Checks whether the entered cell ID is valid
						display("Invalid cell ID.");
					}
					else {
						return new Play(cellID, moveDetails[1].trim(), moveDetails[2].trim());
					}
				}
				else {
					display("Unacceptable tile sequence.");
				}
			}
		}
		catch (IllegalArgumentException iae) {
			display("Unsupported direction of tile sequence. It should be either 'ACROSS' or 'DOWN'.");
		}
		display("Bad data format.");
		return null;
	}
	
	/*
	 * Returns a string representation of a brief title for this application as the header.
	 * @return	a header
	 */
	private static String header() {
		return "\nWord Game\n";
	}
	
	/*
	 * Returns a string representation of the user menu.
	 * @return	the user menu
	 */
	private static String menu() {
		return "Enter the number associated with your chosen menu option.\n" +
			   "1: Refill tile rack\n" +
			   "2: Display game state\n" +
		       "3: Play -- place tiles on game board\n" +
			   "4: Calculate score for an intended play\n" +
			   "5: Check the validity of a given play\n" +
			   "6: Exit this application\n";
	}
	
	/*
	 * Displays the specified info for the user to view.
	 * @param info	info to be displayed on the screen
	 */
	private void display(String info) {
		System.out.println(info);
	}
	
    /*
     * Returns an error message for an unrecognised command.
     * 
     * @param error the unrecognised command
     * @return      an error message
     */
    private static String unrecogniseCommandErrorMsg(String error) {
            return String.format("Cannot recognise the given command: %s.%n", error);
    }
}
