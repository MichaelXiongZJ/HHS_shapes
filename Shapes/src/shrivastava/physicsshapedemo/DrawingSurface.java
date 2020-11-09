package shrivastava.physicsshapedemo;

import java.awt.Color;

import processing.core.PApplet;
import zxiong.shapes.*;


public class DrawingSurface extends PApplet {
	
	private PhysicsShape circle1, circle2, rect1;
	private static final boolean DEBUG_PRINT = false;

	public DrawingSurface() {
		circle1 = new PhysicsShape(new Circle(250,500,100));
		circle2 = new PhysicsShape(new Circle(750,500, 100)); 
		rect1 = new PhysicsShape(new Rectangle(500,500,100,100));
	}
	
	public void setup() {
		frameRate(144);
	}
	
	public void draw() {
		Color background = new Color(79, 121, 66);
		background(background.getRed(), background.getGreen(), background.getBlue());
		circle1.draw(this);	
		circle2.draw(this);
		rect1.draw(this);
		
		circle1.act(new Rectangle(0,0,width, height));
		circle2.act(new Rectangle(0,0,width, height));
		rect1.act(new Rectangle(0,0,width, height));
		
		if(circle1.intersects(rect1)) {
			System.out.println("Intersection Circle 1");
			circle1.bounce();
			rect1.bounce();
		} 
		
		if(circle2.intersects(rect1)) {
			System.out.println("Intersection Circle 2");
			circle2.bounce();
			rect1.bounce();
		}
		
		if(circle1.intersects(circle2)) {
			System.out.println("Intersection Between Circles");
			circle1.bounce();
			circle2.bounce();
		}
		
		if(DEBUG_PRINT) {
			Line l1 = new Line(0,0,500,500);
			l1.draw(this);
			
			Line l2 = new Line(1000,500,400,450);
			l2.draw(this);
			
			System.out.println(l1.intersects(l2));
		}
	}
	
	public void mouseDragged() {
		
		if(circle1.isPointInside(mouseX, mouseY)) {
			circle1.accelerate((mouseX-pmouseX) / 1.5, 0);
			circle1.accelerate(0, (mouseY-pmouseY) / 1.5);
		}
		if(circle2.isPointInside(mouseX, mouseY)) {
			circle2.accelerate((mouseX-pmouseX) / 1.5, 0);
			circle2.accelerate(0, (mouseY-pmouseY) / 1.5);
		}
		if(rect1.isPointInside(mouseX, mouseY)) {
			rect1.accelerate((mouseX-pmouseX) / 1.5, 0);
			rect1.accelerate(0, (mouseY-pmouseY) / 1.5);
		}
	}
	
	
}	
