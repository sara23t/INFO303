package service;

import dao.SalesDAO;
import java.io.IOException;
import io.jooby.Jooby;
import io.jooby.OpenAPIModule;
import io.jooby.ServerOptions;
import io.jooby.json.GsonModule;
import resourc.SaleCustomerResource;
import resourc.SalesResource;

public class SalesService extends Jooby {

	public SalesService() {

                SalesDAO saledao = new SalesDAO();
		setServerOptions(new ServerOptions().setPort(8081));

		install(new GsonModule());
		
                mount(new SaleCustomerResource(saledao));
		mount(new SalesResource(saledao));
                install(new OpenAPIModule());

		assets("/openapi.json", "sales.json");
		assets("/openapi.yaml", "sales.yaml");

		
		get("/", ctx -> ctx.sendRedirect("/swagger"));
	}

	public static void main(String[] args) throws IOException {
		System.out.println("\n\n****** Sales Service ******\n\n");
		new SalesService().start();
	}

}
