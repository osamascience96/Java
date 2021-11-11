/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import Bean.Log;
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
public class Student {
    private Connection connection;
    
    public Student(){
        this.connection = Connector.getConnectionInstance().getConnection();
    }
    
    public ArrayList<Bean.Student> GetAllStudents() throws SQLException{
        ArrayList<Bean.Student> arrayListStudents = new ArrayList<Bean.Student>();
        
        String query = "SELECT * FROM [CUNY_DB].[dbo].[Students]";
        
        PreparedStatement pstmt = this.connection.prepareStatement(query);
        ResultSet rs = pstmt.executeQuery();
        
        while(rs.next()){
            arrayListStudents.add(new Bean.Student(rs.getInt("ssn"), rs.getString("firstName"), rs.getString("mi"), rs.getString("lastName"), rs.getString("birthDate"), rs.getString("street"), rs.getString("phone"), rs.getString("zipcode"), rs.getString("deptId")));
        }
        
        return arrayListStudents;
    }
    
    public ArrayList<Log> GetAllLogsList(int employeeId) throws SQLException{
        ArrayList<Log> logsArrayList = new ArrayList<Log>();
        
        String query = "SELECT TimeSheetTbl.TimeSheetID, TimeSheetTbl.StartTime, TimeSheetTbl.EndTime, PayTypeTbl.PayTypeID, PayTypeTbl.PayAmount, PayTypeTbl.PayType FROM Students JOIN TimeSheetTbl ON TimeSheetTbl.EmpID = Students.ssn JOIN PayTypeTbl ON PayTypeTbl.PayTypeID = TimeSheetTbl.PayTypeID WHERE Students.ssn = ?";
        
        PreparedStatement pstmt = this.connection.prepareStatement(query);
        pstmt.setInt(1, employeeId);
        ResultSet rs = pstmt.executeQuery();
        
        while(rs.next()){
            logsArrayList.add(new Log(rs.getInt("TimeSheetID"), rs.getString("StartTime"), rs.getString("EndTime"), rs.getInt("PayTypeID"), rs.getDouble("PayAmount"), rs.getString("PayType")));
        }
        
        return logsArrayList;
    }
}
