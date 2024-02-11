package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

import java.util.List;

public class Section12Scrolling {
    public static void main(String[] args) {
        //headless testing mode is without browser invocation/without opening browser
        //how to scroll? since selenium doesn't provide any scrolling technique so,
        //it can be done by executing JavaScript only.
        WebDriver driver = new ChromeDriver();
        driver.get("https://www.rahulshettyacademy.com/AutomationPractice/");
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scroll(0,600)");
        js.executeScript("document.querySelector('.tableFixHead').scrollTop=600");
        List<WebElement> values = driver.findElements(By.xpath("//div[@class='tableFixHead']//td[4]"));
        int sum = 0;
        for (int i = 0; i < values.size(); i++) {
            sum = sum + Integer.parseInt(values.get(i).getText());
        }
        System.out.println(sum);
        int total = Integer.parseInt(driver.findElement(By.xpath("//div[@class='totalAmount']")).getText().split(":")[1].trim());
        Assert.assertEquals(sum,total);
    }
}
