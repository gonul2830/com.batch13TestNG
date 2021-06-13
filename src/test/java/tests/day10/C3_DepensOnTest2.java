package tests.day10;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class C3_DepensOnTest2 {
     /*
    ● Bir class oluşturun: DependsOnTest
    ● https://www.walmart.com/ adresine gidin.
    1. Test : Wallmart ana sayfaya gittiginizi test edin
    2. Test : 1.Test basarili ise search Box’i kullanarak “Nutella” icin
        arama yapin ve aramanizin gerceklestigini Test edin
    3.Test : “Nutella” icin arama yapildiysa ilk urunu tiklayin
        ve fiyatinin $6.65 oldugunu test edin
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
       // driver.close();
    }

    @Test
    public  void test01(){
        //    ● https://www.walmart.com/ adresine gidin.
        //    1. Test : Wallmart ana sayfaya gittiginizi test edin
 driver.get("https://www.walmart.com/");
 String expectedUrl = "https://www.walmart.com/";
 String actualUrl = driver.getCurrentUrl();
        Assert.assertEquals(actualUrl,expectedUrl);

    }

    @Test (dependsOnMethods = "test01")
    public void test02(){
        //    2. Test : 1.Test basarili ise search Box’i kullanarak “Nutella” icin
        //        arama yapin ve aramanizin gerceklestigini Test edin
      //  driver.get("https://www.walmart.com/");
        WebElement searchBox = driver.findElement(By.xpath("//input[@id='global-search-input']"));
        String arananKelime ="Nutella";
        searchBox.sendKeys(arananKelime + Keys.ENTER);
        Assert.assertTrue(driver.getTitle().contains("Nutella"));

    }
    @Test (dependsOnMethods = "test02")
    public void test03(){
        //   3.Test : “Nutella” icin arama yapildiysa ilk urunu tiklayin
        //        ve fiyatinin $7.97 oldugunu test edin
      // driver.get("https://www.walmart.com/");
      //  WebElement searchBox = driver.findElement(By.xpath("//input[@id='global-search-input']"));
       // String arananKelime ="Nutella";
        //searchBox.sendKeys(arananKelime + Keys.ENTER);
        driver.findElement(By.xpath("(//img[@data-pnodetype='item-pimg'])[1]")).click();
        //driver.findElement(By.xpath("//div[@class='recaptcha-checkbox-border']")).click();
        WebElement beklenenFiyat = driver.findElement(By.xpath("(//span[@class='price-group'])[1]"));
        String actualFiyat = beklenenFiyat.getText();
        String expectedFiyat = "$7.97";
        Assert.assertEquals(actualFiyat,expectedFiyat);


    }

}
