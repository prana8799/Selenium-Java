import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class HerokuCheckBox {

	public static void main(String[] args) throws InterruptedException {
		
		System.setProperty("Webdriver.chrome.driver", 
				"D:\\Selenium\\chromedriver_win32\\chromedriver.exe");
		
		WebDriver driver=new ChromeDriver();
		
		driver.get("https://the-internet.herokuapp.com/");
		
		Thread.sleep(2000L);
		
		driver.findElement(By.linkText("Checkboxes")).click();
		
		Thread.sleep(2000L);
		
		driver.findElement(By.xpath("//*[@id=\"checkboxes\"]/input[2]"))
		                       .click();
		
		Thread.sleep(2000L);
		
		driver.findElement(By.xpath("//*[@id=\"checkboxes\"]/input[1]"))
		                   .click();
		
		driver.getCurrentUrl();
		
		System.out.println(driver.getCurrentUrl());

		
	}

}
