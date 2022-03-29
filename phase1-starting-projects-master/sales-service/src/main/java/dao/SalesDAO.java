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

public class SalesDAO {

    private static final Map<String, Sale> saleById = new HashMap<>();
    private static final Multimap<String, Sale> saleByCustomerID = HashMultimap.create();

    public SalesDAO() {
        if (saleById.isEmpty()) {
            
        }
    }

    //addtosale by customer 
    public void addSale(Sale sale) {
        saleById.put(sale.getId(), sale);
        saleByCustomerID.put(sale.getCustomer().getId(), sale);

    }

    public Collection<Sale> getSales() {
        return new ArrayList<>(saleById.values());
    }

    public Sale getSaleByid(String id) {
        return saleById.get(id);
    }

   //delete by customerid
    public void delete(String id) {
        saleById.remove(saleById.get(id)).getId();
        saleByCustomerID.remove(saleById.get(id).getCustomer().getId(), saleById.get(id));
    }

    public boolean exists(String id) {
        return saleById.containsKey(id);
    }

    public boolean CustomerExists(String customerid) {
        return saleByCustomerID.containsKey(customerid);
    }

    public Collection<Sale> getSalesByCustomerid(String id) {
            return saleByCustomerID.get(id);
    }
    
    public Summary getSummaryByCustomerId(String customerId){
        Summary summary = new Summary();
        
        Collection<Sale> salebycustomer = getSalesByCustomerid(customerId);
      //number of sales is the lenght of the sale for customer
        // total payment is the sum all of the collection
          summary.setnumberOfSales(salebycustomer.size());
         double x = 0;
          for(Sale s: salebycustomer){
            
             x += s.getTotals().getTotalPayment();
            
          }
          summary.settotalPayment(x);
        if(summary.gettotalPayment() > 5000){
             summary.setGroup("VIP Customers");

        } else {
           summary.setGroup("Regular Customers");
        }
              
        return summary;
        
    }

}
