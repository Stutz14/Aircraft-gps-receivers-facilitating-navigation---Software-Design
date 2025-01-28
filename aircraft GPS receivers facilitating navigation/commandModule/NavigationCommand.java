package commandModule;
import frontEnd.*;
import receiver.*;

public class NavigationCommand extends Command {
	
	
	private int nextLat;
	private int nextLong;
	
	public NavigationCommand(int nextLat, int nextLon) {
		super();
		this.nextLat = nextLat;
		this.nextLong = nextLon;
	}

	public Result doAction() {
		NavProxy aProxy = NavProxy.getInstance();
		NavigationReceiver aReceiver = new NavigationReceiver();
		Result aResult = aReceiver.perform(this, aProxy);
		return aResult;
		
	}

	public int getNextLat() {
		return nextLat;
	}

	public void setNextLat(int nextLat) {
		this.nextLat = nextLat;
	}

	public int getNextLong() {
		return nextLong;
	}

	public void setNextLong(int nextLong) {
		this.nextLong = nextLong;
	}

}
