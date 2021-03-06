package zxiong.testers;
import java.awt.Color;
import java.awt.Dimension;

import javax.swing.JFrame;

import processing.awt.PSurfaceAWT;
import processing.core.PApplet;
import zxiong.shapes.Circle;
import zxiong.shapes.Line;
import zxiong.shapes.Rectangle;
import zxiong.shapes.RegularPolygon;
import zxiong.shapes.Shape;

public class Tester extends PApplet {

	private Rectangle rectA, rectB, rectC, rectB2;
	private Circle circleA, circleB, circleC;
	private Line lineA, lineB, lineC, lineD, lineE;
	private RegularPolygon poly,poly1,poly2;
	
	private Rectangle[] rectTest = new Rectangle[5];
	private Line[] lineTest = new Line[5];
	
	public Tester() {
		rectA = new Rectangle();
		rectB = new Rectangle(50, 50, 50, 50);
		rectC = new Rectangle(100, -100, 20, -300);
		
		circleA = new Circle();
		circleB = new Circle(50,50,50);
		circleC = new Circle(10,-10, -20);
		
		
		lineA = new Line();
		lineB = new Line(30,30,200,100);
		lineC = new Line(100,100,90,100,true);
		lineD = new Line(50,50,300,50);
		lineE = new Line(100,0,90, 5, true);
		
		poly = new RegularPolygon();
		poly1 = new RegularPolygon(200,200,4,-100);
		poly2 = new RegularPolygon(200,200,4,100);
		
		for (int a=0; a<5; a++) {
			rectTest[a] = new Rectangle(50+55*a, 50, 50, 50);
			rectTest[a].setFill(Color.BLUE);
			
			lineTest[a] = new Line(50,50,50*a,50,true);
			lineTest[a].setStroke(Color.GREEN);
		}
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
		
	//	if (rectB.isPointInside(200, 200))
	//		System.out.println("inside");
	//	else
	//		System.out.println("not inside");
	//		System.out.println(rectB);

	//	for (int a=0; a<5; a++) {
	//		rectTest[a].draw(this);
			
	//		lineTest[a].draw(this);
	/*	
		lineD.draw(this);
		lineE.draw(this);
		
		if(lineD.intersects(lineE)) {
			System.out.println("true");
			System.out.println("x="+lineD.getIntersectionX(lineE));
			System.out.println("y="+lineD.getIntersectionY(lineE));
		}
		else if(!lineD.intersects(lineE)) {
			System.out.println("false");
		}
		*/
		
	//	poly.draw(this);

		poly1.draw(this);
		
		poly2.draw(this);
		
		}
	}

