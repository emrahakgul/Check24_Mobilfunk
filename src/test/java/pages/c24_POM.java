package pages;


import org.openqa.selenium.By;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;


import org.openqa.selenium.support.ui.Select;
import utilities.ParentClass;

import java.util.ArrayList;
import java.util.List;

public class c24_POM extends ParentClass {

    By acceptCookies = By.xpath("(//a[@class='c24-cookie-consent-button'])[1]");
    By navTabsHPage = By.xpath("//div[@class='c24-nav-hz clearfix']/div/a");
    By submitButton = By.xpath("//button[@class='button c24-global-button-primary ng-tns-c89-1']");
    By dataVolume = By.xpath("//select[@id='data_included']");
    By minutesInk = By.xpath("//select[@id='minutes_included']");
    By laufzeit = By.xpath("//select[@id='select_contract']");
    By handyHnzfgn = By.xpath("//a[@class='change-to-bundle-link']");
    By iphone10Pro = By.xpath("//a[@class='link ng-star-inserted']");
    By sortierenPreisMonat = By.xpath("(//div[@class='label'])[5]");

    By leftLabelTelekom = By.xpath("(//input[@class='input checked'])[1]");
    By leftLabelO2 = By.xpath("(//input[@class='input checked'])[3]");
    By leftLabel30GB = By.xpath("(//*[@class='value-label col-3 _internal_tooltip_disabled_ _internal_tooltip_applied_ ng-star-inserted'])[8]");
    By leftLabel10 = By.xpath("(//*[@class='value-label col-3 _internal_tooltip_disabled_ _internal_tooltip_applied_ ng-star-inserted'])[11]");
    By backToTop = By.xpath("(//div[@class='label'])[10]");


    List<WebElement> c24NavTabs;
    List<WebElement> tariffPriceList;
  //  List<WebElement> handyList;

    Actions buiilder = new Actions(driver);

    public void navigateToHomePage(String url) {
        driver.manage().window().maximize();
        driver.get(url);
        driver.manage().deleteAllCookies();
        //clickTo(acceptButton);
        waiting(1000);
        clickTo(acceptCookies);
    }

    public void goToHandyPage() {
        c24NavTabs = getElements(navTabsHPage);

        for (WebElement tabElement : c24NavTabs
        ) {
            buiilder.moveToElement(tabElement).perform();
            waiting(500);

            if (tabElement.getAttribute("title").equalsIgnoreCase("handy")) {
                System.out.println(tabElement.getAttribute("title"));
                tabElement.click();

                waiting(2000);
                break;
            }
        }
    }


    public void selectT(By by, String value) {
        Select select = new Select(driver.findElement(by));
        select.selectByValue(value);
    }


    public void selectTariffFeatures() {

        selectT(dataVolume, "11: 9999000");
        waiting(1000);
        selectT(minutesInk, "5: -1");
        waiting(1000);
        selectT(laufzeit, "0: -24");
        waiting(1000);

        clickTo(submitButton);
        waiting(5000);
    }

    public void addAMobilePhone()
    {



        clickTo(handyHnzfgn);
waiting(3000);

clickTo(iphone10Pro);
waiting(4000);

clickTo(sortierenPreisMonat);
waiting(4000);
        }

        public void checkTheTariffs()
        {
          //  By backToTop = By.xpath("(//div[@class='label'])[10]");
            By tarifPreis = By.xpath("//*[@class='price-container']/dd");
            tariffPriceList=getElements(tarifPreis);




            clickTo(leftLabel30GB);waiting(2000);
            clickTo(leftLabel10);waiting(5000);




            int size=5;  //tariffPriceList.size();

            for (int i = 0; i <size ; i++) {



                List<WebElement> listingWebElementListInLoop = driver.findElements(By.xpath("//*[@class='price-container']/dd"));
                String preises=listingWebElementListInLoop.get(i).getText();

               int price=Integer.parseInt(preises.substring(0, 1));

            }
        }
        }


