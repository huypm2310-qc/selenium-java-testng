package webdriver;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.time.Duration;

public class Topic_05_Xpath_Tech {
    WebDriver driver;

    @BeforeClass
    public void beforeClass(){
        driver = new FirefoxDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
    }


    @Test
    public void TC_01_() {
        driver.get("http://live.techpanda.org/index.php/mobile.html");

        // text()= -> Lay text tuyet doi, khong co khoang trang/ xuong dong / tab o dau hoac cuoi chuoi
        driver.findElement(By.xpath("//h1[text()='Mobile']"));

        //contains(text(),'') -> text nam o tren chinh node chua no nhung text phai nam o index dau tien
        driver.findElement(By.xpath("//h5[contains(text(),'Michael Jackson')]"));

        //contains(.,'') ~ -> contains(string(),'') - > text nam o tre chinh node do hoac nam trong child node o bat ky vi tri nao
        // hoac nested text o bat ky vi tri nao
        driver.findElement(By.xpath("//p[contains(string(),'If you have an account with us')]"));
        driver.findElement(By.xpath("//p[contains(.,'If you have an account with us')]"));

        //concat() - > text vua chua dau nhay don - vua chua dau nhay doi
        // nhay don boc nhay doi - nhay doi boc nhay don
        driver.findElement(By.xpath("//span[text()=concat('Hello \"John\", What',\"'s happened?\")]"));


        // AND - Tuyet doi : Ca hai deu phai dung - > Dung, chi can 1 cai sai - > SAI
        // OR - Tuong doi : Ca hai deu sai - > SAI, chi can 1 cai dung - > DUNG
        driver.findElement(By.xpath("//input[@type='email' and @id='email']"));
        driver.findElement(By.xpath("//input[@type='login' or @id='email']"));

        // NOT : phu dinh lai dieu kien, dung khi chi co 2 cai
        // NOT(dieu kien dung) - > SAI
        // NOT (dieu kien sai) - > DUNG
        driver.findElement(By.xpath("//div[not(@style='display:none;')]/div[@class='raDiv']"));

        //Inside parent : khi cac element ngang hang nhau va nam trong cung 1 the cha
        driver.findElement(By.xpath("//ol[@id='selectable']/li[20]"));

        // position()
        driver.findElement(By.xpath("//ol[@id='selectable']/li[position()=20]"));

        //Outside parent : khi cac element ngang hang nhau va khong nam trong cung 1 the cha
        //Lay element cuoi cung
        driver.findElement(By.xpath("(//span[text()='Add to Cart'])[3]"));

        //Last() - Thao tac voi implement cuoi cung
        driver.findElement(By.xpath("//ol[@id='selectable']/li[last()]"));

        //Gan ke last :
        driver.findElement(By.xpath("//ol[@id='selectable']/li[count(//li)-1]"));

        // Lay implement cuoi cung su dung ham count():
        driver.findElement(By.xpath("//ol[@id='selectable']/li[count(//li)]"));

    }
    @AfterClass
    public void afterClass() {
        //driver.quit();
    }
}
