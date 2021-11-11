/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package FTP;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.apache.commons.net.ftp.FTPClient;

/**
 *
 * @author osama
 */
public class FTPConnection {

// testing credentials    
    String server = "ftp.dlptest.com";
    String user = "dlpuser";
    String password = "rNrKYTX9g7z3RgJRmxWuGHbeu";
    int port = 21;
    
//    Actuall Credentials
      // hide from the user
    
    private FtpMain ftpMain;
    private FTPClient ftpclient;
            
    public FTPConnection() {
        this.ftpMain = FtpMain.FTPCONNECT();
        this.ftpclient = this.ftpMain.GetClient();
    }
    
    
    public boolean ConnectFTPServer(){
        try {
            this.ftpclient.connect(server, port);
            return this.ftpclient.login(user, password);
        } catch (IOException ex) {
            Logger.getLogger(FTPConnection.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return false;
    }
    
    public FTPClient GetCurrentClient(){
        return this.ftpclient;
    }
    
    public boolean CloseConnection(){
        return this.ftpMain.Logout();
    }
}
