///////////////////////////////////////////////////////////////////////////////
//ALL STUDENTS COMPLETE THESE SECTIONS
//Main Class File:  PPM_Viewer.java
//File:             In.java
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
 *  This class is the main class which will read the contents of the file and \
 *  create a BufferedImage for the purpose of storing the graphics contents.
 *  <br>
 *  Bugs: none found
 *  @author: Minh Bui
 */

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.awt.Color;
import java.util.ArrayList;
import java.awt.image.BufferedImage;
import java.awt.Image;

public class In {
	private String fileName = "";

	// The dimension of the image.
	private int width = 0;
	private int height = 0;

	// Default header that any PPM file must have in the 1st line
	private final String HEADER = "P3";

	// RGB components stored in the PPM file.
	private int r = 0;
	private int g = 0;
	private int b = 0;

	// This array list of colors stores each pixel's color. For the purpose of
	// written to the BufferedImage object.
	private ArrayList<Color> colorList = new ArrayList<Color>();

	// Main object for the display of image.
	private BufferedImage canvas;

	private final int COLORINSTANCE = 255;

	/**
	 * Constructor
	 * 
	 * @param fileName
	 * @throws FileNotFoundException
	 */

	public In(String fileName) throws FileNotFoundException {
		this.fileName = fileName;
		readFile();
	}

	/**
	 * Return the BufferedImage object of this in object.
	 * 
	 * @return an image object to be displayed
	 */

	public Image getCanvas() {
		return canvas;
	}

	/**
	 * Get the width of the image
	 * 
	 * @return the width of the image.
	 */

	public int getWidth() {
		return width;
	}

	/**
	 * Get the height of the image
	 * @return the height of the image.
	 */

	public int getHeight() {
		return height;
	}
	
	/**
	 * This function check for the header's footprint of  the first line of the 
	 * file.
	 * @param header
	 * @return true if the right header is recognized in the first line and 
	 * 			false otherwise.
	 */

	public boolean checkHeader(String header) {
		if (!header.equals(HEADER))
			return false;
		return true;
	}
	
	/**
	 * This function reads the info from the file, store it, and write it to the
	 * canvas object.
	 * @throws FileNotFoundException
	 */

	public void readFile() throws FileNotFoundException {
		File inFile = new File(fileName);
		Scanner in = new Scanner(inFile);
		
		// Check for the header, the right format of specifying the width, 
		// height and the color instance. If all ok, proceed with the reading 
		// RGB components.
		try {
			String header = in.next();
			if (!checkHeader(header)) {
				in.close();
				throw new IllegalArgumentException();

			}
			width = Integer.parseInt(in.next());
			height = Integer.parseInt(in.next());
			int colorInstance = Integer.parseInt(in.next());
			if (colorInstance != COLORINSTANCE) {
				in.close();
				throw new IllegalArgumentException();
			}
			
			while (in.hasNext()) {
				r = Integer.parseInt(in.next());
				g = Integer.parseInt(in.next());
				b = Integer.parseInt(in.next());
				
				// If successfully read in the RGB components, add the color to
				// the array list.
				Color c = new Color(r, g, b);
				colorList.add(c);
			}
		} catch (IllegalArgumentException e) {
			System.out.println("File format error.");
		} catch (Exception e) {
			System.out.println("Unknown error occurred.");
		}
		
		// Traverse through the colorList array and set the pixel for the canvas
		// object. I am trying to figure out a better way to improve efficiency.
		// Using a triple loop slow down the program. 
		int i = 0;
		canvas = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);
		while (i < colorList.size()) {
			for (int j = 0; j < height; j++) {
				for (int k = 0; k < width; k++) {
					canvas.setRGB(k, j, colorList.get(i).getRGB());
					i++;
				}
			}

		}
		in.close();
	}
}
