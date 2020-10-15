package zxiong.shapes;
import processing.core.PApplet;

public class Rectangle extends Shape {
	
	private double width, height;
	
	/** Creates a default instance of a Rectangle object with all dimensions set to zero.*
	 * @post Create a rectangle with all dimensions of zero
	 */
	public Rectangle(){
		super(0,0);
		width = 0;
		height = 0;
	}
	
	/** Creates a new instance of a Rectangle object with the left and right
	 edges of the rectangle at x and x + width. The top and bottom edges
	 are at y and y + height.
	 *
	 * @param x X-coordinate
	 * @param y Y-coordinate
	 * @param width width of the rectangle
	 * @param height height of the rectangle
	 * @post Side affect: Dimension set to imported values
	 */
	public Rectangle(double x, double y, double width, double height) {
		super(x,y);
		this.width = width;
		this.height = height;
	}

	/**Calculates and returns the parimeter of the rectangle
	 * @return The preimeter of the rectangle
	 */
	public double getPerimeter() {
		return 2*(Math.abs(width) + Math.abs(height));	
	}
	
	/**Calculates and returns the area of the rectangle
	 * @return The area of rectangle
	 */
	public double getArea() {
		return Math.abs(width*height);	
	}
	
	/**Determines whether the point x,y is contained inside this rectangle
	 * @param x The X-coordinate of the point
	 * @param y The Y-coordinate of the point
	 * @return True if point is inside, false if point is outside
	 */
	public boolean isPointInside(double x, double y) {
		if((x>this.getX() && x<(this.getX()+width)) && (y>this.getY() && y<(this.getY()+height)))
			return true;
		else
			return false;	
	}
	
	/** Draws a new instance of a Rectangle object with the left and right
	 edges of the rectangle at x and x + width. The top and bottom edges
	 are at y and y + height.
	 *@param marker The surface PApplet draws on
	 */
	public void draw(PApplet marker) {
		super.draw(marker);
		marker.rect((float)getX(),(float)getY(),(float)(getX()+width),(float)(getY()+height));
	}
	
	/**Set new dimension of a rectangle
	 * @param x x-coordinate of the rectangle
	 * @param y y-coordinate of the rectangle
	 * @param width Width of the rectangle
	 * @param height Height of the rectangle
	 * @post Side affect: the dimensions of the rectangle will be the input values
	 */
	public void setDimension(double x, double y, double width, double height) {
		setX(x);
		setY(y);
		this.width = width;
		this.height = height;
	}
	
	/**Reset all dimension of a rect to zero
	 * @post Side affect: All dimension reset to zero
	 */
	public void reset() {
		setX(0);
		setY(0);
		width = 0;
		height = 0;
	}

}
