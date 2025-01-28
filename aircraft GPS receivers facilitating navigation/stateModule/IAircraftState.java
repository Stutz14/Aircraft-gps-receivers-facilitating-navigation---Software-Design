package stateModule;

import java.util.List;

import controlSurfacesModule.IControlActuator;

public interface IAircraftState {
	void perform(int curLat, int curLon, int nextLat, int nextLon, List<IControlActuator> actuators);
	List<IControlActuator> selectActuators(List<IControlActuator> actuators);

}
