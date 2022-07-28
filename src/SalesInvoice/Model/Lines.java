/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package SalesInvoice.Model;

/**
 *
 * @author Samer.Sameh
 */
public class Lines {
   
    private String product;
    private double Price;
    private int Qty;
    private Invoice invoice;
    
    public Lines() {
    }

    

    public Lines( String product, double Price, int Qty, Invoice invoice) {
        
        this.product = product;
        this.Price = Price;
        this.Qty = Qty;
        this.invoice = invoice;
    }

    public double getLineTotalPrice(){
    return Price*Qty ;
    }
    
    public int getQty() {
        return Qty;
    }

    public void setQty(int Qty) {
        this.Qty = Qty;
    }

   
    public String getProduct() {
        return product;
    }

    public void setProduct(String product) {
        this.product = product;
    }

    public double getPrice() {
        return Price;
    }

    public void setPrice(double Price) {
        this.Price = Price;
    }
    

    @Override
    public String toString() {
        return "Lines{" + "SO=" + invoice.getSonumber() + ", product=" + product + ", Price=" + Price + ", Qty=" + Qty + '}';
    }

    public Invoice getInvoice() {
        return invoice;
    }
    
    public String  getAsCsv(){
 
      return invoice.getSonumber() + "," + product + "," + Price + "," + Qty;
      
      }
    
}
