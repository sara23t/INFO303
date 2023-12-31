package dao;

import com.google.common.collect.HashMultimap;
import com.google.common.collect.Multimap;
import domain.Customer;
import domain.Sale;
import domain.Summary;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

/**
 * @author Sara Taha
 *
 */
/**
 * The SalesDAO class is responsible for handling data operations of the sale,
 * including data access and processing
 */
public class SalesDAO {

    //declares a static Hashmap saleById for storing Sales by its id
    private static final Map<String, Sale> saleById = new HashMap<>();

    //declares a static Multimap saleByCustomerid that is linked to customer id.
    private static final Multimap<String, Sale> saleByCustomerID = HashMultimap.create();

    /**
     * Adds a sale to the system by customer.
     *
     * @param sale the sale object to be added to the system.
     */
    public void addSale(Sale sale) {
        saleById.put(sale.getId(), sale);
        saleByCustomerID.put(sale.getCustomer().getId(), sale);

    }

    /**
     * Delete a sale from the system by customer.
     *
     * @param id id The unique item to be deleted from the sale.
     */
    public void delete(String id) {
        Sale sale;
        sale = saleById.get(id);
        sale = saleById.remove(sale.getId());
        saleByCustomerID.remove(sale.getCustomer().getId(), sale);

    }

    /**
     * Check if the sale with the given id exists in the system.
     *
     * @param id the id of the specific sale to check for existence.
     *
     * @return the sale with the specified id if exists; otherwise, return
     * false.
     */
    public boolean exists(String id) {
        return saleById.containsKey(id);
    }

    /**
     * Check if the customer with the given id exists in the system.
     *
     * @param customerid the id of the customer to check for existence.
     *
     * @return the sale associated with the specific customer id if it exists;
     * otherwise, return false.
     */
    public boolean CustomerExists(String customerid) {
        return saleByCustomerID.containsKey(customerid);
    }

    /**
     * Get collection of all sales in the system.
     *
     * @return all the sales or null if no sales exist in the system.
     */
    public Collection<Sale> getSales() {
        return new ArrayList<>(saleById.values());
    }

    /**
     * Get a sale by its id from the system.
     *
     * @param id the id of the sale
     * @return the specific Sale associated with its ID or null if not found.
     */
    public Sale getSaleByid(String id) {
        return saleById.get(id);
    }

    /**
     * Get all sales associated with a specific customer id.
     *
     * @param id The customer id for obtaining all sales linked to it.
     *
     * @return all sales linked to the customer id, or null if none are found.
     */
    public Collection<Sale> getSalesByCustomerid(String id) {
        return saleByCustomerID.get(id);
    }

    /**
     * Get the summary of the sales linked to the customer ID.
     *
     * @param customerId the customer ID for obtaining all the sales information
     * for the summary.
     *
     * @return the summary of sales information.
     */
    public Summary getSummaryByCustomerId(String customerId) {

        //new instance of Summary class , assign it to summary variable
        Summary summary = new Summary();

        // Get a collection of sales linked to a specific customer ID
        //store them in the salebycustomer variable for further analysis.
        Collection<Sale> salebycustomer = getSalesByCustomerid(customerId);

        // set the number of sales in the 'summary' class for the specific customer.
        summary.setnumberOfSales(salebycustomer.size());
        // Initialize a variable 'x' to track the total payment
        double x = 0;

        //Iterate through each sale in the salebycustomer collection, for a particular customer.
        for (Sale s : salebycustomer) {

            // Store the total payment for the current sale of the customer in variable 'x'.
            x += s.getTotals().getTotalPayment();

        }
        // set the totalpayment to value of x
        summary.settotalPayment(x);

    //Classify customers into two groups based on their total payment.
        if (summary.gettotalPayment() > 5000) {
            summary.setGroup("VIP Customers");

        } else {
            summary.setGroup("Regular Customers");
        }

        //return the overall summary sale information for the customer, including the assigned group.
        return summary;

    }

}
