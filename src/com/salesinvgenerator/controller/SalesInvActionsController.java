package com.salesinvgenerator.controller;

import com.salesinvgenerator.model.InvoiceHeader;
import com.salesinvgenerator.model.InvoiceHeaderTable;
import com.salesinvgenerator.model.InvoiceLine;
import com.salesinvgenerator.model.InvoiceLineTable;
import com.salesinvgenerator.view.InvoiceDisplay;
import com.salesinvgenerator.view.LineDisplay;
import com.salesinvgenerator.view.SalesInvFrame;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JFileChooser;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;


/**
 *
 * @author Monica.George
 */
public class SalesInvActionsController implements ActionListener ,ListSelectionListener {
    
    private final SalesInvFrame invFrame;
    private InvoiceDisplay invoiceDisplay;
    private LineDisplay lineDisplay;
    public SalesInvActionsController(SalesInvFrame frame) { this.invFrame = frame;}

    @Override
    public void actionPerformed(ActionEvent e) {
       String actionValue = e.getActionCommand();
        switch (actionValue) {
            case "Load File":
               loadFile();
                System.out.println("LoadFile");
                break;

            case "Save File":
                saveFile();
                System.out.println("SaveFile");
                break;

            case "New Invoice":
                createNewInvoice();
                System.out.println("NewInvoice");
                break;

            case "Delete Invoice":
                deleteInvoice();
                System.out.println("deleteinvoice");
                break;

            case "New":
                createNewItem();
                System.out.println("NewItem");
                break;

            case "Delete":
                deleteItem();
                System.out.println("deleteitem");
                break;

          case "Create Invoice":
                createInvoice();
                break;

            case "Cancel Invoice":
                cancelInvoice();
                break;

            case "Create Line":
                createLine();
                break;

            case "Cancel Line":
                cancelLine();
                break; 
        }
    }

    
     @Override
    public void valueChanged(ListSelectionEvent e) {
        int row = invFrame.getInvoiceTable().getSelectedRow();
        if (row != -1) {
            InvoiceHeader currentInvoiceData = invFrame.getInvs().get(row);
            System.out.println("row =" + row);
            invFrame.getInvoiceNumberValue().setText("" + currentInvoiceData.getNumber());
            invFrame.getInvoiceDateValue().setText(currentInvoiceData.getDate());
            invFrame.getCustomerNameValue().setText(currentInvoiceData.getCustomerName());
            invFrame.getInvoiceTotalValue().setText("" + currentInvoiceData.getInvoiceTotal());
            InvoiceLineTable lineTableModel = new InvoiceLineTable(currentInvoiceData.getLines());
            invFrame.getLineTable().setModel(lineTableModel);
            lineTableModel.fireTableDataChanged();
        }
    }
    private void loadFile() {
        //throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    JFileChooser fileChooser = new JFileChooser();
        try {
            int display = fileChooser.showOpenDialog(invFrame);
            if (display == JFileChooser.APPROVE_OPTION) {
                File headerFile = fileChooser.getSelectedFile();
                Path invoiceHeaderPath = Paths.get(headerFile.getAbsolutePath());
                List<String> headerLines = Files.readAllLines(invoiceHeaderPath);
                ArrayList<InvoiceHeader> invAll = new ArrayList<>();
                for (String invoiceHeaderLine : headerLines) {
                    String[] invData = invoiceHeaderLine.split(",");
                    int invoiceNumber = Integer.parseInt(invData[0]);
                    String invoiceDate = invData[1];
                    String invoiceCustomer = invData[2];

                    InvoiceHeader invoice = new InvoiceHeader(invoiceNumber, invoiceDate, invoiceCustomer);
                    invAll.add(invoice);
                }
                System.out.println("Header File");
                display = fileChooser.showOpenDialog(invFrame);
                if (display == JFileChooser.APPROVE_OPTION) {
                    File lineFile = fileChooser.getSelectedFile();
                    Path lineHeaderPath = Paths.get(lineFile.getAbsolutePath());
                    List<String> lineFileLines = Files.readAllLines(lineHeaderPath);
                    for (String lineFileLine : lineFileLines) {
                        String[] lineData = lineFileLine.split(",");
                        int num = Integer.parseInt(lineData[0]);
                        String item = lineData[1];
                        double price = Double.parseDouble(lineData[2]);
                        int count = Integer.parseInt(lineData[3]);
                        InvoiceHeader inv = null;
                        for (InvoiceHeader invoice : invAll) {
                            if (num == invoice.getNumber()) {
                                inv = invoice;
                                break;
                            }
                        }
                        InvoiceLine newLine = new InvoiceLine(item, price, count, inv);
                        inv.getLines().add(newLine);
                    }
                    System.out.println("Line File");

                }
                invFrame.setInvs(invAll);
                InvoiceHeaderTable invTableModel = new InvoiceHeaderTable(invAll);
                invFrame.setInvoicesTableModel(invTableModel);
                invFrame.getInvoiceTable().setModel(invTableModel);
                invFrame.getInvoicesTableModel().fireTableDataChanged();
            }
        } catch (IOException exception) {
            exception.printStackTrace();
        }

        System.out.println("Files Loaded Successfully");
    }
    

