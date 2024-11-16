package webdriver;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.Random;

public class Topic_11_TextArea {
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
    public void TC_02_() {
    }

    @AfterClass
    public  void afterClass() {
        driver.quit();
    }
}
