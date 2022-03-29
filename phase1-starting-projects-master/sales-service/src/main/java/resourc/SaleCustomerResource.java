package resourc;

import dao.SalesDAO;
import io.jooby.Jooby;
import io.jooby.StatusCode;

//
public class SaleCustomerResource extends Jooby {

    public SaleCustomerResource(SalesDAO dao) {

        path("/api/sales/customer/{id}", () -> {

            get("", ctx -> {
                String id = ctx.path("id").value();

                if (dao.CustomerExists(id)) {
                    return dao.getSalesByCustomerid(id);
                } else {
                    return ctx.send(StatusCode.NOT_FOUND);
                }

            });
        });
        
         path("/api/sales/customer/{id}/summary", () -> {

            get("", ctx -> {
                String id = ctx.path("id").value();

                if (dao.CustomerExists(id)) {
                    return dao.getSummaryByCustomerId(id);
                } else {
                    return ctx.send(StatusCode.NOT_FOUND);
                }

            });
        });
    }

}
