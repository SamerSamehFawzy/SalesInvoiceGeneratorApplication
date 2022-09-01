/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.salesinvgenerator.model;

import java.util.ArrayList;

/**
 *
 * @author Monica.George
 */
public class InvoiceHeader {
    private int number;
    private String date;
    private String customerName;
     private ArrayList<InvoiceLine> lines;

    public InvoiceHeader(int number, String date, String customerName) {
        this.number = number;
        this.date = date;
        this.customerName = customerName;
        
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public ArrayList<InvoiceLine> getLines() {
        
         if (lines == null) {
            lines = new ArrayList<>();
        }
        return lines;
    }

    public void setLines(ArrayList<InvoiceLine> lines) {
        this.lines = lines;
    }
     

    public double getInvoiceTotal() {
        double total = 0.0;
        for (InvoiceLine line : getLines()) {
            total += line.getInvoiceLineTotal();
        }
        return total;
    }

    @Override
    public String toString() {
        return "InvoiceHeader{" + "number=" + number + ", date=" + date + ", customerName=" + customerName + '}';
    }

}
