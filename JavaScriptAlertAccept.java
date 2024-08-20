import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class JavaScriptAlert {

	public static void main(String[] args) throws InterruptedException {
		

		System.setProperty("Webdriver.chrome.driver", 
				"D:\\Selenium\\chromedriver-win64\\chromedriver.exe");
		
		WebDriver driver=new ChromeDriver();
		
		driver.get("https://the-internet.herokuapp.com/");
		
		driver.manage().window().maximize();
		
		driver.findElement(By.linkText("JavaScript Alerts")).click();
		
		Thread.sleep(2000L);
		
		driver.findElement(By.xpath("//button[@onclick='jsAlert()']")).click();
		
		Alert alert=driver.switchTo().alert();
		
		alert.accept();

	}

}
