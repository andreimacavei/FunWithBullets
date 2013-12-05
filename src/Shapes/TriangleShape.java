package Shapes;

import Constants.Symbols;
import Screen.Screen;

public class TriangleShape extends BasicShape {

	public TriangleShape() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public void draw(Screen screen, int ref, Point centerGrav) {
		Point[] startPoints = new Point[3];
		startPoints[0] = new Point(centerGrav.getX(),
								centerGrav.getY() - 2 * ref);
		startPoints[1] = new Point(centerGrav.getX() - ref,
								centerGrav.getY() + ref);
		startPoints[2] = new Point(centerGrav.getX() + ref,
								centerGrav.getY() + ref);
		
		Point[] endPoints = new Point[3];
		for(int i = 0; i < startPoints.length; ++i) {
			if (i == 2) {
				endPoints[i] = startPoints[0];
				continue;
			}
			endPoints[i] = startPoints[i+1];
		}
		screen.drawMultipleLinesOnScreen(startPoints, endPoints, Symbols.TRIANGLE_SYMBOL);
	}

}
