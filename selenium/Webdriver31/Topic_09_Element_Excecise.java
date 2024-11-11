package Webdriver31;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.time.Duration;

public class Topic_09_Element_Excecise {
    WebDriver driver;

    @BeforeClass
    public void beforeClass(){
        driver = new FirefoxDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        driver.manage().window().maximize();
    }

    // Kiểm tra 1 element có hiển thị hay không?
    // Áp dụng cho tất cả các loại element
    // element.isDisplayed();

    // Kiểm tra 1 element đã được chọn hay chưa?
    // Áp dụng cho Checkbox/ Radio / Dropdown
    // element.isSelected();

    // Kiểm tra 1 element có cho phép thao tác lên hay không?
    // Cho phép sửa dữ liệu
    // true = được phép chỉnh sửa / thao tác
    // false =  bị disabled
    // Test tính năng phân quyền
    // element.isEnabled();

    @Test
    public void TC_01_Displayed() {
        // Displayed # Undisplayed
        // Người dùng có thể nhìn thấy (Có kích thuước cụ thể)
        driver.get("https://automationfc.github.io/basic-form/index.html");

        if(driver.findElement(By.cssSelector("input[id='mail']")).isDisplayed()){
            driver.findElement(By.cssSelector("input[id='mail']")).sendKeys("Automation Testing");
            System.out.println(" Email textbox is displayed");
        }else {
            System.out.println(" Email textbox is not displayed");
        }

        if(driver.findElement(By.cssSelector("textarea[id='edu']")).isDisplayed()){
            driver.findElement(By.cssSelector("textarea[id='edu']")).sendKeys("Automation Testing");
            System.out.println(" Education textbox is displayed");
        }else {
            System.out.println(" Education textbox is not displayed");
        }

        if(driver.findElement(By.cssSelector("input#under_18")).isDisplayed()){
            driver.findElement(By.cssSelector("input#under_18")).click();
            System.out.println(" Age Under 18 radio button is displayed");
        }else {
            System.out.println(" Age Under 18 radio button is not displayed");
        }

        if(driver.findElement(By.xpath("//h5[text()='Name: User5']")).isDisplayed()){
            driver.findElement(By.xpath("//h5[text()='Name: User5']/following-sibling::a")).click();
            System.out.println(" Name User 5 text is displayed");
        }else {
            System.out.println(" Name User 5 text is not displayed");
        }
    }

    @Test
    public void TC_02_Selected() {
        // Selected # Deselected
        // Kiểm tra xem mình chọn rồi thì nó đã được hay chưa?
        driver.get("https://automationfc.github.io/basic-form/index.html");

        // Click chọn
        driver.findElement(By.cssSelector("input#under_18")).click();
        driver.findElement(By.cssSelector("input#java")).click();

        if (driver.findElement(By.cssSelector("input#under_18")).isSelected()) {
            System.out.println("Under 18 radio is selected");
        }else{
            System.out.println("Under 18 radio is not selected");
        }

        if (driver.findElement(By.cssSelector("input#java")).isSelected()) {
            System.out.println("Java checkbox is selected");
        }else{
            System.out.println("Java checkbox is not selected");
        }

        // Click chọn
        driver.findElement(By.cssSelector("input#under_18")).click();
        driver.findElement(By.cssSelector("input#java")).click();

        if (driver.findElement(By.cssSelector("input#under_18")).isSelected()) {
            System.out.println("Under 18 radio is selected");
        }else{
            System.out.println("Under 18 radio is not selected");
        }

        if (driver.findElement(By.cssSelector("input#java")).isSelected()) {
            System.out.println("Java checkbox is selected");
        }else{
            System.out.println("Java checkbox is not selected");
        }


    }

    @Test
    public void TC_03_Enabled() {
        // Enabled # Disabled
        driver.get("https://automationfc.github.io/basic-form/index.html");
        if (driver.findElement(By.cssSelector("input#mail")).isEnabled()) {
            System.out.println("Email textbox is enabled");
        }else{
            System.out.println("Email textbox is disabled");
        }

        if (driver.findElement(By.cssSelector("input#disable_password")).isEnabled()) {
            System.out.println("Password textbox is enabled");
        }else{
            System.out.println("Password textbox is disabled");
        }

        if (driver.findElement(By.cssSelector("input#slider-2")).isEnabled()) {
            System.out.println("Slider bar is enabled");
        }else{
            System.out.println("Slider bar is disabled");
        }
    }

