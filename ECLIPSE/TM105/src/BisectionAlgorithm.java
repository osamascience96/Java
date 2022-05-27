
public class BisectionAlgorithm {
	
	
	public void Root(int index, int number) {
		if(index > 0) {
			if(number < 0 && index == 2) {
				System.out.println("Error: you cannot calculate the square root of a negative number.");
			}else if(number > 0 && index == 2) {
				System.out.println("The radical is ".concat(String.valueOf(SquareRoot(number))));
			}else if(index == 3) {
				int num = Math.abs(number);
				double resultantNum = CubeRoot(num);
				
				System.out.println("The radical is " .concat(String.valueOf(number > 0 ? resultantNum : -resultantNum)));
			}else {
				System.out.println("Error: Please Check your Index Input.");
			}
		}else {
			System.out.println("Error: you can only calculate square or cube roots");
		}
	}
	
	private double SquareRoot(int number) {
		double num = number;
		double left = 0;
		double right = num;
		double mid = 0;
		
		do {
			mid = (left + right) / 2;
			
			if((mid * mid) < num) {
				left = mid;
			}else if((mid * mid) > num) {
				right = mid;
			}else if((mid * mid) == num) {
				left = mid;
				right = mid;
			}
		} while ((int)left != (int)right);
		
		return mid;
	}
	
	private double CubeRoot(int number) {
		double num = number;
		double left = 0;
		double right = num;
		double mid = 0;
		
		double e = 0.0000001;
		
		do {
			mid = (left + right) / 2;
			double error = difference(num, mid);
			
			if(error <= e)
				return mid;
			
			if((mid * mid * mid) > num) {
				right = mid;
			}else
				left = mid;
			
		}while((int)left != (int)right);
		
		return mid;
	}
	
	private double difference(double n, double mid) {
		if(n > (mid * mid * mid)) {
			return (n - (mid * mid * mid));
		}else
			return ((mid * mid * mid) - n);
	}
}
