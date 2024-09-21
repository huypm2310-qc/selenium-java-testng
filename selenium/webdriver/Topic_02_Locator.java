package webdriver;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.time.Duration;

public class Topic_02_Locator {
    WebDriver driver;

    @BeforeClass
    public void beforeClass(){
        driver = new FirefoxDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
    }


    @Test
    public void TC_01_ID() {
        driver.get("http://live.techpanda.org/index.php/customer/account/create/");
        driver.findElement(By.id("search")).sendKeys("Samsung");
        driver.findElement(By.id("firstname")).sendKeys("Nguyen");
    }

    @Test
    public void TC_02_Class() {
        driver.get("http://live.techpanda.org/index.php/customer/account/create/");
        driver.findElement(By.className("header-language-background"));
        driver.findElement(By.className("header-language-container"));
    }

    @Test
    public void TC_03_Name() {
        driver.get("http://live.techpanda.org/index.php/customer/account/create/");
        driver.findElement(By.name("q"));
        driver.findElement(By.name("firstname"));
        driver.findElement(By.name("lastname"));
        driver.findElement(By.name("email"));
        //driver.findElement(By.name("abcdef"));
    }

    @Test
    public void TC_04_Link() {
        driver.get("http://live.techpanda.org/index.php/customer/account/create/");
        // Chỉ dùng được với link có text (Text o tren UI - Khong phai text duoi HTML)
        // Truyen het ca chuoi text vao
        driver.findElement(By.linkText("ABOUT US"));
        driver.findElement(By.linkText("CUSTOMER SERVICE"));
        driver.findElement(By.linkText("ORDERS AND RETURNS"));
    }

    @Test
    public void TC_05_Partial_link() {
        driver.get("http://live.techpanda.org/index.php/customer/account/create/");
        // Chỉ dùng được với link có text
        // Truyen het ca chuoi text vao cung chay duoc
        // Truyen 1 phan chuoi cung chay duoc
        driver.findElement(By.partialLinkText("ABOUT US"));
        driver.findElement(By.partialLinkText("ABOUT"));
        driver.findElement(By.partialLinkText("CUSTOMER"));
        driver.findElement(By.partialLinkText("SERVICE"));
        driver.findElement(By.partialLinkText("ORDERS AND"));
    }

    @Test
    public void TC_06_TagName() {
        driver.get("http://live.techpanda.org/index.php/customer/account/create/");
        // Tim nhieu implement giong nhau
        int linkNumber =  driver.findElements(By.tagName("a")).size();
        System.out.println("Tong so luong link = " + linkNumber);

        //Tagname giong nhau - elemen khac nhau
        //The input: textbox/ checkbox/ radio/ button/ upload file/ slider/..
    }

    @Test
    public void TC_07_Css() {
        /**
         * Css:
         * tagname[attribute='value']
         */
        driver.get("http://live.techpanda.org/index.php/customer/account/create/");

        // CSS vs ID
        driver.findElement(By.cssSelector("input[id='search']"));
        driver.findElement(By.cssSelector("#search"));
        driver.findElement(By.cssSelector("input#search"));

        driver.findElement(By.cssSelector("input[id='email_address']"));
        driver.findElement(By.cssSelector("#email_address"));
        driver.findElement(By.cssSelector("input#email_address"));

        //CSS vs Class
        driver.findElement(By.cssSelector("div[class='header-language-background']"));
        driver.findElement(By.cssSelector("div.header-language-background"));
        driver.findElement(By.cssSelector(".header-language-background"));

        //Ngoai le
        driver.findElement(By.cssSelector("input[class='input-text validate-email required-entry']"));
        driver.findElement(By.cssSelector("input.validate-email.input-text.required-entry"));
        driver.findElement(By.cssSelector("input.input-text.required-entry"));
        driver.findElement(By.cssSelector("input.required-entry"));

        //CSS vs Name
        //driver.get("http://live.techpanda.org/index.php/customer/account/create/");
        driver.findElement(By.cssSelector("input[name='password']"));
        driver.findElement(By.cssSelector("input[name='confirmation']"));
        driver.findElement(By.cssSelector("input[name='q']"));

        //CSS vs Link
        //Css khong the dung duojc voi text
        driver.findElement(By.cssSelector("a[href='http://live.techpanda.org/index.php/about-magento-demo-store/']"));


        //CSS bs partial link
        driver.findElement(By.cssSelector("a[href^='http://live.techpanda.org/index.php']"));
        driver.findElement(By.cssSelector("a[href*='org/index.php/about-magento-demo-store/']"));
        driver.findElement(By.cssSelector("a[href$='about-magento-demo-store/']"));

        //Css vs tagname
        int linkNumber =  driver.findElements(By.cssSelector("a")).size();
        System.out.println("Tong so luong link = " + linkNumber);

    }

    @Test
    public void TC_08_Xpath() {
        /**
         * Xpath:
         * //tagname[@attribute='value']
         */
        driver.get("http://live.techpanda.org/index.php/customer/account/create/");

        //Xpath vs ID
        driver.findElement(By.xpath("//input[@id='search']"));

        //Xpath vs Class
        driver.findElement(By.xpath("//div[@class='header-language-background']"));

        //Xpath vs Name
        driver.findElement(By.xpath("//input[@name='password']"));

        //Xpath vs Link
        driver.findElement(By.xpath("//a[@href='http://live.techpanda.org/index.php/about-magento-demo-store/']"));
        driver.findElement(By.xpath("//a[text()='About Us']"));

        //Xpath vs Partial Link
        driver.findElement(By.xpath("//a[starts-with(@href,'http://live.techpanda.org/index.php')]"));
        driver.findElement(By.xpath("//a[contains(@href,'org/index.php/about-magento')]"));
        //Xpath khong support end-with
        //Css co end with nhung xpath khong co ends-with
        //driver.findElement(By.cssSelector("a[ends-with(@href,'org/index.php/about-magento')]"));


        //Xpath vs Tagname
        int linkNumber =  driver.findElements(By.xpath("//a")).size();
        System.out.println("Tong so luong link = " + linkNumber);

    }

    @AfterClass
    public  void afterClass() {
        driver.quit();
    }
}
