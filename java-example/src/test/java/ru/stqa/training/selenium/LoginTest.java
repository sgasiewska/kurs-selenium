package ru.stqa.training.selenium;


import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;

import static org.openqa.selenium.support.ui.ExpectedConditions.titleIs;

public class LoginTest {
    private WebDriver driver;
    private WebDriverWait wait;


    @Before
    public void  strat(){
     //   driver = new ChromeDriver();
      //  driver= new EdgeDriver();
        driver = new FirefoxDriver();
        //gdy nie znajdzie elementu to szuka gojeszcze przez 10 sekund
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        wait = new WebDriverWait(driver,10);
    }

    @Test
    public void loginTest(){
        driver.get("http://localhost/litecart/admin/login.php");

        WebElement komunikat= (WebElement) driver.findElement(By.xpath("//td[contains(text(),'Username')]"));

        String color = komunikat.getCssValue("color");

        System.out.println(color);
    }

    @After
    public void stop(){
        driver.quit();
        driver=null;
    }
}
