package Shapes;

import Constants.Symbols;
import Screen.Screen;

public class DotShape extends BasicShape {

	public DotShape() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public void draw(Screen screen, int ref, Point centerGrav) {
		screen.drawLineOnScreen(centerGrav, centerGrav, Symbols.DOT_SYMBOL);
	}

}
