package automation.selenium.java;
import java.time.Duration;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
public class T1 {
	public static void main(String[] args) throws InterruptedException {
	
		System.setProperty("Webdriver.chrome.driver", "C:\\Selenium\\chromedriver-win64\\chromedriver.exe");
		
		WebDriver driver=new ChromeDriver();
		
WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(7));
driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(8));
		
		driver.get("https://preprodinternal.yosicare.com/onboard/index.php");
		
		driver.manage().window().maximize();
		
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("username"))).sendKeys("praneshbalamurugan.m@yosicare.com");
		
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@type='password']"))).sendKeys("Yosi1234$");
		
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[@class='btn btn-success btn-sm login_btn']"))).click();
		
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//h3[text()='ONBOARD NEW PRACTICE']"))).click();
		
		 driver.navigate().to("https://preprodinternal.yosicare.com/onboard/excel/file_upload.php");
         driver.findElement(By.xpath("//input[@name='image' and @type='file']")).
               sendKeys("C:\\Onboarding\\999807.xls");
	driver.findElement(By.xpath("//input[@class='submit' and @type='submit']")).click();
	
	Thread.sleep(2000);
	driver.navigate().back();
	driver.navigate().back();
	
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("new_customer_email"))).sendKeys("999807qa@yopmail.com");
		
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("new_customer_name"))).sendKeys("MEG");
		
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("first_name"))).sendKeys("MEGAN");
		
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("last_name"))).sendKeys("TESTPATIENT");
		
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("new_customer_mobile"))).sendKeys("9147528040");
		
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("new_customer_passowrd"))).sendKeys("Yosi1234$");
		
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@class='form-control' and @name='practice_friendly_name']"))).sendKeys("San Andreas");
		
		
		WebElement emrtype=driver.findElement(By.id("emr_type"));
		Select emr=new Select(emrtype);
		emr.selectByIndex(1);
//		emr.selectByVisibleText("Elation");
		System.out.println(emr.getFirstSelectedOption().getText());
		
     WebElement date=wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@class='form-control complete_date']")));
         date.clear();
         date.sendKeys("10-01-2024");
//wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[1]//input[@value='Y']"))).click();
wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//input[@value='Y'and @name='survey_option']"))).click();
wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//input[@value='Y'and @name='ondemand_form']"))).click();
wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//input[@value='Y'and @name='privia_customer']"))).click();
WebElement practiceid=
wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[1]//div[@class='bootstrap-tagsinput']//input[@type='text']")));
practiceid.sendKeys("999807");
practiceid.sendKeys(Keys.ENTER);
System.out.println(driver.getCurrentUrl());
System.out.println(driver.getTitle());
Thread.sleep(2000);
driver.findElement(By.xpath("//input[@name='practice_name[]']")).sendKeys("PRANA1 HOSPITAL");
driver.findElement(By.xpath("//input[@name='practice_logo_999807']")).sendKeys("C:\\Onboarding\\YosiImage.jpg");
driver.findElement(By.xpath("//*[@name='bandwidth_app_id[]']")).sendKeys("1");
driver.findElement(By.xpath("//*[@name='bandwidth_from_no[]']")).sendKeys("1");
driver.findElement(By.xpath("//*[@name='emr_practice_id[]']")).sendKeys("1959031");
		driver.findElement(By.xpath("//*[@name='emr_department_id[]']")).sendKeys("1");
		driver.findElement(By.xpath("//*[@name='emr_form_id[]']")).sendKeys("3561");
		
		
//		driver.findElement(By.id("onboard_submit")).click();
		
	}
}
