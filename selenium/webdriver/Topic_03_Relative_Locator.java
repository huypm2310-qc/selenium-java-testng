package webdriver;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.locators.RelativeLocator;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.time.Duration;

public class Topic_03_Relative_Locator {
    WebDriver driver;

    @BeforeClass
    public void beforeClass(){
        driver = new FirefoxDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
    }


    @Test
    public void TC_01_Relative_Locator() {
        driver.get("http://live.techpanda.org/index.php/catalogsearch/advanced/");
        WebElement priceFromElement =  driver.findElement(RelativeLocator.with(By.tagName("input"))
                .toLeftOf(By.name("price[to]"))
                .below(By.id("sku"))
                .above(By.id("tax_class_id")));

        //System.out.println(priceFromElement);
        priceFromElement.sendKeys("100");

    }

    @Test
    public void TC_02_() {
        driver = new ChromeDriver();
        driver.get("https://www.facebook.com/");
        driver.quit();
    }

    @AfterClass
    public  void afterClass() {
        //driver.quit();
    }
}