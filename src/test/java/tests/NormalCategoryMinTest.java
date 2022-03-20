package tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.Test;

public class NormalCategoryMinTest {
    WebDriver driver;
    @Test
    public void normalCategoryMinTest(){
        System.setProperty("webdriver.chrome.driver", "src/test/resources/chromedriver.exe");
        driver = new ChromeDriver();
        driver.get("https://healthunify.com/bmicalculator/");
        driver.findElement(By.xpath("//input[@name='wg']")).sendKeys("61.98");
        driver.findElement(By.xpath("//select[@name='opt2']")).click();
        driver.findElement(By.xpath("//option[@value='6']")).click();
        driver.findElement(By.xpath("//input[@value='Calculate']")).click();
        String sIUnits = driver.findElement(By.xpath("//input[@name='si']")).getAttribute("value");
        String uSUnits = driver.findElement(By.xpath("//input[@name='us']")).getAttribute("value");
        String uKUnits = driver.findElement(By.xpath("//input[@name='uk']")).getAttribute("value");
        String message = driver.findElement(By.xpath("//input[@name='desc']")).getAttribute("value");
        Assert.assertEquals(sIUnits, "18.51");
        Assert.assertEquals(uSUnits, "18.82");
        Assert.assertEquals(uKUnits, "117.54");
        Assert.assertEquals(message, "Your category is Normal");
    }
    @AfterClass
    public void closeBrowser(){
        driver.quit();
    }
}
