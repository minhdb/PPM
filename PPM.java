import java.awt.Color;
import java.io.PrintWriter;
import java.io.FileNotFoundException;

/**
 * This class represents the output PPM file. It stores the information of the
 * drawn picture under the human-readable text format.
 * 
 * <p>Bugs: none found.
 * @author Minh Bui
 * 
 */

public class PPM {
	// Variables for Shapes class uses.
	private int width = 0;
	private int height = 0;
	
	// Default string value of a PPM file header.
	private final String HEADER = "P3\n";
	
	// A String represents information inside the ppm file.
	private String out = HEADER;
	
	// The value that a color component can reach.
	public final int MAX_INTENSITY = 255;
	
	// A 2D array of pixels.
	private String[][] image;

	/**
	 * Constructor
	 * Create and filled the image with white color. 
	 * @param width
	 * @param height
	 */
	public PPM(int width, int height) {
		image = new String[height][width];
		setAllWhite(width, height);
		out += width + " " + height + "\n" + MAX_INTENSITY + "\n"
				+ printImage(width, height);
		this.width = width;
		this.height = height;
	}
	
	/**
	 * Get and return the image array.
	 * @return the image array.
	 */
	
	public String[][] getImage()
	{
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
		image[row][col] = toString(color);
	}

	/**
	 * This function writes the output of the program to a file. If can't, throw
	 * an error message.
	 * 
	 * @param fileName
	 */

	public void writeToFile(String fileName) throws FileNotFoundException {
		PrintWriter outPut = new PrintWriter(fileName);
		outPut.println(HEADER + width + " " + height + "\n" + MAX_INTENSITY
				+ "\n" + printImage(width, height));
		outPut.close();

	}

	/**
	 * This function writes the image's data to the "out" variable and stores it
	 * for further use.
	 * 
	 * @param width
	 * @param height
	 * @return
	 */

	private String printImage(int width, int height) {
		String out = "";
		if (width < height) {
			for (int i = 0; i < width; i++) {
				for (int j = 0; j < height; j++) {
					if (i == width - 1 && j == height - 1) {
						out += image[j][i];
					} else {
						out += image[j][i] + "\n";
					}
				}
			}
		} else {
			for (int i = 0; i < height; i++) {
				for (int j = 0; j < width; j++) {
					if (i == height - 1 && j == width - 1) {
						out += image[i][j];
					} else {
						out += image[i][j] + "\n";
					}
				}
			}
		}
		return out;
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
				for (int j = 0; j < height; j++)
				{
					image[j][i] = toString(Color.WHITE);
				}
			}
		} else {
			for (int j = 0; j < height; j++) {
				for (int i = 0; i < width; i++)
				{
					image[j][i] = toString(Color.WHITE);
				}
			}
		}
	}
	
	/**
	 * Return 3 color components of a color. <br>
	 * Example:
	 * toString(Color.WHITE) will return: <br>
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
