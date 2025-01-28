package stateModule;

import java.util.ArrayList;
import java.util.List;

import controlSurfacesModule.IControlActuator;

public class Below1KNGD implements IAircraftState {

	@Override
	public void perform(int curLat, int curLon, int nextLat, int nextLon, List<IControlActuator> actuators) {
		System.out.println("Notify only Elevator --------------------------");
		List<IControlActuator> currentActuators = new ArrayList<IControlActuator>();
		currentActuators = selectActuators(actuators);
		
		for (IControlActuator anActuator : currentActuators) {
			anActuator.update(curLat, curLon, nextLat, nextLon);
		}
	}

	public List<IControlActuator> selectActuators(List<IControlActuator> actuators) {
		List<IControlActuator> currentActuators = new ArrayList<IControlActuator>();
		currentActuators.add(actuators.get(1));

		return currentActuators;

	}

}
