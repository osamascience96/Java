package loose_coupling_2;

public class Box {
	private int volume;
	
	public Box(int length, int width, int height) {
		this.volume = length * width * height;
	}
	
	public int getVolume() {
		return this.volume;
	}
}
