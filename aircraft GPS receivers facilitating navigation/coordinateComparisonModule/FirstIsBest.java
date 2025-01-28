package coordinateComparisonModule;

import autopilotModule.Coordinates;

public class FirstIsBest implements ICompareCoordsStrategy {

	@Override
	public Coordinates compareCoords(Coordinates gps1, Coordinates gps2, Coordinates gps3) {
		System.out.println("FIRST IS BEST IS USED______________________");
		return gps1;

	}

}
