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
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import dev.failsafe.internal.util.Assert;
import io.github.bonigarcia.wdm.WebDriverManager;

public class PracticeSettings {

     WebDriver driver;
     WebDriverWait wait;
    
    

    @BeforeMethod
    public void setUp() {
		System.setProperty("Webdriver.chrome.driver", "C:\\Selenium\\chromedriver-win64\\chromedriver.exe");
        driver = new ChromeDriver();
        wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
        driver.manage().window().maximize();
    }
    @Test
    public void Practice() throws InterruptedException {
    	
    	 driver.get("https://preprodinternal.yosicare.com/page-cms/");
	     	     
	     driver.findElement(By.xpath("(//input[@placeholder=\"Email Address\"])[1]")).sendKeys("praneshbalamurugan.m@yosicare.com");
	     
	     driver.findElement(By.xpath("//*[@placeholder='Enter Password']")).sendKeys("Yosi@12345");
	     
	     driver.findElement(By.xpath("//*[text()='Log in']")).click();
	     
	     Thread.sleep(4000);
	     
	     WebElement prac=driver.findElement(By.xpath("//*[@placeholder='Search and select department']"));
	     
	     prac.sendKeys("777801");
	     prac.click();
	     
	     
	     Actions actions=new Actions(driver);
	     
	     actions.moveToElement(prac).keyDown(Keys.ARROW_DOWN).keyDown(Keys.ENTER).perform();
	     
	     Thread.sleep(2000);
	     
	     wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[text()='Switch to classic view']"))).click();
	     
	     driver.findElement(By.xpath("//a[text()='Practice settings']")).click();
	     
	     WebElement emrtype=driver.findElement(By.xpath("//select[@data-fieldname=\"EMR Type\"]"));
	     
	     if(emrtype.getText().contains("Athena")) {
	    	 System.out.println("Athena EMR Selected");
	     }else
	    	 System.out.println("Other EMR Selected");
	     
	     
	     WebElement spanish=driver.findElement(By.xpath("(//div[@class='toggle btn btn-primary'])[1]"));
	     
	     if(spanish.isEnabled()) {
	    	 System.out.println("Spanish enabled");
	     }else
	    	 System.out.println("Spanish disabled");
	     
	     
	     WebElement payments=driver.findElement(By.xpath("(//div[@class=\"toggle-group\"])[2]"));
	     
	     if(payments.isEnabled()) {
	    	 System.out.println("Payments enabled");
	     }else
	    	 System.out.println("Spanish disabled");
	     
	     
	     WebElement insurancetype=driver.findElement(By.xpath("//span[text()=\"Primary\"]"));
	     
	     if(insurancetype.isDisplayed()) {
	    	 System.out.println("Primary Insurance Selected");
	     }else
	    	 System.out.println("1st Insurance Selected");
	     
	     
	     WebElement race=driver.findElement(By.xpath("(//span[text()=\"Emr\"])[1]"));
	     
	     if(race.getText().contains("Emr")) {
	    	 System.out.println("Race source selected from EMR");
	     }else
	    	 System.out.println("Race source selected from Practice");
	     
	     
	     WebElement ethnicity=driver.findElement(By.xpath("(//span[text()=\"Emr\"])[2]"));
	     
	     if(ethnicity.getText().contains("Emr")) {
	    	 System.out.println("Ethnicity source selected from EMR");
	     }else
	    	 System.out.println("Ethnicity source selected from Practice");
	     
	     
	     WebElement appid=driver.findElement(By.xpath("//span[text()='Appointment Type Name']"));
	     
	     if(appid.isDisplayed()) {
	    	 System.out.println("Appointment Type Name was selected");
	     }
	     
	     
	     WebElement timeout=driver.findElement(By.xpath("//select[@name='practice_settings[session_timeout][setting_value]']"));
	     
	     Select st=new Select(timeout);
	     
	     st.getFirstSelectedOption().getText();
	     
	     System.out.println(st.getFirstSelectedOption().getText());
	     
	     WebElement walkin=driver.findElement(By.xpath("//label[text()='Enable Walk-in Patient ']/following-sibling::div"));
	     
	    if(walkin.isEnabled()) {
	    	System.out.println("Walkin enabled");
	    }else
	    	System.out.println("Walkin not enabled");
	    
	    WebElement sunday=driver.findElement(By.xpath("//input[@value='23' and @type='checkbox']"));
	    
	    if(sunday.isSelected()) {
	    	System.out.println("Sunday");
	    }else
	    	System.out.println("No Sunday");

	    
 WebElement monday=driver.findElement(By.xpath("//input[@value='24' and @type='checkbox']"));
	    
	    if(monday.isSelected()) {
	    	System.out.println("Monday");
	    }else
	    	System.out.println("No Monday");
	    
	    
	    WebElement tuesday=driver.findElement(By.xpath("//input[@value='25' and @type='checkbox']"));
	    
	    if(tuesday.isSelected()) {
	    	System.out.println("Tuesday");
	    }else
	    	System.out.println("No Tuesday");
	    
 WebElement wednesday=driver.findElement(By.xpath("//input[@value='26' and @type='checkbox']"));
	    
	    if(wednesday.isSelected()) {
	    	System.out.println("Wednesday");
	    }else
	    	System.out.println("No Wednesday");
	    
 WebElement thursday=driver.findElement(By.xpath("//input[@value='27' and @type='checkbox']"));
	    
	    if(thursday.isSelected()) {
	    	System.out.println("Thursday");
	    }else
	    	System.out.println("No Thursday");
	    
	    
WebElement friday=driver.findElement(By.xpath("//input[@value='28' and @type='checkbox']"));
	    
	    if(friday.isSelected()) {
	    	System.out.println("Friday");
	    }else
	    	System.out.println("No Friday");
	    
	    WebElement saturday=driver.findElement(By.xpath("//input[@value='29' and @type='checkbox']"));
	    
	    if(saturday.isSelected()) {
	    	System.out.println("Saturday");
	    }else
	    	System.out.println("No Saturday");
	    
	    
	    WebElement fetch=driver.findElement(By.xpath("(//select[@data-fieldname='Appointment fetch timing'])[1]"));
	    
	    Select fet=new Select(fetch);
	    
	    fet.getFirstSelectedOption();
	    
	    System.out.println(fet.getFirstSelectedOption().getText());
	    	    
	    WebElement sec=wait.until(ExpectedConditions.elementToBeClickable
	    		(By.xpath("(//span[@class='select2-selection select2-selection--single']/span[@class='select2-selection__rendered'])[10]")));
	    
	    
	    String s=sec.getText();
	    
	    System.out.println(s);
	    
	    WebElement l=wait.until(ExpectedConditions.elementToBeClickable
   		(By.xpath("(//span[contains(@title, 'AM') or contains(@title, 'PM')])[1]")));
	    
    String ll=l.getText();
    
    System.out.println(ll);	    
	    System.out.println("Appointment fetching time from:"+ " "+fet.getFirstSelectedOption().getText()+":"+ s + " "+ ll);
	    
	    
	    
 
//	    WebElement to=driver.findElement(By.xpath("//span[@id='select2-setting_value_23_HHTO-container']"));
//	    
//	    String t=to.getText();
//	    
//	    WebElement mi=driver.findElement(By.xpath("//span[@id='select2-setting_value_23_MMTO-container']"));
//	    
//	    String m=mi.getText();
//	    
//	    WebElement xi=driver.findElement(By.xpath("//span[@id=\"select2-setting_value_23_AMPMTO-container\"]"));
//	    
//	    String x=xi.getText();
//	    
//	    System.out.println("To:"+t+ " "+m+" "+x);
//	    
	   
	    
	    
	    
    }
    
    
   

    
    
    
    
	    
	    @AfterMethod
	    public void executionCompleted() {
	     driver.close();
	      
	      }
	
}
	
	     

