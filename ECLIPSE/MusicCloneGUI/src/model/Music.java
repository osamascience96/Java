package model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import database.Database;

public class Music {
	private Connection connection;
	
	public Music() {
		this.connection = Database.GetConnectionInstance().GetConnection();
	}
	
	public ArrayList<pojo.Music> GetMusicArrayList(){
		String query = "SELECT * FROM music";
		
		ArrayList<pojo.Music> arrayListMusic = new ArrayList<pojo.Music>();
		
		try {
			PreparedStatement pstmt = this.connection.prepareStatement(query);
			ResultSet rs = pstmt.executeQuery();
			
			while(rs.next()) {
				arrayListMusic.add(new pojo.Music(rs.getInt("id"), rs.getString("title"), rs.getBlob("music_blob")));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return arrayListMusic;
	}
}
