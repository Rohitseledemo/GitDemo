package org.example;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.io.File;
import java.io.IOException;

public class SSLcheck {
    public static void main(String[] args) throws IOException {
        ChromeOptions options = new ChromeOptions();
        options.setAcceptInsecureCerts(true);
       // options.addExtensions("")
        WebDriver driver = new ChromeDriver(options);
        driver.get("https://commons.apache.org/proper/commons-io/download_io.cgi");
        File src = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
        FileUtils.copyFile(src,new File("D://Seleniumscreenshot.png"));

    }
}
