import processing.core.PApplet;

public class Rectangle {
	
	/**Fields**/
	private double x, y, width, height;
	
	/** Creates a default instance of a Rectangle object with all dimensions set to zero.**/
	public Rectangle() {
		x = 0;
		y = 0;
		width = 0;
		height = 0;
	}
	
	/** Creates a new instance of a Rectangle object with the left and right
	 edges of the rectangle at x and x + width. The top and bottom edges
	 are at y and y + height.**/
	public Rectangle(double x, double y, double width, double height) {
		this.x = x;
		this.y = y;
		this.width = width;
		this.height = height;
	}

	/**Calculates and returns the parimeter of the rectangle**/
	public double getPerimeter() {
		return 2*(Math.abs(width) + Math.abs(height));	
	}
	
	/**Calculates and returns the area of the rectangle**/
	public double getArea() {
		return Math.abs(width*height);	
	}
	
	/**Determines whether the point x,y is contained inside this rectangle**/
	public boolean isPointInside(double x, double y) {
		if((x>this.x && x<(this.x+width)) && (y>this.y && y<(this.y+height)))
			return true;
		else
			return false;	
	}
	
	/** Draws a new instance of a Rectangle object with the left and right
	 edges of the rectangle at x and x + width. The top and bottom edges
	 are at y and y + height.**/
	public void draw(PApplet marker) {
		marker.rect((float)x,(float)y,(float)(x+width),(float)(y+height));
	}
	
	/**Set new dimension of a rect**/
	public void setPosition(double x, double y, double width, double height) {
		this.x = x;
		this.y = y;
		this.width = width;
		this.height = height;
	}
	
	/**Reset all dimension of a rect to zero**/
	public void reset() {
		x = 0;
		y = 0;
		width = 0;
		height = 0;
	}

}
