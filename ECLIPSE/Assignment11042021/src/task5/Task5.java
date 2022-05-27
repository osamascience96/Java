package task5;

public class Task5 {
	private int number = 0;
	
	public Task5(int number) {
		this.number = number;
	}
	
	public void Print25Printtable() {
		for(int i = 1; i <= 25; i++) {
			System.out.println(String.valueOf(this.number).concat(" x ").concat(String.valueOf(i)).concat(" = ").concat(String.valueOf(this.number * i)));
		}
	}
}
