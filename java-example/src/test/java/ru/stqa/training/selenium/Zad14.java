package ru.stqa.training.selenium;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;
import java.util.Set;

import static org.openqa.selenium.support.ui.ExpectedConditions.numberOfWindowsToBe;

public class Zad14 extends TestBase {

    @Test
    public void zad14() {
        driver.get("http://localhost/litecart/admin/?app=countries&doc=countries");
        driver.findElement(By.name("username")).sendKeys("admin");
        driver.findElement(By.name("password")).sendKeys("admin");
        driver.findElement(By.name("login")).click();
        driver.findElement(By.linkText("Add New Country")).click();


        WebElement table = driver.findElement(By.id("content"));
        List<WebElement> rows = table.findElements(By.xpath(".//td/a[@target='_blank']"));


        for (WebElement row : rows) {
            row.findElement(By.className("fa-external-link")).click();
            wait.until(numberOfWindowsToBe(2));
            String originalWindow = driver.getWindowHandle();
            Set<String> existingWindows = driver.getWindowHandles();
            for (String newWindow : existingWindows) {
                if (!newWindow.equals(originalWindow)) {
                    driver.switchTo().window(newWindow);
                    driver.close();
                    driver.switchTo().window(originalWindow);
                }
            }
        }
    }
}
