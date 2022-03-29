package resourc;

import dao.SalesDAO;
import domain.Sale;
import io.jooby.Jooby;
import io.jooby.StatusCode;

public class SalesResource extends Jooby {

    public SalesResource(SalesDAO dao) {

        path("/api/sales", () -> {

            get("/{id}", ctx -> {
                String id = ctx.path("id").value();

                if (dao.exists(id)) {
                    return dao.getSaleByid(id);
                } else {
                    return ctx.send(StatusCode.NOT_FOUND);
                }

            });

            delete("/{id}", ctx -> {
                String id = ctx.path("id").value();

                if (dao.exists(id)) {
                    dao.delete(id);
                    return ctx.send(StatusCode.NO_CONTENT);
                } else {
                    return ctx.send(StatusCode.NOT_FOUND);
                }
            });
            get("", ctx -> {
                return dao.getSales();
            });

            post("", ctx -> {
                Sale sale = ctx.body(Sale.class);

                if (dao.exists(sale.getid())) {

                    // store the product
                    return ctx
                            .send(StatusCode.UNPROCESSABLE_ENTITY);
                    //.render(new ErrorMessage("There is already a product with that ID."));
                } else {
                    // Non-unique ID
                    // send the URI of the new item via the "location" header of the response
                    dao.addSale(sale);
                    return ctx
                            .setResponseHeader("location", ctx.getRequestURL() + "/product/" + sale.getid())
                            .send(StatusCode.CREATED);

                }

            });

        });

    }

}
