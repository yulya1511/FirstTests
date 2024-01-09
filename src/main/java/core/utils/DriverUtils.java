package core.utils;

import static core.driver.DriverManager.getDriver;

public class DriverUtils {

    public static void refreshPage() {
        getDriver().navigate().refresh();
    }

    public void openMainPage() {
         getDriver().get("https://store.steampowered.com/");
    }

    public void openPageMax() {
        getDriver().manage().window().maximize();
    }
}
