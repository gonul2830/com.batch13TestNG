package tests.day09;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class C3_DropDown {
    /*
    ● Bir class oluşturun: D10_DropDownAmazon
● https://www.amazon.com/ adresine gidin.
- Test 1
    Arama kutusunun yanindaki kategori menusundeki kategori sayisinin 45 oldugunu test edin
-Test 2
    1. Kategori menusunden Books secenegini  secin
    2. Arama kutusuna Java yazin ve aratin
    3. Bulunan sonuc sayisini yazdirin
    4. Sonucun Java kelimesini icerdigini test edin

     */
    WebDriver driver;
    @BeforeMethod
    public void setup (){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);

    }

    @AfterMethod
    public void tearDown() {
        // driver.close();
    }

@Test
    public void test01(){
        //   Arama kutusunun yanindaki kategori menusundeki kategori sayisinin 45 oldugunu test edin
    driver.get("https://www.amazon.com/");
    WebElement drownDrop = driver.findElement(By.xpath("//select[@title='Search in']"));
    Select secilenler = new Select(drownDrop);

    List<WebElement>liste = secilenler.getOptions();
    System.out.println(liste.size());

    int exceptedOptionSayisi = 45;
    int actualSayisi= liste.size();
    Assert.assertEquals(exceptedOptionSayisi,actualSayisi);

}
@Test
    public void test2(){
        /*
        -Test 2
    1. Kategori menusunden Books secenegini  secin
    2. Arama kutusuna Java yazin ve aratin
    3. Bulunan sonuc sayisini yazdirin
    4. Sonucun Java kelimesini icerdigini test edin
         */
    driver.get("https://www.amazon.com/");
    WebElement acilirListe = driver.findElement(By.xpath("//select[@title='Search in']"));
    Select booksecim = new Select(acilirListe);
    booksecim.selectByValue("search-alias=stripbooks-intl-ship");
    WebElement javaARA= driver.findElement(By.id("twotabsearchtextbox"));
    javaARA.sendKeys("Java" + Keys.ENTER);
   WebElement sonucSayisi = driver.findElement(By.xpath("(//span[@dir='auto'])[1]"));
    System.out.println("sonuc sayisi: "+ sonucSayisi.getText());


}

}
