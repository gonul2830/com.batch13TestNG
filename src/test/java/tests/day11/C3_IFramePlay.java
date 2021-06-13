package tests.day11;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class C3_IFramePlay {

    WebDriver driver;
    @BeforeClass
    public void setup(){
        WebDriverManager.chromedriver().setup();
        driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
    }
    @AfterClass
    public void tearDown(){
       // driver.close();
    }
    @Test
    public void test01() throws InterruptedException {
        //driver.get("https://html.com/tags/iframe/");
        //Thread.sleep(5000);

       // driver.findElement(By.cssSelector(".lazy-loaded")).click();
     //driver.findElement(By.cssSelector(".ytp-cued-thumbnail-overlay-image")).click();

    //WebElement iframe = driver.findElement(By.className("//iframe[@class='lazy-loaded']"));
    //driver.switchTo().
    }
}
