package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import static core.utils.WaitUtils.waitUntilPresenceOfElementLocated;
import static org.junit.Assert.assertTrue;

public class InformationPage extends BasePage {

    private static final By ROOT_ELEMENT1 = By.xpath("//div[@class='about_subtitle']");
    private static final By BUTTON_LOAD =
            By.xpath("//*[@id='about_greeting']/descendant::a[contains(text(),'Загрузить')]");

    public InformationPage() {
        super(ROOT_ELEMENT1);
    }

    public InformationPage checkButton(){
        WebElement buttonLoadSteam = waitUntilPresenceOfElementLocated
                (By.xpath("//*[@id='about_greeting']/descendant::a[contains(text(),'Загрузить')]"));
        //здесь вставляю кнопку BUTTON_LOAD, и не получается , подчеркивает красным, поэтому пока здесь вставила xpath
        assertTrue("Кнопка 'Загрузить Steam' отображается", buttonLoadSteam.isEnabled());
        if (buttonLoadSteam.isEnabled()) {
            buttonLoadSteam.click();
        } else {
            System.out.println("Кнопка 'Загрузить Steam' НЕкликабельна");
        }
                return new InformationPage();
    }
}
