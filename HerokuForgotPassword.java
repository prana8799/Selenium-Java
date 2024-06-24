import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class HerokuForgotPassword {

	public static void main(String[] args) throws InterruptedException {
		
		
		System.setProperty("Webdriver.chrome.driver", 
				"D:\\Selenium\\chromedriver_win32\\chromedriver.exe");
		
		WebDriver driver=new ChromeDriver();
		
		driver.get("https://the-internet.herokuapp.com/");
		
		driver.manage().window().maximize();
		
		driver.findElement(By.linkText("Forgot Password")).click();
		
		Thread.sleep(2000L);
		
		driver.findElement(By.xpath("//input[@name='email']"))
		                  .sendKeys("praneshbalamurugan9976@gmail.com");
		
		Thread.sleep(2000L);
		
		driver.findElement(By.id("form_submit")).click();
		
		if(driver.getCurrentUrl().contains("https://the-internet.herokuapp.com/forgot_password")) {
			System.out.println("Success");
		}
		else
			System.out.println("Failed");
		
	}

}
