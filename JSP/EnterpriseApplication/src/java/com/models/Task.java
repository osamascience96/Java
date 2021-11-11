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
public class Task {
    private Connection connection;
    
    public Task(){
        this.connection = Connector.getConnectionInstance().getConnection();
    }
    
    public int InsertTask(com.pojo.Task task) throws SQLException{
        int generatedkey = 0;
        String query = "INSERT INTO tasks(name, description, duration, created_at) VALUES (?, ?, ?, ?)";
        
        PreparedStatement ps = this.connection.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);
        
        ps.setString(1, task.GetName());
        ps.setString(2, task.GetDescription());
        ps.setInt(3, task.GetDuration());
        ps.setString(4, task.GetCreatedAt());
        
        ps.execute();
        
        ResultSet rs = ps.getGeneratedKeys();
        while(rs.next()){
            generatedkey = rs.getInt(1);
        }
        
        return generatedkey;
    }
    
    public boolean CheckTaskExistance(String task_name) throws SQLException{
        String query = "SELECT * FROM tasks WHERE name = ?";
        
        PreparedStatement ps = this.connection.prepareStatement(query);
        ps.setString(1, task_name);
        
        ResultSet rs = ps.executeQuery();
        String final_task_name = "";
        while(rs.next()){
            final_task_name = rs.getString("name");
        }
        
        return final_task_name.compareToIgnoreCase(task_name) == 0 ? true : false;
    }
    
    public void UpdateTask(com.pojo.Task task) throws SQLException{
        String query = "UPDATE tasks SET name = ?, description = ?, duration = ? WHERE id = ?";
        
        PreparedStatement ps = this.connection.prepareStatement(query);
        ps.setString(1, task.GetName());
        ps.setString(2, task.GetDescription());
        ps.setInt(3, task.GetDuration());
        ps.setInt(4, task.GetId());
        
        ps.execute();
    }
    
    public ArrayList<com.pojo.Task> GetAllTasksDB() throws SQLException{
        ArrayList<com.pojo.Task> arrayListTasks = new ArrayList<com.pojo.Task>();
        
        String query  = "SELECT * FROM tasks";
        
        Statement stmt = this.connection.createStatement();
        ResultSet rs = stmt.executeQuery(query);
        
        while(rs.next()){
            com.pojo.Task taskObject = new com.pojo.Task(rs.getInt("id"), rs.getString("name"), rs.getString("description"), rs.getInt("duration"), rs.getString("created_at"));
            taskObject.SetUpdatedAt(rs.getString("updated_at"));
            arrayListTasks.add(taskObject);
        }
        
        return arrayListTasks;
    }
    
    public int CheckTasktoEmployees(int taskId, int employeeId) throws SQLException{
        int count = 0;
        
        String query = "SELECT * FROM employeetasks WHERE task_id = ? AND employee_id = ?";
        
        PreparedStatement ps = this.connection.prepareStatement(query);
        ps.setInt(1, taskId);
        ps.setInt(2, employeeId);
        ResultSet rs = ps.executeQuery();
        
        while(rs.next()){
            count+=1;
        }
        
        return count;
    }
    
    public void SetTasktoEmployees(int taskId, int employeeId) throws SQLException{
        String query = "INSERT INTO employeetasks(employee_id, task_id) VALUES(?, ?)";
        
        PreparedStatement ps = this.connection.prepareStatement(query);
        ps.setInt(1, employeeId);
        ps.setInt(2, taskId);
        
        ps.execute();
    }
    
    public ArrayList<com.pojo.Task> GetEmployeeTaskList(int employee_id) throws SQLException{
        ArrayList<com.pojo.Task> arrayListTask = new ArrayList<com.pojo.Task>();
        
        String query = "SELECT * FROM tasks JOIN employeetasks ON employeetasks.task_id = tasks.id WHERE employeetasks.employee_id = ?";
        
        PreparedStatement ps = this.connection.prepareStatement(query);
        ps.setInt(1, employee_id);
        ResultSet rs = ps.executeQuery();
        
        while(rs.next()){
            arrayListTask.add(new com.pojo.Task(rs.getInt("id"), rs.getString("name"), rs.getString("description"), rs.getInt("duration"), rs.getString("created_at")));
        }
        
        return arrayListTask;
    }
    
    public void deleteTask(int id) throws SQLException{
        String query = "DELETE FROM tasks WHERE id = ?";
        PreparedStatement ps = this.connection.prepareStatement(query);
        ps.setInt(1, id);
        ps.execute();
    }
    
    public void deleteEmployeeTask(int id) throws SQLException{
        String query = "DELETE FROM employeetasks WHERE task_id = ?";
        PreparedStatement ps = this.connection.prepareStatement(query);
        ps.setInt(1, id);
        ps.execute();
    }
    
    public void deleteEmployeeFromTask(int id) throws SQLException{
        String query = "DELETE FROM employeetasks WHERE employee_id = ?";
        PreparedStatement ps = this.connection.prepareStatement(query);
        ps.setInt(1, id);
        ps.execute();
    }
    
    public int GetSelectedtaskTotalTime(String task_id_array) throws SQLException{
        String query = "";
        int totalTime = 0;
        PreparedStatement ps = null;
        query = "SELECT duration FROM tasks WHERE id = ?";
        ps = this.connection.prepareStatement(query);
        ps.setInt(1, Integer.parseInt(task_id_array));

        ResultSet rs = ps.executeQuery();

        while(rs.next()){
            totalTime += rs.getInt("duration");
        }
        
        return totalTime;
    }
}
