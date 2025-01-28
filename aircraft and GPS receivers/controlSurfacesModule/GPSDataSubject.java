package controlSurfacesModule;

import java.util.*;

public class GPSDataSubject {

	private List<IControlActuator> actuators;

	public GPSDataSubject(List<IControlActuator> actuators) {
		super();
		this.actuators = actuators;
	}

	public List<IControlActuator> getActuators() {
		return actuators;
	}

	public void setActuators(List<IControlActuator> actuators) {
		this.actuators = actuators;
	}
	
    // The OBSERVER PATTERN
	public void notifyActuators(int curLat, int curLon, int nextLat, int nextLon) {
		for (IControlActuator anActuator : actuators) {
			anActuator.update(curLat, curLon, nextLat, nextLon);
		}
	}

}
