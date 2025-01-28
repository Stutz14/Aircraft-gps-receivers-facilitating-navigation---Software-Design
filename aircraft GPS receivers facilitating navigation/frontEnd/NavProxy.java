package frontEnd;


import java.util.ArrayList;
import java.util.List;

import GPSReaderModule.HoneyWellGPSReader;
import GPSReaderModule.IGPSReader;
import GPSReaderModule.RockWellGPSReader;
import autopilotModule.Autopilot;
import autopilotModule.Coordinates;
import controlSurfacesModule.AileronActuator;
import controlSurfacesModule.ElevatorActuator;
import controlSurfacesModule.IControlActuator;
import controlSurfacesModule.RudderActuator;
import coordinateComparisonModule.ICompareCoordsStrategy;
import coordinateComparisonModule.TwoThreeVotingStrategy;
import GPSReaderModule.*;

// THE PROXY PATTERN AS SINGLETON
public class NavProxy extends Proxy {
	
	private static NavProxy instance = null;
	
	private NavProxy NavProxy() {
		return new NavProxy();
	}


	public static NavProxy getInstance() {
		if(instance == null) {
			instance = new NavProxy();
		}
		return instance;
	}
	
	public Coordinates navigate(Autopilot autoP) {
		
		// Create the setup for the Facade
		List<IGPSReader> gpsReaders = new ArrayList<IGPSReader>();
		ICompareCoordsStrategy aComparisonStrategy = new TwoThreeVotingStrategy();
		List<IControlActuator> actuators = new ArrayList<IControlActuator>();
		
		gpsReaders.add(new HoneyWellGPSReader());
		gpsReaders.add(new HoneyWellGPSReader());
		gpsReaders.add(new RockWellGPSReader());
		
		actuators.add(new AileronActuator());
		actuators.add(new ElevatorActuator());
		actuators.add(new RudderActuator());
		
		// Create and Invoke the facade
		NavigationFacade aNavFacade = new NavigationFacade(gpsReaders, aComparisonStrategy, actuators);
		return aNavFacade.doNavigation(autoP);
		
	}

}
