///////////////////////////////////////////////////////////////////////////////
//ALL STUDENTS COMPLETE THESE SECTIONS
//Main Class File:  PortablePixelMapperEC.java
//File:             CcircleEC.java
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
import java.util.ArrayList;

class Vector {
	private int x;
	private int y;

	public Vector(int x, int y) {
		this.x = x;
		this.y = y;
	}

	public int getX() {
		return x;
	}

	public void setX(int x) {
		this.x = x;
	}

	public int getY() {
		return y;
	}

	public void setY(int y) {
		this.y = y;
	}

	public double length() {
		return Math.sqrt(x * x + y * y);
	}

	public static Vector addVector(Vector v1, Vector v2) {
		Vector v3 = new Vector(v1.x + v2.x, v1.y + v2.y);
		return v3;
	}

}

public class CcircleEC extends ShapeEC {
	private double radiusP;
	private int points;
	private boolean found = false;
	private ArrayList<Vector> vectorList = new ArrayList<Vector>();

	/**
	 * Constructor
	 * 
	 * @param color
	 * @param xPerc
	 * @param yPerc
	 * @param raiusP
	 * @param points
	 */
	public CcircleEC(Color color, double xPerc, double yPerc, double radiusP,
			int points) {
		super(color, xPerc, yPerc);
		this.radiusP = radiusP;
		this.points = points;
	}

	/**
	 * This function draw the circumscribed circle on the PPM object.
	 * 
	 * @param PPM
	 */
	public void drawTo(PPMEC PPM) {
		Vector v = new Vector(0, 0);
		// Must scale x,y to final ppm dimensions
		int c = (int) (xRatio * PPM.getWidth()); // get x-coord
		int r = (int) (yRatio * PPM.getHeight()); // get y-coord
		int radius = (int) (PPM.getWidth() * radiusP);
		int count = 0;
		while (!found) {
			for (int j = 0; j < PPM.getHeight(); j++) {
				for (int k = 0; k < PPM.getWidth(); k++) {
					int d = (r - j) * (r - j) + (c - k) * (c - k);
					if (radius * radius == d && count < points) {
						Vector v0 = new Vector(k - c, j - r);
						vectorList.add(v0);
						count++;
					}
				}
			}
			Vector v10 = addVectors(vectorList);
			if (v10.length() == 0) {
				for (int i = 0; i < vectorList.size() / 2; i++) {
					for (int j = 0; j < PPM.getHeight(); j++) {
						for (int k = 0; k < PPM.getWidth(); k++) {
							int c1 = crossProduct(c, r, k, j);
							int c2 = crossProduct(vectorList.get(i).getX() + c,
									vectorList.get(i).getY() + r, k, j);
							int c3 = crossProduct(vectorList.get(i + 1).getX()
									+ c, vectorList.get(i + 1).getY() + r, k, j);
							PPM.setPixel(vectorList.get(i).getX() + c,
									vectorList.get(i).getY() + r, color);
						}
						found = true;
					}

				}

			}
		}
	}

	public int crossProduct(int x1, int x2, int y1, int y2) {
		return (x1 * y2 - y1 * x2);
	}

	public static Vector addVectors(ArrayList<Vector> array) {
		Vector v = new Vector(0, 0);
		for (int i = 0; i < array.size(); i++) {
			v = Vector.addVector(v, array.get(i));
		}
		return v;
	}
}
