/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main;

import FTP.FTPConnection;
import FTP.FTPGet;
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
@WebServlet(name = "OutputServlet", urlPatterns = {"/output_servlet"})
public class OutputServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String response = "";
        FTPConnection ftpConnection = new FTPConnection();
        boolean ftp = ftpConnection.ConnectFTPServer();
        if(ftp){
            // on connection success
            FTPGet fTPGet = new FTPGet(ftpConnection.GetCurrentClient());
            // path of storage 
            String pathStore = getServletContext().getRealPath("/").concat("/AKIVA.OUTPUT");
            boolean is_ftpge = fTPGet.GetFile("AKIVA.OUTPUT", pathStore);
            if(is_ftpge){
                File fileobj = new File(pathStore);
                String data = fileobj.ReadFile();
                if(data != null){
                    response = "success_reterived&data=".concat(data);
                }else{
                    response = "failed_reterived";
                }   
            }else{
                response = "ftp_file_get_failed";
            }
        }else{
            response = "ftp_connection_failed";
        }
        
        ftpConnection.CloseConnection();
        
        resp.sendRedirect(req.getContextPath().concat("?response=".concat(response)));
    }
}
