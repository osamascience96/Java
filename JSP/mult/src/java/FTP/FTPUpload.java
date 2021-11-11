/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package FTP;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.apache.commons.net.ftp.FTP;
import org.apache.commons.net.ftp.FTPClient;

/**
 *
 * @author osama
 */
public class FTPUpload {
    private FTPClient ftpClient;
    private File localeFile;

    public FTPUpload(FTPClient ftpClient, File localeFile) {
        this.ftpClient = ftpClient;
        this.localeFile = localeFile;
    }
    
    public boolean UploadFile(String inputfile){
        boolean uploadfile = false;
        try {
            // set the file type 
            this.ftpClient.setFileType(FTP.EBCDIC_FILE_TYPE);
            this.ftpClient.setFileTransferMode(FTP.EBCDIC_FILE_TYPE);
            this.ftpClient.enterLocalPassiveMode();
            // set the input stream
            InputStream inputStream = new FileInputStream(this.localeFile);
            // upload to the ftp
            uploadfile = this.ftpClient.storeFile(inputfile, inputStream);
            // close the stream
            inputStream.close();
        } catch (FileNotFoundException ex) {
            Logger.getLogger(FTPUpload.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(FTPUpload.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return uploadfile;
    }
}
