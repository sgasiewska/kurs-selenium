package ru.stqa.training.selenium;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

import static org.junit.Assert.assertTrue;
import static org.openqa.selenium.support.ui.ExpectedConditions.elementToBeClickable;
import static org.openqa.selenium.support.ui.ExpectedConditions.numberOfElementsToBe;
import static org.openqa.selenium.support.ui.ExpectedConditions.textToBe;

public class Zad13 extends TestBase {

    @Test
    public void zad13() {
        driver.get("http://localhost/litecart/en/");
        for (int i = 1; i < 4; i++) {
            List<WebElement> ducks = driver.findElements(By.className("name"));
            String text = ducks.get(0).getText();
            ducks.get(0).click();
            if (text.equals("Yellow Duck")) {
                new Select(driver.findElement(By.name("options[Size]"))).selectByValue("Small");
            }
            driver.findElement(By.name("add_cart_product")).click();
            wait.until(textToBe(By.className("quantity"), String.valueOf(i)));
            driver.findElement(By.id("logotype-wrapper")).click();
        }
        driver.findElement(By.linkText("Checkout »")).click();
        wait.until(elementToBeClickable(By.name("remove_cart_item")));
        WebElement table = driver.findElement(By.id("order_confirmation-wrapper"));
        List<WebElement> rows = table.findElements(By.xpath(".//td[1][@style='text-align: center;']"));
        int numberOfRows = rows.size();
        int numberOfItems = 0;
        for (WebElement row : rows) {
            int numberInRow = Integer.parseInt(row.getText());
            numberOfItems = (numberOfItems + numberInRow);
        }
        assertTrue(numberOfItems == 3);
        for (int i = 0; i <= numberOfRows; i++) {
            driver.findElement(By.name("remove_cart_item")).click();
            if (i != numberOfRows) {
                wait.until(numberOfElementsToBe(By.xpath(".//td[1][@style='text-align: center;']"), (numberOfRows - 1)));
                table = driver.findElement(By.id("order_confirmation-wrapper"));
                rows = table.findElements(By.xpath(".//td[1][@style='text-align: center;']"));
                numberOfRows = rows.size();
            }
        }
        return;
    }
}
