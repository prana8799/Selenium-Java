package automation_testing;

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

public class AbhiBus {

	public static void main(String[] args) throws InterruptedException {
		WebDriver driver=new ChromeDriver();
		
		WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(30));
		
		driver.manage().window().maximize();
	
		{
			
			driver.get("https://www.abhibus.com/");
			
			Actions ac=new Actions(driver);
			
		WebElement origin=wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@placeholder=\"Leaving From\"]")));
		origin.click();
		
		ac.sendKeys("Coimbatore").pause(4000).
		sendKeys(Keys.ENTER).perform();
		
			
		WebElement destination=wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@placeholder=\"Going To\"]")));
			destination.click();	
		
		
		ac.sendKeys("Chennai").pause(4000).
		sendKeys(Keys.ENTER).perform();
			
			wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//a[text()='Tomorrow']"))).click();
			
			wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//span[text()='Search']"))).click();
			
			Thread.sleep(2000);
			
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[text()='AC' and 'Sleeper']"))).click();
			
			driver.findElement(By.xpath("//span[text()='After 11 PM']")).click();
			
			driver.findElement(By.xpath("//span[(text()='Bus Partner')]")).click();
			
			driver.findElement(By.xpath("//label[text()='NATIONAL TRAVELS (CHN)']")).click();
			
			driver.findElement(By.xpath("//span[text()='Boarding Point']")).click();
			
			WebElement boarding=driver.findElement(By.xpath("//*[@placeholder=\"Search here\"]"));
			
			boarding.click();
			boarding.sendKeys("Hopes");
			
			wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//label[contains(.,'Hopes College')]"))).click();
			
			driver.findElement(By.xpath("//*[text()='Dropping Point']")).click();
			
			driver.findElement(By.xpath("//input[@placeholder=\"Search here\"]")).sendKeys("Vandalur");
			
			driver.findElement(By.xpath("//*[text()='Vandalur']")).click();
			
			JavascriptExecutor js = (JavascriptExecutor) driver;

			
			WebElement seats = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[text()='Select Seats']")));

			js.executeScript("arguments[0].click();", seats);

			
			
			
			
		}

	}

}