    @Test
    public void TC_04_MailChimp_Validate() throws InterruptedException {
        // Email Marketing
        driver.get("https://login.mailchimp.com/signup/");

        By signupButton = By.cssSelector("button#create-account-enabled");

        driver.findElement(By.cssSelector("input#email")).sendKeys("automationtesting@gmail.net");
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", driver.findElement(signupButton));
        driver.findElement(signupButton).click();
        Thread.sleep(3000);

        // Empty
        Assert.assertTrue(driver.findElement(By.cssSelector("li[class='lowercase-char not-completed']")).isDisplayed());
        Assert.assertTrue(driver.findElement(By.cssSelector("li[class='uppercase-char not-completed']")).isDisplayed());
        Assert.assertTrue(driver.findElement(By.cssSelector("li[class='number-char not-completed']")).isDisplayed());
        Assert.assertTrue(driver.findElement(By.cssSelector("li[class='special-char not-completed']")).isDisplayed());
        Assert.assertTrue(driver.findElement(By.cssSelector("li[class='8-char not-completed']")).isDisplayed());
        Assert.assertTrue(driver.findElement(By.cssSelector("li.username-check.not-completed")).isDisplayed());


        // Lowercase
        driver.findElement(By.cssSelector("input#new_password")).sendKeys("sele");
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", driver.findElement(signupButton));
        driver.findElement(signupButton).click();
        Thread.sleep(3000);

        Assert.assertTrue(driver.findElement(By.cssSelector("li[class='lowercase-char completed']")).isDisplayed());
        Assert.assertTrue(driver.findElement(By.cssSelector("li[class='uppercase-char not-completed']")).isDisplayed());
        Assert.assertTrue(driver.findElement(By.cssSelector("li[class='number-char not-completed']")).isDisplayed());
        Assert.assertTrue(driver.findElement(By.cssSelector("li[class='special-char not-completed']")).isDisplayed());
        Assert.assertTrue(driver.findElement(By.cssSelector("li[class='8-char not-completed']")).isDisplayed());
        Assert.assertTrue(driver.findElement(By.cssSelector("li.username-check.completed")).isDisplayed());

        // Uppercase
        driver.findElement(By.cssSelector("input#new_password")).clear();
        driver.findElement(By.cssSelector("input#new_password")).sendKeys("SELE");
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", driver.findElement(signupButton));
        driver.findElement(signupButton).click();
        Thread.sleep(3000);

        Assert.assertTrue(driver.findElement(By.cssSelector("li[class='lowercase-char not-completed']")).isDisplayed());
        Assert.assertTrue(driver.findElement(By.cssSelector("li[class='uppercase-char completed']")).isDisplayed());
        Assert.assertTrue(driver.findElement(By.cssSelector("li[class='number-char not-completed']")).isDisplayed());
        Assert.assertTrue(driver.findElement(By.cssSelector("li[class='special-char not-completed']")).isDisplayed());
        Assert.assertTrue(driver.findElement(By.cssSelector("li[class='8-char not-completed']")).isDisplayed());
        Assert.assertTrue(driver.findElement(By.cssSelector("li.username-check.completed")).isDisplayed());

        // Numbercase
        driver.findElement(By.cssSelector("input#new_password")).clear();
        driver.findElement(By.cssSelector("input#new_password")).sendKeys("123456");
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", driver.findElement(signupButton));
        driver.findElement(signupButton).click();
        Thread.sleep(3000);

        Assert.assertTrue(driver.findElement(By.cssSelector("li[class='lowercase-char not-completed']")).isDisplayed());
        Assert.assertTrue(driver.findElement(By.cssSelector("li[class='uppercase-char not-completed']")).isDisplayed());
        Assert.assertTrue(driver.findElement(By.cssSelector("li[class='number-char completed']")).isDisplayed());
        Assert.assertTrue(driver.findElement(By.cssSelector("li[class='special-char not-completed']")).isDisplayed());
        Assert.assertTrue(driver.findElement(By.cssSelector("li[class='8-char not-completed']")).isDisplayed());
        Assert.assertTrue(driver.findElement(By.cssSelector("li.username-check.completed")).isDisplayed());

        //Specialcase
        driver.findElement(By.cssSelector("input#new_password")).clear();
        driver.findElement(By.cssSelector("input#new_password")).sendKeys("!!@@##");
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", driver.findElement(signupButton));
        driver.findElement(signupButton).click();
        Thread.sleep(3000);

        Assert.assertTrue(driver.findElement(By.cssSelector("li[class='lowercase-char not-completed']")).isDisplayed());
        Assert.assertTrue(driver.findElement(By.cssSelector("li[class='uppercase-char not-completed']")).isDisplayed());
        Assert.assertTrue(driver.findElement(By.cssSelector("li[class='number-char not-completed']")).isDisplayed());
        Assert.assertTrue(driver.findElement(By.cssSelector("li[class='special-char completed']")).isDisplayed());
        Assert.assertTrue(driver.findElement(By.cssSelector("li[class='8-char not-completed']")).isDisplayed());
        Assert.assertTrue(driver.findElement(By.cssSelector("li.username-check.completed")).isDisplayed());


        //Username
        driver.findElement(By.cssSelector("input#new_password")).clear();
        driver.findElement(By.cssSelector("input#new_password")).sendKeys("auto");
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", driver.findElement(signupButton));
        driver.findElement(signupButton).click();
        Thread.sleep(3000);

        Assert.assertTrue(driver.findElement(By.cssSelector("li[class='lowercase-char completed']")).isDisplayed());
        Assert.assertTrue(driver.findElement(By.cssSelector("li[class='uppercase-char not-completed']")).isDisplayed());
        Assert.assertTrue(driver.findElement(By.cssSelector("li[class='number-char not-completed']")).isDisplayed());
        Assert.assertTrue(driver.findElement(By.cssSelector("li[class='special-char not-completed']")).isDisplayed());
        Assert.assertTrue(driver.findElement(By.cssSelector("li[class='8-char not-completed']")).isDisplayed());
        Assert.assertTrue(driver.findElement(By.cssSelector("li.username-check.not-completed")).isDisplayed());

        //8 characters
        driver.findElement(By.cssSelector("input#new_password")).clear();
        driver.findElement(By.cssSelector("input#new_password")).sendKeys("AUTOMATION");
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", driver.findElement(signupButton));
        driver.findElement(signupButton).click();
        Thread.sleep(3000);

        Assert.assertTrue(driver.findElement(By.cssSelector("li[class='lowercase-char not-completed']")).isDisplayed());
        Assert.assertTrue(driver.findElement(By.cssSelector("li[class='uppercase-char completed']")).isDisplayed());
        Assert.assertTrue(driver.findElement(By.cssSelector("li[class='number-char not-completed']")).isDisplayed());
        Assert.assertTrue(driver.findElement(By.cssSelector("li[class='special-char not-completed']")).isDisplayed());
        Assert.assertTrue(driver.findElement(By.cssSelector("li[class='8-char completed']")).isDisplayed());
        Assert.assertTrue(driver.findElement(By.cssSelector("li.username-check.not-completed")).isDisplayed());

        //Full
        driver.findElement(By.cssSelector("input#new_password")).clear();
        driver.findElement(By.cssSelector("input#new_password")).sendKeys("Selenium123!!!");
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", driver.findElement(signupButton));
        driver.findElement(signupButton).click();
        Thread.sleep(3000);

        Assert.assertFalse(driver.findElement(By.cssSelector("li[class='lowercase-char completed']")).isDisplayed());
        Assert.assertFalse(driver.findElement(By.cssSelector("li[class='uppercase-char completed']")).isDisplayed());
        Assert.assertFalse(driver.findElement(By.cssSelector("li[class='number-char completed']")).isDisplayed());
        Assert.assertFalse(driver.findElement(By.cssSelector("li[class='special-char completed']")).isDisplayed());
        Assert.assertFalse(driver.findElement(By.cssSelector("li[class='8-char completed']")).isDisplayed());


        Assert.assertFalse(driver.findElement(By.cssSelector("input#marketing_newsletter")).isSelected());

    }



    @AfterClass
    public  void afterClass() {
        //driver.quit();
    }
}
