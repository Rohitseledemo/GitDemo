package org.example;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Main {
    public static void main(String[] args){
        // TODO Invoking a browser eg. chrome driver
        // there is a class named ChromeDriver, FirefoxDriver, etc for all browsers
        // and there is an interface named "WebDriver" whose methods are implemented by all browsers.
        // invoking a chrome class through object
        //ChromeDriver driver = new ChromeDriver();
        // this will also implement the methods of chrome driver
        //which makes it not working for other browsers.Therefore..-->
        // ChromeDriver.exe is a third party library provided by the chrome to invoke the browser
        // Due to every browser restrictions Selenium cannot invoke directly.
        // Selenium manager is a pkg ensures for us that .exe file is requested from browser
        // so we don't have to call or download it manually
        System.setProperty("web-driver.chrome.driver", "C:\\Users\\91844\\OneDrive\\Documents\\chromedriver-win64\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.get("https://www.javatpoint.com/post/java-system-setproperty-method");
        System.out.println(driver.getTitle());
        System.out.println(driver.getCurrentUrl());
        driver.quit();
    }
}