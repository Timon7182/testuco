package kz.uco.testwork.service.name;

import com.haulmont.cuba.core.global.DataManager;
import kz.uco.testwork.TestworkTestContainer;
import kz.uco.testwork.entity.Account;
import kz.uco.testwork.entity.ContactType;
import kz.uco.testwork.entity.Contacts;

import java.util.UUID;

public class NameGeneratorDb {


    public final static String FULL_NAME = "User Test Middle";

    private final DataManager dataManager;
    private final TestworkTestContainer testContainer;

    public NameGeneratorDb(
            DataManager dataManager,
            TestworkTestContainer testContainer
    ) {
        this.dataManager = dataManager;
        this.testContainer = testContainer;
    }

    public Account loadAccountWithFullName() {

        Account account = testContainer.metadata().create(Account.class);
        account.setName("User");
        account.setLast_name("Test");
        account.setMiddle_name("Middle");
        dataManager.commit(account);


        return dataManager.load(Account.class)
                .query("select e from testwork_Account e where e.id = :id")
                .parameter("id",account.getUuid())
                .one();
    }


    public void deleteAccount(UUID u){
        dataManager.remove(dataManager.getReference(Account.class,u));
    }



}
