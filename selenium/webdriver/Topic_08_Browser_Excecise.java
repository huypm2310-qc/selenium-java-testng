package webdriver;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.time.Duration;

public class Topic_08_Browser_Excecise {
    WebDriver driver;

    @BeforeClass
    public void beforeClass(){
        driver = new FirefoxDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
    }


    @Test
    public void TC_01_Page_Url() {
        driver.get("https://live.techpanda.org/");

        // Click vào My Account tại Footer
        driver.findElement(By.cssSelector("div.footer a[title='My Account']")).click();

        //Khi viết code xong và muốn chạy 1 Test Class / Test Case nào đó thì bắt buộc tất cả các class trong project
        //Không còn lỗi (báo đỏ)
        //Bắt đầu ở đâu thì kết thúc ở đó
        //Không thừa / thiếu các ký tự
        // Hàm được gọi ra đúng vị trí

        // Kiểm tra actual và expected bằng nhau
        Assert.assertEquals(driver.getCurrentUrl(),"https://live.techpanda.org/index.php/customer/account/login/");

        // Click qua trang Register
        driver.findElement(By.xpath("//a[@title='Create an Account']")).click();

        Assert.assertEquals(driver.getCurrentUrl(),"https://live.techpanda.org/index.php/customer/account/create/");

    }

    @Test
    public void TC_02_Page_Title() {
        //Truy cập vào trang
        driver.get("https://live.techpanda.org/");

        //Click MY ACCOUNT link tại footer
        driver.findElement(By.cssSelector("div.footer a[title='My Account']")).click();

        //Verify title của login Page = Customer Login
        Assert.assertEquals(driver.getTitle(),"Customer Login");

        //Click CREATE AN ACCOUNT button
        driver.findElement(By.xpath("//a[@title='Create an Account']")).click();

        //Verify title của Register page
        Assert.assertEquals(driver.getTitle(),"Create New Customer Account");

    }

    @Test
    public void TC_03_Naviagation() {
        //Truy cập vào trang
        driver.get("https://live.techpanda.org/");

        //Click MY ACCOUNT link tại footer
        driver.findElement(By.cssSelector("div.footer a[title='My Account']")).click();

        //Click CREATE AN ACCOUNT button
        driver.findElement(By.xpath("//a[@title='Create an Account']")).click();

        //Verify URL của Register page
        Assert.assertEquals(driver.getCurrentUrl(),"https://live.techpanda.org/index.php/customer/account/create/");

        //Back lại trang Login page
        driver.navigate().back();

        //Verify URL của Login page
        Assert.assertEquals(driver.getCurrentUrl(),"https://live.techpanda.org/index.php/customer/account/login/");


        //Forward tới trang Register Page
        driver.navigate().forward();

        //Verify title của Register page
        Assert.assertEquals(driver.getTitle(),"Create New Customer Account");
    }

    @Test
    public void TC_04_Page_Source() {
        //Truy cập vào trang
        driver.get("https://live.techpanda.org/");

        //Click MY ACCOUNT link tại footer
        driver.findElement(By.cssSelector("div.footer a[title='My Account']")).click();

        //Verify Login Page  chứa text : Login or Create an Account
        //Tuyệt đối  = nhau
        //Assert.assertEquals(driver.getTitle(),"Customer Login");
        //Tương đối
        Assert.assertTrue(driver.getPageSource().contains("Login or Create an Account"));

        //Click CREATE AN ACCOUNT button
        driver.findElement(By.xpath("//a[@title='Create an Account']")).click();

        //Verify Register Page  chứa text :Create an Account
        Assert.assertTrue(driver.getPageSource().contains("Create an Account"));
    }

    @AfterClass
    public  void afterClass() {
        driver.quit();
    }
}
