package tests.day13;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;
import utilities.TestBaseClass;

public class C2_MouseActions02 extends TestBaseClass {
    /*
    Yeni bir class olusturalim: D14_MouseActions2
1- https://demoqa.com/droppable adresine gidelim
2- “Drag me” butonunu tutup “Drop here” kutusunun ustune birakalim
3- “Drop here” yazisi yerine “Dropped!” oldugunu test edin
     */
    @Test
    public void test01(){
        //1- https://demoqa.com/droppable adresine gidelim
        driver.get("https://demoqa.com/droppable");

        //2- “Drag me” butonunu tutup “Drop here” kutusunun ustune birakalim
        Actions obj = new Actions(driver);

        //2- “Drag me” butonunu tutup “Drop here” kutusunun ustune birakalim
        WebElement sorceMenu = driver.findElement(By.xpath("//div[@id='draggable']"));
        WebElement dropAlan = driver.findElement(By.xpath("((//div[@id='droppable']))[1]"));
        obj.dragAndDrop(sorceMenu,dropAlan).perform();

        //Baska yolu da su sekilde olabilir
        //actions.clickAndHold(dragMe).moveToElement(dropMe).release().build().perform();

        //3- “Drop here” yazisi yerine “Dropped!” oldugunu test edin
        WebElement dropedYazisiWebelementi = driver.findElement(By.xpath("(//*[.='Dropped!'])[1]"));
        String actualDroppedYazisi = dropedYazisiWebelementi.getText();
        String expectedYazisi = "Dropped!";
        Assert.assertEquals(actualDroppedYazisi,expectedYazisi);
    }
}
