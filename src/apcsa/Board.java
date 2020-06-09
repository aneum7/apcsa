package apcsa;

public class Board {
	// slots[x coordinate starting from top left][y coordinate starting from top left]
	private Slot[][] Slots = new Slot[7][6];

	Board() {

	}

	/**
	 * looks throughout the board for a win (4 in a row)
	 * returns 2 for blue win
	 * returns 1 for red win returns 0 for no win
	 */
	public int checkForWin() {
		for (int i = 0; i < 7; i++) {
			for (int j = 0; j < 6; j++) {
				if (checkForLeftWin(i,j) != 0 || checkForRightWin(i,j) != 0 || checkForDiagonalLeftWin(i,j) != 0 ||
						checkForDiagonalRightWin(i,j) != 0 || checkForDownWin(i,j) != 0) {
					return Slots[i][j].getType();
				}
			}
		}
		return 0;
	}

	/**
	 * looks to the left for a win (3 additional)
	 * returns 2 for blue win
	 * returns 1 for red win returns 0 for no win
	 */
	public int checkForLeftWin(int i, int j) {
		int count = 0;
		try {
			for (int t = 1; t < 4; t++) {
				if (Slots[j][i].getType() == Slots[j - t][i].getType()) {
					count++;
				}
			}
		} catch (Exception e) {
			return 0;
		}
		if (count == 3) {
			return Slots[j][i].getType();
		} else {
			return 0;
		}
	}

	/**
	 * looks to the right for a win (3 additional)
	 * returns 2 for blue win
	 * returns 1 for red win returns 0 for no win
	 */
	public int checkForRightWin(int i, int j) {
		int count = 0;
		try {
			for (int t = 1; t < 4; t++) {
				if (Slots[j][i].getType() == Slots[j + t][i].getType()) {
					count++;
				}
			}
		} catch (Exception e) {
			return 0;
		}
		if (count == 3) {
			return Slots[j][i].getType();
		} else {
			return 0;
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
				if (Slots[j][i].getType() == Slots[j + t][i + t].getType()) {
					count++;
				}
			}
		} catch (Exception e) {
			return 0;
		}
		if (count == 3) {
			return Slots[j][i].getType();
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
				if (Slots[j][i].getType() == Slots[j - t][i + t].getType()) {
					count++;
				}
			}
		} catch (Exception e) {
			return 0;
		}
		if (count == 3) {
			return Slots[j][i].getType();
		} else {
			return 0;
		}
	}
	
	/**
	 * looks down for a win (3 additional)
	 * returns 2 for blue win
	 * returns 1 for red win returns 0 for no win
	 */
	public int checkForDownWin(int i, int j) {
		int count = 0;
		try {
			for (int t = 1; t < 4; t++) {
				if (Slots[j][i].getType() == Slots[j][i + t].getType()) {
					count++;
				}
			}
		} catch (Exception e) {
			return 0;
		}
		if (count == 3) {
			return Slots[j][i].getType();
		} else {
			return 0;
		}
	}
}
