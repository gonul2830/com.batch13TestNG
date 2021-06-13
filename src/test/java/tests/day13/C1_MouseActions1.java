package tests.day13;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;
import utilities.TestBaseClass;

import javax.swing.*;
import java.util.Set;

public class C1_MouseActions1 extends TestBaseClass {
    /*
    1- Yeni bir class olusturalim: D14_MouseActions1
2- https://the-internet.herokuapp.com/context_menu sitesine gidelim
3- Cizili alan uzerinde sag click yapalim
4- Alert’te cikan yazinin “You selected a context menu” oldugunu
    test edelim.
5- Tamam diyerek alert’I kapatalim
6- Elemental Selenium linkine tiklayalim
7- Acilan sayfada h1 taginda “Elemental Selenium” yazdigini test edelim

     */
    @Test
    public void test01() throws InterruptedException {
        driver.get("https://the-internet.herokuapp.com/context_menu");
        //1. adim.: action objesi olusturalım.
        Actions obj = new Actions(driver);
        // 2. adim action'ı yapacagim web elementini locate edelim.
        WebElement cizgiliAlan = driver.findElement(By.id("hot-spot"));
        //3.adim: actions objesi ve locate ettigimiz web elementini kullanarak istedigimiz islemi yapalım

        obj.contextClick(cizgiliAlan).perform();
        //4- Alert’te cikan yazinin “You selected a context menu” oldugunu
        //    test edelim.

        String alertYazisi = driver.switchTo().alert().getText();
        String expectedYazi = "You selected a context menu";
        Assert.assertEquals(expectedYazi,alertYazisi);
         //5- Tamam diyerek alert’I kapatalim
        driver.switchTo().alert().accept();

        //contextclick'in menüsü acık kalıyor
        // kapatmak icin herhangi bir yere normal click yapmak lazim
        Thread.sleep(3000);
        obj.click(cizgiliAlan).click();


        String ilkSayfaHandleDegeri = driver.getWindowHandle();

        //6- Elemental Selenium linkine tiklayalim
        WebElement elemantelLink = driver.findElement(By.linkText("Elemental Selenium"));
        obj.click(elemantelLink).perform();

        //7- Acilan sayfada h1 taginda “Elemental Selenium” yazdigini test edelim
        Set<String> handleKumesi = driver.getWindowHandles();
        String ikinciSayfaHandleDegeri="";
        for (String w: handleKumesi) {
            if(!w.equals(ilkSayfaHandleDegeri)){
                ikinciSayfaHandleDegeri=w;
            }
        }
        System.out.println("==================");
        System.out.println(ikinciSayfaHandleDegeri);
        driver.switchTo().window(ikinciSayfaHandleDegeri);
        WebElement h1TagYazisiWebelement = driver.findElement(By.tagName("h1"));
        String accualH1Yazisi = h1TagYazisiWebelement.getText();
        String expectedYazisi = "Elemental Selenium";
        Assert.assertEquals(accualH1Yazisi,expectedYazisi);
    }
}
