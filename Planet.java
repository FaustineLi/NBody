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
		double dx = myXPos - p.myXPos; 
		double dy = myYPos - p.myYPos;
		double dist = Math.sqrt(dx * dx + dy * dy);
		return dist;
	}

	public double calcForceExertedBy(Planet p) {
		double g = 6.67e-11;
		double r = calcDistance(p);
		double force = g * myMass * p.myMass / (r * r);
		return force;
	}

	public double calcForceExertedByX(Planet p) {
		double force = calcForceExertedBy(p);
		double dx = p.myXPos - myXPos;
		double r = calcDistance(p);
		double fx = dx * force / r;
		return fx;
	}

	public double calcForceExertedByY(Planet p) {
		double force = calcForceExertedBy(p);
		double dy = p.myYPos - myYPos;
		double r = calcDistance(p);
		double fx = dy * force / r;
		return fx;
	}

	public double calcNetForceExertedByX(Planet[] planets) {
		double net = 0;
		for (Planet p : planets) {
			if (! p.equals(this)) {
				net += calcForceExertedByX(p);
			}
		}
		return net;
	}

	public double calcNetForceExertedByY(Planet[] planets) {
		double net = 0;
		for (Planet p : planets) {
			if (! p.equals(this)) {
				net += calcForceExertedByY(p);
			}
		}
		return net;
	}

	public void update(double dt, double xforce, double yforce) {
		double ax = xforce / myMass;
		double ay = yforce / myMass;
		myXVel = myXVel + ax * dt;
		myYVel = myYVel + ay * dt;
		myXPos = myXPos + myXVel * dt;
		myYPos = myYPos + myYVel * dt;
	}

	public void draw() {
		String picFile = "images/" + myFileName;
		StdDraw.picture(myXPos, myYPos, picFile);
	}
}