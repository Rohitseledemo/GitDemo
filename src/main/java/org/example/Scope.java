package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.Iterator;
import java.util.List;
import java.util.Set;

public class Scope {
    public static void main(String[] args) {
        WebDriver driver = new ChromeDriver();
        driver.get("http://qaclickacademy.com/practice.php");
        //1.count of the links on the page
        System.out.println(driver.findElements(By.tagName("a")).size());
        //2.Count of links on footer section-
        WebElement footDriver = driver.findElement(By.id("gf-BIG"));
        System.out.println(footDriver.findElements(By.tagName("a")).size());
        //3.to check all links of a particular coloumn
        WebElement colDriver = footDriver.findElement(By.xpath("//table/tbody/tr/td/ul"));
        List<WebElement> links=colDriver.findElements(By.tagName("a"));
        for (int i= 1;i< links.size();i++){
            String keys = Keys.chord(Keys.CONTROL,Keys.ENTER);
            colDriver.findElements(By.tagName("a")).get(i).sendKeys(keys);
        }
        Set<String> windows = driver.getWindowHandles();
        Iterator<String> it = windows.iterator();
        //for(int i=0;i< windows.size();i++){
        while(it.hasNext()){
            driver.switchTo().window(it.next());
            System.out.println(driver.getTitle());
        }

    }
}
