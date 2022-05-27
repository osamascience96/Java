package main;

import factory.Shape;
import window.ShapeFactory;

public class Main {
	public static void main(String args[]) {
		ShapeFactory factory = new ShapeFactory();
		Shape shape = factory.GetShape("square");
		shape.draw();
	}
}
