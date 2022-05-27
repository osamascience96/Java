package bean;

public class ColorBean {
	private String foregroundColor = "black";
	private String backgroundColor = "white";
	
	public ColorBean() {
	}
	
	public ColorBean(String foregroundColor, String backgroundColor) {
		this.foregroundColor = foregroundColor;
		this.backgroundColor = backgroundColor;
	}
	
	public String getForegroundColor() {
		return foregroundColor;
	}
	public void setForegroundColor(String foregroundColor) {
		this.foregroundColor = foregroundColor;
	}
	public String getBackgroundColor() {
		return backgroundColor;
	}
	public void setBackgroundColor(String backgroundColor) {
		this.backgroundColor = backgroundColor;
	}
}
