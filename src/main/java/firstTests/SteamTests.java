package firstTests;

import static core.utils.WaitUtils.waitUntilPresenceOfElementLocated;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import core.utils.WaitUtils;
import java.util.List;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import pages.MainPage;

public class SteamTests extends BaseTest {

    private static final String FALLOUT = "Fallout";

    @Test
    public void searchTest() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@name='term']")))
            .sendKeys("Max Payne");
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@id='store_search_link']/img"))).click();
        int i = 0;

        List<WebElement> titles = wait
            .until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath("//*[@class='title']")));

        assertTrue("В коллекции менее 5 элементов", titles.size() > 5);
        assertFalse("В выборке отсутствует тайтл с название 'Max Payne'", titles.contains("Max Payne"));
    }

    @Test
    public void checkPage() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[contains(text(),'Информация')]")))
            .click();

        WebElement button1 = wait
            .until(ExpectedConditions
                .visibilityOfElementLocated
                    (By.xpath("//div[@class='about_install mac ']//a[contains(text(), 'Загрузить Steam')][1]")));

        assertTrue("Кнопка 'Загрузить Steam' отображается", button1.isEnabled());

        if (button1.isEnabled()) {
            button1.click();
        } else {
            System.out.println("Кнопка 'Загрузить Steam' НЕкликабельна");
        }
    }

    //    Ввести в поиск "Fallout" / В поле поиска введно "Fallout"
    //    Нажать на кнопку "Поиск" / Открыта страница с выборкой игр по названию
    //    Выбираем сортировку по убыванию цены
    //    Ожидаемый результат:
    //    - Все тайтлы расположены по убыванию цены.
    @Test
    public void sortOfTitles() {
//        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@id='store_nav_search_term']")))
//            .sendKeys("Fallout", Keys.ENTER);
//
//        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[@id='sort_by_trigger']")))
//            .click();
//        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[contains(text(), 'убыванию цены')]")))
//            .click();
//
//        List<WebElement> elementsSort =
//            wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath("//div[@id='search_results']")));
//
//        for (double i = 0; i < elementsSort.size(); i++) {
//            if (i > elementsSort.size() - 1) {
//                System.out.println("Цены расположены по убыванию");
//            } else {
//                System.out.println("Тест не пройден. Цифры расположены вразброс");
//            }
//        }

        new MainPage()
            .search(FALLOUT)
            .sortByReducePrice();

        WaitUtils.getExplicitWait().until(ExpectedConditions.visibilityOfElementLocated(
            By.xpath("(//*[contains(text(),'убыванию цены')])[1]")));

        List<WebElement> elementsSort =
            WaitUtils.getExplicitWait().until(ExpectedConditions.presenceOfAllElementsLocatedBy(
                By.xpath("//*[contains(@class,'discount_block')]")));

        for (int i = 0; i < elementsSort.size(); i++) {
            System.out.println(elementsSort.get(i).getAttribute("data-price-final"));
        }
    }
}
