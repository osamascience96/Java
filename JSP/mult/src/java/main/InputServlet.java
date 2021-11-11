/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main;

import FTP.FTPConnection;
import FTP.FTPUpload;
import file.File;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author osama
 */
@WebServlet(name = "InputServlet", urlPatterns = {"/input_servlet"})
public class InputServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        
        String response = "";
        
        String firstnumber = req.getParameter("fn");
        String lastnumber = req.getParameter("ln");
        
        // concatenate to one string
        String concatenatedString = firstnumber.concat(" ").concat(lastnumber);
        
        File file = new File(getServletContext().getRealPath("/").concat("/AKIVA.INPUT"));
        boolean is_file_created = file.createFile();
        if(is_file_created){
            boolean write_string = file.WritetoFile(concatenatedString);
            if(!write_string){
                response = "data_not_stored_to_file";
            }else{
                // eastablish the connection with the ftp
                FTPConnection fTPConnection = new FTPConnection();
                boolean is_server_connected = fTPConnection.ConnectFTPServer();
                if(is_server_connected){
                    String remoteFile = "AKIVA.INPUT";
                    FTPUpload ftpupload = new FTPUpload(fTPConnection.GetCurrentClient(), file.GetFile());
                    boolean done = ftpupload.UploadFile(remoteFile);
                    if(done){
                        response = "inputfile_uploaded";
                    }else{
                        response = "inputfile_upload_failed";
                    }
                }else{
                    response = "server_not_connected";
                }
            }
        }else{
            response = "file_not_created";
        }
        
        resp.sendRedirect(req.getContextPath().concat("?response=".concat(response)));
    }
    
}
