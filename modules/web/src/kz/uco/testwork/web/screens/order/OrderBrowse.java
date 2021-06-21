package kz.uco.testwork.web.screens.order;

import com.haulmont.cuba.gui.screen.*;
import kz.uco.testwork.entity.Order;

@UiController("testwork_Order.browse")
@UiDescriptor("order-browse.xml")
@LookupComponent("ordersTable")
@LoadDataBeforeShow
public class OrderBrowse extends StandardLookup<Order> {
}