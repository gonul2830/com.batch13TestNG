package tests.day12;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;
import utilities.TestBase;

import java.util.Set;

public class C2_HandleWindow01 extends TestBase {
    @Test
    public void test01(){
        driver.get("https://the-internet.herokuapp.com/iframe");
  //Ben click yapmadan var olan Window un handle'ini alsam

        String ilkSayfaHandleDeger = driver.getWindowHandle();


        driver.findElement(By.linkText("Elemental Selenium")).click();

        //click yaptıktan sonra tüm handle degerlerini alsam;
       Set<String> handleListesi =  driver.getWindowHandles();

       //Elimizde icinde 2 handle degeri bulunan bir set var
        //Bunlardan biri ilk sayfanin handle degeri
        //ikinci sayfanin handle degerini nasil bulabilirim (for each ile yapabilrim)
         String ikinciSayfaHandleDegeri="";
        for (String each:handleListesi) {
              if(!each.equals(ilkSayfaHandleDeger)){
                  ikinciSayfaHandleDegeri = each;
            }
        }
        driver.switchTo().window(ikinciSayfaHandleDegeri);

        WebElement souceLabYazisi = driver.findElement(By.xpath("//a[text()='Sauce Labs']"));
        System.out.println(souceLabYazisi.getText());

    }
}
