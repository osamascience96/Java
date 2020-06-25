
public class ShapeFactory extends AbstractFactory{

	@Override
	public Shape getShape(String shapeType) {
		Shape shape = null;
		if(shapeType.equalsIgnoreCase("Rectangle")) {
			shape = new Rectangle();
		}else if(shapeType.equalsIgnoreCase("Square")){
			shape = new Square();
		}
		
		return shape;
	}
}
