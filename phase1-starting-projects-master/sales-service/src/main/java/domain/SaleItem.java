package domain;

/**
 *
 * @author SaraTaha
 */
public class SaleItem {
    private String productid;
    private double quantity;
    private double price;
    
    
    public SaleItem(String productid, double quantity, double price){
        this.productid = productid;
        this.quantity = quantity;
        this.price = price;
    }

    public String getId() {
        return productid;
    }

    public double getquantity() {
        return quantity;
    }

    public double getprice() {
        return price;
    }

    public void setid(String productid) {
        this.productid = productid;
    }

    public void setquantity(double quantity) {
        this.quantity = quantity;
    }

    public void setprice(double price) {
        this.price = price;
    }
    
    public String toString(){
        return price + quantity + productid;
    }
}