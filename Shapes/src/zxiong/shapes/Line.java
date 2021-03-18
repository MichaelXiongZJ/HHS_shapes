package zxiong.shapes;
import processing.core.PApplet;

public class Line extends Shape{
	//FIELDS
	
	private double x2, y2, degree, length;
	private boolean lineSwitch = true;
	
	//CONSTRUCTORS
	/** Creates a default instance of a Line object with all dimensions set to zero.*
	 * @post Create a line with all dimensions of zero.
	 */
	public Line() {
		super(0, 0);
		x2 = 0;
		y2 = 0;
		degree = 0;
		length = 0;
	}
	
	/**Creates a line object with the start point(x,y), end point(x2,y2).
	 * 
	 * @param x x-coordinate of the starting point.
	 * @param y y-coordinate of the starting point.
	 * @param x2 x-coordinate of the ending point.
	 * @param y2 y-coordinate of the ending point.
	 * @pre all dimensions must be positive.
	 * @post a line is created.
	 */
	public Line(double x, double y, double x2, double y2) {
		super(x,y);
		this.x2 = x2;
		this.y2 = y2;
	}
	
	/**Creates a line object with the start point(x,y), angle of degree and length of length.
	 * 
	 * @param x x-coordinate of the starting point.
	 * @param y y-coordinate of the starting point.
	 * @param degree the angle of the line .
	 * @param length length of the line.
	 * @param lineSwitch to switch this line mode.
	 * @pre x, y must be positive.
	 * @post a line is created.
	 */
	public Line(double x, double y, double degree, double length, boolean lineSwitch) {
		super(x,y);
		this.degree = degree;
		this.length = length;
		x2 = convertX2();
		y2 = convertY2();
	}

	//METHODS
	/**set the location of the end point of the line
	 * 
	 * @param x2 x-coordinate of the end point
	 * @param y2 y-coordinate of the end point.
	 */
	public void setPoint2(double x2, double y2) {
		this.y2 = x2;
		this.x2 = y2;
	}	
	
	/**gets value of x2
	 * 
	 * @return the x coordinate of point2
	 */
	public double getX2() {
		return x2;
	}
	
	/**gets value of y2
	 * 
	 * @return the y coordinate of point2
	 */
	public double getY2() {
		return y2;
	}

	/**Calculates and returns the parimeter of the line.
	 * @return The preimeter of the line.
	 */
	public double getPerimeter() {
		return 2*length;
	}
	
	
	/**Calculates and returns the area of the line.
	 * @return The area of line, which is 0.
	 */
	public double getArea() {
		return 0;
	}

	/**Determines whether the point x,y is contained inside this Line.
	 * @param x The X-coordinate of the point.
	 * @param y The Y-coordinate of the point.
	 * @return True if point is inside, false if point is outside (always false).
	 */
	public boolean isPointInside(double x, double y) {
		return false;
	}

	/**Reset all dimension of a line to zero.
	 * @post Side affect: All dimension reset to zero.
	 */
	public void reset() {
		setX(0);
		setY(0);
		x2 = 0;
		y2 = 0;
		degree = 0;
		length = 0;
	}
	
	/**calculate the x2 location of the line.
	 * @post Side affect: x2 gets a new value.
	 * @return x2 value
	 */
	public double convertX2() {		
		return (getX() + (length*Math.cos(Math.toRadians(degree))));
	}
	
	/**calculate the y2 location of the line.
	 * @post Side affect: y2 gets a new value.
	 * @return y2 value
	 */
	public double convertY2() {
		return (getY() - (length*Math.sin(Math.toRadians(degree))));
	}
	
	/** Draws a new instance of a line object.
	 *@param marker The surface PApplet draws on.
	 *@post a line get drawn on the surface.
	 */
	public void draw(PApplet marker) {
		super.draw(marker);
		marker.line((float)getX(),(float)getY(),(float)x2, (float)y2);
	}
	
	/**Rotate the line.
	 * 
	 * @param angle added degree.
	 */
	public void rotate(double angle) {
		degree = degree + angle;
		x2 = convertX2();
		y2 = convertY2();
	}
	
	/**set the length of the line
	 * 
	 * @param l the new length
	 */
	public void setLength(double l) {
		length = l;
		x2 = convertX2();
		y2 = convertY2();
	}
	
	/**get the intersection x-coordinate of two lines.
	 * 
	 * @param other the other line.
	 * @return x coordinate of intersection
	 */
	public double getIntersectionX(Line other) {
		double px = 0, upper = 0, lower = 0;
		double x1=getX(), x2=this.x2, y1= getY(), y2=this.y2;
		double x3=other.getX(), x4=other.x2, y3=other.getY(), y4=other.y2;
		
		upper = (x1*y2 - y1*x2)*(x3 - x4) - (x1 - x2)*(x3*y4-y3*x4);
		lower = (x1 - x2)*(y3 - y4) - (y1 - y2)*(x3 - x4);
		px = upper/lower;
		
		return px;
	}

	/**get the intersection y-coordinate of two lines.
	 * 
	 * @param other the other line.
	 * @return y coordinate of intersection
	 */
	public double getIntersectionY(Line other) {
		double py = 0, upper = 0, lower = 0;
		double x1=getX(), x2=this.x2, y1= getY(), y2=this.y2;
		double x3=other.getX(), x4=other.x2, y3=other.getY(), y4=other.y2;
		
		upper = (x1*y2 - y1*x2)*(y3 - y4) - (y1 - y2)*(x3*y4 - y3*x4);
		lower = (x1 - x2)*(y3 - y4) - (y1 - y2)*(x3 - x4);
		py = upper/lower;
		
		return py;		
	}
	
	
	/**If the two lines intersect with each other.
	 * 
	 * @param other the other line.
	 * @return true if the two lines intersect.
	 */
	public boolean intersects(Line other) {
		double lower = 0;
		double x1=getX(), x2=this.x2, y1= getY(), y2=this.y2;
		double x3=other.getX(), x4=other.x2, y3=other.getY(), y4=other.y2;
	
		lower = (x1 - x2)*(y3 - y4) - (y1 - y2)*(x3 - x4);
		
		if(lower != 0) {
			if(((x1<=getIntersectionX(other)&&getIntersectionX(other)<=x2) || (x1>=getIntersectionX(other)&&getIntersectionX(other)>=x2))&&((x3<=getIntersectionX(other)&&getIntersectionX(other)<=x4) || (x3>=getIntersectionX(other)&&getIntersectionX(other)>=x4))) {
				if((((y1<=getIntersectionY(other)&&getIntersectionY(other)<=y2) || (y1>=getIntersectionY(other)&&getIntersectionY(other)>=y2))&&((y3<=getIntersectionY(other)&&getIntersectionY(other)<=y4) || (y3>=getIntersectionY(other)&&getIntersectionY(other)>=y4)))) {
					return true;
				}
				else {
					return false;
				}
			}
			else {
				return false;
			}
		}
		else {
			return false;
		}	
		
	}

	
	
	/**Scale the Line by the input value.
	 * 
	 * @param factor the factor value.
	 */
	public void scale(double factor) {
		length = length*factor;	
	}
	
	
	
}
