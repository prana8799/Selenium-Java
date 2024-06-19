import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class HerokuAddRemove {

	public static void main(String[] args) throws InterruptedException {
		
		System.setProperty("Webdriver.chrome.driver", "D:\\Selenium\\chromedriver_win32\\chromedriver.exe");
		
		WebDriver driver=new ChromeDriver();
		
		driver.get("https://the-internet.herokuapp.com/");
		
		driver.manage().window().maximize();
		
		Thread.sleep(2000L);
		
		driver.findElement(By.linkText("Add/Remove Elements")).click();
		
		Thread.sleep(2000L);
		
		driver.findElement(By.xpath("//button[@onclick='addElement()']")).click();
		
		Thread.sleep(2000L);
		
		driver.findElement(By.xpath("//button[@class='added-manually']")).click();
		
		Thread.sleep(2000L);
		
		driver.findElement(By.xpath("//button[@onclick='addElement()']")).click();
		
		Thread.sleep(2000L);
		
		driver.findElement(By.xpath("//button[@class='added-manually']")).click();
		
		Thread.sleep(2000L);
		
		driver.getCurrentUrl();
		
		System.out.println(driver.getCurrentUrl());
		
		driver.getTitle();
		
		System.out.println(driver.getTitle());
	}

}
