package domain;

/**
 *
 * @author Sara Taha
 */
public final class Totals {

    private double totalPrice;
    private double totalTax;
    private double totalPayment;

    public Totals() {
    }

    public void setTotalPrice(double totalPrice) {
        this.totalPrice = totalPrice;
    }

    public void setTotalTax(double totalTax) {
        this.totalTax = totalTax;
    }

    public void setTotalPayment(double totalPayment) {
        this.totalPayment = totalPayment;
    }

    public double getTotalTax() {
        return totalTax;
    }

    public double getTotalPrice() {
        return totalPrice;
    }

    public double getTotalPayment() {
        return totalPayment;
    }

    @Override
    public String toString() {
        return "Totals{" + "totalPrice=" + totalPrice + ", totalTax=" + totalTax + ", totalPayment=" + totalPayment + '}';
    }

}
