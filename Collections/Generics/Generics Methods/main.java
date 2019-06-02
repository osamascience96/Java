// Generic Methods
// Code learned from Youtuber Learning Never Ends
// link: https://www.youtube.com/channel/UC1N6vS8JcUOFuAUk9sOO__A
public class main {

	
	// Java contains the Rapper Class for every primitive datatype 
	
	// to always include the generic type method before constructing the generic object
	public static <T> void main(String[] args){ 
		 Sample sampleObj = new Sample<T>();
		 
		 Integer[] integerData = {12, 23, 24};
		 sampleObj.showArray(integerData);
		 
		 String[] stringData = {"Osama", "Saad", "Jafri", "Ali", "Usman"};
		 sampleObj.showArray(stringData);
		 
		 Character[] charData = {'A', 'D', 'I', 'L'};
		 sampleObj.showArray(charData);
		 
		 Float[] floatData = {12.56f, 23.32f, 24.12f};
		 sampleObj.showArray(floatData);
	}
}
