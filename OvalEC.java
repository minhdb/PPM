import java.awt.Color;

///////////////////////////////////////////////////////////////////////////////
//ALL STUDENTS COMPLETE THESE SECTIONS
//Main Class File:  PortablePixelMapperEC.java
//File:             OvalEC.java
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
 * The OvalEC class is responsible for drawing a filled ellipse.
 * 
 * @author Minh Bui
 * 
 */

public class OvalEC extends ShapeEC {

	// Ratio of the coordinates for the first focus point
	private double xRatio1;
	private double yRatio1;
	// Ratio of the coordinates for the second focus point
	private double xRatio2;
	private double yRatio2;
	// Ratio of the distance of the evolutes to the foci.
	private double distR;

	/**
	 * Constructor
	 * 
	 * @param color
	 * @param xPerc
	 * @param yPerc
	 * @param lengthP
	 */
	public OvalEC(Color color, double xRatio1, double yRatio1, double xRatio2,
			double yRatio2, double distRatio) {
		super(color, xRatio1, yRatio1);
		this.xRatio1 = xRatio1;
		this.xRatio2 = xRatio2;
		this.yRatio1 = yRatio1;
		this.yRatio2 = yRatio2;
		distR = distRatio;

	}

	/**
	 * This method take a PPM parameter and draws on it.
	 * 
	 * @param PPM
	 */
	public void drawTo(PPMEC PPM) {
		// Calculate the parameters for the ellipse.
		int x1 = (int) (xRatio1 * PPM.getWidth());
		int x2 = (int) (xRatio2 * PPM.getWidth());
		int y1 = (int) (yRatio1 * PPM.getHeight());
		int y2 = (int) (yRatio2 * PPM.getHeight());
		int distance = (int) (distR * PPM.getWidth());

		// Fill those pixels if d1 + d2 is in the range of distance.
		for (int i = 0; i < PPM.getHeight(); i++) {
			for (int j = 0; j < PPM.getWidth(); j++) {
				double d1 = Math
						.sqrt((x1 - j) * (x1 - j) + (y1 - i) * (y1 - i));
				double d2 = Math
						.sqrt((x2 - j) * (x2 - j) + (y2 - i) * (y2 - i));
				if ((d1 + d2) <= distance) {
					PPM.setPixel(i, j, color);
				}
			}
		}
	}

}
