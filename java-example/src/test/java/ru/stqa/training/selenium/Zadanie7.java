package ru.stqa.training.selenium;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.List;

import static org.openqa.selenium.support.ui.ExpectedConditions.titleIs;

public class Zadanie7 extends TestBase {
    @Test
    public void litecartTest() {
        driver.get("http://localhost/litecart/admin/login.php");
        driver.findElement(By.name("username")).sendKeys("admin");
        driver.findElement(By.name("password")).sendKeys("admin");
        driver.findElement(By.name("login")).click();

        List<String> listaNazw = new ArrayList<String>();
        List<WebElement> lista = driver.findElements(By.className("name"));
        for (WebElement wiersz : lista) {
            String nazwa = wiersz.getAttribute("innerText");
            listaNazw.add(nazwa);
        }
        int wielkosc = listaNazw.size();
        for (int i = 0; i < wielkosc; i++) {
            driver.findElement(By.linkText(listaNazw.get(i))).click();
            String naglowek = driver.findElement(By.tagName("h1")).getAttribute("innerText");
            System.out.println(naglowek);

            List<String> listaPodnazw = new ArrayList<String>();

            if (isElementPresent(By.className("docs"))) {
                WebElement sciezka = driver.findElement(By.className("docs"));
                List<WebElement> listaPod = sciezka.findElements(By.className("name"));
                for (WebElement wierszPod : listaPod) {
                    String nazwaPod = wierszPod.getAttribute("innerText");
                    listaPodnazw.add(nazwaPod);
                }
                int wielkoscPod = listaPodnazw.size();
                for (int a = 0; a < wielkoscPod; a++) {
                    driver.findElement(By.linkText(listaPodnazw.get(a))).click();
                    String naglowekPod = driver.findElement(By.tagName("h1")).getAttribute("innerText");
                    System.out.println(naglowekPod);
                }
            }
        }
    }


}