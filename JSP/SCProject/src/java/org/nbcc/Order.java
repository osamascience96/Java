package org.nbcc;

public class Order {

    String bookName;
    String subject;
    String campus;
    int qty;
    double price;
    int term;
    String discount;
    String total;
    String subtotal;
    String tax;

    public Order(String bookName, String subject, String campus, int qty, double price, int term, String discount, String total, String subtotal, String tax) {
        this.bookName = bookName;
        this.subject = subject;
        this.campus = campus;
        this.qty = qty;
        this.price = price;
        this.term = term;
        this.discount = discount;
        this.total = total;
        this.subtotal = subtotal;
        this.tax = tax;
    }

    

    public String getBookName() {
        return bookName;
    }

    public void setBookName(String bookName) {
        this.bookName = bookName;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public String getCampus() {
        return campus;
    }

    public void setCampus(String campus) {
        this.campus = campus;
    }

    public int getQty() {
        return qty;
    }

    public void setQty(int qty) {
        this.qty = qty;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getTerm() {
        return term;
    }

    public void setTerm(int term) {
        this.term = term;
    }

    public String getDiscount() {
        return discount;
    }

    public void setDiscount(String discount) {
        this.discount = discount;
    }

    public String getTotal() {
        return total;
    }

    public void setTotal(String total) {
        this.total = total;
    }

    public String getSubtotal() {
        return subtotal;
    }

    public void setSubtotal(String subtotal) {
        this.subtotal = subtotal;
    }

    public String getTax() {
        return tax;
    }

    public void setTax(String tax) {
        this.tax = tax;
    }

    
}
