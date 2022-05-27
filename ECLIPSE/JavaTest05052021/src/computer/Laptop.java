package computer;

public class Laptop extends Computer{
	private String modelName;
	private String processorType;
	private String gpu;
	private String ram;
	
	public Laptop() {
		
	}
	
	public Laptop(String modelName, String processorType, String gpu, String ram) {
		this.modelName = modelName;
		this.processorType = processorType;
		this.gpu = gpu;
		this.ram = ram;
	}

	public String getModelName() {
		return modelName;
	}

	public void setModelName(String modelName) {
		this.modelName = modelName;
	}

	public String getProcessorType() {
		return processorType;
	}

	public void setProcessorType(String processorType) {
		this.processorType = processorType;
	}

	public String getGpu() {
		return gpu;
	}

	public void setGpu(String gpu) {
		this.gpu = gpu;
	}

	public String getRam() {
		return ram;
	}

	public void setRam(String ram) {
		this.ram = ram;
	}
	
	public void outputLaptopDetails() {
		System.out.println("Model Name: " + this.modelName);
		System.out.println("Processor Type: " + this.processorType);
		System.out.println("GPU: " + this.gpu);
		System.out.println("RAM: " + this.ram);
	}
}
