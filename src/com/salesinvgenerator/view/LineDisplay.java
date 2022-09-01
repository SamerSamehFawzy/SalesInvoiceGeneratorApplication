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
public class LineDisplay extends JDialog {
    
    private final JLabel itemNameLabel;
    private final JTextField itemNameTextField;
    private final JLabel itemPriceLabel;
    private final JTextField itemPriceTextField;
    private final JLabel countLabel;
    private final JTextField countTextField;
    private final JButton createLineButton;
    private final JButton cancelLineButton;

    public LineDisplay(SalesInvFrame invFrame) {
        itemNameLabel = new JLabel("Item Name: ");
        itemNameTextField = new JTextField(15);
        itemPriceLabel = new JLabel("Item Price: ");
        itemPriceTextField = new JTextField(15);
        countLabel = new JLabel("Count: ");
        countTextField = new JTextField(15);

        createLineButton = new JButton("Create");
        cancelLineButton = new JButton("Cancel");

        createLineButton.setActionCommand("Create Line");
        cancelLineButton.setActionCommand("Cancel Line");

        createLineButton.addActionListener(invFrame.getController());
        cancelLineButton.addActionListener(invFrame.getController());

        setLayout(new GridLayout(4, 2));

        add(itemNameLabel);
        add(itemNameTextField);
        add(itemPriceLabel);
        add(itemPriceTextField);
        add(countLabel);
        add(countTextField);
        add(createLineButton);
        add(cancelLineButton);

        pack();
    }

   
    public JTextField getItemNameTextField() {
        return itemNameTextField;
    }

    public JTextField getItemPriceTextField() {
        return itemPriceTextField;
    }

    public JTextField getCountTextField() {
        return countTextField;
    }

   

}


