/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.models;

import com.database.Connector;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

/**
 *
 * @author osama
 */
public class Team {
    private Connection connection;
    
    public Team(){
        this.connection = Connector.getConnectionInstance().getConnection();
    }
    
    public ArrayList<com.pojo.Team> GetAllTeamsRecordList() throws SQLException{
        ArrayList<com.pojo.Team> teamsArrayList = new ArrayList<com.pojo.Team>();
        
        String query = "SELECT * FROM team";
        Statement stmt = this.connection.createStatement();
        ResultSet rs = stmt.executeQuery(query);
        
        while(rs.next()){
            teamsArrayList.add(new com.pojo.Team(rs.getInt("id"), rs.getString("name"), rs.getInt("is_on_call"), rs.getInt("team_members"), rs.getString("created_at")));
        }
        
        return teamsArrayList;
    }
    
    public ArrayList<com.pojo.Team> GetAllFreeTeamsRecordList() throws SQLException{
        ArrayList<com.pojo.Team> teamsArrayList = new ArrayList<com.pojo.Team>();
        
        String query = "SELECT * FROM team WHERE is_on_call = 0";
        Statement stmt = this.connection.createStatement();
        ResultSet rs = stmt.executeQuery(query);
        
        while(rs.next()){
            teamsArrayList.add(new com.pojo.Team(rs.getInt("id"), rs.getString("name"), rs.getInt("is_on_call"), rs.getInt("team_members"), rs.getString("created_at")));
        }
        
        return teamsArrayList;
    }
    
    public ArrayList<com.pojo.Employee> GetOnTeamEmployeeData() throws SQLException{
        ArrayList<com.pojo.Employee> OnTeamEmployeeList = new ArrayList<com.pojo.Employee>();
        
        String query = "SELECT id, team_id, first_name, last_name FROM employee WHERE team_id != 0";
        Statement stmt = this.connection.createStatement();
        ResultSet rs = stmt.executeQuery(query);
        
        while(rs.next()){
            com.pojo.Employee employee = new com.pojo.Employee();
            employee.SetID(rs.getInt("id"));
            employee.SetFirstName(rs.getString("first_name"));
            employee.SetLastName(rs.getString("last_name"));
            employee.SetTeamID(rs.getInt("team_id"));
            OnTeamEmployeeList.add(employee);
        }
        
        return OnTeamEmployeeList;
    }
    
    public ArrayList<com.pojo.Employee> GetFreeEmployeeData() throws SQLException{
        ArrayList<com.pojo.Employee> freeEmployeesList = new ArrayList<com.pojo.Employee>();
        
        String query = "SELECT id, first_name, last_name FROM employee WHERE team_id = 0";
        Statement stmt = this.connection.createStatement();
        ResultSet rs = stmt.executeQuery(query);
        
        while(rs.next()){
            com.pojo.Employee employee = new com.pojo.Employee();
            employee.SetID(rs.getInt("id"));
            employee.SetFirstName(rs.getString("first_name"));
            employee.SetLastName(rs.getString("last_name"));
            freeEmployeesList.add(employee);
        }
        
        return freeEmployeesList;
    }
    
    public boolean CheckTeamExistance(String team_name) throws SQLException{
        String query = "SELECT * FROM team WHERE name = ?";
        
        PreparedStatement ps = this.connection.prepareStatement(query);
        ps.setString(1, team_name);
        
        ResultSet rs = ps.executeQuery();
        String fetched_team_name = "";
        while(rs.next()){
            fetched_team_name = rs.getString("name");
        }
        
        return team_name.compareToIgnoreCase(fetched_team_name) == 0 ? true : false;
    }
    
    public boolean InsertTeamDatabase(String team_name, String on_call, String employee_id_array[]) throws SQLException{
        // insert into the team table join with employee table, the array given mut be infiled
        String query = "INSERT INTO team(name, is_on_call) VALUES(?, ?)";
        
        PreparedStatement ps = this.connection.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);
        ps.setString(1, team_name);
        ps.setInt(2, Integer.parseInt(on_call));
        ps.execute();
        
