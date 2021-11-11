/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package EJB;

/**
 *
 * @author osama
 */
public class Register {
    private int id;
    private int AssesseId;
    private String email;
    private String billNo;
    private String RegisteredDateTime;
    private String remarks;
    private String mobileNo1;
    private String mobileNo2;
    private int otp;

    public Register() {
    }

    public Register(int id, int AssesseId, String email, String billNo, String RegisteredDateTime, String remarks, String mobileNo1, String mobileNo2, int otp) {
        this.id = id;
        this.AssesseId = AssesseId;
        this.email = email;
        this.billNo = billNo;
        this.RegisteredDateTime = RegisteredDateTime;
        this.remarks = remarks;
        this.mobileNo1 = mobileNo1;
        this.mobileNo2 = mobileNo2;
        this.otp = otp;
    }
    
    

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getAssesseId() {
        return AssesseId;
    }

    public void setAssesseId(int AssesseId) {
        this.AssesseId = AssesseId;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getBillNo() {
        return billNo;
    }

    public void setBillNo(String billNo) {
        this.billNo = billNo;
    }

    public String getRegisteredDateTime() {
        return RegisteredDateTime;
    }

    public void setRegisteredDateTime(String RegisteredDateTime) {
        this.RegisteredDateTime = RegisteredDateTime;
    }

    public String getRemarks() {
        return remarks;
    }

    public void setRemarks(String remarks) {
        this.remarks = remarks;
    }

    public String getMobileNo1() {
        return mobileNo1;
    }

    public void setMobileNo1(String mobileNo1) {
        this.mobileNo1 = mobileNo1;
    }

    public String getMobileNo2() {
        return mobileNo2;
    }

    public void setMobileNo2(String mobileNo2) {
        this.mobileNo2 = mobileNo2;
    }

    public int getOtp() {
        return otp;
    }

    public void setOtp(int otp) {
        this.otp = otp;
    }
    
    
}
