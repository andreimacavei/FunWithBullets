package Projectiles;

import ProcessingManagers.TimeManager;
import Screen.Screen;
import Shapes.Point;
import Shapes.RectangleShape;

/**
 * The class for the projectile type "spidershot". This projectile
 * can change its shape transforming into "simpleshell".
 * Represented on the screen by a "rectangle" shape.
 * 
 * @author Macavei Andrei-Gabriel
 *
 */
public class SpiderShot extends SimpleShell {
	
	private final int id = 7;
	
	public SpiderShot(Screen screen, int ref, TimeManager currentTime) {
		super(screen, ref, currentTime);
	}
	
	@Override
	public void shoot(int dist, Point shooterPosition) {
		this.shapeChangingDist = 42 + 
				(this.id * this.id * this.currentTime.getHours() +
				this.id * this.currentTime.getMinutes() + 
				this.currentTime.getSeconds()) % 42;
		this.shape = new RectangleShape();
		
		if (dist < this.shapeChangingDist) {
			// New coords after trajectory calculation
			int dx = (int) Math.round(Math.sin((dist * Math.PI) / 2));
			int dy = (int) Math.round(Math.cos((dist * Math.PI) / 2));
			shooterPosition = shooterPosition.translate(dx, dy);
			int dref = -(dist/10) - this.id;
			
			hitScreenAction(shooterPosition, ref + dref);
		} else {
			int dx = (int) Math.round(Math.sin((this.shapeChangingDist
								* Math.PI) / 2));
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
