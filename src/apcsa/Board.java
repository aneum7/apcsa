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


	private int[] sums = new int[8];
	/**
	 * returns 0 if nobody has yet won
	 * returns 1 if red has won
	 * returns 5 if blue has won
	 */
	public int checkWin (int i, int j) {
		checkLeft(i,j);
		checkRight(i,j);
		checkUp(i,j);
		checkDown(i,j);
		checkDiagLeftUp(i,j);
		checkDiagRightUp(i,j);
		checkDiagLeftDown(i,j);
		checkDiagLeftUp(i,j);
		
		for (int k : sums) {
			if (k == 4) return 1;
			else if (k == 20) return 5;
		}
		
		return 0;
	}

	// the following methods populate sums with the appropriate values
	private void checkLeft (int i, int j) {
		if (i < 3) sums[0] = 0;
		else {
			int sum = 0;
			for (int k = 0; k < 4; k++) sum += getSlot(i - k, j);
			sums[0] = sum;
		}
	}

	private void checkRight (int i, int j) {
		if (i > 3) sums[1] = 0;
		else {
			int sum = 0;
			for (int k = 0; k < 4; k++) sum += getSlot(i - k, j);
			sums[1] = sum;
		}
	}
	
	private void checkUp (int i, int j) {
		if (j < 3) sums[2] = 0;
		else {
			int sum = 0;
			for (int k = 0; k < 4; k++) sum += getSlot(i, j - k);
			sums[2] = sum;
		}
	}

	private void checkDown (int i, int j) {
		if (j > 2) sums[3] = 0;
		else {
			int sum = 0;
			for (int k = 0; k < 4; k++) sum += getSlot(i, j + k);
			sums[3] = sum;
		}
	}
	
	private void checkDiagLeftUp (int i, int j) {
		if (i < 3 || j < 3) sums[4] = 0;
		else {
			int sum = 0;
			for (int k = 0; k < 4; k++) sum += getSlot(i - k, j - k);
			sums[4] = sum;
		}
	}

	private void checkDiagRightUp (int i, int j) {
		if (i > 3 || j < 3) sums[5] = 0;
		else {
			int sum = 0;
			for (int k = 0; k < 4; k++) sum += getSlot(i + k, j - k);
			sums[5] = sum;
		}
	}

	private void checkDiagLeftDown (int i, int j) {
		if (i < 3 || j > 2) sums[6] = 0;
		else {
			int sum = 0;
			for (int k = 0; k < 4; k++) sum += getSlot(i - k, j + k);
			sums[6] = sum;
		}
	}

	private void checkDiagRightDown (int i, int j) {
		if (i > 3 || j > 2) sums[7] = 0;
		else {
			int sum = 0;
			for (int k = 0; k < 4; k++) sum += getSlot(i + k, j + k);
			sums[7] = sum;
		}
	}
}