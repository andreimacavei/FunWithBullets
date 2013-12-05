package Shapes;

import Constants.Symbols;
import Screen.Screen;

public class RectangleShape extends BasicShape {

	public RectangleShape() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public void draw(Screen screen, int ref, Point centerGrav) {
		Point[] startPoints = new Point[4];
		
		startPoints[0] = new Point(centerGrav.getX() - 2 * ref,
							centerGrav.getY() - ref);
		startPoints[1] = new Point(centerGrav.getX() - 2 * ref,
							centerGrav.getY() + ref);
		startPoints[2] = new Point(centerGrav.getX() + 2 * ref,
							centerGrav.getY() + ref);
		startPoints[3] = new Point(centerGrav.getX() + 2 * ref,
							centerGrav.getY() - ref);
		Point[] endPoints = new Point[4];
		for(int i = 0; i < startPoints.length; ++i) {
			if (i == 3) {
				endPoints[i] = startPoints[0];
				continue;
			}
			endPoints[i] = startPoints[i+1];
		}
		screen.drawMultipleLinesOnScreen(startPoints, endPoints, Symbols.RECTANGLE_SYMBOL);
	}

}