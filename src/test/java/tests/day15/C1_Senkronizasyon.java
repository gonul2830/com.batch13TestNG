package tests.day15;

import org.openqa.selenium.By;
import org.testng.annotations.Test;
import utilities.TestBaseClass;

public class C1_Senkronizasyon extends TestBaseClass {

    @Test
    public void test01(){
        driver.get("https://www.youtube.com/");
        driver.findElement(By.xpath("(//*[.='I agree'])[5]")).click();
        driver.findElement(By.xpath("(//*[.='Music'])[2]")).click();

    }
}
