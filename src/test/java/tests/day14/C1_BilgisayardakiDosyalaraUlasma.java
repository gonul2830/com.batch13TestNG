package tests.day14;

import org.testng.annotations.Test;
import utilities.TestBaseClass;

public class C1_BilgisayardakiDosyalaraUlasma {

    @Test
    public void test01(){
        System.out.println(System.getProperty("user.dir"));
        System.out.println("===================================");
        System.out.println(System.getProperty("user.com"));

        String masaUstuDosyaYolu = System.getProperty("user.home") + "\\Desktop";
        System.out.println("=================================");
        System.out.println(masaUstuDosyaYolu);
    }
}
