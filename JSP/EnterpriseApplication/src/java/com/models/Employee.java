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
public class Employee {
    
    private Connection connection;
    private Task taskModel;
    
    public Employee(){
        this.connection = Connector.getConnectionInstance().getConnection();
        this.taskModel = new Task();
    }
    
    public ArrayList<com.pojo.Employee> GetAllEmployeeRecords() throws SQLException{
        ArrayList<com.pojo.Employee> arrayListEmployee = new ArrayList<com.pojo.Employee>();
        
        String query = "SELECT employee.*, team.name as team_name FROM employee LEFT JOIN team ON employee.team_id = team.id";
        Statement stmt = this.connection.createStatement();
        ResultSet rs = stmt.executeQuery(query);
        
        while(rs.next()){
            com.pojo.Employee employee = new com.pojo.Employee(rs.getInt("id"), rs.getString("first_name"), rs.getString("last_name"), rs.getString("sin"), rs.getString("hourly_pay_rate"), rs.getString("created_at"));
            employee.SetTeamID(rs.getInt("team_id"));
            employee.SetTeamName(rs.getString("team_name"));
            // getting the tasks of the employee
            employee.SetEmployeeTaskList(this.taskModel.GetEmployeeTaskList(rs.getInt("id")));
            arrayListEmployee.add(employee);
        }
        
        return arrayListEmployee;
    }
    
    public boolean CheckSINExistance(String sin) throws SQLException{
        String query = "SELECT * FROM employee WHERE sin = ?";
        
        PreparedStatement ps = this.connection.prepareStatement(query);
        ps.setString(1, sin);
        
        ResultSet rs = ps.executeQuery();
        
        String fetchedSIN = "";
        while(rs.next()){
            fetchedSIN = rs.getString("sin");
        }
        
        return sin.compareTo(fetchedSIN) == 0 ? true : false;
    }
    
    public int InsertEmployeeRecords(com.pojo.Employee employee) throws SQLException{
        int generated_key = 0;
        String query = "INSERT INTO employee(first_name, last_name, sin, hourly_pay_rate) VALUES (?, ?, ?, ?)";
        
        PreparedStatement preparedStmt = this.connection.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);
        preparedStmt.setString(1, employee.GetFirstName());
        preparedStmt.setString(2, employee.GetLastName());
        preparedStmt.setString(3, employee.GetSocialInsuranceNumber());
        preparedStmt.setString(4, employee.GetHourlyPayRate());
        
        preparedStmt.execute();
        
        ResultSet rs = preparedStmt.getGeneratedKeys();
        while(rs.next()){
            generated_key = rs.getInt(1);
        }
        
        return generated_key;
    }
    
    public boolean UpdateEmployeeRecords(com.pojo.Employee employee) throws SQLException{
        String query = "UPDATE employee SET first_name = ?, last_name = ?, hourly_pay_rate = ? WHERE id = ?";
        
        PreparedStatement preparedStatement = this.connection.prepareStatement(query);
        preparedStatement.setString(1, employee.GetFirstName());
        preparedStatement.setString(2, employee.GetLastName());
        preparedStatement.setString(3, employee.GetHourlyPayRate());
        preparedStatement.setString(4, String.valueOf(employee.GetID()));
        
        return preparedStatement.execute();
    }
    
    public boolean DeleteEmployeeRecords(String id) throws SQLException{
        boolean row_exists = false;
        
        String query = "SELECT * FROM `team` LEFT JOIN employee ON employee.team_id = team.id WHERE employee.id = ?";
        
        PreparedStatement preparedStatement = this.connection.prepareStatement(query);
        preparedStatement.setInt(1, Integer.parseInt(id));
        
        ResultSet rs = preparedStatement.executeQuery();
        
        if(rs.next()){
            row_exists = true;
        }
        
        if(!row_exists){
            query = "DELETE FROM employee WHERE id = ?";

            preparedStatement = this.connection.prepareStatement(query);
            preparedStatement.setString(1, id);

            preparedStatement.execute();
        }
        
        return row_exists;
    }
    
    public ArrayList<com.pojo.Employee> GetAllEmployeeByTeamID(int team_id) throws SQLException{
        ArrayList<com.pojo.Employee> employeeArrayList = new ArrayList<com.pojo.Employee>();
        
        String query = "SELECT * FROM employee WHERE team_id = ?";
        
        PreparedStatement ps = this.connection.prepareStatement(query);
        ps.setInt(1, team_id);
        
        ResultSet rs = ps.executeQuery();
        
        while(rs.next()){
            employeeArrayList.add(new com.pojo.Employee(rs.getInt("id"), rs.getString("first_name"), rs.getString("last_name"), rs.getString("sin"), rs.getString("hourly_pay_rate"), rs.getString("created_at")));
        }
        
        return employeeArrayList;
    }
    
    public void DeleteEmployeeTasks(int taskid, int employeeid) throws SQLException{
        String query = "DELETE FROM employeetasks WHERE task_id = ? AND employee_id = ?";
        
        PreparedStatement ps = this.connection.prepareStatement(query);
        ps.setInt(1, taskid);
        ps.setInt(2, employeeid);
        ps.executeUpdate();
    }
}
