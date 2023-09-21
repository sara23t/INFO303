/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package domain;

/**
 *
 * @author sarataha
 */
/**
 * The Summary class represents information related to sales and its total
 * payment
 */
public class Summary {

    private int numberOfSales; //The 'numberOfSales'  stores the count of sales transactions.
    private double totalPayment; //The totalPayment  stores The total amount of payments.
    private String group; //Stores the group or category of the sales.

    public Summary(int numberOfSales, double totalPayment, String group) {
        this.group = group;
        this.numberOfSales = numberOfSales;
        this.totalPayment = totalPayment;
    }

    // Default constructor for the summary class.
    public Summary() {
    }

    /**
     * Sets the group for the sale.
     *
     * @param group.
     */
    public void setGroup(String group) {
        this.group = group;
    }

    /**
     * Sets the number of sales
     *
     * @param numberOfSales
     */
    public void setnumberOfSales(int numberOfSales) {
        this.numberOfSales = numberOfSales;
    }

    /**
     * Sets the total payment for the sale.
     *
     * @param totalPayment
     */
    public void settotalPayment(double totalPayment) {
        this.totalPayment = totalPayment;
    }

    /**
     * Gets the group that is associated with the sale.
     *
     * @return the group.
     */
    public String getGroup() {
        return group;
    }

    /**
     * Gets the number of sales.
     *
     * @return The number of sales
     */
    public int getnumberOfSales() {
        return numberOfSales;
    }

    /**
     * Gets the total payment of the sale.
     *
     * @return The total payment
     */
    public double gettotalPayment() {
        return totalPayment;
    }

    /**
     * return a string representation of the summary object, with its
     * attributes.
     *
     * @return formatted summary details.
     */
    @Override
    public String toString() {
        return totalPayment + numberOfSales + group;
    }

}
