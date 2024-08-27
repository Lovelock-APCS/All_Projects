import kareltherobot.Robot;

public class SortableRobot extends Robot implements SortableBotInterface {

	public SortableRobot(int street, int avenue, int numBeepers) {
		super(street, avenue, North, numBeepers);


	}

	@Override
	public void turnRight() {
		turnLeft();
		turnLeft();
		turnLeft();

	}

	@Override
	public void turnAround() {
		turnLeft();
		turnLeft();

	}

	@Override
	public void slideLeft(int steps) {
		int times = 0;
		while(steps>times) {
			turnLeft();
			move();
			turnRight();
			++times;
		}
	}

	@Override
	public void slideRight(int steps) {
		int times = 0;
		while(steps>times) {
			turnRight();
			move();
			turnLeft();
			++times;
		}

	}

	@Override
	public void showAllBeeps() {
		while (anyBeepersInBeeperBag()) {
			putBeeper();
			move();
		}


	}

	@Override
	public int getNumBeeps() {
		int numBeepers = beepers();
		return numBeepers;
	}

	@Override
	public int getLocation() {
		int loc1 = avenue();
		
		return loc1;
	}

	@Override
	public void moveToLocation(int[] loc) {
		

	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
