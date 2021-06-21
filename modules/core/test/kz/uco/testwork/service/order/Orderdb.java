package kz.uco.testwork.service.order;

import com.haulmont.cuba.core.global.DataManager;
import kz.uco.testwork.TestworkTestContainer;
import kz.uco.testwork.entity.Account;
import kz.uco.testwork.entity.Order;
import kz.uco.testwork.entity.Product;
import org.aspectj.weaver.ast.Or;
import org.checkerframework.checker.units.qual.A;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class Orderdb {

    private final DataManager dataManager;
    private final TestworkTestContainer testContainer;

    public Orderdb(
            DataManager dataManager,
            TestworkTestContainer testContainer
    ) {
        this.dataManager = dataManager;
        this.testContainer = testContainer;
    }

    public Account loadAccountWithOrder() {

        Account account = testContainer.metadata().create(Account.class);
        account.setName("User");
        account.setLast_name("Test");

        Account account1 = dataManager.commit(account);
        Order order = testContainer.metadata().create(Order.class);
        order.setName("New Test Order");
        order.setAccount(account1);

        Product product = testContainer.metadata().create(Product.class);
        product.setName("Test product");
        product.setOrder(order);

//        List<Order> orders=new ArrayList<>();
//        orders.add(order);
//        account1.setOrders(orders);
        dataManager.commit(account1,order,product);

        return dataManager.load(Account.class)
                .query("select e from testwork_Account e where e.id = :id")
                .parameter("id",account1.getUuid())
                .view("account-with-order")
                .one();
    }

    public Order orderWithId(UUID uuid) {
        return dataManager.load(Order.class)
                .query("select e from testwork_Order e join fetch e.account where e.id = :eId")
                .parameter("eId",uuid)
                .view("order-with-product-and-account")
                .one();
    }


    public void deleteAccount(UUID u){
        dataManager.remove(dataManager.getReference(Account.class,u));
    }
}
