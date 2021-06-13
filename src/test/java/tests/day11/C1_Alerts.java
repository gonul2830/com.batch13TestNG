package tests.day11;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.TimeUnit;

import java.util.concurrent.TimeUnit;

public class C1_Alerts {
    /*
    ● Bir class olusturun: D12_Alerts
● https://the-internet.herokuapp.com/javascript_alerts adresine gidin.
● Bir metod olusturun: acceptAlert
 ○ 1. butona tıklayın, uyarıdaki OK butonuna tıklayın ve result mesajının “You successfuly clicked an alert” oldugunu test edin.
● Bir metod olusturun: dismissAlert
 ○ 2. butona tıklayın, uyarıdaki Cancel butonuna tıklayın ve result mesajının   “successfuly” icermedigini test edin.
● Bir metod olusturun: sendKeysAlert
 ○ 3. butona tıklayın, uyarıdaki metin kutusuna isminizi yazin, OK butonuna  tıklayın ve result mesajında isminizin görüntülendiğini doğrulayın.
     */

    WebDriver driver;
    @BeforeClass
    public void setup(){
        WebDriverManager.chromedriver().setup();
        driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
    }
    @AfterClass
    public void tearDown(){
        driver.close();
    }
    @Test
    public void acceptAlert(){
        driver.get("https://the-internet.herokuapp.com/javascript_alerts");
        //○ 1. butona tıklayın, uyarıdaki OK butonuna tıklayın ve
        // result mesajının “You successfuly clicked an alert” oldugunu test edin.
        driver.findElement(By.xpath("//button[@onclick='jsAlert()']")).click();
        driver.switchTo().alert().accept();

        String actualMessage = driver.findElement(By.xpath("//p[@id='result']")).getText();
        String expectedMessage = "You successfully clicked an alert";

        SoftAssert obj = new SoftAssert();
        obj.assertEquals(actualMessage,expectedMessage);
        obj.assertAll();
    }

    // Bir metod olusturun: dismissAlert
    // ○ 2. butona tıklayın, uyarıdaki Cancel butonuna tıklayın
    // ve result mesajının   “successfuly” icermedigini test edin.
    @Test
    public void dismissAlertTest(){
        driver.get("https://the-internet.herokuapp.com/javascript_alerts");
        driver.findElement(By.xpath("//button[@onclick='jsAlert()']")).click();
        driver.switchTo().alert().dismiss();
        String actualMessage = driver.findElement(By.xpath("//p[@id='result']")).getText();
        String unexpectedMessage = "successfuly";
        Assert.assertFalse(actualMessage.contains(unexpectedMessage));

    }
    //● Bir metod olusturun: sendKeysAlert
    // ○ 3. butona tıklayın, uyarıdaki metin kutusuna isminizi yazin,
    // OK butonuna  tıklayın ve result mesajında isminizin görüntülendiğini doğrulayın.
    @Test
    public void senKeysAlertTest() throws InterruptedException {
        driver.get("https://the-internet.herokuapp.com/javascript_alerts");
        driver.findElement(By.xpath("//button[@onclick='jsPrompt()']")).click();
        Thread.sleep(5000);
        String isim ="GONUL";
        driver.switchTo().alert().sendKeys(isim);
        Thread.sleep(3000);
        driver.switchTo().alert().accept();

        String actualIsim = driver.findElement(By.xpath("//p[@id='result']")).getText();
        String expectedIsim = "GONUL";

        Assert.assertTrue(actualIsim.contains(expectedIsim));

    }
}
