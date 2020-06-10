package apcsa;

public class Board {
	// represents the games board
	// 1 for red, 5 for blue, other for nothing
	private static int[][] slots = new int[7][6];
	public static int win = 0;
	
	public static int getSlot(int i, int j) {
		return slots[i][j];
	}
	
	public static void setSlot(int i, int j, int val) {
		slots[i][j] = val;
	}


	private static int[] sums = new int[8];
	/**
	 * returns 0 if nobody has yet won
	 * returns 1 if red has won
	 * returns 5 if blue has won
	 */
	public static void checkWin (int i, int j) {
		checkLeft(i,j);
		checkRight(i,j);
		checkDown(i,j);
		checkDiagLeftUp(i,j);
		checkDiagRightUp(i,j);
		checkDiagLeftDown(i,j);
		checkDiagRightDown(i,j);
		
		for (int k : sums) {
			if (k == 4) win = 1;
			else if (k == 20) win = 5;
		}
		System.out.println();
	}

	// the following methods populate sums with the appropriate values
	private static void checkLeft (int i, int j) {
		if (i < 3) sums[0] = 0;
		else {
			int sum = 0;
			for (int k = 0; k < 4; k++) sum += getSlot(i - k, j);
			sums[0] = sum;
		}
	}

	private static void checkRight (int i, int j) {
		if (i > 3) sums[1] = 0;
		else {
			int sum = 0;
			for (int k = 0; k < 4; k++) sum += getSlot(i + k, j);
			sums[1] = sum;
		}
	}
	
	private static void checkDown (int i, int j) {
		if (j > 2) sums[3] = 0;
		else {
			int sum = 0;
			for (int k = 0; k < 4; k++) sum += getSlot(i, j + k);
			sums[3] = sum;
		}
	}
	
	private static void checkDiagLeftUp (int i, int j) {
		if (i < 3 || j < 3) sums[4] = 0;
		else {
			int sum = 0;
			for (int k = 0; k < 4; k++) sum += getSlot(i - k, j - k);
			sums[4] = sum;
		}
	}

	private static void checkDiagRightUp (int i, int j) {
		if (i > 3 || j < 3) sums[5] = 0;
		else {
			int sum = 0;
			for (int k = 0; k < 4; k++) sum += getSlot(i + k, j - k);
			sums[5] = sum;
		}
	}

	private static void checkDiagLeftDown (int i, int j) {
		if (i < 3 || j > 2) sums[6] = 0;
		else {
			int sum = 0;
			for (int k = 0; k < 4; k++) sum += getSlot(i - k, j + k);
			sums[6] = sum;
		}
	}

	private static void checkDiagRightDown (int i, int j) {
		if (i > 3 || j > 2) sums[7] = 0;
		else {
			int sum = 0;
			for (int k = 0; k < 4; k++) sum += getSlot(i + k, j + k);
			sums[7] = sum;
		}
	}
}