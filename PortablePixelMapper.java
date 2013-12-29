///////////////////////////////////////////////////////////////////////////////
//ALL STUDENTS COMPLETE THESE SECTIONS
//Title:            PortablePixelMapper
//Files:            PortablePixelMapper.java
//					PPM.java
//					Shape.java
//					SVG.java
//					Rectangle.java
//					Square.java
//					Ring.java
//					Circle.java
//Semester:         CS302 Fall 2013
//
//Author:           Minh Bui
//Email:            minh@cs.wisc.edu or mbui2@wisc.edu
//CS Login:         minh
//Lecturer's Name:  Shreedhar Hardika
//Lab Section:      301
//
//PAIR PROGRAMMERS COMPLETE THIS SECTION
//Pair Partner:     null
//Email:            null
//CS Login:         null
//Lecturer's Name:  null
//Lab Section:      null
//
//STUDENTS WHO GET HELP FROM ANYONE OTHER THAN THEIR PARTNER
//Credits:          null
////////////////////////////80 columns wide //////////////////////////////////

import java.io.FileNotFoundException;

/**
 * This program receives arguments from the command line and draws graphic
 * contents by generating a PPM format file.
 * 
 * @author Minh Bui
 * 
 */

public class PortablePixelMapper {
	public static void main(String[] args) {
		// Declaring variables
		PPM outPPM;
		// Store the reference of the output file.

		// Default required number of arguments.
		final int NUMBERS_OF_ARG = 4;

		// Set width and height to -1 because these values cannot be negative.
		// These values will be changed to positive during the input process.
		// If these values are still negative, the user has entered invalid
		// values.
		int width = -1;
		int height = -1;

		// Echo the entered arguments.
		for (int i = 0; i < args.length; i++) {
			if (i == args.length - 1) {
				System.out.print(args[i]);
			} else {
				System.out.print(args[i] + " ");
			}
		}
		System.out.println();

		// Check for the number of arguments. If insufficiently provided, return
		// the usage message and then terminate the program. Otherwise process
		// with the next steps.
		if (args.length < NUMBERS_OF_ARG) {
			System.out.println();
			usage();
		} else {
			// This code fragment tests for invalid inputs such as wrong type.
			// This code fragment also try to find the input file. If not found,
			// print out the error message. If found, process with the next
			// steps.
			// try {
			try {
				width = Integer.parseInt(args[1]);
				height = Integer.parseInt(args[2]);
				if (width < 0 || height < 0) {
					usage();
					return;
				}
			} catch (Exception invalidInPut) {
				usage();
				return;
			}

			try {
				// Trying to read the input file, create the image dimension
				outPPM = new PPM(width, height);
				SVG newSVG = new SVG(args[0]);
				newSVG.drawPixmap(outPPM);
			} catch (FileNotFoundException fileNotFound) {
				System.out.println("Sorry, unable to read from " + args[0]
						+ ".");
				return;
			}
			try {
				outPPM.writeToFile(args[3]);
			} catch (FileNotFoundException e) {
				System.out
						.println("Sorry, unable to write to " + args[3] + ".");
			}
			// } catch (Exception general) {
			// System.out.println("Sorry, unknown error occurred.");
		}

		// }
	}

	/**
	 * This method print out the usage message.
	 */

	public static void usage() {
		System.out.println("Usage:");
		System.out.println("java PortablePixelMapper <inFile> <width> "
				+ "<height> <outFile>");
		System.out.println();
		System.out.println("<inFile> is the name of an input file with svg "
				+ "shape information");
		System.out.println("<width> is the result image width in pixels");
		System.out.println("<height> is the result image height in pixels");
		System.out.println("<outFile> is the name of the ppm file to create");
		System.out.println();
		System.out.println("Example:");
		System.out.println("java PortablePixelMapper sample01.txt 100 100 "
				+ "image01.ppm");
	}
}
