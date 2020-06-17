import java.util.Scanner;

/*This Pattern is usefull when you may want to create several objects at run time with more complex logic*/
public class FactoryPattern {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Shape shape1 = ShapeFactory.getShape("Circle");
		Shape shape2 = ShapeFactory.getShape("Rectangle");
		Shape shape3 = ShapeFactory.getShape("Triangle");
		
		shape1.Draw();
		shape2.Draw();
		shape3.Draw();
		
		// lets take another example 
		
		Scanner sc = new Scanner(System.in);
		Shape shape = ShapeFactory.getShape(sc.nextLine());
		if (shape != null) {
			shape.Draw();
		}else {
			System.out.println("Shape Not Available");
		}
	}
}

class ShapeFactory{
	// make the factory object to get the new object based on the param
	public static Shape getShape(String shapeType) {
		//return based on the passed params
		if(shapeType.equalsIgnoreCase("Circle")) {
			return new Circle();
		}else if (shapeType.equalsIgnoreCase("Rectangle")) {
			return new Rectangle();
		}else if (shapeType.equalsIgnoreCase("Triangle")) {
			return new Triangle();
		}
		
		// return null, if nothing returns.
		return null;
	}
}
