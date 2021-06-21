package kz.uco.testwork.core;

import com.haulmont.cuba.core.Persistence;
import com.haulmont.cuba.core.Query;
import kz.uco.testwork.entity.Order;
import kz.uco.testwork.entity.Product;
import org.springframework.stereotype.Component;

import javax.inject.Inject;
import java.util.List;
import java.util.UUID;

@Component("ordersGenerator")
public class OrdersServiceMethods {

    @Inject
    private Persistence persistence;

    public List<Order> getOrdersForAccountWithId(UUID accountId) {

        Query query = persistence.getEntityManager().createQuery(
                "select e from testwork_Order e join fetch e.account  join fetch e.product where e.account.id = :accId");
        query.setParameter("accId", accountId);

        List<Order> orders= query.getResultList();

        return orders;
    }

}
