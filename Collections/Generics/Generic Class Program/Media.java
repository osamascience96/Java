
abstract public class Media {
	protected String mediaFileName;
	protected int duration;
	protected String mediaFileType;
	protected String mediaFileFormat;
	protected String mediaDescription;
	
	public Media(String mediaFileName, int duration, String mediaFileType, 
			String mediaFileFormat, String mediaDescription) {
		this.mediaFileName = mediaFileName;
		this.duration = duration;
		this.mediaFileType = mediaFileType;
		this.mediaFileFormat = mediaFileFormat;
		this.mediaDescription = mediaDescription;
	}
	
	public abstract void DisplayFileInformation();
}
