public class Planet{
	public double xxPos;
	public double yyPos;
	public double xxVel;
	public double yyVel;
	public double mass;
	public String imgFileName;
	private static final double g = 6.67e-11;
	public Planet(double xP, double yP, double xV,
              double yV, double m, String img){
		xxPos = xP;
		yyPos = yP;
		xxVel = xV;
		yyVel = yV;
		mass = m;
		imgFileName = img;
	}
	public Planet(Planet p){
		xxPos = p.xxPos;
		yyPos = p.yyPos;
		xxVel = p.xxVel;
		yyVel = p.yyVel;
		mass = p.mass;
		imgFileName = p.imgFileName;

	}
	public double calcDistance(Planet p2){
		double xxDis2 = (this.xxPos - p2.xxPos) * (this.xxPos - p2.xxPos);
		double yyDis2 = (this.yyPos - p2.yyPos) * (this.yyPos - p2.yyPos); 
		double r = Math.sqrt(xxDis2+yyDis2);
		return r;

	}
	public double calcForceExertedBy(Planet p3){
		double f = (g*this.mass*p3.mass)/
		(this.calcDistance(p3)*this.calcDistance(p3));
		return f;
	}
	public double calcForceExertedByX(Planet p4){
		double fx = this.calcForceExertedBy(p4)*
		((p4.xxPos-this.xxPos)/this.calcDistance(p4));
		return fx; 
	}
	public double calcForceExertedByY(Planet p5){
		double fy = this.calcForceExertedBy(p5)*
		((p5.yyPos-this.yyPos)/this.calcDistance(p5));
		return fy; 
	}
	public double calcNetForceExertedByX(Planet [] p6s){
		double fnetx = 0;
		for (int i = 0; i < p6s.length; i+=1 ){
			if (this.equals(p6s[i])){
				continue;
			} double fxi = this.calcForceExertedByX(p6s[i]);
			fnetx = fnetx + fxi;
		}
		return fnetx;
	}
	public double calcNetForceExertedByY(Planet [] p7s){
		double fnety = 0;
		for (int j = 0; j < p7s.length; j+=1 ){
			if (this.equals(p7s[j])){
				continue;
			} double fyj = this.calcForceExertedByY(p7s[j]);
			fnety = fnety + fyj;
		}
		return fnety;
	}
	public void update(double dt, double fX, double fY){
		double aNetX = fX/(this.mass);
		double aNetY = fY/(this.mass);
		this.xxVel = this.xxVel + dt*aNetX;
		this.yyVel = this.yyVel + dt*aNetY;
		this.xxPos = this.xxPos + dt* this.xxVel;
		this.yyPos = this.yyPos + dt* this.yyVel;
	} 
	
	public void draw(){
		String imgName = this.imgFileName; 
		String imgName2 = "images/"+imgName;
		StdDraw.picture(this.xxPos, this.yyPos, imgName2);
	}





}