import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.awt.Event;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.Timer;

import info.gridworld.grid.BoundedGrid;
import info.gridworld.grid.Location;
import info.gridworld.world.World;

public class BejeweledBoard {
	
	
	public int score;
	public static final int TICK_DELAY = 10, MAX_TICKS = 2500;// milliseconds between ticks of clock
	public final static int NUM_ROWS = 8, NUM_COLS = 8;
	private Jewel[][] jewelBoard = new Jewel[NUM_ROWS][NUM_COLS];
	// ticks of the clock left until time runs out!!  If you increase your score
	// ticksLeft will be increased.
	public int ticksLeft = MAX_TICKS;
	// firstClick is true if the user is selecting the first jewel
	// firstClick is false if the user is selecting the second jewel
	protected boolean firstClick = true;
	
	// This is only used for display purposes.  After making changes to the 
	// jewelBoard, call show which updates this display.  Do not make any changes
	// to the World code below
	private World display = new World(new BoundedGrid(this.NUM_ROWS,this.NUM_COLS)) {
		
		@Override
		public boolean locationClicked(Location loc) {
			// LEAVE THIS FUNCTION ALONE!!
			if(firstClick ) {
				firstClick(loc);
			}
			else {
				secondClick(loc);
			}
			return true;
		}
	};
	
	// this timer is used to count down to zero.
	private Timer ticker;
	protected int decrement = 1;
	
	public static void main(String[] args) {
		new BejeweledBoard();
	}
	
	public BejeweledBoard() {
		fillEmptySpots();
		display.show();// this is done only once to make the world visible
		ticker = new Timer(this.TICK_DELAY, new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				ticksLeft-= decrement ;
				display.setMessage("Score: "+score+"\nTime left: "+ticksLeft);
			}
			
		});
		ticker.start();
		updateView();
	}
	
/*
 * This method fills up any spots on the board that are empty.  This will only be
 * called if jewels have dropped already, thus filling in tops of columns.
 */
	private void fillEmptySpots() {
		//Obviously, this is not how fill empty spots should be written
		jewelBoard[3][5] = new OrangeJewel();
		jewelBoard[2][4] = new RedJewel();
		jewelBoard[1][5] = new RedJewelHighlighted();
		
	}
	
	/*
	 * This method drops any jewels that are above opened spaces.  It MUST maintain
	 * relative locations vertically with jewels that are above it.  DO NOT fill in 
	 * empty spots with new jewels. 
	 */
	private void dropJewels() {
		
	}
	
	// This should be called when the user is clicking the first jewel to swap
	// the jewel at this location should be highlighted!
	protected void firstClick(Location loc) {
		this.jewelBoard[loc.getRow()][loc.getCol()]=new RedJewelHighlighted();
		
		this.updateView();
	}
	// this should be called when the user is clicking the second jewel to swap
	// with first.  Replace the Jewel at this location with a highlighted version 
	// of this Jewel.  Swap with the first clicked Jewel.  Now check for 3 in a rows
	// If there are no 3-in-a-rows then swap back and replace with non-highlighted
	// versions and set back to first click!!
	protected void secondClick(Location loc) {
		
		
	}
// checks for jewels that are part of 3 in a row or more horizontally or vertically 
	// across the entire board.  Any Locations that make up a 3 in a row or more are
	// placed into the list constructed in this array.  Someone who uses this method
	// knows no matches are on the board if the returned list is empty.
	private ArrayList<Location> find3OrMore(){
		ArrayList<Location> list = find3OrMoreHor();
		list.addAll(find3OrMoreVert());
		
		return list;
	}

	private ArrayList<Location> find3OrMoreVert() {
		// TODO Auto-generated method stub
		return null;
	}
	private ArrayList<Location> find3OrMoreHor() {
		// TODO Auto-generated method stub
		return null;
	}
	/*
	 * This method is used after every call to fillEmptySpots to make 
	 * sure that there is still at least one move possible.  
	 * 
	 * One strategy:  swap each jewel with an adjacent jewel, see if there are any 
	 * matches on the board.  Keep doing this until you find a swap that would make a 
	 * 3-in-a-row.
	 */
	private boolean atLeastOneMovePossible() {
		
		return true;
	}
	// add to score and ticksLeft
	public void updateScore() {
		
	}
	
	
	// LEAVE THIS ALONE!!!!
	private void updateView() {
		for(int r = 0; r<jewelBoard.length; r++) {
			for(int c = 0; c< jewelBoard[r].length;c++) {
				Jewel jwl = jewelBoard[r][c];
				if(jwl != null) {
					System.out.println("Displaying "+jwl);
					
					display.add(new Location(r,c),jwl);
				}
					
			}
		}
	}
	

}
