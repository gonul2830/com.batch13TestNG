package tests.day14;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;
import utilities.TestBaseClass;

import java.nio.file.Files;
import java.nio.file.Paths;

public class C3_FileDownload extends TestBaseClass {
@Test
    public void downloadTesti() throws InterruptedException {
    /*
    1. Tests packagenin altina bir class oluşturalim : D14_FileDownload
2. Iki tane metod oluşturun : isExist() ve downloadTest()
3. downloadTest () metodunun icinde aşağıdaki testi yapalim:
 - https://the-internet.herokuapp.com/download adresine gidelim.
 - image1.jpg dosyasını indirelim
4. Ardından isExist()  methodunda dosyanın başarıyla indirilip indirilmediğini test edelim
     */
    driver.get("https://the-internet.herokuapp.com/download");

    driver.findElement(By.xpath("//*[.='webdriverIO.png']")).click();
    Thread.sleep(5000);

}

@Test
    public void isExistTesti(){


    String dosyaYolu= System.getProperty("user.home")+"\\Downloads\\code.txt";
    Assert.assertTrue(Files.exists(Paths.get(dosyaYolu)));

}
}
