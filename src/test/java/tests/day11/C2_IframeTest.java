package tests.day11;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import java.util.concurrent.TimeUnit;

public class C2_IframeTest {
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
    public void iframeTest(){
        /*
        ● Bir class olusturun: D12_IframeTest
● https://the-internet.herokuapp.com/iframe adresine gidin.
● Bir metod olusturun: iframeTest
 ○ “An IFrame containing….” textinin erisilebilir oldugunu test edin ve  konsolda  yazdirin.
 ○ Text Box’a “Merhaba Dunya!” yazin.
 ○ TextBox’in altinda bulunan “Elemental Selenium” linkini textinin gorunur oldugunu  dogrulayin ve  konsolda yazdirin.
         */
        driver.get("https://the-internet.herokuapp.com/iframe");
        WebElement iFrameYazisi = driver.findElement(By.tagName("h3"));
        SoftAssert obj = new SoftAssert();
        obj.assertTrue(iFrameYazisi.isEnabled());
        System.out.println(iFrameYazisi.getText());
        obj.assertAll();
        driver.switchTo().frame(0);
        WebElement textBox = driver.findElement(By.className("mce-content-body"));
        textBox.clear();
        String yazilacakKelime= "Merhaba Dunya";
        textBox.sendKeys(yazilacakKelime);

        driver.switchTo().parentFrame();
       // WebElement gorunenYazi = driver.findElement(By.xpath("(//a[@target='_blank'])[2]"));
        //Assert.assertTrue(gorunenYazi.isDisplayed());
         String gorunenYazi2 = driver.findElement(By.xpath("(//a[@target='_blank'])[2]")).getText();
        String expectedYazi = "Elemental Selenium";
        Assert.assertEquals(gorunenYazi2,expectedYazi);




    }
}
