package firstTests;

import static core.driver.DriverManager.closeDriver;
import static core.utils.DriverUtils.open;
import static core.utils.DriverUtils.openPageMax;
import static core.utils.ResourcesUtils.getResource;
import core.utils.WaitUtils;
import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.support.ui.WebDriverWait;

abstract public class BaseTest {

    protected WebDriverWait wait;
    protected final static String HOST = "HOST";

    @Before
    public void setUp() {
        open(getResource(HOST));
        openPageMax();
        wait = WaitUtils.getExplicitWait();
    }

    @After
    public void tearDown() {
        closeDriver();
    }
}
