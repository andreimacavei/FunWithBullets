package Shapes;

import Constants.Symbols;
import Screen.Screen;

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
