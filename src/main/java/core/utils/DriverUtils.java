package core.utils;

import static core.driver.DriverManager.getDriver;

public class DriverUtils {

    public static void refreshPage() {
        getDriver().navigate().refresh();
    }
}
