import java.awt.Color;

///////////////////////////////////////////////////////////////////////////////
//ALL STUDENTS COMPLETE THESE SECTIONS
//Main Class File:  PortablePixelMapperEC.java
//File:             RingEC.java
//Semester:         CS302 Fall 2013
//
//Author:           Minh Bui
//CS Login:         minh
//Lecturer's Name:  Shreed Hardika
//Lab Section:      301
//
//PAIR PROGRAMMERS COMPLETE THIS SECTION
//Pair Partner:     null
//CS Login:         null
//Lecturer's Name:  null
//Lab Section:      null
//
//STUDENTS WHO GET HELP FROM ANYONE OTHER THAN THEIR PARTNER
//Credits:          null
////////////////////////////80 columns wide //////////////////////////////////

/**
 * The Ring class is responsible for drawing a filled ring.
 * 
 * <p>
 * Bugs: none found.
 * 
 * @author Minh Bui
 * 
 */

public class RingEC extends ShapeEC {
	// For holding the percentage of radius of the inside circle to the image
	// width.
	double radiusInP = 0;
	// For holding the percentage of radius of the outside circle to the image
	// width.
	double radiusOutP = 0;

	/**
	 * Constructor
	 * 
	 * @param color
	 * @param xPerc
	 * @param yPerc
	 * @param inR
	 * @param outR
	 */
	public RingEC(Color color, double xPerc, double yPerc, double outR,
			double inR) {
		super(color, xPerc, yPerc);
		radiusInP = inR;
		radiusOutP = outR;

	}

	/**
	 * Draw the Ring to the PPM object.
	 * 
	 * @param PPM
	 * 
	 */

	public void drawTo(PPMEC PPM) {
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