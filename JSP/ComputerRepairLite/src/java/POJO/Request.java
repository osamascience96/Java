/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package POJO;

/**
 *
 * @author osama
 */
public class Request {
    private int id;
    private String computerOwner;
    private String serialNumber;
    private String type;
    private String model;
    private int memory_gb;
    private int harddisk_gb;
    private String problems;
    private double repair_cost;
    private String repair_status;
    private String repair_finish_datetime;
    private String repair_delievery_datetime;
    
    public Request(){
    }
    
    public Request(int id, String computerOwner, String serialNumber, String type, String model, int memory_gb, int harddisk_gb, String problems, double repair_cost, String repair_status, String repair_finish_datetime, String repair_delievery_datetime){
        this.id = id;
        this.computerOwner = computerOwner;
        this.serialNumber = serialNumber;
        this.type = type;
        this.model = model;
        this.memory_gb = memory_gb;
        this.harddisk_gb = harddisk_gb;
        this.problems = problems;
        this.repair_cost = repair_cost;
        this.repair_status = repair_status;
        this.repair_finish_datetime = repair_finish_datetime;
        this.repair_delievery_datetime = repair_delievery_datetime;
    }
    
    public void SetId(int id){
        this.id = id;
    }
    public int GetId(){
        return this.id;
    }
    
    public void SetComputerOwner(String computerOwner){
        this.computerOwner = computerOwner;
    }
    public String GetComputerOwner(){
        return this.computerOwner;
    }
    
    public void SetSerialNumber(String serialNumber){
        this.serialNumber = serialNumber;
    }
    public String GetSerialNumber(){
        return this.serialNumber;
    }
    
    public void SetType(String type){
        this.type = type;
    }
    public String GetType(){
        return this.type;
    }
    
    public void SetModel(String model){
        this.model = model;
    }
    public String GetModel(){
        return this.model;
    }
    
    public void SetMemoryGB(int memory_gb){
        this.memory_gb = memory_gb;
    }
    public int GetMemoryGB(){
        return this.memory_gb;
    }
    
    public void SetHardGB(int hardgb){
        this.harddisk_gb = hardgb;
    }
    public int GetHardGB(){
        return this.harddisk_gb;
    }
    
    public void SetProblem(String problems){
        this.problems = problems;
    }
    public String GetProblem(){
        return this.problems;
    }
    
    public void SetRepairCost(double repair_cost){
        this.repair_cost = repair_cost;
    }
    public double GetRepairCost(){
        return this.repair_cost;
    }
    
    public void SetRepairStatus(String status){
        this.repair_status = status;
    }
    public String GetRepairStatus(){
        return this.repair_status;
    }
    
    public void SetRepairFinishDateTime(String repair_fisish_datetime){
        this.repair_finish_datetime = repair_fisish_datetime;
    }
    public String GetRepairFinishDateTime(){
        return this.repair_finish_datetime;
    }
    
    public void SetRepairDelieveryDateTime(String repair_delievery_datetime){
        this.repair_delievery_datetime = repair_delievery_datetime;
    }
    public String GetRepairDelieveryDateTIme(){
        return this.repair_delievery_datetime;
    }
}
