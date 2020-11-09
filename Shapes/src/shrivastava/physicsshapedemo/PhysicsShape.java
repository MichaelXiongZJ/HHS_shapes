package shrivastava.physicsshapedemo;

import processing.core.PApplet;
import zxiong.shapes.*;

public class PhysicsShape {

	private Shape s;
	private double vx, vy;
	private double friction;

	public PhysicsShape(Shape s) {
		this.s = s;
		vx = 0;
		vy = 0;
		friction = 0.95;

	}

	public void draw(PApplet surface) {
		s.draw(surface);

	}

//	no user input
	public void act(Rectangle window) {
		bounceOffWindow(window);
	}

	public void bounceOffWindow(Rectangle window) {
		double x = s.getX();
		x += vx;
		s.setX(x);

		if (!window.isPointInside(s.getX(), s.getY())) {
			vx = -vx;
			x += vx;
			s.setX(x);
		}

		double y = s.getY();
		y += vy;
		s.setY(y);
		if (!window.isPointInside(s.getX(), s.getY())) {
			vy = -vy;
			y += vy;
			s.setY(y);
		}
		applyFriction();
	}

	public void accelerate(double ax, double ay) {
		vx += ax;
		vy += ay;
	}

	public void applyFriction() {
		vx *= friction;
		vy *= friction;
	}

	public boolean isPointInside(double x, double y) {
		return s.isPointInside(x, y);
	}

	public Shape getShape() {
		return s;
	}

	public void bounce() {
		vx = -vx;
		vy = -vy;
	}
	
	public boolean intersects(PhysicsShape other) {
		boolean retVal = false;
		if (other.getShape() instanceof Rectangle) {
			Rectangle r = (Rectangle) other.getShape();
			Line[] rLines = new Line[4];
			rLines[0] = new Line(r.getX(), r.getY(), r.getX() + 100, r.getY());
			rLines[1] = new Line(r.getX(), r.getY(), r.getX(), r.getY() + 100);
			rLines[2] = new Line(r.getX(), r.getY() + 100, r.getX() + 100, r.getY() + 100);
			rLines[3] = new Line(r.getX() + 100, r.getY(), r.getX() + 100, r.getY() + 100);

			if (s instanceof Circle) {
				Circle c = (Circle) s;
				Line[] cLines = new Line[12];

				double angle = 0.0;
				for (int i = 0; i < 12; i++) {
					cLines[i] = new Line(c.getX(), c.getY(), angle, 50, false);
					angle += Math.toDegrees(Math.PI / 3.0);
				}

				for (int i = 0; i < rLines.length; i++) {
					for (int j = 0; j < cLines.length; j++) {
						if (rLines[i].intersects(cLines[j])) {
							retVal = true;
							break;
						}
					}
				}

			} else if (s instanceof Rectangle) {
				Rectangle r2 = (Rectangle) s;
				Line[] r2Lines = new Line[4];
				r2Lines[0] = new Line(r2.getX(), r2.getY(), r2.getX() + 100, r2.getY());
				r2Lines[1] = new Line(r2.getX(), r2.getY(), r2.getX(), r2.getY() + 100);
				r2Lines[2] = new Line(r2.getX(), r2.getY() + 100, r2.getX() + 100, r2.getY() + 100);
				r2Lines[3] = new Line(r2.getX() + 100, r2.getY(), r2.getX() + 100, r2.getY() + 100);

				for (int i = 0; i < rLines.length; i++) {
					for (int j = 0; j < r2Lines.length; j++) {
						if (rLines[i].intersects(r2Lines[j])) {
							retVal = true;
							break;
						}
					}
				}
			}
		} else if (other.getShape() instanceof Circle) {
			Circle c1 = (Circle) other.getShape();
			Line[] c1Lines = new Line[12];
			double angle = 0.0;
			for (int i = 0; i < 12; i++) {
				c1Lines[i] = new Line(c1.getX(), c1.getY(), angle, 50, false);
				angle += Math.toDegrees(Math.PI / 3.0);
			}
			
			if(s instanceof Circle) {
				Circle c2 = (Circle)s;
				Line[] c2Lines = new Line[12];
				angle = 0.0;
				for (int i = 0; i < 12; i++) {
					c2Lines[i] = new Line(c2.getX(), c2.getY(), angle, 50, false);
					angle += Math.toDegrees(Math.PI / 3.0);
				}
				
				for(int i = 0; i < c1Lines.length; i++) {
					for(int j = 0; j < c2Lines.length; j++) {
						if(c1Lines[i].intersects(c2Lines[j])) {
							retVal = true;
							break;
						}
					}
				}
				
			} else if(s instanceof Rectangle) {
				Rectangle r2 = (Rectangle) s;
				Line[] r2Lines = new Line[4];
				r2Lines[0] = new Line(r2.getX(), r2.getY(), r2.getX() + 100, r2.getY());
				r2Lines[1] = new Line(r2.getX(), r2.getY(), r2.getX(), r2.getY() + 100);
				r2Lines[2] = new Line(r2.getX(), r2.getY() + 100, r2.getX() + 100, r2.getY() + 100);
				r2Lines[3] = new Line(r2.getX() + 100, r2.getY(), r2.getX() + 100, r2.getY() + 100); 
				
				for(int i = 0; i < c1Lines.length; i++) {
					for(int j = 0; j < r2Lines.length; j++) {
						if(c1Lines[i].intersects(r2Lines[j])) {
							retVal = true;
							break;
						}
					}
				}
			}
		}
		return retVal;
	}

}