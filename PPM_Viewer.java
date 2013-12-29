///////////////////////////////////////////////////////////////////////////////
//ALL STUDENTS COMPLETE THESE SECTIONS
//Title:            PPM_Viewer
//Files:            PPM_Viewer.java
//					in.java
//
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

/**
 * This program read a PPM format file and display the rendered contents taken 
 * from the file. 
 * <br>
 * Bugs: none found.
 * 
 * @author Minh Bui
 */

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import java.io.FileNotFoundException;

public class PPM_Viewer {
	public static void main(String[] args) {
		final String ABOUT = "-about";
		String inFile = "";
		final int NUMBERS_OF_ARG = 1;
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
			return;
		}
		if (args[0].equals(ABOUT))
		{
			System.out.println();
			System.out.println("|			PPM Image Viewer v1.0			|");
			System.out.println("|				by Minh Bui		  	|");
			System.out.println("| 		 from project 4 CS302 Fall 2013     	" +
					"	|");
			return;
		}
		// Try to read in the file. Draw the image based on the contents of the
		// file and then display it through JFrame object.
		try {
			inFile = args[0];
			In inP = new In(inFile);
			JFrame frame = new JFrame();
			frame.setSize(inP.getWidth(), inP.getHeight());
			frame.add(new JLabel(new ImageIcon(inP.getCanvas())));
			frame.pack();
			frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
			frame.setVisible(true);
			frame.setTitle("Minh's PPM Viewer");

		} catch (FileNotFoundException e) {
			System.out.println("ERROR! File not found!");
			return;
		} catch (Exception e) {
			System.out.println("Unknown error occured.");
		}
	}

	/**
	 * Print out the usage message.
	 */
	private static void usage() {
		System.out.println("Usage:");
		System.out.println("java PPMViewer <inFile>");
		System.out.println();
		System.out.println("<inFile> is the name of an input PPM file.");
		System.out.println();
		System.out.println("Example:");
		System.out.println("java PPMViewer image00.ppm");
		System.out.println();
	}
}
