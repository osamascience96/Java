
public class RoundedShapeFactory extends AbstractFactory{
	@Override
	public Shape getShape(String shapeType) {
		Shape shape = null;
		if (shapeType.equalsIgnoreCase("Rectangle")) {
			shape = new RoundedRectangle();
		}else if(shapeType.equalsIgnoreCase("Square")) {
			shape = new RoundedSquare();
		}
		return shape;
	}
}
