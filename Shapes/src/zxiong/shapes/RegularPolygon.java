package zxiong.shapes;
import processing.core.PApplet;

public class RegularPolygon extends Shape{

	//FIELDS
	private int n;
	private double s;
	
	// CONSTRUCTORS
	/** 
	 * Creates a default instance of a triangle.
	 * @post A triangle with side length of 100 is created at 100,100.
	 */
	 public RegularPolygon(){
		 super(100,100);
		 n = 3;
		 s = 100;
	 }
	 
	 /**
	  * Create a instance of a regular polygon.
	  * @param x x coordinate of the center
	  * @param y y coordinate of the center
	  * @param n number of sides
	  * @param s length of sides
	  * @pre all dimensions but be positive except for length
	  * @post a regular polygon with center coordinate x,y, sides of n, and side length of s is created.
	  */
	 public RegularPolygon(double x, double y, int n, double s) {
		 super(x,y);
		 this.n = n;
		 this.s = s;
	 }

	 
	 //METHODS
	 /**
	  * Calculate the radius of the inner circle
	  * @return the radius of the inner circle
	  */
	 public double calcr(){
		 return s/(2*Math.tan(Math.PI/n));
	 }
	 
	 /**
	  * calculate the radius of the outer circle
	  * @return the radius of the outer circle
	  */
	 public double calcR(){
		 return s/(2*Math.sin(Math.PI/n));
	 }
	 
	 /**
	  * calculate the vertex angle
	  * @return the vertex angle
	  */
	 public double calcVertexAngle(){
		 return 180*(n-2)/n;
	 }
	 
	 /**
	  * calculate the perimeter
	  * @return the perimeter
	  */
	 public double getPerimeter(){
		 return n*s;
	 }

	 /**
	  * calculate the area
	  * @return the area
	  */
	 public double getArea(){
		 return n*Math.pow(calcR(), 2)*Math.sin(2*Math.PI/n)/2;
	 }
	 
	 /**
	  * get the number of sides
	  * @return the number of sides
	  */
	 public int getNumSides(){
		 return n;
	 }
	 
	 /**
	  * get the length of sides
	  * @return the length of sides
	  */
	 public double getSideLength(){
		 return s;
	 }
	 
	 /**
	  * calculate the inner angle 
	  * @return the inner angle 
	  */
	 public double getInnerAngle() {
		 return 360.0/n;
	 }
	 
	 /** Draws a new instance of a polygon object.
	 *@param marker The surface PApplet draws on.
	 */
	 public void draw(PApplet marker){
		 super.draw(marker);
	 
		 Line[] l = new Line[n];
		 Line[] l2 = new Line[n];
		 
		 double d = getInnerAngle();

		 for (int a=0; a<n; a++) {
			 l[a] = new Line(getX(),getY(),d*a,calcR(),true);		 
			 l2[a] = new Line(getX(),getY(),d*(a+1),calcR(),true);
			 
			 marker.line((float)l[a].getX2(), (float)l[a].getY2(), (float)l2[a].getX2(), (float)l2[a].getY2());		 
		 }
 
	 }

	/**Determines whether the point x,y is contained inside this polygon.
	* @param x The X-coordinate of the point.
	* @param y The Y-coordinate of the point.
	* @return True if point is inside, false if point is outside.
	*/
	public boolean isPointInside(double x, double y) {
	    if(Math.sqrt(Math.pow(this.getX()-x, 2.0)+Math.pow(this.getY()-y, 2.0)) <= calcr())
            return true;
        else
            return false;
	}

	/**
	 * set everything to zero
	 * @post every dimention set to zero
	 */
	public void reset() {
		super.setX(0);
		super.setY(0);
		n=0;
		s=0;
	}

	/**
	 * scale the size of the polygon by a factor
	 * @param factor the factor the scale
	 */
	public void scale(double factor) {
		// TODO Auto-generated method stub
		s *= factor;
	}


}
