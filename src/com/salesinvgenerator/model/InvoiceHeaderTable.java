/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.salesinvgenerator.model;

import java.util.ArrayList;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author Monica.George
 */
public class InvoiceHeaderTable extends AbstractTableModel {

    private final ArrayList<InvoiceHeader> invoicesData;
    private final String[] invoiceHeaderColumns = {"No.", "Date", "Customer", "Total"};
    
     public InvoiceHeaderTable(ArrayList<InvoiceHeader> invoicesData) {
        this.invoicesData = invoicesData;
    }

    @Override
    public int getRowCount() {
       //throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
       return invoicesData.size();
    }

    @Override
    public int getColumnCount() {
        //throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
        return invoiceHeaderColumns.length;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
       // throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
        switch (columnIndex) {
            case 0:
                return invoicesData.get(rowIndex).getNumber();
            case 1:
                return invoicesData.get(rowIndex).getDate();
            case 2:
                return invoicesData.get(rowIndex).getCustomerName();
            case 3:
                return invoicesData.get(rowIndex).getInvoiceTotal();
            default:
                return "";
        }
    }
    
}
