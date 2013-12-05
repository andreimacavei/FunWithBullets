package Shapes;

import Constants.Symbols;
import Screen.Screen;

/**
 * The class for drawing a rhombus shape on the screen.
 * The rhombus is drawn using the position for the center of gravity
 * of the shape, a ref value and the character 'R'.
 * 
 * @author Macavei Andrei-Gabriel
 *
 */
public class RhombusShape extends BasicShape {

	public RhombusShape() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public void draw(Screen screen, int ref, Point centerGrav) {
		Point[] startPoints = new Point[4];
		startPoints[0] = new Point(centerGrav.getX(),
								centerGrav.getY() - 2 * ref);
		startPoints[1] = new Point(centerGrav.getX() - ref,
								centerGrav.getY());
		startPoints[2] = new Point(centerGrav.getX(),
								centerGrav.getY() + 2 * ref);
		startPoints[3] = new Point(centerGrav.getX() + ref,
								centerGrav.getY());
		
		Point[] endPoints = new Point[4];
		for(int i = 0; i < startPoints.length; ++i) {
			if (i == 3) {
				endPoints[i] = startPoints[0];
				continue;
			}
			endPoints[i] = startPoints[i+1];
		}
		screen.drawMultipleLinesOnScreen(startPoints, endPoints, Symbols.RHOMBUS_SYMBOL);
	}

}
