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
		
		Actions actions=new Actions(driver);
		
//		actions.dragAndDrop(source, target).build().perform(); 
		
		actions.dragAndDrop(source, target).perform();
		
		driver.getCurrentUrl();
		
		System.out.println(driver.getCurrentUrl());
		
		if(driver.getCurrentUrl().contains("https://the-internet.herokuapp.com/drag_and_drop"))
		{
			System.out.println("Drag and Drop Action performed using Actions class");
		}else
			System.out.println("The Actions class failed");
	}

}
