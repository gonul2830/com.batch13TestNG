package tests.day09;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ISelect;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class DropDown {
    /*
    ● https://the-internet.herokuapp.com/dropdown adresine gidin.
    1.Index kullanarak Seçenek 1’i (Option 1) seçin ve yazdırın
    2.Value kullanarak Seçenek 2'yi (Option 2) seçin ve yazdırın
    3.Visible Text(Görünen metin) kullanarak Seçenek 1’i (Option 1) seçin ve yazdırın
    4.Tüm dropdown değerleri(value) yazdırın
    5. Dropdown’un boyutunu bulun, Dropdown’da 4 öğe varsa konsolda True , degilse False yazdırın.
     */
    WebDriver driver;
    @BeforeMethod
    public void setup (){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);

    }

    @AfterMethod
    public void tearDown() {
       // driver.close();
    }

    @Test
    public void indexKullanma (){
        driver.get("https://the-internet.herokuapp.com/dropdown");
        // 1.Index kullanarak Seçenek 1’i (Option 1) seçin ve yazdırın
        //1.ASAMA DROPDOWN I LOCATE edelim
        WebElement dropdownMenu = driver.findElement(By.xpath("//select[@id='dropdown']"));
        //2.asama
        Select dropdownListe = new Select(dropdownMenu);
        //3.asama dropdown menusunden option ı secelim
        dropdownListe.selectByIndex(1);
        System.out.println("Listeden" + dropdownListe.getFirstSelectedOption().getText());


    }
    @Test
    public void  degerKullanma () {
       // 2.Value kullanarak Seçenek 2'yi (Option 2) seçin ve yazdırın
        driver.get("https://the-internet.herokuapp.com/dropdown");
        WebElement dropdownMenu2 = driver.findElement(By.xpath("//select[@id='dropdown']"));
        Select dropdownListe2 = new Select(dropdownMenu2);
        dropdownListe2.selectByValue("2");
        System.out.println(dropdownListe2.getFirstSelectedOption().getText());
    }

    @Test  //  3.Visible Text(Görünen metin) kullanarak Seçenek 1’i (Option 1) seçin ve yazdırın
    public void visible (){
        driver.get("https://the-internet.herokuapp.com/dropdown");
        WebElement dropdownMenu3 = driver.findElement(By.xpath("//select[@id='dropdown']"));
        Select dropdownListe3 = new Select(dropdownMenu3);
        dropdownListe3.selectByVisibleText("Option 1");
        System.out.println(dropdownListe3.getFirstSelectedOption().getText());
    }

    @Test
    public void allList(){
        driver.get("https://the-internet.herokuapp.com/dropdown");
        WebElement dropdownMenu4 = driver.findElement(By.xpath("//select[@id='dropdown']"));
        Select dropdownListe4 = new Select(dropdownMenu4);
        List<WebElement> tumOptions=  dropdownListe4.getOptions();
        for (WebElement w :tumOptions) {
            System.out.println(w.getText());
        }
        // 5. Dropdown’un boyutunu bulun, Dropdown’da 4 öğe varsa konsolda True , degilse False yazdırın.

        System.out.println("dropdowndaki eleman sayisi  "+ tumOptions.size());
    }

}
