package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import java.time.Duration;

public class locators3 {
    public static void main(String[] args) {
        WebDriver driver = new ChromeDriver();
        System.setProperty("web-driver.chrome.driver", "C:\\Users\\91844\\OneDrive\\Documents\\chromedriver-win64\\chromedriver.exe");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(7));
        driver.get("https://rahulshettyacademy.com/");
        driver.findElement(By.xpath("//li[7]/a")).click();
        driver.findElement(By.xpath("//input[@placeholder='Your Name*']")).sendKeys("Rohit Kumar");
        driver.findElement(By.xpath("//input[@placeholder='Your Email*']")).sendKeys("rohitkumar.fly1@gmail.com");
        driver.findElement(By.xpath("//button[@type='submit']")).click();
        driver.findElement(By.xpath("//div[@class='projects-item']/a[1]")).click();
        driver.findElement(By.xpath("//a[@class='cart-header-navlink'][2]")).click();
        // handling static dropdowns using Select class
        WebElement element = driver.findElement(By.id("ctl00_mainContent_DropDownListCurrency"));
        Select dropdown = new Select(element);
        dropdown.selectByIndex(3);
        dropdown.selectByVisibleText("INR");






    }
}
