import java.awt.Color;
import java.awt.Font;

import javax.swing.UIManager;
import javax.swing.plaf.FontUIResource;

/**
 * This class contains class (static) methods
 * that will help you test the Picture class 
 * methods.  Uncomment the methods and the code
 * in the main to test.  This is a great lesson for learning 
 * about 2D arrays and the Color class.
 * 
 * @author Barbara Ericson 
 */
public class PictureTester
{

	/** Main method for testing.  Every class can have a main
	 * method in Java */
	public static void main(String[] args)
	{
		UIManager.put("TextArea.messageFont", new FontUIResource(new Font("CALIBRI",Font.PLAIN,50))); 
		UIManager.put("OptionPane.font", new FontUIResource(new Font("ARIAL",Font.PLAIN,50))); 
		UIManager.put("TextField.font", new FontUIResource(new Font("ARIAL",Font.PLAIN,50))); 
		UIManager.put("OptionPane.buttonFont", new FontUIResource(new Font("ARIAL",Font.PLAIN,40))); 
		UIManager.put("JLabel", new FontUIResource(new Font("CALIBRI",Font.PLAIN,50))); 
		UIManager.put("OptionPane.font", new FontUIResource(new Font("ARIAL",Font.PLAIN,50))); 
		UIManager.put("TextField.font", new FontUIResource(new Font("ARIAL",Font.PLAIN,50))); 


		/*
		 * You will write the methods that do the following
		 * 
		 */
		//testZeroBlue();
		//testKeepOnlyBlue();
		//testKeepOnlyRed();
		//testKeepOnlyGreen();
		//testNegate();
		//testGrayscale();
		//testEdgeDetection();
		//    testEdgeDetection2();
		//testFixUnderwater();
		//testMirrorVertical();
		//    testMirrorTemple();
		//    testMirrorArms();
		//    testMirrorGull();
		//    testMirrorDiagonal();
		//    testCollage();
		//    testCopy();

		//    testChromakey();
		//testEncodeAndDecode();  // use png, gif or bmp because of compression
		//    testGetCountRedOverValue(250);
		//    testSetRedToHalfValueInTopHalf();
		//    testClearBlueOverValue(200);
		//    Color avgColor = testGetAverageForColumn(pic, col);// specified column 
	}
	/** Method to test zeroBlue */
	public static void testZeroBlue()
	{
		Picture beach = new Picture("beach.jpg");
		Pixel[][] pixels = beach.getPixels2D();
		for (Pixel[] rowArray : pixels)
		{
			for (Pixel pixelObj : rowArray)
			{
				pixelObj.setBlue(0);
				int gr = pixelObj.getGreen();
				pixelObj.setGreen(gr/2);
				int rd = pixelObj.getRed();
				pixelObj.setRed(rd*2);

			}
		}
		beach.explore(); 
	}

	private static void testKeepOnlyBlue() {
		Picture beach = new Picture("beach.jpg");
		Pixel[][] pixels = beach.getPixels2D();
		for (Pixel[] rowArray : pixels)
		{
			for (Pixel pixelObj : rowArray)
			{
				pixelObj.setGreen(0);
				pixelObj.setRed(0);

			}
		}
		beach.explore();
	}

	private static void testKeepOnlyGreen() {
		Picture beach = new Picture("beach.jpg");
		Pixel[][] pixels = beach.getPixels2D();
		for (Pixel[] rowArray : pixels)
		{
			for (Pixel pixelObj : rowArray)
			{
				pixelObj.setBlue(0);
				pixelObj.setRed(0);

			}
		}
		beach.explore();

	}

	private static void testKeepOnlyRed() {
		Picture beach = new Picture("beach.jpg");
		Pixel[][] pixels = beach.getPixels2D();
		for (Pixel[] rowArray : pixels)
		{
			for (Pixel pixelObj : rowArray)
			{
				pixelObj.setGreen(0);
				pixelObj.setBlue(0);

			}
		}
		beach.explore();
	}

