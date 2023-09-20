package domain;

/**
 *
 * @author Sara Taha
 */
/**
 * The `Total` class represents the total payment for the sale.
 */
public final class Totals {

    private double totalPrice; // Stores the total price.
    private double totalTax; // Stores the total tax.
    private double totalPayment; // Stores the total payment.

    public Totals() {
    }

    /**
     * Sets the total price of the sale.
     *
     * @param totalPrice
     */
    public void setTotalPrice(double totalPrice) {
        this.totalPrice = totalPrice;
    }

    /**
     * Sets the total tax of the sale.
     *
     * @param totalTax
     */
    public void setTotalTax(double totalTax) {
        this.totalTax = totalTax;
    }

    /**
     * Sets the total payment of the sale.
     *
     * @param totalPayment
     */
    public void setTotalPayment(double totalPayment) {
        this.totalPayment = totalPayment;
    }

    /**
     * Gets the total tax that is associated with the sale.
     *
     * @return the total tax.
     */
    public double getTotalTax() {
        return totalTax;
    }

    /**
     * Gets the total price that is associated with the sale.
     *
     * @return the total price.
     */
    public double getTotalPrice() {
        return totalPrice;
    }

    /**
     * Gets the total payment that is associated with the sale.
     *
     * @return the total payment.
     */
    public double getTotalPayment() {
        return totalPayment;
    }

    @Override
    public String toString() {
        return "Totals{" + "totalPrice=" + totalPrice + ", totalTax=" + totalTax + ", totalPayment=" + totalPayment + '}';
    }

}
