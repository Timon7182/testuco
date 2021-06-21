package kz.uco.testwork.web.screens.contacts;

import com.haulmont.cuba.gui.components.LookupField;
import com.haulmont.cuba.gui.screen.*;
import javafx.scene.control.TextField;
import kz.uco.testwork.entity.Contacts;

import javax.inject.Inject;

@UiController("testwork_Contacts.edit")
@UiDescriptor("contacts-edit.xml")
@EditedEntityContainer("contactsDc")
@LoadDataBeforeShow
public class ContactsEdit extends StandardEditor<Contacts> {

}