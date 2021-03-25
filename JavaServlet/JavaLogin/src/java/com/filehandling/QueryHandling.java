/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.filehandling;

import com.models.Query;
import java.io.FileWriter;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author osama
 */
public class QueryHandling {
    private String filename;
    
    public QueryHandling(String filename){
        this.filename = filename;
    }
    
    public boolean WriteQuery(Query query){
        boolean data_write_flag = false;
        
        try {
            FileWriter fileWriter = new FileWriter(this.filename, true);
            fileWriter.append(query.GetName().concat("\n"));
            fileWriter.append(query.GetEmail().concat("\n"));
            fileWriter.append(query.GetMessage().concat("\n"));
            fileWriter.append("\n");
            fileWriter.close();
            data_write_flag = true;
        } catch (IOException ex) {
            Logger.getLogger(QueryHandling.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return data_write_flag;
    }
}
