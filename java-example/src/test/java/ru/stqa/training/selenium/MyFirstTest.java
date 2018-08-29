package ru.stqa.training.selenium;


import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import static java.util.concurrent.TimeUnit.SECONDS;
import static org.openqa.selenium.support.ui.ExpectedConditions.titleIs;


public class MyFirstTest extends TestBase {


 @Test
  public void myFirstTest() {
     driver.navigate().to("http://www.google.com");
     driver.findElement(By.name("q")).sendKeys("webdriver");
     //WebElement btnG=driver.findElement(By.xpath("//input[@value='Szukaj w Google']"));

     WebElement element = driver.findElement(By.xpath("//input[@value='Szukaj w Google']"));
     Actions actions = new Actions(driver);
     actions.moveToElement(element).click().build().perform();
     wait.until(titleIs("webdriver - Szukaj w Google"));
     //btnG.click();
 }

 /*
      driver.get("http://www.google.com/");
      driver.findElement(By.name("q")).sendKeys("webdriver");
      driver.findElement(By.name("btnK")).click();
      wait.until(titleIs("webdriver - Szukaj w Google"));
  }
  /*
    @Test
    public void mySecondTest(){
        driver.get("http://www.google.com/");
        driver.findElement(By.name("q")).sendKeys("webdriver");
        driver.findElement(By.cssSelector(".lsbt")).click();
        wait.until(titleIs("webdriver - Szukaj w Google"));
    }
    */
}
