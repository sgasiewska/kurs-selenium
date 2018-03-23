package ru.stqa.training.selenium;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.HasCapabilities;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;

import static org.openqa.selenium.support.ui.ExpectedConditions.titleIs;

public class MyFirstTest {

  private WebDriver driver;
  private WebDriverWait wait;

  //inicjalizacja sterownika przegladarki
  @Before
  public void  strat(){
    /*
    driver = new ChromeDriver();
    //gdy nie znajdzie elementu to szuka gojeszcze przez 10 sekund
    driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    wait = new WebDriverWait(driver,10);
    */
    //ChromeOptions options= new ChromeOptions();
   // options.addArguments("start-fullscreen");
    //driver = new ChromeDriver(options);

    DesiredCapabilities caps = new DesiredCapabilities();

    //    //    //wskazanie, ze FF ma być uruchomione wg. "starego" schematu (tylko dla wersji przeglądarek obsługujących start=y schemat np FF SRE)
    caps.setCapability(FirefoxDriver.MARIONETTE,false);

    //caps.setCapability(ChromeOptions.CAPABILITY, options);
  //  caps.setCapability("unexpectedAlertBehavior", "disnuss");
   // caps.setCapability(InternetExplorerDriver.IGNORE_ZOOM_SETTING,true);
    //caps.setCapability(InternetExplorerDriver.INTRODUCE_FLAKINESS_BY_IGNORING_SECURITY_DOMAINS);
   // driver= new InternetExplorerDriver(caps);
  //  driver= new ChromeDriver(caps);
   // System.out.println(((HasCapabilities)driver).getCapabilities());
    wait= new WebDriverWait(driver, 10);
  }

  @Test
  public void myFirstTest(){
   // driver.get("http://www.google.com/");
   // driver.findElement(By.name("q")).sendKeys("webdriver");
  //  driver.findElement(By.name("btnK")).click();
    //wait.until(titleIs("webdriver - Szukaj w Google"));

  }

  //zatrzymanie sterownika przegladaki
  @After
  public void stop(){
    driver.quit();
    driver=null;
  }
}
