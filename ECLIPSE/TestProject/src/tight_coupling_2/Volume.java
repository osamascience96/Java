package tight_coupling_2;

public class Volume {
	private Box box;
	
	public Volume() {
		box = new Box(5, 5, 5);
	}
	
	public void printBoxVolume() {
		System.out.println(box.volume);
	}
}
