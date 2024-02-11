package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.ElementClickInterceptedException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class Assignment3 {
    public static void main(String[] args){
        WebDriver driver = new ChromeDriver();
        driver.get("https://rahulshettyacademy.com/loginpagePractise/");
        driver.findElement(By.id("username")).sendKeys("rahulshettyacademy");
        driver.findElement(By.id("password")).sendKeys("learning");
        driver.findElement(By.cssSelector(".customradio:nth-child(2)")).click();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(3));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("okayBtn"))).click();
        WebElement element = driver.findElement(By.xpath("//select[@class='form-control']"));
        Select dropdown = new Select(element);
        dropdown.selectByIndex(0);
        driver.findElement(By.cssSelector("input[id='terms']")).click();
        driver.findElement(By.cssSelector("input[id='signInBtn']")).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//h1[text()='Shop Name']")));
        List<WebElement> phones = driver.findElements(By.cssSelector(".card-footer .btn-info"));
        for (WebElement phone : phones) {
            phone.click();
        }
        driver.findElement(By.partialLinkText("Checkout")).click();
        driver.close();
    }

    }

