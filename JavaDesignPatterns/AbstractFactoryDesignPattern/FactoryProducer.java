
public class FactoryProducer {
	public static AbstractFactory getFactory(boolean rounded) {
		AbstractFactory absFactory = null;
		if(rounded) {
			absFactory = new RoundedShapeFactory();
		}else {
			absFactory = new ShapeFactory();
		}
		
		return absFactory;
	}
}
