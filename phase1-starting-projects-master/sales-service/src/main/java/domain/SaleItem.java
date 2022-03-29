package domain;

/**
 *
 * @author SaraTaha
 */
public class SaleItem {
    private String productId;
    private double quantity;
    private double price;

    @Override
    public String toString() {
        return "SaleItem{" + "productId=" + productId + ", quantity=" + quantity + ", price=" + price + '}';
    }

    public String getProductId() {
        return productId;
    }

    public void setProductId(String productId) {
        this.productId = productId;
    }

    public double getQuantity() {
        return quantity;
    }

    public void setQuantity(double quantity) {
        this.quantity = quantity;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }


}