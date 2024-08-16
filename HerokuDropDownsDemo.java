import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.support.ui.Select;

public class HerokuDropDowns {

	public static void main(String[] args) throws InterruptedException {
		
		System.setProperty("Webdriver.gecko.driver", 
				"D:\\Selenium\\chromedriver-win64\\chromedriver.exe");
		
		WebDriver driver=new EdgeDriver();
		
		driver.get("https://the-internet.herokuapp.com/");
		
		driver.manage().window().maximize();
		
		driver.findElement(By.linkText("Dropdown")).click();
		
		Thread.sleep(3000L);
		
		WebElement dropdown=driver.findElement(By.xpath("//select[@id='dropdown']"));
		
		Select sdd=new Select(dropdown);
		
//		sdd.selectByIndex(2);
		
//		sdd.selectByIndex(0);
		
//		sdd.selectByIndex(1);
		
		sdd.selectByVisibleText("Option 1");
		
//		sdd.selectByValue(" ");
	
		System.out.println(sdd.getFirstSelectedOption().getText());
		
		
	}

}
