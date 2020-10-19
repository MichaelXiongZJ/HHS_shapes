package zxiong.shapes;

import java.awt.Color;

import processing.core.PApplet;

public abstract class Shape {


	//FIELDS
	private double x;
	private double y;
	private int strokeWidth;
	private Color strokeColor;
	private Color fillColor;
	private boolean filled;
	
	//CONSTRUCTORS
	/** Creates a new instance of a Shape object with the coordinates of x and y.
	 *
	 * @param x X-coordinate.
	 * @param y Y-coordinate.
	 * @pre all dimensions must be positive.
	 * @post a shape is created.
	 */
	public Shape(double x, double y) {
		this.x = x;
		this.y = y;	
		strokeColor = Color.BLACK;
		filled = true;
		fillColor = Color.WHITE;
		strokeWidth = 2;
	}
	
	
	//METHODS	
	/**Calculates and returns the parimeter of the shape.
	 * @return The preimeter of the rectangle.
	 */
	public abstract double getPerimeter();
	
	/**Calculates and returns the area of the rectangle.
	 * @return The area of rectangle.
	 */
	public abstract double getArea();
	
	/**Determines whether the point x,y is contained inside this rectangle.
	 * @param x The X-coordinate of the point.
	 * @param y The Y-coordinate of the point.
	 * @return True if point is inside, false if point is outside.
	 */
	public abstract boolean isPointInside(double x, double y);
	
	/**Reset all dimension of a rect to zero.
	 * @post Side affect: All dimension reset to zero.
	 */
	public abstract void reset();
	
	/**Scale the shape by the input value.
	 * 
	 * @param factor the factor value.
	 */
	public abstract void scale(double factor);
	
	
	/**Return the x-coordinate of the shape.
	 * 
	 * @return x-coordinate.
	 */
	public double getX() {
		return x;
	}
	
	/**Return the y-coordinate of the shape.
	 * 
	 * @return y-coordinate.
	 */
	public double getY() {
		return y;
	}
	
	/**Set the x-coordinate as x.
	 * 
	 * @param x the new x-coordinate.
	 * @post Side affect: The x-coordinate changes to x.
	 */
	public void setX(double x) {
		this.x = x;
	}
	
	/**Set the y-coordinate as y.
	 * 
	 * @param y the new y-coordinate.
	 * @post Side affect: The y-coordinate changes to y.
	 */
	public void setY(double y) {
		this.y = y;
	}
	
	/**Set the stroke color.
	 * 
	 * @param c The new stroke color.
	 * @post Side affect: Stroke color changes to c.
	 */
	public void setStroke(Color c) {
		this.strokeColor = c;
	}
	
	/**Set the fill color.
	 * 
	 * @param c The new fill color.
	 * @post Side affect: fill color changes to c.
	 */
	public void setFill(Color c) {
		this.fillColor = c;
	}
	
	/**Set the shape filled.
	 * 
	 * @param f a boolean that tells if the shape is filled.
	 * @post the fill state will be updated.
	 */
	public void setFilled(boolean f) {
		this.filled = f;
	}
	
	/**Set the width of the stroke width.
	 * 
	 * @param w width of the stroke.
	 * @post width of stroke become w.
	 */
	public void setStrokeWidth(int w) {
		this.strokeWidth = w;
	}

	/**A drawing surface that will set a random color of the shape.
	 * @param surface The surface PApplet draws on.
	 */
	public void draw(PApplet surface) {
		if (filled) {
			surface.fill(fillColor.getRed(), 
					fillColor.getGreen(),
					fillColor.getBlue());
		} else {
			surface.noFill();
		}
		surface.strokeWeight(strokeWidth);
		surface.stroke(strokeColor.getRed(), 
				strokeColor.getGreen(), 
				strokeColor.getBlue());
	}
	
}
