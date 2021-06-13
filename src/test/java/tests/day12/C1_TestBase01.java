package tests.day12;

import org.openqa.selenium.By;
import org.testng.annotations.Test;
import utilities.TestBase;

public class C1_TestBase01 extends  TestBase {

    @Test
        public void test01(){
        driver.get("https://www.youtube.com");
     // driver.get("https://the-internet.herokuapp.com/iframe");

    }
}
