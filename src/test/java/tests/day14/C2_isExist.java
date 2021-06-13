package tests.day14;

import org.testng.Assert;
import org.testng.annotations.Test;

import java.nio.file.Files;
import java.nio.file.Paths;

public class C2_isExist {
    @Test
    public void test01(){
        //masa Ustunde flower dosysının oldugunu test edin
        //1. Adim: Main (Masustunun) pathini String olarak kaydedelim
        String mainPath = System.getProperty("user.home");
        //2.adim: Dosya yolunu String olarak kaydedelim.

        String dosyaYolu = mainPath + "\\Desktop"+ "\\FLOWER.jpg";
        System.out.println(dosyaYolu);

        Assert.assertTrue(Files.exists(Paths.get(dosyaYolu)));
    }
}