        ResultSet rs = ps.getGeneratedKeys();
        int generatedKey = 0;
        if(rs.next()){
            generatedKey = rs.getInt(1);
        }
        
        System.out.println(generatedKey);
        
        if(employee_id_array != null){
            Statement stmt = null;

            // updating the employee table to make join with the team table 
            for(int i=0; i < employee_id_array.length; i++){
                query = "UPDATE employee SET team_id = ".concat(String.valueOf(generatedKey)).concat(" where id = ").concat(String.valueOf(employee_id_array[i]));
                stmt = this.connection.createStatement();
                stmt.executeUpdate(query);
            }
        }
        
        return true;
    }
    
    public boolean editTeamDatabase(com.pojo.Team team, String employeeIdArray[]) throws SQLException{
        String query = "UPDATE `team` SET name = ?, is_on_call = ? WHERE id = ?";
        
        PreparedStatement ps = this.connection.prepareStatement(query);
        ps.setString(1, team.GetTeamName());
        ps.setInt(2, team.GetIsOnCall());
        ps.setInt(3, team.GetId());
        ps.execute();
        
        Statement stmt = null;
        
        // updating the employee table to make join with the team table 
        for(int i=0; i < employeeIdArray.length; i++){
            query = "UPDATE employee SET team_id = ".concat(String.valueOf(team.GetId())).concat(" where id = ").concat(String.valueOf(employeeIdArray[i]));
            stmt = this.connection.createStatement();
            stmt.executeUpdate(query);
        }
        
        return true;
    }
    
    public boolean deleteTeamDatabase(int team_id) throws SQLException{
        
        boolean response = false;
        int is_on_call = 1;
        
        String query = "SELECT is_on_call FROM team WHERE id = ?";
        PreparedStatement ps = this.connection.prepareStatement(query);
        ps.setInt(1, team_id);
        ResultSet rs = ps.executeQuery();
        
        while(rs.next()){
            is_on_call = rs.getInt("is_on_call");
        }
        
        if(is_on_call == 0){
            // unlink the team_id from the employee table
            query = "UPDATE employee SET team_id = 0 WHERE team_id = ?";

            ps = this.connection.prepareStatement(query);
            ps.setInt(1, team_id);
            response = ps.execute();
            
            query = "SELECT id FROM jobs WHERE team_id = ?";
            ps = this.connection.prepareStatement(query);
            ps.setInt(1, team_id);
            rs = ps.executeQuery();
            
            while(rs.next()){
                int job = rs.getInt("id");
                
                // delete from jobs
                query = "DELETE FROM jobs WHERE id = ?";
                ps = this.connection.prepareStatement(query);
                ps.setInt(1, job);
                ps.executeUpdate();
                
                // delete from jobcomments
                query = "DELETE FROM jobcomments WHERE job_id = ?";
                ps = this.connection.prepareStatement(query);
                ps.setInt(1, job);
                ps.executeUpdate();
                
                // delete from jobtasks
                query = "DELETE FROM jobtasks WHERE job_id = ?";
                ps = this.connection.prepareStatement(query);
                ps.setInt(1, job);
                ps.executeUpdate();
                
            }

            // delete team from the team table
            query = "DELETE FROM team WHERE id = ?";
            ps = this.connection.prepareStatement(query);
            ps.setInt(1, team_id);
            response = ps.execute();
            
            response = true;
        }
        
        return response;
        
    }
    
    public boolean UpdateTeamScale(String team_scale, String team_id) throws SQLException{
        String query = "UPDATE team SET team_members = ".concat(team_scale).concat(" WHERE id = ").concat(team_id);
        Statement stmt = this.connection.createStatement();
        return stmt.executeUpdate(query) != 0 ? true : false;
    }
    
    // set the specific team to oncall
    public void SetTeamCall(int call_status, int team_id) throws SQLException{
        String query = "Update team SET is_on_call = ? WHERE id = ?";
        
        PreparedStatement pstmt = this.connection.prepareStatement(query);
        pstmt.setInt(1, call_status);
        pstmt.setInt(2, team_id);
        
        pstmt.execute();
    }
}
