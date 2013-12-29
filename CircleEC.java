///////////////////////////////////////////////////////////////////////////////
//ALL STUDENTS COMPLETE THESE SECTIONS
//Main Class File:  PortablePixelMapperEC.java
//File:             CircleEC.java
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
 * This class is responsible for drawing a filled circle.
 * <br>
 * Bugs: none found
 * @author Minh Bui
 */

import java.awt.Color;

public class CircleEC extends ShapeEC {
	// For holding the percentage of radius to the image width.
	double radiusP = 0;

	/**
	 * Constructor
	 * @param color
	 * @param xPerc
	 * @param yPerc
	 * @param r
	 */
	public CircleEC(Color color, double xPerc, double yPerc, double r) {
		super(color, xPerc, yPerc);
		radiusP = r;
	}

	/**
	 * This method draws the specified circle on the PPM file.
	 * 
	 * @param PPM
	 * @return
	 */
	public void drawTo(PPMEC PPM) {
		// Must scale x,y to final PPM dimensions
		// get x-coord
		int c = (int) (xRatio * PPM.getWidth());
		// get y-coord
		int r = (int) (yRatio * PPM.getHeight());
		int radius = (int) (radiusP * PPM.getWidth()); // Radius of R.
		// Scan through the pixels and try to see if any pixel is within the
		// range of radius. If found, colored that pixels.
		for (int i = 0; i < PPM.getHeight(); i++) {
			for (int j = 0; j < PPM.getWidth(); j++) {
				// d is the distance between the traversing point and the circle
				// origin.
				int d = (r - i) * (r - i) + (c - j) * (c - j);
				if (d <= radius * radius) {
					PPM.setPixel(i, j, color);
				}
			}
		}
	}
}
// }
