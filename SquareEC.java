import java.awt.Color;

///////////////////////////////////////////////////////////////////////////////
//ALL STUDENTS COMPLETE THESE SECTIONS
//Main Class File:  PortablePixelMapperEC.java
//File:             SquareEC.java
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
 * The Square class is responsible for drawing a filled square.
 * 
 * @author Minh Bui
 * 
 */
public class SquareEC extends ShapeEC {
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
	public SquareEC(Color color, double xPerc, double yPerc, double lengthP) {
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
	public void drawTo(PPMEC PPM) {
		int r = 0;
		int c = 0;
		int side1 = 0;
		int side2 = 0;

		if (xRatio < 0) {
			c = 0;
			side1 = (int) (lengthP * PPM.getWidth() - (-xRatio)
					* PPM.getWidth());
		} else {
			c = (int) (xRatio * PPM.getWidth()); // get x-coord
			side1 = (int) (lengthP * PPM.getWidth()); // w is the real width in
														// pixel
		}
		if (yRatio < 0) {
			r = 0;
			side2 = (int) (lengthP * PPM.getWidth() - (-yRatio)
					* PPM.getWidth());
		} else {
			r = (int) (yRatio * PPM.getHeight()); // get y-coord
			side2 = (int) (lengthP * PPM.getWidth());
		}

		// Set the pixels to that color. The pixels will make up a rectangle.
		if (side1 < side2) {
			for (int i = c; i < c + side1; i++) {
				if (i == PPM.getWidth()) {
					return;
				}
				for (int j = r; j < r + side2; j++) {
					if (j == PPM.getHeight()) {
						j = r;
						break;
					} else {
						PPM.setPixel(j, i, color);
					}
				}
			}

		} else {
			for (int i = r; i < r + side2; i++) {
				if (i == PPM.getHeight()) {
					return;
				}
				for (int j = c; j < c + side1; j++) {
					if (j == PPM.getWidth()) {
						j = c;
						break;
					} else {
						PPM.setPixel(i, j, color);
					}
				}
			}
		}
	}
}
