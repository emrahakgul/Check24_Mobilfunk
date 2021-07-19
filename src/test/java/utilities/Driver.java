package utilities;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.opera.OperaDriver;

public class Driver {

    public static ThreadLocal<WebDriver> drivers = new ThreadLocal<>();
    public static ThreadLocal<String> browsers = new ThreadLocal<>();

    /**
     * this method returns the threadlocal webDriver
     *
     * @return WebDriver
     */
    public static WebDriver getDriver() {

        if (browsers.get() == null) {
            browsers.set("chrome");
        }

        if (drivers.get() == null) {
            switch (browsers.get()) {
                case "firefox" -> {
                    WebDriverManager.firefoxdriver().setup();
                    drivers.set(new FirefoxDriver());
                }
                case "edge", "msedge" -> {
                    WebDriverManager.edgedriver().setup();
                    drivers.set(new EdgeDriver());
                }
                case "opera" -> {
                    WebDriverManager.operadriver().setup();
                    drivers.set(new OperaDriver());
                }
                default -> {
                    WebDriverManager.chromedriver().setup();
                    drivers.set(new ChromeDriver());
                }
            }

        }
        return drivers.get();
    }

    /**
     * quit the threadLocal WebDriver
     */
    public static void quitDriver() {
        if (drivers.get() != null) {
            drivers.get().quit();
            drivers.set(null);
        }
    }
}
