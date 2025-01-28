package client;

import autopilotModule.Autopilot;
import frontEnd.NavProxy;

public class NavigationServer {

	public static void main(String[] args) {
		NavProxy aProxy = new NavProxy();
		int nextLat = 5;
		int nextLon = 2;
		Autopilot autoP = new Autopilot(aProxy, nextLat, nextLon);

		for (int i = 1; i < 100; i++) {
			autoP.navigate();
			System.out.println(" ");
			System.out.println("================================================");
			
		}
	}
}
