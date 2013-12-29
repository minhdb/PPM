import java.awt.Color;

///////////////////////////////////////////////////////////////////////////////
//ALL STUDENTS COMPLETE THESE SECTIONS
//Main Class File:  PortablePixelMapperEC.java
//File:             RectangleEC.java
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
public class RectangleEC extends ShapeEC {
	//Percentage of the rectangle to the PPM dimension.
	private double widthP;
	private double heightP;
	
	/**
	 * Constructor
	 * @param color
	 * @param xPerc
	 * @param yPerc
	 * @param widthP
	 * @param heightP
	 */
	
	public RectangleEC(Color color, double xPerc, double yPerc, double widthP,
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

	public void drawTo(PPMEC PPM) {
		int c = 0;
		int r = 0;
		int w = 0;
		int h = 0;
		
		// Deal with the negative coordinates.
		if (xRatio < 0) {
			c = 0;
			w = (int) ((PPM.getWidth() * widthP) - (-xRatio)*PPM.getWidth());
		}
		else
		{
			c = (int) (xRatio * PPM.getWidth()); // get x-coord
			w = (int) (PPM.getWidth() * widthP); // w is the real width in pixel
		}
		if (yRatio < 0) {
			r = 0;
			w = (int) ((PPM.getWidth() * widthP) - (-yRatio)*PPM.getWidth());
		}
		else
		{
			r = (int) (yRatio * PPM.getHeight()); // get y-coord
			h = (int) (PPM.getHeight() * heightP);
		}
		// Must scale x,y to final PPM dimensions
		
		
		
		// h is the real height in pixels
		

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
