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
////////////////////////////80 columns wide ///////////////////////////////////

/**
 * The Ring class is responsible for drawing a filled ring.
 * 
 * <p>
 * Bugs: none found.
 * 
 * @author Minh Bui
 * 
 */

public class Ring2 extends Shape {
	double radiusInP = 0;
	double radiusOutP = 0;
	int c;
	int r;

	/**
	 * Constructor
	 * 
	 * @param color
	 * @param xPerc
	 * @param yPerc
	 * @param inR
	 * @param outR
	 */
	public Ring2(Color color, double xPerc, double yPerc, double outR,
			double inR) {
		super(color, xPerc, yPerc);
		radiusInP = inR;
		radiusOutP = outR;

	}

	public void drawTo(PPM PPM) {
		int c = (int) (xRatio * PPM.getWidth()); // get x-coord
		int r = (int) (yRatio * PPM.getHeight()); // get y-coord
		int radiusOut = (int) (radiusOutP * PPM.getWidth()); // Radius of R.
		int radiusIn = (int) (radiusInP * PPM.getWidth()); // Radius of R.
		for (int i = 0; i < PPM.getHeight(); i++) {
			for (int j = 0; j < PPM.getWidth(); j++) {
				int d = (r - i) * (r - i) + (c - j) * (c - j);
				if (d <= radiusOut * radiusOut && d >= radiusIn * radiusIn) {
					PPM.setPixel(i, j, color);
				}
			}
		}
	}
}