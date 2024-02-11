package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.Iterator;
import java.util.List;

public class Calender {
    public static void main(String[] args) {
        WebDriver driver = new ChromeDriver();
        driver.get("https://www.path2usa.com/travel-companions");
        driver.findElement(By.cssSelector("input[id='form-field-travel_comp_date']")).click();
        //driver.findElements(By.)
        List<WebElement> dates= driver.findElements(By.xpath("//div[@class='dayContainer']"));
        int size = driver.findElements(By.className("flatpickr-day ")).size();
        for (int i=0;i<size;i++){
            String text = driver.findElements(By.className("flatpickr-day ")).get(i).getText();
            if (text.equalsIgnoreCase("23")){
                driver.findElements(By.className("flatpickr-day ")).get(i).click();
                break;
            }
        }



    }
}
