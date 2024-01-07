package core.utils;

import core.driver.DriverManager;
import java.time.Duration;
import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class WaitUtils {

    public static WebDriverWait getExplicitWait() {
        return new WebDriverWait(DriverManager.getDriver(), Duration.ofSeconds(10));
    }

    public static WebElement waitUntilPresenceOfElementLocated(By locator) {
        return getExplicitWait().until(ExpectedConditions.presenceOfElementLocated(locator));
    }

    public static List<WebElement> waitUntilPresenceOfAllElementsLocatedBy(By locator) {
        return getExplicitWait().until(ExpectedConditions.presenceOfAllElementsLocatedBy(locator));
    }
}
