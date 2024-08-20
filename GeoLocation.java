import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;

public class GeoLocation {

	public static void main(String[] args) throws InterruptedException {
		
		System.setProperty("Webdriver.gecko.driver", 
				"D:\\Selenium\\chromedriver-win64\\chromedriver.exe");
		
		WebDriver driver=new EdgeDriver();
		
		driver.get("https://the-internet.herokuapp.com/");
		
		driver.manage().window().maximize();
		
		driver.findElement(By.linkText("Geolocation")).click();
		
		Thread.sleep(3500L);
		
		driver.findElement(By.xpath("//button[@onclick='getLocation()']")).click();
		
		Thread.sleep(1500L);
		
		driver.findElement(By.linkText("See it on Google")).click();
		

	}

}
