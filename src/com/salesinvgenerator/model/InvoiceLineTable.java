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
public class InvoiceLineTable extends AbstractTableModel {
    
    
    private ArrayList<InvoiceLine> lineData;
    private String[] invoiceColumns = {"No.", "Item Name", "Item Price", "Count", "Item Total"};

    public InvoiceLineTable(ArrayList<InvoiceLine> lineData) {
        this.lineData = lineData;
    }

    public ArrayList<InvoiceLine> getLineData() {
        return lineData;
    }


    @Override
    public int getRowCount() {
        return lineData.size();
    }

    @Override
    public int getColumnCount() {
        return invoiceColumns.length;
    }
    
    @Override
    public String getColumnName(int column){
        return invoiceColumns[column];
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        switch(columnIndex){
            case 0:
                return lineData.get(rowIndex).getInvoice().getNumber();
            case 1:
                return lineData.get(rowIndex).getItem();
            case 2:
                return lineData.get(rowIndex).getPrice();
            case 3:
                return lineData.get(rowIndex).getCount();
            case 4:
                return lineData.get(rowIndex).getInvoiceLineTotal();
            default:
                return "";
        }
    
    }
    
}
