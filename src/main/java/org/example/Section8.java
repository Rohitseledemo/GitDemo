package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.Arrays;
import java.util.List;

public class Section8 {
    int count=0;
    public void addItem(WebDriver driver, String[] items) {
        List<WebElement> product = driver.findElements(By.xpath("//h4[@class='product-name']"));
        for (int i = 0; i < product.size(); i++) {
            String[] productName = product.get(i).getText().split("-");
            String name = productName[0].trim();
            List al = Arrays.asList(items);
            if (al.contains(name)) {
                count++;
                driver.findElements(By.xpath("//div[@class='product-action']")).get(i).click();
                if(count== items.length){
                    break;
                }
            }

        }

    }
    public static void main(String[] args) {
        WebDriver driver = new ChromeDriver();
        WebDriverWait w = new WebDriverWait(driver, Duration.ofSeconds(5));
        driver.get("https://rahulshettyacademy.com/seleniumPractise/#/");
        String[] items = {"Cauliflower", "Brocolli", "Cucumber", "Apple", "Banana"};
        Section8 obj = new Section8();
        obj.addItem(driver, items);
        driver.findElement(By.xpath("//img[@alt='Cart']")).click();
        driver.findElement(By.xpath("//button[text()='PROCEED TO CHECKOUT']")).click();
        w.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@class='promoCode']")));
        driver.findElement(By.xpath("//input[@class='promoCode']")).sendKeys("rahulshettyacademy");
        driver.findElement(By.cssSelector("button.promoBtn")).click();
        w.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("span.promoInfo")));
        driver.findElement(By.xpath("//button[text()='Place Order']")).click();


    }
}


