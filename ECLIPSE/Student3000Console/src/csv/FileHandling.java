package csv;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

import com.opencsv.CSVWriter;

import professor.Professor;
import student.Student;

public class FileHandling {
	
	private File fileObj = null;
	private String filePath = null;
	
	public FileHandling(String fileName) {
		// TODO Auto-generated constructor stub
		fileObj = new File(fileName.concat(".csv"));
		filePath = fileObj.getAbsolutePath();
	}
	
	public int GetFileRecordNumber() {
		int count = 0;
		
		try {
			Scanner scanner = new Scanner(new File(filePath));
			while(scanner.hasNext()) {
				scanner.next();
				count++;
			}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return count;
	}
	
	public boolean InsertDataToFile(Object obj) {
		
		boolean is_inserted = false;
		
		int numberOfRecs = GetFileRecordNumber();
		
		CSVWriter writer = null;
		
		try {
			
			if(numberOfRecs > 0) {
				writer = new CSVWriter(new FileWriter(filePath, true));
			}else {
				writer = new CSVWriter(new FileWriter(filePath));
			}
			
			if(obj.getClass() == Student.class || obj.getClass() == Professor.class) {
				// if the object is Student or Professor 
				
			}
			
			if(obj.getClass() == Student.class) {
				Student student = (Student) obj;
				String line[] = {String.valueOf(student.getId()), student.getName(), String.valueOf(student.getAge()), student.getCnic()};
				
				CSVWriter baseWriter = null;
				
				if(numberOfRecs > 0) {
					baseWriter = new CSVWriter(new FileWriter(new File("User.csv").getAbsoluteFile(), true));
				}else {
					baseWriter = new CSVWriter(new FileWriter(new File("User.csv").getAbsoluteFile()));
				}
				
				baseWriter.writeNext(line);
				baseWriter.flush();
				baseWriter.close();
				
				String stdline[] = {String.valueOf(student.getId()), student.getDegree(), student.getBatch()};
				writer.writeNext(stdline);
				writer.flush();
				
				is_inserted = true;
			}
			
			writer.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		return is_inserted;
	}
	
	
	
	public String GetAbsolutePath() {
		return this.filePath;
	}
}
