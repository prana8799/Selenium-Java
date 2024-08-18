import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;

public class HerokuForgotPassword {

	public static void main(String[] args) throws InterruptedException {
	
		System.setProperty("Webdriver.gecko.driver", 
				"D:\\Selenium\\chromedriver-win64\\chromedriver.exe");
		
		WebDriver driver=new EdgeDriver();
		
		driver.get("https://the-internet.herokuapp.com/");
		
		driver.manage().window().maximize();
		
		driver.findElement(By.linkText("Forgot Password")).click();
		
		Thread.sleep(20000L);
		
		driver.findElement(By.xpath("//input[@id='email']"))
		                     .sendKeys("praneshheroku@yopmail.com");
		
		Thread.sleep(2000L);
		
		driver.findElement(By.xpath("//i[@class='icon-2x icon-signin']")).click();
	}

}
