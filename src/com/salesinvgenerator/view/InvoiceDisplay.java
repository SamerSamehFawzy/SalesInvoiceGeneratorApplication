/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.salesinvgenerator.view;

import java.awt.GridLayout;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JTextField;

/**
 *
 * @author Monica.George
 */
public class InvoiceDisplay extends JDialog{

    private final JLabel dateLabel;
    private final JTextField dateTextField;
    private final JLabel customerNameLabel;
    private final JTextField customerNameTextField;
    private final JButton createInvoiceButton;
    private final JButton cancelInvoiceButton;

    public InvoiceDisplay(SalesInvFrame frame) {
        dateLabel = new JLabel("Invoice Date: ");
        dateTextField = new JTextField(15);
        customerNameLabel = new JLabel("Customer Name: ");
        customerNameTextField = new JTextField(15);

        createInvoiceButton = new JButton("Create");
        cancelInvoiceButton = new JButton("Cancel");

        createInvoiceButton.setActionCommand("Create Invoice");
        cancelInvoiceButton.setActionCommand("Cancel Invoice");

        createInvoiceButton.addActionListener(frame.getController());
        cancelInvoiceButton.addActionListener(frame.getController());

        setLayout(new GridLayout(3, 2));

        add(dateLabel);
        add(dateTextField);
        add(customerNameLabel);
        add(customerNameTextField);
        add(createInvoiceButton);
        add(cancelInvoiceButton);

        pack();
    }

    
    public JTextField getDateTextField() {
        return dateTextField;
    }

    public JTextField getCustomerNameTextField() {
        return customerNameTextField;
    }

}