	private static void testNegate() {
		// Turns a Picture into its negative
		Picture beach = new Picture("beach.jpg");
		beach.explore();
		Pixel[][] pixels = beach.getPixels2D();
		for (Pixel[] rowArray : pixels)
		{
			for (Pixel pixelObj : rowArray)
			{
				int gr = pixelObj.getGreen();
				int rd = pixelObj.getRed();
				int bl = pixelObj.getBlue();
				pixelObj.setBlue(255-bl);
				pixelObj.setGreen(255-gr);
				pixelObj.setRed(255-rd);
			}
		}
		beach.explore();


	}


	private static void testGrayscale() {
		Picture beach = new Picture("beach.jpg");
		Pixel[][] pixels = beach.getPixels2D();
		for (Pixel[] rowArray : pixels) 
		{
			for (Pixel pixelObj : rowArray) {
				int mean = ((pixelObj.getBlue()) +(pixelObj.getGreen()) + (pixelObj.getRed())/(3));
				pixelObj.setBlue(mean);
				pixelObj.setGreen(mean);
				pixelObj.setRed(mean);
			}
		}
		beach.explore();
	}

	/** Method to test edgeDetection */
	public static void testEdgeDetection()
	{ 
		int col = 0;
		int row = 0;
		Picture swan = new Picture("swan.jpg");
		Pixel[][] pixels = swan.getPixels2D();
		swan.explore();
		for (Pixel[] rowArray : pixels) {
			for (Pixel pixelObj : rowArray) {
				int end = rowArray.length-1;
				Pixel currentPixel = pixels[row][col];
				Pixel right = null;
				if(col< end) {
					right = pixels[row][col+1];
				}
				else {
					right = pixels[row][col];
				}
				Color rightPixel = right.getColor();
				if(currentPixel.colorDistance(rightPixel) < 7) {
					pixelObj.setBlue(255);
					pixelObj.setRed(255);
					pixelObj.setGreen(255);
				}
				else {
					pixelObj.setBlue(0);
					pixelObj.setRed(0);
					pixelObj.setGreen(0);
				}
				col++;
			}
			col = 0;
			row++;
		}

		// You need to write the edgeDetection method.  The larger the 
		// input value, the farther
		//swan.edgeDetection(10);
		swan.explore();
		swan.write("swan outline.jpg");// writes the new picture to a new file
	}
	/** Method to test mirrorVertical */
	public static void testMirrorVertical()
	{
		int row = 0;
		int col = 0;
		Picture caterpillar = new Picture("caterpillar.jpg");
		Pixel[][] pixels = caterpillar.getPixels2D();
		caterpillar.explore();
		for (Pixel[] rowArray : pixels) {
			int midline = (rowArray.length-1)/(2);
			for (int i = 0;i<=midline;i++) {
				Color temp = pixels [row][col].getColor();
				pixels[row][col].setColor( pixels[row][rowArray.length-1-col].getColor());
				pixels[row][rowArray.length-1-col].setColor(temp);
				++col;
			}
			col = 0;
			++row;
		}
		// this should take the left-hand half of the picture and reflect it across 
		// the vertical midline.
		//caterpillar.mirrorVertical();// need to write this method in the picture class
		caterpillar.explore();
	}

	/** Method to test mirrorTemple */
	public static void testMirrorTemple()
	{
		Picture temple = new Picture("temple.jpg");
		temple.explore();
		temple.mirrorTemple();// this method creates a mirror image for a section of its
		// pixels.  What would happen if we used a different starting 
		// image?  Is mirrorTemple a useful method in the long run?  How
		// could you change it so that it would be more useful?
		temple.explore();
	}

	/** Method to test the collage method */
	public static void testCollage()
	{
		Picture canvas = new Picture("640x480.jpg");
		canvas.createCollage();// this method has been written in the Picture class
		// how can it be changed so that we could pass in 
		// pictures that could be added to a collage?
		canvas.explore();
	}


