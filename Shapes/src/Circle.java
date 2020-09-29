import processing.core.PApplet;

public class Circle {
	
	/**Fields**/
	private double x, y, radius;
	
	/** Creates a default instance of a Circle object with all dimensions set to zero.**/
	public Circle() {
		x = 0;
		y = 0;
		radius = 0;
	}
	/** Creates a new instance of a Circle object**/
	public Circle(double x, double y, double radius) {
		this.x = x;
		this.y = y;
		this.radius = radius;
	}

	/**Calculates and returns the parimeter of the Circle**/
	public double getPerimeter() {
		return 2*radius*Math.PI;
	}
	
	/**Calculates and returns the area of the Circle**/
	public double getArea() {
		return Math.PI*Math.pow(radius,2);
	}
	
	/**Determines whether the point x,y is contained inside this Circle**/
	public boolean isPointInside(double x, double y) {
        if(Math.sqrt(Math.pow(this.x-x, 2.0)+Math.pow(this.y-y, 2.0)) <= radius)
            return true;
        else
            return false;
    }
	
	/** Draws a new instance of a Circle object**/
	public void draw(PApplet marker) {
		marker.circle((float)x,(float)y,(float)(radius));
	}
	
	/**Set new dimension of a circle**/
	public void setDimension(double x, double y, double radius) {
		this.x = x;
		this.y = y;
		this.radius = radius;
	}
	
	/**Reset all dimension of a circle to zero**/
	public void reset() {
		x = 0;
		y = 0;
		radius = 0;
	}

}
