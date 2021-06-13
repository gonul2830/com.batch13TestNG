package tests.day13;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;
import utilities.TestBaseClass;

public class C5_KeyboardActions2 extends TestBaseClass {
    /*
    1- Bir Class olusturalim D14_KeyboardActions2
2- https://html.com/tags/iframe/ sayfasina gidelim
3- video’yu gorecek kadar asagi inin
4- videoyu izlemek icin Play tusuna basin
5- videoyu calistirdiginizi test edin
     */

    @Test
    public void test01(){
        driver.get("https://html.com/tags/iframe/");
        Actions obj = new Actions(driver);

        //3- video’yu gorecek kadar asagi inin
        obj.sendKeys(Keys.PAGE_DOWN).sendKeys(Keys.PAGE_DOWN).perform();
        //4- videoyu izlemek icin Play tusuna basin
        WebElement iframeGecis = driver.findElement(By.xpath("//iframe[@class='lazy-loaded']"));
        driver.switchTo().frame(iframeGecis);

        WebElement clickTus = driver.findElement(By.xpath("//button[@class='ytp-large-play-button ytp-button']"));
        clickTus.click();
        WebElement kontrol = driver.findElement(By.xpath("(//button[@aria-label='Pause (k)'])"));
        Assert.assertTrue(kontrol.isDisplayed());

    }
}
