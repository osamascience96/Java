package main;

import computer.Computer;
import computer.Laptop;

public class Main {

	public static void main(String[] args) {
		/*
		 * 1. Manufacturers name =Dell; Price =$850; Model name =XPS13; processor=i7; GPU=iris; RAM=8GB
		2. Manufacturers name = Lenovo; Price =$1200; Model name= YogaC760; processor = i7-10510U; GPU= NVIDIA; RAM=16GB*/
		
		
		Laptop laptop1 = new Laptop();
		laptop1.setManufacturersName("Dell");
		laptop1.setPrice(850);
		laptop1.setModelName("XPS13");
		laptop1.setProcessorType("17");
		laptop1.setGpu("iris");
		laptop1.setRam("8GB");
		
		//output laptop1 details
		laptop1.outputComputerDetails();
		laptop1.outputLaptopDetails();
		
		System.out.println("++++++++++++++++++++++++++++++++++++++++++++++++++++++++");
				
		Laptop laptop2 = new Laptop();
		laptop2.setManufacturersName("Lenovo");
		laptop2.setPrice(1200);
		laptop2.setModelName("YogaC760");
		laptop2.setProcessorType("i7-10510U");
		laptop2.setGpu("NVIDIA");
		laptop2.setRam("16GB");
		
		//output laptop1 details
		laptop2.outputComputerDetails();
		laptop2.outputLaptopDetails();
	}

}
