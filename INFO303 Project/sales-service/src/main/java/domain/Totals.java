package domain;


/**
 *
 * @author Sara Taha
 */
public final class Totals {
    private double totalPrice;
    private double totalTax;
    private double totalPayment;
    public Totals(){}
    public double getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(double totalPrice) {
        this.totalPrice = totalPrice;
    }

    public double getTotalTax() {
        return totalTax;
    }

    public void setTotalTax(double totalTax) {
        this.totalTax = totalTax;
    }

    public double getTotalPayment() {
        return totalPayment;
    }

    public void setTotalPayment(double totalPayment) {
        this.totalPayment = totalPayment;
    }

    @Override
    public String toString() {
        return "Totals{" + "totalPrice=" + totalPrice + ", totalTax=" + totalTax + ", totalPayment=" + totalPayment + '}';
    }
   

   
}