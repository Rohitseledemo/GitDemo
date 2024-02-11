package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

import java.util.List;

public class DropDowns {
    public static void main(String[] args) throws InterruptedException {
        WebDriver driver = new ChromeDriver();
        driver.get("https://rahulshettyacademy.com/dropdownsPractise/");
        // handling static dropdowns using Select class
        WebElement element = driver.findElement(By.id("ctl00_mainContent_DropDownListCurrency"));
        Select dropdown = new Select(element);
        dropdown.selectByIndex(1);
        dropdown.selectByVisibleText("INR");
        driver.findElement(By.id("divpaxinfo")).click();
        Thread.sleep(1000);
        int i =1;
        while(i<=5) {
            driver.findElement(By.id("hrefIncAdt")).click();
            i++;
        }
        driver.findElement(By.id("btnclosepaxoption")).click();
        //System.out.println(driver.findElement(By.id("divpaxinfo")).getText());
        Assert.assertEquals(driver.findElement(By.id("divpaxinfo")).getText(), "6 Adult");
        driver.findElement(By.id("ctl00_mainContent_ddl_originStation1_CTXT")).click();
        driver.findElement(By.xpath("//a[@value='BLR']")).click();
        Thread.sleep(1000);
        // driver.findElement(By.xpath("(//a[@value='MAA'])[2]")).click();
        // parent - child xpath traverse because sometimes coding standards dont allow us to use indexing in xpath
        driver.findElement(By.xpath("//div[@id='glsctl00_mainContent_ddl_destinationStation1_CTNR'] //a[@value='MAA']")).click();
        driver.findElement(By.xpath("//*[@id='ctl00_mainContent_view_date1']")).click();
        //driver.findElement(By.cssSelector(".ui-state-default.ui-state-highlight.ui-state-active")).click();
        driver.findElement(By.id("autosuggest")).sendKeys("Au");
        Thread.sleep(1000);
        List<WebElement> options = driver.findElements(By.xpath("//li[@class='ui-menu-item']"));
        for(WebElement allelement : options){
            if (allelement.getText().equalsIgnoreCase("Palau")){
                allelement.click();
                break;
            }
        }
        driver.findElement(By.cssSelector("input[id*='friendsandfamily']")).click();
        Assert.assertTrue(driver.findElement(By.cssSelector("input[id*='friendsandfamily']")).isSelected());
        List<WebElement> checkbox = driver.findElements(By.xpath("//input[@type='checkbox']"));
        System.out.println("The number of check boxes in this webpage are = " + checkbox.size()+ " checkboxes");
        driver.findElement(By.id("ctl00_mainContent_rbtnl_Trip_1")).click();
        if(driver.findElement(By.id("Div1")).getAttribute("style").contains("1"))
        {
            Assert.assertTrue(true);
        }
        else{
            Assert.assertTrue(false);
        }






    }

    }

