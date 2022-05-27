package loose_coupling_2;

public class Volume {
	private Box box;
	
	public Volume() {
		this.box = new Box(5, 5, 5);
		System.out.println(this.box.getVolume());
	}
}
