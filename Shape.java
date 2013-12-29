import java.awt.Color;

///////////////////////////////////////////////////////////////////////////////
//ALL STUDENTS COMPLETE THESE SECTIONS
//Main Class File:  PortablePixelMapper.java
//File:             Shape.java
//Semester:         CS302 Fall 2013
//
//Author:           Deb Deppeler
//CS Login:         deppeler
//Lecturer's Name:  
//Lab Section:      
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
 * Contains the common fields and methods needed by all shapes in Program 4 Fall
 * 2013 semester.
 * 
 * It is intended to be used as the super (parent) class of all shape types in
 * p4.
 * 
 * It contains the relative position of a reference point for drawing a scalable
 * vector graphic shape on any size image field.
 * 
 * It also allows requires a Color to be chosen for drawing the shape.
 * 
 * @author Deb Deppeler (deppeler@cs.wisc.edu), Nov 2013
 */
public class Shape {

	/**
	 * The relative location of the origin or anchor point along the horizontal
	 * axis of a figure.
	 * 
	 * 0.50 indicates half of the distance across or at column 50 if the width
	 * is 100 pixels.
	 * 
	 * A value of 1.0 may end up with the reference point being in the image or
	 * just outside of the image depending upon the dimensions of the image. If
	 * the dimensions of an image are 100 than the available columns are 0 - 99
	 * (and 1% would mean 100 and just outside the image field of view.
	 */
	protected double xRatio; // indicates column

	/**
	 * The relative location of the origin or anchor point along the vertical
	 * axis of a figure.
	 * 
	 * 0.50 indicates half of the distance down or at row 50 if the height is
	 * 100 pixels.
	 * 
	 * A value of 1.0 may end up with the reference point being in the image or
	 * just outside of the image depending upon the dimensions of the image. If
	 * the height of an image is 100 than the available rows are 0 - 99 (and 1%
	 * would mean 100 and just outside the image field of view.
	 */
	protected double yRatio; // row

	/**
	 * A color for drawing this shape. Standard named colors may be used or new
	 * colors created from the red, green, blue (RGB) components of the desired
	 * color.
	 */
	protected Color color;

	/**
	 * All shapes must have a color and an origin or anchor point to be used as
	 * a reference point for drawing the shape on an image.
	 * 
	 * The reference point does not have to be in the image space, but only the
	 * part of the shape image that is within the image space will be visible.
	 * 
	 * @param color
	 *            The color to be used to draw this shape.
	 * 
	 * @param xPerc
	 *            A relative position of 0 to 1.0 means the x-coordinate of the
	 *            reference point is on the visible portion of the image plane.
	 *            Values outside the range 0-1 indicate the reference point is
	 *            not in the visible portion of the image.
	 * 
	 * @param yPerc
	 *            A relative position of 0 to 1.0 means the y-coordinate of the
	 *            reference point is on the visible portion of the image plane.
	 *            Values outside the range 0-1 indicate the reference point is
	 *            not in the visible portion of the image.
	 */
	public Shape(Color color, double xPerc, double yPerc) {
		this.xRatio = xPerc;
		this.yRatio = yPerc;
		this.color = color;
	}

	/**
	 * Draws this shape onto the image plane available for the PPM object.
	 * 
	 * Uses this shapes reference point and the width and height of the image to
	 * determine where and how to set pixels to "draw" the desired shape.
	 * 
	 * Each subclass of Shape must override this method to get its shape drawn
	 * to the image.
	 * 
	 * This method will draw a "dot" at the coordinate of the reference point,
	 * if that point is on the visible portion of the image.
	 * 
	 * @param ppm
	 *            An image object that can have individual pixels set as the
	 *            user wishes.
	 */
	public void drawTo(PPM ppm) {
		// Must scale x,y to final ppm dimensions
		int c = (int) (xRatio * ppm.getWidth()); // get x-coord
		// REVISED 12/2/2013 - fixed r to correspond
		// to the yRatio of the HEIGHT
		int r = (int) (yRatio * ppm.getHeight()); // get y-coord
		ppm.setPixel(r, c, color);
	}

	/**
	 * Returns the runtime name of the particular shape and its color and
	 * reference point.
	 * 
	 * Can be overridden by subclasses to include more information. To call this
	 * method from within a subclass method: super.toString()
	 */
	public String toString() {
		return color + " " + getClass().getName() + " at (" + xRatio + ","
				+ yRatio + ")";
	}

}