/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

/**
 *
 * @author osama
 */
public class Intervention {
    private int ID_INTERVENTION;
    private String DATE_INCIDENT;
    private String CATÉGORIE;
    private String PDQ;
    private String QUART_TRAVAIL;
    
    public Intervention(){
    }
    
    public Intervention(int ID_INTERVENTION, String DATE_INCIDENT, String CATÉGORIE, String PDQ, String QUART_TRAVAIL){
        this.ID_INTERVENTION = ID_INTERVENTION;
        this.DATE_INCIDENT = DATE_INCIDENT;
        this.CATÉGORIE = CATÉGORIE;
        this.PDQ = PDQ;
        this.QUART_TRAVAIL = QUART_TRAVAIL;
    }
    
    public void SETIDINTERVENTION(int ID_INTERVENTION){
        this.ID_INTERVENTION = ID_INTERVENTION;
    }
    public int GETIDINTERVENTION(){
        return this.ID_INTERVENTION;
    }
    
    public void SETDATEINCIDENT(String DATE_INCIDENT){
        this.DATE_INCIDENT = DATE_INCIDENT;
    }
    public String GETDATEINCIDENT(){
        return this.DATE_INCIDENT;
    }
    
    public void SETCATÉGORIE(String CATÉGORIE){
        this.CATÉGORIE = CATÉGORIE;
    }
    public String GETCATÉGORIE(){
        return this.CATÉGORIE;
    }
    
    public void SETPDQ(String PDQ){
        this.PDQ = PDQ;
    }
    public String GETPDQ(){
        return this.PDQ;
    }
    
    public void SETQUARTTRAVAIL(String QUART_TRAVAIL){
        this.QUART_TRAVAIL = QUART_TRAVAIL;
    }
    public String GETQUARTTRAVAIL(){
        return this.QUART_TRAVAIL;
    }
}
