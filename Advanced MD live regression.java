package automation.selenium.java;

import java.awt.RenderingHints.Key;
import java.io.File;
import java.io.IOException;
import java.sql.DriverManager;
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
import org.openqa.selenium.support.ui.WebDriverWait;

public class AdvancedMD_Scheduling {

	public static void main(String[] args) throws InterruptedException, IOException {
		

		System.setProperty("Webdriver.chrome.driver", "C:\\Selenium\\chromedriver-win64\\chromedriver.exe");

		WebDriver driver = new ChromeDriver();

		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(270));

		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));

		driver.get("https://schedule.yosicare.com/09fb52a829cbccd96deacda4b8cbdf40");

		driver.manage().window().maximize();

		driver.findElement(By.xpath("//*[@optval='Sick Visit']")).click();

		driver.findElement(By.xpath("//*[@optval='Georgia']")).click();

		driver.findElement(By.xpath("//span[text()='YOSI FOLLOW UP']")).click();

		driver.findElement(By.xpath("//p[text()='AdvancedMD Test-02']")).click();

//		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//b[text()='View more availability']"))).click();
		
	
		driver.findElement(By.xpath("(//div[@class=\"flex flex-col slotgroup\"])[1]")).click();
		

		Thread.sleep(2000);

		driver.findElement(By.xpath("//*[@name='patient_first_name']")).sendKeys("Preethi");

		driver.findElement(By.xpath("//*[@name='patient_last_name']")).sendKeys("Testpatient");

		WebElement dob = driver.findElement(By.id("patient_dob"));

		dob.sendKeys("07/08/1999");

		driver.findElement(By.xpath("//td[@data-year='1999']//a[text()='8']")).click();

		driver.findElement(By.xpath("//input[@optval='female']")).click();

		Thread.sleep(3000);

		driver.findElement(By.xpath("//input[@type='tel' and @maxlength='14']")).sendKeys("9147528040");

		driver.findElement(By.name("patient_email")).sendKeys("praneshbalamurugan.m@yosicare.com");

		driver.findElement(By.xpath("//*[@name='patient_address1']")).sendKeys("XYZ STREET");

		driver.findElement(By.xpath("//*[@name='patient_address2']")).sendKeys("26TH AVENUE");

		driver.findElement(By.name("patient_zip")).sendKeys("12345");

		Thread.sleep(5000);

		wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("walkin_notes")))
				.sendKeys("Test - Advanced MD");

		Thread.sleep(6000);

		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div//label[contains(text(),'No')]"))).click();
		
		driver.findElement(By.xpath("(//button[text()='Book Appointment'])[2]")).click();
		
		Thread.sleep(3000);
		
		driver.findElement(By.xpath("//button[text()='Start Check-in']")).click();
		
		Thread.sleep(2000);
		
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//b[@role='presentation'])[1]"))).click();
		
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//span[contains(.,'Single')])[1]"))).click();
		
		driver.findElement(By.xpath("//input[@data-labelname='SSN']")).sendKeys("111111111");
		
		Thread.sleep(4000);

		WebElement race=
		
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//span[@class='select2-selection select2-selection--single'])[2]")));
		race.click();
		
		
		Actions actions=new Actions(driver);
		
		actions.moveToElement(race).keyDown(Keys.ARROW_DOWN).keyDown(Keys.ENTER).perform();
		
		Thread.sleep(6000);
		
		Actions a=new Actions(driver);

		WebElement ethnicity= wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[text()='Please select an option below']/parent::span[@data-labelname='Ethnicity']")));
		
		JavascriptExecutor j=(JavascriptExecutor) driver;
		
		j.executeScript("arguments[0].click()", j);
		
		Actions cl=new Actions(driver);
		
	
		
		cl.moveToElement(ethnicity).keyDown(Keys.ARROW_DOWN).keyUp(Keys.ARROW_DOWN).keyDown(Keys.ENTER).perform();
		
		

		
		if(!ethnicity.isDisplayed()) {
			System.out.println("Ethnicity not displaying");
		}else
			System.out.println("Ethnicity displaying");
		
		
		
      
		
		
		Thread.sleep(4000);
		
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@data-labelname='Home Phone']"))).sendKeys("9147528040");
		
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@data-labelname='Work Phone']"))).sendKeys("9147528040");
		
		Thread.sleep(4000);

		driver.findElement(By.xpath("//*[@data-labelname='First Name']")).sendKeys("CLARA");
		
		driver.findElement(By.xpath("//*[@data-labelname='Last Name']")).sendKeys("TESTPATIENT");
		
		driver.findElement(By.xpath("//*[@data-labelname='Mobile Phone']")).sendKeys("9147528040");
		
		Thread.sleep(5000);
		
		WebElement relationship=
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//span[@class='select2-selection select2-selection--single'])[5]")));
		relationship.click();
		
         Actions actions2=new Actions(driver);
		
		actions2.moveToElement(relationship).keyDown(Keys.ARROW_DOWN).keyDown(Keys.ENTER).perform();
		
		
		
		
		Thread.sleep(4000);
		
		driver.findElement(By.xpath("//*[@data-labelname='Address1']")).sendKeys("TQ, JAINS APARTMENTS");
		
		driver.findElement(By.xpath("//*[@data-labelname='Address2']")).sendKeys("PQT LAYOUT");
		
		driver.findElement(By.xpath("//*[@data-labelname='Zip Code']")).sendKeys("45321");
		
		Thread.sleep(5000);
		
        File schh=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		
		File loch=new File("C:\\Advanced MD regression testing screenshots\\Regression.jpeg");
		
		FileUtils.copyFile(schh, loch);
		
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[@type='submit']"))).click();
		
		
		Thread.sleep(4000);
		
		WebElement guarantor=
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//b[@role='presentation']")));
		
		guarantor.click();
		
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[contains(.,'Self')][1]"))).click();
		
		Thread.sleep(4000);
		
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@data-labelname='SSN']"))).sendKeys("111111111");
		
		Thread.sleep(5000);
		
        File sch=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		
		File loc=new File("C:\\Advanced MD regression testing screenshots\\Regression.jpeg");
		
		FileUtils.copyFile(sch, loc);
		
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[@type='submit']"))).click();
		
		Thread.sleep(6000);
		
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//span[@class='select2-selection__arrow'])[1]"))).click();
		
		Thread.sleep(4000);
		
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//span[@class='select2-selection__arrow']//b[@role='presentation'])[2]"))).click();
		
		Thread.sleep(4000);
		
		try {
			WebElement pharmacy=
					wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//span[@class='select2-selection__arrow'])[3]")));
			pharmacy.sendKeys("PHARMACY");
			
			Actions pharm=new Actions(driver);
			
			pharm.moveToElement(pharmacy).keyDown(Keys.ARROW_DOWN).keyDown(Keys.ENTER).perform();
			
		} catch (Exception e) {
//			System.out.println(e);
		}
		
		
