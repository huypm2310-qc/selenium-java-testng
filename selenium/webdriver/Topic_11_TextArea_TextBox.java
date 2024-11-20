package webdriver;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.Random;

public class Topic_11_TextArea_TextBox {
    WebDriver driver;

    @BeforeClass
    public void beforeClass(){
        driver = new FirefoxDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        driver.manage().window().maximize();
    }


    @Test
    public void TC_01_TechPanda() {
        driver.get("http://live.techpanda.org/");

        driver.findElement(By.cssSelector("div.footer a[title='My Account']")).click();

        driver.findElement(By.cssSelector("a[title='Create an Account']")).click();

        String firstName = "Donald";
        String lastName = "Trump";
        String fullName = firstName + " " + lastName;
        String email = "donaldtrump" + new Random().nextInt(99999) + "@gmail.com";
        String password = "1234567";
        String throughReview = "Best Phone\nBest Provider\nBest Product";
        String summaryReview = "Hot Phones";
        String nickName = "US President";

        driver.findElement(By.id("firstname")).sendKeys(firstName);
        driver.findElement(By.id("lastname")).sendKeys(lastName);
        driver.findElement(By.id("email_address")).sendKeys(email);
        driver.findElement(By.id("password")).sendKeys(password);
        driver.findElement(By.id("confirmation")).sendKeys(password);

        driver.findElement(By.cssSelector("button[title='Register']")).click();

        Assert.assertEquals(driver.findElement(By.cssSelector("li.success-msg span")).getText(),
                "Thank you for registering with Main Website Store.");

        String contactInformation = driver.findElement(By.xpath("//h3[text()='Contact Information']/parent::div/following-sibling::div/p")).getText();

        Assert.assertTrue(contactInformation.contains(fullName));
        Assert.assertTrue(contactInformation.contains(email));

        driver.findElement(By.xpath("//a[text()='Mobile']")).click();
        driver.findElement(By.xpath("//a[text()='Samsung Galaxy']")).click();
        driver.findElement(By.xpath("//a[text()='Add Your Review']")).click();

        driver.findElement(By.cssSelector("input[id='Quality 1_5']")).click();
        driver.findElement(By.cssSelector("textarea[id='review_field']")).sendKeys(throughReview);
        driver.findElement(By.cssSelector("input[id='summary_field']")).sendKeys(summaryReview);
        driver.findElement(By.cssSelector("input[id='nickname_field']")).clear();
        driver.findElement(By.cssSelector("input[id='nickname_field']")).sendKeys(nickName);
        driver.findElement(By.cssSelector("button[title='Submit Review']")).click();
        Assert.assertEquals(driver.findElement(By.cssSelector("li.success-msg span")).getText(),
                "Your review has been accepted for moderation.");

    }

