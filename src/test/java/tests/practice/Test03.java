package tests.practice;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;
import utilities.TestBaseClass;

import java.util.List;

public class Test03 extends TestBaseClass {
    @Test
    public void test01(){
        /*
        1.kullanici amazon sayfasina gider
2.search input box a kelime girer
3.tahmini sonuclarin aranan kelimeyi icerdigi test edilir
4.tahmin sayisinin en fazla 10 oldugu test edilir
         */
        driver.get("https://www.amazon.com/");
       WebElement searchBox =  driver.findElement(By.id("twotabsearchtextbox"));

        searchBox.sendKeys("bilgisayar");


        List<WebElement> suggestion = driver.findElements(By.cssSelector("#suggestions>div"));
        Assert.assertTrue(suggestion.size()<11 && suggestion.size()>1);
    }


}