//		pharmacy.click();
		
		driver.findElement(By.id("button_300322")).click();
		
		
        
		Thread.sleep(4000);
		
		
		
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@data-accessname=\"medical_conditions\" and @data-value=\"yes\"]"))).click();
		
		Thread.sleep(3000);
		
		WebElement mc=
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//span[@class='select2-selection__arrow'])[1]")));
		
		mc.click();
		
		Thread.sleep(3000);
		
		Actions pain=new Actions(driver);
		
		pain.moveToElement(mc).keyDown(Keys.ARROW_DOWN).keyDown(Keys.ENTER).perform();
		
		Thread.sleep(4000);
		
		WebElement submit= wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[text()='+ Add']")));
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].click();", submit);

		
		
		
		
		driver.findElement(By.xpath("(//span[contains(.,'Continue')])[1]")).click();
		
		
		
		
		
		File sch1=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		
		File loc1=new File("C:\\Advanced MD regression testing screenshots\\Regression.jpeg");
		
		FileUtils.copyFile(sch1, loc1);
		
		
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//div[contains(.,'No')])[12]"))).click();
		
		driver.findElement(By.xpath("//div//span[text()='Yes, I want to proceed']")).click();
		
		Thread.sleep(5000);
		
		
		driver.findElement(By.xpath("(//div[contains(.,'No')])[12]")).click();
		
		driver.findElement(By.xpath("//div//span[text()='Yes, I want to proceed']")).click();
		
		
	Thread.sleep(6000);
	
	//Allergies//
	
	wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//div[contains(.,'Yes')])[12]"))).click();
	
	Thread.sleep(5000);

	WebElement allergies=wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//span//b[@role='presentation'])[1]")));
	
	allergies.click();
	
	Thread.sleep(5000);
	
	
	Actions ay=new Actions(driver);
	
	ay.moveToElement(allergies).keyDown(Keys.ARROW_DOWN).keyDown(Keys.ENTER).perform();
	
	
	
	Thread.sleep(5000);
	
	WebElement react=wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//span[@role='presentation'])[2]")));
	
	react.click();
	
	Actions r=new Actions(driver);
	
	r.moveToElement(react).keyDown(Keys.ARROW_DOWN).keyDown(Keys.ENTER).perform();
	
	Thread.sleep(4000);
	
	
	WebElement severity=wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//span[@role='presentation'])[3]")));
	
	severity.click();
	
    Actions sev=new Actions(driver);
	
	sev.moveToElement(severity).keyDown(Keys.ARROW_DOWN).keyDown(Keys.ENTER).perform();
	
	Thread.sleep(4000);
	
	WebElement add=
	
	wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[text()='+ Add']")));
	
	JavascriptExecutor je=(JavascriptExecutor) driver;
	je.executeScript("arguments[0].click()", add);
	
	Thread.sleep(3000);
	
	
	wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//span[contains(.,'Continue')])[1]"))).click();
	
	Thread.sleep(3000);
	
	// Past Medical History //
	
	wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@data-value='yes']"))).click();
	
	Thread.sleep(4000);
	
	WebElement all=
	wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[@role='presentation']")));
	Thread.sleep(3000);
	
	all.click();
	
	Thread.sleep(2000);
	
	Actions ab=new Actions(driver);
	
	ab.moveToElement(all).keyDown(Keys.ARROW_DOWN).keyDown(Keys.ENTER).perform();
	
	Thread.sleep(3000);
	
	WebElement all0=wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//span[@class='select2-selection__rendered'])[2]")));
	
	all0.click();
	
	
    Actions b=new Actions(driver);
	
	b.moveToElement(all0).keyDown(Keys.ARROW_DOWN).keyDown(Keys.ENTER).perform();
	
	Thread.sleep(4000);
	
	
	
	wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//SPAN[contains(text(),'+ Add')]"))).click();
	
	Thread.sleep(2000);
	
	wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//span[@class='hh-non-loader-text d-inline-flex'])[2]"))).click();
	
	Thread.sleep(3000);
	
	
	//medical
	
	
	//vaccines
	
	
	wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@data-value='yes']"))).click();
	
	Thread.sleep(2000);
	
	WebElement med=wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[@class='select2-selection select2-selection--single']")));
	
	med.click();
	
	Actions d=new Actions(driver);
	
	d.moveToElement(med).keyDown(Keys.ARROW_DOWN).keyDown(Keys.ENTER).perform();
	
	Thread.sleep(3000);
	

