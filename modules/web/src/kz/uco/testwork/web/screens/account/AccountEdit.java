package kz.uco.testwork.web.screens.account;

import com.haulmont.cuba.gui.ScreenBuilders;
import com.haulmont.cuba.gui.UiComponents;
import com.haulmont.cuba.gui.actions.list.CreateAction;
import com.haulmont.cuba.gui.builders.ScreenBuilder;
import com.haulmont.cuba.gui.components.*;
import com.haulmont.cuba.gui.components.data.value.ContainerValueSource;
import com.haulmont.cuba.gui.screen.*;
import kz.uco.testwork.entity.Account;
import kz.uco.testwork.entity.Contacts;
import kz.uco.testwork.web.screens.contacts.ContactsEdit;

import javax.inject.Inject;
import javax.inject.Named;

@UiController("testwork_Account.edit")
@UiDescriptor("account-edit.xml")
@EditedEntityContainer("accountDc")
@LoadDataBeforeShow
public class AccountEdit extends StandardEditor<Account> {

    @Inject
    ScreenBuilders screenBuilder;
    @Inject
    private Table<Contacts> contactsTable;




    @Subscribe("contactsTable.edit")
    private void onProductsTableEdit(Action.ActionPerformedEvent event) {
        screenBuilder.editor(contactsTable)
                .withLaunchMode(OpenMode.DIALOG)
                .build()
                .show();
    }
    @Subscribe("contactsTable.create")
    private void onProductsTableCreate(Action.ActionPerformedEvent event) {
        screenBuilder.editor(contactsTable)
                .newEntity()
                .withOpenMode(OpenMode.DIALOG)
                .withScreenClass(ContactsEdit.class)
                .withAfterCloseListener(afterScreenCloseEvent -> {
                    if (afterScreenCloseEvent.closedWith(StandardOutcome.COMMIT)) {
                        Contacts committedCustomer = (afterScreenCloseEvent.getScreen()).getEditedEntity();
                    }
                })
                .build()
                .show();
    }

}