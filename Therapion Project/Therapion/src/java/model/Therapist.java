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
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import pojo.Religion;

/**
 *
 * @author osama
 */
public class Therapist {
    private Connection connection;

    public Therapist() {
        this.connection = Connector.getConnectionInstance().getConnection();
    }
    
    public ArrayList<pojo.Therapist> GetAllTherapist(){
        String query = "SELECT user.*, type.user_type as usertype, gender.name as gendername, therapist.id as therapistid, therapist.background as therapistBackground, religion.id as religionid, religion.name as religionname FROM therapist JOIN user ON user.id = therapist.user_id JOIN type ON type.id = user.type_id JOIN gender ON gender.id = user.gender_id JOIN religion ON religion.id = therapist.religion_id";
        
        ArrayList<pojo.Therapist> therapistArrList = new ArrayList<>();
        
        try {
            PreparedStatement pstmt = this.connection.prepareStatement(query);
            
            ResultSet rs = pstmt.executeQuery();
            
            while(rs.next()){
                pojo.Type typeObj = new pojo.Type();
                typeObj.setId(rs.getInt("type_id"));
                typeObj.setUserType(rs.getString("usertype"));
                
                pojo.Gender genderObj = new pojo.Gender();
                genderObj.setId(rs.getInt("gender_id"));
                genderObj.setName(rs.getString("gendername"));
                
                Religion religionObj = new Religion();
                religionObj.setId(rs.getInt("religionid"));
                religionObj.setName(rs.getString("religionname"));
                
                pojo.User userObj = new pojo.User(rs.getInt("id"), rs.getString("name"), typeObj, rs.getString("image_addr"), genderObj, rs.getString("dob"), rs.getString("address"), rs.getString("email"), rs.getString("password"), rs.getString("phone"), rs.getString("created_at"));
                
                therapistArrList.add(new pojo.Therapist(rs.getInt("therapistid"), userObj, religionObj, rs.getString("therapistBackground")));
            }
        } catch (SQLException ex) {
            Logger.getLogger(Therapist.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return therapistArrList;
    }
}
