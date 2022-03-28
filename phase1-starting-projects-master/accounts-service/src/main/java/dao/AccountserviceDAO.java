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

	//private static final Map<String, Customer> itemsById = new TreeMap<>();
	private static final Map<String, Customer> itemsById = new HashMap<>();

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
	
        //public Collection<Customer> getCustomer() {
		//return itemsById.value();
	//}



	public Customer delete(String id) {
		return itemsById.remove(id);
	}

	/**
	 * Checks if a Customer exists.*/
	 
	public boolean exists(String id) {
		return itemsById.containsKey(id);
	}

	



}
