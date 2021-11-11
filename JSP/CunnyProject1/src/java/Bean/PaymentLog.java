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
public class PaymentLog {
    private int TImeSheetID;
    private int ssn;
    private String firstName;
    private String lastName;
    private int PayTypeId;
    private String PayType;
    private double PayAmount;
    
    public PaymentLog(){
    }

    public PaymentLog(int TImeSheetID, int ssn, String firstName, String lastName, int PayTypeId, String PayType, double PayAmount) {
        this.TImeSheetID = TImeSheetID;
        this.ssn = ssn;
        this.firstName = firstName;
        this.lastName = lastName;
        this.PayTypeId = PayTypeId;
        this.PayType = PayType;
        this.PayAmount = PayAmount;
    }

    public int getTImeSheetID() {
        return TImeSheetID;
    }

    public void setTImeSheetID(int TImeSheetID) {
        this.TImeSheetID = TImeSheetID;
    }

    public int getSsn() {
        return ssn;
    }

    public void setSsn(int ssn) {
        this.ssn = ssn;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public int getPayTypeId() {
        return PayTypeId;
    }

    public void setPayTypeId(int PayTypeId) {
        this.PayTypeId = PayTypeId;
    }

    public String getPayType() {
        return PayType;
    }

    public void setPayType(String PayType) {
        this.PayType = PayType;
    }

    public double getPayAmount() {
        return PayAmount;
    }

    public void setPayAmount(double PayAmount) {
        this.PayAmount = PayAmount;
    }
    
    
}
