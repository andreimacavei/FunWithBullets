package Projectiles;

import ProcessingManagers.TimeManager;
import Screen.Screen;
import Shapes.Point;
import Shapes.SquareShape;

/**
 * The class for the projectile type "carcass". This projectile
 * can change its shape transforming into "heatedshot".
 * Represented on the screen by a "square" shape.
 * 
 * @author Macavei Andrei-Gabriel
 *
 */
public class Carcass extends HeatedShot {

	private final int id = 2;
	
	public Carcass(Screen screen, int ref, TimeManager currentTime) {
		super(screen, ref, currentTime);
	}
	
	@Override
	public void shoot(int dist, Point shooterPosition) {
		this.shapeChangingDist = 42 + 
				(this.id * this.id * this.currentTime.getHours() +
				this.id * this.currentTime.getMinutes() + 
				this.currentTime.getSeconds()) % 42;
		this.shape = new SquareShape();
		
		if (dist < this.shapeChangingDist) {
			int dx = 0;
			int dy = dist;
			shooterPosition = shooterPosition.translate(dx, dy);
			int dref = -(dist/10) - this.id;
			
			hitScreenAction(shooterPosition, ref + dref);
		} else {
			int dx = 0;
			int dy = this.shapeChangingDist;
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
