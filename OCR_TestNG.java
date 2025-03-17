package automation.selenium.java;

import java.io.File;
import java.io.IOException;
import java.time.Duration;

import org.apache.commons.io.FileUtils;
import org.testng.annotations.Test;
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
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public class Scheduling_Dashboard_OCR {

	
	    WebDriver driver;
		WebDriverWait wait;
		
		
     String frontImage = "C:\\Automation-RTE\\insurance_front_Jennifer.jpg";
     String backImage = "C:\\Automation-RTE\\insurance_back_Jennifer.jpg";
     
     
	@SuppressWarnings("unused")
	public static void main(String[] args) throws InterruptedException, IOException {
	  		
	}
		
		@BeforeMethod
		
		public void setDriver() {
		 System.setProperty("Webdriver.chrome.driver", "C:\\Selenium\\chromedriver-win64\\chromedriver.exe");  
         
         
         driver=new ChromeDriver();
         
         wait=new WebDriverWait(driver, Duration.ofSeconds(60));
         
     
         
		}
       
         
         @Test
         
         public void testOCR() throws IOException, InterruptedException {
         driver.get("https://preprodapp.yosicare.com/landing.php?action=&invite_id=4e04b86f9ccbdeb44cb20b6be49db07bb22b151205b8&lang=sp&source=Email");
         driver.manage().window().maximize();
         
         WebElement lan=
         driver.findElement(By.xpath("//span[@class='select2-selection__placeholder']"));
         
         lan.click();
         
         Actions ac=new Actions(driver);
         
         ac.moveToElement(lan).keyDown(Keys.ENTER).perform();
         
//         driver.findElement(By.xpath("//button[text()='Confirmation']")).click();
         
         Thread.sleep(3000);
         
         wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[contains(.,' Edit Registration')]"))).click();
         WebElement dob=
         wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@data-labelname='Patient Date of Birth']")));
         
         dob.sendKeys("01/01/1990");
         
         Actions ad=new Actions(driver);
         
         ad.moveToElement(dob).keyDown(Keys.ENTER).perform();
         
         driver.findElement(By.xpath("//label[contains(.,'Myself')]")).click();
         
         driver.findElement(By.xpath("(//button[contains(.,'Continue')])[1]")).click();
         
         Thread.sleep(6000);
         
         WebElement butt=
         wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[@id='button_47771']")));
         butt.click();
         
         JavascriptExecutor js7=(JavascriptExecutor)driver;
         js7.executeScript("arguments[0].scrollIntoView(true);", butt); 
         
         
         WebElement clk=
         wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//label[contains(.,'Yes')])[1]")));
         clk.click();
 		
 		Thread.sleep(2000);
 		
 		//FIRST INSURANCE
 		
 		WebElement ia=wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//select[@placeholder='Please select an option below']")));
 		
 		Select stt=new Select(ia);
 		stt.selectByVisibleText("Self");
 		
 		
 		
 		WebElement front=driver.findElement(By.xpath("//div[@id='upload-aphoto']"));

 		js7.executeScript("arguments[0].scrollIntoView(true);", front);        		 
 		Thread.sleep(3000);
 		 
 		driver.findElement(By.xpath("//*[@id='selectedFile']")).sendKeys(frontImage);
 		
 		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//div[contains(.,'Save')])[10]"))).click();
 				
				
 		
 		Thread.sleep(6000);
 		WebElement back=driver.findElement(By.xpath("//div[@id='upload-aphoto1']"));
 		
 		JavascriptExecutor js8=(JavascriptExecutor)driver;
 		
 		js8.executeScript("arguments[0].scrollIntoView(true);", back);        		 
 		Thread.sleep(3000);
 		 
 		driver.findElement(By.xpath("//*[@id='selectedFile1']")).sendKeys(backImage);
 		
 		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//div[contains(.,'Save')])[10]"))).click();
 		
 		
 		Thread.sleep(7000);
 		
 		WebElement firstn=wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@data-labelname='Policy Holder First Name']")));
 		firstn.clear();
 		firstn.sendKeys("JENNIFER");
 		
 		WebElement lastn=wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@data-labelname='Policy Holder Last Name']")));
 		lastn.clear();
 		lastn.sendKeys("SMITH");
 		
 		WebElement dobb=wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@data-labelname='Policy Holder DOB']")));
 		dobb.clear();
 		dobb.sendKeys("03/16/1978");
 		dobb.sendKeys(Keys.ENTER);
 		
 		
 		Thread.sleep(6000);
 		
 		
 		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//button[text()='Continue'])[1]"))).click();
 		
 		Thread.sleep(8000);
 		
 		
 		
// 		WebElement nxt=
// 		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@id='more_ins_yes']")));
// 		nxt.click();
// 		
// 		if(!nxt.isDisplayed()) {
// 			System.out.println("1ST INSURANCE-OCR Eligibility Failed!");
// 		}else
// 			System.out.println("1ST INSURANCE-OCR Eligibility Passed!");
 		
 		
 		//SECOND INSURANCE
 		
