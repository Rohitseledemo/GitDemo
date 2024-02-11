package org.example;

//import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.asserts.SoftAssert;

import java.io.File;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.util.List;

public class BrokenLinks {
    public static void main(String[] args) throws IOException {
        WebDriver driver = new ChromeDriver();
        driver.get("https://www.rahulshettyacademy.com/AutomationPractice/");
        List<WebElement> links = driver.findElements(By.xpath("//div[@id='gf-BIG']//a"));
        SoftAssert a = new SoftAssert();
        for (WebElement link : links){
            String url =  link.getAttribute("href");
            HttpURLConnection conn= (HttpURLConnection) new URL(url).openConnection();
            conn.setRequestMethod("HEAD");
            conn.connect();
            int respCode = conn.getResponseCode();
            System.out.println(respCode);
            a.assertTrue(respCode<400, "The link with Text"+link.getText()+" is broken with code" +respCode);//this stores all the errors but also continue with the execution
        }
            a.assertAll();//this reports all the errors stored by a.assertTrue. Mandatory to use at last
    }
}
