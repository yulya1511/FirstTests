package core.utils;

import java.util.ResourceBundle;

public class ResourcesUtils {

    public static String getResource(String resourceName) {
        return ResourceBundle.getBundle("config").getString(resourceName);
    }

    public static String getResource(String from, String resourceName) {
        return ResourceBundle.getBundle(from).getString(resourceName);
    }
}