    @Test
    public void TC_02_OrangeHRM() throws InterruptedException {
        driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");

        String firstName = "Olivia";
        String lastName = "Davis";
        String username = "olivia" + new Random().nextInt(99999);
        String password = "Olivia!123";
        String passpostNumber = "1111-2222-3333-4444";
        String passpostComment = "Automation FC\n Best Tour";

        driver.findElement(By.cssSelector("input[name='username']")).sendKeys("Admin");
        driver.findElement(By.cssSelector("input[name='password']")).sendKeys("admin123");
        driver.findElement(By.cssSelector("button.orangehrm-login-button")).click();
        Thread.sleep(4000);

        driver.findElement(By.xpath("//span[text()='PIM']")).click();
        Thread.sleep(4000);

        driver.findElement(By.xpath("//a[text()='Add Employee']")).click();
        Thread.sleep(4000);

        driver.findElement(By.cssSelector("input[name='firstName']")).sendKeys(firstName);
        driver.findElement(By.cssSelector("input[name='lastName']")).sendKeys(lastName);
        String employeeID = driver.findElement(By.xpath(
                "//label[text()='Employee Id']/parent::div/following-sibling::div/input"))
                .getAttribute("value");

        driver.findElement(By.xpath("//p[text()='Create Login Details']/following-sibling::div//label")).click();
        Thread.sleep(2000);

        driver.findElement(By.xpath("//label[text()='Username']/parent::div/following-sibling::div//input"))
                .sendKeys(username);
        driver.findElement(By.xpath("//label[text()='Password']/parent::div/following-sibling::div//input"))
                .sendKeys(password);
        driver.findElement(By.xpath("//label[text()='Confirm Password']/parent::div/following-sibling::div//input"))
                .sendKeys(password);
        driver.findElement(By.xpath("//button[contains(string(),'Save')]")).click();
        Thread.sleep(8000);

        Assert.assertEquals(driver.findElement(By.cssSelector("input[name='firstName']")).getAttribute("value"),firstName);
        Assert.assertEquals(driver.findElement(By.cssSelector("input[name='lastName']")).getAttribute("value"),lastName);
        Assert.assertEquals(driver.findElement(By.xpath("//label[text()='Employee Id']/parent::div/following-sibling::div/input"))
                .getAttribute("value"),employeeID);
        Assert.assertTrue(driver.findElement(By.xpath("//label[text()='Employee Id']/parent::div/following-sibling::div/input")).isEnabled());


        driver.findElement(By.xpath("//a[text()='Immigration']")).click();
        Thread.sleep(2000);

        driver.findElement(By.xpath("//h6[text()='Assigned Immigration Records']/following-sibling::button[contains(string(),'Add')]")).click();

        driver.findElement(By.xpath("//label[text()='Number']/parent::div/following-sibling::div//input"))
                .sendKeys(passpostNumber);
        driver.findElement(By.xpath("//label[text()='Comments']/parent::div/following-sibling::div//textarea"))
                .sendKeys(passpostComment);
        driver.findElement(By.xpath("//button[contains(string(),'Save')]")).click();
        Thread.sleep(4000);

        driver.findElement(By.cssSelector("i[class='oxd-icon bi-pencil-fill']")).click();
        Thread.sleep(4000);

        Assert.assertEquals(driver.findElement(By.xpath("//label[text()='Number']/parent::div/following-sibling::div//input"))
                .getAttribute("value"),passpostNumber);
        Assert.assertEquals(driver.findElement(By.xpath("//label[text()='Comments']/parent::div/following-sibling::div//textarea"))
                .getAttribute("value"),passpostComment);

        driver.findElement(By.cssSelector("p.oxd-userdropdown-name")).click();
        Thread.sleep(2000);

        driver.findElement(By.xpath("//a[text()='Logout']")).click();
        Thread.sleep(5000);

        driver.findElement(By.cssSelector("input[name='username']")).sendKeys(username);
        driver.findElement(By.cssSelector("input[name='password']")).sendKeys(password);
        driver.findElement(By.cssSelector("button.orangehrm-login-button")).click();
        Thread.sleep(5000);

        driver.findElement(By.xpath("//span[text()='My Info']")).click();
        Thread.sleep(2000);

        Assert.assertEquals(driver.findElement(By.cssSelector("input[name='firstName']")).getAttribute("value"),firstName);
        Assert.assertEquals(driver.findElement(By.cssSelector("input[name='lastName']")).getAttribute("value"),lastName);
        Assert.assertEquals(driver.findElement(By.xpath("//label[text()='Employee Id']/parent::div/following-sibling::div/input"))
                .getAttribute("value"),employeeID);

        Assert.assertFalse(driver.findElement(By.xpath("//label[text()='Employee Id']/parent::div/following-sibling::div/input")).isEnabled());

        driver.findElement(By.xpath("//a[text()='Immigration']")).click();
        Thread.sleep(2000);
        driver.findElement(By.cssSelector("i[class='oxd-icon bi-pencil-fill']")).click();
        Thread.sleep(4000);
        Assert.assertEquals(driver.findElement(By.xpath("//label[text()='Number']/parent::div/following-sibling::div//input"))
                .getAttribute("value"),passpostNumber);
        Assert.assertEquals(driver.findElement(By.xpath("//label[text()='Comments']/parent::div/following-sibling::div//textarea"))
                .getAttribute("value"),passpostComment);




    }

    @AfterClass
    public  void afterClass() {
        driver.quit();
    }
}
