package core.utils;

import firstTests.BaseTest;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

public class ResourcesUtils {

    public static void readResources() throws IOException {
        System.getProperties().load(ClassLoader.getSystemResourceAsStream("config.properties"));
        System.getProperty("HOST");

    }
}
