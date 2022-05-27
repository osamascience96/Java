package controller;

import java.util.ArrayList;

import model.Music;

public class MusicController {
	private Music musicModel = null;
	private ArrayList<pojo.Music> arrayListMusic = null;
	
	
	public MusicController() {
		this.musicModel = new Music();
	}
	
	public ArrayList<pojo.Music> GetMyMusicList(){
		this.arrayListMusic = this.musicModel.GetMusicArrayList();
		return this.arrayListMusic;
	}
}
