package core.utils;

import static core.driver.DriverManager.getDriver;

public class DriverUtils {

    public static void refreshPage() {
        getDriver().navigate().refresh();
    }

    public static void open(String url) {
         getDriver().get(url);
    }

    public static void openPageMax() {
        getDriver().manage().window().maximize();
    }
}
