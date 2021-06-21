package kz.uco.testwork;

import com.haulmont.bali.util.Dom4j;
import com.haulmont.cuba.testsupport.TestContainer;
import org.dom4j.Document;
import org.dom4j.Element;
import org.junit.jupiter.api.extension.ExtensionContext;
import org.springframework.core.io.DefaultResourceLoader;
import org.springframework.core.io.Resource;

import java.io.File;
import java.io.InputStream;
import java.nio.file.Files;
import java.util.*;

public class TestworkTestContainer extends TestContainer {

    public TestworkTestContainer() {
        super();
        appComponents = new ArrayList<>(Arrays.asList(
                "com.haulmont.cuba"

        ));
        appPropertiesFiles = Arrays.asList(

                "kz/uco/testwork/app.properties",
                "com/haulmont/cuba/testsupport/test-app.properties");
        autoConfigureDataSource();

    }



    public static class Common extends TestworkTestContainer {

        public static final TestworkTestContainer.Common INSTANCE = new TestworkTestContainer.Common();

        private static volatile boolean initialized;

        private Common() {
        }

        @Override
        public void before() throws Throwable {
            if (!initialized) {
                super.before();
                initialized = true;
            }
            setupContext();
        }

        @Override
        public void after() {
            cleanupContext();
            // never stops - do not call super
        }
    }
}