/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package SalesInvoice.View;
import java.awt.GridLayout;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JTextField;
/**
 *
 * @author Samer.Sameh
 */
public class ItemData extends JDialog{
    
    private final JTextField itemNameField;
    private final JTextField itemQtyField;
    private final JTextField itemPriceField;
    private final JLabel itemNameLabel;
    private final JLabel itemCountLabel;
    private final JLabel itemPriceLabel;
    private final JButton okButton;
    private final JButton cancelButton;
      public ItemData(InvFrame frame) {
        itemNameField = new JTextField(20);
        itemNameLabel = new JLabel("Item Name");
        
        itemQtyField = new JTextField(20);
        itemCountLabel = new JLabel("Item Count");
        
        itemPriceField = new JTextField(20);
        itemPriceLabel = new JLabel("Item Price");
        
        okButton = new JButton("OK");
        cancelButton = new JButton("Cancel");
        
        okButton.setActionCommand("createOK");
        cancelButton.setActionCommand("createLineCancel");
        
        okButton.addActionListener(frame.getController());
        cancelButton.addActionListener(frame.getController());
        setLayout(new GridLayout(4, 2));
        
        add(itemNameLabel);
        add(itemNameField);
        add(itemCountLabel);
        add(itemQtyField);
        add(itemPriceLabel);
        add(itemPriceField);
        add(okButton);
        add(cancelButton);
        
        pack();
    }

    public JTextField getItemNameField() {
        return itemNameField;
    }

    public JTextField getItemQtyField() {
        return itemQtyField;
    }

    public JTextField getItemPriceField() {
        return itemPriceField;
    }
    
}
