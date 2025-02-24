package automation.selenium.java;

import java.io.File;
import java.io.IOException;
import java.time.Duration;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Scheduling_Dashboard_OCR {

	@SuppressWarnings("unused")
	public static void main(String[] args) throws InterruptedException, IOException {
		
		 System.setProperty("Webdriver.chrome.driver", "C:\\Selenium\\chromedriver-win64\\chromedriver.exe");  
         
         
         WebDriver driver=new ChromeDriver();
         
         WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(60));
         
        
         driver.manage().window().maximize();
         
         driver.get("https://preprodapi.yosicare.com/r/4wg294798GMv");
         
         WebElement lan=
         driver.findElement(By.xpath("//span[@class='select2-selection__placeholder']"));
         
         lan.click();
         
         Actions ac=new Actions(driver);
         
         ac.moveToElement(lan).keyDown(Keys.ENTER).perform();
         
         driver.findElement(By.xpath("//button[contains(text(),'Start Registration')]")).click();
         
         Thread.sleep(3000);
         WebElement dob=
         driver.findElement(By.xpath("//input[@data-labelname='Patient Date of Birth']"));
         
         dob.sendKeys("01/01/1990");
         
         Actions ad=new Actions(driver);
         
         ad.moveToElement(dob).keyDown(Keys.ENTER).perform();
         
         driver.findElement(By.xpath("//label[contains(.,'Myself')]")).click();
         
         driver.findElement(By.xpath("(//button[contains(.,'Continue')])[1]")).click();
         
         Thread.sleep(6000);
         
         wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[@id='button_47771']"))).click();
         
         JavascriptExecutor js7=(JavascriptExecutor)driver;
         
         wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//label[contains(.,'Yes')])[1]"))).click();
 		
 		Thread.sleep(2000);
 		
 		WebElement ia=wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//select[@placeholder='Please select an option below']")));
 		
 		Select stt=new Select(ia);
 		stt.selectByVisibleText("Self");
 		

 		
 		
 		WebElement front=driver.findElement(By.xpath("//div[@id='upload-aphoto']"));

 		js7.executeScript("arguments[0].scrollIntoView(true);", front);        		 
 		Thread.sleep(3000);
 		 
 		driver.findElement(By.xpath("//*[@id='selectedFile']")).sendKeys("C:\\Automation-RTE\\insurance_front_Jennifer.jpg");
 		
 		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//div[contains(.,'Save')])[10]"))).click();
 				
				
 		
 		Thread.sleep(6000);
 		WebElement back=driver.findElement(By.xpath("//div[@id='upload-aphoto1']"));
 		
 		JavascriptExecutor js8=(JavascriptExecutor)driver;
 		
 		js8.executeScript("arguments[0].scrollIntoView(true);", back);        		 
 		Thread.sleep(3000);
 		 
 		driver.findElement(By.xpath("//*[@id='selectedFile1']")).sendKeys("C:\\Automation-RTE\\insurance_back_Jennifer.jpg");
 		
 		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//div[contains(.,'Save')])[10]"))).click();
 		
 		
 		Thread.sleep(15000);
 		
 		WebElement firstn=wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@data-labelname='Policy Holder First Name']")));
 		firstn.clear();
 		firstn.sendKeys("JENNIFER");
 		
 		WebElement lastn=wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@data-labelname='Policy Holder Last Name']")));
 		lastn.clear();
 		lastn.sendKeys("TESTPATIENT");
 		
 		WebElement dobb=wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@data-labelname='Policy Holder DOB']")));
 		dobb.clear();
 		dobb.sendKeys("03/16/1978");
 		
 		Thread.sleep(3000);
 		
 		
 		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[@id='button_47774']"))).click();
 		
 		Thread.sleep(8000);
 		
 		
 		
 		
 		
File sch=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		
		File dest=new File("C:\\RTE_Eligibity_Automation_Evidences\\RTE_Failure1.jpeg");
		
		FileUtils.copyFile(sch, dest);
		
 		
 		
         
        
		
		

	}

}
