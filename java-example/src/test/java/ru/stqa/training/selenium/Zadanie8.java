package ru.stqa.training.selenium;


import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;

import static org.junit.Assert.assertEquals;

public class Zadanie8 extends TestBase {

    @Test
    public void zad8() {
        driver.get("http://localhost/litecart/en/");
        driver.findElement(By.linkText("Rubber Ducks")).click();
        WebElement products = driver.findElement(By.cssSelector("[class*=products]"));
        List <WebElement> listDucks = products.findElements(By.cssSelector("[class=image-wrapper]"));
        for(WebElement kaczka : listDucks){
            int sizeSticker = kaczka.findElements(By.cssSelector("[class*=sticker]")).size();

           assertEquals(sizeSticker,1);
        }
    }
}
