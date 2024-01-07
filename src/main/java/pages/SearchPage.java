package pages;

import static core.utils.WaitUtils.waitUntilPresenceOfElementLocated;
import org.openqa.selenium.By;

public class SearchPage extends BasePage {

    private static final By ROOT_ELEMENT =
        By.xpath("//*[contains(text(),'Результатов по вашему запросу')]");

    private static final By SORT_BY_BUTTON = By.xpath("//a[@id='sort_by_trigger']");

    private static final By BY_REDUCE_PRICE_BUTTON = By.xpath("//a[contains(text(), 'убыванию цены')]");

    public SearchPage() {
        super(ROOT_ELEMENT);
    }

    public SearchPage sortByReducePrice() {
        waitUntilPresenceOfElementLocated(SORT_BY_BUTTON).click();
        waitUntilPresenceOfElementLocated(BY_REDUCE_PRICE_BUTTON).click();
        return new SearchPage();
    }
}
