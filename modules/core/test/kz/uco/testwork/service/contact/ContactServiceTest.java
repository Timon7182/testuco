package kz.uco.testwork.service.contact;

import com.haulmont.cuba.core.global.AppBeans;
import com.haulmont.cuba.core.global.DataManager;
import com.haulmont.cuba.core.global.TimeSource;
import com.haulmont.cuba.testsupport.TestContainer;
import kz.uco.testwork.TestworkTestContainer;
import kz.uco.testwork.core.ContactCollect;
import kz.uco.testwork.entity.Account;
import kz.uco.testwork.entity.Contacts;
import kz.uco.testwork.entity.Order;
import kz.uco.testwork.service.ContactCollectService;
import kz.uco.testwork.service.OrdersService;
import kz.uco.testwork.service.order.Orderdb;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.RegisterExtension;

import java.util.List;
import java.util.UUID;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;
// See https://doc.cuba-platform.com/manual-7.2/integration_tests_mw.html

class ContactServiceTest {



    @RegisterExtension
    public static TestworkTestContainer testContainer = TestworkTestContainer.Common.INSTANCE;

    private static ContactCollectService contactCollect;

    private static ContactDb db;
    private Account account;
    private Contacts contact;

    @BeforeAll
    static void beforeAll() {
        contactCollect = AppBeans.get(ContactCollectService.class);
        db = new ContactDb(
                AppBeans.get(DataManager.class),
                testContainer
        );
    }

    @BeforeEach
    void loadNewAccountandOrder() {
        account=db.loadAccountWithContact();
        contact =db.getContactByAccountid(account.getId());
    }

    @Test
    void testGetAllContactValues() {

        String contacts=contactCollect.getAllContactValues(account.getId());
        assertThat(contacts.length())
                .isGreaterThan(0);
        db.deleteAccount(account.getId());

    }

}