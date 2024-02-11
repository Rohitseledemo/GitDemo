package org.example;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class locators {
    public static void main(String[] args) throws InterruptedException {
        WebDriver driver = new ChromeDriver();
        //implicit wait call after making driver object
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        System.setProperty("web-driver.chrome.driver", "C:\\Users\\91844\\OneDrive\\Documents\\chromedriver-win64\\chromedriver.exe");
        driver.get("https://rahulshettyacademy.com/locatorspractice/");
        System.out.println(driver.getCurrentUrl());
        System.out.println(driver.getTitle());
        //info extracted from inspect from webpage = " <input type="text" placeholder="Username" id="inputUsername" value=" ">
        driver.findElement(By.id("inputUsername")).sendKeys("Rohit");
        //info extracted from inspect from webpage = " <input type="password" placeholder="Password" name="inputPassword" value="" fdprocessedid="g5zjvp">"
        driver.findElement(By.name("inputPassword")).sendKeys("Rohit@123");
        // clicking on signin button " <button class="submit signInBtn" type="submit" fdprocessedid="176iji">Sign In</button>
        driver.findElement(By.className("signInBtn")).click();
        // clicking on incorrect username or password " <p class="error">* Incorrect username or password </p> "
        System.out.println(driver.findElement(By.cssSelector("p.error")).getText());
        driver.findElement(By.linkText("Forgot your password?")).click();
        Thread.sleep(1000);
        //<input type="text" placeholder="Name" fdprocessedid="asbu1i">
        driver.findElement(By.xpath("//input[@placeholder='Name']")).sendKeys("Rohit Kumar");
        //<input type="text" placeholder="Email" fdprocessedid="b97cnx">
        driver.findElement(By.cssSelector("input[placeholder='Email']")).sendKeys("rohit.kumar24@gmail.com");
        //<input type="text" placeholder="Phone Number" fdprocessedid="7ih6o">
        driver.findElement(By.xpath("//form/input[3]")).sendKeys("8447733521");
        //<button class="reset-pwd-btn" fdprocessedid="4cfab">Reset Login</button>
        //<button class="reset-pwd-btn">Reset Login</button>
        driver.findElement(By.cssSelector(".reset-pwd-btn")).click();
        //<p class="infoMsg">Please use temporary password 'rahulshettyacademy' to Login. </p>
        System.out.println(driver.findElement(By.cssSelector("form p")).getText());
        driver.findElement(By.cssSelector(".go-to-login-btn")).click();
        Thread.sleep(1000);
        driver.findElement(By.id("inputUsername")).sendKeys("Rohit");
        driver.findElement(By.name("inputPassword")).sendKeys("rahulshettyacademy");
        driver.findElement(By.className("signInBtn")).click();
        //Runnable


        driver.quit();

    }
}
