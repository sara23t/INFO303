package graphql;

import com.fasterxml.jackson.databind.ObjectMapper;
import dao.AccountserviceDAO;
import domain.Customer;
import graphql.schema.DataFetcher;
import graphql.schema.DataFetchingEnvironment;
import java.math.BigDecimal;
import java.util.Map;



public class AccountFetcher {

    private final AccountserviceDAO dao;

    public AccountFetcher(AccountserviceDAO dao) {
        this.dao = dao;
    }

    public DataFetcher getCustomerByIdFetcher() {
        return (DataFetchingEnvironment dfe) -> {
            String id = dfe.getArgument("id");
            return dao.getCustomerById(id);
        };
    }
    public DataFetcher getCreateCustomerFetcher() {
    return (DataFetchingEnvironment dfe) -> {
        Map map = dfe.getArgument("customer");
        ObjectMapper mapper = new ObjectMapper();
        Customer newCustomer = mapper.convertValue(map, Customer.class);
        return dao.addCustomer(newCustomer);
    };
}

    

   // public DataFetcher getCustomerFetcher() {
    //    return (DataFetchingEnvironment dfe) -> {
    //        return dao.getCustomer();
      //  };
   // }
//
    public DataFetcher getDeleteCustomerFetcher() {
        return (DataFetchingEnvironment dfe) -> {
            String id = dfe.getArgument("id");
            return dao.delete(id);
        };
    }

}


