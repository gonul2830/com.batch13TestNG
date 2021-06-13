package utilities;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;

import java.util.concurrent.TimeUnit;

public abstract class TestBase {
  //public: herkes ulasabilir
  //protected: aynı package veya child class
  // default: (bir sey yazmayınca da default kabul edilir): package private
  // private : sadece class icinde kullanırız.

  protected WebDriver driver;
  @BeforeMethod
    public void setup(){
      WebDriverManager.chromedriver().setup();
      driver= new ChromeDriver();
      driver.manage().window().maximize();
      driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
  }

  @AfterMethod
    public void tearDown(){
      driver.close();
  }
}
