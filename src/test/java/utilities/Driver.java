package utilities;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;

import org.openqa.selenium.firefox.FirefoxDriver;


public class Driver {

    public static ThreadLocal<WebDriver> drivers = new ThreadLocal<>();
    public static ThreadLocal<String> browsers = new ThreadLocal<>();

    /**
     * this method returns the threadlocal webDriver
     *
     * @return WebDriver
     */
    public static WebDriver getDriver() {

   /*     if (browsers.get() == null) {
            browsers.set("firefox");
        }*/

        if (drivers.get() == null) {
            //  switch (browsers.get()) {
            //   case "firefox":
            WebDriverManager.firefoxdriver().setup();
            drivers.set(new FirefoxDriver());

            //  break;
/*
                case "edge":
                case "msedge":
                    WebDriverManager.edgedriver().setup();
                    drivers.set(new EdgeDriver());
                    break;
                case "opera":
                    WebDriverManager.operadriver().setup();
                    drivers.set(new OperaDriver());
                    break;
                   default:

                    WebDriverManager.firefoxdriver().setup();
                    drivers.set(new FirefoxDriver());
                    break;

                   WebDriverManager.chromedriver().setup();
                    drivers.set(new ChromeDriver());
                    break;*/
            // }

            //  }



        }return drivers.get();
    }
    /**
     * quit the threadLocal WebDriver
     */
    public static void quitDriver () {
        if (drivers.get() != null) {
            drivers.get().quit();
            drivers.set(null);
        }
    }

}