WebElement iat=
wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//select[@placeholder='Please select an option below'])[2]")));
 	

if(iat.isDisplayed()) {
	System.out.println("1ST INSURANCE-OCR ELIGIBILITY PASSED!");
}else 
	System.out.println("1ST INSURANCE-OCR ELIGIBILITY FAILED!");
 		


Select std=new Select(iat);
 		std.selectByVisibleText("Self");
 		

 		
 		
 		WebElement front1=driver.findElement(By.xpath("(//div[@id='upload-aphoto'])[2]"));

 		js7.executeScript("arguments[0].scrollIntoView(true);", front1);        		 
 		Thread.sleep(3000);
 		 
 		driver.findElement(By.xpath("(//*[@id='selectedFile'])[2]")).sendKeys(frontImage);
 		
 		
 		
 		
 		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//div[contains(.,'Save')])[10]"))).click();
 				
				
 		
 		Thread.sleep(3000);
 		WebElement back1=driver.findElement(By.xpath("(//div[@id='upload-aphoto1'])[2]"));
 		
 		JavascriptExecutor js9=(JavascriptExecutor)driver;
 		
 		js9.executeScript("arguments[0].scrollIntoView(true);", back1);        		 
 		Thread.sleep(3000);
 		 
 		driver.findElement(By.xpath("(//*[@id='selectedFile1'])[2]")).sendKeys(backImage);
 		
 		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//div[contains(.,'Save')])[10]"))).click();
 		
 		
 		Thread.sleep(7000);
 		
 		WebElement firstn1=wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//input[@data-labelname='Policy Holder First Name'])[2]")));
 		firstn1.clear();
 		firstn1.sendKeys("PRANESH");
 		
 		WebElement lastn1=wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//input[@data-labelname='Policy Holder Last Name'])[2]")));
 		lastn1.clear();
 		lastn1.sendKeys("TESTPATIENT");
 		
 		WebElement dobb1=wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//input[@data-labelname='Policy Holder DOB'])[2]")));
 		dobb1.clear();
 		dobb1.sendKeys("07/08/1999");
 		
 		Thread.sleep(3000);
 		
 		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[@id='button_47774']"))).click();
 		
 		
 		
 		
 		
 		
 		WebElement e=
 	wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//p[contains(text(),'We were unable to confirm active insurance eligibility')]")));
 		
 		if(e.getText().
 equalsIgnoreCase("We were unable to confirm active insurance eligibility. Kindly verify your coverage with your insurance provider. You also have the option to proceed with your intake using out-of-pocket payment.")){ 		 
 			System.out.println("2ND INSURANCE-OCR Eligibility failed!");
 		}else
 			System.out.println("2ND INSURANCE-OCR Eligibility successfull!");
 		
 		String exp=e.getText();
 		String act="We were unable to confirm active insurance eligibility. Kindly verify your coverage with your insurance provider. You also have the option to proceed with your intake using out-of-pocket payment.";
 		
 	if(exp==act) {
 		System.out.println("OCR Eligibility successfull in 2nd condition too!");
 	}else
 		System.out.println("OCR Eligibility not successfull in 2nd condition too!");
 		
 		
 		
 	
        File sch=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		
		File dest=new File("C:\\RTE_Eligibity_Automation_Evidences\\RTE_Failure2.jpeg");
		
		FileUtils.copyFile(sch, dest);
		
		
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//btn//span[text()='Skip']"))).click();
		
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//span[text()='+ Add Record'])[2]"))).click();
		
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//div[text()='+ Add New Record'])[4]"))).click();
		
		WebElement ag=
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[@id='select2-allergy-q2-container']")));
		
		ag.click();
		
		Actions allergy=new Actions(driver);
		
		allergy.moveToElement(ag).keyDown(Keys.ENTER).perform();
		
		
		WebElement ai=wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[@id='select2-reaction-hr-container']")));
		ai.click();
		
		Actions reaction=new Actions(driver);
		
		reaction.moveToElement(ai).keyDown(Keys.ENTER).perform();
		
		WebElement sy=wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[text()='Specify the severity of your allergic reaction.']")));
		sy.click();
		
		Actions severity=new Actions(driver);
		
		severity.moveToElement(sy).keyDown(Keys.ENTER).perform();
		
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//span[text()='+ Add'])[4]"))).click();
		
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//span[contains(.,'Continue')])[1]"))).click();
		
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//span[contains(.,'Yes, I want to proceed')])[1]"))).click();
		
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//span[contains(.,'Continue')])[1]"))).click();
		
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//span[contains(.,'Yes, I want to proceed')])[1]"))).click();
		
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[@id='button_47773']"))).click();
         }

		
		
		
		@AfterMethod
		public void driverClose() {
		if(driver !=null) {
			driver.quit();
		}
	}
		
}

		
		
		

		
 		
 		
         
        
		
		

	


