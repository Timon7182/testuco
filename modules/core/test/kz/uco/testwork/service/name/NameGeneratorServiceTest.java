package kz.uco.testwork.service.name;

import com.haulmont.cuba.core.global.AppBeans;
import com.haulmont.cuba.core.global.DataManager;
import com.haulmont.cuba.testsupport.TestContainer;
import kz.uco.testwork.TestworkTestContainer;
import kz.uco.testwork.entity.Account;
import kz.uco.testwork.service.ContactCollectService;
import kz.uco.testwork.service.NameGeneratorService;
import kz.uco.testwork.service.contact.ContactDb;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.RegisterExtension;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;
// See https://doc.cuba-platform.com/manual-7.2/integration_tests_mw.html

class NameGeneratorServiceTest {

    @RegisterExtension
    public static TestworkTestContainer testContainer = TestworkTestContainer.Common.INSTANCE;

    static DataManager dataManager;

    static NameGeneratorDb db;
    static NameGeneratorService nameGeneratorService;
    static Account account;

    @BeforeAll
    static void beforeAll() {
        nameGeneratorService = AppBeans.get(NameGeneratorService.class);
        db = new NameGeneratorDb(
                AppBeans.get(DataManager.class),
                testContainer
        );
    }

    @BeforeEach
    void loadNewAccount() {
        account=db.loadAccountWithFullName();
    }

    @Test
    void testGetFullName() {
        String fullname= nameGeneratorService.getFullName(account.getId());
        assertThat(fullname)
                .isEqualTo(db.FULL_NAME);
        db.deleteAccount(account.getId());

    }
}