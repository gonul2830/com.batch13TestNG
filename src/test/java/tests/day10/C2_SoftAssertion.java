package tests.day10;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import java.util.concurrent.TimeUnit;

public class C2_SoftAssertion {
    //"Selenium ogrenmek cok zevkli" cümlesine asagidaki testleri uygulayın
    /*
    1- Cumle "ogrenmek" iceriyor
    2- Cumle "java" icermiyor
    3-cumle 4 kelimeden olusuyor
    4-cumle 25 karakterden olusuyor.

     */


    WebDriver driver;
    String cumle = "Selenium ogrenmek cok zevkli";
    @Test
    public void hardAssertion(){
        Assert.assertTrue(cumle.contains("ogrenmek"));
        System.out.println("1");
        Assert.assertFalse(cumle.contains("java"));
        System.out.println("2");
        String kelimeler[] = cumle.split(" ");
        Assert.assertEquals(kelimeler.length,4);
        System.out.println("3");

        String karakterler[] = cumle.split("");
        Assert.assertEquals(karakterler.length,28);
        System.out.println("4");
    }
    @Test
    public  void SoftAssertionTesti(){
        SoftAssert obj = new SoftAssert();
        obj.assertTrue(cumle.contains("ogrenmek"));
        System.out.println("1");
        obj.assertFalse(cumle.contains("java"));
        System.out.println("2");
        String kelimeler[] = cumle.split(" ");
        obj.assertEquals(kelimeler.length,4);
        System.out.println("3");
        String karakterler[] = cumle.split("");
        obj.assertEquals(karakterler.length,28);
        System.out.println("4");

        obj.assertAll();
        System.out.println("bu yazı konsolda cıkar mı?");
    }
}
