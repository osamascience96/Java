/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.controllers;

import com.models.Client;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author osama
 */
@WebServlet(name = "ClientServlet", urlPatterns = {"/client_servlet"})
public class ClientServlet extends HttpServlet {
    private Client clientModel;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String link = "clients.jsp";
        
        String request_type = req.getParameter("request_type");
        
        this.clientModel = new Client();
        
        if(request_type != null){
            // if the request type is del
            if(request_type.compareTo("del") == 0){
                int client_id = Integer.parseInt(req.getParameter("client_id"));
                
                try {
                    this.clientModel.DeleteClient(client_id);
                } catch (SQLException ex) {
                    Logger.getLogger(ClientServlet.class.getName()).log(Level.SEVERE, null, ex);
                }
                
                link = "client_servlet?response=deleted_successfully";
            }
        }else{
            ArrayList<com.pojo.Client> clientsArrayList = null;
        
            try {
                clientsArrayList = this.clientModel.GetAllClientList();
            } catch (SQLException ex) {
                Logger.getLogger(ClientServlet.class.getName()).log(Level.SEVERE, null, ex);
            }

            HttpSession httpSession = req.getSession();
            httpSession.setAttribute("clients_list", clientsArrayList);
            
            if(req.getParameter("response") != null){
                String response = req.getParameter("response");
                link = link.concat("?response=").concat(response);
            }
        }
        
        resp.sendRedirect(link);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.clientModel = new Client();
        
        String link = "client_servlet";
        String request_type = req.getParameter("request_type");
        
        String name = req.getParameter("name");
        String address = req.getParameter("address");
        String email = req.getParameter("email");
        String phone = req.getParameter("phone");
        
        if(request_type.compareTo("insert") == 0){
            String created_at = req.getParameter("created_at");
            
            com.pojo.Client client = new com.pojo.Client();
            client.SetName(name);
            client.SetAddress(address);
            client.SetEmail(email);
            client.SetPhone(phone);
            client.SetCreatedAt(created_at);
            
            try {
                if(!this.clientModel.CheckClientExistance(name)){
                    this.clientModel.InsertClient(client);
                    link = link.concat("?response=client_insert_success");
                }else{
                    link = link.concat("?response=client_exists");
                }
            } catch (SQLException ex) {
                Logger.getLogger(ClientServlet.class.getName()).log(Level.SEVERE, null, ex);
            }
        }else if(request_type.compareTo("update") == 0){
            com.pojo.Client client = new com.pojo.Client();
            client.SetId(Integer.parseInt(req.getParameter("client_id")));
            client.SetName(name);
            client.SetAddress(address);
            client.SetEmail(email);
            client.SetPhone(phone);
            
            try {
                this.clientModel.UpdateClient(client);
                link = link.concat("?response=client_update_success");
            } catch (SQLException ex) {
                Logger.getLogger(ClientServlet.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        
        resp.sendRedirect(link);
    }
    
    
    
}