    private void saveFile() {
      //  throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
        JFileChooser fileChooser = new JFileChooser();
        ArrayList<InvoiceHeader> saveInvs = invFrame.getInvs();
        ArrayList<InvoiceLine> saveLines = null;
        try {
            int result = fileChooser.showSaveDialog(invFrame);
            if (result == JFileChooser.APPROVE_OPTION) {
                File headerFile = fileChooser.getSelectedFile();
                FileWriter headerWriter = new FileWriter(headerFile);
                for (InvoiceHeader saveInv : saveInvs) {
                    String invoiceNumber = "" + saveInv.getNumber();
                    String invoiceDate = saveInv.getDate();
                    String customerName = saveInv.getCustomerName();
                    headerWriter.write(invoiceNumber + "," + invoiceDate + "," + customerName + "\n");
                    headerWriter.flush();
                }
                headerWriter.close();
                result = fileChooser.showSaveDialog(invFrame);
                if (result == JFileChooser.APPROVE_OPTION) {
                    File lineFile = fileChooser.getSelectedFile();
                    FileWriter lineWriter = new FileWriter(lineFile);
                    for (InvoiceHeader saveInvoice : saveInvs) {
                        saveLines = saveInvoice.getLines();
                        for (InvoiceLine saveLine : saveLines) {
                            String invoiceNumber = "" + saveLine.getInvoice().getNumber();
                            String itemName = saveLine.getItem();
                            String itemPrice = "" + saveLine.getPrice();
                            String count = "" + saveLine.getCount();
                            lineWriter.write(invoiceNumber + "," + itemName + "," + itemPrice + "," + count + "\n");
                            lineWriter.flush();
                        }
                    }
                    lineWriter.close();
                }
            }
        } catch (IOException exception) {
            exception.printStackTrace();
        }
        System.out.println("Files Saved Successfully");
      
    }

    private void createNewInvoice() {
        //throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
        invoiceDisplay = new InvoiceDisplay(invFrame);
        invoiceDisplay.setVisible(true);
        System.out.println("Pressing On Created New Invoice and the window opened");
    }

    private void deleteInvoice() {
        //throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
        int row = invFrame.getInvoiceTable().getSelectedRow();
        if (row != -1) {
            invFrame.getInvs().remove(row);
            for (int i = 0; i < invFrame.getInvs().size(); i++) {
                invFrame.getInvs().get(i).setNumber(i + 1);
            }
            invFrame.getInvoicesTableModel().fireTableDataChanged();
        }
        System.out.println("Pressing on deleted Invoice and delete it");
    }

    private void createNewItem() {
        //throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
        lineDisplay = new LineDisplay(invFrame);
        lineDisplay.setVisible(true);
        System.out.println("Pressing On New and the window opened");
    }

    private void deleteItem() {
        //throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
        int row = invFrame.getLineTable().getSelectedRow();
        if (row != -1) {
            InvoiceLineTable lineTableModel = (InvoiceLineTable) invFrame.getLineTable().getModel();
            lineTableModel.getLineData().remove(row);
            lineTableModel.fireTableDataChanged();
            invFrame.getInvoicesTableModel().fireTableDataChanged();
        }
        System.out.println("Deleting Item Successfully");
    }

    private void createInvoice() {
        //throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
        String dateText = invoiceDisplay.getDateTextField().getText();
        String customerNameText = invoiceDisplay.getCustomerNameTextField().getText();
        int invoiceNumber = invFrame.getNextInvoiceNumber();

        InvoiceHeader createNewInvoice = new InvoiceHeader(invoiceNumber, dateText, customerNameText);
        invFrame.getInvs().add(createNewInvoice);
        invFrame.getInvoicesTableModel().fireTableDataChanged();

        invoiceDisplay.setVisible(false);
        invoiceDisplay.dispose();
        invoiceDisplay = null;
        System.out.println("Creating new invoice Successfully");
    }

    private void cancelInvoice() {
       //throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
        invoiceDisplay.setVisible(false);
        invoiceDisplay.dispose();
        invoiceDisplay = null;
        System.out.println("cancel btn and the window closed");
    }

   private void createLine() {
        String itemName = lineDisplay.getItemNameTextField().getText();
        double itemPrice = Double.parseDouble(lineDisplay.getItemPriceTextField().getText());
        int itemCount = Integer.parseInt(lineDisplay.getCountTextField().getText());

        int selectedInvoiceRow = invFrame.getInvoiceTable().getSelectedRow();
        if (selectedInvoiceRow != -1) {
            InvoiceHeader invoice = invFrame.getInvs().get(selectedInvoiceRow);
            InvoiceLine createNewLine = new InvoiceLine(itemName, itemPrice, itemCount, invoice);
            invoice.getLines().add(createNewLine);

            InvoiceLineTable lineTableModel = (InvoiceLineTable) invFrame.getLineTable().getModel();
            lineTableModel.fireTableDataChanged();
            invFrame.getInvoicesTableModel().fireTableDataChanged();
            invFrame.getInvoiceTotalValue().setText("" + invoice.getInvoiceTotal());
        }

        lineDisplay.setVisible(false);
        lineDisplay.dispose();
        lineDisplay = null;
        System.out.println("Creating new line Successfully");
    }

    private void cancelLine() {
        //throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
        lineDisplay.setVisible(false);
        lineDisplay.dispose();
        lineDisplay = null;  
        System.out.println("cancel btn and the window closed");
    }

   
}

    

