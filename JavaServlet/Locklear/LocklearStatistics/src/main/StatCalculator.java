package main;

import java.util.Arrays;

public class StatCalculator {
	private int[] values;
	
	public StatCalculator(int[] values) {
		this.values = values;
	}
	
	public int min() {
		int min = values[0];
		for (int value : values) {
			if(value < min) {
				min = value;
			}
		}
		
		return min;
	}
	
	public int max() {
		int max = values[0];
		for (int value : values) {
			if(value > max) {
				max = value;
			}
		}
		
		return max;
	}
	
	public int sum() {
		int sum = 0;
		for (int value : values) {
			sum += value;
		}
		
		return sum;
	}
	
	public double avg() {
		double average = this.sum() / this.values.length;
		return average;
	}
	
	public String showStats() {
		String resultStats =  "Numbers Entered: ".concat(Arrays.toString(this.values)).concat("\n");
		Arrays.sort(this.values);
		resultStats = resultStats.concat("Sorted Numbers: ".concat(Arrays.toString(this.values)).concat("\n"));
		resultStats = resultStats.concat("Sum of Numbers: ".concat(String.valueOf(this.sum()))).concat("\n");
		resultStats = resultStats.concat("Minimum Value: ".concat(String.valueOf(this.min()))).concat("\n");
		resultStats = resultStats.concat("Maximum Value: ".concat(String.valueOf(this.max()))).concat("\n");
		
		return resultStats;
	}
	
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return Arrays.toString(this.values);
	}
}
