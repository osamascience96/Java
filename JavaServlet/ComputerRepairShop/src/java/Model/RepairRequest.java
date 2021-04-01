/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import Database.Connector;
import POJO.Request;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author osama
 */
public class RepairRequest {
    private Connection conn;
    
    public RepairRequest(){
        this.conn = Connector.getConnectionInstance().getConnection();
    }
    
    public void InsertRequestRecord(Request request){
        String query = "INSERT INTO request(computer_owner, computer_serial_number, type, model, memory_gb, harddisk_gb, problems, repair_delievery_datetime) VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
        
        PreparedStatement ps = null;
        try {
            ps = this.conn.prepareStatement(query);
            ps.setString(1, request.GetComputerOwner());
            ps.setString(2, request.GetSerialNumber());
            ps.setString(3, request.GetType());
            ps.setString(4, request.GetModel());
            ps.setInt(5, request.GetMemoryGB());
            ps.setInt(6, request.GetHardGB());
            ps.setString(7, request.GetProblem());
            ps.setString(8, request.GetRepairDelieveryDateTIme());
            ps.execute();
        } catch (SQLException ex) {
            Logger.getLogger(RepairRequest.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public ArrayList<Request> GetAllRequests(){
        ArrayList<Request> RequestArrayList = new ArrayList<Request>();
        
        String query = "SELECT * FROM request";
        
        try {
            Statement stmt = this.conn.createStatement();
            ResultSet rs = stmt.executeQuery(query);
            
            while(rs.next()){
                Request request = new Request(rs.getInt("id"), rs.getString("computer_owner"), rs.getString("computer_serial_number"), rs.getString("type"), rs.getString("model"), rs.getInt("memory_gb"), rs.getInt("harddisk_gb"), rs.getString("problems"), rs.getDouble("repair_cost"), rs.getString("repair_status"), rs.getString("repair_finish_datetime"), rs.getString("repair_delievery_datetime"));
                RequestArrayList.add(request);
            }
        } catch (SQLException ex) {
            Logger.getLogger(RepairRequest.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return RequestArrayList;
    }
}
