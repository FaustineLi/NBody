
public class NBody {
	
	public static void main(String[] args){
		double T = 157788000.0;
		double dt = 25000.0;
		String pfile = "data/planets.txt";
		if (args.length > 2) {
			T = Double.parseDouble(args[0]);
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
