package tests.day09;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class Homework2 {

    WebDriver driver;
    @BeforeMethod
    public void setup  () {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
    }

    @AfterMethod
    public void tearDown(){
        //  driver.close();
    }
    @Test
    public void test(){
        /*
        1. “http://zero.webappsecurity.com/” Adresine gidin
2. Sign in butonuna basin
3. Login kutusuna “username” yazin
4. Password kutusuna “password.” yazin
5. Sign in tusuna basin
6. Pay Bills sayfasina gidin
7. “Purchase Foreign Currency” tusuna basin
8. “Currency” drop down menusunden Eurozone’u secin
9. “amount” kutusuna bir sayi girin
10. “US Dollars” in secilmedigini test edin
11. “Selected currency” butonunu secin
12. “Calculate Costs” butonuna basin sonra “purchase” butonuna basin
13. “Foreign currency cash was successfully purchased.” yazisinin ciktigini
control edin
         */
        driver.get("http://zero.webappsecurity.com");
        driver.findElement(By.id("signin_button")).click();
        driver.findElement(By.id("user_login")).sendKeys("username");
        driver.findElement(By.id("user_password")).sendKeys("password");
        driver.findElement(By.xpath("//input[@type='submit']")).click();
        driver.findElement(By.id("primary-button")).click();
        driver.findElement(By.xpath("(//*[.='Online Banking'])[2]")).click();
        driver.findElement(By.id("pay_bills_link")).click();
        //7. “Purchase Foreign Currency” tusuna basin
        driver.findElement(By.xpath("//a[@href='#ui-tabs-3']")).click();

        WebElement acilirSecenekler = driver.findElement(By.xpath("//select[@id='pc_currency']"));
        Select option = new Select(acilirSecenekler);
        // 8. “Currency” drop down menusunden Eurozone’u secin
        option.selectByValue("EUR");
        // 9. “amount” kutusuna bir sayi girin
        WebElement amount = driver.findElement(By.xpath("//input[@id='pc_amount']"));
        amount.sendKeys("25000" );

        // 10. “US Dollars” in secilmedigini test edin
        WebElement dollars = driver.findElement(By.xpath("//input[@id='pc_inDollars_true']"));
        Assert.assertFalse(dollars.isSelected());

        //11. “Selected currency” butonunu secin
        WebElement selected = driver.findElement(By.xpath("(//label[@class='radio inline'])[3]"));
        selected.click();
        // 12. “Calculate Costs” butonuna basin sonra “purchase” butonuna basin
        driver.findElement(By.xpath("//input[@type='button']")).click();
        driver.findElement(By.xpath("(//input[@type='submit'])[2]")).click();
        //13. “Foreign currency cash was successfully purchased.” yazisinin ciktigini
        //control edin
        WebElement kayitYazisi = driver.findElement(By.xpath("//div[@id='alert_content']"));
        Assert.assertTrue(kayitYazisi.isDisplayed());
    }
}
