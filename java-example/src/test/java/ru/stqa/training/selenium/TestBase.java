package ru.stqa.training.selenium;

import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.HasCapabilities;
import org.openqa.selenium.WebDriver;
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
    @Before
    public void start(){
        //ta metoda będzie się wykonywać przed każdą met.testową i spr czy sterownik już jest
        if (driver!=null){
            return;
        }
        /*
        DesiredCapabilities caps = new DesiredCapabilities();
        caps.setCapability(FirefoxDriver.MARIONETTE,false);
        driver = new FirefoxDriver(caps);
        */
        FirefoxOptions options= new FirefoxOptions();
        options.setCapability(FirefoxDriver.MARIONETTE,false);
        driver = new ChromeDriver(options);
        System.out.println(((HasCapabilities) driver).getCapabilities());
        wait=new WebDriverWait(driver,10);

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
