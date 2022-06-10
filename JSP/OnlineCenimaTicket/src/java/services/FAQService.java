/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package services;

import models.FAQ;

/**
 *
 * @author osama
 */
public class FAQService {
    public String name;
    public String email;
    public String subject;
    public String message;
    
    private FAQ faqModel;

    public FAQService(String name, String email, String subject, String message) {
        this.name = name;
        this.email = email;
        this.subject = subject;
        this.message = message;
        
        this.faqModel = new FAQ();
    }
    
    public String DoSubmitMessage(){
        this.name = this.name.trim();
        this.email = this.email.trim();
        this.subject = this.subject != null ? this.subject : null;
        this.message = this.message.trim();
        
        this.faqModel.name = this.name;
        this.faqModel.subject = this.subject;
        this.faqModel.email = this.email;
        this.faqModel.message = this.message;
        
        boolean IsMessageSubmit = this.faqModel.InsertFAQ();
        
        return IsMessageSubmit ? "Success" : "Failed";
    }
    
    
}
