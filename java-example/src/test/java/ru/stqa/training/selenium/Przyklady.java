package ru.stqa.training.selenium;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import java.util.List;

public class Przyklady extends TestBase {

    @Test
    public void przykla(){
        driver.get("https://jqueryui.com/sortable/#connect-lists");
        List<WebElement> items1 =driver.findElements(By.cssSelector("#sortable1 li"));

        List<WebElement> item2 = driver.findElements(By.cssSelector("#sortable2 li"));
        new Actions(driver).moveToElement(items1.get(0)).clickAndHold().moveToElement(items1.get(1)).release().perform();

    }


    @Test
    public void przyklad2(){
        JavascriptExecutor executor = (JavascriptExecutor)driver;

        driver.get("http://cssglobe.com/lab/style_select/01.html");
        WebElement select = driver.findElement(By.cssSelector("select"));
        executor.executeScript("arguments[0].selectedIndex=3; arguments[0].dispatchEvent(new Event('change))", select);

    }
}
