package ru.stqa.training.selenium;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static org.junit.Assert.assertEquals;


public class Zad9SprSortowania extends TestBase {
//    @Before
//    public  void  logowanie(){
//        driver.get("http://localhost/litecart/admin/login.php");
//        driver.findElement(By.name("username")).sendKeys("admin");
//        driver.findElement(By.name("password")).sendKeys("admin");
//        driver.findElement(By.name("login")).click();
//    }


    @Test
    public void sortowanieKrajow() {
        driver.get("http://localhost/litecart/admin/login.php");
        driver.findElement(By.name("username")).sendKeys("admin");
        driver.findElement(By.name("password")).sendKeys("admin");
        driver.findElement(By.name("login")).click();

        driver.get("http://localhost/litecart/admin/?app=countries&doc=countries");


        WebElement calaTabela = driver.findElement(By.className("dataTable"));
        List<WebElement> kolumny = calaTabela.findElements(By.xpath(".//td[5]"));
        List<String> listaKrajow = new ArrayList<String>();
        List<String> bezSortowania = new ArrayList<String>();
        for (WebElement wiersz : kolumny) {
            String kraj = wiersz.getText();
            listaKrajow.add(kraj);
            bezSortowania.add(kraj);
        }
        Collections.sort(listaKrajow);
        assertEquals(bezSortowania, listaKrajow);



        List<WebElement> wszystkieWiersze = calaTabela.findElements(By.className("row"));
        List<String> krajZStrefami = new ArrayList<String>();
        for (WebElement wierszKrajow : wszystkieWiersze) {
            String iloscStref = wierszKrajow.findElement(By.xpath(".//td[6]")).getAttribute("innerText");
            if (!(iloscStref.equals("0"))) {
                krajZStrefami.add(wierszKrajow.findElement(By.xpath(".//td[5]")).getAttribute("innerText"));
            }
        }
        int strefy = krajZStrefami.size();
        for (int i = 0; i < strefy; i++) {
            driver.findElement(By.linkText(krajZStrefami.get(i))).click();
            WebElement tableZones = driver.findElement(By.id("table-zones"));
            List<WebElement> tabelaStrefy = tableZones.findElements(By.xpath(".//td[3]/input[not(@type='text')]"));
            List<String> listaStref = new ArrayList<String>();
            bezSortowania = new ArrayList<String>();
            for (WebElement wiersz : tabelaStrefy) {
                String strefa = wiersz.getAttribute("value");
                listaStref.add(strefa);
                bezSortowania.add(strefa);
            }
            Collections.sort(listaStref);
            assertEquals(bezSortowania, listaStref);
            driver.findElement(By.name("cancel")).click();
        }
    }

    @Test
    public void zonesTest() {
        driver.get("http://localhost/litecart/admin/?app=geo_zones&doc=geo_zones");
        driver.findElement(By.name("username")).sendKeys("admin");
        driver.findElement(By.name("password")).sendKeys("admin");
        driver.findElement(By.name("login")).click();


        driver.findElement(By.linkText("Canada")).click();
        WebElement tableZones = driver.findElement(By.id("table-zones"));
        List<WebElement> tabelaStrefy = tableZones.findElements(By.xpath(".//td[3]/select/option"));
        List<String> listaStref = new ArrayList<String>();
        List<String> bezSortowania = new ArrayList<String>();
        for (WebElement wiersz : tabelaStrefy) {
            if (wiersz.isEnabled()) {
                if (wiersz.isSelected()) {
                    String strefa = wiersz.getText();
                    listaStref.add(strefa);
                    bezSortowania.add(strefa);
                }
            }
        }
        Collections.sort(listaStref);
        assertEquals(bezSortowania, listaStref);
        driver.findElement(By.name("cancel")).click();

        driver.findElement(By.linkText("European Union")).click();
        tableZones = driver.findElement(By.id("table-zones"));
        tabelaStrefy = tableZones.findElements(By.xpath(".//td[3]/select/option"));
        listaStref = new ArrayList<String>();
        bezSortowania = new ArrayList<String>();
        for (WebElement wiersz : tabelaStrefy) {
            if (wiersz.isEnabled()) {
                if (wiersz.isSelected()) {
                    String strefa = wiersz.getText();
                    listaStref.add(strefa);
                    bezSortowania.add(strefa);
                }
            }
        }
        Collections.sort(listaStref);
        assertEquals(bezSortowania, listaStref);
        driver.findElement(By.name("cancel")).click();


        driver.findElement(By.linkText("United States of America")).click();
        tableZones = driver.findElement(By.id("table-zones"));
        tabelaStrefy = tableZones.findElements(By.xpath(".//td[3]/select/option"));
        listaStref = new ArrayList<String>();
        bezSortowania = new ArrayList<String>();
        for (WebElement wiersz : tabelaStrefy) {
            if (wiersz.isEnabled()) {
                if (wiersz.isSelected()) {
                    String strefa = wiersz.getText();
                    listaStref.add(strefa);
                    bezSortowania.add(strefa);
                }
            }
        }
        Collections.sort(listaStref);
        assertEquals(bezSortowania, listaStref);
        System.out.println(bezSortowania);
        System.out.println(listaStref);

    }
}
