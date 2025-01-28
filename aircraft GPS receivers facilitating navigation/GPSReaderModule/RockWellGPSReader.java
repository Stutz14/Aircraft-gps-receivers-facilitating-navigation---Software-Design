package GPSReaderModule;

import java.util.Random;

import autopilotModule.Coordinates;

public class RockWellGPSReader implements IGPSReader {
	Random rand = new Random();

	@Override
	public Coordinates readCoordinates() {
		System.out.println("Rockwell GPS Reader is Used ");
		int lat = rand.nextInt(2);
		int lon = rand.nextInt(2);
		Coordinates result = new Coordinates();
		result.setLatitude(lat);
		result.setLongitude(lon);
		System.out.println("GPS DATA LAT DATA IS " + lat + " " + "GPS DATA LON IS " + " " + lon);
		return result;
	}
}
