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
		degree = 0;
		length = 0;
	}
	
	/**calculate the x2 location of the line.
	 * @post Side affect: x2 gets a new value.
	 */
	public double convertX2() {		
		return getX() + (length*Math.cos(Math.toRadians(degree)));
	}
	
	/**calculate the y2 location of the line.
	 * @post Side affect: y2 gets a new value.
	 */
	public double convertY2() {
		return getX() + (length*Math.sin(Math.toRadians(degree)));

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
		convertX2();
		convertY2();
	}
	
	/**set the length of the line
	 * 
	 * @param l the new length
	 */
	public void setLength(double l) {
		length = l;
		convertX2();
		convertY2();
	}
	

	
	
	
	
	
}
