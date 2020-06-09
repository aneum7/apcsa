package apcsa;

public class Board {
	// slots[x coordinate starting from top left][y coordinate starting from top left]
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
		for (int i = 0; i < 7; i++) {
			for (int j = 0; j < 6; j++) {
				if (checkLeft(i,j) != 0 || checkRight(i,j) != 0 || checkForDiagonalLeftWin(i,j) != 0 ||
						checkForDiagonalRightWin(i,j) != 0 || checkDown(i,j) != 0) {
					return Slots[i][j];
				}
			}
		}
		return 0;
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
	/**
	 * looks to the diagonal right for a win (3 additional)
	 * returns 2 for blue win
	 * returns 1 for red win returns 0 for no win
	 */
	public int checkForDiagonalRightWin(int i, int j) {
		int count = 0;
		try {
			for (int t = 1; t < 4; t++) {
				if (Slots[j][i] == Slots[j + t][i + t]) {
					count++;
				}
			}
		} catch (Exception e) {
			return 0;
		}
		if (count == 3) {
			return Slots[j][i];
		} else {
			return 0;
		}
	}
	
	/**
	 * looks to the diagonal left for a win (3 additional)
	 * returns 2 for blue win
	 * returns 1 for red win returns 0 for no win
	 */
	public int checkForDiagonalLeftWin(int i, int j) {
		int count = 0;
		try {
			for (int t = 1; t < 4; t++) {
				if (Slots[j][i] == Slots[j - t][i + t]) {
					count++;
				}
			}
		} catch (Exception e) {
			return 0;
		}
		if (count == 3) {
			return Slots[j][i];
		} else {
			return 0;
		}
	}
}