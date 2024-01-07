package core.utils;

import core.driver.DriverManager;
import java.time.Duration;
import org.openqa.selenium.support.ui.WebDriverWait;

public class WaitUtils {
    public static WebDriverWait getExplicitWait() {
        return new WebDriverWait(DriverManager.getDriver(), Duration.ofSeconds(10));
    }
}