	/*so, you have a choice for this one and the methods that follow.  You can write the
	 * code in the methods below or you can add functionality to the picture class.  Sometimes
	 * it makes sense to add it to the class for reusability reasons.  Sometimes it is too unique
	 * a need to add to the class. 
	 */

	// So, you can create a Picture Object and find the average value of 
	// the component in that column
	private static Color testGetAverageForColumn(Picture pic, int col) {
		Color avg = null;

		return avg;
	}

	// so for this one, any pixels that have blue over a certain value are set 
	// to no blue at all.  Or for a different effect, have those pixels set to black.
	private static void testClearBlueOverValue(int i) {


	}

	// goes to each pixel in the top half and cuts the red component in half
	// So, bottom half of pic should look normal
	private static void testSetRedToHalfValueInTopHalf() {


	}
	// displays the number of pixels in the pic that have a red component
	// greater than the specifies int.
	private static void testGetCountRedOverValue(int i) {


	}

	/*
	 * The method below is really cool!!  Use the following approach:
	 * go through the entire Picture (the one to carry the message), 
	 * and make the red component of every pixel an even number.  
	 * To do this, mod by 2 and see if remainder>0.  If so, add or 
	 * subtract one (subtracting is safer. Why?) 
	 * Then, using a Picture of a message (one color on white background), 
	 * any pixel from Picture of message that is not white causes you to 
	 * add one to the corresponding pixel's red component of the 
	 * encoded picture (the one with all even red components).
	 * 
	 * Then you can send along the encoded picture to someone else and they should 
	 * be able to 
	 */
	private static void testEncodeAndDecode() {
		
		Picture message = new Picture("msg.jpg");
		Pixel[][] pixels2 = message.getPixels2D();
		Picture beach = new Picture("beach.jpg");
		Pixel[][] pixels = beach.getPixels2D();
		beach.explore();
		for (Pixel[] rowArray : pixels) {
			for (Pixel pixelObj : rowArray) {
				int red = (pixelObj.getRed())/(2);
				int red2 = red*2;
				pixelObj.setRed(red2);
			}
		}
		int row = 0;
		int col = 0;
		for (Pixel[] rowArray : pixels2) {
			for (Pixel pixelObj : rowArray) {
				if(pixelObj.getRed() == 0) {
					int red = pixels[row][col].getRed();
					pixels[row][col].setRed(red+1);
				}
				++col;
			}
				++row;
				col= 0;
	
		}
		beach.explore();
		for (Pixel[] rowArray : pixels) {
			for (Pixel pixelObj : rowArray) {
				int red = pixelObj.getRed();
				int red1 = red/2;
				int red2 = red1*2;
				if(red2 != red) {
					pixelObj.setRed(0);
					pixelObj.setBlue(0);
					pixelObj.setGreen(0);
				}
				else {
					pixelObj.setRed(255);
					pixelObj.setBlue(255);
					pixelObj.setGreen(255);
					
				}
			}
				
			}
		beach.explore();
		message.explore();
	}

	private static void testChromakey() {
		// chroma key means to superimpose one image over another.  The image to be
		// drawn over the other one, only draws the pixels that aren't the chroma key
		// The common name for this is green screen

	}

	private static void testEdgeDetection2() {
		// This method looks for high contrast pixels.  If two adjacent pixels are relatively
		// far apart (in terms of color) then one pixel is set to black, otherwise, white.

	}


	private static void testCopy() {
		// copies a picture onto another

	}

	private static void testMirrorDiagonal() {
		// Creates a new Picture that creates a mirror image along one diagonal

	}

	private static void testMirrorGull() {
		// creates a mirror image of a bird making image look like bird is over water

	}

	private static void testMirrorArms() {
		// TODO Auto-generated method stub

	}
	/** This method is an effort to make a Picture taken underwater look
	 * more like it would be if the water were drained
	 */
	private static void testFixUnderwater() {

	}

}