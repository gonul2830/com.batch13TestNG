package tests.day12;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import utilities.TestBaseClass;

import java.util.Set;

public class C5_WindowHandle3 extends TestBaseClass {
     /*
      ● https://the-internet.herokuapp.com/windows adresine gidin.
      ● Sayfadaki textin “Opening a new window” olduğunu doğrulayın.
      ● Sayfa başlığının(title) “The Internet” olduğunu doğrulayın.
      ● Click Here butonuna basın.
      ● Acilan yeni pencerenin sayfa başlığının (title) “New Window” oldugunu dogrulayin.
      ● Sayfadaki textin “New Window” olduğunu doğrulayın.
      ● Bir önceki pencereye geri döndükten sonra sayfa başlığının “The Internet” olduğunu doğrulayın.
   */

    @Test
    public void test01(){
        driver.get("https://the-internet.herokuapp.com/windows");
        WebElement text =driver.findElement(By.tagName("h3"));
    String accualYazi = text.getText();
    String expectedYazi ="Opening a new window";
        Assert.assertEquals(accualYazi,expectedYazi);
        String accualBaslik= driver.getTitle();
        String expectedBaslik = "The Internet";
        Assert.assertEquals(accualBaslik,expectedBaslik);
        String ilkSayfaHandleDegeri = driver.getWindowHandle();
        driver.findElement(By.xpath("//*[.='Click Here']")).click();
        String ikinciSayfaHandleDegeri = "";
        Set<String> handleListesi = driver.getWindowHandles();
        for (String w:handleListesi) {
            if(!ilkSayfaHandleDegeri.equals(w)){
                ikinciSayfaHandleDegeri=w;
            }
        }

        driver.switchTo().window(ikinciSayfaHandleDegeri);

        String accualikinciSayfaBaslik= driver.getTitle();
        String expectedikinciSayfaBaslik = "New Window";
        Assert.assertEquals(accualikinciSayfaBaslik,expectedikinciSayfaBaslik);
        // Bir önceki pencereye geri döndükten sonra sayfa başlığının “The Internet” olduğunu doğrulayın.

        driver.switchTo().window(ilkSayfaHandleDegeri);
        String accualBaslikİlkSayfa2= driver.getTitle();
        String expectedBaslikSayfa2 = "The Internet";
        Assert.assertEquals(accualBaslikİlkSayfa2,expectedBaslikSayfa2);

    }

}
