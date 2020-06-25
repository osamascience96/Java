
public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		AbstractFactory factory = FactoryProducer.getFactory(false);
		Shape shapeObj1 = factory.getShape("Rectangle");
		shapeObj1.draw();
		Shape shapeObj2 = factory.getShape("Square");
		shapeObj2.draw();
		
		// try another form
		AbstractFactory factory2 = FactoryProducer.getFactory(true);
		Shape shapeObj3 = factory2.getShape("Rectangle");
		shapeObj3.draw();
		Shape shapeObj4 = factory2.getShape("Square");
		shapeObj4.draw();
		
	}

}
