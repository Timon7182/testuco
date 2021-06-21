package kz.uco.testwork.service.contact;

import com.haulmont.cuba.core.global.DataManager;
import kz.uco.testwork.TestworkTestContainer;
import kz.uco.testwork.entity.*;

import java.util.UUID;

public class ContactDb {



    private final DataManager dataManager;
    private final TestworkTestContainer testContainer;

    public ContactDb(
            DataManager dataManager,
            TestworkTestContainer testContainer
    ) {
        this.dataManager = dataManager;
        this.testContainer = testContainer;
    }

    public Account loadAccountWithContact() {

        Account account = testContainer.metadata().create(Account.class);
        account.setName("User");
        account.setLast_name("Test");
        dataManager.commit(account);
        Contacts contact = testContainer.metadata().create(Contacts.class);
        contact.setAccount(account);
        contact.setContact(ContactType.PHONE);
        contact.setValue("87029993333");
        dataManager.commit(contact);

        return dataManager.load(Account.class)
                .query("select e from testwork_Account e where e.id = :id")
                .parameter("id",account.getUuid())
                .view("account-with-contacts")
                .one();
    }
    public Contacts getContactByAccountid(UUID uuid){
        return dataManager.load(Contacts.class)
                .query("select e from testwork_Contacts e where e.account.id = :id")
                .parameter("id",uuid)
                .one();
    }

    public void deleteAccount(UUID u){
        dataManager.remove(dataManager.getReference(Account.class,u));
    }


}
