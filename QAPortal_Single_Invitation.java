package automation.selenium.java;

import java.time.Duration;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class QADashboard {

	public static void main(String[] args) throws InterruptedException {
		
     System.setProperty("Webdriver.chrome.driver", "C:\\Selenium\\chromedriver-win64\\chromedriver.exe");
		
	 WebDriver driver=new ChromeDriver();
	 
	 
	 
	 
		
     WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(7));

     driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(8));

     driver.get("https://qaportal.yosicare.com/");
     
     driver.manage().window().maximize();
     
     
     wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@id='email']"))).sendKeys("500000qa@yopmail.com");
     
     wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@id='password']"))).sendKeys("YosiJan2026$");
     
     
     wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//input[@type='submit']"))).click();
     
     
     driver.findElement(By.xpath("(//div//span[contains(text(),'Select Your Location')])[2]")).click();
     
     driver.findElement(By.xpath("(//ul//li[text()='ST MARY 01'])[2]")).click();
     
    
     
    	 
    	 
     driver.findElement(By.xpath("//a[text()='Invite Patients']")).click();
     
     wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//*[text()='Single Invitation'])[1]"))).click();
     
    

     
     wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@placeholder='First Name']"))).sendKeys("DAISY");
     
     wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@placeholder='Last Name']"))).sendKeys("Testpatient");
     
     driver.findElement(By.xpath("//*[@id='dob_datepicker']")).sendKeys("07/08/1999");
     
     
     WebElement gender=driver.findElement(By.xpath("//div//span[text()='Gender']"));
     
     JavascriptExecutor js1 = (JavascriptExecutor) driver;
     js1.executeScript("arguments[0].click();", gender);
     
     WebElement female=driver.findElement(By.xpath("//li[text()='Female']"));
     JavascriptExecutor js2 = (JavascriptExecutor) driver;
     js2.executeScript("arguments[0].click();", female);
     
     wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@placeholder='Phone Number']"))).sendKeys("9147528040");
     
     wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("email"))).sendKeys("praneshbalamurugan.m@yosicare.com");
     
     WebElement datetime=wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@placeholder='Appt.Date']")));
     datetime.clear();
     datetime.sendKeys("01/27/2026 11:00 PM");
     datetime.click();
     
     
     driver.findElement(By.xpath("(//*[@class='nice-select wide locationone required-now'])[1]")).click();
     driver.findElement(By.xpath("//ul//li[text()='NP - NEW PATIENT (19)']")).click();
     
     driver.findElement(By.xpath("(//div//*[text()='Provider'])[2]")).click();
     driver.findElement(By.xpath("//ul//li[contains(.,'ADAMS,ARTHUR (17)')]")).click();
     
    
     
     driver.findElement(By.xpath("//div//span[text()='Location']")).click();
     
     driver.findElement(By.xpath("(//ul//li[contains(.,'ST MARY 01')])[2]")).click();
     
     
     wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@value='Send SMS']"))).click();
   
   
    }
   
	}


