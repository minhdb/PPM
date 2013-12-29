///////////////////////////////////////////////////////////////////////////////
//ALL STUDENTS COMPLETE THESE SECTIONS
//Main Class File:  PortablePixelMapper.java
//File:             PPM.java
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
import java.io.PrintWriter;
import java.io.FileNotFoundException;

/**
 * This class represents the output PPM file. It stores the information of the
 * drawn picture under the human-readable text format.
 * 
 * <p>
 * Bugs: none found.
 * 
 * @author Minh Bui
 * 
 */

public class PPMEC {
	// Variables for Shapes class uses.
	private int width = 0;
	private int height = 0;

	// Default string value of a PPM file header.
	private final String HEADER = "P3\n";

	// A String represents information inside the ppm file.
	private String out;

	// The value that a color component can reach.
	public final int MAX_INTENSITY = 255;

	// A 2D array of pixels.
	private Color[][] image;

	/**
	 * Constructor Create and filled the image with white color.
	 * 
	 * @param width
	 * @param height
	 */
	public PPMEC(int width, int height) {
		image = new Color[height][width];
		setAllWhite(width, height);
		this.width = width;
		this.height = height;
	}

	/**
	 * Get and return the image array.
	 * 
	 * @return the image array.
	 */

	public Color[][] getImage() {
		return image;
	}

	/**
	 * Get the width of the image.
	 * 
	 * @return width
	 */

	public int getWidth() {
		return this.width;
	}

	/**
	 * Get the height of the image.
	 * 
	 * @return height;
	 */

	public int getHeight() {
		return this.height;
	}

	/**
	 * This function modifies the color of the specified pixel at a specific
	 * location.
	 * 
	 * @param row
	 * @param col
	 * @param color
	 */

	public void setPixel(int row, int col, Color color) {
		image[row][col] = color;
	}

	/**
	 * This function writes the output of the program to a file. If can't, throw
	 * an error message.
	 * 
	 * @param fileName
	 * @throws FileNotFoundException
	 */

	public void writeToFile(String fileName) throws FileNotFoundException {
		PrintWriter outPut = new PrintWriter(fileName);
		outPut.println(HEADER + width + " " + height + "\n" + MAX_INTENSITY);
		printImage(width, height, outPut);
		outPut.close();

	}

	/**
	 * This function writes the image's data to the "out" variable and stores it
	 * for further use.
	 * 
	 * @param width
	 * @param height
	 * @return the string that represent the information of the image in text
	 *         format
	 */

	private void printImage(int width, int height, PrintWriter outP) {
		// out = "";
		if (width < height) {
			for (int i = 0; i < width; i++) {
				for (int j = 0; j < height; j++) {
					if (i == width - 1 && j == height - 1) {
						// out += toString(image[j][i]);
						outP.print(toString(image[j][i]));
					} else {
						// out += toString(image[j][i]) + "\n";
						outP.print(toString(image[j][i]) + "\n");
					}
				}
			}
		} else {
			for (int i = 0; i < height; i++) {
				for (int j = 0; j < width; j++) {
					if (i == height - 1 && j == width - 1) {
						// out += toString(image[i][j]);
						outP.print(toString(image[i][j]));
					} else {
						// out += toString(image[i][j]) + "\n";
						outP.print(toString(image[i][j]) + "\n");
					}
				}
			}
		}
	}

	/**
	 * This function set the whole image to white color.
	 * 
	 * @param width
	 * @param height
	 */
	private void setAllWhite(int width, int height) {
		if (width < height) {
			for (int i = 0; i < width; i++) {
				for (int j = 0; j < height; j++) {
					image[j][i] = Color.WHITE;
				}
			}
		} else {
			for (int j = 0; j < height; j++) {
				for (int i = 0; i < width; i++) {
					image[j][i] = Color.WHITE;
				}
			}
		}
	}

	/**
	 * Return 3 color components of a color. <br>
	 * Example: toString(Color.WHITE) will return: <br>
	 * 255 255 255
	 * 
	 * @param col
	 * @return a string that separate color components with space.
	 */

	public static String toString(Color col) {
		String colorComp = "";
		colorComp = "" + col.getRed() + " " + col.getGreen() + " "
				+ col.getBlue();
		return colorComp;
	}
}
