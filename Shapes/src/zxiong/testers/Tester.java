package zxiong.testers;
import java.awt.Color;
import java.awt.Dimension;

import javax.swing.JFrame;

import processing.awt.PSurfaceAWT;
import processing.core.PApplet;
import zxiong.shapes.Circle;
import zxiong.shapes.Line;
import zxiong.shapes.Rectangle;
import zxiong.shapes.Shape;

public class Tester extends PApplet {

	private Rectangle rectA, rectB, rectC;
	private Circle circleA, circleB, circleC;
	private Line lineA, lineB, lineC, lineD, lineE;
	
	public Tester() {
		rectA = new Rectangle();
		rectB = new Rectangle(50, 50, 400, 400);
		rectC = new Rectangle(100, -100, 20, -300);
		
		circleA = new Circle();
		circleB = new Circle(50,50,50);
		circleC = new Circle(10,-10, -20);
		
		
		lineA = new Line(0,0,0,0);
		lineB = new Line(30,30,200,100);
		lineC = new Line(100,100,90,100,true);
		lineD = new Line(-100,100,100,-100);
		lineE = new Line(-100,100,45, 141, true);
	}


	public static void main(String args[]) {
		   Tester drawing = new Tester();
		   PApplet.runSketch(new String[]{""}, drawing);
	       PSurfaceAWT surf = (PSurfaceAWT) drawing.getSurface();
	       PSurfaceAWT.SmoothCanvas canvas = (PSurfaceAWT.SmoothCanvas) surf.getNative();
	       JFrame window = (JFrame)canvas.getFrame();
	       window.setSize(500, 500);
	       window.setMinimumSize(new Dimension(100,100));
	       window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	       window.setResizable(true);
	       window.setVisible(true);
	       canvas.requestFocus();
	}
	
	public void setup() {
	}
	
	public void draw() { 
		background(255);
		
		lineC.setStroke(Color.BLUE);
		lineC.setStrokeWidth(5);
		rectB.setStrokeWidth(2);
		circleB.setFilled(true);
		circleB.setFill(Color.RED);
		rectB.scale(0.5);
		lineC.scale(0.5);
		lineB.scale(100);
		lineC.rotate(45);
		lineB.rotate(90);
/*	
		rectA.draw(this);
		circleA.draw(this);
		lineA.draw(this);
*/
		
		rectB.draw(this);
		circleB.draw(this);
		lineB.draw(this);

		
//		rectC.draw(this);
//		circleC.draw(this);
		lineC.draw(this);

//		lineD.draw(this);
//		lineE.draw(this);
	}
}
