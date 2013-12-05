package Screen;

import java.io.FileWriter;
import java.io.IOException;

import Shapes.Point;
import Constants.Symbols;
import ProcessingManagers.DrawManager;

/**
 * Class that represents the screen to be projected on
 */
public class Screen {
	private char[][] matrix;
	
	/**
	 * Builds the necessary data of the screen
	 * 
	 * @param sizeX	screen size on X axis
	 * @param sizeY	screen size on Y axis
	 */
	public Screen(int sizeX, int sizeY) {
		this.matrix = new char[sizeX][sizeY];
		for (int i = 0; i < sizeX; ++i) {
			for (int j = 0; j < sizeY; ++j) {
				matrix[i][j] = Symbols.SCREEN_SYMBOL;
			}
		}
	}
	
	/**
	 * Draws a line on the screen between the given points
	 * 
	 * @param startPoint	the first end of the line
	 * @param endPoint		the second end of the line
	 * @param symbol		the symbol the line is drawn with
	 */
	public void drawLineOnScreen(Point startPoint, Point endPoint, 
			char symbol) {
		// Hint: Use DrawManager
		DrawManager.drawLine(this.matrix, startPoint, endPoint, symbol);
	}
	
	/**
	 * Draws multiple lines, each defined by startPoints[index] and
	 * endPoints[index] 
	 * 
	 * @param startPoints	array of first ends of the lines
	 * @param endPoints		array of second ends of the lines
	 * @param symbol		the symbol with which ALL lines are drawn
	 */
	public void drawMultipleLinesOnScreen(Point[] startPoints,
			Point[] endPoints, char symbol) {
		for (int i=0; i < startPoints.length; ++i) {
			Point start = startPoints[i];
			Point end = endPoints[i];
			DrawManager.drawLine(this.matrix, start, end, symbol);
		}
	}
	
	/**
	 * Writes this screen, represented by a matrix of characters,
	 * to a given file.
	 * 
	 * @param out	the output file
	 */
	public void writeScreen(FileWriter out) {
		for (int i = 0; i < this.matrix.length; ++i) {
			try {
				out.write(matrix[i]);
				out.write('\n');
			} catch (IOException e) {
				e.printStackTrace();
				return;
			}
		}
		// Adding the last blank line
		try {
			out.write('\n');
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
