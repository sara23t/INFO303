package api;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import domain.Customer;
import domain.Sale;
import domain.SaleItem;

import domain.Summary;
import domain.Totals;
import java.io.IOException;
import java.util.List;

import java.math.BigDecimal;
import java.util.Collection;
import static org.hamcrest.CoreMatchers.hasItem;
import static org.hamcrest.CoreMatchers.hasItems;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.not;
import org.hamcrest.Matcher;
import static org.hamcrest.MatcherAssert.assertThat;
import org.hamcrest.Matchers;
import static org.hamcrest.Matchers.contains;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.hamcrest.Matchers.samePropertyValuesAs;
import retrofit2.Response;

public class SalesIntegrationTest {

    private final Retrofit retrofit = new Retrofit.Builder()
            .baseUrl("http://localhost:8081/api/")
            .addConverterFactory(GsonConverterFactory.create())
            .build();

    private SaleResourcesApi sales;
    private SalesCustomerResourcsApi customers;

    private Sale sale1;
    private Sale sale2;
    private Sale sale3;
    private Customer cus1;
    private Customer cus2;

    private Totals total;
    private SaleItem saleitem;

    @BeforeEach
    public void setUp() throws IOException {

        sales = retrofit.create(SaleResourcesApi.class);
        customers = retrofit.create(SalesCustomerResourcsApi.class);
        cus1 = new Customer();
        cus1.setId("cus1");
        cus1.setFirstName("Sara");
        cus1.setGroup("group1");
        cus1.setLastName("Taha");
        cus1.setCustomerCode("2342");
        cus1.setEmail("something@home.com");

        cus2 = new Customer();
        cus2.setId("cus1");
        cus2.setFirstName("Sara");
        cus2.setGroup("group1");
        cus2.setLastName("Taha");
        cus2.setCustomerCode("2342");
        cus2.setEmail("something@home.com");

        total = new Totals();
        total.setTotalPayment(new BigDecimal("85.0"));
        total.setTotalPrice(new BigDecimal("6.0"));
        total.setTotalTax(new BigDecimal("753.00"));

        saleitem = new SaleItem();
        saleitem.setProductId("item1");
        saleitem.setPrice(new BigDecimal("6.0"));
        saleitem.setQuantity(new BigDecimal("14.4"));

        sale1 = new Sale();
        sale1.setTotals(total);
        sale1.setId("s1");
        sale1.setCustomer(cus2);
        sale1.setSaleDate("23th");
        sale1.addItemsItem(saleitem);

        sale2 = new Sale();
        sale2.setTotals(total);
        sale2.setId("s2");
        sale2.setCustomer(cus2);
        sale2.setSaleDate("4th");
        sale2.addItemsItem(saleitem);

        sale3 = new Sale();
        sale3.setId("s3");
        sale3.setTotals(total);
        sale3.setCustomer(cus1);
        sale3.setSaleDate("5th");
        sale3.addItemsItem(saleitem);

        sales.addSale(sale1).execute();
        sales.addSale(sale2).execute();
    }

    @AfterEach
    public void cleanUp() throws IOException {
        sales.deleteSale(sale1.getId()).execute();
        sales.deleteSale(sale2.getId()).execute();
        sales.deleteSale(sale3.getId()).execute();
    }

    @Test
    public void testDeleteSale() throws IOException {
        Response<Sale> product = sales.getSale(sale2.getId()).execute();
        assertThat(product.code(), is(200));
        Response<Void> deletesale = sales.deleteSale(sale2.getId()).execute();
        assertThat(deletesale.code(), is(204));
        product = sales.getSale(sale2.getId()).execute();
        assertThat(product.code(), is(404));
    }

    @Test
    public void testGetAllSaleByCustomerId() throws IOException {

        Response <List<Sale>> salesResponse  = customers.getSalesCustomerId(cus2.getId()).execute();
        assertThat(salesResponse.code(), is(200));
      List<Sale> s2 = salesResponse.body();
        assertThat(s2, hasItems(sale1,sale2));


    }

    @Test
    public void testGetSaleByID() throws IOException {
        Response<Sale> getsale = sales.getSale(sale1.getId()).execute();
        assertThat(getsale.code(), is(200));
        Response<Sale> getprodss = sales.getSale("BADID").execute();
        assertThat(getprodss.code(), is(404));

    }

    @Test
    public void testCreateSale() throws IOException {
        Response<Void> createsaleres = sales.addSale(sale3).execute();
        assertThat(createsaleres.code(), is(201));

        //Response<Sale> salesResponse = sales.getSale(sale3.getId()).execute();
        // assertThat(salesResponse.code(),is(sale3));
        Response<Sale> salesResponse = sales.getSale("s3").execute();
        assertThat(salesResponse.code(), is(200));

        createsaleres = sales.addSale(sale3).execute();
        assertThat(createsaleres.code(), is(422));

    }

    @Test
    public void testGetAllSales() throws IOException {
        Response<List<Sale>> getResponse = sales.getSales().execute();

        List<Sale> returnSales = getResponse.body();
        // assertThat(getResponse.code(), is(200));

        assertThat(returnSales, hasItems(sale1, sale2));
        assertThat(returnSales, not(hasItem(sale3)));
    }

    @SuppressWarnings("null")
    @Test
    public void testGetSummary() throws IOException {
        Response<Summary> summary2 = customers.getSalesdataCustomerIdSummary(cus1.getId()).execute();
        Summary summarres = summary2.body();
        assertThat(summarres.getTotalPayment(), is(new BigDecimal("170.0")));
        assertThat(summarres.getGroup(), is("Regular Customers"));
        assertThat(summarres.getNumberOfSales(), is(2));
    }

}
