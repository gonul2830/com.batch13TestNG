package tests.practice;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Test02 {
    //sayfa başlığı ==> getTitle()
//        By title=By.xpath("//title");
//
//        browser.findElement(title).getText();// ==> browser.getTitle()
    //browser.findElement(By.id("title")); // doğrudan method içerisine yazıyoruz


    /*
    //1-Test02 isimli bir class olusturun
//2- https://www.walmart.com/ adresine gidin
//3- Browseri tam sayfa yapin
//4-Sayfayi "refresh" yapin
//5- Sayfa basliginin "Save" ifadesi icerdigini control edin
//6-Sayfa basliginin "Walmart.com | Save Money.Live Better" a esit oldugunu control ediniz
//7- URL in walmart.com icerdigini control edin
//8-Sayfayi kapatin
     */

    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver","drivers/chromedriver.exe");
        WebDriver browser=new ChromeDriver();
        browser.manage().window().maximize();
        browser.get("https://www.walmart.com/");
        browser.navigate().refresh();
        //sayfa başlığı ==> getTitle()
//        By title=By.xpath("//title");
//
//        browser.findElement(title).getText();// ==> browser.getTitle()
        //browser.findElement(By.id("title")); // doğrudan method içerisine yazıyoruz
        String title=browser.getTitle();
        //5. step
        if(title.contains("Save")){
            System.out.println("PASS");
        }else {
            System.out.println("FAIL");
            System.out.println("Title Save kelimesini içermiyor");
        }
        //6. step
        String expectedUrl="Walmart.com | Save Money.Live Better";
        if(title.equals(expectedUrl)){
            System.out.println("PASS");
        }else {
            System.out.println("FAIL");
            System.out.println("Title Save kelimesini içermiyor");
        }
        //getCurrentUrl()
        String currentUrl = browser.getCurrentUrl();
        //7. step
        if(currentUrl.contains("walmart.com")){
            System.out.println("PASS");
        }else {
            System.out.println("FAIL");
            System.out.println("URL walmart.com kelimesini içermiyor");
        }
        browser.quit();
    }


}
