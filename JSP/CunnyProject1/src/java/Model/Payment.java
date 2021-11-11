/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import Bean.PaymentLog;
import Database.Connector;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author osama
 */
public class Payment {
    private Connection connnection;
    
    public Payment(){
        this.connnection = Connector.getConnectionInstance().getConnection();
    }
    
    public ArrayList<Bean.Payment> GetAllPaymentList() throws SQLException{
        ArrayList<Bean.Payment> paymentArrayList = new ArrayList<Bean.Payment>();
        
        String query = "SELECT * FROM PayTypeTbl";
        PreparedStatement pstmt = this.connnection.prepareStatement(query);
        ResultSet rs = pstmt.executeQuery();
        
        while(rs.next()){
            paymentArrayList.add(new Bean.Payment(rs.getInt("PayTypeId"), rs.getString("PayType"), rs.getDouble("PayAmount")));
        }
        
        return paymentArrayList;
    }
    
    public PaymentLog GetPaymentLog(int timesheetID) throws SQLException{
        PaymentLog paymentLog = null;
        
        String query = "SELECT TimeSheetTbl.TimeSheetID, Students.ssn, Students.firstName, Students.lastName, PayTypeTbl.PayTypeID, PayTypeTbl.PayType, PayTypeTbl.PayAmount FROM TimeSheetTbl JOIN Students ON Students.ssn = TimeSheetTbl.EmpID JOIN PayTypeTbl ON PayTypeTbl.PayTypeID = TimeSheetTbl.PayTypeID WHERE TimeSheetID = ?";
        PreparedStatement pstmt = this.connnection.prepareStatement(query);
        pstmt.setInt(1, timesheetID);
        ResultSet rs = pstmt.executeQuery();
        
        if(rs.next()){
            paymentLog = new PaymentLog(rs.getInt("TimeSheetID"), rs.getInt("ssn"), rs.getString("firstName"), rs.getString("lastName"), rs.getInt("PayTypeID"), rs.getString("PayType"), rs.getDouble("PayAmount"));
        }
        
        return paymentLog;
    }
    
    public void UpdatePaymentMethod(int timesheetID, int PayTypeID) throws SQLException{
        String query  = "UPDATE TimeSheetTbl SET PayTypeID = ? WHERE TimeSheetID = ?";
        
        PreparedStatement pstmt = this.connnection.prepareStatement(query);
        pstmt.setInt(1, PayTypeID);
        pstmt.setInt(2, timesheetID);
        pstmt.executeUpdate();
    }
}
