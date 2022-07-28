/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package SalesInvoice.View;

import SalesInvoice.Model.Invoice;
import java.util.ArrayList;
import java.awt.GridLayout;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JTextField;
/**
 *
 * @author Samer.Sameh
 */
public class InvoiceData extends JDialog {
    private final JTextField customerNameField;
    private final JTextField invoiceDateField;
    private final JLabel customerNameLabel;
    private final JLabel invoiceDateLabel;
    private final JButton okButton;
    private final JButton cancelButton;    
    
     public InvoiceData(InvFrame frame) {
        customerNameLabel = new JLabel("Customer Name:");
        customerNameField = new JTextField(20);
        invoiceDateLabel = new JLabel("Invoice Date:");
        invoiceDateField = new JTextField(20);
        okButton = new JButton("OK");
        cancelButton = new JButton("Cancel");
        okButton.setActionCommand("createInvoiceOK");
        cancelButton.setActionCommand("createInvoiceCancel");
        
        okButton.addActionListener(frame.getController());
        cancelButton.addActionListener(frame.getController());
        setLayout(new GridLayout(3, 2));
        
        add(invoiceDateLabel);
        add(invoiceDateField);
        add(customerNameLabel);
        add(customerNameField);
        add(okButton);
        add(cancelButton);
        
        pack();
        
    }
public JTextField getcustomerNameField() {
        return customerNameField;
    }

    public JTextField getinvoiceDateField() {
        return invoiceDateField;
    }
}
