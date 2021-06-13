package tests.practice;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Test01 {
    //1- PratikDers isimli bir package olusturun
//2- Test01 isimli bir class olusturun
//3- Gerekli ayarlari yapin ve driver olusturun
//4- https://www.google.com/ adresine gidin
//5- sayfayi tam sayfa yapin
//6- https://www.walmart.com/ adresine gidin
//7- google sayfasina geri donunuz
//8- Sayfayi refresh yapin
//9- Sayfayi kapatin


    /*
    1. Static Wait => Java Thread.sleep()
    2. Dynabic Wait
        -implicitly wait => findElement() aktif oluyor
        -explicitly wait
                         elementToBeClickable  500 milis.
                         elementToBeVisibale
        -fuluent wait
     */

    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver", "drivers/chromedriver.exe");
        WebDriver driver = new ChromeDriver(); // Polimorphic olarka objemizi oluşturduk.
        //ChromeDriver driver1=new ChromeDriver(); // normal yoldan obje oluşturmak
        driver.manage().window().maximize(); // browser boyutlarını nasıl ayarlarsınız
        driver.get("https://www.google.com/");
        staticWait(1);
        driver.navigate().to("https://www.walmart.com/");
        driver.navigate().back();
        driver.navigate().refresh();
        driver.quit(); //close();
    }

    public static void staticWait(int second) {
        try {
            Thread.sleep(second * 1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}