package graphql;

import dao.AccountserviceDAO;
import graphql.schema.idl.RuntimeWiring;
import static graphql.schema.idl.TypeRuntimeWiring.newTypeWiring;

public class AccountWiring {

    private final AccountserviceDAO dao;

    public AccountWiring(AccountserviceDAO dao) {
        this.dao = dao;
    }

    public RuntimeWiring getWiring() {
        return RuntimeWiring
                .newRuntimeWiring()
                .type(
                        newTypeWiring("SaleQuery")
                                .dataFetcher("customers", new AccountFetcher(dao).getCustomerFetcher())
                                .dataFetcher("customer", new AccountFetcher(dao).getCustomerByIdFetcher())
                ).type(
                        newTypeWiring("SalesMutation")
                                .dataFetcher("deleteCustomer", new AccountFetcher(dao).getDeleteCustomerFetcher())
                                .dataFetcher("createCustomer", new AccountFetcher(dao).getCreateCustomerFetcher())
                                .dataFetcher("changeGroup", new AccountFetcher(dao).getChangeGroupFetcher())
                ).build();
    }

}
