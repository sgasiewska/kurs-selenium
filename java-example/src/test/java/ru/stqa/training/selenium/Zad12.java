package ru.stqa.training.selenium;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

public class Zad12 extends TestBase {
    @Test
    public void zad12() {

        driver.get("http://localhost/litecart/admin/login.php");
        driver.findElement(By.name("username")).sendKeys("admin");
        driver.findElement(By.name("password")).sendKeys("admin");
        driver.findElement(By.name("login")).click();
        driver.findElement(By.linkText("Catalog")).click();
        driver.findElement(By.linkText("Add New Product")).click();
        driver.findElement(By.name("status")).click();
        driver.findElement(By.name("name[en]")).sendKeys("nowy");
        driver.findElement(By.name("code")).sendKeys("nowy");

        List<WebElement> kategorie = driver.findElements(By.name("categories[]"));
        kategorie.get(1).click();
        WebElement kategoria = driver.findElement(By.name("default_category_id"));
        new Select(kategoria).selectByValue("1");
        driver.findElement(By.xpath("//*[@value='1-1']")).click();
        WebElement el = driver.findElement(By.name("quantity"));
        new Actions(driver).moveToElement(el).moveByOffset(45, -7).click().release().perform();
        new Select(driver.findElement(By.name("quantity_unit_id"))).selectByValue("");
        new Select(driver.findElement(By.name("delivery_status_id"))).selectByValue("1");
        new Select(driver.findElement(By.name("sold_out_status_id"))).selectByValue("1");

        driver.findElement(By.name("new_images[]")).sendKeys("D:/GitHub/kurs-selenium/java-example/src/test/resources/projekt.bmp");
        driver.findElement(By.id("add-new-image")).click();
        List<WebElement> zdjecie = driver.findElements(By.name("new_images[]"));
        zdjecie.get(1).sendKeys("D:/GitHub/kurs-selenium/java-example/src/test/resources/projekt.bmp");
        new Actions(driver).click(driver.findElement(By.name("date_valid_from"))).release()
                .sendKeys("20102010").perform();
        new Actions(driver).click(driver.findElement(By.name("date_valid_to"))).release()
                .sendKeys("20102010").perform();

        driver.findElement(By.linkText("Information")).click();
        new Select(driver.findElement(By.name("manufacturer_id"))).selectByValue("1");
        new Select(driver.findElement(By.name("supplier_id"))).selectByValue("");
        driver.findElement(By.name("keywords")).sendKeys("nowy produkt");
        driver.findElement(By.name("short_description[en]")).sendKeys("nowy produkt");
        driver.findElement(By.className("trumbowyg-bold-button ")).click();
        driver.findElement(By.className("trumbowyg-editor")).sendKeys("nowy produkt");
        driver.findElement(By.name("head_title[en]")).sendKeys("nowy produkt");
        driver.findElement(By.name("meta_description[en]")).sendKeys("nowy produkt");

        driver.findElement(By.linkText("Prices")).click();
        WebElement elem = driver.findElement(By.name("purchase_price"));
        new Actions(driver).moveToElement(elem).moveByOffset(45, -7).click().release().perform();
        new Select(driver.findElement(By.name("purchase_price_currency_code"))).selectByValue("USD");

        new Select(driver.findElement(By.name("tax_class_id"))).selectByValue("");
        driver.findElement(By.name("prices[USD]")).sendKeys("5");
        driver.findElement(By.name("prices[EUR]")).sendKeys("9");
        driver.findElement(By.name("save")).click();
        driver.findElement(By.linkText("Catalog")).click();

        driver.findElement(By.linkText("nowy")).click();
    }

}

