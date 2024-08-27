import javax.swing.JOptionPane;
import java.util.Random;
import kareltherobot.Directions;
import kareltherobot.Robot;
import kareltherobot.World;


public class SortRobotDriver implements Directions {

	public static void main(String[] args) {
		new SortRobotDriver().start();
	}

	private void start() {





		//1. input number of robots, and max number of beeps
		String numberOfRobots = "" + 10;//JOptionPane.showInputDialog("How many robots do you want?");
		String maxBeepers = "" + 10; //JOptionPane.showInputDialog("What is the max number of beepers a robot should have?");
		int numOfRobots = Integer.parseInt(numberOfRobots);
		int maxBeeps = Integer.parseInt(maxBeepers);
		createWorld(maxBeeps, numOfRobots);


		//2. create that number of robots (from part 1) with max number
		// of beeps, and place into an array and return that array to here.
		SortableRobot [] bots  = new SortableRobot [numOfRobots];
		for (int b = 0;b < numOfRobots; ++b) {
			int beepers = (int)(Math.random() * (maxBeeps));
			bots[b] = new SortableRobot(1, b+1, beepers);
		}

		//3. Find robot with min # of beeps. Have that bot show all beeps
		int minBeeps = 0;
		for(int x=0; x<numOfRobots-1; x++) {

			if (bots[x].getNumBeeps() < minBeeps) {
				minBeeps = bots[x].getNumBeeps();

			}
		}

		//4. Repeat looking for max # of beeps.
		int mostBeeps = 0;
		for(int x=0; x<numOfRobots-1; x++) {

			if (bots[x].getNumBeeps() > mostBeeps) {
				mostBeeps = bots[x].getNumBeeps();

			}
		}


		//Now sort 
		//A.  BubbleSort


		//				for (int y = 0; y< numOfRobots; y++) {
		//					for(int x=0; x<numOfRobots-1; x++) {
		//						if (bots[x].getNumBeeps() >= bots[x+1].getNumBeeps()) {
		//							bots[x].slideRight(1);
		//							bots[x+1].slideLeft(1);
		//							SortableRobot temp = bots[x];
		//							bots [x] = bots[x+1];
		//							bots[x+1] = temp;
		//						}
		//		
		//					}
		//		
		//				}
		//				for(int i=0;i<numOfRobots;i++) {
		//					bots[i].showAllBeeps();
		//				}

		//B.  SelectionSort
		for (int i = 0; i<numOfRobots;i++) {
			int waterBottle = bots[i].getNumBeeps();
			int locOfMin = 0;
			for(int x=i; x<numOfRobots-1-i; x++) {
				if (waterBottle > bots[+1].getNumBeeps()) {
					waterBottle = bots[x+1].getNumBeeps();
					locOfMin = bots[x+1].getLocation();
					
				}
			}
		
			bots[locOfMin-1].slideLeft(locOfMin-1-i);
			bots[i].slideRight(locOfMin-1);
			SortableRobot temp = bots[locOfMin-1];
			bots[locOfMin-1] = bots[i];
			bots[i] = temp;
		
			
			
		}
	}



	//		int x = 0;
	//		for (int i = 0; i<numOfRobots;i++) {
	//			for( x=0; x<numOfRobots-1; x++) {
	//				if (bots[x+i].getNumBeeps() < bots[x+1+i].getNumBeeps()) {
	//					bots[x].slideRight(1);
	//					bots[x+1].slideLeft(1);
	//					SortableRobot temp = bots[x];
	//					bots [x] = bots[x+1];
	//					bots[x+1] = temp;
	//			}
	//			}
	//			bots[x].slideLeft(x);
	//			SortableRobot temp = bots[x];
	//			bots[x] = bots[i];
	//			bots[i].slideRight(x-i);
	//			bots[i] = temp;
	//			
	//			
	//			System.out.println("you are in i loop");
	//		}
	//
	//		for(int i=0;i<numOfRobots;i++) {
	//			bots[i].showAllBeeps();
	//		}
	//	}





	//C.  InsertionSort
	//D.  QuickSort
	//E.  MergeSort


	//System.out.println("The least beepers was " +minBeeps);
	//System.out.println("The most beepers was " +mostBeeps);







	private void createWorld(int maxBeeps, int numOfRobots) {
		World.setVisible(true);
		World.setDelay(14);
		World.setSize(maxBeeps +1,numOfRobots+1);

	}



}
