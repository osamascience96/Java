/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bean;

/**
 *
 * @author osama
 */
public class Personnel {
    private int id;
    private String personnel_login;
    private String personnel_password;
    
    public Personnel(){
    }

    public Personnel(int id, String personnel_login, String personnel_password) {
        this.id = id;
        this.personnel_login = personnel_login;
        this.personnel_password = personnel_password;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getPersonnel_login() {
        return personnel_login;
    }

    public void setPersonnel_login(String personnel_login) {
        this.personnel_login = personnel_login;
    }

    public String getPersonnel_password() {
        return personnel_password;
    }

    public void setPersonnel_password(String personnel_password) {
        this.personnel_password = personnel_password;
    }
}
