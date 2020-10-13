package zxiong.shapes;

import java.awt.Color;

import processing.core.PApplet;

public abstract class Shape {


	//FIELDS
	protected double x,y;
	private Color strokeColor;
	private Color fillColor;
	
	//CONSTRUCTORS
	
	public Shape(double x, double y) {
		this.x = x;
		this.y = y;	
	}
	
	
	//METHODS	
	public abstract void draw(PApplet surface);
	public abstract double getPerimeter();
	public abstract double getArea();
	public abstract void setDimension();
	public abstract boolean isPointInside(double x, double y);
	public abstract void reset();
	
	public double getX() {
		return x;
	}
	
	public double getY() {
		return y;
	}
	
	public void setStroke(Color c) {
		this.strokeColor = c;
	}
	
	public void setFill(Color c) {
		this.fillColor = c;
	}

}
