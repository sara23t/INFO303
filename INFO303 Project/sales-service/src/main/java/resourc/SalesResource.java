package resourc;

import dao.SalesDAO;
import domain.Sale;
import io.jooby.Jooby;
import io.jooby.StatusCode;

/**
 *
 * @author sarataha
 */
/**
 * The SalesResource class responsible for managing sales operations using the
 * jooby framework.
 */
public class SalesResource extends Jooby {

    //The SalesResource constructor class that takes a SalesDAO instance as an argument or parameter.
    public SalesResource(SalesDAO dao) {

        //Defines routes for fetching sales data by ID within the "/api/sales" endpoint
        //it is responsible for managing sales data operations.
        path("/api/sales", () -> {
            //Handles incoming GET requests with the a specfic 'id' parameter to fetch the data

            get("/{id}", ctx -> {

                String id = ctx.path("id").value(); //Extracting the value of the 'id' parameter from the request for further processing

                //If the sale exists in the system, it retrieves it and then returns the sale data; 
                //otherwise, it will return a "NOT_FOUND" status.
                if (dao.exists(id)) {
                    return dao.getSaleByid(id);
                } else {
                    return ctx.send(StatusCode.NOT_FOUND);
                }

            });

            //Handle the delete request for a sale with its specified id.
            delete("/{id}", ctx -> {
                String id = ctx.path("id").value(); //Extracting the value of the 'id' parameter from the request for further processing

                //If the sale exists in the system, it will delete it and then return a 'No Content' status; 
                //otherwise, it will return a "NOT_FOUND" status.
                if (dao.exists(id)) {
                    dao.delete(id);
                    return ctx.send(StatusCode.NO_CONTENT);
                } else {
                    return ctx.send(StatusCode.NOT_FOUND);
                }
            });

            //This route handles the root path of a GET request,
            //which gets all of the sales from the DAO and returns it as a response
            get("", ctx -> {
                return dao.getSales();
            });

            //define a route for handling POST requests at the specified URL path.
            post("", ctx -> {
                Sale sale = ctx.body(Sale.class); // Fetch the request body and convert it to a Sale object

                //if the sale with given id exist in DAO
                //If it exists, return an http status that inditcate that the request is unprocessable.
                //Otherwise, add the sale to the database and send a response that the URL has been created.
                // send the URI of the new item via the "location" header of the response
                if (dao.exists(sale.getId())) {

                    return ctx.send(StatusCode.UNPROCESSABLE_ENTITY);

                } else {

                    dao.addSale(sale);
                    return ctx
                            .setResponseHeader("location", ctx.getRequestURL() + "/product/" + sale.getId())
                            .send(StatusCode.CREATED);

                }

            });

        });

    }

}
