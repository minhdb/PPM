///////////////////////////////////////////////////////////////////////////////
//ALL STUDENTS COMPLETE THESE SECTIONS
//Main Class File:  PortablePixelMapperEC.java
//File:             equilateral_triangleEC.java
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
import java.awt.Color;

/**
 * The OvalEC class is responsible for drawing a filled ellipse.
 * 
 * @author Minh Bui
 * 
 */

public class equilateral_triangleEC extends ShapeEC {
	private double baseR;
	private final double ANGLE = 60;
	private final double ANGLEH = 30;
	private final double EPSILON = 0.001;

	/**
	 * Constructor
	 * @param color
	 * @param xPerc
	 * @param yPerc
	 * @param baseR
	 */
	public equilateral_triangleEC(Color color, double xPerc, double yPerc,
			double baseR) {
		super(color, xPerc, yPerc);
		xRatio = xPerc;
		yRatio = yPerc;
		this.baseR = baseR;
	}
	
	/**
	 * This function draws the equilateral on PPM's surface.
	 */

	public void drawTo(PPMEC PPM) {
		int c = (int) (xRatio * PPM.getWidth());
		int r = (int) (yRatio * PPM.getHeight());
		int hLengthB = (int) (baseR * PPM.getWidth() / 2);
		double angleR = Math.toRadians(ANGLE);
		double angleHR = Math.toRadians(ANGLEH);
		double h = (int) (Math.tan(angleR) * hLengthB);
		PPM.setPixel(r, c, color);
		for (int i = (r + 1); i < (r + h + 1); i++) {
			int hp = (int) Math.sqrt((i - r) * (i - r));
			for (int k = 0; k < PPM.getWidth(); k++) {
				int b = (int) Math.sqrt((c - k) * (c - k));
				double tan = b / (hp * 1.0);
				double arctan = Math.atan(tan);
				if ((arctan <= angleHR) ) {
					PPM.setPixel(i, k, color);
				}
			}
		}

	}
}
