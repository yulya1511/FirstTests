package core.utils;

import core.driver.DriverManager;
import java.time.Duration;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class WaitUtils {
    public static WebDriverWait getExplicitWait() {
        return new WebDriverWait(DriverManager.getDriver(), Duration.ofSeconds(10));
    }

    public static WebElement waitUntilPresenceOfElementLocated(By locator) {
        return WaitUtils.getExplicitWait().until(ExpectedConditions.presenceOfElementLocated(locator));
    }
}
