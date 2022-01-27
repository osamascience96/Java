/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import helper.Connector;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author osama
 */
public class Questionaire {
    private Connection connection;

    public Questionaire() {
        this.connection = Connector.getConnectionInstance().getConnection();
    }
    
    public int InsertQuestionaire(pojo.Questionaire questionaire){
        String query = "INSERT INTO questionaire(patient_id, gender_id, age, identity_id, source, country, language) VALUES (?, ?, ?, ?, ?, ?, ?)";
        
        pojo.Questionaire questionaireObj = null;
        
        int row = 0;
        
        try {
            PreparedStatement pstmt = this.connection.prepareStatement(query, PreparedStatement.RETURN_GENERATED_KEYS);
            pstmt.setInt(1, questionaire.getUser().getId());
            pstmt.setInt(2, questionaire.getGender().getId());
            pstmt.setInt(3, questionaire.getAge());
            pstmt.setInt(4, questionaire.getIdentity().getId());
            pstmt.setString(5, questionaire.getSource());
            pstmt.setString(6, questionaire.getCountry());
            pstmt.setString(7, questionaire.getLanguage());
            
            pstmt.executeUpdate();
            
            ResultSet rs = pstmt.getGeneratedKeys();
            if(rs.next()){
                row = rs.getInt(1);
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(Questionaire.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return row;
    }
}
