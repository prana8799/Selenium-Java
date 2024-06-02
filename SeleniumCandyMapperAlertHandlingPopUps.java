import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class CandyMapper {

	public static void main(String[] args) throws InterruptedException {
	
		System.setProperty("Webdriver.chrome.driver", "D:\\Selenium\\chromedriver_win32\\chromedriver.exe");
		
		WebDriver driver=new ChromeDriver();
		
		driver.get("https://candymapper.com/");
		
		driver.manage().window().maximize();
		
		Thread.sleep(2000L);
		
		WebElement popupclose=driver.findElement(By.cssSelector("#popup-widget111379-close-icon"));
		
		popupclose.click();
		 
		Thread.sleep(2000L);
		
		Alert alert=driver.switchTo().alert();
		
		alert.dismiss();

}

}
