/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package FTP;

import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.Reader;
import java.nio.charset.StandardCharsets;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.apache.commons.net.ftp.FTP;
import org.apache.commons.net.ftp.FTPClient;

/**
 *
 * @author osama
 */
public class FTPGet {
    private FTPClient fTPClient;
    

    public FTPGet(FTPClient fTPClient) {
        this.fTPClient = fTPClient;
    }
    
    public boolean GetFile(String remoteFile, String path){
        boolean success = false;
        
        File fileObj = new File(path);
        try {
            this.fTPClient.setFileType(FTP.EBCDIC_FILE_TYPE);
            this.fTPClient.enterLocalPassiveMode();
            OutputStream outputPathStream = new BufferedOutputStream(new FileOutputStream(fileObj));
            success = this.fTPClient.retrieveFile(remoteFile, outputPathStream);
            outputPathStream.close();
        } catch (FileNotFoundException ex) {
            Logger.getLogger(FTPGet.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(FTPGet.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return success;
    }
    
    /*
        Code takesn from https://frontbackend.com/java/reader-to-byte-array-in-java
    */
    public byte[] GetReaderBytes(Reader reader){
        char[] buffer = new char[4096];
        StringBuilder builder = new StringBuilder();
        int numChars;

        try {
            while ((numChars = reader.read(buffer)) >= 0) {
                builder.append(buffer, 0, numChars);
            }
        } catch (IOException ex) {
            Logger.getLogger(FTPGet.class.getName()).log(Level.SEVERE, null, ex);
        }

        byte[] bytes = builder.toString()
                              .getBytes(StandardCharsets.UTF_8);
        
        return bytes;
    }
    
    public InputStream GetInputStream(String remote){
        String mainframeDataSet = remote;
        try {
            InputStream stream = this.fTPClient.retrieveFileStream(mainframeDataSet);
            Reader reader = new InputStreamReader(stream, "cp037");
            byte[] bytes = this.GetReaderBytes(reader);
            String s = new String(bytes, "cp037");
            System.out.println(s);
            return stream;
        } catch (IOException ex) {
            Logger.getLogger(FTPGet.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return null;
    }
    
}
