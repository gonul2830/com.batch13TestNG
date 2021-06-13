package tests.day13;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;
import utilities.TestBaseClass;

public class C4_KeyboardActions1 extends TestBaseClass {
    /*
    1- Bir Class olusturalim D14_KeyboardActions1
2- https://www.amazon.com sayfasina gidelim
3- Arama kutusuna actions method’larine kullanarak samsung A71 yazdirin ve Enter’a basarak arama yaptirin
4- basarili login olmadigini test edin
     */
    @Test
    public void test01(){
        driver.get("https://www.amazon.com");
        //3- Arama kutusuna actions method’larine kullanarak samsung A71 yazdirin ve Enter’a basarak arama yaptirin

        WebElement aramaKutusu = driver.findElement(By.id("twotabsearchtextbox"));
        Actions obj = new Actions(driver);
        obj.click(aramaKutusu).
                sendKeys("samsung ").
                keyDown(Keys.SHIFT).
                sendKeys("a").
                keyUp(Keys.SHIFT).
                sendKeys("71").
                sendKeys(Keys.ENTER).
                perform();
        WebElement sonucSayisi = driver.findElement(By.xpath("//span[@dir='auto']"));
        Assert.assertTrue(sonucSayisi.isDisplayed());
    }


}
