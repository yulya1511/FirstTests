package firstTests;

import static core.driver.DriverManager.closeDriver;
import static core.driver.DriverManager.getDriver;
import core.utils.WaitUtils;
import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.support.ui.WebDriverWait;

abstract public class BaseTest {

    protected WebDriverWait wait;

    @Before
    public void setUp() {
        getDriver().get("https://store.steampowered.com/");
        getDriver().manage().window().maximize();
        wait = WaitUtils.getExplicitWait();
    }

    @After
    public void tearDown() {
        closeDriver();
    }
}
