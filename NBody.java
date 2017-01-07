import  java.util.Scanner;
import  java.io.*;

public class NBody {

	public static double readRadius(String file) throws FileNotFoundException {
		Scanner scan = new Scanner(new File(file));
		scan.next();
		double radius = scan.nextDouble();
		return radius;
	}

	public static Planet[] readPlanets(String file) throws FileNotFoundException {	
		Scanner scan = new Scanner(new File(file));
		int nPlanets = scan.nextInt();
		scan.next();
		Planet[] planets = new Planet[nPlanets];

		for (int i = 0; i < nPlanets; i++) {
			double xP = scan.nextDouble();
			double yP = scan.nextDouble();
			double xVel = scan.nextDouble();
			double yVel = scan.nextDouble();
			double myMass = scan.nextDouble();
			String filename = scan.next();
			planets[i] = new Planet(xP, yP, xVel, yVel, myMass, filename);
		}

		return planets;
	}
	
	public static void main(String[] args) throws FileNotFoundException {
		double T = 157788000.0;
		double dt = 25000.0;
		String pfile = "data/planets.txt";
		String soundfile = "audio/2001.mid";

		if (args.length > 3) {
			T  = Double.parseDouble(args[0]);
			dt = Double.parseDouble(args[1]);
			pfile = args[2];
			soundfile = args[3];
		}	
		
		Planet[] planets = readPlanets(pfile);
		double radius = readRadius(pfile);
		int nPlanets = planets.length;

		StdDraw.setScale(-radius, radius);
		StdAudio.play(soundfile);

		double time = 0;
		while (time < T) {
			StdDraw.picture(0, 0, "images/starfield.jpg");

			double[] xForces = new double[nPlanets];
			double[] yForces = new double[nPlanets];
			for (int i = 0; i < nPlanets; i++) {
				xForces[i] = planets[i].calcNetForceExertedByX(planets);
				yForces[i] = planets[i].calcNetForceExertedByY(planets);
			}

			for (int i = 0; i < nPlanets; i++) {
				planets[i].update(dt, xForces[i], yForces[i]);
				planets[i].draw();
			}

			StdDraw.show(10);
			time += dt;
		}
	}
}
