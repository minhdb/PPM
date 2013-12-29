import java.awt.Color;

///////////////////////////////////////////////////////////////////////////////
//ALL STUDENTS COMPLETE THESE SECTIONS
//Title:            SheepMaster
//Files:            SheepMaster.java
//Semester:         CS302 Fall 2013
//
//Author:           Minh Bui
//Email:            minh@cs.wisc.edu or mbui2@wisc.edu
//CS Login:         minh
//Lecturer's Name:  Shreedhar Hardika
//Lab Section:      301
//
//PAIR PROGRAMMERS COMPLETE THIS SECTION
//Pair Partner:     null
//Email:            null
//CS Login:         null
//Lecturer's Name:  null
//Lab Section:      null
//
//STUDENTS WHO GET HELP FROM ANYONE OTHER THAN THEIR PARTNER
//Credits:          null
////////////////////////////80 columns wide //////////////////////////////////

/**
 * The Square class is responsible for drawing a filled square.
 * 
 * @author Minh Bui
 * 
 */
public class Square extends Shape {
	// The percentage of the square's side to the width of the image dimension.
	private double lengthP = 0;

	/**
	 * Constructor
	 * 
	 * @param color
	 * @param xPerc
	 * @param yPerc
	 * @param lengthP
	 */
	public Square(Color color, double xPerc, double yPerc, double lengthP) {
		super(color, xPerc, yPerc);
		// TODO Auto-generated constructor stub
		this.xRatio = xPerc;
		this.yRatio = yPerc;
		this.color = color;
		this.lengthP = lengthP;

	}

	/**
	 * This method take a PPM parameter and draws on it.
	 * 
	 * @param PPM
	 */
	public void drawTo(PPM PPM) {
		// Deal with the negative coordinates.
		if (xRatio < 0) {
			xRatio = 0;
		}
		if (yRatio < 0) {
			yRatio = 0;
		}
		// Must scale x,y to final ppm dimensions
		int c = (int) (xRatio * PPM.getWidth()); // get x-coord
		int r = (int) (yRatio * PPM.getHeight()); // get y-coord
		int side = (int) (lengthP * PPM.getWidth()); // get the side in pixels

		// Colors the pixels. The pixels will make up a square.
		for (int i = c; i < c + side; i++) {
			if (i == PPM.getWidth()) {
				return;			}
			for (int j = r; j < r + side; j++) {
				if (j == PPM.getHeight()) {
					j = r;
					break;
				} else {
					PPM.setPixel(j, i, color);
				}
			}
		}
	}
}
