/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Bean;

/**
 *
 * @author osama
 */
public class Log {
    private int timesheetId;
    private String startTime;
    private String endTime;
    private int payTypeId;
    private double payAmount;
    private String payType;
   
    public Log(){
    }

    public Log(int timesheetId, String startTime, String endTime, int payTypeId, double payAmount, String payType) {
        this.timesheetId = timesheetId;
        this.startTime = startTime;
        this.endTime = endTime;
        this.payTypeId = payTypeId;
        this.payAmount = payAmount;
        this.payType = payType;
    }

    public int getTimesheetId() {
        return timesheetId;
    }

    public void setTimesheetId(int timesheetId) {
        this.timesheetId = timesheetId;
    }
    
    

    public String getStartTime() {
        return startTime;
    }

    public void setStartTime(String startTime) {
        this.startTime = startTime;
    }

    public String getEndTime() {
        return endTime;
    }

    public void setEndTime(String endTime) {
        this.endTime = endTime;
    }

    public int getPayTypeId() {
        return payTypeId;
    }

    public void setPayTypeId(int payTypeId) {
        this.payTypeId = payTypeId;
    }

    public double getPayAmount() {
        return payAmount;
    }

    public void setPayAmount(double payAmount) {
        this.payAmount = payAmount;
    }

    public String getPayType() {
        return payType;
    }

    public void setPayType(String payType) {
        this.payType = payType;
    }
}
