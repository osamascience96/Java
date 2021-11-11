package FTP;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.apache.commons.net.ftp.FTPClient;

public class FtpMain {

    /*A Singleton Class to return the object of the ftpobject*/
    
    private FTPClient ftpclient;
    private static FtpMain ftp_main = null;
    
    public FtpMain() {
        this.ftpclient = new FTPClient();
    }
    
    public static FtpMain FTPCONNECT(){
        if(ftp_main == null){
            ftp_main = new FtpMain();
        }
        
        return ftp_main;
    }
    
    public FTPClient GetClient(){
        return this.ftpclient;
    }
    
    public boolean Logout(){
        try {
            return this.ftpclient.logout();
        } catch (IOException ex) {
            Logger.getLogger(FtpMain.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return false;
    }
    
}
