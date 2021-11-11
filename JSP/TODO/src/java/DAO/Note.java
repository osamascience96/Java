/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import database.Connector;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author osama
 */
public class Note {
    private Connection connection;

    public Note() {
        this.connection = Connector.getConnectionInstance().getConnection();
    }
    
    public ArrayList<EJB.Note> GetAllNotes(int userid){
        ArrayList<EJB.Note> nodeArrayList  = new ArrayList<EJB.Note>();
        
        String query  = "SELECT * FROM notes WHERE user_id = ?";
        
        try {
            PreparedStatement pstmt = this.connection.prepareStatement(query);
            pstmt.setInt(1, userid);
            ResultSet rs = pstmt.executeQuery();
            
            while(rs.next()){
                EJB.User userKb = new EJB.User();
                userKb.setId(rs.getInt("user_id"));
                nodeArrayList.add(new EJB.Note(rs.getInt("id"), userKb, rs.getString("data"), rs.getString("created_at")));
            }
        } catch (SQLException ex) {
            Logger.getLogger(Note.class.getName()).log(Level.SEVERE, null, ex);
        }
        return nodeArrayList;
    }
    
    public int InsertNote(EJB.Note note){
        int insertnode = 0;
        
        String query = "INSERT INTO notes(user_id, data) VALUES(?, ?)";
        
        try {
            PreparedStatement pstmt = this.connection.prepareStatement(query);
            pstmt.setInt(1, note.getUser().getId());
            pstmt.setString(2, note.getData());
            insertnode = pstmt.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(Note.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return insertnode;
    }
    
    public int DeleteNote(int id){
        int is_deleted = 0;
        try {
            String query = "DELETE FROM notes WHERE id = ?";
            
            PreparedStatement pstmt = this.connection.prepareStatement(query);
            pstmt.setInt(1, id);
            is_deleted =  pstmt.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(Note.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return is_deleted;
    }
}
