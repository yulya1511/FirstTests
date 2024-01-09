package pages;

import static core.utils.DriverUtils.refreshPage;
import static core.utils.WaitUtils.waitUntilPresenceOfAllElementsLocatedBy;
import static core.utils.WaitUtils.waitUntilPresenceOfElementLocated;
import java.util.List;
import java.util.stream.Collectors;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class SearchPage extends BasePage {

    private static final By ROOT_ELEMENT =
        By.xpath("//*[contains(text(),'Результатов по вашему запросу')]");

    private static final By SORT_BY_BUTTON = By.xpath("//a[@id='sort_by_trigger']");

    private static final By BY_REDUCE_PRICE_BUTTON = By.xpath("//a[contains(text(), 'убыванию цены')]");

    private static final By PRICE_LABEL = By.xpath("//*[contains(@class,'discount_block')]");

    public SearchPage() {
        super(ROOT_ELEMENT);
    }

    public SearchPage sortByReducePrice() {
        waitUntilPresenceOfElementLocated(SORT_BY_BUTTON).click();
        waitUntilPresenceOfElementLocated(BY_REDUCE_PRICE_BUTTON).click();
        refreshPage();
        return new SearchPage();
    }

    public List<Long> getPriceList() {
        return waitUntilPresenceOfAllElementsLocatedBy(PRICE_LABEL).stream()
            .map(element -> element.getAttribute("data-price-final"))
            .map(Long::parseLong)
            .collect(Collectors.toList());
    }

    public List<WebElement> expectedTitles(){
       List<WebElement> titles = waitUntilPresenceOfAllElementsLocatedBy(By.xpath("//*[@class='title']"));
       return titles;
    }
}
