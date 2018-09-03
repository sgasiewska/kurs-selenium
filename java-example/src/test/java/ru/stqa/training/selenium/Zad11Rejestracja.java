package ru.stqa.training.selenium;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;

public class Zad11Rejestracja extends TestBase {
        @Test
        public void rejestracja() {
            driver.get("http://localhost/litecart/en/");
            for (int liczba = 0; ; liczba++) {
                String mejl = "test" + liczba + "@test.com";
                driver.findElement(By.name("email")).sendKeys(mejl);
                driver.findElement(By.name("lost_password")).click();
                String tekst = driver.findElement(By.id("notices")).getText();
                if (tekst.equals("The email address does not exist in our database.")) {
                    driver.findElement(By.linkText("New customers click here")).click();
                    driver.findElement(By.name("firstname")).sendKeys("test");
                    driver.findElement(By.name("lastname")).sendKeys("test");
                    driver.findElement(By.name("address1")).sendKeys("test");
                    driver.findElement(By.name("postcode")).sendKeys("80-120");
                    driver.findElement(By.name("city")).sendKeys("test");
                    driver.findElement(By.className("select2-selection__arrow")).click();
                    driver.findElement(By.className("select2-search__field")).sendKeys("Poland");
                    driver.findElement(By.className("select2-search__field")).sendKeys(Keys.ENTER);
                    driver.findElement(By.name("email")).sendKeys(mejl);
                    driver.findElement(By.name("phone")).sendKeys("123456");
                    driver.findElement(By.name("password")).sendKeys("admin");
                    driver.findElement(By.name("confirmed_password")).sendKeys("admin");
                    driver.findElement(By.name("create_account")).click();
                    driver.findElement(By.linkText("Logout")).click();
                    driver.findElement(By.name("email")).sendKeys(mejl);
                    driver.findElement(By.name("password")).sendKeys("admin");
                    driver.findElement(By.name("login")).click();
                    return;
                }
            }

        }
    }


