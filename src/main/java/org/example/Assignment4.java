package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.Iterator;
import java.util.Set;

public class Assignment4 {
    public static void main(String[] args) {
        WebDriver driver = new ChromeDriver();
        driver.get("http://the-internet.herokuapp.com/");
        driver.findElement(By.linkText("Multiple Windows")).click();
        driver.findElement(By.linkText("Click Here")).click();
        Set<String> windows = driver.getWindowHandles();
        Iterator<String> it = windows.iterator();
        String p=it.next();
        String c=it.next();
        driver.switchTo().window(c);
        String text = driver.findElement(By.cssSelector(".example")).getText();
        driver.switchTo().window(p);
        System.out.println(driver.findElement(By.xpath("//div[@class='example']/h3")).getText());
        System.out.println(text);


    }
}
