package window;

import factory.Circle;
import factory.Rectangle;
import factory.Shape;
import factory.Square;

public class ShapeFactory {
	public Shape GetShape(String shape) {
		Shape shapeObj = null;
		
		if(shape.compareToIgnoreCase("Circle") == 0) {
			shapeObj = new Circle();
		}else if(shape.compareToIgnoreCase("Rectangle") == 0) {
			shapeObj = new Rectangle();
		}else if(shape.compareToIgnoreCase("Square") == 0) {
			shapeObj = new Square();
		}
		
		return shapeObj;
	}
}
