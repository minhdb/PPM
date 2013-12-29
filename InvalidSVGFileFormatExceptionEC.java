///////////////////////////////////////////////////////////////////////////////
//ALL STUDENTS COMPLETE THESE SECTIONS
//Main Class File:  PortablePixelMapperEC.java
//File:             InvalidSVGFileFormatException.java
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
 * This class is thrown when a file is not completely read.
 * <br>
 * Bugs: none found
 * @author Minh Bui
 */

public class InvalidSVGFileFormatExceptionEC extends RuntimeException {
	public InvalidSVGFileFormatExceptionEC()
	{
		System.out.println("Sorry, unable to read rest of file.");
	}
}
