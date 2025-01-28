package controlSurfacesModule;

import java.util.*;
import stateModule.IAircraftState;


public class GPSDataSubject {

	private List<IControlActuator> actuators;
	private IAircraftState hasState;
	

	public IAircraftState getHasState() {
		return hasState;
	}

	public void setHasState(IAircraftState hasState) {
		this.hasState = hasState;
	}

	public GPSDataSubject(List<IControlActuator> actuators, IAircraftState aState) {
		super();
		this.actuators = actuators;
		this.hasState = aState;
	}

	public List<IControlActuator> getActuators() {
		return actuators;
	}

	public void setActuators(List<IControlActuator> actuators) {
		this.actuators = actuators;
	}
	
	
	
    // The OBSERVER PATTERN
	public void notifyActuators(int curLat, int curLon, int nextLat, int nextLon) {
		hasState.perform(curLat, curLon, nextLat, nextLon, actuators);
		
//		for (IControlActuator anActuator : actuators) {
//			anActuator.update(curLat, curLon, nextLat, nextLon);
		}
	}


