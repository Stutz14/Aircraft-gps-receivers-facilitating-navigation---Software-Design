package coordinateComparisonModule;

import autopilotModule.Coordinates;
import java.lang.Math.*;

public class TwoThreeVotingStrategy implements ICompareCoordsStrategy {

	@Override
	public Coordinates compareCoords(Coordinates gps1, Coordinates gps2, Coordinates gps3) {
		// By default will be the data form gps1
		Coordinates result = gps1;
		if (((Math.abs(gps1.getLatitude() - gps2.getLatitude()) < 1)
				&& Math.abs(gps1.getLongitude() - gps2.getLongitude()) < 1)) {
			System.out.println("------- AGGREEMENT WITH GPS1 AND GPS2");
			result = gps1;
		} else if (((Math.abs(gps1.getLatitude() - gps3.getLatitude()) < 1)
				&& Math.abs(gps1.getLongitude() - gps3.getLongitude()) < 1)) {
			System.out.println("------- AGGREEMENT WITH GPS1 AND GPS3");
			result = gps2;
		} else if (((Math.abs(gps3.getLatitude() - gps2.getLatitude()) < 1)
				&& Math.abs(gps3.getLongitude() - gps2.getLongitude()) < 1)) {
			System.out.println("------- AGGREEMENT WITH GPS2 AND GPS3");
			result = gps3;
		} else {
			System.out.println(" ********* NO AGGREEMENT GPS1 DATA WILL BE USED **********");
		}
		return result;
	}
}
