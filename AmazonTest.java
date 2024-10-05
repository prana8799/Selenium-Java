package automation_testing;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class Amazon {

	public static void main(String[] args) throws InterruptedException {
		
		System.setProperty("Webdriver.gecko.driver", 
				"C:\\Selenium\\chromedriver-win64\\chromedriver.exe");
		
		WebDriver driver=new EdgeDriver();
		
		WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(10));
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		
		driver.get("https://www.amazon.in/");
		
		driver.manage().window().maximize();
		
		Thread.sleep(2000);
		
		WebElement categories=driver.findElement(By.xpath("//select[@id='searchDropdownBox']"));
		Select category=new Select(categories);
		category.selectByIndex(7);
		
		System.out.println(category.getFirstSelectedOption().getText());
		
		WebElement searchbox=wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("twotabsearchtextbox")));
		searchbox.sendKeys("Games");
		searchbox.sendKeys(Keys.ENTER);
		
		Thread.sleep(2000);
		
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//a[@data-type='productTitle'])[1]"))).click();
		
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//*[@class='a-button-text a-declarative'][1])[1]"))).click();
		driver.findElement(By.id("quantity_3")).click();
		
		Thread.sleep(1000);
		
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id='add-to-cart-button']"))).click();
		
		driver.findElement(By.linkText("Go to Cart")).click();
		
		driver.findElement(By.cssSelector("#sc-buy-box-gift-checkbox")).click();
		
		Thread.sleep(2000);
		
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@class='icp-nav-flag icp-nav-flag-in icp-nav-flag-lop']"))).click();
		
		driver.findElement(By.xpath("(//i[@class='a-icon a-icon-radio'])[3]")).click();
		
		Thread.sleep(4000);
		
		driver.navigate().refresh();
		
		driver.findElement(By.xpath("//*[@class='a-button-input']")).click();
		
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//*[@class='nav-line-2'])[3]"))).click();
		Thread.sleep(3000);
    	driver.findElement(By.xpath("//*[@value='Delete']")).click();		
    	
    	wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//i[@class='hm-icon nav-sprite']"))).click();
    	
    	wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[@data-menu-id='11']"))).click();
    	
    	Thread.sleep(1000);
    	
    	driver.findElement(By.xpath("(//a[text()='Fashion Sandals'])[2]")).click();
    	
    	driver.findElement(By.xpath("(//*[@class='a-size-base a-color-base'][1])[1]")).click();
    	System.out.println(driver.getTitle());
    	
    	
    	wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@value='3']"))).click();
    	
//    	driver.findElement(By.xpath("((//i[@class='a-icon a-icon-checkbox'])[1]")).click();
//    	
//    	Assert.assertTrue(driver.findElement(By.xpath("((//i[@class='a-icon a-icon-checkbox'])[1]")).isSelected());
//    	
    	
    	
    	

		
		
		
		
//		driver.close();
		
		
		
		
		

	}

}
