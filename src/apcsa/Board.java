package apcsa;

public class Board {
	// represents the games board
	// 1 for red, 5 for blue, other for nothing
	private static int[][] Slots = new int[7][6];
	
	public static int getSlot(int i, int j) {
		return Slots[i][j];
	}
	
	public static void setSlot(int i, int j, int val) {
		Slots[i][j] = val;
	}


	/**
	 * the following win condition methods:
	 * return 4 if red has won
	 * return 20 if blue has won
	 * return other if no player has yet won
	 */
	public int checkForWin() {
		return 0;	// to be implemented
	}

	public int checkLeft (int i, int j) {
		if (i < 3) return 0;
		else {
			int sum = 0;
			for (int k = 0; k < 4; k++) sum += getSlot(i - k, j);
			return sum;
		}
	}

	public int checkRight (int i, int j) {
		if (i > 3) return 0;
		else {
			int sum = 0;
			for (int k = 0; k < 4; k++) sum += getSlot(i - k, j);
			return sum;
		}
	}
	
	public int checkUp (int i, int j) {
		if (j < 3) return 0;
		else {
			int sum = 0;
			for (int k = 0; k < 4; k++) sum += getSlot(i, j - k);
			return sum;
		}
	}

	public int checkDown (int i, int j) {
		if (j > 2) return 0;
		else {
			int sum = 0;
			for (int k = 0; k < 4; k++) sum += getSlot(i, j + k);
			return sum;
		}
	}
	
	public int checkDiagLeftUp (int i, int j) {
		if (i < 3 || j < 3) return 0;
		else {
			int sum = 0;
			for (int k = 0; k < 4; k++) sum += getSlot(i - k, j - k);
			return sum;
		}
	}

	public int checkDiagRightUp (int i, int j) {
		if (i > 3 || j < 3) return 0;
		else {
			int sum = 0;
			for (int k = 0; k < 4; k++) sum += getSlot(i + k, j - k);
			return sum;
		}
	}

	public int checkDiagLeftDown (int i, int j) {
		if (i < 3 || j > 2) return 0;
		else {
			int sum = 0;
			for (int k = 0; k < 4; k++) sum += getSlot(i - k, j + k);
			return sum;
		}
	}

	public int checkDiagRightDown (int i, int j) {
		if (i > 3 || j > 2) return 0;
		else {
			int sum = 0;
			for (int k = 0; k < 4; k++) sum += getSlot(i + k, j + k);
			return sum;
		}
	}
}