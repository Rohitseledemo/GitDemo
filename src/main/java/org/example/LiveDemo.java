package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

import java.util.List;
import java.util.stream.Collectors;

public class LiveDemo {
    public static void main(String[] args) {
        WebDriver driver = new ChromeDriver();
        driver.get("https://rahulshettyacademy.com/seleniumPractise/#/offers");
        driver.findElement(By.xpath("//th[@role='columnheader'][1]")).click();
        List<WebElement> fruits = driver.findElements(By.xpath("//tr//td[1]"));
        List<String> orgList=fruits.stream().map(s->s.getText()).collect(Collectors.toList());
        List<String> sortList= orgList.stream().sorted().collect(Collectors.toList());
        Assert.assertEquals(sortList, orgList);
        //get the price of banana
        List<String> price;
        do {
            List<WebElement> fruits1 = driver.findElements(By.xpath("//tr//td[1]"));
            price = fruits.stream().filter(s -> s.getText().contains("rice")).map(m -> veggiePrice(m))
                    .collect(Collectors.toList());
            price.forEach(a -> System.out.println(a));
            if (price.isEmpty()) {
                driver.findElement(By.cssSelector("[aria-label='Next']")).click();
            }
        }while(price.isEmpty());





    }

    private static String veggiePrice(WebElement m) {
        String priceValue = m.findElement(By.xpath("following-sibling::td[1]")).getText();
         return priceValue;
    }
}
