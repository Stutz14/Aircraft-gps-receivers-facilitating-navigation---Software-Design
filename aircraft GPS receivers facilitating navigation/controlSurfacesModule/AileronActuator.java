package controlSurfacesModule;

public class AileronActuator implements IControlActuator {

	@Override
	public void update(int curLat, int curLon, int nextLat, int nextLon) {
		System.out.println(
				"Aileron Actuator Notified with values " + " " + curLat + " " + curLon + " " + nextLat + " " + nextLon);
	}

}
