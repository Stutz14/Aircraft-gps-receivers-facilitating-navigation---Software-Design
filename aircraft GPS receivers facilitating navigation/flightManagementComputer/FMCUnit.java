package flightManagementComputer;

import commandModule.*;
import frontEnd.NavProxy;

public class FMCUnit {
	
	private static FMCUnit instance = null;
	private static Command FMCUnitCommand;
	
	
	private FMCUnit FMCUnit() {
		return FMCUnit();
	}
	

	public static FMCUnit getInstance() {
		if(instance == null) {
			instance = new FMCUnit();
		}
		return instance;
	}
	
	public Result execute() {
		Result aResult = FMCUnitCommand.doAction();
		System.out.println(aResult.getResultData());
		return aResult;
	}


	public Command getFMCUnitCommand() {
		return FMCUnitCommand;
	}


	public static void setFMCUnitCommand(Command afMCUnitCommand) {
		FMCUnitCommand = afMCUnitCommand;
	};

}
