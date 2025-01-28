package autopilotModule;

import java.util.List;

import controlSurfacesModule.*;

import frontEnd.NavProxy;

public class Autopilot {
	public Autopilot(NavProxy proxy, int nextWaypointLatitude, int nextWaypointLongitude) {
		super();
		this.proxy = proxy;
		this.nextWaypointLatitude = nextWaypointLatitude;
		this.nextWaypointLongitude = nextWaypointLongitude;
	}

	private NavProxy proxy;
	private int nextWaypointLatitude;
	private int nextWaypointLongitude;
	private int currentLatitude;
	private int currentLongitude;
	
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
