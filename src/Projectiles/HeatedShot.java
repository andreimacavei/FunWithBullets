package Projectiles;

import ProcessingManagers.TimeManager;
import Screen.Screen;
import Shapes.Point;
import Shapes.RhombusShape;

/**
 * The class for the projectile type "heatedshot". This projectile
 * can change its shape transforming into "spidershot".
 * Represented on the screen by a "rhombus" shape.
 * 
 * @author Macavei Andrei-Gabriel
 *
 */
public class HeatedShot extends SpiderShot {

	private final int id = 6;
	
	public HeatedShot(Screen screen, int ref, TimeManager currentTime) {
		super(screen, ref, currentTime);
	}
	
	@Override
	public void shoot(int dist, Point shooterPosition) {
		this.shapeChangingDist = 42 + 
				(this.id  * this.id * this.currentTime.getHours() +
				this.id * this.currentTime.getMinutes() + 
				this.currentTime.getSeconds()) % 42;
		this.shape = new RhombusShape();

		if (dist < this.shapeChangingDist) {
			int dx = 0;
			int dy = (int) Math.round(Math.cos((dist * Math.PI) / 2));
			shooterPosition = shooterPosition.translate(dx, dy);
			int dref = -(dist/10) - this.id;
			
			hitScreenAction(shooterPosition, ref + dref);
		} else {
			int dx = 0;
			int dy = (int) Math.round(Math.cos((this.shapeChangingDist 
					* Math.PI) / 2));
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
