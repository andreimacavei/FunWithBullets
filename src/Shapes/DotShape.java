package Shapes;

import Constants.Symbols;
import Screen.Screen;

/**
 * The class for drawing a dot shape on the screen.
 * The dot is drawn using coordinates of a point on the screen
 * and the character 'P'.
 * 
 * @author Macavei Andrei-Gabriel
 *
 */
public class DotShape extends BasicShape {

	public DotShape() {
	}

	@Override
	public void draw(Screen screen, int ref, Point centerGrav) {
		screen.drawLineOnScreen(centerGrav, centerGrav, Symbols.DOT_SYMBOL);
	}

}
