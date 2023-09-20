package domain;

import java.util.Collection;
import java.util.ArrayList;

/**
 *
 * @author Sara Taha Sept 2023
 */
/**
 * The Sale class represents a transaction and the Sale within a business
 * system.
 */
public class Sale {

    private String id;
    private String saleDate;

    private Customer customer; //Holds the reference to a Customer object.
    private Collection<SaleItem> items; //Stores the reference to a collection of SaleItem objects.
    private Totals totals; //a reference to the Totals object, which holds information about the overall total for the sale

    public Sale() {
    }

    /**
     * Sets the id of the sale
     *
     * @param id
     */
    public void setId(String id) {
        this.id = id;
    }

    /**
     * Sets the total object for the sale, which will contain information about
     * the sale total.
     *
     * @param totals
     */
    public void setTotals(Totals totals) {
        this.totals = totals;
    }

    /**
     * Sets the collection of sale items for the sale.
     *
     * @param items
     */
    public void setItems(Collection<SaleItem> items) {
        this.items = items;
    }

    /**
     * Sets the sale date of a specific sale.
     *
     * @param saleDate
     */
    public void setSaleDate(String saleDate) {
        this.saleDate = saleDate;
    }

    /**
     * Sets the customer for the sale.
     *
     * @param customer holds information for the specific customer associated
     * with the sale.
     */
    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    /**
     * get the total information for the sale.
     *
     * @return the total information about the sale
     */
    public Totals getTotals() {
        return totals;
    }

    public Collection<SaleItem> getItems() {
        return items;
    }

    /**
     * Retrieve the Id of the Sale.
     *
     * @return The Sale's Id.
     */
    public String getId() {
        return id;
    }

    /**
     * Gets the sale date.
     *
     * @return The date of the sale.
     */

    public String getSaleDate() {
        return saleDate;
    }

    /**
     * Gets the customer information for the sale.
     *
     * @return The customer object that references to the sale.
     */
    public Customer getCustomer() {
        return customer;
    }

    @Override
    public String toString() {
        return "Sale{" + "id=" + id + ", saleDate=" + saleDate + ", customer=" + customer + ", items=" + items + ", totals=" + totals + '}';
    }

}
