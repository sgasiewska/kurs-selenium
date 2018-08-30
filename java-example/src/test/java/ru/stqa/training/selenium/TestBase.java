package ru.stqa.training.selenium;

import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.remote.DesiredCapabilities;


public class TestBase  {

    public static WebDriver driver;
    public static WebDriverWait wait;
    public static ThreadLocal<WebDriver> tlDriver = new ThreadLocal<>();

    //funkcja do spr obecnosci elementu wg okreslonego lokatora
    public  boolean isElementPresent (By locator) {
        try {
            driver.findElement(locator);
            return true;
// jeżeli lokator jest nieprawidołowy to ma wyrzucić wyjątek
        } catch (InvalidElementStateException ex){
            throw  ex;
            //jeżeli lokator jest prawidłowy ale nie odnaleziono go na stronie to ma nie być wyjątku
    }catch (NoSuchElementException ex){
            return false;
        }
    }
    // funkcja spr obecnosc elementow
    public boolean areElementsPresent (By locator){
        return driver.findElements(locator).size()>0;
    }

    @Before
public void start() {
        if (tlDriver.get() !=null){
            driver = tlDriver.get();
            wait= new WebDriverWait(driver, 10);
            return;
        }
        driver = new ChromeDriver();
        tlDriver.set(driver);
        System.out.println(((HasCapabilities) driver).getCapabilities());
    }
}

    /*
    @Before
    public void start(){
        //ta metoda będzie się wykonywać przed każdą met.testową i spr czy sterownik już jest
        if (driver!=null){
            return;
        }

        DesiredCapabilities caps = new DesiredCapabilities();
        caps.setCapability(FirefoxDriver.MARIONETTE,false);
        driver = new FirefoxDriver(caps);
        FirefoxOptions options= new FirefoxOptions();
        options.setCapability(FirefoxDriver.MARIONETTE,false);
       //  driver = new ChromeDriver(options);
        driver= new FirefoxDriver();
        System.out.println(((HasCapabilities) driver).getCapabilities());
        wait=new WebDriverWait(driver,100);

        //zamykanie przeglądarki po wykonaniu wszystkich metod testowych
        Runtime.getRuntime().addShutdownHook(
                new Thread(() -> {driver.quit(); driver=null;}));
    }

    @After
    public void stop(){
       // driver.quit();
      //  driver= null;
    }
}
*/