package tests.day13;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import utilities.TestBaseClass;

import java.util.Set;

public class Homework extends TestBaseClass {
    /*
 1."http://webdriveruniversity.com/" adresine gidin
2."Login Portal" a kadar asagi inin
3."Login Portal" a tiklayin
4.Diger window'a gecin
5."username" ve "password" kutularina deger yazdirin
6."login" butonuna basin
7.Popup'ta cikan yazinin "validation failed" oldugunu test edin
8.Ok diyerek Popup'i kapatin
9.Ilk sayfaya geri donun
10.Ilk sayfaya donuldugunu test
  */
    @Test
    public void test01(){
        driver.get("http://webdriveruniversity.com/");
        Actions obj = new Actions(driver);
        //2."Login Portal" a kadar asagi inin
        obj.sendKeys(Keys.PAGE_DOWN).perform();
        String ilkSayfaWingowHandle = driver.getWindowHandle();
         //3)"Login Portal" a tiklayin
        driver.findElement(By.id("login-portal")).click();
        String ikinciSayfaWindowHandle = "";
        Set<String> HandleListesi = driver.getWindowHandles();
        for (String w:HandleListesi) {
            if(!ilkSayfaWingowHandle.equals(w)){
                ikinciSayfaWindowHandle=w;
            }
        }
        //4.Diger window'a gecin
         driver.switchTo().window(ikinciSayfaWindowHandle);
        //5."username" ve "password" kutularina deger yazdirin
        WebElement username = driver.findElement(By.xpath("//input[@type='text']"));
        obj.click(username).sendKeys("Gonul").sendKeys(Keys.TAB).sendKeys("12345").sendKeys(Keys.TAB).perform();
        obj.click().perform();
        //6."login" butonuna basin
        driver.findElement(By.id("login-button")).click();

        //7.Popup'ta cikan yazinin "validation failed" oldugunu test edin
        String actualAlertYazisi = driver.switchTo().alert().getText();
        String expectedYazi = "validation failed";
        SoftAssert obj2 = new SoftAssert();
        obj2.assertEquals(actualAlertYazisi,expectedYazi);

        //8.Ok diyerek Popup'i kapatin
         driver.switchTo().alert().accept();
         //9.Ilk sayfaya geri donun
        driver.switchTo().window(ilkSayfaWingowHandle);
        //10.Ilk sayfaya donuldugunu test
        String expectedUrl="http://webdriveruniversity.com/";
        String actualUrl=driver.getCurrentUrl();
        obj2.assertEquals(actualUrl,expectedUrl);
        obj2.assertAll();
    }

}
