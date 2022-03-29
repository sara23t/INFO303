package domain;

import java.util.Collection;
import java.util.ArrayList;

/**
 *
 * @author Sara Taha
 */
public class Sale {

    private String id;
    private String saledate;

    private Customer customer;
    private Collection<SaleItem> items;
    private Totals totals;

    public Sale(String id, String saledate, Customer customer, Collection<SaleItem> items, Totals total) {
        this.id = id;
        this.saledate = saledate;
        this.customer = customer;
        this.totals = total;
        this.items = items;
    }

    public String getid() {
        return id;
    }

    public String getDate() {
        return saledate;
    }

    public Customer getCustomer() {
        return this.customer;
    }

    public Collection<SaleItem> getsaleitem() {
        return items;
    }
  public void setsaleitem(Collection<SaleItem> items) {
        this.items = items;
    }
    public Totals getTotals() {
        return totals;
    }

    public void setid(String id) {
        this.id = id;
    }

    public void setSaleDate(String saledate) {
        this.saledate = saledate;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

  

    public void setTotals(Totals total) {
        this.totals = total;
    }

    @Override
    public String toString() {
        return  id  + saledate + customer  + items + totals;

    }
}
