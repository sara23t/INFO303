package domain;

/**
 *
 * @author SaraTaha
 */
/**
 * The SaleItem class represents the item information within a sale.
 */
public class SaleItem {

    private String productId;
    private double quantity;
    private double price;

    /**
     * Sets the price of the product.
     *
     * @param price
     */
    public void setPrice(double price) {
        this.price = price;
    }

    /**
     * Sets the id of the product.
     *
     * @param productId
     */
    public void setProductId(String productId) {
        this.productId = productId;
    }

    /**
     * * Sets the quantity of the product.
     *
     * @param quantity
     */
    public void setQuantity(double quantity) {
        this.quantity = quantity;
    }

    /**
     * Gets the quantity of the product.
     *
     * @return The quantity of the product.
     */
    public double getQuantity() {
        return quantity;
    }

    /**
     * Gets the price of the product.
     *
     * @return The price of the product.
     */
    public double getPrice() {
        return price;
    }

    /**
     * Gets the id of the product.
     *
     * @return The id of the product.
     */
    public String getProductId() {
        return productId;
    }

    /**
     * return a string representation of the SaleItem object, with its
     * attributes.
     *
     * @return formatted SaleItem details.
     */
    @Override
    public String toString() {
        return "SaleItem{" + "productId=" + productId + ", quantity=" + quantity + ", price=" + price + '}';
    }

}
