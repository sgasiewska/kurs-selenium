package ru.stqa.training.selenium;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import static org.openqa.selenium.support.ui.ExpectedConditions.titleIs;

public class MyFirstTest {

  private WebDriver driver;
  private WebDriverWait wait;

  //inicjalizacja sterownika przegladarki
  @Before
  public void  strat(){
    driver = new ChromeDriver();
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
