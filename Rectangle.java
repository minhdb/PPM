import java.awt.Color;

///////////////////////////////////////////////////////////////////////////////
//ALL STUDENTS COMPLETE THESE SECTIONS
//Main Class File:  PortablePixelMapper.java
//File:             Rectangle.java
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
 * The Rectangle class is responsible for drawing a filled rectangle.
 * 
 * <p>
 * Bugs: none found.
 * 
 * @author Minh Bui
 * 
 */
public class Rectangle extends Shape {
	private double widthP;
	private double heightP;

	public Rectangle(Color color, double xPerc, double yPerc, double widthP,
			double heightP) {
		super(color, xPerc, yPerc);
		this.widthP = widthP;
		this.heightP = heightP;
		// TODO Auto-generated constructor stub
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
		// Must scale x,y to final PPM dimensions
		int c = (int) (xRatio * PPM.getWidth()); // get x-coord
		int r = (int) (yRatio * PPM.getHeight()); // get y-coord
		int w = (int) (PPM.getWidth() * widthP); // w is the real width in pixel
		// h is the real height in pixels
		int h = (int) (PPM.getHeight() * heightP);

		// Set the pixels to that color. The pixels will make up a rectangle.
		if (w < h) {
			for (int i = c; i < c + w; i++) {
				if (i == PPM.getWidth()) {
					return;
				}
				for (int j = r; j < r + h; j++) {
					if (j == PPM.getHeight()) {
						j = r;
						break;
					} else {
						PPM.setPixel(j, i, color);
					}
				}
			}

		} else {
			for (int i = r; i < r + h; i++) {
				if (i == PPM.getHeight()) {
					return;
				}
				for (int j = c; j < c + w; j++) {
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
