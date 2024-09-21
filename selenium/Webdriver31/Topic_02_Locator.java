package Webdriver31;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
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
        driver.get("https://alada.vn/tai-khoan/dang-ky.html");
        driver.findElement(By.id("txtSearch"));
    }

    @Test
    public void TC_02_Class() {
        driver.get("https://alada.vn/tai-khoan/dang-ky.html");
        driver.findElement(By.className("box-search"));
        driver.findElement(By.className("login"));
    }

    @Test
    public void TC_03_Name() {
        driver.get("https://alada.vn/tai-khoan/dang-ky.html");
        driver.findElement(By.name("txtFirstname"));
        driver.findElement(By.name("txtEmail"));
        driver.findElement(By.name("txtCEmail"));
        driver.findElement(By.name("txtPassword"));
        driver.findElement(By.name("txtCPassword"));
        driver.findElement(By.name("txtPhone"));
    }

    @Test
    public void TC_04_Link() {
        driver.get("https://alada.vn/tai-khoan/dang-ky.html");
        // Chỉ dùng được với link có text (Text o tren UI - Khong phai text duoi HTML)
        // Truyen het ca chuoi text vao
        driver.findElement(By.linkText("Đăng Ký"));
    }

    @Test
    public void TC_05_Partial_link() {
        driver.get("https://alada.vn/tai-khoan/dang-ky.html");
        // Chỉ dùng được với link có text
        // Truyen het ca chuoi text vao cung chay duoc
        // Truyen 1 phan chuoi cung chay duoc
        driver.findElement(By.partialLinkText("Chính sách bảo mật"));
        driver.findElement(By.partialLinkText("bảo mật"));
    }

    @Test
    public void TC_06_TagName() {
        driver.get("https://alada.vn/tai-khoan/dang-ky.html");
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
        driver.get("https://alada.vn/tai-khoan/dang-ky.html");

        // CSS vs ID
        driver.findElement(By.cssSelector("input[id='txtSearch']"));
        driver.findElement(By.cssSelector("#txtSearch"));
        driver.findElement(By.cssSelector("input#txtSearch"));

        //CSS vs Class
        driver.findElement(By.cssSelector("div[class='box-search']"));
        driver.findElement(By.cssSelector("div.box-search"));
        driver.findElement(By.cssSelector(".box-search"));

//        //Ngoai le
//        driver.findElement(By.cssSelector("input[class='input-text validate-email required-entry']"));
//        driver.findElement(By.cssSelector("input.validate-email.input-text.required-entry"));
//        driver.findElement(By.cssSelector("input.input-text.required-entry"));
//        driver.findElement(By.cssSelector("input.required-entry"));

        //CSS vs Name
        driver.findElement(By.cssSelector("input[name='txtFirstname']"));
        driver.findElement(By.cssSelector("input[name='txtEmail']"));
        driver.findElement(By.cssSelector("input[name='txtPassword']"));

        //CSS vs Link
        //Css khong the dung duoc voi text
        driver.findElement(By.cssSelector("a[href='https://alada.vn/tai-khoan/dang-ky.html']"));


        //CSS bs partial link
        driver.findElement(By.cssSelector("a[href^='https://alada.vn/tai-khoan/dang-ky.html']"));
        driver.findElement(By.cssSelector("a[href*='alada.vn/tai-khoan/']"));
        driver.findElement(By.cssSelector("a[href$='dang-ky.html']"));

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
        driver.get("https://alada.vn/tai-khoan/dang-ky.html");

        //Xpath vs ID
        driver.findElement(By.xpath("//input[@id='txtSearch']"));

        //Xpath vs Class
        driver.findElement(By.xpath("//div[@class='box-search']"));

        //Xpath vs Name
        driver.findElement(By.xpath("//input[@name='txtFirstname']"));

        //Xpath vs Link
        driver.findElement(By.xpath("//a[@href='https://alada.vn/tai-khoan/dang-ky.html']"));
        driver.findElement(By.xpath("//a[text()='Giới thiệu']"));

        //Xpath vs Partial Link
        driver.findElement(By.xpath("//a[starts-with(@href,'https://alada.vn/tai-khoan/dang-ky.html')]"));
        driver.findElement(By.xpath("//a[contains(@href,'dang-ky.html')]"));
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
