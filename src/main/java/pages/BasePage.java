package pages;

import core.utils.WaitUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;

public abstract class BasePage {
    protected BasePage(By rootElement) {
        WaitUtils.getExplicitWait().until(ExpectedConditions.presenceOfElementLocated(rootElement));
    }
}
