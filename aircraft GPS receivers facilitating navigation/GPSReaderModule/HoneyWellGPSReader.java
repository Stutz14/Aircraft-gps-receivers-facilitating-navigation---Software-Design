package GPSReaderModule;

import autopilotModule.Coordinates;
import java.util.Random;

public class HoneyWellGPSReader implements IGPSReader {
	
	Random rand = new Random();

	@Override
	public Coordinates readCoordinates() {
		System.out.println("Honeywell GPS Reader is Used ");
		int lat = rand.nextInt(2);
		int lon = rand.nextInt(2);
		Coordinates result = new Coordinates();
		result.setLatitude(lat);
		result.setLongitude(lon);
		System.out.println("GPS DATA LAT DATA IS " + lat + " " + "GPS DATA LON IS " + " " + lon);
		return result;
	}

}
