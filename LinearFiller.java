import java.awt.Color;

/**
 * This class contains a method that fill up the gaps with the color specified
 * between 2 pixels. 
 * @author Minh Bui
 *
 */

public class LinearFiller {
	public static void filler(PPM PPM, int x0, int y0, int x1, int y1,
			Color color) {
		for (int i = 0; i < (x1 - x0); i++) {
			if ((x0 + i) == PPM.getImage()[0].length - 1) {
			} else {
				PPM.setPixel(y0, x0 + i, color);
			}
		}

		for (int j = 0; j < (y1 - y0); j++) {
			if ((y0 + j) == PPM.getImage().length - 1) {
			} else {
				PPM.setPixel(y0 + j, x0, color);
			}
		}
	}
}
