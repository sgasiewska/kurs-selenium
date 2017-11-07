package ru.stqa.training.selenium;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;

import static org.openqa.selenium.support.ui.ExpectedConditions.titleIs;

public class MyFirstTest {

  private WebDriver driver;
  private WebDriverWait wait;

  //inicjalizacja sterownika przegladarki
  @Before
  public void  strat(){
    driver = new ChromeDriver();
    //gdy nie znajdzie elementu to szuka gojeszcze przez 10 sekund
    driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    wait = new WebDriverWait(driver,10);
  }

  @Test
  public void myFirstTest(){
    driver.get("http://www.google.com/");
    driver.findElement(By.name("q")).sendKeys("webdriver");
    driver.findElement(By.name("btnK")).click();
    wait.until(titleIs("webdriver - Szukaj w Google"));

  }

  //zatrzymanie sterownika przegladaki
  @After
  public void stop(){
    driver.quit();
    driver=null;
  }
}
