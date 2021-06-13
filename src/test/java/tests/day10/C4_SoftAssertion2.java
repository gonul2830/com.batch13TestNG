package tests.day10;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class C4_SoftAssertion2 {
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
        Assert.assertFalse(cumle.contains("java"));
        String []kelimeler = cumle.split(" ");
        Assert.assertEquals(kelimeler.length,4);
        String [] karakterler = cumle.split("");
       // Assert.assertEquals(karakterler.length,25,"28 karakterden olusuyor");
    }
    @Test
    public  void SoftAssertionTesti(){
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertTrue(cumle.contains("ogrenmek"));
        softAssert.assertFalse(cumle.contains("java"));
        String []kelimeler = cumle.split(" ");
        softAssert.assertEquals(kelimeler.length,4);
        String [] karakterler = cumle.split("");
        softAssert.assertEquals(karakterler.length,28,"28 karakterden olusuyor");

        softAssert.assertAll();

    }

}
