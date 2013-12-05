package Shapes;

import Constants.Symbols;
import Screen.Screen;

/**
 * The class for drawing a square shape on the screen.
 * The square is drawn using the position for the center of gravity
 * of the shape, a ref value and the character 'S'.
 * 
 * @author Macavei Andrei-Gabriel
 *
 */
public class SquareShape extends BasicShape {

	
	public SquareShape() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public void draw(Screen screen, int ref, Point centerGrav) {
		Point[] startPoints = new Point[4];
		
		startPoints[0] = new Point(centerGrav.getX() - ref,
							centerGrav.getY() - ref);
		startPoints[1] = new Point(centerGrav.getX() - ref,
							centerGrav.getY() + ref);
		startPoints[2] = new Point(centerGrav.getX() + ref,
							centerGrav.getY() + ref);
		startPoints[3] = new Point(centerGrav.getX() + ref,
							centerGrav.getY() - ref);
		Point[] endPoints = new Point[4];
		for(int i = 0; i < startPoints.length; ++i) {
			if (i == 3) {
				endPoints[i] = startPoints[0];
				continue;
			}
			endPoints[i] = startPoints[i+1];
		}
		screen.drawMultipleLinesOnScreen(startPoints, endPoints, Symbols.SQUARE_SYMBOL);
	}

}
