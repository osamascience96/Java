package task4;

import java.util.Scanner;

public class Task4 {
	private double radius;
	
	public Task4() {
		radius = new Scanner(System.in).nextDouble();
	}
	
	public void CalculateAreaofCircle() {
		double areaOfCircle = Math.PI * Math.pow(this.radius, 2);
		System.out.println(areaOfCircle);
	}
}
