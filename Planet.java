import java.lang.Math.*;

public class Planet {
	
	double myXPos;
	double myYPos;
	double myXVel;
	double myYVel;
	double myMass;
	String myFileName;

	public Planet(double xP, double yP, double xV, double yV, 
		          double m, String img) {
		myXPos = xP;
		myYPos = yP;
		myXVel = xV;
		myYVel = yV;
		myMass = m;
		myFileName = img;
	}

	public Planet(Planet p) {
		myXPos = p.myXPos;
		myYPos = p.myYPos;
		myXVel = p.myXVel;
		myYVel = p.myYVel;
		myMass = p.myMass;
		myFileName = p.myFileName;
	}

	public double calcDistance(Planet p) {
		double dist = Math.sqrt(p.myXPos * p.myXPos + p.myYPos * p.myYPos);
		return dist;
	}
}