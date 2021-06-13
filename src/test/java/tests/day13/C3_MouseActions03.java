package tests.day13;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;
import utilities.TestBaseClass;

public class C3_MouseActions03 extends TestBaseClass {
    /*
    1- https://www.facebook.com adresine gidelim
2- Ad, soyad, mail ve sifre kutularina deger yazalim ve kaydol tusuna basalim
3- Kaydol tusuna basalim
     */
    @Test
    public void test01(){
        driver.get("https://www.facebook.com");
        driver.findElement(By.xpath("(//button[@value='1'])[3]")).click();
        driver.findElement(By.xpath("(//a[@role='button'])[2]")).click();

        WebElement isimKutusu = driver.findElement(By.xpath("(//input[@type='text'])[2]"));

        Actions obj = new Actions(driver);
/*
        Actions obj = new Actions(driver);
        obj.click(isimKutusu).perform();
        obj.sendKeys("Gonul").perform();
        obj.sendKeys(Keys.TAB).perform();
        obj.sendKeys("Taslak").perform();
        obj.sendKeys(Keys.TAB).perform();
        */

               obj.click(isimKutusu).
                sendKeys("Gonul").
                sendKeys(Keys.TAB).
                sendKeys("Taslak").
                sendKeys(Keys.TAB).
              sendKeys("mehmetbulu@gmail.com").
                sendKeys(Keys.TAB).
                sendKeys("mehmetbulu@gmail.com").
                sendKeys(Keys.TAB).
                sendKeys("12345").
                perform();

    }
}
