package pages;

import static core.utils.WaitUtils.waitUntilPresenceOfElementLocated;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class InformationPage extends BasePage {

    private static final By LOAD_BUTTON =
        By.xpath("//*[@id='about_greeting']/descendant::a[contains(text(),'Загрузить')]");

    public InformationPage() {
        super(By.xpath("//div[@class='about_subtitle']"));
    }

    public WebElement getLoadSteamButtonElement() {
        return waitUntilPresenceOfElementLocated(LOAD_BUTTON);
    }
}
