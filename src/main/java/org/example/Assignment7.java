package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Assignment7 {
    public static void main(String[] args) {
        WebDriver driver = new ChromeDriver();
        driver.get("https://www.rahulshettyacademy.com/AutomationPractice/");
        JavascriptExecutor js = (JavascriptExecutor)driver;
        js.executeScript("window.scroll(0,700)");
        js.executeScript("document.querySelector(\".table-display\")");
        int row = driver.findElements(By.xpath("//table[@class='table-display']//tr")).size();
        System.out.println("Number of rows are "+row);
        int column = driver.findElements(By.xpath("//table[@class='table-display']//th")).size();
        System.out.println("Number of columns are "+column);
        System.out.println(driver.findElement(By.xpath("//table[@class='table-display']//tr[4]")).getText());
    }
}
