package kz.uco.testwork.service;

import kz.uco.testwork.entity.Order;
import kz.uco.testwork.entity.Product;

import java.util.List;
import java.util.UUID;

public interface OrdersService {
    String NAME = "testwork_OrdersService";


    List<Order> getOrdersForAccountWithId(UUID uuid);
}
