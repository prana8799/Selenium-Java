package automation.selenium.java;

import java.time.Duration;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

@SuppressWarnings("unused")
public class Preprod_Customer_Support_Portal {

	public static void main(String[] args) throws InterruptedException {
 System.setProperty("Webdriver.chrome.driver", "C:\\Selenium\\chromedriver-win64\\chromedriver.exe");  
         
         
         WebDriver driver=new ChromeDriver();
         
         WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(60));
         
         driver.manage().window().maximize();
         
         driver.get("https://preprodinternal.yosicare.com/");
         
         driver.findElement(By.xpath("//a[contains(.,' Customer Support ')]")).click();
         
         wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='email']"))).sendKeys("praneshbalamurugan.m@yosicare.com");
         
         wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='password']"))).sendKeys("Yosi@12345");
         
         wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[text()='Login']"))).click();
         
         WebElement req=wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[text()='Required']")));
         
         if(req.isDisplayed()) {
        	 System.out.println("Required displayed!");
         }else
        	 System.out.println("Required not displayed!");
         
//         Assert.assertEquals(req, "required");
    
         
         
         WebElement emr=wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div//span[text()='Select EMR']")));
         emr.click();
         
         Actions ath=new Actions(driver);
         
         ath.moveToElement(emr).keyDown(Keys.ARROW_DOWN)
         .sendKeys("Athena")
         .keyDown(Keys.ENTER).perform();
         
         wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[text()='Advanced search']"))).click();
         
         wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@placeholder='Practice ID']"))).sendKeys("777801");
         
         wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='firstname']"))).sendKeys("LORI");
         
         wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//i[@class='fa fa-search']"))).click();
         
         wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[@title='LORI TESTPATIENT']"))).click();
         
         Thread.sleep(10000);
         
         WebElement policy=wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("(//div[@class='card-header'])[6]")));
         
         JavascriptExecutor js=(JavascriptExecutor) driver;
         js.executeScript("arguments[0].scrollIntoView(true);", policy);
         
         Thread.sleep(10000);

         
    WebElement srh=wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[text()='Return to search results']")));
    
    js.executeScript("arguments[0].scrollIntoView(true);", srh);
    
    Thread.sleep(5000);
    
    srh.click();
    
   
         
         
        
	}
}
         
             
         

	


