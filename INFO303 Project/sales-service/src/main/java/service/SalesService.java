package service;

import dao.SalesDAO;
import java.io.IOException;
import io.jooby.Jooby;
import io.jooby.OpenAPIModule;
import io.jooby.ServerOptions;
import io.jooby.json.GsonModule;
import resourc.SaleCustomerResource;
import resourc.SalesResource;

/**
 * @author Sara Taha
 */
/**
 * The SalesService class is responsible for setting up the connection and
 * running the system using the Jooby framework.
 */
public class SalesService extends Jooby {

    //Constructor class
    public SalesService() {

        SalesDAO saledao = new SalesDAO(); // an instance of the SalesDAO class to manage sales data.
        setServerOptions(new ServerOptions().setPort(8081)); // Set server port to 8081.

        install(new GsonModule()); //installs the GsonModule

        mount(new SaleCustomerResource(saledao)); // Mounting SaleCustomerResource with the SaleDAO instance

        mount(new SalesResource(saledao)); // Mounting SalesResource with the SaleDAO instance
        install(new OpenAPIModule()); // Install the module of openAPI to enable the functionality of OpenAI to work

        assets("/openapi.json", "sales.json"); //search for the openAPI json file for "sales" and renames it to "sales.json".
        assets("/openapi.yaml", "sales.yaml"); //search for the openAPI json file for "sales" and renames it to "sales.yaml"

        //Redirect to the Swagger page whenever a request is made.
        get("/", ctx -> ctx.sendRedirect("/swagger"));
    }
    
    // main method that starts and runs the service.
    public static void main(String[] args) throws IOException {
        System.out.println("\n\n****** Sales Service ******\n\n");
        new SalesService().start();
    }

}
