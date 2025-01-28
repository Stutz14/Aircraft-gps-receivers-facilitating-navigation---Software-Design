package frontEnd;

import java.util.ArrayList;
import java.util.List;

import GPSReaderModule.HoneyWellGPSReader;
import GPSReaderModule.IGPSReader;
import GPSReaderModule.RockWellGPSReader;
import autopilotModule.Autopilot;
import autopilotModule.Coordinates;
import coordinateComparisonModule.ICompareCoordsStrategy;
import coordinateComparisonModule.TwoThreeVotingStrategy;
import controlSurfacesModule.*;

public class NavigationFacade {

	public NavigationFacade(List<IGPSReader> gpsReaders, ICompareCoordsStrategy aComparisonStrategy,
			List<IControlActuator> actuators) {
		super();
		this.gpsReaders = gpsReaders;
		this.aComparisonStrategy = aComparisonStrategy;
		this.actuators = actuators;
	}

	private List<IGPSReader> gpsReaders;
	// THE STRATEGY PATTERN
	private ICompareCoordsStrategy aComparisonStrategy;
	private List<IControlActuator> actuators;

	
	

	public List<Coordinates> ReadGPSData() {
		// Create GPS Readers (can be done with a Factory)

		
		List<Coordinates> results = new ArrayList<Coordinates>();
		Coordinates aGPSReading;
	
		for (IGPSReader gps : gpsReaders) {
			aGPSReading = gps.readCoordinates();
			results.add(aGPSReading);
		}
		
		return results;
	}
	
	
	public Coordinates compareGPSData(List<Coordinates> results) {
		// Step 2 Do the comparison
		Coordinates finalResult;
		// INVOKING THE STRATEGY
		finalResult = aComparisonStrategy.compareCoords(results.get(0), results.get(1), results.get(2));
		// Step 3 Return the final result
		return finalResult;

	}

	// A FACADE
	public Coordinates doNavigation(Autopilot autoP) {
		// Step 1 Read Coordinates 
		List<Coordinates> data = ReadGPSData();
		// Step 2 Compare Coordinates THE STRATEGY PATTERN
		Coordinates result = compareGPSData(data);
		//Step 3 Update autopilot readings from reconciled GPS data
		autoP.setCurrentLatitude(result.getLatitude());
		autoP.setCurrentLongitude(result.getLongitude());
		//Step 4 Decide on the actuators and notify tehm through a Subject
		// The OBSERVER PATTERN
		GPSDataSubject aSubject = new GPSDataSubject(actuators);
		aSubject.notifyActuators(autoP.getCurrentLatitude(), autoP.getCurrentLongitude(), 
				                  autoP.getNextWaypointLatitude(), 
				                  autoP.getNextWaypointLongitude());
		return result;
	}
}
