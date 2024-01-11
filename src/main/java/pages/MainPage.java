package pages;

import static core.utils.WaitUtils.waitUntilPresenceOfElementLocated;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;

public class MainPage extends BasePage {

    private static final By SEARCH_FIELD = By.xpath("//input[@id='store_nav_search_term']");
    private static final By INFO = By.xpath("//*[contains(text(),'Информация')]");

    public MainPage() {
        super(By.xpath("//*[@class='gutter_header']"));
    }

    public SearchPage search(String text) {
        waitUntilPresenceOfElementLocated(SEARCH_FIELD).clear();
        waitUntilPresenceOfElementLocated(SEARCH_FIELD).sendKeys(text, Keys.ENTER);
        return new SearchPage();
    }

    public InformationPage searchInfo() {
        waitUntilPresenceOfElementLocated(INFO).click();
        return new InformationPage();
    }
}
