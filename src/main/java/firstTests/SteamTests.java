package firstTests;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import pages.MainPage;

public class SteamTests extends BaseTest {

    private static final String FALLOUT = "Fallout";
    private static final String MAXPAYNE = "Max Payne";

    /*Pre-Conditions:
Открыть главную сраницу Steam https://store.steampowered.com/
Шаги:
1) Ввести в поиск "Max Payne" / В поле поиска введно "Max Payne"
2) Нажать на кнопку "Поиск" / Открыта страница с выборкой игр по названию
Ожидаемый результат:
- В выборке не менее 5 тайтлов.
- В выборе отсутствует тайтл с названием "Max Payne"
    */
    @Test
    public void searchTest() {
//        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@name='term']")))
//            .sendKeys("Max Payne");
//        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@id='store_search_link']/img"))).click();
//        int i = 0;
//
//        List<WebElement> titles = wait
//            .until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath("//*[@class='title']")));
//
//        assertTrue("В коллекции не менее 5 элементов", titles.size() > 5);
//        assertFalse("В выборке отсутствует тайтл с название 'Max Payne'", titles.contains("Max Payne"));

        List<WebElement> test1 = new MainPage()
                .searchTest1(MAXPAYNE)
                .expectedTitles();
        assertTrue("В коллекции не менее 5 элементов", test1.size() > 5);
        assertTrue("В выборке отсутствует тайтл с название 'Max Payne'", !test1.contains("Max Payne"));

    }

    /*
   Pre-Conditions:
Открыть главную сраницу Steam https://store.steampowered.com/
Шаги:
1) Нажать на кнопку "Информация" в хэдере / Открыта страница с информацией
Ожидаемый результат:
- Кнопка "Загрузить Steam" отображается
- Кнопка "Загрузить Steam" кликабельна
     */
    //div[@class='about_subtitle']
    @Test
    public void checkPage() {
//        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[contains(text(),'Информация')]")))
//            .click();
//
//        WebElement button1 = wait
//            .until(ExpectedConditions
//                .visibilityOfElementLocated
//                    (By.xpath("//div[@class='about_install mac ']//a[contains(text(), 'Загрузить Steam')][1]")));
//
//        assertTrue("Кнопка 'Загрузить Steam' отображается", button1.isEnabled());



        new MainPage().searchInfo().checkButton();

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
//        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[@id='sort_by_trigger']")))
//            .click();
//        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[contains(text(), 'убыванию цены')]")))
//            .click();
//        List<WebElement> elementsSort =
//            wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath("//div[@id='search_results']")));
//        for (double i = 0; i < elementsSort.size(); i++) {
//            if (i > elementsSort.size() - 1) {
//                System.out.println("Цены расположены по убыванию");
//            } else {
//                System.out.println("Тест не пройден. Цифры расположены вразброс");
//            }
//        }

        List<Long> reducePriceList = new MainPage()
            .search(FALLOUT)
            .sortByReducePrice()
            .getPriceList();

        List<Long> expectedResultList = reducePriceList.stream()
            .sorted(Comparator.reverseOrder())
            .collect(Collectors.toList());

        assertEquals("Сортировка выполнена некорректно! Цены идут не по убыванию.",
            expectedResultList, reducePriceList);
    }
}
