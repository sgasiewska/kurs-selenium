package ru.stqa.training.selenium;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import static org.junit.Assert.assertEquals;

public class Zad10SprCzyWlasciwaStrona extends TestBase {

    @Test
    public void czyWlasciwaStrona() {
        driver.get("http://localhost/litecart/en/");
        WebElement kaczka = driver.findElement(By.xpath("//div[@id='box-campaigns']//li[@class='product column shadow hover-light']/*[1]"));
        String tytulGłowna = kaczka.findElement(By.className("name")).getText();
        String cenaGlowna = kaczka.findElement(By.className("regular-price")).getText();
        String przecenaGlowna = kaczka.findElement(By.className("campaign-price")).getText();

        String kolorCeny = kaczka.findElement(By.className("regular-price")).getCssValue("color");
        String kolorPrzeceny = kaczka.findElement(By.className("campaign-price")).getCssValue("color");
        String wielkoscCeny = kaczka.findElement(By.className("regular-price")).getCssValue("font-weight");
        String wielkoscPrzeceny = kaczka.findElement(By.className("campaign-price")).getCssValue("font-weight");
        String stylCeny = kaczka.findElement(By.className("regular-price")).getCssValue("text-decoration");
        String stylPrzeceny = kaczka.findElement(By.className("campaign-price")).getCssValue("text-decoration");
        kaczka.click();

        System.out.println(tytulGłowna + ' ' + stylPrzeceny);

        WebElement kampania = driver.findElement(By.id("box-product"));
        String nazwaKampania = kampania.findElement(By.className("title")).getText();
        String cenaKampania = kampania.findElement(By.className("regular-price")).getText();
        String przecenaKampania = kampania.findElement(By.className("campaign-price")).getText();
        String kolorCenyKampania = kampania.findElement(By.className("regular-price")).getCssValue("color");
        String kolorPrzecenyKampania = kampania.findElement(By.className("campaign-price")).getCssValue("color");
        String wielkoscCenyKampania = kampania.findElement(By.className("regular-price")).getCssValue("font-weight");
        String wielkoscPrzecenyKampania = kampania.findElement(By.className("campaign-price")).getCssValue("font-weight");
        String stylCenyKampania = kampania.findElement(By.className("regular-price")).getCssValue("text-decoration");
        String stylPrzecenyKampania = kampania.findElement(By.className("campaign-price")).getCssValue("text-decoration");
        assertEquals(tytulGłowna, nazwaKampania);
        assertEquals(cenaGlowna, cenaKampania);
        assertEquals(przecenaGlowna, przecenaKampania);

        
        assertEquals(kolorCeny, kolorCenyKampania);
        assertEquals(kolorPrzeceny, kolorPrzecenyKampania);
        assertEquals(wielkoscCeny, wielkoscCenyKampania);
        assertEquals(wielkoscPrzeceny, wielkoscPrzecenyKampania);
        assertEquals(stylCeny, stylCenyKampania);
        assertEquals(stylPrzeceny, stylPrzecenyKampania);

    }
}
