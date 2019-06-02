import java.util.ArrayList;

public class main {
	
	public static void main(String[] args){ 
		ArrayList<Media> mediaList = new ArrayList<Media>();
		
		String mediaFileName;
		int duration;
		String mediaFileType;
		String mediaFileFormat;
		String mediaDescription;
		
		mediaFileName = "Jugni";
		duration = 10;
		mediaFileType = "Audio";
		mediaFileFormat = "MP3";
		mediaDescription = "Song Sung by Punjabi Folk Artist Arif Lohar";
		mediaList.add(new Music(mediaFileName, duration, mediaFileType, mediaFileFormat, 
				mediaDescription));
		
		mediaFileName = "Putt Jatt Da";
		duration = 5;
		mediaFileType = "Video";
		mediaFileFormat = "MP4";
		mediaDescription = "Song Sung by Punjabi Pop Artist Diljit Dosanjh";
		mediaList.add(new Video(mediaFileName, duration, mediaFileType, mediaFileFormat, 
				mediaDescription));
		
		mediaFileName = "Pakistan Zindabad";
		duration = 7;
		mediaFileType = "Audio";
		mediaFileFormat = "MP3";
		mediaDescription = "Song Sung by Asian Singer Sahir Ali Bagga";
		mediaList.add(new Music(mediaFileName, duration, mediaFileType, mediaFileFormat, 
				mediaDescription));
		
		mediaFileName = "Raat di Gedi";
		duration = 4;
		mediaFileType = "Video";
		mediaFileFormat = "MP4";
		mediaDescription = "Song Sung by Punjabi Pop Artist Diljit Dosanjh";
		mediaList.add(new Video(mediaFileName, duration, mediaFileType, mediaFileFormat, 
				mediaDescription));
		
		System.out.println(mediaList); // will display the object list reference to Media Class
		
		for (int i=0;i<mediaList.size();i++) {
			mediaList.get(i).DisplayFileInformation();
			System.out.println();
		}
		
	}
}
