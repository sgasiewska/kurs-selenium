package ru.stqa.training.selenium;


import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.*;
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

        //polozenie elementu- współzedne lewego górnego kąta elementu w pikselach w stosunku do lewego górnego kąta strony
        Point location = komunikat.getLocation();
        //szerokość i wysokosc elementu w pikselach
        Dimension size = komunikat.getSize();
        // "dwa w jednym" -- nowy sposób, którego jeszcze nie wszystkie sterowniki obsługują
        //zwraca rozmiar i położenie elementu
        Rectangle rect = komunikat.getRect();
        // skroluje do elementu aby był widoczny-nie ma przykładu
        //(Locatable element).getCoordinates().inView();

        System.out.println(color);
        System.out.println(location);
        System.out.println(size);
        System.out.println(rect);
    }

    @After
    public void stop(){
        driver.quit();
        driver=null;
    }
}
