package dao;

import com.google.common.collect.Multimap;
import com.google.common.collect.TreeMultimap;
import domain.Customer;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;
import java.util.stream.Collectors;

public class AccountserviceDAO {

    private static final Map<String, Customer> itemsById = new TreeMap<>();

    public AccountserviceDAO() {
        /*
		 * Some dummy data for testing
         */
        if (itemsById.isEmpty()) {
            Customer c1 = new Customer("DH8832", "Dodgy Doohicky", "A doohicky t..", "Doohickies", "dsds", "dssd");
            addCustomer(c1);
        }
    }

    public final Customer addCustomer(Customer newCustomer) {

        itemsById.put(newCustomer.getId(), newCustomer);
        return newCustomer;
    }

    public Customer getCustomerById(String id) {
        return itemsById.get(id);
    }

    //get all customers account//
    public Collection<Customer> getCustomer() {
        return new ArrayList<>(itemsById.values());
    }

    public Customer delete(String id) {
        return itemsById.remove(id);
    }

    public Customer changeGroup(String id, String group) {
        Customer customer = itemsById.get(id);
        customer.setgroup(group);
        return customer;
    }


/**
 * Checks if a Customer exists.
 */

public boolean exists(String id) {
		return itemsById.containsKey(id);
	}

}
