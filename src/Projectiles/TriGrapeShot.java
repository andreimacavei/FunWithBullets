package Projectiles;

import ProcessingManagers.TimeManager;
import Screen.Screen;
import Shapes.Point;
import Shapes.TriangleShape;

/**
 * The class for the projectile type "trigrapeshot". This projectile
 * can change its shape transforming into "shrapnel".
 * Represented on the screen by a "triangle" shape.
 * 
 * @author Macavei Andrei-Gabriel
 *
 */
public class TriGrapeShot extends Shrapnel {

	private final int id = 1;
	
	public TriGrapeShot(Screen screen, int ref, TimeManager currentTime) {
		super(screen, ref, currentTime);
	}

	@Override
	public void shoot(int dist, Point shooterPosition) {
		this.shapeChangingDist = 42 + 
				(this.id  * this.id * this.currentTime.getHours() +
				this.id * this.currentTime.getMinutes() + 
				this.currentTime.getSeconds()) % 42;
		this.shape = new TriangleShape();

		
		if (dist < this.shapeChangingDist) {
			int dx = dist;
			int dy = 0;
			shooterPosition = shooterPosition.translate(dx, dy);
			int dref = -(dist/10) - this.id;
			
			hitScreenAction(shooterPosition, ref + dref);
		} else {
			int dx = this.shapeChangingDist;
			int dy = 0;
			shooterPosition = shooterPosition.translate(dx, dy);
			int dref = -(this.shapeChangingDist/10) - this.id;
			
			super.setRef(ref + dref);
			super.shoot(dist - shapeChangingDist, shooterPosition);
		}
	}

	@Override
	protected void hitScreenAction(Point shooterPosition, int ref) {
		this.shape.draw(this.screen, ref, shooterPosition);
	}
}
