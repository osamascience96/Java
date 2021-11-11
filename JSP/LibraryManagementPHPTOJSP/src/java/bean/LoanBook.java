/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bean;

/**
 *
 * @author osama
 */
public class LoanBook {
    private int transaction_id;
    private Personnel personnel;
    private Member member;
    private Book book;
    private String dateOfIssue;
    private String dateOfReturn;

    public LoanBook() {
    }

    public LoanBook(int transaction_id, Personnel personnel, Member member, Book book, String dateOfIssue, String dateOfReturn) {
        this.transaction_id = transaction_id;
        this.personnel = personnel;
        this.member = member;
        this.book = book;
        this.dateOfIssue = dateOfIssue;
        this.dateOfReturn = dateOfReturn;
    }

    public int getTransaction_id() {
        return transaction_id;
    }

    public void setTransaction_id(int transaction_id) {
        this.transaction_id = transaction_id;
    }

    public Personnel getPersonnel() {
        return personnel;
    }

    public void setPersonnel(Personnel personnel) {
        this.personnel = personnel;
    }

    public Member getMember() {
        return member;
    }

    public void setMember(Member member) {
        this.member = member;
    }

    public Book getBook() {
        return book;
    }

    public void setBook(Book book) {
        this.book = book;
    }

    public String getDateOfIssue() {
        return dateOfIssue;
    }

    public void setDateOfIssue(String dateOfIssue) {
        this.dateOfIssue = dateOfIssue;
    }

    public String getDateOfReturn() {
        return dateOfReturn;
    }

    public void setDateOfReturn(String dateOfReturn) {
        this.dateOfReturn = dateOfReturn;
    }
    
    
}
