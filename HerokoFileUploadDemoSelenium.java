import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class HerokoFileUpload {

	public static void main(String[] args) throws InterruptedException {
		
		System.setProperty("Webdriver.chrome.driver", 
				"D:\\Selenium\\chromedriver-win64\\chromedriver.exe");
		
		WebDriver driver=new ChromeDriver();
		
		driver.get("https://the-internet.herokuapp.com/");
		
		driver.manage().window().maximize();
		
		driver.findElement(By.xpath("//a[@href='/upload']")).click();
		
		Thread.sleep(3000L);
		
		driver.findElement(By.id("file-upload")).
		           sendKeys("D:\\Selenium Screenshots\\Golden Retriever.png");
		
		Thread.sleep(3000L);
		
		driver.findElement(By.xpath("//input[@id='file-submit']")).click();

	}

}
