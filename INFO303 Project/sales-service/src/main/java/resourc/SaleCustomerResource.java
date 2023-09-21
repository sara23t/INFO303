package resourc;

import dao.SalesDAO;
import io.jooby.Jooby;
import io.jooby.StatusCode;

/**
 *
 * @author sarataha
 */
/**
 * The SalesCustomerResource class represents the resources for managing sales
 * operations for a specific customer using the Jooby framework.
 */
public class SaleCustomerResource extends Jooby {

    //The SalesCustomerResource constructor class that takes a SalesDAO instance as an argument or parameter.
    public SaleCustomerResource(SalesDAO dao) {

        //Defines routes for fetching sales data for a specific customer within the "/api/sales/customer/{id} endpoint.
        //it is responsible for managing sales data operations for a specfice customer.
        path("/api/sales/customer/{id}", () -> {

            get("", ctx -> {
                String id = ctx.path("id").value(); //Extracting the value of the 'id' parameter from the request for further processing
                // if a customer with the given 'id' exists in the database 
                // By using the 'CustomerExists' method, then get all sales associated with this customer id.
                //otherwise, return a 'NOT_FOUND' status code.
                if (dao.CustomerExists(id)) {
                    return dao.getSalesByCustomerid(id);
                } else {
                    return ctx.send(StatusCode.NOT_FOUND);
                }

            });
        });

         // define the route for accessing the summary of the customer's sales information
        path("/api/sales/customer/{id}/summary", () -> {

            get("", ctx -> {
             
                String id = ctx.path("id").value(); //Extracting the value of the 'id' parameter from the request for further processing.

                if (dao.CustomerExists(id)) {
                    return dao.getSummaryByCustomerId(id);
                } else {
                    return ctx.send(StatusCode.NOT_FOUND);
                }

            });
        });
    }

}
