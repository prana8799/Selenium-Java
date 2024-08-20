import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class BrokenImage {

	public static void main(String[] args) throws InterruptedException {
		
		System.setProperty("Webdriver.chrome.driver", 
				"D:\\Selenium\\chromedriver-win64\\chromedriver.exe");
		
		WebDriver driver=new ChromeDriver();
		
		driver.get("https://the-internet.herokuapp.com");
		
		driver.manage().window().maximize();
		
		driver.findElement(By.partialLinkText("Broken")).click();
		
		Thread.sleep(4000L);
		
		List<WebElement> images=driver.findElements(By.tagName("img"));
		
		for(WebElement im:images) {
			String src=im.getAttribute("src");
			if(src.isEmpty()||src==null) {
				System.out.println("The broken image is:"+im);
			}
		}
		
	}

}
