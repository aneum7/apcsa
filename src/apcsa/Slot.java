package apcsa;

public class Slot {
	/** type legend
	 *  0 = nothing
	 *  1 = red
	 *  2 = blue
	 */
	private int type = 0;
	public Slot() {
	}
	
	public void changeType(int t) {
		if (type < 0 || type >2) {
			System.out.println("changeType method was used incorrectly");
			return;
		} else {
			type = t;
		}
	}
	
	public int getType() {
		return type;
	}

}
