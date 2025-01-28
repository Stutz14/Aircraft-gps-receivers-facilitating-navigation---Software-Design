package client;

import autopilotModule.Autopilot;
import java.util.Scanner; 
import flightManagementComputer.FMCUnit;
import frontEnd.NavProxy;
import commandModule.*;

public class FMCServer {

	public static void main(String[] args) {
		FMCUnit anFMCUnit = FMCUnit.getInstance();
		
		Scanner myObj = new Scanner(System.in);  // Create a Scanner object
	    System.out.println("Enter 1 for Navigation ");
	    System.out.println("Enter 2 for Fuel Quantity Prediction at Landing ");
	    
	    System.out.print("Enter Selection: ");
	    

	    int selection = Integer.parseInt(myObj.nextLine());  // Read user input
	    if(selection == 1) {
	    	System.out.print("Navigation Option Selected");
	    	
	    	System.out.print("Enter Target Latitude: ");
	    	String selectionLat = myObj.nextLine();
	    	System.out.print("Enter Target Longitude: ");
	    	String selectionLong =  myObj.nextLine();
			
			Command aCommand = new NavigationCommand(Integer.parseInt(selectionLat), 
					                                 Integer.parseInt(selectionLong));
			
			anFMCUnit.setFMCUnitCommand(aCommand);
		
	    }
	    
	    // we will add later if selection is 2 - We should use a Factory to create the right command

		anFMCUnit.execute();
		
	}
}
