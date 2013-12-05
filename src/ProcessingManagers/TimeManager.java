package ProcessingManagers;

/**
 * Time object
 */
public class TimeManager {
	private int h,m,s;
	
	/**
	 * Constructs a time object from the given string
	 * 
	 * @param time  a string representing the time in hh:mm:ss format
	 */
	public TimeManager(String time) {
		String[] timePieces = time.split(":");
		this.h = Integer.parseInt(timePieces[0]);
		this.m = Integer.parseInt(timePieces[1]);
		this.s = Integer.parseInt(timePieces[2]);
	}
	
	public int getHours() {
		return this.h;
	}
	
	public int getMinutes() {
		return this.m;
	}
	
	public int getSeconds() {
		return this.s;
	}
}