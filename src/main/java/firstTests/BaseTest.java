package firstTests;

import core.driver.DriverManager;
import core.utils.WaitUtils;
import io.github.bonigarcia.wdm.WebDriverManager;
import java.time.Duration;
import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

abstract public class BaseTest {

    protected WebDriver driver;
    protected WebDriverWait wait;

    @Before
    public void setUp() {
        driver = DriverManager.getDriver();
        driver.manage().window().maximize();
        wait = WaitUtils.getExplicitWait();
    }

    @After
    public void tearDown() {
        DriverManager.closeDriver();
    }
}
