/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.salesinvgenerator.model;

/**
 *
 * @author Monica.George
 */
public class InvoiceLine {
   
    private String item;
    private double price;
    private int count;
    private InvoiceHeader invoice;
   

    public InvoiceLine( String item, double price, int count,InvoiceHeader invoice) {
        this.item = item;
        this.price = price;
        this.count = count;
        this.invoice = invoice;
       
    }

   

  

    public InvoiceHeader getInvoice() {
        return invoice;
    }

    public void setInvoice(InvoiceHeader invoice) {
        this.invoice = invoice;
    }

    public String getItem() {
        return item;
    }

    public void setItem(String item) {
        this.item = item;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    
    public double getInvoiceLineTotal() {
        return price * count;
    }

}
