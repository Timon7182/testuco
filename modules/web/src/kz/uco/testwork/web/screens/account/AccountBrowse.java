package kz.uco.testwork.web.screens.account;

import com.haulmont.cuba.gui.Notifications;
import com.haulmont.cuba.gui.ScreenBuilders;
import com.haulmont.cuba.gui.UiComponents;
import com.haulmont.cuba.gui.components.Action;
import com.haulmont.cuba.gui.components.Component;
import com.haulmont.cuba.gui.components.Image;
import com.haulmont.cuba.gui.components.Table;
import com.haulmont.cuba.gui.components.data.value.ContainerValueSource;
import com.haulmont.cuba.gui.screen.*;
import kz.uco.testwork.entity.Account;
import kz.uco.testwork.service.ContactCollectService;
import kz.uco.testwork.service.NameGeneratorService;

import javax.inject.Inject;

@UiController("testwork_Account.browse")
@UiDescriptor("account-browse.xml")
@LookupComponent("accountsTable")
@LoadDataBeforeShow
public class AccountBrowse extends StandardLookup<Account> {



    @Inject
    private Table<Account> accountsTable;

    @Inject
    private UiComponents uiComponents;

    @Inject
    NameGeneratorService nameGeneratorService;

    @Inject
    ContactCollectService contactCollectService;
    @Inject
    protected ScreenBuilders screenBuilders;

    @Inject
    private Notifications notifications;


    @Subscribe
    protected void onInit(InitEvent event) {
        accountsTable.getColumn("full_name").setCaption("Full Name");
        accountsTable.getColumn("id").setCaption("Contact");


        accountsTable.addGeneratedColumn("photo", account -> {
            if (account.getPhoto() != null) {
                Image avatarImage = uiComponents.create(Image.class);
                avatarImage.setScaleMode(Image.ScaleMode.SCALE_DOWN);
                avatarImage.setAlignment(Component.Alignment.MIDDLE_CENTER);
                avatarImage.setWidth("100%");
                avatarImage.setHeight("80px");

                avatarImage.setValueSource(new ContainerValueSource<>(accountsTable.getInstanceContainer(account), "photo"));
                return avatarImage;
            }
            return null;
        });
    }



    @Subscribe("accountsTable.order")
    protected void openOrder(Action.ActionPerformedEvent event) {
        Account account = accountsTable.getSingleSelected();
        if(account.getOrders().size()>0){
            screenBuilders.screen(this)
                    .withScreenId("testwork_Screen")
                    .withOpenMode(OpenMode.NEW_TAB)
                    .withOptions(new ScreenOptionsOrder(account.getId()))
                    .build()
                    .show();
        }else {
            notifications.create().withCaption("Нет заказов").show();
        }

    }


    public Component generateFullNameCell(Account entity) {
        return new Table.PlainTextCell(nameGeneratorService.getFullName(entity.getId()));
    }
    public Component generateContactValues(Account entity) {
        return new Table.PlainTextCell(contactCollectService.getAllContactValues(entity.getId()));
    }
}