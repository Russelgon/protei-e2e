package ru.protei.e2e.core.tech;

import io.github.bonigarcia.wdm.WebDriverManager;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Driver {

    private static WebDriver webDriver;

    public static WebDriver initializeDriver() {

        if (webDriver == null) {
            WebDriverManager.chromedriver().setup();
            webDriver = new ChromeDriver();
            webDriver.get("C:\\Users\\Alex\\Downloads\\qa-test.html");

            webDriver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        }

        return webDriver;
    }
}
