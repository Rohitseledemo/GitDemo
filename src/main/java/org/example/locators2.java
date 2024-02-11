package org.example;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.w3c.dom.Text;
import java.time.Duration;


//class TextNotFoundException  extends Exception{
//     TextNotFoundException(String errMessage){
//          super(errMessage);
//     }

public class locators2 {
   public static void main(String[] args) throws InterruptedException {
        String name = "Rohit";
        WebDriver driver = new ChromeDriver();
        //implicit wait call after making driver object
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        String Password=GetPassword(driver);
        System.setProperty("web-driver.chrome.driver", "C:\\Users\\91844\\OneDrive\\Documents\\chromedriver-win64\\chromedriver.exe");
        driver.get("https://rahulshettyacademy.com/locatorspractice/");
        System.out.println(driver.getCurrentUrl());
        System.out.println(driver.getTitle());
        driver.findElement(By.id("inputUsername")).sendKeys(name);
        driver.findElement(By.name("inputPassword")).sendKeys(Password);
        driver.findElement(By.className("signInBtn")).click();
        Thread.sleep(2000);
        System.out.println(driver.findElement(By.tagName("p")).getText());
        try{
           Assert.assertEquals(driver.findElement(By.tagName("p")).getText(), "You are successfully logged in.");
        }
        catch(Exception e){
             System.out.println("Text  not found");
        }
        finally {
             Assert.assertEquals(driver.findElement(By.cssSelector("div[class='login-container'] h2")).getText(),"Hello "+name+",");
        }
        driver.findElement(By.className("logout-btn")).click();
        driver.close();

    }
      public static String GetPassword(WebDriver driver){
           driver.get("https://rahulshettyacademy.com/locatorspractice/");
           driver.findElement(By.linkText("Forgot your password?")).click();
           try {
                Thread.sleep(2000);
           } catch (InterruptedException e) {
                throw new RuntimeException(e);
           }
           driver.findElement(By.cssSelector(".reset-pwd-btn")).click();
           String PasswordText = driver.findElement(By.cssSelector("form p")).getText();
           //Please use temporary password 'rahulshettyacademy' to Login.
           System.out.println(PasswordText);
           String[] PasswordSplit = PasswordText.split("'");
           //rahulshettyacademy' to Login.
           //String[] Password= PasswordSplit[1].split("'");
           String password = PasswordSplit[1].split("'")[0];
           return password;
      }

}
