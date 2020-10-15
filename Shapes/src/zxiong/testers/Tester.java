package zxiong.testers;
import java.awt.Dimension;

import javax.swing.JFrame;

import processing.awt.PSurfaceAWT;
import processing.core.PApplet;
import zxiong.shapes.Circle;
import zxiong.shapes.Line;
import zxiong.shapes.Rectangle;

public class Tester extends PApplet {

	private Rectangle rectA, rectB, rectC;
	private Circle circleA, circleB, circleC;
	private Line lineA, lineB;
	
	public Tester() {
		rectA = new Rectangle();
		rectB = new Rectangle(0, 80, 400, 160);
		rectC = new Rectangle(100, -100, 20, -300);
		
		circleA = new Circle();
		circleB = new Circle(10,10,20);
		circleC = new Circle(10,-10, -20);
		
		lineA = new Line(30,30,200,100);
		lineB = new Line(100,100,90,100,true);
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
		rectB.draw(this);
	}
}
