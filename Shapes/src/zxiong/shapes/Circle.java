package zxiong.shapes;
import processing.core.PApplet;

public class Circle extends Shape{
	
	private double radius;
	
	/** Creates a default instance of a Circle object with all dimensions set to zero.
	 * @post Create a circle with all dimensions of zero.
	 */
	public Circle() {
		super(0,0);
		radius = 0;
	}
	
	/** Creates a new instance of a Circle object.
	 * @param x X-coordinate.
	 * @param y Y-coordinate.
	 * @param radius Radius of the circle.
	 * @post Side affect: Dimension set to imported values.
	 */
	public Circle(double x, double y, double radius) {
		super(x,y);
		this.radius = radius;
	}

	/**Calculates and returns the parimeter of the Circle.
	 * @return The preimeter of the circle.
	 */
	public double getPerimeter() {
		return 2*radius*Math.PI;
	}
	
	/**Calculates and returns the area of the Circle.
	 * @return The area of circle.
	 */
	public double getArea() {
		return Math.PI*Math.pow(radius,2);
	}
	
	/**Determines whether the point x,y is contained inside this Circle.
	 * @param x The X-coordinate of the point.
	 * @param y The Y-coordinate of the point.
	 * @return True if point is inside, false if point is outside.
	 */
	public boolean isPointInside(double x, double y) {
        if(Math.sqrt(Math.pow(this.getX()-x, 2.0)+Math.pow(this.getY()-y, 2.0)) <= radius)
            return true;
        else
            return false;
    }
	
	/** Draws a new instance of a circle object with the left and right
	 edges of the circle at x and x + width. The top and bottom edges
	 are at y and y + height.
	 *@param marker The surface PApplet draws on.
	 */
	public void draw(PApplet marker) {
		super.draw(marker);
		marker.circle((float)getX(),(float)getY(),(float)(radius));

	}
	
	/**Set new dimension of a circle.
	 * @param x x-coordinate of the circle.
	 * @param y y-coordinate of the circle.
	 * @param radius Radius of the circle.
	 * @pre all dimensions must be positive.
	 * @post Side affect: the dimensions of the circle will be the input values.
	 */
	public void setDimension(double x, double y, double radius) {
		setX(x);
		setY(y);
		this.radius = radius;
	}
	
	/**Reset all dimension of a circle to zero.
	 * @post Side affect: All dimension reset to zero.
	 */
	public void reset() {
		setX(0);
		setY(0);
		radius = 0;
	}


}
