package controlSurfacesModule;

public class RudderActuator implements IControlActuator {

	@Override
	public void update(int curLat, int curLon, int nextLat, int nextLon) {
		System.out.println("Rudder Actuator Notified with values " + " " + curLat + " " + curLon + " " + nextLat + " "
				+ nextLon);
	}
}
