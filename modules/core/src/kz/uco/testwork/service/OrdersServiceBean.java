package kz.uco.testwork.service;

import kz.uco.testwork.core.OrdersServiceMethods;
import kz.uco.testwork.entity.Order;
import kz.uco.testwork.entity.Product;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.inject.Inject;
import java.beans.Transient;
import java.util.List;
import java.util.UUID;

@Service(OrdersService.NAME)
public class OrdersServiceBean implements OrdersService {


    @Inject
    OrdersServiceMethods ordersService;


    @Override
    @Transactional
    public List<Order> getOrdersForAccountWithId(UUID uuid) {
        return ordersService.getOrdersForAccountWithId(uuid);
    }


}