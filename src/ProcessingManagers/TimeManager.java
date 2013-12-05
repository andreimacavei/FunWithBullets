package ProcessingManagers;

/**
 * Time object
 */
public class TimeManager {
	private int h,m,s;

	// TODO => implement the body of the class (set class fields, make ways 
	// 			for other classes to work with a TimeManager object)
	public TimeManager(String time) {
		String[] timePieces = time.split(":");
		// TODO => check if the input is correct
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