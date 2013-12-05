package Projectiles;

import ProcessingManagers.TimeManager;
import Screen.Screen;
import Shapes.DotShape;
import Shapes.Point;

public class SimpleShell extends Projectile {
	
	private final int id = 8;
	
	public SimpleShell(Screen screen, int ref, TimeManager currentTime) {
		super(screen, ref, currentTime);
	}

	@Override
	public void shoot(int dist, Point shooterPosition) {
		this.shapeChangingDist = Integer.MAX_VALUE;
		this.shape = new DotShape();
		
		hitScreenAction(shooterPosition, ref);
	}

	@Override
	protected void hitScreenAction(Point shooterPosition, int ref) {
		this.shape.draw(this.screen, ref, shooterPosition);
	}

}
