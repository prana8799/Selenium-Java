import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class HerokuDragAndDrop {

	public static void main(String[] args) throws InterruptedException {
		
		System.setProperty("Webdriver.chrome.driver", 
				"D:\\Selenium\\chromedriver-win64\\chromedriver.exe");
		
		WebDriver driver=new ChromeDriver();
		
		driver.get("https://the-internet.herokuapp.com/");
		
		driver.manage().window().maximize();
		
		driver.findElement(By.linkText("Drag and Drop")).click();
		
		Thread.sleep(3000L);
		
		WebElement source= driver.findElement(By.id("column-a"));
		
		WebElement target= driver.findElement(By.id("column-b"));
		
		Actions action=new Actions(driver);
		
		action.dragAndDrop(source, target).build().perform();
	}

}
