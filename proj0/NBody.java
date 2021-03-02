public class NBody{
	public static double readRadius(String fileName){
		In in = new In(fileName);
		int n = in.readInt();
		double  r = in.readDouble();
		return r;		
	}
	public static Planet[] readPlanets(String fileName2){
		In in2 = new In(fileName2);
		int n1 = in2.readInt();
		double r = in2.readDouble();
		Planet[] planets = new Planet[n1];
		for (int i = 0; i < n1; i+=1){
			double xp = in2.readDouble();
			double yp = in2.readDouble();
			double xv = in2.readDouble();
			double yv = in2.readDouble();
			double m = in2.readDouble();
			String imgN = in2.readString(); 
			planets[i]= new Planet(xp, yp, xv, yv, m, imgN);
		}
		return planets;

	} 
	public static void main(String[] args){
		StdDraw.enableDoubleBuffering();
		double t0 = Double.parseDouble(args[0]);
		double dt = Double.parseDouble(args[1]);
		String filename = args[2];
		double radius = readRadius(filename);
		Planet[] planets2 = readPlanets(filename);
		StdDraw.setScale(-radius, radius);
		StdDraw.picture(0,0,"images/starfield.jpg");
		for(int i=0; i<planets2.length; i+=1){
			planets2[i].draw();
		}
		for(double t1 = 0; t1 < t0; t1+=dt){
			double[] xForces = new double[planets2.length];
			double[] yForces = new double[planets2.length];
			for (int j = 0; j<planets2.length; j+=1){
				xForces[j] = 
				planets2[j].calcNetForceExertedByX(planets2);
				yForces[j] = 
				planets2[j].calcNetForceExertedByY(planets2);
			}
			for (int z = 0; z < planets2.length; z+=1){
				planets2[z].update(dt, xForces[z], yForces[z]);
			}
			StdDraw.picture(0,0,"images/starfield.jpg");
			for(int z2=0; z2<planets2.length; z2+=1){
			planets2[z2].draw();
		}
		StdDraw.show(10);
		StdDraw.pause(10);
		}
		StdOut.printf("%d\n", planets2.length);
		StdOut.printf("%.2e\n", radius);
		for (int i = 0; i < planets2.length; i++) {
			StdOut.printf("%11.4e %11.4e %11.4e %11.4e %11.4e %12s\n",
				planets2[i].xxPos, planets2[i].yyPos, planets2[i].xxVel,
				planets2[i].yyVel, planets2[i].mass, planets2[i].imgFileName);   
}

		


	}
}