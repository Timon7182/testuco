package kz.uco.testwork.web.screens.order;

import com.haulmont.cuba.gui.screen.*;
import kz.uco.testwork.entity.Order;

@UiController("testwork_Order.edit")
@UiDescriptor("order-edit.xml")
@EditedEntityContainer("orderDc")
@LoadDataBeforeShow
public class OrderEdit extends StandardEditor<Order> {
}