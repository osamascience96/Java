/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Database;

/**
 *
 * @author osama
 */
public class DBCredentials {
    private static String DBID;
    private static String DBPassword;
    
    public static void SetDBID(String ID){
        DBID = ID;
    }
    
    public static String GetDBID(){
        return DBID;
    }
    
    public static void SetDBPassword(String password){
        DBPassword = password;
    }
    
    public static String GetDBPassword(){
        return DBPassword;
    }
}
