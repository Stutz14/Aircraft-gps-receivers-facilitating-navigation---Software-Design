package autopilotModule;

import java.util.List;

import controlSurfacesModule.*;

import frontEnd.NavProxy;

// Singleton
public class Autopilot {
	private NavProxy proxy;
	private int nextWaypointLatitude;
	private int nextWaypointLongitude;
	private int currentLatitude;
	private int currentLongitude;
	private static Autopilot instance = null;
	
	
	private Autopilot Autopilot() {
		return new Autopilot();

	}
	
	
	public static Autopilot getInstance() {
		if(instance == null) {
			instance = new Autopilot();
		}

		return instance;
	}

	public Coordinates navigate() {
		Coordinates result = proxy.navigate(this);
		return result;
			
		
	}

	public NavProxy getProxy() {
		return proxy;
	}

	public void setProxy(NavProxy proxy) {
		this.proxy = proxy;
	}

	public int getNextWaypointLatitude() {
		return nextWaypointLatitude;
	}

	public void setNextWaypointLatitude(int nextWaypointLatitude) {
		this.nextWaypointLatitude = nextWaypointLatitude;
	}

	public int getNextWaypointLongitude() {
		return nextWaypointLongitude;
	}

	public void setNextWaypointLongitude(int nextWaypointLongitude) {
		this.nextWaypointLongitude = nextWaypointLongitude;
	}

	public int getCurrentLatitude() {
		return currentLatitude;
	}

	public void setCurrentLatitude(int currentLatitude) {
		this.currentLatitude = currentLatitude;
	}

	public int getCurrentLongitude() {
		return currentLongitude;
	}

	public void setCurrentLongitude(int currentLongitude) {
		this.currentLongitude = currentLongitude;
	}
	
	
	
	
	
	
	
}
