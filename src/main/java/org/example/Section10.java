package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import javax.swing.*;

public class Section10 {
    public static void main(String[] args) {
        WebDriver driver= new ChromeDriver();
        driver.get("https://www.amazon.in/");
        driver.manage().window().maximize();
        Actions a = new Actions(driver);
        a.moveToElement(driver.findElement(By.id("twotabsearchtextbox"))).click().keyDown(Keys.LEFT_SHIFT).sendKeys("rohit").doubleClick().build().perform();
        a.moveToElement(driver.findElement(By.id("nav-link-accountList"))).build().perform();





    }
}
