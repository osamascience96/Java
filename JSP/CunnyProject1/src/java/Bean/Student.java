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
public class Student {
    private int ssnId;
    private String firstName;
    private String mi;
    private String lastName;
    private String birthDate;
    private String street;
    private String phone;
    private String zipcode;
    private String deptId;
    
    public Student(){
    }

    public Student(int ssnId, String firstName, String mi, String lastName, String birthDate, String street, String phone, String zipcode, String deptId) {
        this.ssnId = ssnId;
        this.firstName = firstName;
        this.mi = mi;
        this.lastName = lastName;
        this.birthDate = birthDate;
        this.street = street;
        this.phone = phone;
        this.zipcode = zipcode;
        this.deptId = deptId;
    }

    public int getSsnId() {
        return ssnId;
    }

    public void setSsnId(int ssnId) {
        this.ssnId = ssnId;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getMi() {
        return mi;
    }

    public void setMi(String mi) {
        this.mi = mi;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(String birthDate) {
        this.birthDate = birthDate;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getZipcode() {
        return zipcode;
    }

    public void setZipcode(String zipcode) {
        this.zipcode = zipcode;
    }

    public String getDeptId() {
        return deptId;
    }

    public void setDeptId(String deptId) {
        this.deptId = deptId;
    }
    
    
}
