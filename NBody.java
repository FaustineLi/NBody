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
	
	public static void main(String[] args) {
		double T = 157788000.0;
		double dt = 25000.0;
		String pfile = "data/planets.txt";

		if (args.length > 2) {
			T  = Double.parseDouble(args[0]);
			dt = Double.parseDouble(args[1]);
			pfile = args[2];
		}	
		
		Planet[] planets = null;
		double radius = 0.0;
	
		System.out.printf("%d\n", planets.length);
		System.out.printf("%.2e\n", radius);
		for (int i = 0; i < planets.length; i++) {
		    System.out.printf("%11.4e %11.4e %11.4e %11.4e %11.4e %12s\n",
		   		              planets[i].myXPos, planets[i].myYPos, 
		                      planets[i].myXVel, planets[i].myYVel, 
		                      planets[i].myMass, planets[i].myFileName);	
		}
	}
}
