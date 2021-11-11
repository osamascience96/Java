/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

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
public class Car {
    private Connection connection;
    
    public Car(){
        this.connection = Connector.getConnectionInstance().getConnection();
    }
    
    public void InsertCartoSaleDB(Bean.Car car) throws SQLException{
        String query = "";
        // check if the inputsream to the object is set 
        if(car.getInputStream() != null){
            query = "INSERT INTO cars(user_id, manufacturer, model, type, year_of_manufacturer, miles, price, hasAC, hasDVD, comments, image) VALUES(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
        }else{
            query = "INSERT INTO cars(user_id, manufacturer, model, type, year_of_manufacturer, miles, price, hasAC, hasDVD, comments) VALUES(?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
        }
        
        PreparedStatement pstmt = this.connection.prepareStatement(query);
        pstmt.setInt(1, car.getUser().getId());
        pstmt.setString(2, car.getManufacturer());
        pstmt.setString(3, car.getModel());
        pstmt.setString(4, car.getType());
        pstmt.setInt(5, car.getYear_of_manufacturer());
        pstmt.setInt(6, car.getMiles());
        pstmt.setFloat(7, car.getPrice());
        pstmt.setString(8, String.valueOf(car.getHasAC()));
        pstmt.setString(9, String.valueOf(car.getHasDVD()));
        pstmt.setString(10, car.getComments());
        if(car.getInputStream() != null){
            pstmt.setBlob(11, car.getInputStream());
        }
        
        pstmt.executeUpdate();
    }
    
    public ArrayList<Bean.Car> GetCarArrayList() throws SQLException{
        ArrayList<Bean.Car> arrayListCars = new ArrayList<Bean.Car>();
        
        String query = "SELECT cars.*, user.username FROM cars LEFT JOIN user ON cars.user_id = user.id";
        PreparedStatement pstmt = this.connection.prepareStatement(query);
        
        ResultSet rs = pstmt.executeQuery();
        
        while(rs.next()){
            Bean.User user = new Bean.User();
            user.setId(rs.getInt("user_id"));
            user.setUsername(rs.getString("username"));
            
            arrayListCars.add(new Bean.Car(rs.getInt("id"), user, rs.getString("manufacturer"), rs.getString("model"), rs.getString("type"), rs.getInt("year_of_manufacturer"), rs.getInt("miles"), rs.getFloat("price"), rs.getString("hasAC").charAt(0), rs.getString("hasDVD").charAt(0), rs.getString("comments"), rs.getBlob("image"), rs.getString("created_at")));
        }
        
        return arrayListCars;
    }
}
