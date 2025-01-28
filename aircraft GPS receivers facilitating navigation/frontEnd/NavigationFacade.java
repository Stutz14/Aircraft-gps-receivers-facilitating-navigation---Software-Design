package frontEnd;

import java.util.ArrayList;
import java.util.List;

import GPSReaderModule.HoneyWellGPSReader;
import GPSReaderModule.IGPSReader;
import GPSReaderModule.RockWellGPSReader;
import autopilotModule.Autopilot;
import autopilotModule.Coordinates;
import coordinateComparisonModule.FirstIsBest;
import coordinateComparisonModule.ICompareCoordsStrategy;
import coordinateComparisonModule.TwoThreeVotingStrategy;
import stateModule.Below1KNGD;
import stateModule.Between1K15KNGD;
import controlSurfacesModule.*;

public class NavigationFacade {

	private List<IGPSReader> gpsReaders;
	// THE STRATEGY PATTERN
	private ICompareCoordsStrategy aComparisonStrategy;
	private List<IControlActuator> actuators;
	
	
	public NavigationFacade(List<IGPSReader> gpsReaders, ICompareCoordsStrategy aComparisonStrategy,
			List<IControlActuator> actuators) {
		super();
		this.gpsReaders = gpsReaders;
		this.aComparisonStrategy = aComparisonStrategy;
		this.actuators = actuators;
	}

	private List<Coordinates> ReadGPSData() {
		// Create GPS Readers (can be done with a Factory)

		
		List<Coordinates> results = new ArrayList<Coordinates>();
		Coordinates aGPSReading;
	
		for (IGPSReader gps : gpsReaders) {
			aGPSReading = gps.readCoordinates();
			results.add(aGPSReading);
		}
		
		return results;
	}
	
	
	private Coordinates compareGPSData(List<Coordinates> results) {
		// Step 2 Do the comparison
		Coordinates finalResult;
		// INVOKING THE STRATEGY
	 //  aComparisonStrategy = new FirstIsBest();
		finalResult = aComparisonStrategy.compareCoords(results.get(0), results.get(1), results.get(2));
		// Step 3 Return the final result
		return finalResult;

	}

	// A FACADE
	public Coordinates doNavigation(Autopilot autoP) {
		// Step 1 Read Coordinates 
		List<Coordinates> results = ReadGPSData();
		// Step 2 Compare Coordinates THE STRATEGY PATTERN
		Coordinates result = compareGPSData(results);
		//Step 3 Update autopilot readings from reconciled GPS data
		autoP.setCurrentLatitude(result.getLatitude());
		autoP.setCurrentLongitude(result.getLongitude());
		//Step 4 Decide on the actuators and notify tehm through a Subject
		// The OBSERVER PATTERN
		// here the state should be created by a Factory having obtained data from an altitude instrument
		GPSDataSubject aSubject = new GPSDataSubject(actuators, new Between1K15KNGD());
		aSubject.notifyActuators(autoP.getCurrentLatitude(), autoP.getCurrentLongitude(), 
				                  autoP.getNextWaypointLatitude(), 
				                  autoP.getNextWaypointLongitude());
		return result;
	}
}
