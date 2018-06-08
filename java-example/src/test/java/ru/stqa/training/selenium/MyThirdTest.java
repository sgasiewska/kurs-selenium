package ru.stqa.training.selenium;


import org.junit.Test;
import org.openqa.selenium.By;
import static org.openqa.selenium.support.ui.ExpectedConditions.titleIs;


public class MyThirdTest extends TestBase {


    @Test
    public void myFirstTest(){
        driver.get("http://www.google.com/");
        driver.findElement(By.name("q")).sendKeys("webdriver");
        driver.findElement(By.name("btnK")).click();
        wait.until(titleIs("webdriver - Szukaj w Google"));
    }
    @Test
    public void mySecondTest(){
        driver.get("http://www.google.com/");
        driver.findElement(By.name("q")).sendKeys("webdriver");
        driver.findElement(By.name("btnK")).click();
        wait.until(titleIs("webdriver - Szukaj w Google"));
    }
}
