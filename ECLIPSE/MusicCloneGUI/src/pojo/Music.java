package pojo;

import java.sql.Blob;

public class Music {
	private int id;
	private String name;
	private Blob music_blob;
	
	public Music() {
		// TODO Auto-generated constructor stub
	}

	public Music(int id, String name, Blob music_blob) {
		super();
		this.id = id;
		this.name = name;
		this.music_blob = music_blob;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Blob getMusic_blob() {
		return music_blob;
	}

	public void setMusic_blob(Blob music_blob) {
		this.music_blob = music_blob;
	}
	
	
}
