package kz.uco.testwork.web.screens.account;


import com.haulmont.cuba.core.global.DataManager;
import com.haulmont.cuba.core.global.LoadContext;
import com.haulmont.cuba.gui.components.Table;
import com.haulmont.cuba.gui.data.CollectionDatasource;
import com.haulmont.cuba.gui.model.CollectionLoader;
import com.haulmont.cuba.gui.model.InstanceContainer;
import com.haulmont.cuba.gui.screen.*;
import kz.uco.testwork.entity.Account;
import kz.uco.testwork.entity.Order;
import kz.uco.testwork.entity.Product;
import kz.uco.testwork.service.OrdersService;

import javax.inject.Inject;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@UiController("testwork_Screen")
@UiDescriptor("orderscreen.xml")
@LoadDataBeforeShow
@LookupComponent("ordersTable")
public class Screen extends StandardLookup<Order> {



    @Inject
    private OrdersService ordersService;

    @Inject
    private Table<Order> ordersTable;


    @Inject
    private CollectionLoader<Product> productDl;

    @Inject
    private CollectionLoader<Order> ordersDl;
    private UUID id;

    @Inject
    private DataManager dataManager;

    @Subscribe
    protected void onInit(InitEvent event) {
        ScreenOptions options = event.getOptions();
        if (options instanceof ScreenOptionsOrder) {
            UUID accountId = ((ScreenOptionsOrder) options).getMessage();
            this.id=accountId;
        }
    }


    @Subscribe
    protected void onBeforeShow(BeforeShowEvent event) {
        productDl.setParameter("product",new UUID( 0 , 0 ));
        productDl.load();

    }


    @Subscribe(id = "ordersDc", target = Target.DATA_CONTAINER)
    protected void onOrdersDcItemChange(InstanceContainer.ItemChangeEvent<Order> event) {
        UUID id=new UUID(0,0);
        if(event.getItem()!=null){
            id=event.getItem().getId();
        }
        productDl.setParameter("product", id);
        productDl.load();
    }



    @Install(to = "ordersDl", target = Target.DATA_LOADER)
    private List<Order> tableDlLoadDelegate(LoadContext<Order> loadContext){
//        Stream<Order> context=dataManager.loadList(loadContext).stream();
        List<Order> result=ordersService.getOrdersForAccountWithId(this.id);
//        Stream<Order> dataStream=orders.stream();
//        Stream<Order> dl=Stream.concat(context,dataStream);
        return result;
    }
}