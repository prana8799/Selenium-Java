package automation.selenium.java;

import java.time.Duration;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class FeaturesLive {

	
		

	    WebDriver driver;
	    WebDriverWait wait;

	    @BeforeMethod
	    public void driverSetup() {
	        driver = new ChromeDriver();
	        driver.manage().window().maximize();
	        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	        wait = new WebDriverWait(driver, Duration.ofSeconds(60));
	    }
	    
	    @Test
	    public void features() {
	    	
	    	driver.get("https://internalnew.yosicare.com/onboard/index.php");
	        
	        driver.findElement(By.xpath("//*[@id='username']")).sendKeys("abirami.s@yosicare.com");
	        driver.findElement(By.xpath("//*[@id='password']")).sendKeys("Yosi1234$");
	        driver.findElement(By.xpath("//button[contains(.,' Login ')]")).click();
	        
	        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[text()='MODIFY EXISTING PRACTICE']"))).click();
	        
	        WebElement practiceid = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='search_practice']")));
	        practiceid.click();

	        Actions ac = new Actions(driver);
	        ac.moveToElement(practiceid)
	          .sendKeys("349301").pause(2000)
	          .keyDown(Keys.ARROW_DOWN)  
	          .sendKeys(Keys.ENTER)      
	          .perform();
	        
	       
	        
	        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[contains(.,'Features')]"))).click();     
	        
	        String mainWindowHandle = driver.getWindowHandle();
	        
	        
Set<String> allWindowHandles = driver.getWindowHandles();
String newWindowHandle = "new window";

for(String handle : allWindowHandles) {
    if(!handle.equals(mainWindowHandle)) {
        newWindowHandle = handle;
        driver.switchTo().window(handle);
        break;
    }
}

WebElement invpat=driver.findElement(By.xpath("//*[@name='invite_patient_flag' and @value='Y']"));

if(invpat.isSelected()) {
	System.out.println("\n \n Single Invitation enabled");
}else
	System.out.println("\n \n Single Invitation not enabled");


if(driver.findElement(By.xpath("//*[@name='reputation_management_flag' and @value='Y']")).isSelected()) {
	System.out.println("\n \n Survey enabled");
}else
	System.out.println("\n \n Survey not enabled");


if(driver.findElement(By.xpath("//*[@name='enhanced_scheduling' and @value='Y']")).isSelected()) {
	System.out.println("\n \n Enhanced Scheduling enabled");
}else
	System.out.println("\n \n Enhanced Scheduling not enabled");


if(driver.findElement(By.xpath("//*[@name='self_scheduling_flag' and @value='Y']")).isSelected()) {
	System.out.println("\n \n Old Scheduling enabled");
}else
	System.out.println("\n \n Old Scheduling not enabled");


if(driver.findElement(By.xpath("//*[@name='two_way_communication_for_scheduled_patients' and @value='Y']")).isSelected()) {
	System.out.println("\n \n Two way communication version 1 enabled");
}else
	System.out.println("\n \n Two way communication version 1 not enabled");


if(driver.findElement(By.xpath("//*[@name='show_two_way_chats_only_for_selected_practice' and @value='Y']")).isSelected()) {
	System.out.println("\n \n Show two way chats for only selected patients enabled");
}else
	System.out.println("\n \n Show two way chats for only selected patients not enabled");

if(driver.findElement(By.xpath("//*[@name='dashboard_two_way_communication_v2' and @value='Y']")).isSelected()) {
	System.out.println("\n \n Two way communication version 2 enabled");
}else
	System.out.println("\n \n Two way communication version 2 not enabled");


if(driver.findElement(By.xpath("//*[@name='yosichat_bulk_messaging' and @value='Y']")).isSelected()) {
	System.out.println("\n \n Yosi broadcast messaging enabled");
}else
	System.out.println("\n \n Yosi broadcast messaging not enabled");


if(driver.findElement(By.xpath("//*[@name='hpi_new_functionality_flag' and @value='Y']")).isSelected()) {
	System.out.println("\n \n HPI ROS flag enabled");
}else
	System.out.println("\n \n HPI ROS flag not enabled");

if(driver.findElement(By.xpath("//*[@name='ondemand_form' and @value='Y']")).isSelected()) {
	System.out.println("\n \n On demand form enabled");
}else
	System.out.println("\n \n On demand form not displayed");

	


	}
	    
	    
	    @AfterMethod
	    public void driverClose() {
	        driver.quit();
	    }

}
