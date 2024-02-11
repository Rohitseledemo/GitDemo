package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;

public class Irctcbook {
    public static void main(String[] args) throws InterruptedException {
        WebDriver driver = new ChromeDriver();
        driver.get("https://www.irctc.co.in/nget/train-search");
        driver.findElement(By.cssSelector(".ng-tns-c57-8.ui-inputtext.ui-widget.ui-state-default.ui-corner-all.ui-autocomplete-input.ng-star-inserted")).sendKeys("Niza");
        Thread.sleep(2000);
        List<WebElement> options = driver.findElements(By.cssSelector(".ng-tns-c57-8.ui-autocomplete.ui-widget"));
        for(WebElement option : options){
            if (option.getText().equalsIgnoreCase("NEW DELHI")){
                option.click();
                break;
            }
        }
    }
}
