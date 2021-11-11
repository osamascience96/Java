/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package FileHandling;

import Model.Intervention;
import Model.PDQ;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author osama
 */
public class ReadFile {
    private Scanner scanner = null;
    
    public ReadFile(){
    }
    
    public ReadFile(String path){
        try {
            this.scanner = new Scanner(new File(path), "utf-8");
        } catch (FileNotFoundException ex) {
            Logger.getLogger(ReadFile.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public ArrayList<String> GetAllPDQ(){
        ArrayList<String> PDQArrayList = new ArrayList<String>();
        
        while(this.scanner.hasNextLine()){
            PDQArrayList.add(this.scanner.nextLine());
        }
        
        this.scanner.close();
        
        return PDQArrayList;
    }
    
    public PDQ GetPDQObject(int pdq_number){
        PDQ pdq = null;
        int lineNumber = 0;
        while(this.scanner.hasNextLine()){
            String[] line = this.scanner.nextLine().split(";");
            lineNumber += 1; // increment the line number
            //check if the record is the desired number 
            try {
                if(pdq_number == Integer.parseInt(line[0])){
                    pdq = new PDQ(Integer.parseInt(line[0]), line[1], Integer.parseInt(line[2]));
                    pdq.SetLineNumber(lineNumber);
                }
            } catch (NumberFormatException e) {
                System.out.println("Input String cannot be parsed to Integer.");
            }
        }
        
        return pdq;
    }
    
    public ArrayList<String> GetCategoryInterventionList(){
        ArrayList<String> CategoryInterventionList = new ArrayList<String>();
        
        while(this.scanner.hasNextLine()){
            CategoryInterventionList.add(this.scanner.nextLine());
        }
        
        this.scanner.close();
        
        return CategoryInterventionList;
    }
    
    public ArrayList<String> GetQuarterList(){
        ArrayList<String> QuarterList = new ArrayList<String>();
        
        while(this.scanner.hasNextLine()){
            QuarterList.add(this.scanner.nextLine());
        }
        
        this.scanner.close();
        
        return QuarterList;
    }
    
    public ArrayList<String> GetMinandMaxDate(File file){
        ArrayList<String> DateList = new ArrayList<String>();
        BufferedReader tsvReader = null;
        try {
            tsvReader = new BufferedReader(new FileReader(file));
        } catch (FileNotFoundException ex) {
            Logger.getLogger(ReadFile.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println(ex.toString());
        }
        String line = null;
        try {
            while((line = tsvReader.readLine()) != null){
                DateList.add(line.split("\t")[1]);
            }
        } catch (IOException ex) {
            Logger.getLogger(ReadFile.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return DateList;
    }
    
    public ArrayList<Intervention> GetAllInterventionList(File file){
        ArrayList<Intervention> InterventionList = new ArrayList<Intervention>();
        
        BufferedReader tsvReader = null;
        try {
            tsvReader = new BufferedReader(new FileReader(file));
        } catch (FileNotFoundException ex) {
            Logger.getLogger(ReadFile.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println(ex.toString());
        }
        
        String line = null;
        try {
            while((line = tsvReader.readLine()) != null){
                String data[] = line.split("\t");
                try {
                    InterventionList.add(new Intervention(Integer.parseInt(data[0]), data[1], data[2], data[3], data[4]));
                } catch (NumberFormatException e) {
                    System.out.println("Input String cannot be parsed to Integer.");
                }
            }
        } catch (IOException ex) {
            Logger.getLogger(ReadFile.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return InterventionList;
    }
}
