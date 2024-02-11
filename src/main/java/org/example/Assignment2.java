package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import java.time.Duration;

public class Assignment2 {
    public static void main(String[] args) {
        WebDriver driver = new ChromeDriver();
        driver.get("https://rahulshettyacademy.com/angularpractice/");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        driver.findElement(By.name("name")).sendKeys("Rohit Kumar");
        driver.findElement(By.name("email")).sendKeys("rohit.robin24@gmail.com");
        driver.findElement(By.id("exampleInputPassword1")).sendKeys("Pass@123");
        driver.findElement(By.id("exampleCheck1")).click();
        WebElement element = driver.findElement(By.id("exampleFormControlSelect1"));
        Select object = new Select(element);
        object.selectByVisibleText("Male");
        driver.findElement(By.id("inlineRadio1")).click();
        driver.findElement(By.xpath("//input[@type='date']")).sendKeys("24/12/1997");
        driver.findElement(By.cssSelector(".btn.btn-success")).click();
        System.out.println(driver.findElement(By.cssSelector(".alert.alert-success.alert-dismissible")).getText());
    }
}