//	vaccines 
	
	
	WebElement add1=wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[text()='+ Add']")));
	
	add1.click();
	
	Thread.sleep(3000);
	
	wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[@class='common-btn px-5 d-inline-flex common-action-btn']"))).click();
	
	
	Thread.sleep(3000);
	
	wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@data-value='no']"))).click();
	
	Thread.sleep(7000);
	
	wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div//span[text()='Yes, I want to proceed']"))).click();
	
	Thread.sleep(4000);
	
	
	
	
	File schh1=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
	
	File loch1=new File("C:\\Advanced MD regression testing screenshots\\Regression.jpeg");
	
	FileUtils.copyFile(schh1, loch1);
	
	
	Thread.sleep(4000);
	
	wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@data-labelname='SSN']"))).sendKeys("111111111");
	
	wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@data-labelname='Phone Number']"))).sendKeys("9147528040");
	
	Thread.sleep(3000);
	
	wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//label[contains(text(),'I Agree')]"))).click();
	
	wait.until(ExpectedConditions.elementToBeClickable(By.id("button_300324"))).click();
	
	Thread.sleep(4000);
	
	wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//label[contains(text(),'I Agree')]"))).click();
	
	wait.until(ExpectedConditions.elementToBeClickable(By.id("button_300325"))).click();
	
	Thread.sleep(3000);
	
	WebElement signature=wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@id='ctlSignature_Container']")));
	
	Actions sign=new Actions(driver);
	
	sign.moveToElement(signature, 10, 10).clickAndHold().moveByOffset(50, 50).moveByOffset(100, 0).release().perform();
	
	Thread.sleep(3000);
	
	wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[@type='submit']"))).click();
	
	Thread.sleep(3000);
	
	wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[text()='Logout']"))).click();
	
	
    File schh9=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
	
	File loch9=new File("C:\\Advanced MD regression testing screenshots\\Regression.jpeg");
	
	FileUtils.copyFile(schh9, loch9);
	
	
	
	if(driver.getCurrentUrl().contains("https://yosi.health/")) {
		System.out.println("Regression successfull!");
	}else
		System.out.println("Regression failure!");
	
	}		
}
