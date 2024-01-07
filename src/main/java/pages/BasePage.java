package pages;

import static core.utils.WaitUtils.waitUntilPresenceOfElementLocated;
import org.openqa.selenium.By;

public abstract class BasePage {

    public BasePage(By rootElement) {
        waitUntilPresenceOfElementLocated(rootElement);
    }
}
