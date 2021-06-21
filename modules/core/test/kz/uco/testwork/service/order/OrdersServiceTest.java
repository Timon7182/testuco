package kz.uco.testwork.service.order;

import com.haulmont.cuba.core.global.AppBeans;
import com.haulmont.cuba.core.global.DataManager;
import com.haulmont.cuba.core.global.TimeSource;
import kz.uco.testwork.TestworkTestContainer;
import kz.uco.testwork.entity.Account;
import kz.uco.testwork.entity.Order;
import kz.uco.testwork.service.OrdersService;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.RegisterExtension;

import java.util.List;
import java.util.UUID;

import static org.assertj.core.api.Assertions.assertThat;
// See https://doc.cuba-platform.com/manual-7.2/integration_tests_mw.html

public class OrdersServiceTest {


    @RegisterExtension
    public static TestworkTestContainer testContainer = TestworkTestContainer.Common.INSTANCE;

    private static TimeSource timeSource;
    private static OrdersService ordersService;

    private static Orderdb db;
    private Account account;
    private Order order;

    @BeforeAll
    static void beforeAll() {
        ordersService = AppBeans.get(OrdersService.class);
        db = new Orderdb(
                AppBeans.get(DataManager.class),
                testContainer
        );
        timeSource = AppBeans.get(TimeSource.class);
    }

    @BeforeEach
    void loadNewAccountandOrder() {
        account=db.loadAccountWithOrder();
        order =db.orderWithId(account.getOrders().get(0).getId());
    }

    @Test
    void testGetOrdersForAccountWithId() {


        UUID id = account.getId();
        List<Order> orderList=ordersService.getOrdersForAccountWithId(id);
        assertThat(orderList.size())
                .isGreaterThan(0);
        db.deleteAccount(account.getId());

    }


}