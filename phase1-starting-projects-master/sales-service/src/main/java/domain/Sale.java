package domain;

import java.util.Collection;
import java.util.ArrayList;

/**
 *
 * @author Sara Taha
 */
public class Sale {

    private String id;
    private String saleDate;

    private Customer customer;
    private Collection<SaleItem> items;
    private Totals totals;

    public Sale(){}
    @Override
    public String toString() {
        return "Sale{" + "id=" + id + ", saleDate=" + saleDate + ", customer=" + customer + ", items=" + items + ", totals=" + totals + '}';
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getSaleDate() {
        return saleDate;
    }

    public void setSaleDate(String saleDate) {
        this.saleDate = saleDate;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public Collection<SaleItem> getItems() {
        return items;
    }

    public void setItems(Collection<SaleItem> items) {
        this.items = items;
    }

    public Totals getTotals() {
        return totals;
    }

    public void setTotals(Totals totals) {
        this.totals = totals;
    }
}

    