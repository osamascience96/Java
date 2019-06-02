
public class Music extends Media{

	public Music(String mediaFileName, int duration, String mediaFileType, String mediaFileFormat,
			String mediaDescription) {
		super(mediaFileName, duration, mediaFileType, mediaFileFormat, mediaDescription);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void DisplayFileInformation()  {
		System.out.println("File Name: " + mediaFileName);
		System.out.println("Duration: " + duration + " mins");
		System.out.println("Media Type: " + mediaFileType);
		System.out.println("Media Format: " + mediaFileFormat);
		System.out.println("Description: " + mediaDescription);
	}
	
	

}
