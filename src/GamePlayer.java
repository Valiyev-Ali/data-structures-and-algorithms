import java.util.Random;

// import game.Game;

public class GamePlayer {
	// state
	private static int[][] gameMap;
	private static boolean [][] visitedLocations;
	private static int currentX;
	private static int currentY;
	
	// solution test
	private static boolean isSolution() {
		return gameMap[currentX][currentY] == 1;
	}
	
	private static void moveDown() {
		currentX++;
		visitedLocations[currentX][currentY] = true;
		System.out.println("Moved to " + currentX + ", " + currentY);
	}
	private static void moveUp() {
		currentX--;
		visitedLocations[currentX][currentY] = true;
		System.out.println("Moved to " + currentX + ", " + currentY);
	}
	private static void moveRight() {
		currentY++;
		visitedLocations[currentX][currentY] = true;
		System.out.println("Moved to " + currentX + ", " + currentY);
	}
	private static void moveLeft() {
		currentY--;
		visitedLocations[currentX][currentY] = true;
		System.out.println("Moved to " + currentX + ", " + currentY);
	}
	
	private static boolean canMoveDown() {
		if ((currentX == 4) || visitedLocations[currentX + 1][currentY]) {
			return false;
		}
		return true;
	}
	private static boolean canMoveRight() {
		if ((currentY == 4) || visitedLocations[currentX][currentY + 1]) {
			return false;
		}
		return true;
	}
	
	private static boolean exploreDown() {
		if (canMoveDown()) {
			moveDown();
			if (isSolution()) {
				System.out.println("Treasure found at " + currentX + ", " + currentY);
				return true;
			}
			boolean solution = exploreDown();
			if (solution) {
				return true;
			}
			else {
				solution = exploreRight();
				if (solution) {
					return true;
				}
				else {
					moveUp();
					return false;
				}
			}
		}
		else {
			return exploreRight();
		}
	}
	
	private static boolean exploreRight() {
		if (canMoveRight()) {
			moveRight();
			if (isSolution()) {
				System.out.println("Treasure found at " + currentX + ", " + currentY);
				return true;
			}
			boolean solution = exploreDown();
			if (solution) {
				return true;
			}
			else {
				solution = exploreRight();
				if (solution) {
					return true;
				}
				else {
					moveLeft();
					return false;
				}
			}
		}
		else {
			return false;
		}
	}
	
	public static void main(String[] args) {
		// define the initial state
		gameMap = new int[5][5];
		Random numberGenerator = new Random();
		int treasureX = numberGenerator.nextInt(5);
		int treasureY = numberGenerator.nextInt(5);
		gameMap[treasureX][treasureY] = 1;
		System.out.println("Treasure location: [" + treasureX + ", " + treasureY + "]");
		visitedLocations = new boolean[5][5];
		currentX = 0;
		currentY = 0;
		visitedLocations[currentX][currentY] = true;
		System.out.println("Starting at " + currentX + ", " + currentY);
		if (isSolution()) {
			System.out.println("Treasure found at " + currentX + ", " + currentY);
		}
		else { // start exploring / searching for the solution state
			exploreDown();
		}
		
	}
}
