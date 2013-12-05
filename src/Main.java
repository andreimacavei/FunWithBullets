import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

import Constants.ProjectileNames;
import ProcessingManagers.TimeManager;
import Projectiles.CanisterShot;
import Projectiles.Carcass;
import Projectiles.ChainShot;
import Projectiles.HeatedShot;
import Projectiles.Projectile;
import Projectiles.Shrapnel;
import Projectiles.SimpleShell;
import Projectiles.SpiderShot;
import Projectiles.TriGrapeShot;
import Screen.Screen;
import Shapes.Point;

public class Main {

	public static void main(String[] args) throws IOException {
		
		BufferedReader in = null;
		FileWriter out = null;
		
		try {
			in = new BufferedReader(new FileReader(args[0]));
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		
		try {
			out = new FileWriter(args[0] + "_out");
		} catch (IOException e) {
			e.printStackTrace();
		}
		// Getting the screen coordinates
		String line = in.readLine();
		String[] lineAtoms = line.split(" ");
		int ex = Integer.parseInt(lineAtoms[0]);
		int ey = Integer.parseInt(lineAtoms[1]);
		Screen scr = new Screen(ex, ey);
		
		final int N = Integer.parseInt(in.readLine());
		// Parsing N lines
		while((line = in.readLine()) != null) {
			String[] tokens = line.split(" ");
			
			String projectileName = tokens[0];
			int ref = Integer.parseInt(tokens[1]);
			String time = tokens[2];
			TimeManager currentTime = new TimeManager(time);
			
			int dist = Integer.parseInt(tokens[3]);
			int posx = Integer.parseInt(tokens[4]);
			int posy = Integer.parseInt(tokens[5]);
			Point shooterPosition = new Point(posx, posy);
			
			shootProjectile(projectileName, scr, ref, currentTime, dist, shooterPosition);
			
		}
		
		scr.writeScreen(out);
		
		try {
			in.close();
		} catch (IOException e) {
			System.out.println("Error closing file " + args[0]);
		}
		try {
			out.close();
		} catch (IOException e) {
			System.out.println("Error closing file " + args[1]);
		}
	}
	
	public static void shootProjectile(String projectileName,
			Screen screen, int ref, TimeManager currentTime,
			int dist, Point shooterPosition) {
		
		if (projectileName.equals(ProjectileNames.CANNISTER_SHOT)) {
			Projectile canisterShot = new CanisterShot(screen, ref, currentTime);
			canisterShot.shoot(dist, shooterPosition);
			
		} else if (projectileName.equals(ProjectileNames.CARCASS)) {
			Projectile carcass = new Carcass(screen, ref, currentTime);
			carcass.shoot(dist, shooterPosition);
			
		} else if (projectileName.equals(ProjectileNames.CHAIN_SHOT)) {
			Projectile chainShot = new ChainShot(screen, ref, currentTime);
			chainShot.shoot(dist, shooterPosition);
			
		} else if (projectileName.equals(ProjectileNames.HEATED_SHOT)) {
			Projectile heatedShot = new HeatedShot(screen, ref, currentTime);
			heatedShot.shoot(dist, shooterPosition);
			
		} else if (projectileName.equals(ProjectileNames.SHRAPNEL)) {
			Projectile shrapnel = new Shrapnel(screen, ref, currentTime);
			shrapnel.shoot(dist, shooterPosition);
			
		} else if (projectileName.equals(ProjectileNames.SIMPLE_SHELL)) {
			Projectile simpleShell = new SimpleShell(screen, ref, currentTime);
			simpleShell.shoot(dist, shooterPosition);
		} else if (projectileName.equals(ProjectileNames.SPIDER_SHOT)) {
			Projectile spiderShot = new SpiderShot(screen, ref, currentTime);
			spiderShot.shoot(dist, shooterPosition);
			
		} else if (projectileName.equals(ProjectileNames.TRI_GRAPE_SHOT)) {
			Projectile triGrapeShot = new TriGrapeShot(screen, ref, currentTime);
			triGrapeShot.shoot(dist, shooterPosition);
			
		} else {
			System.out.println("Undefined projectile type");
			return;
		}
	}
}
