import java.util.ArrayList;
import java.util.Scanner;
import java.awt.Color;
import java.io.*;

///////////////////////////////////////////////////////////////////////////////
//ALL STUDENTS COMPLETE THESE SECTIONS
//Main Class File:  PortablePixelMapperEC.java
//File:             SVGEC.java
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
 * SVG class represents the input file. It grabs the information from the input
 * file and stores it for further process.
 * 
 * <p>
 * Bugs: none found.
 * 
 * @author Minh Bui
 * 
 */
public class SVGEC {
	// The shapes information specified in the input file will be store here.
	private ArrayList<ShapeEC> shapeList = new ArrayList<ShapeEC>();

	// A String that represents the name of the shape.
	private String shapeName = "";

	// The number that represents red, green, blue color component.
	private int r = 0;
	private int g = 0;
	private int b = 0;

	// The percentage that specifies the first point's position to be drawn on
	// the x-axis.
	private double xOrg = 0;

	// The percentage that specifies the first point's position to be drawn on
	// the y-axis.
	private double yOrg = 0;

	// Additional fields for shapes that require information.
	private ArrayList<Double> addF = new ArrayList<Double>();
	private Color color;
	private PPMEC PPMEC;
	String out = "";

	/**
	 * Constructor
	 */
	public SVGEC() {

	}

	/**
	 * Constructor with parameter.
	 * 
	 * @param fileName
	 * @param PPM
	 * @param out
	 */

	public SVGEC(String fileName, PPMEC PPM, String out)
			throws FileNotFoundException {
		this.PPMEC = PPM;
		this.out = out;
		readFile(fileName);

	}

	/**
	 * This function adds a specified shape to the shapeList.
	 * 
	 * @param shape
	 */

	public void addShape(ShapeEC shape) {
		shapeList.add(shape);
	}

	/**
	 * This function draw the shapes to the PPM object
	 * @param PPMEC
	 */

	public void drawPixmap(PPMEC ppm) {
		for (int i = 0; i < shapeList.size(); i++) {
			shapeList.get(i).drawTo(ppm);
		}
	}

	/**
	 * This function returns the array list of shapes.
	 * 
	 * @return list of shapes
	 */

	public ArrayList<ShapeEC> getShapes() {
		return shapeList;
	}

	/**
	 * This function tries to read the contents of the input file. This function
	 * also make the program store the shapes information from the input file.
	 * 
	 * @param fileName
	 */

	public void readFile(String fileName) throws FileNotFoundException {
		File newFile = new File(fileName);
		Scanner in = new Scanner(newFile);
		// Read in the information from the input file. The usage is:
		// <String name> <int red> <int green> <int blue> <double xOrg>
		// <double yOrg> <additional fields>
		while (in.hasNext()) {
			try {
				shapeName = in.next();
				r = in.nextInt();
				g = in.nextInt();
				b = in.nextInt();
				xOrg = in.nextDouble();
				yOrg = in.nextDouble();
				color = new Color(r, g, b);

				// Read in the additional fields.
				while (in.hasNextDouble()) {
					double temp = in.nextDouble();
					addF.add(temp);
				}
			} catch (Exception e) {
				drawPixmap(PPMEC);
				PPMEC.writeToFile(out);
				in.close();
				throw new InvalidSVGFileFormatExceptionEC();
			}
			// This part tries to identify the name of the shape specified in
			// the input file, create a new object of that shape with the
			// parameters taken from the input file. If something goes wrong,
			// throws an exception. <br>
			//
			// The disadvantage is each time I add another new shape class. I
			// have to add code to check for that shape. I still haven't found
			// another way of doing this.
			if (shapeName.equals("rectangle") && addF.size() == 2) {
				RectangleEC rec = new RectangleEC(color, xOrg, yOrg,
						addF.get(0), addF.get(1));
				shapeList.add(rec);
			} else if (shapeName.equals("square") && addF.size() == 1) {
				SquareEC sq = new SquareEC(color, xOrg, yOrg, addF.get(0));
				shapeList.add(sq);
			} else if (shapeName.equals("circle") && addF.size() == 1) {
				CircleEC c = new CircleEC(color, xOrg, yOrg, addF.get(0));
				shapeList.add(c);
			} else if (shapeName.equals("ring") && addF.size() == 2) {
				RingEC r = new RingEC(color, xOrg, yOrg, addF.get(0),
						addF.get(1));
				shapeList.add(r);
			} else if (shapeName.equals("oval") && addF.size() == 3) {
				OvalEC o = new OvalEC(color, xOrg, yOrg, addF.get(0),
						addF.get(1), addF.get(2));
				shapeList.add(o);
			} else if (shapeName.equals("equilateral_triangle")
					&& addF.size() == 1) {
				equilateral_triangleEC et = new equilateral_triangleEC(color,
						xOrg, yOrg, addF.get(0));
				shapeList.add(et);
			}
			else if (shapeName.equals("ccircle") && addF.size() == 2)
			{
				CcircleEC cc = new CcircleEC(color, xOrg, yOrg, addF.get(0), (int)((double)(addF.get(1))));
				shapeList.add(cc);
			}
			else {
				in.close();
				throw new IllegalArgumentException();
			}
			addF.clear();
		}
		in.close();

	}
}
