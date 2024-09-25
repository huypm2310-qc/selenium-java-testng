package Webdriver31;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
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
    public void TC_01_() {
        driver.get("https://demo.nopcommerce.com/register?returnUrl=%2F");

        // Gender radio button
        driver.findElement(By.xpath("//div[@id='gender']"));

        // First name field
        driver.findElement(By.xpath("//input[@id='FirstName']"));

        //Last name field
        driver.findElement(By.xpath("//input[@id='LastName']"));

        // Day of birth field
        driver.findElement(By.xpath("//select[@name='DateOfBirthDay']"));

        // Email field
        driver.findElement(By.xpath("//input[@id='Email']"));

        // Company name field
        driver.findElement(By.xpath("//input[@id='Company']"));

        // Newsletter checkbox
        driver.findElement(By.xpath("//input[@id='Newsletter']"));

        // Password field
        driver.findElement(By.xpath("//input[@id='Password']"));

        // Confirm password field
        driver.findElement(By.xpath("//input[@id='ConfirmPassword']"));

        // Register button
        driver.findElement(By.xpath("//button[@id='register-button']"));

    }

    @AfterClass
    public  void afterClass() {
        driver.quit();
    }
}
